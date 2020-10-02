package com.onesignal;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.onesignal.t0 */
/* compiled from: OSInAppMessageTag */
public class C4654t0 {

    /* renamed from: a */
    private JSONObject f12659a;

    /* renamed from: b */
    private JSONArray f12660b;

    C4654t0(JSONObject jSONObject) throws JSONException {
        JSONArray jSONArray = null;
        this.f12659a = jSONObject.has("adds") ? jSONObject.getJSONObject("adds") : null;
        this.f12660b = jSONObject.has("removes") ? jSONObject.getJSONArray("removes") : jSONArray;
    }

    /* renamed from: a */
    public JSONObject mo29960a() {
        return this.f12659a;
    }

    /* renamed from: b */
    public JSONArray mo29961b() {
        return this.f12660b;
    }

    public String toString() {
        return "OSInAppMessageTag{adds=" + this.f12659a + ", removes=" + this.f12660b + '}';
    }
}
