package com.criteo.publisher.model;

import com.criteo.publisher.model.C2444h;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;

/* renamed from: com.criteo.publisher.model.t */
public abstract class C2462t {
    /* renamed from: a */
    public static C2462t m9300a(String str, String str2, String str3, int i) {
        return new C2444h(str, str2, str3, i);
    }

    /* renamed from: a */
    public abstract String mo10327a();

    @SerializedName("cpId")
    /* renamed from: b */
    public abstract String mo10328b();

    @SerializedName("rtbProfileId")
    /* renamed from: c */
    public abstract int mo10329c();

    /* renamed from: d */
    public abstract String mo10330d();

    /* renamed from: a */
    public static TypeAdapter<C2462t> m9301a(Gson gson) {
        return new C2444h.C2445a(gson);
    }
}
