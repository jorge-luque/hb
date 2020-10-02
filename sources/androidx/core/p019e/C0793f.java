package androidx.core.p019e;

/* renamed from: androidx.core.e.f */
/* compiled from: Pools */
public class C0793f<T> implements C0792e<T> {

    /* renamed from: a */
    private final Object[] f1998a;

    /* renamed from: b */
    private int f1999b;

    public C0793f(int i) {
        if (i > 0) {
            this.f1998a = new Object[i];
            return;
        }
        throw new IllegalArgumentException("The max pool size must be > 0");
    }

    /* renamed from: b */
    private boolean m2497b(T t) {
        for (int i = 0; i < this.f1999b; i++) {
            if (this.f1998a[i] == t) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    public T mo4075a() {
        int i = this.f1999b;
        if (i <= 0) {
            return null;
        }
        int i2 = i - 1;
        T[] tArr = this.f1998a;
        T t = tArr[i2];
        tArr[i2] = null;
        this.f1999b = i - 1;
        return t;
    }

    /* renamed from: a */
    public boolean mo4076a(T t) {
        if (!m2497b(t)) {
            int i = this.f1999b;
            Object[] objArr = this.f1998a;
            if (i >= objArr.length) {
                return false;
            }
            objArr[i] = t;
            this.f1999b = i + 1;
            return true;
        }
        throw new IllegalStateException("Already in the pool!");
    }
}
