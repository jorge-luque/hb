package bolts;

import java.util.Locale;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* renamed from: bolts.d */
/* compiled from: BoltsExecutors */
final class C1162d {

    /* renamed from: c */
    private static final C1162d f3193c = new C1162d();

    /* renamed from: a */
    private final ExecutorService f3194a;

    /* renamed from: b */
    private final Executor f3195b;

    /* renamed from: bolts.d$b */
    /* compiled from: BoltsExecutors */
    private static class C1164b implements Executor {

        /* renamed from: a */
        private ThreadLocal<Integer> f3196a;

        private C1164b() {
            this.f3196a = new ThreadLocal<>();
        }

        /* renamed from: a */
        private int m4769a() {
            Integer num = this.f3196a.get();
            if (num == null) {
                num = 0;
            }
            int intValue = num.intValue() - 1;
            if (intValue == 0) {
                this.f3196a.remove();
            } else {
                this.f3196a.set(Integer.valueOf(intValue));
            }
            return intValue;
        }

        /* renamed from: b */
        private int m4770b() {
            Integer num = this.f3196a.get();
            if (num == null) {
                num = 0;
            }
            int intValue = num.intValue() + 1;
            this.f3196a.set(Integer.valueOf(intValue));
            return intValue;
        }

        public void execute(Runnable runnable) {
            if (m4770b() <= 15) {
                try {
                    runnable.run();
                } catch (Throwable th) {
                    m4769a();
                    throw th;
                }
            } else {
                C1162d.m4766a().execute(runnable);
            }
            m4769a();
        }
    }

    private C1162d() {
        this.f3194a = !m4768c() ? Executors.newCachedThreadPool() : C1156a.m4761a();
        Executors.newSingleThreadScheduledExecutor();
        this.f3195b = new C1164b();
    }

    /* renamed from: a */
    public static ExecutorService m4766a() {
        return f3193c.f3194a;
    }

    /* renamed from: b */
    static Executor m4767b() {
        return f3193c.f3195b;
    }

    /* renamed from: c */
    private static boolean m4768c() {
        String property = System.getProperty("java.runtime.name");
        if (property == null) {
            return false;
        }
        return property.toLowerCase(Locale.US).contains("android");
    }
}
