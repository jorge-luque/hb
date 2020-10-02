package com.criteo.publisher.model.p055z;

import com.criteo.publisher.model.p055z.C2483k;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;
import java.net.URI;
import java.net.URL;

/* renamed from: com.criteo.publisher.model.z.q */
public abstract class C2492q {
    /* renamed from: a */
    public static TypeAdapter<C2492q> m9414a(Gson gson) {
        return new C2483k.C2484a(gson);
    }

    /* access modifiers changed from: package-private */
    @SerializedName("optoutClickUrl")
    /* renamed from: a */
    public abstract URI mo10456a();

    /* access modifiers changed from: package-private */
    @SerializedName("optoutImageUrl")
    /* renamed from: b */
    public abstract URL mo10457b();

    /* access modifiers changed from: package-private */
    @SerializedName("longLegalText")
    /* renamed from: c */
    public abstract String mo10458c();
}
