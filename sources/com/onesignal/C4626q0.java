package com.onesignal;

import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.onesignal.q0 */
/* compiled from: OSInAppMessageOutcome */
public class C4626q0 {

    /* renamed from: a */
    private String f12615a;

    /* renamed from: b */
    private float f12616b;

    /* renamed from: c */
    private boolean f12617c;

    C4626q0(JSONObject jSONObject) throws JSONException {
        this.f12615a = jSONObject.getString("name");
        this.f12616b = jSONObject.has("weight") ? (float) jSONObject.getDouble("weight") : 0.0f;
        this.f12617c = jSONObject.has("unique") && jSONObject.getBoolean("unique");
    }

    /* renamed from: a */
    public String mo29919a() {
        return this.f12615a;
    }

    /* renamed from: b */
    public float mo29920b() {
        return this.f12616b;
    }

    /* renamed from: c */
    public boolean mo29921c() {
        return this.f12617c;
    }

    public String toString() {
        return "OSInAppMessageOutcome{name='" + this.f12615a + '\'' + ", weight=" + this.f12616b + ", unique=" + this.f12617c + '}';
    }
}
