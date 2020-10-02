package p118io.fabric.sdk.android.services.concurrency;

import android.annotation.TargetApi;
import java.util.concurrent.Callable;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* renamed from: io.fabric.sdk.android.services.concurrency.k */
/* compiled from: PriorityThreadPoolExecutor */
public class C6182k extends ThreadPoolExecutor {

    /* renamed from: a */
    private static final int f16230a;

    /* renamed from: b */
    private static final int f16231b;

    /* renamed from: c */
    private static final int f16232c;

    /* renamed from: io.fabric.sdk.android.services.concurrency.k$a */
    /* compiled from: PriorityThreadPoolExecutor */
    protected static final class C6183a implements ThreadFactory {

        /* renamed from: a */
        private final int f16233a;

        public C6183a(int i) {
            this.f16233a = i;
        }

        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable);
            thread.setPriority(this.f16233a);
            thread.setName("Queue");
            return thread;
        }
    }

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        f16230a = availableProcessors;
        f16231b = availableProcessors + 1;
        f16232c = (availableProcessors * 2) + 1;
    }

    <T extends Runnable & C6172b & C6184l & C6180i> C6182k(int i, int i2, long j, TimeUnit timeUnit, C6173c<T> cVar, ThreadFactory threadFactory) {
        super(i, i2, j, timeUnit, cVar, threadFactory);
        prestartAllCoreThreads();
    }

    /* renamed from: a */
    public static <T extends Runnable & C6172b & C6184l & C6180i> C6182k m19948a(int i, int i2) {
        return new C6182k(i, i2, 1, TimeUnit.SECONDS, new C6173c(), new C6183a(10));
    }

    /* access modifiers changed from: protected */
    public void afterExecute(Runnable runnable, Throwable th) {
        C6184l lVar = (C6184l) runnable;
        lVar.setFinished(true);
        lVar.setError(th);
        getQueue().mo34280a();
        super.afterExecute(runnable, th);
    }

    @TargetApi(9)
    public void execute(Runnable runnable) {
        if (C6181j.isProperDelegate(runnable)) {
            super.execute(runnable);
        } else {
            super.execute(newTaskFor(runnable, (Object) null));
        }
    }

    /* access modifiers changed from: protected */
    public <T> RunnableFuture<T> newTaskFor(Runnable runnable, T t) {
        return new C6179h(runnable, t);
    }

    /* renamed from: a */
    public static C6182k m19947a() {
        return m19948a(f16231b, f16232c);
    }

    public C6173c getQueue() {
        return (C6173c) super.getQueue();
    }

    /* access modifiers changed from: protected */
    public <T> RunnableFuture<T> newTaskFor(Callable<T> callable) {
        return new C6179h(callable);
    }
}
