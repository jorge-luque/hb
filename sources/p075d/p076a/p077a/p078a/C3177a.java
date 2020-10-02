package p075d.p076a.p077a.p078a;

import java.util.concurrent.Executor;

/* renamed from: d.a.a.a.a */
/* compiled from: ArchTaskExecutor */
public class C3177a extends C3182c {

    /* renamed from: c */
    private static volatile C3177a f8854c;

    /* renamed from: a */
    private C3182c f8855a;

    /* renamed from: b */
    private C3182c f8856b;

    /* renamed from: d.a.a.a.a$a */
    /* compiled from: ArchTaskExecutor */
    static class C3178a implements Executor {
        C3178a() {
        }

        public void execute(Runnable runnable) {
            C3177a.m10473b().mo18640b(runnable);
        }
    }

    /* renamed from: d.a.a.a.a$b */
    /* compiled from: ArchTaskExecutor */
    static class C3179b implements Executor {
        C3179b() {
        }

        public void execute(Runnable runnable) {
            C3177a.m10473b().mo18638a(runnable);
        }
    }

    static {
        new C3178a();
        new C3179b();
    }

    private C3177a() {
        C3180b bVar = new C3180b();
        this.f8856b = bVar;
        this.f8855a = bVar;
    }

    /* renamed from: b */
    public static C3177a m10473b() {
        if (f8854c != null) {
            return f8854c;
        }
        synchronized (C3177a.class) {
            if (f8854c == null) {
                f8854c = new C3177a();
            }
        }
        return f8854c;
    }

    /* renamed from: a */
    public void mo18638a(Runnable runnable) {
        this.f8855a.mo18638a(runnable);
    }

    /* renamed from: a */
    public boolean mo18639a() {
        return this.f8855a.mo18639a();
    }

    /* renamed from: b */
    public void mo18640b(Runnable runnable) {
        this.f8855a.mo18640b(runnable);
    }
}
