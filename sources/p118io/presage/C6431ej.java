package p118io.presage;

import java.io.Serializable;

/* renamed from: io.presage.ej */
public final class C6431ej<A, B> implements Serializable {

    /* renamed from: a */
    private final A f17011a;

    /* renamed from: b */
    private final B f17012b;

    public C6431ej(A a, B b) {
        this.f17011a = a;
        this.f17012b = b;
    }

    /* renamed from: a */
    public final A mo35393a() {
        return this.f17011a;
    }

    /* renamed from: b */
    public final B mo35394b() {
        return this.f17012b;
    }

    /* renamed from: c */
    public final A mo35395c() {
        return this.f17011a;
    }

    /* renamed from: d */
    public final B mo35396d() {
        return this.f17012b;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C6431ej)) {
            return false;
        }
        C6431ej ejVar = (C6431ej) obj;
        return C6514hl.m21416a((Object) this.f17011a, (Object) ejVar.f17011a) && C6514hl.m21416a((Object) this.f17012b, (Object) ejVar.f17012b);
    }

    public final int hashCode() {
        A a = this.f17011a;
        int i = 0;
        int hashCode = (a != null ? a.hashCode() : 0) * 31;
        B b = this.f17012b;
        if (b != null) {
            i = b.hashCode();
        }
        return hashCode + i;
    }

    public final String toString() {
        return "(" + this.f17011a + ", " + this.f17012b + ')';
    }
}
