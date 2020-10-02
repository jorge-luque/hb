package p118io.presage;

import java.io.Serializable;

/* renamed from: io.presage.ek */
final class C6432ek<T> implements C6426ee<T>, Serializable {

    /* renamed from: a */
    private C6481gf<? extends T> f17013a;

    /* renamed from: b */
    private volatile Object f17014b;

    /* renamed from: c */
    private final Object f17015c;

    private C6432ek(C6481gf<? extends T> gfVar) {
        this.f17013a = gfVar;
        this.f17014b = C6435en.f17016a;
        this.f17015c = this;
    }

    /* renamed from: b */
    private boolean m21303b() {
        return this.f17014b != C6435en.f17016a;
    }

    private final Object writeReplace() {
        return new C6424ec(mo35391a());
    }

    /* renamed from: a */
    public final T mo35391a() {
        T t;
        T t2 = this.f17014b;
        if (t2 != C6435en.f17016a) {
            return t2;
        }
        synchronized (this.f17015c) {
            t = this.f17014b;
            if (t == C6435en.f17016a) {
                C6481gf gfVar = this.f17013a;
                if (gfVar == null) {
                    C6514hl.m21413a();
                }
                t = gfVar.mo34405a();
                this.f17014b = t;
                this.f17013a = null;
            }
        }
        return t;
    }

    public final String toString() {
        return m21303b() ? String.valueOf(mo35391a()) : "Lazy value not initialized yet.";
    }

    public /* synthetic */ C6432ek(C6481gf gfVar, byte b) {
        this(gfVar);
    }
}
