package p118io.fabric.sdk.android.p200m.p202b;

import java.util.Locale;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import p118io.fabric.sdk.android.C6059c;
import p118io.fabric.sdk.android.C6072k;

/* renamed from: io.fabric.sdk.android.m.b.o */
/* compiled from: ExecutorUtils */
public final class C6100o {

    /* renamed from: io.fabric.sdk.android.m.b.o$a */
    /* compiled from: ExecutorUtils */
    static class C6101a implements ThreadFactory {

        /* renamed from: a */
        final /* synthetic */ String f16046a;

        /* renamed from: b */
        final /* synthetic */ AtomicLong f16047b;

        /* renamed from: io.fabric.sdk.android.m.b.o$a$a */
        /* compiled from: ExecutorUtils */
        class C6102a extends C6089h {

            /* renamed from: a */
            final /* synthetic */ Runnable f16048a;

            C6102a(C6101a aVar, Runnable runnable) {
                this.f16048a = runnable;
            }

            public void onRun() {
                this.f16048a.run();
            }
        }

        C6101a(String str, AtomicLong atomicLong) {
            this.f16046a = str;
            this.f16047b = atomicLong;
        }

        public Thread newThread(Runnable runnable) {
            Thread newThread = Executors.defaultThreadFactory().newThread(new C6102a(this, runnable));
            newThread.setName(this.f16046a + this.f16047b.getAndIncrement());
            return newThread;
        }
    }

    /* renamed from: io.fabric.sdk.android.m.b.o$b */
    /* compiled from: ExecutorUtils */
    static class C6103b extends C6089h {

        /* renamed from: a */
        final /* synthetic */ String f16049a;

        /* renamed from: b */
        final /* synthetic */ ExecutorService f16050b;

        /* renamed from: c */
        final /* synthetic */ long f16051c;

        /* renamed from: d */
        final /* synthetic */ TimeUnit f16052d;

        C6103b(String str, ExecutorService executorService, long j, TimeUnit timeUnit) {
            this.f16049a = str;
            this.f16050b = executorService;
            this.f16051c = j;
            this.f16052d = timeUnit;
        }

        public void onRun() {
            try {
                C6072k f = C6059c.m19630f();
                f.mo34093d("Fabric", "Executing shutdown hook for " + this.f16049a);
                this.f16050b.shutdown();
                if (!this.f16050b.awaitTermination(this.f16051c, this.f16052d)) {
                    C6072k f2 = C6059c.m19630f();
                    f2.mo34093d("Fabric", this.f16049a + " did not shut down in the allocated time. Requesting immediate shutdown.");
                    this.f16050b.shutdownNow();
                }
            } catch (InterruptedException unused) {
                C6059c.m19630f().mo34093d("Fabric", String.format(Locale.US, "Interrupted while waiting for %s to shut down. Requesting immediate shutdown.", new Object[]{this.f16049a}));
                this.f16050b.shutdownNow();
            }
        }
    }

    /* renamed from: a */
    public static ExecutorService m19772a(String str) {
        ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor(m19776c(str));
        m19773a(str, newSingleThreadExecutor);
        return newSingleThreadExecutor;
    }

    /* renamed from: b */
    public static ScheduledExecutorService m19775b(String str) {
        ScheduledExecutorService newSingleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor(m19776c(str));
        m19773a(str, newSingleThreadScheduledExecutor);
        return newSingleThreadScheduledExecutor;
    }

    /* renamed from: c */
    public static final ThreadFactory m19776c(String str) {
        return new C6101a(str, new AtomicLong(1));
    }

    /* renamed from: a */
    private static final void m19773a(String str, ExecutorService executorService) {
        m19774a(str, executorService, 2, TimeUnit.SECONDS);
    }

    /* renamed from: a */
    public static final void m19774a(String str, ExecutorService executorService, long j, TimeUnit timeUnit) {
        Runtime runtime = Runtime.getRuntime();
        C6103b bVar = new C6103b(str, executorService, j, timeUnit);
        runtime.addShutdownHook(new Thread(bVar, "Crashlytics Shutdown Hook for " + str));
    }
}
