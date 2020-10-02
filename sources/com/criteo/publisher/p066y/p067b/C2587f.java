package com.criteo.publisher.p066y.p067b;

import com.criteo.publisher.p054a0.C2343r;

/* renamed from: com.criteo.publisher.y.b.f */
class C2587f implements C2588g {

    /* renamed from: a */
    private final C2343r f8162a;

    public C2587f(C2343r rVar) {
        this.f8162a = rVar;
    }

    /* renamed from: a */
    public Integer mo10646a() {
        return 2;
    }

    /* renamed from: b */
    public String mo10647b() {
        int a = this.f8162a.mo10164a("IABTCF_gdprApplies", -1);
        return a != -1 ? String.valueOf(a) : "";
    }

    /* renamed from: c */
    public String mo10648c() {
        return this.f8162a.mo10165a("IABTCF_TCString", "");
    }

    /* renamed from: d */
    public boolean mo10650d() {
        return !mo10647b().isEmpty() || !mo10648c().isEmpty();
    }
}
