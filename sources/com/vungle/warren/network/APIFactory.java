package com.vungle.warren.network;

import java.util.List;
import p113i.C3497e;
import p113i.C3539s;

public class APIFactory {
    private static final String TAG = "APIFactory";
    private C3539s baseUrl;
    private C3497e.C3498a okHttpClient;

    public APIFactory(C3497e.C3498a aVar, String str) {
        C3539s d = C3539s.m11858d(str);
        this.baseUrl = d;
        this.okHttpClient = aVar;
        List<String> j = d.mo19529j();
        if (!"".equals(j.get(j.size() - 1))) {
            throw new IllegalArgumentException("baseUrl must end in /: " + str);
        }
    }

    public VungleApi createAPI() {
        return new VungleApiImpl(this.baseUrl, this.okHttpClient);
    }
}
