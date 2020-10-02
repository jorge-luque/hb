package com.criteo.publisher.p066y.p067b;

import com.criteo.publisher.C2387i;
import com.criteo.publisher.p066y.p067b.C2582b;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.criteo.publisher.y.b.c */
public abstract class C2584c {
    /* renamed from: a */
    public static C2584c m9695a(String str, Boolean bool, Integer num) {
        return new C2582b(str, bool, num);
    }

    /* renamed from: a */
    public abstract String mo10636a();

    /* renamed from: b */
    public abstract Boolean mo10637b();

    /* renamed from: c */
    public JSONObject mo10644c() throws JSONException {
        return new JSONObject(C2387i.m9085U().mo10287t().toJson((Object) this));
    }

    /* renamed from: d */
    public abstract Integer mo10638d();

    /* renamed from: a */
    public static TypeAdapter<C2584c> m9696a(Gson gson) {
        return new C2582b.C2583a(gson);
    }
}
