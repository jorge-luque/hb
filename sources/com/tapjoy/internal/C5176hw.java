package com.tapjoy.internal;

/* renamed from: com.tapjoy.internal.hw */
final class C5176hw extends C3157ho implements C5127gp {

    /* renamed from: a */
    public static final C4911bi f14180a = new C4911bi() {
        /* renamed from: a */
        public final /* synthetic */ Object mo18614a(C3126bn bnVar) {
            bnVar.mo18492h();
            String str = "";
            String str2 = str;
            while (bnVar.mo18494j()) {
                String l = bnVar.mo18496l();
                if ("campaign_id".equals(l)) {
                    str = bnVar.mo18482c("");
                } else if ("product_id".equals(l)) {
                    str2 = bnVar.mo18482c("");
                } else {
                    bnVar.mo18503s();
                }
            }
            bnVar.mo18493i();
            return new C5176hw(str, str2);
        }
    };

    /* renamed from: b */
    private final String f14181b;

    /* renamed from: c */
    private final String f14182c;

    C5176hw(String str, String str2) {
        this.f14181b = str;
        this.f14182c = str2;
    }

    /* renamed from: a */
    public final String mo31305a() {
        return this.f14181b;
    }

    /* renamed from: b */
    public final String mo31306b() {
        return this.f14182c;
    }
}
