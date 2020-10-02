package com.adcolony.sdk;

import com.adcolony.sdk.C1439u;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.adcolony.sdk.x */
class C1454x {

    /* renamed from: a */
    private String f4557a;

    /* renamed from: b */
    private JSONObject f4558b;

    C1454x(JSONObject jSONObject) {
        try {
            this.f4558b = jSONObject;
            this.f4557a = jSONObject.getString("m_type");
        } catch (JSONException e) {
            new C1439u.C1440a().mo6801a("JSON Error in ADCMessage constructor: ").mo6801a(e.toString()).mo6803a(C1439u.f4517j);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public C1454x mo6827a() {
        return mo6829a((JSONObject) null);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public JSONObject mo6830b() {
        return this.f4558b;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public String mo6833c() {
        return this.f4557a;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public void mo6834d() {
        C1199a.m4877a(this.f4557a, this.f4558b);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public C1454x mo6828a(String str) {
        return mo6829a(C1437s.m5600b(str));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo6832b(JSONObject jSONObject) {
        this.f4558b = jSONObject;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public C1454x mo6829a(JSONObject jSONObject) {
        try {
            C1454x xVar = new C1454x("reply", this.f4558b.getInt("m_origin"), jSONObject);
            xVar.f4558b.put("m_id", this.f4558b.getInt("m_id"));
            return xVar;
        } catch (JSONException e) {
            new C1439u.C1440a().mo6801a("JSON error in ADCMessage's createReply(): ").mo6801a(e.toString()).mo6803a(C1439u.f4517j);
            return new C1454x("JSONException", 0);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo6831b(String str) {
        this.f4557a = str;
    }

    C1454x(String str, int i) {
        try {
            this.f4557a = str;
            JSONObject jSONObject = new JSONObject();
            this.f4558b = jSONObject;
            jSONObject.put("m_target", i);
        } catch (JSONException e) {
            new C1439u.C1440a().mo6801a("JSON Error in ADCMessage constructor: ").mo6801a(e.toString()).mo6803a(C1439u.f4517j);
        }
    }

    C1454x(String str, int i, String str2) {
        try {
            this.f4557a = str;
            JSONObject b = C1437s.m5600b(str2);
            this.f4558b = b;
            b.put("m_target", i);
        } catch (JSONException e) {
            new C1439u.C1440a().mo6801a("JSON Error in ADCMessage constructor: ").mo6801a(e.toString()).mo6803a(C1439u.f4517j);
        }
    }

    C1454x(String str, int i, JSONObject jSONObject) {
        try {
            this.f4557a = str;
            jSONObject = jSONObject == null ? new JSONObject() : jSONObject;
            this.f4558b = jSONObject;
            jSONObject.put("m_target", i);
        } catch (JSONException e) {
            new C1439u.C1440a().mo6801a("JSON Error in ADCMessage constructor: ").mo6801a(e.toString()).mo6803a(C1439u.f4517j);
        }
    }
}
