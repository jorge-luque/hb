package p093e.p094a.p095a.p096c1;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import p093e.p094a.p095a.C3309k;

/* renamed from: e.a.a.c1.d */
/* compiled from: SingleThreadFutureScheduler */
public class C3284d implements C3278a {

    /* renamed from: a */
    private ScheduledThreadPoolExecutor f9128a;

    /* renamed from: e.a.a.c1.d$a */
    /* compiled from: SingleThreadFutureScheduler */
    class C3285a implements RejectedExecutionHandler {

        /* renamed from: a */
        final /* synthetic */ String f9129a;

        C3285a(C3284d dVar, String str) {
            this.f9129a = str;
        }

        public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
            C3309k.m11002d().mo19021b("Runnable [%s] rejected from [%s] ", runnable.toString(), this.f9129a);
        }
    }

    public C3284d(String str, boolean z) {
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1, new C3287f(str), new C3285a(this, str));
        this.f9128a = scheduledThreadPoolExecutor;
        if (!z) {
            scheduledThreadPoolExecutor.setKeepAliveTime(10, TimeUnit.MILLISECONDS);
            this.f9128a.allowCoreThreadTimeOut(true);
        }
    }

    /* renamed from: a */
    public ScheduledFuture<?> mo18985a(Runnable runnable, long j) {
        return this.f9128a.schedule(new C3279b(runnable), j, TimeUnit.MILLISECONDS);
    }

    /* renamed from: a */
    public ScheduledFuture<?> mo18986a(Runnable runnable, long j, long j2) {
        return this.f9128a.scheduleWithFixedDelay(new C3279b(runnable), j, j2, TimeUnit.MILLISECONDS);
    }
}
