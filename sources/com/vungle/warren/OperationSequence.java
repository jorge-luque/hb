package com.vungle.warren;

import com.vungle.warren.AdLoader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.concurrent.atomic.AtomicInteger;

class OperationSequence {
    private Callback callback;
    private String currentId = null;
    private Map<String, AdLoader.Operation> loadOperations;
    private final PriorityQueue<Entry> queue = new PriorityQueue<>(11, new Comparator<Entry>() {
        public int compare(Entry entry, Entry entry2) {
            int compareTo = Integer.valueOf(entry.operation.priority).compareTo(Integer.valueOf(entry2.operation.priority));
            return compareTo == 0 ? Integer.valueOf(entry.order).compareTo(Integer.valueOf(entry2.order)) : compareTo;
        }
    });

    interface Callback {
        void onChangePriority(AdLoader.Operation operation);

        void onLoadNext(AdLoader.Operation operation);
    }

    private static class Entry {
        private static final AtomicInteger seq = new AtomicInteger();
        AdLoader.Operation operation;
        /* access modifiers changed from: private */
        public final int order = seq.incrementAndGet();

        Entry(AdLoader.Operation operation2) {
            this.operation = operation2;
        }
    }

    OperationSequence() {
    }

    private Entry get(String str) {
        Iterator<Entry> it = this.queue.iterator();
        while (it.hasNext()) {
            Entry next = it.next();
            if (next.operation.f14484id.equals(str)) {
                return next;
            }
        }
        return null;
    }

    public synchronized boolean contains(String str) {
        return get(str) != null;
    }

    public void init(Callback callback2, Map<String, AdLoader.Operation> map) {
        this.callback = callback2;
        this.loadOperations = map;
    }

    /* access modifiers changed from: package-private */
    public synchronized void offer(AdLoader.Operation operation) {
        AdLoader.Operation operation2 = this.loadOperations.get(operation.f14484id);
        if (operation2 != null) {
            int i = operation2.priority;
            operation2.merge(operation);
            if (operation2.priority < i) {
                this.callback.onChangePriority(operation2);
            }
        } else {
            Entry entry = get(operation.f14484id);
            if (entry != null) {
                this.queue.remove(entry);
                entry.operation.merge(operation);
                operation = entry.operation;
            }
            if (operation.priority <= 0) {
                this.callback.onLoadNext(operation);
            } else {
                PriorityQueue<Entry> priorityQueue = this.queue;
                if (entry == null) {
                    entry = new Entry(operation);
                }
                priorityQueue.offer(entry);
                reportFinished((String) null);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public synchronized List<AdLoader.Operation> removeAll() {
        ArrayList arrayList;
        this.currentId = null;
        arrayList = new ArrayList();
        while (!this.queue.isEmpty()) {
            Entry poll = this.queue.poll();
            if (poll != null) {
                arrayList.add(poll.operation);
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: package-private */
    public synchronized void reportFinished(String str) {
        if (this.currentId == null || this.currentId.equals(str)) {
            this.currentId = null;
            Entry poll = this.queue.poll();
            if (poll != null) {
                this.currentId = poll.operation.f14484id;
                this.callback.onLoadNext(poll.operation);
            }
        }
    }
}
