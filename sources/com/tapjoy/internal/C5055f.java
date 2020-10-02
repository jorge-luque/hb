package com.tapjoy.internal;

/* renamed from: com.tapjoy.internal.f */
public final class C5055f {

    /* renamed from: a */
    public String f13737a;

    /* renamed from: b */
    public String f13738b;

    /* renamed from: c */
    public String f13739c;

    /* renamed from: d */
    public long f13740d;

    /* renamed from: e */
    public int f13741e;

    /* renamed from: f */
    public String f13742f;

    /* renamed from: g */
    public String f13743g;

    public C5055f(String str) {
        C3126bn b = C3126bn.m10231b(str);
        b.mo18492h();
        while (b.mo18494j()) {
            String l = b.mo18496l();
            if ("orderId".equals(l)) {
                this.f13737a = b.mo18497m();
            } else if ("packageName".equals(l)) {
                this.f13738b = b.mo18497m();
            } else if ("productId".equals(l)) {
                this.f13739c = b.mo18497m();
            } else if ("purchaseTime".equals(l)) {
                this.f13740d = b.mo18501q();
            } else if ("purchaseState".equals(l)) {
                this.f13741e = b.mo18502r();
            } else if ("developerPayload".equals(l)) {
                this.f13742f = b.mo18497m();
            } else if ("purchaseToken".equals(l)) {
                this.f13743g = b.mo18497m();
            } else {
                b.mo18503s();
            }
        }
        b.mo18493i();
    }
}
