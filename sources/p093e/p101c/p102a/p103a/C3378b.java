package p093e.p101c.p102a.p103a;

/* renamed from: e.c.a.a.b */
/* compiled from: com.google.android.datatransport:transport-api@@2.2.0 */
public final class C3378b {

    /* renamed from: a */
    private final String f9441a;

    private C3378b(String str) {
        if (str != null) {
            this.f9441a = str;
            return;
        }
        throw new NullPointerException("name is null");
    }

    /* renamed from: a */
    public static C3378b m11260a(String str) {
        return new C3378b(str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C3378b)) {
            return false;
        }
        return this.f9441a.equals(((C3378b) obj).f9441a);
    }

    public int hashCode() {
        return this.f9441a.hashCode() ^ 1000003;
    }

    public String toString() {
        return "Encoding{name=\"" + this.f9441a + "\"}";
    }

    /* renamed from: a */
    public String mo19145a() {
        return this.f9441a;
    }
}
