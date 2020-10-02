package com.applovin.impl.mediation.p046c;

import com.applovin.impl.mediation.p045b.C1699c;
import com.applovin.impl.sdk.C1941j;
import com.applovin.impl.sdk.p048a.C1814c;
import com.applovin.impl.sdk.p052d.C1865aa;
import com.applovin.impl.sdk.utils.C1993i;
import com.applovin.impl.sdk.utils.C2025o;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.mediation.c.g */
public class C1724g extends C1865aa {

    /* renamed from: a */
    private final C1699c f5364a;

    public C1724g(C1699c cVar, C1941j jVar) {
        super("TaskReportMaxReward", jVar);
        this.f5364a = cVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public String mo7866a() {
        return "2.0/mcr";
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo7867a(int i) {
        super.mo7867a(i);
        mo8405a("Failed to report reward for mediated ad: " + this.f5364a + " - error code: " + i);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo7868a(JSONObject jSONObject) {
        C1993i.m7886a(jSONObject, "ad_unit_id", this.f5364a.getAdUnitId(), this.f6217b);
        C1993i.m7886a(jSONObject, "placement", this.f5364a.mo7820L(), this.f6217b);
        String t = this.f5364a.mo7803t();
        if (!C2025o.m7963b(t)) {
            t = "NO_MCODE";
        }
        C1993i.m7886a(jSONObject, "mcode", t, this.f6217b);
        String s = this.f5364a.mo7802s();
        if (!C2025o.m7963b(s)) {
            s = "NO_BCODE";
        }
        C1993i.m7886a(jSONObject, "bcode", s, this.f6217b);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public C1814c mo7869b() {
        return this.f5364a.mo7806w();
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo7870b(JSONObject jSONObject) {
        mo8405a("Reported reward successfully for mediated ad: " + this.f5364a);
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public void mo7871c() {
        mo8410d("No reward result was found for mediated ad: " + this.f5364a);
    }
}
