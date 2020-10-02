package com.onesignal;

import org.json.JSONObject;

/* renamed from: com.onesignal.a1 */
/* compiled from: OSPermissionStateChanges */
public class C4468a1 {

    /* renamed from: a */
    C4741z0 f12280a;

    /* renamed from: b */
    C4741z0 f12281b;

    /* renamed from: a */
    public JSONObject mo29705a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("from", this.f12281b.mo30043d());
            jSONObject.put("to", this.f12280a.mo30043d());
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return jSONObject;
    }

    public String toString() {
        return mo29705a().toString();
    }
}
