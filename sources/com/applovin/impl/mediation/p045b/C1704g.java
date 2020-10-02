package com.applovin.impl.mediation.p045b;

import com.applovin.impl.sdk.C1941j;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.mediation.b.g */
public class C1704g extends C1701e {
    public C1704g(JSONObject jSONObject, JSONObject jSONObject2, C1941j jVar) {
        super(jSONObject, jSONObject2, jVar);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public int mo7765a() {
        return mo7830b("max_signal_length", 2048);
    }

    /* renamed from: b */
    public boolean mo7849b() {
        return mo7836b("only_collect_signal_when_initialized", (Boolean) false);
    }

    public String toString() {
        return "SignalProviderSpec{specObject=" + mo7811C() + '}';
    }
}
