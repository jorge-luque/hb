package com.criteo.publisher.model;

import com.criteo.publisher.C2387i;
import com.criteo.publisher.model.C2448j;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.criteo.publisher.model.x */
public abstract class C2466x {
    /* renamed from: a */
    public static C2466x m9331a(String str, String str2, String str3, String str4) {
        return new C2448j(str, "gaid", "android", str2, str3, str4);
    }

    /* renamed from: a */
    public abstract String mo10343a();

    /* renamed from: b */
    public abstract String mo10344b();

    /* renamed from: c */
    public abstract String mo10345c();

    /* renamed from: d */
    public abstract String mo10346d();

    /* renamed from: e */
    public JSONObject mo10417e() throws JSONException {
        return new JSONObject(C2387i.m9085U().mo10287t().toJson((Object) this));
    }

    /* renamed from: f */
    public abstract String mo10348f();

    /* renamed from: g */
    public abstract String mo10349g();

    /* renamed from: a */
    public static TypeAdapter<C2466x> m9332a(Gson gson) {
        return new C2448j.C2449a(gson);
    }
}
