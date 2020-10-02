package p113i.p114e0;

/* renamed from: i.e0.b */
/* compiled from: NamedRunnable */
public abstract class C5927b implements Runnable {

    /* renamed from: a */
    protected final String f15169a;

    public C5927b(String str, Object... objArr) {
        this.f15169a = C3500c.m11639a(str, objArr);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public abstract void mo19596b();

    public final void run() {
        String name = Thread.currentThread().getName();
        Thread.currentThread().setName(this.f15169a);
        try {
            mo19596b();
        } finally {
            Thread.currentThread().setName(name);
        }
    }
}
