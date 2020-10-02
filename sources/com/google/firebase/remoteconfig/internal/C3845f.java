package com.google.firebase.remoteconfig.internal;

import java.util.Date;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.google.firebase.remoteconfig.internal.f */
/* compiled from: com.google.firebase:firebase-config@@19.1.4 */
public class C3845f {
    /* access modifiers changed from: private */

    /* renamed from: e */
    public static final Date f10619e = new Date(0);

    /* renamed from: a */
    private JSONObject f10620a;

    /* renamed from: b */
    private JSONObject f10621b;

    /* renamed from: c */
    private Date f10622c;

    /* renamed from: d */
    private JSONArray f10623d;

    /* renamed from: com.google.firebase.remoteconfig.internal.f$b */
    /* compiled from: com.google.firebase:firebase-config@@19.1.4 */
    public static class C3847b {

        /* renamed from: a */
        private JSONObject f10624a;

        /* renamed from: b */
        private Date f10625b;

        /* renamed from: c */
        private JSONArray f10626c;

        /* renamed from: a */
        public C3847b mo27575a(Map<String, String> map) {
            this.f10624a = new JSONObject(map);
            return this;
        }

        private C3847b() {
            this.f10624a = new JSONObject();
            this.f10625b = C3845f.f10619e;
            this.f10626c = new JSONArray();
        }

        /* renamed from: a */
        public C3847b mo27577a(JSONObject jSONObject) {
            try {
                this.f10624a = new JSONObject(jSONObject.toString());
            } catch (JSONException unused) {
            }
            return this;
        }

        /* renamed from: a */
        public C3847b mo27574a(Date date) {
            this.f10625b = date;
            return this;
        }

        /* renamed from: a */
        public C3847b mo27576a(JSONArray jSONArray) {
            try {
                this.f10626c = new JSONArray(jSONArray.toString());
            } catch (JSONException unused) {
            }
            return this;
        }

        /* renamed from: a */
        public C3845f mo27578a() throws JSONException {
            return new C3845f(this.f10624a, this.f10625b, this.f10626c);
        }
    }

    /* renamed from: a */
    static C3845f m13001a(JSONObject jSONObject) throws JSONException {
        return new C3845f(jSONObject.getJSONObject("configs_key"), new Date(jSONObject.getLong("fetch_time_key")), jSONObject.getJSONArray("abt_experiments_key"));
    }

    /* renamed from: e */
    public static C3847b m13003e() {
        return new C3847b();
    }

    /* renamed from: b */
    public JSONObject mo27569b() {
        return this.f10621b;
    }

    /* renamed from: c */
    public Date mo27570c() {
        return this.f10622c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C3845f)) {
            return false;
        }
        return this.f10620a.toString().equals(((C3845f) obj).toString());
    }

    public int hashCode() {
        return this.f10620a.hashCode();
    }

    public String toString() {
        return this.f10620a.toString();
    }

    private C3845f(JSONObject jSONObject, Date date, JSONArray jSONArray) throws JSONException {
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("configs_key", jSONObject);
        jSONObject2.put("fetch_time_key", date.getTime());
        jSONObject2.put("abt_experiments_key", jSONArray);
        this.f10621b = jSONObject;
        this.f10622c = date;
        this.f10623d = jSONArray;
        this.f10620a = jSONObject2;
    }

    /* renamed from: a */
    public JSONArray mo27568a() {
        return this.f10623d;
    }
}
