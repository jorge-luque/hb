package androidx.core.p019e;

/* renamed from: androidx.core.e.d */
/* compiled from: Pair */
public class C0791d<F, S> {

    /* renamed from: a */
    public final F f1996a;

    /* renamed from: b */
    public final S f1997b;

    public C0791d(F f, S s) {
        this.f1996a = f;
        this.f1997b = s;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C0791d)) {
            return false;
        }
        C0791d dVar = (C0791d) obj;
        if (!C0790c.m2494a(dVar.f1996a, this.f1996a) || !C0790c.m2494a(dVar.f1997b, this.f1997b)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        F f = this.f1996a;
        int i = 0;
        int hashCode = f == null ? 0 : f.hashCode();
        S s = this.f1997b;
        if (s != null) {
            i = s.hashCode();
        }
        return hashCode ^ i;
    }

    public String toString() {
        return "Pair{" + String.valueOf(this.f1996a) + " " + String.valueOf(this.f1997b) + "}";
    }
}
