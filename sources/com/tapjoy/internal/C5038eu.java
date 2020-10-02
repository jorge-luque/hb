package com.tapjoy.internal;

import com.tapjoy.internal.C5003eh;

/* renamed from: com.tapjoy.internal.eu */
public final class C5038eu extends C5003eh {

    /* renamed from: c */
    public static final C5006ej f13645c = new C5040b();

    /* renamed from: d */
    public static final Integer f13646d = 0;

    /* renamed from: e */
    public final String f13647e;

    /* renamed from: f */
    public final Integer f13648f;

    /* renamed from: g */
    public final String f13649g;

    /* renamed from: h */
    public final String f13650h;

    /* renamed from: i */
    public final String f13651i;

    /* renamed from: com.tapjoy.internal.eu$a */
    public static final class C5039a extends C5003eh.C5004a {

        /* renamed from: c */
        public String f13652c;

        /* renamed from: d */
        public Integer f13653d;

        /* renamed from: e */
        public String f13654e;

        /* renamed from: f */
        public String f13655f;

        /* renamed from: g */
        public String f13656g;

        /* renamed from: b */
        public final C5038eu mo31197b() {
            return new C5038eu(this.f13652c, this.f13653d, this.f13654e, this.f13655f, this.f13656g, super.mo31101a());
        }
    }

    public C5038eu(String str, Integer num, String str2, String str3, String str4, C5212iu iuVar) {
        super(f13645c, iuVar);
        this.f13647e = str;
        this.f13648f = num;
        this.f13649g = str2;
        this.f13650h = str3;
        this.f13651i = str4;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C5038eu)) {
            return false;
        }
        C5038eu euVar = (C5038eu) obj;
        return mo31097a().equals(euVar.mo31097a()) && C5026eo.m16987a((Object) this.f13647e, (Object) euVar.f13647e) && C5026eo.m16987a((Object) this.f13648f, (Object) euVar.f13648f) && C5026eo.m16987a((Object) this.f13649g, (Object) euVar.f13649g) && C5026eo.m16987a((Object) this.f13650h, (Object) euVar.f13650h) && C5026eo.m16987a((Object) this.f13651i, (Object) euVar.f13651i);
    }

    public final int hashCode() {
        int i = this.f13578b;
        if (i != 0) {
            return i;
        }
        int hashCode = mo31097a().hashCode() * 37;
        String str = this.f13647e;
        int i2 = 0;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 37;
        Integer num = this.f13648f;
        int hashCode3 = (hashCode2 + (num != null ? num.hashCode() : 0)) * 37;
        String str2 = this.f13649g;
        int hashCode4 = (hashCode3 + (str2 != null ? str2.hashCode() : 0)) * 37;
        String str3 = this.f13650h;
        int hashCode5 = (hashCode4 + (str3 != null ? str3.hashCode() : 0)) * 37;
        String str4 = this.f13651i;
        if (str4 != null) {
            i2 = str4.hashCode();
        }
        int i3 = hashCode5 + i2;
        this.f13578b = i3;
        return i3;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.f13647e != null) {
            sb.append(", pkgVer=");
            sb.append(this.f13647e);
        }
        if (this.f13648f != null) {
            sb.append(", pkgRev=");
            sb.append(this.f13648f);
        }
        if (this.f13649g != null) {
            sb.append(", dataVer=");
            sb.append(this.f13649g);
        }
        if (this.f13650h != null) {
            sb.append(", installer=");
            sb.append(this.f13650h);
        }
        if (this.f13651i != null) {
            sb.append(", store=");
            sb.append(this.f13651i);
        }
        StringBuilder replace = sb.replace(0, 2, "App{");
        replace.append('}');
        return replace.toString();
    }

    /* renamed from: com.tapjoy.internal.eu$b */
    static final class C5040b extends C5006ej {
        C5040b() {
            super(C5001eg.LENGTH_DELIMITED, C5038eu.class);
        }

        /* renamed from: a */
        public final /* synthetic */ int mo31092a(Object obj) {
            C5038eu euVar = (C5038eu) obj;
            String str = euVar.f13647e;
            int i = 0;
            int a = str != null ? C5006ej.f13596p.mo31102a(1, (Object) str) : 0;
            Integer num = euVar.f13648f;
            int a2 = a + (num != null ? C5006ej.f13584d.mo31102a(2, (Object) num) : 0);
            String str2 = euVar.f13649g;
            int a3 = a2 + (str2 != null ? C5006ej.f13596p.mo31102a(3, (Object) str2) : 0);
            String str3 = euVar.f13650h;
            int a4 = a3 + (str3 != null ? C5006ej.f13596p.mo31102a(4, (Object) str3) : 0);
            String str4 = euVar.f13651i;
            if (str4 != null) {
                i = C5006ej.f13596p.mo31102a(5, (Object) str4);
            }
            return a4 + i + euVar.mo31097a().mo31425c();
        }

        /* renamed from: a */
        public final /* bridge */ /* synthetic */ void mo31095a(C5023el elVar, Object obj) {
            C5038eu euVar = (C5038eu) obj;
            String str = euVar.f13647e;
            if (str != null) {
                C5006ej.f13596p.mo31106a(elVar, 1, str);
            }
            Integer num = euVar.f13648f;
            if (num != null) {
                C5006ej.f13584d.mo31106a(elVar, 2, num);
            }
            String str2 = euVar.f13649g;
            if (str2 != null) {
                C5006ej.f13596p.mo31106a(elVar, 3, str2);
            }
            String str3 = euVar.f13650h;
            if (str3 != null) {
                C5006ej.f13596p.mo31106a(elVar, 4, str3);
            }
            String str4 = euVar.f13651i;
            if (str4 != null) {
                C5006ej.f13596p.mo31106a(elVar, 5, str4);
            }
            elVar.mo31118a(euVar.mo31097a());
        }

        /* renamed from: a */
        public final /* synthetic */ Object mo31094a(C5022ek ekVar) {
            C5039a aVar = new C5039a();
            long a = ekVar.mo31109a();
            while (true) {
                int b = ekVar.mo31111b();
                if (b == -1) {
                    ekVar.mo31110a(a);
                    return aVar.mo31197b();
                } else if (b == 1) {
                    aVar.f13652c = (String) C5006ej.f13596p.mo31094a(ekVar);
                } else if (b == 2) {
                    aVar.f13653d = (Integer) C5006ej.f13584d.mo31094a(ekVar);
                } else if (b == 3) {
                    aVar.f13654e = (String) C5006ej.f13596p.mo31094a(ekVar);
                } else if (b == 4) {
                    aVar.f13655f = (String) C5006ej.f13596p.mo31094a(ekVar);
                } else if (b != 5) {
                    C5001eg c = ekVar.mo31112c();
                    aVar.mo31099a(b, c, c.mo31096a().mo31094a(ekVar));
                } else {
                    aVar.f13656g = (String) C5006ej.f13596p.mo31094a(ekVar);
                }
            }
        }
    }
}
