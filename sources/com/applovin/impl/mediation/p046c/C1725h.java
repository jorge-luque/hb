package com.applovin.impl.mediation.p046c;

import com.applovin.impl.mediation.p045b.C1699c;
import com.applovin.impl.sdk.C1941j;
import com.applovin.impl.sdk.p048a.C1814c;
import com.applovin.impl.sdk.p052d.C1873af;
import com.applovin.impl.sdk.utils.C1993i;
import com.applovin.impl.sdk.utils.C2025o;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.mediation.c.h */
public class C1725h extends C1873af {

    /* renamed from: a */
    private final C1699c f5365a;

    public C1725h(C1699c cVar, C1941j jVar) {
        super("TaskValidateMaxReward", jVar);
        this.f5365a = cVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public String mo7866a() {
        return "2.0/mvr";
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo7867a(int i) {
        super.mo7867a(i);
        this.f5365a.mo7795a(C1814c.m6808a((i < 400 || i >= 500) ? "network_timeout" : "rejected"));
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo7872a(C1814c cVar) {
        this.f5365a.mo7795a(cVar);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo7868a(JSONObject jSONObject) {
        C1993i.m7886a(jSONObject, "ad_unit_id", this.f5365a.getAdUnitId(), this.f6217b);
        C1993i.m7886a(jSONObject, "placement", this.f5365a.mo7820L(), this.f6217b);
        String t = this.f5365a.mo7803t();
        if (!C2025o.m7963b(t)) {
            t = "NO_MCODE";
        }
        C1993i.m7886a(jSONObject, "mcode", t, this.f6217b);
        String s = this.f5365a.mo7802s();
        if (!C2025o.m7963b(s)) {
            s = "NO_BCODE";
        }
        C1993i.m7886a(jSONObject, "bcode", s, this.f6217b);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public boolean mo7873b() {
        return this.f5365a.mo7804u();
    }
}
