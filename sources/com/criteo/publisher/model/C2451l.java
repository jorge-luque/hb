package com.criteo.publisher.model;

import com.criteo.publisher.p066y.p067b.C2584c;
import com.qumpara.offerwall.sdk.core.QumparaOfferwallUtil;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.criteo.publisher.model.l */
public class C2451l {

    /* renamed from: a */
    private final C2460s f7894a;

    /* renamed from: b */
    private final C2466x f7895b;

    /* renamed from: c */
    private final String f7896c;

    /* renamed from: d */
    private final int f7897d;

    /* renamed from: e */
    private final C2584c f7898e;

    /* renamed from: f */
    private final List<C2453n> f7899f;

    public C2451l(C2460s sVar, C2466x xVar, String str, int i, C2584c cVar, List<C2453n> list) {
        this.f7894a = sVar;
        this.f7895b = xVar;
        this.f7896c = str;
        this.f7897d = i;
        this.f7898e = cVar;
        this.f7899f = list;
    }

    /* renamed from: a */
    public List<C2453n> mo10371a() {
        return this.f7899f;
    }

    /* renamed from: b */
    public JSONObject mo10372b() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(QumparaOfferwallUtil.TABLE_NAME, this.f7895b.mo10417e());
        jSONObject.put("publisher", this.f7894a.mo10394c());
        jSONObject.put("sdkVersion", this.f7896c);
        jSONObject.put("profileId", this.f7897d);
        JSONArray jSONArray = new JSONArray();
        for (C2453n f : this.f7899f) {
            jSONArray.put(f.mo10376f());
        }
        if (jSONArray.length() > 0) {
            jSONObject.put("slots", jSONArray);
        }
        C2584c cVar = this.f7898e;
        if (cVar != null) {
            jSONObject.put("gdprConsent", cVar.mo10644c());
        }
        return jSONObject;
    }

    public String toString() {
        return "CdbRequest{publisher=" + this.f7894a + ", user=" + this.f7895b + ", sdkVersion='" + this.f7896c + '\'' + ", profileId=" + this.f7897d + ", gdprConsent=" + this.f7898e + ", slots=" + this.f7899f + '}';
    }
}
