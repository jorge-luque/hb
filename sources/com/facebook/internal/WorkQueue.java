package com.facebook.internal;

import com.facebook.FacebookSdk;
import java.util.concurrent.Executor;

public class WorkQueue {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final int DEFAULT_MAX_CONCURRENT = 8;
    private final Executor executor;
    private final int maxConcurrent;
    /* access modifiers changed from: private */
    public WorkNode pendingJobs;
    private int runningCount;
    private WorkNode runningJobs;
    /* access modifiers changed from: private */
    public final Object workLock;

    public interface WorkItem {
        boolean cancel();

        boolean isRunning();

        void moveToFront();
    }

    private class WorkNode implements WorkItem {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private final Runnable callback;
        private boolean isRunning;
        private WorkNode next;
        private WorkNode prev;

        WorkNode(Runnable runnable) {
            this.callback = runnable;
        }

        /* access modifiers changed from: package-private */
        public WorkNode addToList(WorkNode workNode, boolean z) {
            if (workNode == null) {
                this.prev = this;
                this.next = this;
                workNode = this;
            } else {
                this.next = workNode;
                WorkNode workNode2 = workNode.prev;
                this.prev = workNode2;
                workNode2.next = this;
                workNode.prev = this;
            }
            return z ? this : workNode;
        }

        public boolean cancel() {
            synchronized (WorkQueue.this.workLock) {
                if (isRunning()) {
                    return false;
                }
                WorkNode unused = WorkQueue.this.pendingJobs = removeFromList(WorkQueue.this.pendingJobs);
                return true;
            }
        }

        /* access modifiers changed from: package-private */
        public Runnable getCallback() {
            return this.callback;
        }

        /* access modifiers changed from: package-private */
        public WorkNode getNext() {
            return this.next;
        }

        public boolean isRunning() {
            return this.isRunning;
        }

        public void moveToFront() {
            synchronized (WorkQueue.this.workLock) {
                if (!isRunning()) {
                    WorkNode unused = WorkQueue.this.pendingJobs = removeFromList(WorkQueue.this.pendingJobs);
                    WorkNode unused2 = WorkQueue.this.pendingJobs = addToList(WorkQueue.this.pendingJobs, true);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public WorkNode removeFromList(WorkNode workNode) {
            if (workNode == this && (workNode = this.next) == this) {
                workNode = null;
            }
            WorkNode workNode2 = this.next;
            workNode2.prev = this.prev;
            this.prev.next = workNode2;
            this.prev = null;
            this.next = null;
            return workNode;
        }

        /* access modifiers changed from: package-private */
        public void setIsRunning(boolean z) {
            this.isRunning = z;
        }

        /* access modifiers changed from: package-private */
        public void verify(boolean z) {
        }
    }

    public WorkQueue() {
        this(8);
    }

    private void execute(final WorkNode workNode) {
        this.executor.execute(new Runnable() {
            public void run() {
                try {
                    workNode.getCallback().run();
                } finally {
                    WorkQueue.this.finishItemAndStartNew(workNode);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public void finishItemAndStartNew(WorkNode workNode) {
        WorkNode workNode2;
        synchronized (this.workLock) {
            if (workNode != null) {
                this.runningJobs = workNode.removeFromList(this.runningJobs);
                this.runningCount--;
            }
            if (this.runningCount < this.maxConcurrent) {
                workNode2 = this.pendingJobs;
                if (workNode2 != null) {
                    this.pendingJobs = workNode2.removeFromList(this.pendingJobs);
                    this.runningJobs = workNode2.addToList(this.runningJobs, false);
                    this.runningCount++;
                    workNode2.setIsRunning(true);
                }
            } else {
                workNode2 = null;
            }
        }
        if (workNode2 != null) {
            execute(workNode2);
        }
    }

    private void startItem() {
        finishItemAndStartNew((WorkNode) null);
    }

    public WorkItem addActiveWorkItem(Runnable runnable) {
        return addActiveWorkItem(runnable, true);
    }

    public void validate() {
        synchronized (this.workLock) {
            if (this.runningJobs != null) {
                WorkNode workNode = this.runningJobs;
                do {
                    workNode.verify(true);
                    workNode = workNode.getNext();
                } while (workNode != this.runningJobs);
            }
        }
    }

    public WorkQueue(int i) {
        this(i, FacebookSdk.getExecutor());
    }

    public WorkItem addActiveWorkItem(Runnable runnable, boolean z) {
        WorkNode workNode = new WorkNode(runnable);
        synchronized (this.workLock) {
            this.pendingJobs = workNode.addToList(this.pendingJobs, z);
        }
        startItem();
        return workNode;
    }

    public WorkQueue(int i, Executor executor2) {
        this.workLock = new Object();
        this.runningJobs = null;
        this.runningCount = 0;
        this.maxConcurrent = i;
        this.executor = executor2;
    }
}
