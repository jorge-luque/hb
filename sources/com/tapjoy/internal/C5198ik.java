package com.tapjoy.internal;

import com.tapjoy.internal.C5044ew;
import java.util.Map;

/* renamed from: com.tapjoy.internal.ik */
public final class C5198ik extends C3164ii {

    /* renamed from: c */
    private final C5044ew.C5045a f14266c = new C5044ew.C5045a();

    /* renamed from: d */
    private C5050ey f14267d = null;

    /* renamed from: a */
    public final boolean mo31372a(C5041ev evVar) {
        C5050ey eyVar = this.f14267d;
        if (eyVar == null) {
            this.f14267d = evVar.f13680n;
        } else if (evVar.f13680n != eyVar) {
            return false;
        }
        this.f14266c.f13720c.add(evVar);
        return true;
    }

    /* renamed from: c */
    public final String mo18509c() {
        return this.f14267d == C5050ey.USAGES ? "api/v1/usages" : "api/v1/cevs";
    }

    /* renamed from: e */
    public final Map mo18511e() {
        Map e = super.mo18511e();
        e.put("events", new C4917bm(C5164hp.m17391a(this.f14266c.mo31203b())));
        return e;
    }

    /* renamed from: g */
    public final int mo31373g() {
        return this.f14266c.f13720c.size();
    }
}
