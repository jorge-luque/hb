package com.tapjoy.internal;

import com.tapjoy.internal.C5003eh;

/* renamed from: com.tapjoy.internal.fc */
public final class C5062fc extends C5003eh {

    /* renamed from: c */
    public static final C5006ej f13791c = new C5064b();

    /* renamed from: d */
    public final String f13792d;

    /* renamed from: e */
    public final String f13793e;

    /* renamed from: f */
    public final String f13794f;

    /* renamed from: com.tapjoy.internal.fc$a */
    public static final class C5063a extends C5003eh.C5004a {

        /* renamed from: c */
        public String f13795c;

        /* renamed from: d */
        public String f13796d;

        /* renamed from: e */
        public String f13797e;

        /* renamed from: b */
        public final C5062fc mo31218b() {
            return new C5062fc(this.f13795c, this.f13796d, this.f13797e, super.mo31101a());
        }
    }

    public C5062fc(String str, String str2, String str3) {
        this(str, str2, str3, C5212iu.f14313b);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C5062fc)) {
            return false;
        }
        C5062fc fcVar = (C5062fc) obj;
        return mo31097a().equals(fcVar.mo31097a()) && C5026eo.m16987a((Object) this.f13792d, (Object) fcVar.f13792d) && C5026eo.m16987a((Object) this.f13793e, (Object) fcVar.f13793e) && C5026eo.m16987a((Object) this.f13794f, (Object) fcVar.f13794f);
    }

    public final int hashCode() {
        int i = this.f13578b;
        if (i != 0) {
            return i;
        }
        int hashCode = mo31097a().hashCode() * 37;
        String str = this.f13792d;
        int i2 = 0;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 37;
        String str2 = this.f13793e;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 37;
        String str3 = this.f13794f;
        if (str3 != null) {
            i2 = str3.hashCode();
        }
        int i3 = hashCode3 + i2;
        this.f13578b = i3;
        return i3;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.f13792d != null) {
            sb.append(", fq7Change=");
            sb.append(this.f13792d);
        }
        if (this.f13793e != null) {
            sb.append(", fq30Change=");
            sb.append(this.f13793e);
        }
        if (this.f13794f != null) {
            sb.append(", pushId=");
            sb.append(this.f13794f);
        }
        StringBuilder replace = sb.replace(0, 2, "Meta{");
        replace.append('}');
        return replace.toString();
    }

    public C5062fc(String str, String str2, String str3, C5212iu iuVar) {
        super(f13791c, iuVar);
        this.f13792d = str;
        this.f13793e = str2;
        this.f13794f = str3;
    }

    /* renamed from: com.tapjoy.internal.fc$b */
    static final class C5064b extends C5006ej {
        C5064b() {
            super(C5001eg.LENGTH_DELIMITED, C5062fc.class);
        }

        /* renamed from: a */
        public final /* synthetic */ int mo31092a(Object obj) {
            C5062fc fcVar = (C5062fc) obj;
            String str = fcVar.f13792d;
            int i = 0;
            int a = str != null ? C5006ej.f13596p.mo31102a(1, (Object) str) : 0;
            String str2 = fcVar.f13793e;
            int a2 = a + (str2 != null ? C5006ej.f13596p.mo31102a(2, (Object) str2) : 0);
            String str3 = fcVar.f13794f;
            if (str3 != null) {
                i = C5006ej.f13596p.mo31102a(3, (Object) str3);
            }
            return a2 + i + fcVar.mo31097a().mo31425c();
        }

        /* renamed from: a */
        public final /* bridge */ /* synthetic */ void mo31095a(C5023el elVar, Object obj) {
            C5062fc fcVar = (C5062fc) obj;
            String str = fcVar.f13792d;
            if (str != null) {
                C5006ej.f13596p.mo31106a(elVar, 1, str);
            }
            String str2 = fcVar.f13793e;
            if (str2 != null) {
                C5006ej.f13596p.mo31106a(elVar, 2, str2);
            }
            String str3 = fcVar.f13794f;
            if (str3 != null) {
                C5006ej.f13596p.mo31106a(elVar, 3, str3);
            }
            elVar.mo31118a(fcVar.mo31097a());
        }

        /* renamed from: a */
        public final /* synthetic */ Object mo31094a(C5022ek ekVar) {
            C5063a aVar = new C5063a();
            long a = ekVar.mo31109a();
            while (true) {
                int b = ekVar.mo31111b();
                if (b == -1) {
                    ekVar.mo31110a(a);
                    return aVar.mo31218b();
                } else if (b == 1) {
                    aVar.f13795c = (String) C5006ej.f13596p.mo31094a(ekVar);
                } else if (b == 2) {
                    aVar.f13796d = (String) C5006ej.f13596p.mo31094a(ekVar);
                } else if (b != 3) {
                    C5001eg c = ekVar.mo31112c();
                    aVar.mo31099a(b, c, c.mo31096a().mo31094a(ekVar));
                } else {
                    aVar.f13797e = (String) C5006ej.f13596p.mo31094a(ekVar);
                }
            }
        }
    }
}
