package com.chartboost.sdk.impl;

import com.chartboost.sdk.Model.C2090e;
import com.chartboost.sdk.Model.C2091f;
import com.chartboost.sdk.Model.CBError;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.chartboost.sdk.impl.e1 */
public class C2137e1 extends C2128c1 {
    public C2137e1(C2090e eVar, C2196p0 p0Var) {
        super(eVar.f6947a, eVar.f6948b, eVar.f6949c, eVar.f6950d, eVar.f6951e, eVar.f6952f);
        this.f7128k = new C2091f(eVar.f6949c, p0Var).mo9151a();
    }

    /* renamed from: a */
    public C2212t0<JSONObject> mo9290a(C2215u0 u0Var) {
        byte[] bArr = u0Var.f7465b;
        if (bArr == null) {
            return C2212t0.m8773a(new CBError(CBError.C2085b.INVALID_RESPONSE, "Response is not a valid json object"));
        }
        try {
            return C2212t0.m8774a(new JSONObject(new String(bArr)));
        } catch (JSONException unused) {
            return C2212t0.m8773a(new CBError(CBError.C2085b.MISCELLANEOUS, "No Bid"));
        }
    }

    /* renamed from: c */
    public void mo9296c() {
    }
}
