package com.vungle.warren.network;

import com.google.gson.JsonObject;
import com.vungle.warren.network.converters.Converter;
import com.vungle.warren.network.converters.EmptyResponseConverter;
import com.vungle.warren.network.converters.JsonConverter;
import java.util.Map;
import p113i.C3484b0;
import p113i.C3497e;
import p113i.C3539s;
import p113i.C3541u;
import p113i.C3548y;
import p113i.C3550z;
import p118io.fabric.sdk.android.p200m.p202b.C6078a;

public class VungleApiImpl implements VungleApi {
    private static final String CONFIG = "config";
    private static final Converter<C3484b0, Void> emptyResponseConverter = new EmptyResponseConverter();
    private static final Converter<C3484b0, JsonObject> jsonConverter = new JsonConverter();
    C3539s baseUrl;
    C3497e.C3498a okHttpClient;

    public VungleApiImpl(C3539s sVar, C3497e.C3498a aVar) {
        this.baseUrl = sVar;
        this.okHttpClient = aVar;
    }

    private <T> Call<T> createNewGetCall(String str, String str2, Map<String, String> map, Converter<C3484b0, T> converter) {
        C3539s.C3540a i = C3539s.m11858d(str2).mo19528i();
        if (map != null) {
            for (Map.Entry next : map.entrySet()) {
                i.mo19539a((String) next.getKey(), (String) next.getValue());
            }
        }
        C3548y.C3549a defaultBuilder = defaultBuilder(str, i.mo19540a().toString());
        defaultBuilder.mo19617b();
        return new OkHttpCall(this.okHttpClient.mo19365a(defaultBuilder.mo19616a()), converter);
    }

    private Call<JsonObject> createNewPostCall(String str, String str2, JsonObject jsonObject) {
        String jsonElement = jsonObject != null ? jsonObject.toString() : "";
        C3548y.C3549a defaultBuilder = defaultBuilder(str, str2);
        defaultBuilder.mo19612a(C3550z.create((C3541u) null, jsonElement));
        return new OkHttpCall(this.okHttpClient.mo19365a(defaultBuilder.mo19616a()), jsonConverter);
    }

    private C3548y.C3549a defaultBuilder(String str, String str2) {
        C3548y.C3549a aVar = new C3548y.C3549a();
        aVar.mo19618b(str2);
        aVar.mo19615a(C6078a.HEADER_USER_AGENT, str);
        aVar.mo19615a("Vungle-Version", "5.4.0");
        aVar.mo19615a("Content-Type", C6078a.ACCEPT_JSON_VALUE);
        return aVar;
    }

    public Call<JsonObject> ads(String str, String str2, JsonObject jsonObject) {
        return createNewPostCall(str, str2, jsonObject);
    }

    public Call<JsonObject> config(String str, JsonObject jsonObject) {
        return createNewPostCall(str, this.baseUrl.toString() + CONFIG, jsonObject);
    }

    public Call<Void> pingTPAT(String str, String str2) {
        return createNewGetCall(str, str2, (Map<String, String>) null, emptyResponseConverter);
    }

    public Call<JsonObject> reportAd(String str, String str2, JsonObject jsonObject) {
        return createNewPostCall(str, str2, jsonObject);
    }

    public Call<JsonObject> reportNew(String str, String str2, Map<String, String> map) {
        return createNewGetCall(str, str2, map, jsonConverter);
    }

    /* renamed from: ri */
    public Call<JsonObject> mo32534ri(String str, String str2, JsonObject jsonObject) {
        return createNewPostCall(str, str2, jsonObject);
    }

    public Call<JsonObject> willPlayAd(String str, String str2, JsonObject jsonObject) {
        return createNewPostCall(str, str2, jsonObject);
    }
}
