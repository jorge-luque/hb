package com.criteo.publisher.model;

import com.criteo.publisher.C2387i;
import com.criteo.publisher.model.C2442g;
import com.criteo.publisher.p054a0.C2321a;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.Collection;
import java.util.Collections;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.criteo.publisher.model.n */
public abstract class C2453n {
    /* renamed from: a */
    public static C2453n m9264a(String str, String str2, C2321a aVar, AdSize adSize) {
        return new C2442g(str, str2, aVar == C2321a.CRITEO_CUSTOM_NATIVE ? true : null, aVar == C2321a.CRITEO_INTERSTITIAL ? true : null, Collections.singletonList(adSize.getFormattedSize()));
    }

    @SerializedName("impId")
    /* renamed from: a */
    public abstract String mo10319a();

    @SerializedName("placementId")
    /* renamed from: b */
    public abstract String mo10320b();

    @SerializedName("sizes")
    /* renamed from: c */
    public abstract Collection<String> mo10321c();

    @SerializedName("interstitial")
    /* renamed from: d */
    public abstract Boolean mo10322d();

    @SerializedName("isNative")
    /* renamed from: e */
    public abstract Boolean mo10323e();

    /* renamed from: f */
    public JSONObject mo10376f() throws JSONException {
        return new JSONObject(C2387i.m9085U().mo10287t().toJson((Object) this));
    }

    /* renamed from: a */
    public static TypeAdapter<C2453n> m9265a(Gson gson) {
        return new C2442g.C2443a(gson);
    }
}
