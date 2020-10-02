package com.onesignal;

import org.json.JSONObject;

/* renamed from: com.onesignal.g1 */
/* compiled from: OSSubscriptionStateChanges */
public class C4512g1 {

    /* renamed from: a */
    OSSubscriptionState f12345a;

    /* renamed from: b */
    OSSubscriptionState f12346b;

    /* renamed from: a */
    public OSSubscriptionState mo29776a() {
        return this.f12345a;
    }

    /* renamed from: b */
    public JSONObject mo29777b() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("from", this.f12346b.mo29677e());
            jSONObject.put("to", this.f12345a.mo29677e());
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return jSONObject;
    }

    public String toString() {
        return mo29777b().toString();
    }
}
