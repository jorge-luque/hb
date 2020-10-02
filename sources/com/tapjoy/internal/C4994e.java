package com.tapjoy.internal;

/* renamed from: com.tapjoy.internal.e */
public final class C4994e {

    /* renamed from: a */
    public String f13557a;

    /* renamed from: b */
    public String f13558b;

    /* renamed from: c */
    public String f13559c;

    /* renamed from: d */
    public String f13560d;

    /* renamed from: e */
    public String f13561e;

    /* renamed from: f */
    public String f13562f;

    /* renamed from: g */
    public long f13563g;

    public C4994e(String str) {
        C3126bn b = C3126bn.m10231b(str);
        b.mo18492h();
        while (b.mo18494j()) {
            String l = b.mo18496l();
            if ("productId".equals(l)) {
                this.f13557a = b.mo18497m();
            } else if ("type".equals(l)) {
                this.f13558b = b.mo18497m();
            } else if ("price".equals(l)) {
                this.f13559c = b.mo18497m();
            } else if ("title".equals(l)) {
                this.f13560d = b.mo18497m();
            } else if ("description".equals(l)) {
                this.f13561e = b.mo18497m();
            } else if ("price_currency_code".equals(l)) {
                this.f13562f = b.mo18497m();
            } else if ("price_amount_micros".equals(l)) {
                this.f13563g = b.mo18501q();
            } else {
                b.mo18503s();
            }
        }
        b.mo18493i();
    }
}
