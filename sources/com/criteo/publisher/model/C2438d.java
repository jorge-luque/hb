package com.criteo.publisher.model;

/* renamed from: com.criteo.publisher.model.d */
abstract class C2438d extends C2466x {

    /* renamed from: a */
    private final String f7867a;

    /* renamed from: b */
    private final String f7868b;

    /* renamed from: c */
    private final String f7869c;

    /* renamed from: d */
    private final String f7870d;

    /* renamed from: e */
    private final String f7871e;

    /* renamed from: f */
    private final String f7872f;

    C2438d(String str, String str2, String str3, String str4, String str5, String str6) {
        this.f7867a = str;
        if (str2 != null) {
            this.f7868b = str2;
            if (str3 != null) {
                this.f7869c = str3;
                this.f7870d = str4;
                this.f7871e = str5;
                this.f7872f = str6;
                return;
            }
            throw new NullPointerException("Null deviceOs");
        }
        throw new NullPointerException("Null deviceIdType");
    }

    /* renamed from: a */
    public String mo10343a() {
        return this.f7867a;
    }

    /* renamed from: b */
    public String mo10344b() {
        return this.f7868b;
    }

    /* renamed from: c */
    public String mo10345c() {
        return this.f7869c;
    }

    /* renamed from: d */
    public String mo10346d() {
        return this.f7870d;
    }

    public boolean equals(Object obj) {
        String str;
        String str2;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C2466x)) {
            return false;
        }
        C2466x xVar = (C2466x) obj;
        String str3 = this.f7867a;
        if (str3 != null ? str3.equals(xVar.mo10343a()) : xVar.mo10343a() == null) {
            if (this.f7868b.equals(xVar.mo10344b()) && this.f7869c.equals(xVar.mo10345c()) && ((str = this.f7870d) != null ? str.equals(xVar.mo10346d()) : xVar.mo10346d() == null) && ((str2 = this.f7871e) != null ? str2.equals(xVar.mo10348f()) : xVar.mo10348f() == null)) {
                String str4 = this.f7872f;
                if (str4 == null) {
                    if (xVar.mo10349g() == null) {
                        return true;
                    }
                } else if (str4.equals(xVar.mo10349g())) {
                    return true;
                }
            }
        }
        return false;
    }

    /* renamed from: f */
    public String mo10348f() {
        return this.f7871e;
    }

    /* renamed from: g */
    public String mo10349g() {
        return this.f7872f;
    }

    public int hashCode() {
        String str = this.f7867a;
        int i = 0;
        int hashCode = ((((((str == null ? 0 : str.hashCode()) ^ 1000003) * 1000003) ^ this.f7868b.hashCode()) * 1000003) ^ this.f7869c.hashCode()) * 1000003;
        String str2 = this.f7870d;
        int hashCode2 = (hashCode ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
        String str3 = this.f7871e;
        int hashCode3 = (hashCode2 ^ (str3 == null ? 0 : str3.hashCode())) * 1000003;
        String str4 = this.f7872f;
        if (str4 != null) {
            i = str4.hashCode();
        }
        return hashCode3 ^ i;
    }

    public String toString() {
        return "User{deviceId=" + this.f7867a + ", deviceIdType=" + this.f7868b + ", deviceOs=" + this.f7869c + ", mopubConsent=" + this.f7870d + ", uspIab=" + this.f7871e + ", uspOptout=" + this.f7872f + "}";
    }
}
