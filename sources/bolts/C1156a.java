package bolts;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* renamed from: bolts.a */
/* compiled from: AndroidExecutors */
final class C1156a {

    /* renamed from: b */
    private static final C1156a f3185b = new C1156a();

    /* renamed from: c */
    private static final int f3186c;

    /* renamed from: d */
    static final int f3187d;

    /* renamed from: e */
    static final int f3188e;

    /* renamed from: a */
    private final Executor f3189a = new C1158b();

    /* renamed from: bolts.a$b */
    /* compiled from: AndroidExecutors */
    private static class C1158b implements Executor {
        private C1158b() {
        }

        public void execute(Runnable runnable) {
            new Handler(Looper.getMainLooper()).post(runnable);
        }
    }

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        f3186c = availableProcessors;
        f3187d = availableProcessors + 1;
        f3188e = (availableProcessors * 2) + 1;
    }

    private C1156a() {
    }

    /* renamed from: a */
    public static ExecutorService m4761a() {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(f3187d, f3188e, 1, TimeUnit.SECONDS, new LinkedBlockingQueue());
        m4762a(threadPoolExecutor, true);
        return threadPoolExecutor;
    }

    /* renamed from: b */
    public static Executor m4763b() {
        return f3185b.f3189a;
    }

    @SuppressLint({"NewApi"})
    /* renamed from: a */
    public static void m4762a(ThreadPoolExecutor threadPoolExecutor, boolean z) {
        if (Build.VERSION.SDK_INT >= 9) {
            threadPoolExecutor.allowCoreThreadTimeOut(z);
        }
    }
}
