package com.tapjoy.internal;

import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tapjoy.internal.db */
public final class C4957db {

    /* renamed from: a */
    private final boolean f13478a = false;

    /* renamed from: b */
    private final Float f13479b = null;

    /* renamed from: c */
    private final boolean f13480c = false;

    /* renamed from: d */
    private final C4956da f13481d;

    private C4957db(C4956da daVar) {
        this.f13481d = daVar;
    }

    /* renamed from: a */
    public static C4957db m16801a(C4956da daVar) {
        C4975do.m16853a((Object) daVar, "Position is null");
        return new C4957db(daVar);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final JSONObject mo31043a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("skippable", this.f13478a);
            if (this.f13478a) {
                jSONObject.put("skipOffset", this.f13479b);
            }
            jSONObject.put("autoPlay", this.f13480c);
            jSONObject.put("position", this.f13481d);
        } catch (JSONException e) {
            C4974dn.m16851a("VastProperties: JSON error", e);
        }
        return jSONObject;
    }
}
