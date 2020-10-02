package p118io.fabric.sdk.android.services.concurrency;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.util.Log;
import com.ogury.p159cm.OguryChoiceManager;
import java.util.LinkedList;
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

/* renamed from: io.fabric.sdk.android.services.concurrency.a */
/* compiled from: AsyncTask */
public abstract class C6161a<Params, Progress, Result> {

    /* renamed from: f */
    private static final int f16191f;

    /* renamed from: g */
    private static final int f16192g;

    /* renamed from: h */
    private static final int f16193h;

    /* renamed from: i */
    private static final ThreadFactory f16194i = new C6162a();

    /* renamed from: j */
    private static final BlockingQueue<Runnable> f16195j = new LinkedBlockingQueue(OguryChoiceManager.TcfV2.Purpose.MEASURE_AD_PERFORMANCE);

    /* renamed from: k */
    public static final Executor f16196k = new ThreadPoolExecutor(f16192g, f16193h, 1, TimeUnit.SECONDS, f16195j, f16194i);

    /* renamed from: l */
    public static final Executor f16197l = new C6168g((C6162a) null);

    /* renamed from: m */
    private static final C6167f f16198m = new C6167f();

    /* renamed from: a */
    private final C6171i<Params, Result> f16199a = new C6163b();

    /* renamed from: b */
    private final FutureTask<Result> f16200b = new C6164c(this.f16199a);

    /* renamed from: c */
    private volatile C6170h f16201c = C6170h.PENDING;

    /* renamed from: d */
    private final AtomicBoolean f16202d = new AtomicBoolean();
    /* access modifiers changed from: private */

    /* renamed from: e */
    public final AtomicBoolean f16203e = new AtomicBoolean();

    /* renamed from: io.fabric.sdk.android.services.concurrency.a$a */
    /* compiled from: AsyncTask */
    static class C6162a implements ThreadFactory {

        /* renamed from: a */
        private final AtomicInteger f16204a = new AtomicInteger(1);

        C6162a() {
        }

        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "AsyncTask #" + this.f16204a.getAndIncrement());
        }
    }

    /* renamed from: io.fabric.sdk.android.services.concurrency.a$b */
    /* compiled from: AsyncTask */
    class C6163b extends C6171i<Params, Result> {
        C6163b() {
            super((C6162a) null);
        }

        public Result call() throws Exception {
            C6161a.this.f16203e.set(true);
            Process.setThreadPriority(10);
            C6161a aVar = C6161a.this;
            Result a = aVar.mo34121a(this.f16218a);
            Object unused = aVar.m19919d(a);
            return a;
        }
    }

    /* renamed from: io.fabric.sdk.android.services.concurrency.a$c */
    /* compiled from: AsyncTask */
    class C6164c extends FutureTask<Result> {
        C6164c(Callable callable) {
            super(callable);
        }

        /* access modifiers changed from: protected */
        public void done() {
            try {
                C6161a.this.m19920e(get());
            } catch (InterruptedException e) {
                Log.w("AsyncTask", e);
            } catch (ExecutionException e2) {
                throw new RuntimeException("An error occured while executing doInBackground()", e2.getCause());
            } catch (CancellationException unused) {
                C6161a.this.m19920e(null);
            }
        }
    }

    /* renamed from: io.fabric.sdk.android.services.concurrency.a$d */
    /* compiled from: AsyncTask */
    static /* synthetic */ class C6165d {

        /* renamed from: a */
        static final /* synthetic */ int[] f16207a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                io.fabric.sdk.android.services.concurrency.a$h[] r0 = p118io.fabric.sdk.android.services.concurrency.C6161a.C6170h.m19931a()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f16207a = r0
                io.fabric.sdk.android.services.concurrency.a$h r1 = p118io.fabric.sdk.android.services.concurrency.C6161a.C6170h.RUNNING     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f16207a     // Catch:{ NoSuchFieldError -> 0x001d }
                io.fabric.sdk.android.services.concurrency.a$h r1 = p118io.fabric.sdk.android.services.concurrency.C6161a.C6170h.FINISHED     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: p118io.fabric.sdk.android.services.concurrency.C6161a.C6165d.<clinit>():void");
        }
    }

    /* renamed from: io.fabric.sdk.android.services.concurrency.a$e */
    /* compiled from: AsyncTask */
    private static class C6166e<Data> {

        /* renamed from: a */
        final C6161a f16208a;

        /* renamed from: b */
        final Data[] f16209b;

        C6166e(C6161a aVar, Data... dataArr) {
            this.f16208a = aVar;
            this.f16209b = dataArr;
        }
    }

    /* renamed from: io.fabric.sdk.android.services.concurrency.a$f */
    /* compiled from: AsyncTask */
    private static class C6167f extends Handler {
        public C6167f() {
            super(Looper.getMainLooper());
        }

        public void handleMessage(Message message) {
            C6166e eVar = (C6166e) message.obj;
            int i = message.what;
            if (i == 1) {
                eVar.f16208a.m19918c(eVar.f16209b[0]);
            } else if (i == 2) {
                eVar.f16208a.mo34267b((Progress[]) eVar.f16209b);
            }
        }
    }

    /* renamed from: io.fabric.sdk.android.services.concurrency.a$h */
    /* compiled from: AsyncTask */
    public enum C6170h {
        PENDING,
        RUNNING,
        FINISHED;

        /* renamed from: a */
        public static C6170h[] m19931a() {
            return (C6170h[]) f16217d.clone();
        }
    }

    /* renamed from: io.fabric.sdk.android.services.concurrency.a$i */
    /* compiled from: AsyncTask */
    private static abstract class C6171i<Params, Result> implements Callable<Result> {

        /* renamed from: a */
        Params[] f16218a;

        private C6171i() {
        }

        /* synthetic */ C6171i(C6162a aVar) {
            this();
        }
    }

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        f16191f = availableProcessors;
        f16192g = availableProcessors + 1;
        f16193h = (availableProcessors * 2) + 1;
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public Result m19919d(Result result) {
        f16198m.obtainMessage(1, new C6166e(this, result)).sendToTarget();
        return result;
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public void m19920e(Result result) {
        if (!this.f16203e.get()) {
            m19919d(result);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract Result mo34121a(Params... paramsArr);

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract void mo34123a(Result result);

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public abstract void mo34124b(Result result);

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo34267b(Progress... progressArr) {
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public void mo34125c() {
    }

    /* renamed from: io.fabric.sdk.android.services.concurrency.a$g */
    /* compiled from: AsyncTask */
    private static class C6168g implements Executor {

        /* renamed from: a */
        final LinkedList<Runnable> f16210a;

        /* renamed from: b */
        Runnable f16211b;

        /* renamed from: io.fabric.sdk.android.services.concurrency.a$g$a */
        /* compiled from: AsyncTask */
        class C6169a implements Runnable {

            /* renamed from: a */
            final /* synthetic */ Runnable f16212a;

            C6169a(Runnable runnable) {
                this.f16212a = runnable;
            }

            public void run() {
                try {
                    this.f16212a.run();
                } finally {
                    C6168g.this.mo34273a();
                }
            }
        }

        private C6168g() {
            this.f16210a = new LinkedList<>();
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public synchronized void mo34273a() {
            Runnable poll = this.f16210a.poll();
            this.f16211b = poll;
            if (poll != null) {
                C6161a.f16196k.execute(poll);
            }
        }

        public synchronized void execute(Runnable runnable) {
            this.f16210a.offer(new C6169a(runnable));
            if (this.f16211b == null) {
                mo34273a();
            }
        }

        /* synthetic */ C6168g(C6162a aVar) {
            this();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m19918c(Result result) {
        if (mo34268b()) {
            mo34123a(result);
        } else {
            mo34124b(result);
        }
        this.f16201c = C6170h.FINISHED;
    }

    /* renamed from: b */
    public final boolean mo34268b() {
        return this.f16202d.get();
    }

    /* renamed from: a */
    public final C6170h mo34264a() {
        return this.f16201c;
    }

    /* renamed from: a */
    public final boolean mo34266a(boolean z) {
        this.f16202d.set(true);
        return this.f16200b.cancel(z);
    }

    /* renamed from: a */
    public final C6161a<Params, Progress, Result> mo34265a(Executor executor, Params... paramsArr) {
        if (this.f16201c != C6170h.PENDING) {
            int i = C6165d.f16207a[this.f16201c.ordinal()];
            if (i == 1) {
                throw new IllegalStateException("Cannot execute task: the task is already running.");
            } else if (i == 2) {
                throw new IllegalStateException("Cannot execute task: the task has already been executed (a task can be executed only once)");
            }
        }
        this.f16201c = C6170h.RUNNING;
        mo34125c();
        this.f16199a.f16218a = paramsArr;
        executor.execute(this.f16200b);
        return this;
    }
}
