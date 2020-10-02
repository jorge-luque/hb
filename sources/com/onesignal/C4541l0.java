package com.onesignal;

import com.facebook.places.model.PlaceFields;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.onesignal.l0 */
/* compiled from: OSInAppMessageAction */
public class C4541l0 {

    /* renamed from: a */
    String f12411a;

    /* renamed from: b */
    public C4542a f12412b;

    /* renamed from: c */
    public String f12413c;

    /* renamed from: d */
    public List<C4626q0> f12414d = new ArrayList();

    /* renamed from: e */
    public List<C4636r0> f12415e = new ArrayList();

    /* renamed from: f */
    public C4654t0 f12416f;

    /* renamed from: g */
    public boolean f12417g;

    /* renamed from: com.onesignal.l0$a */
    /* compiled from: OSInAppMessageAction */
    public enum C4542a {
        IN_APP_WEBVIEW("webview"),
        BROWSER("browser"),
        REPLACE_CONTENT("replacement");
        

        /* renamed from: a */
        private String f12422a;

        private C4542a(String str) {
            this.f12422a = str;
        }

        /* renamed from: a */
        public static C4542a[] m15661a() {
            return (C4542a[]) f12421e.clone();
        }

        public String toString() {
            return this.f12422a;
        }

        /* renamed from: a */
        public static C4542a m15660a(String str) {
            for (C4542a aVar : m15661a()) {
                if (aVar.f12422a.equalsIgnoreCase(str)) {
                    return aVar;
                }
            }
            return null;
        }
    }

    C4541l0(JSONObject jSONObject) throws JSONException {
        this.f12411a = jSONObject.optString("id", (String) null);
        jSONObject.optString("name", (String) null);
        this.f12413c = jSONObject.optString("url", (String) null);
        C4542a a = C4542a.m15660a(jSONObject.optString("url_target", (String) null));
        this.f12412b = a;
        if (a == null) {
            this.f12412b = C4542a.IN_APP_WEBVIEW;
        }
        jSONObject.optBoolean("close", true);
        if (jSONObject.has("outcomes")) {
            m15658a(jSONObject);
        }
        if (jSONObject.has("tags")) {
            this.f12416f = new C4654t0(jSONObject.getJSONObject("tags"));
        }
        if (jSONObject.has("prompts")) {
            m15659b(jSONObject);
        }
    }

    /* renamed from: a */
    private void m15658a(JSONObject jSONObject) throws JSONException {
        JSONArray jSONArray = jSONObject.getJSONArray("outcomes");
        for (int i = 0; i < jSONArray.length(); i++) {
            this.f12414d.add(new C4626q0((JSONObject) jSONArray.get(i)));
        }
    }

    /* renamed from: b */
    private void m15659b(JSONObject jSONObject) throws JSONException {
        JSONArray jSONArray = jSONObject.getJSONArray("prompts");
        for (int i = 0; i < jSONArray.length(); i++) {
            if (jSONArray.get(i).equals(PlaceFields.LOCATION)) {
                this.f12415e.add(new C4613p0());
            }
        }
    }
}
