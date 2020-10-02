package androidx.loader.p026b;

import android.os.Binder;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.util.Log;
import com.ogury.p159cm.OguryChoiceManager;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: androidx.loader.b.c */
/* compiled from: ModernAsyncTask */
abstract class C1000c<Params, Progress, Result> {

    /* renamed from: f */
    private static final ThreadFactory f2557f = new C1001a();

    /* renamed from: g */
    private static final BlockingQueue<Runnable> f2558g = new LinkedBlockingQueue(10);

    /* renamed from: h */
    public static final Executor f2559h = new ThreadPoolExecutor(5, OguryChoiceManager.TcfV2.Purpose.MEASURE_AD_PERFORMANCE, 1, TimeUnit.SECONDS, f2558g, f2557f);

    /* renamed from: i */
    private static C1006f f2560i;

    /* renamed from: a */
    private final C1008h<Params, Result> f2561a = new C1002b();

    /* renamed from: b */
    private final FutureTask<Result> f2562b = new C1003c(this.f2561a);

    /* renamed from: c */
    private volatile C1007g f2563c = C1007g.PENDING;

    /* renamed from: d */
    final AtomicBoolean f2564d = new AtomicBoolean();

    /* renamed from: e */
    final AtomicBoolean f2565e = new AtomicBoolean();

    /* renamed from: androidx.loader.b.c$a */
    /* compiled from: ModernAsyncTask */
    static class C1001a implements ThreadFactory {

        /* renamed from: a */
        private final AtomicInteger f2566a = new AtomicInteger(1);

        C1001a() {
        }

        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "ModernAsyncTask #" + this.f2566a.getAndIncrement());
        }
    }

    /* renamed from: androidx.loader.b.c$b */
    /* compiled from: ModernAsyncTask */
    class C1002b extends C1008h<Params, Result> {
        C1002b() {
        }

        public Result call() throws Exception {
            C1000c.this.f2565e.set(true);
            Result result = null;
            try {
                Process.setThreadPriority(10);
                result = C1000c.this.mo5059a(this.f2576a);
                Binder.flushPendingCommands();
                C1000c.this.mo5100d(result);
                return result;
            } catch (Throwable th) {
                C1000c.this.mo5100d(result);
                throw th;
            }
        }
    }

    /* renamed from: androidx.loader.b.c$c */
    /* compiled from: ModernAsyncTask */
    class C1003c extends FutureTask<Result> {
        C1003c(Callable callable) {
            super(callable);
        }

        /* access modifiers changed from: protected */
        public void done() {
            try {
                C1000c.this.mo5101e(get());
            } catch (InterruptedException e) {
                Log.w("AsyncTask", e);
            } catch (ExecutionException e2) {
                throw new RuntimeException("An error occurred while executing doInBackground()", e2.getCause());
            } catch (CancellationException unused) {
                C1000c.this.mo5101e(null);
            } catch (Throwable th) {
                throw new RuntimeException("An error occurred while executing doInBackground()", th);
            }
        }
    }

    /* renamed from: androidx.loader.b.c$d */
    /* compiled from: ModernAsyncTask */
    static /* synthetic */ class C1004d {

        /* renamed from: a */
        static final /* synthetic */ int[] f2569a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                androidx.loader.b.c$g[] r0 = androidx.loader.p026b.C1000c.C1007g.m3558a()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f2569a = r0
                androidx.loader.b.c$g r1 = androidx.loader.p026b.C1000c.C1007g.RUNNING     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f2569a     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.loader.b.c$g r1 = androidx.loader.p026b.C1000c.C1007g.FINISHED     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.loader.p026b.C1000c.C1004d.<clinit>():void");
        }
    }

    /* renamed from: androidx.loader.b.c$e */
    /* compiled from: ModernAsyncTask */
    private static class C1005e<Data> {

        /* renamed from: a */
        final C1000c f2570a;

        /* renamed from: b */
        final Data[] f2571b;

        C1005e(C1000c cVar, Data... dataArr) {
            this.f2570a = cVar;
            this.f2571b = dataArr;
        }
    }

    /* renamed from: androidx.loader.b.c$f */
    /* compiled from: ModernAsyncTask */
    private static class C1006f extends Handler {
        C1006f() {
            super(Looper.getMainLooper());
        }

        public void handleMessage(Message message) {
            C1005e eVar = (C1005e) message.obj;
            int i = message.what;
            if (i == 1) {
                eVar.f2570a.mo5094a(eVar.f2571b[0]);
            } else if (i == 2) {
                eVar.f2570a.mo5098b((Progress[]) eVar.f2571b);
            }
        }
    }

    /* renamed from: androidx.loader.b.c$g */
    /* compiled from: ModernAsyncTask */
    public enum C1007g {
        PENDING,
        RUNNING,
        FINISHED;

        /* renamed from: a */
        public static C1007g[] m3558a() {
            return (C1007g[]) f2575d.clone();
        }
    }

    /* renamed from: androidx.loader.b.c$h */
    /* compiled from: ModernAsyncTask */
    private static abstract class C1008h<Params, Result> implements Callable<Result> {

        /* renamed from: a */
        Params[] f2576a;

        C1008h() {
        }
    }

    C1000c() {
    }

    /* renamed from: d */
    private static Handler mo5063d() {
        C1006f fVar;
        synchronized (C1000c.class) {
            if (f2560i == null) {
                f2560i = new C1006f();
            }
            fVar = f2560i;
        }
        return fVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract Result mo5059a(Params... paramsArr);

    /* renamed from: a */
    public final boolean mo5095a() {
        return this.f2564d.get();
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo5097b() {
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo5061b(Result result) {
        mo5097b();
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo5098b(Progress... progressArr) {
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public void mo5099c() {
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public void mo5062c(Result result) {
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public void mo5101e(Result result) {
        if (!this.f2565e.get()) {
            mo5100d(result);
        }
    }

    /* renamed from: a */
    public final boolean mo5096a(boolean z) {
        this.f2564d.set(true);
        return this.f2562b.cancel(z);
    }

    /* renamed from: a */
    public final C1000c<Params, Progress, Result> mo5093a(Executor executor, Params... paramsArr) {
        if (this.f2563c != C1007g.PENDING) {
            int i = C1004d.f2569a[this.f2563c.ordinal()];
            if (i == 1) {
                throw new IllegalStateException("Cannot execute task: the task is already running.");
            } else if (i != 2) {
                throw new IllegalStateException("We should never reach this state");
            } else {
                throw new IllegalStateException("Cannot execute task: the task has already been executed (a task can be executed only once)");
            }
        } else {
            this.f2563c = C1007g.RUNNING;
            mo5099c();
            this.f2561a.f2576a = paramsArr;
            executor.execute(this.f2562b);
            return this;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public Result mo5100d(Result result) {
        mo5063d().obtainMessage(1, new C1005e(this, result)).sendToTarget();
        return result;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo5094a(Result result) {
        if (mo5095a()) {
            mo5061b(result);
        } else {
            mo5062c(result);
        }
        this.f2563c = C1007g.FINISHED;
    }
}
