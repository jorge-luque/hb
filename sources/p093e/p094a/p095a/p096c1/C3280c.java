package p093e.p094a.p095a.p096c1;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import p093e.p094a.p095a.C3309k;

/* renamed from: e.a.a.c1.c */
/* compiled from: SingleThreadCachedScheduler */
public class C3280c implements C3289g {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final List<Runnable> f9118a = new ArrayList();
    /* access modifiers changed from: private */

    /* renamed from: b */
    public boolean f9119b = false;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public boolean f9120c = false;

    /* renamed from: d */
    private ThreadPoolExecutor f9121d;

    /* renamed from: e.a.a.c1.c$a */
    /* compiled from: SingleThreadCachedScheduler */
    class C3281a implements RejectedExecutionHandler {

        /* renamed from: a */
        final /* synthetic */ String f9122a;

        C3281a(C3280c cVar, String str) {
            this.f9122a = str;
        }

        public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
            C3309k.m11002d().mo19021b("Runnable [%s] rejected from [%s] ", runnable.toString(), this.f9122a);
        }
    }

    /* renamed from: e.a.a.c1.c$b */
    /* compiled from: SingleThreadCachedScheduler */
    class C3282b implements Runnable {

        /* renamed from: a */
        final /* synthetic */ long f9123a;

        /* renamed from: b */
        final /* synthetic */ Runnable f9124b;

        C3282b(long j, Runnable runnable) {
            this.f9123a = j;
            this.f9124b = runnable;
        }

        public void run() {
            try {
                Thread.sleep(this.f9123a);
            } catch (InterruptedException e) {
                C3309k.m11002d().mo19021b("Sleep delay exception: %s", e.getMessage());
            }
            C3280c.this.submit(this.f9124b);
        }
    }

    /* renamed from: e.a.a.c1.c$c */
    /* compiled from: SingleThreadCachedScheduler */
    class C3283c implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Runnable f9126a;

        C3283c(Runnable runnable) {
            this.f9126a = runnable;
        }

        public void run() {
            Runnable runnable;
            C3280c.this.m10921b(this.f9126a);
            while (true) {
                synchronized (C3280c.this.f9118a) {
                    if (!C3280c.this.f9120c) {
                        if (C3280c.this.f9118a.isEmpty()) {
                            boolean unused = C3280c.this.f9119b = false;
                            return;
                        } else {
                            runnable = (Runnable) C3280c.this.f9118a.get(0);
                            C3280c.this.f9118a.remove(0);
                        }
                    } else {
                        return;
                    }
                }
                C3280c.this.m10921b(runnable);
            }
            while (true) {
            }
        }
    }

    public C3280c(String str) {
        this.f9121d = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), new C3287f(str), new C3281a(this, str));
    }

    public void schedule(Runnable runnable, long j) {
        synchronized (this.f9118a) {
            if (!this.f9120c) {
                this.f9121d.submit(new C3282b(j, runnable));
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001a, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void submit(java.lang.Runnable r3) {
        /*
            r2 = this;
            java.util.List<java.lang.Runnable> r0 = r2.f9118a
            monitor-enter(r0)
            boolean r1 = r2.f9120c     // Catch:{ all -> 0x001b }
            if (r1 == 0) goto L_0x0009
            monitor-exit(r0)     // Catch:{ all -> 0x001b }
            return
        L_0x0009:
            boolean r1 = r2.f9119b     // Catch:{ all -> 0x001b }
            if (r1 != 0) goto L_0x0014
            r1 = 1
            r2.f9119b = r1     // Catch:{ all -> 0x001b }
            r2.m10919a((java.lang.Runnable) r3)     // Catch:{ all -> 0x001b }
            goto L_0x0019
        L_0x0014:
            java.util.List<java.lang.Runnable> r1 = r2.f9118a     // Catch:{ all -> 0x001b }
            r1.add(r3)     // Catch:{ all -> 0x001b }
        L_0x0019:
            monitor-exit(r0)     // Catch:{ all -> 0x001b }
            return
        L_0x001b:
            r3 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x001b }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: p093e.p094a.p095a.p096c1.C3280c.submit(java.lang.Runnable):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m10921b(Runnable runnable) {
        try {
            if (!this.f9120c) {
                runnable.run();
            }
        } catch (Throwable th) {
            C3309k.m11002d().mo19021b("Execution failed: %s", th.getMessage());
        }
    }

    /* renamed from: a */
    private void m10919a(Runnable runnable) {
        this.f9121d.submit(new C3283c(runnable));
    }
}
