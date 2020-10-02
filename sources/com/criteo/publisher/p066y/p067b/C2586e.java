package com.criteo.publisher.p066y.p067b;

import com.criteo.publisher.p054a0.C2343r;

/* renamed from: com.criteo.publisher.y.b.e */
class C2586e implements C2588g {

    /* renamed from: a */
    private final C2343r f8161a;

    public C2586e(C2343r rVar) {
        this.f8161a = rVar;
    }

    /* renamed from: a */
    public Integer mo10646a() {
        return 1;
    }

    /* renamed from: b */
    public String mo10647b() {
        return this.f8161a.mo10165a("IABConsent_SubjectToGDPR", "");
    }

    /* renamed from: c */
    public String mo10648c() {
        return this.f8161a.mo10165a("IABConsent_ConsentString", "");
    }

    /* renamed from: d */
    public boolean mo10649d() {
        return !mo10647b().isEmpty() || !mo10648c().isEmpty();
    }
}
