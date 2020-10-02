package p093e.p101c.p102a.p103a.p104i.p107v.p108j;

import p093e.p101c.p102a.p103a.p104i.C3400h;
import p093e.p101c.p102a.p103a.p104i.C3406l;

/* renamed from: e.c.a.a.i.v.j.b */
/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
final class C3433b extends C3446h {

    /* renamed from: a */
    private final long f9544a;

    /* renamed from: b */
    private final C3406l f9545b;

    /* renamed from: c */
    private final C3400h f9546c;

    C3433b(long j, C3406l lVar, C3400h hVar) {
        this.f9544a = j;
        if (lVar != null) {
            this.f9545b = lVar;
            if (hVar != null) {
                this.f9546c = hVar;
                return;
            }
            throw new NullPointerException("Null event");
        }
        throw new NullPointerException("Null transportContext");
    }

    /* renamed from: a */
    public C3400h mo19232a() {
        return this.f9546c;
    }

    /* renamed from: b */
    public long mo19233b() {
        return this.f9544a;
    }

    /* renamed from: c */
    public C3406l mo19234c() {
        return this.f9545b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C3446h)) {
            return false;
        }
        C3446h hVar = (C3446h) obj;
        if (this.f9544a != hVar.mo19233b() || !this.f9545b.equals(hVar.mo19234c()) || !this.f9546c.equals(hVar.mo19232a())) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        long j = this.f9544a;
        return this.f9546c.hashCode() ^ ((((((int) (j ^ (j >>> 32))) ^ 1000003) * 1000003) ^ this.f9545b.hashCode()) * 1000003);
    }

    public String toString() {
        return "PersistedEvent{id=" + this.f9544a + ", transportContext=" + this.f9545b + ", event=" + this.f9546c + "}";
    }
}
