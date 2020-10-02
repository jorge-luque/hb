package com.onesignal;

import org.json.JSONObject;

/* renamed from: com.onesignal.b1 */
/* compiled from: OSPermissionSubscriptionState */
public class C4477b1 {

    /* renamed from: a */
    OSSubscriptionState f12291a;

    /* renamed from: b */
    C4741z0 f12292b;

    /* renamed from: c */
    C4529j0 f12293c;

    /* renamed from: a */
    public OSSubscriptionState mo29720a() {
        return this.f12291a;
    }

    /* renamed from: b */
    public JSONObject mo29721b() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("permissionStatus", this.f12292b.mo30043d());
            jSONObject.put("subscriptionStatus", this.f12291a.mo29677e());
            jSONObject.put("emailSubscriptionStatus", this.f12293c.mo29801b());
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return jSONObject;
    }

    public String toString() {
        return mo29721b().toString();
    }
}
