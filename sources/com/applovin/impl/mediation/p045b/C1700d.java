package com.applovin.impl.mediation.p045b;

import com.applovin.impl.mediation.C1743j;
import com.applovin.impl.sdk.C1941j;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.mediation.b.d */
public class C1700d extends C1697a {
    private C1700d(C1700d dVar, C1743j jVar) {
        super(dVar.mo7811C(), dVar.mo7810B(), jVar, dVar.f5302b);
    }

    public C1700d(JSONObject jSONObject, JSONObject jSONObject2, C1941j jVar) {
        super(jSONObject, jSONObject2, (C1743j) null, jVar);
    }

    /* renamed from: a */
    public C1697a mo7764a(C1743j jVar) {
        return new C1700d(this, jVar);
    }
}
