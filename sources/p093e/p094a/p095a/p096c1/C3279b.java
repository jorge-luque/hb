package p093e.p094a.p095a.p096c1;

import p093e.p094a.p095a.C3309k;

/* renamed from: e.a.a.c1.b */
/* compiled from: RunnableWrapper */
public class C3279b implements Runnable {

    /* renamed from: a */
    private Runnable f9117a;

    C3279b(Runnable runnable) {
        this.f9117a = runnable;
    }

    public void run() {
        try {
            this.f9117a.run();
        } catch (Throwable th) {
            C3309k.m11002d().mo19022c("Runnable error [%s] of type [%s]", th.getMessage(), th.getClass().getCanonicalName());
        }
    }
}
