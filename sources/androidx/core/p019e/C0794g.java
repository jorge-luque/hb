package androidx.core.p019e;

/* renamed from: androidx.core.e.g */
/* compiled from: Pools */
public class C0794g<T> extends C0793f<T> {

    /* renamed from: c */
    private final Object f2000c = new Object();

    public C0794g(int i) {
        super(i);
    }

    /* renamed from: a */
    public T mo4075a() {
        T a;
        synchronized (this.f2000c) {
            a = super.mo4075a();
        }
        return a;
    }

    /* renamed from: a */
    public boolean mo4076a(T t) {
        boolean a;
        synchronized (this.f2000c) {
            a = super.mo4076a(t);
        }
        return a;
    }
}
