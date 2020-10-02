package com.criteo.publisher.p066y.p067b;

/* renamed from: com.criteo.publisher.y.b.a */
abstract class C2581a extends C2584c {

    /* renamed from: a */
    private final String f8153a;

    /* renamed from: b */
    private final Boolean f8154b;

    /* renamed from: c */
    private final Integer f8155c;

    C2581a(String str, Boolean bool, Integer num) {
        if (str != null) {
            this.f8153a = str;
            this.f8154b = bool;
            if (num != null) {
                this.f8155c = num;
                return;
            }
            throw new NullPointerException("Null version");
        }
        throw new NullPointerException("Null consentData");
    }

    /* renamed from: a */
    public String mo10636a() {
        return this.f8153a;
    }

    /* renamed from: b */
    public Boolean mo10637b() {
        return this.f8154b;
    }

    /* renamed from: d */
    public Integer mo10638d() {
        return this.f8155c;
    }

    public boolean equals(Object obj) {
        Boolean bool;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C2584c)) {
            return false;
        }
        C2584c cVar = (C2584c) obj;
        if (!this.f8153a.equals(cVar.mo10636a()) || ((bool = this.f8154b) != null ? !bool.equals(cVar.mo10637b()) : cVar.mo10637b() != null) || !this.f8155c.equals(cVar.mo10638d())) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int hashCode = (this.f8153a.hashCode() ^ 1000003) * 1000003;
        Boolean bool = this.f8154b;
        return ((hashCode ^ (bool == null ? 0 : bool.hashCode())) * 1000003) ^ this.f8155c.hashCode();
    }

    public String toString() {
        return "GdprData{consentData=" + this.f8153a + ", gdprApplies=" + this.f8154b + ", version=" + this.f8155c + "}";
    }
}
