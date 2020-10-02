package com.applovin.impl.sdk.p052d;

import com.applovin.impl.sdk.C1941j;
import com.applovin.impl.sdk.p048a.C1814c;
import com.applovin.impl.sdk.p049ad.C1827g;
import com.applovin.impl.sdk.utils.C1993i;
import com.applovin.impl.sdk.utils.C2025o;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.sdk.d.z */
public class C1923z extends C1865aa {

    /* renamed from: a */
    private final C1827g f6358a;

    public C1923z(C1827g gVar, C1941j jVar) {
        super("TaskReportAppLovinReward", jVar);
        this.f6358a = gVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public String mo7866a() {
        return "2.0/cr";
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo7867a(int i) {
        super.mo7867a(i);
        mo8410d("Failed to report reward for ad: " + this.f6358a + " - error code: " + i);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo7868a(JSONObject jSONObject) {
        C1993i.m7886a(jSONObject, "zone_id", this.f6358a.getAdZone().mo8174a(), this.f6217b);
        C1993i.m7884a(jSONObject, "fire_percent", this.f6358a.mo8260an(), this.f6217b);
        String clCode = this.f6358a.getClCode();
        if (!C2025o.m7963b(clCode)) {
            clCode = "NO_CLCODE";
        }
        C1993i.m7886a(jSONObject, "clcode", clCode, this.f6217b);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public C1814c mo7869b() {
        return this.f6358a.mo8245aO();
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo7870b(JSONObject jSONObject) {
        mo8405a("Reported reward successfully for ad: " + this.f6358a);
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public void mo7871c() {
        mo8410d("No reward result was found for ad: " + this.f6358a);
    }
}
