package p118io.presage;

/* renamed from: io.presage.hk */
public class C6513hk extends C6507he implements C6512hj, C6537ih {

    /* renamed from: c */
    private final int f17050c;

    public C6513hk(int i, Object obj) {
        super(obj);
        this.f17050c = i;
    }

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public final C6534ie mo35518e() {
        return C6516hn.m21419a(this);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof C6513hk) {
            C6513hk hkVar = (C6513hk) obj;
            if (mo34406b() != null ? mo34406b().equals(hkVar.mo34406b()) : hkVar.mo34406b() == null) {
                return mo34407c().equals(hkVar.mo34407c()) && mo34408d().equals(hkVar.mo34408d()) && C6514hl.m21416a(mo35519f(), hkVar.mo35519f());
            }
        } else if (obj instanceof C6537ih) {
            return obj.equals(mo35520g());
        } else {
            return false;
        }
    }

    public int hashCode() {
        return (((mo34406b() == null ? 0 : mo34406b().hashCode() * 31) + mo34407c().hashCode()) * 31) + mo34408d().hashCode();
    }

    public String toString() {
        C6534ie g = mo35520g();
        if (g != this) {
            return g.toString();
        }
        if ("<init>".equals(mo34407c())) {
            return "constructor (Kotlin reflection is not available)";
        }
        return "function " + mo34407c() + " (Kotlin reflection is not available)";
    }
}
