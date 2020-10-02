package com.tapjoy.internal;

/* renamed from: com.tapjoy.internal.hy */
final class C5180hy extends C3157ho implements C5128gq {

    /* renamed from: a */
    public static final C4911bi f14189a = new C4911bi() {
        /* renamed from: a */
        public final /* synthetic */ Object mo18614a(C3126bn bnVar) {
            bnVar.mo18492h();
            String str = null;
            String str2 = null;
            String str3 = null;
            int i = 1;
            while (bnVar.mo18494j()) {
                String l = bnVar.mo18496l();
                if ("id".equals(l)) {
                    str = bnVar.mo18497m();
                } else if ("name".equals(l)) {
                    str2 = bnVar.mo18497m();
                } else if ("quantity".equals(l)) {
                    i = bnVar.mo18502r();
                } else if ("token".equals(l)) {
                    str3 = bnVar.mo18497m();
                } else {
                    bnVar.mo18503s();
                }
            }
            bnVar.mo18493i();
            return new C5180hy(str, str2, i, str3);
        }
    };

    /* renamed from: b */
    private final String f14190b;

    /* renamed from: c */
    private final String f14191c;

    /* renamed from: d */
    private final int f14192d;

    /* renamed from: e */
    private final String f14193e;

    C5180hy(String str, String str2, int i, String str3) {
        this.f14190b = str;
        this.f14191c = str2;
        this.f14192d = i;
        this.f14193e = str3;
    }

    /* renamed from: a */
    public final String mo31307a() {
        return this.f14190b;
    }

    /* renamed from: b */
    public final String mo31308b() {
        return this.f14191c;
    }

    /* renamed from: c */
    public final int mo31309c() {
        return this.f14192d;
    }

    /* renamed from: d */
    public final String mo31310d() {
        return this.f14193e;
    }
}
