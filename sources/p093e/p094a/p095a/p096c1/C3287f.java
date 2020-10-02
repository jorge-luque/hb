package p093e.p094a.p095a.p096c1;

import java.lang.Thread;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import p093e.p094a.p095a.C3309k;

/* renamed from: e.a.a.c1.f */
/* compiled from: ThreadFactoryWrapper */
public class C3287f implements ThreadFactory {

    /* renamed from: a */
    private String f9130a;

    /* renamed from: e.a.a.c1.f$a */
    /* compiled from: ThreadFactoryWrapper */
    class C3288a implements Thread.UncaughtExceptionHandler {
        C3288a(C3287f fVar) {
        }

        public void uncaughtException(Thread thread, Throwable th) {
            C3309k.m11002d().mo19022c("Thread [%s] with error [%s]", thread.getName(), th.getMessage());
        }
    }

    public C3287f(String str) {
        this.f9130a = str;
    }

    public Thread newThread(Runnable runnable) {
        Thread newThread = Executors.defaultThreadFactory().newThread(runnable);
        newThread.setPriority(9);
        newThread.setName("Adjust-" + newThread.getName() + "-" + this.f9130a);
        newThread.setDaemon(true);
        newThread.setUncaughtExceptionHandler(new C3288a(this));
        return newThread;
    }
}
