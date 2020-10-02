package androidx.loader.p026b;

import android.content.Context;
import android.os.Handler;
import android.os.SystemClock;
import androidx.core.p019e.C0796i;
import androidx.core.p022os.OperationCanceledException;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;

/* renamed from: androidx.loader.b.a */
/* compiled from: AsyncTaskLoader */
public abstract class C0995a<D> extends C0997b<D> {
    static final boolean DEBUG = false;
    static final String TAG = "AsyncTaskLoader";
    volatile C0995a<D>.C0000a mCancellingTask;
    private final Executor mExecutor;
    Handler mHandler;
    long mLastLoadCompleteTime;
    volatile C0995a<D>.C0000a mTask;
    long mUpdateThrottle;

    /* renamed from: androidx.loader.b.a$a */
    /* compiled from: AsyncTaskLoader */
    final class C0996a extends C1000c<Void, Void, D> implements Runnable {

        /* renamed from: j */
        private final CountDownLatch f2554j = new CountDownLatch(1);

        /* renamed from: k */
        boolean f2555k;

        C0996a() {
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public void mo5061b(D d) {
            try {
                C0995a.this.dispatchOnCancelled(this, d);
            } finally {
                this.f2554j.countDown();
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: c */
        public void mo5062c(D d) {
            try {
                C0995a.this.dispatchOnLoadComplete(this, d);
            } finally {
                this.f2554j.countDown();
            }
        }

        /* renamed from: d */
        public void mo5063d() {
            try {
                this.f2554j.await();
            } catch (InterruptedException unused) {
            }
        }

        public void run() {
            this.f2555k = false;
            C0995a.this.executePendingTask();
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public D mo5059a(Void... voidArr) {
            try {
                return C0995a.this.onLoadInBackground();
            } catch (OperationCanceledException e) {
                if (mo5095a()) {
                    return null;
                }
                throw e;
            }
        }
    }

    public C0995a(Context context) {
        this(context, C1000c.f2559h);
    }

    public void cancelLoadInBackground() {
    }

    /* access modifiers changed from: package-private */
    public void dispatchOnCancelled(C0995a<D>.C0000a aVar, D d) {
        onCanceled(d);
        if (this.mCancellingTask == aVar) {
            rollbackContentChanged();
            this.mLastLoadCompleteTime = SystemClock.uptimeMillis();
            this.mCancellingTask = null;
            deliverCancellation();
            executePendingTask();
        }
    }

    /* access modifiers changed from: package-private */
    public void dispatchOnLoadComplete(C0995a<D>.C0000a aVar, D d) {
        if (this.mTask != aVar) {
            dispatchOnCancelled(aVar, d);
        } else if (isAbandoned()) {
            onCanceled(d);
        } else {
            commitContentChanged();
            this.mLastLoadCompleteTime = SystemClock.uptimeMillis();
            this.mTask = null;
            deliverResult(d);
        }
    }

    @Deprecated
    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        if (this.mTask != null) {
            printWriter.print(str);
            printWriter.print("mTask=");
            printWriter.print(this.mTask);
            printWriter.print(" waiting=");
            printWriter.println(this.mTask.f2555k);
        }
        if (this.mCancellingTask != null) {
            printWriter.print(str);
            printWriter.print("mCancellingTask=");
            printWriter.print(this.mCancellingTask);
            printWriter.print(" waiting=");
            printWriter.println(this.mCancellingTask.f2555k);
        }
        if (this.mUpdateThrottle != 0) {
            printWriter.print(str);
            printWriter.print("mUpdateThrottle=");
            C0796i.m2509a(this.mUpdateThrottle, printWriter);
            printWriter.print(" mLastLoadCompleteTime=");
            C0796i.m2508a(this.mLastLoadCompleteTime, SystemClock.uptimeMillis(), printWriter);
            printWriter.println();
        }
    }

    /* access modifiers changed from: package-private */
    public void executePendingTask() {
        if (this.mCancellingTask == null && this.mTask != null) {
            if (this.mTask.f2555k) {
                this.mTask.f2555k = false;
                this.mHandler.removeCallbacks(this.mTask);
            }
            if (this.mUpdateThrottle <= 0 || SystemClock.uptimeMillis() >= this.mLastLoadCompleteTime + this.mUpdateThrottle) {
                this.mTask.mo5093a(this.mExecutor, (Params[]) null);
                return;
            }
            this.mTask.f2555k = true;
            this.mHandler.postAtTime(this.mTask, this.mLastLoadCompleteTime + this.mUpdateThrottle);
        }
    }

    public boolean isLoadInBackgroundCanceled() {
        return this.mCancellingTask != null;
    }

    public abstract D loadInBackground();

    /* access modifiers changed from: protected */
    public boolean onCancelLoad() {
        if (this.mTask == null) {
            return false;
        }
        if (!this.mStarted) {
            this.mContentChanged = true;
        }
        if (this.mCancellingTask != null) {
            if (this.mTask.f2555k) {
                this.mTask.f2555k = false;
                this.mHandler.removeCallbacks(this.mTask);
            }
            this.mTask = null;
            return false;
        } else if (this.mTask.f2555k) {
            this.mTask.f2555k = false;
            this.mHandler.removeCallbacks(this.mTask);
            this.mTask = null;
            return false;
        } else {
            boolean a = this.mTask.mo5096a(false);
            if (a) {
                this.mCancellingTask = this.mTask;
                cancelLoadInBackground();
            }
            this.mTask = null;
            return a;
        }
    }

    public void onCanceled(D d) {
    }

    /* access modifiers changed from: protected */
    public void onForceLoad() {
        super.onForceLoad();
        cancelLoad();
        this.mTask = new C0996a();
        executePendingTask();
    }

    /* access modifiers changed from: protected */
    public D onLoadInBackground() {
        return loadInBackground();
    }

    public void setUpdateThrottle(long j) {
        this.mUpdateThrottle = j;
        if (j != 0) {
            this.mHandler = new Handler();
        }
    }

    public void waitForLoader() {
        C0995a<D>.C0000a aVar = this.mTask;
        if (aVar != null) {
            aVar.mo5063d();
        }
    }

    private C0995a(Context context, Executor executor) {
        super(context);
        this.mLastLoadCompleteTime = -10000;
        this.mExecutor = executor;
    }
}
