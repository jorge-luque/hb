package p188f.p189a;

import p193h.p194a.C5925a;

/* renamed from: f.a.a */
/* compiled from: DoubleCheck */
public final class C5912a<T> implements C5925a<T> {

    /* renamed from: c */
    private static final Object f15134c = new Object();

    /* renamed from: a */
    private volatile C5925a<T> f15135a;

    /* renamed from: b */
    private volatile Object f15136b = f15134c;

    private C5912a(C5925a<T> aVar) {
        this.f15135a = aVar;
    }

    /* renamed from: a */
    public static Object m18978a(Object obj, Object obj2) {
        if (!(obj != f15134c) || obj == obj2) {
            return obj2;
        }
        throw new IllegalStateException("Scoped provider was invoked recursively returning different results: " + obj + " & " + obj2 + ". This is likely due to a circular dependency.");
    }

    public T get() {
        T t = this.f15136b;
        if (t == f15134c) {
            synchronized (this) {
                t = this.f15136b;
                if (t == f15134c) {
                    t = this.f15135a.get();
                    m18978a(this.f15136b, t);
                    this.f15136b = t;
                    this.f15135a = null;
                }
            }
        }
        return t;
    }

    /* renamed from: a */
    public static <P extends C5925a<T>, T> C5925a<T> m18977a(P p) {
        C5915d.m18980a(p);
        if (p instanceof C5912a) {
            return p;
        }
        return new C5912a(p);
    }
}
