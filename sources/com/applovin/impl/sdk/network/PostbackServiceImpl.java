package com.applovin.impl.sdk.network;

import com.applovin.impl.sdk.C1941j;
import com.applovin.impl.sdk.p052d.C1864a;
import com.applovin.impl.sdk.p052d.C1890j;
import com.applovin.impl.sdk.p052d.C1907s;
import com.applovin.sdk.AppLovinPostbackListener;
import com.applovin.sdk.AppLovinPostbackService;

public class PostbackServiceImpl implements AppLovinPostbackService {

    /* renamed from: a */
    private final C1941j f6535a;

    public PostbackServiceImpl(C1941j jVar) {
        this.f6535a = jVar;
    }

    public void dispatchPostbackAsync(String str, AppLovinPostbackListener appLovinPostbackListener) {
        dispatchPostbackRequest(C1971g.m7686b(this.f6535a).mo8663a(str).mo8666a(false).mo8667a(), appLovinPostbackListener);
    }

    public void dispatchPostbackRequest(C1971g gVar, C1907s.C1909a aVar, AppLovinPostbackListener appLovinPostbackListener) {
        this.f6535a.mo8533L().mo8475a((C1864a) new C1890j(gVar, aVar, this.f6535a, appLovinPostbackListener), aVar);
    }

    public void dispatchPostbackRequest(C1971g gVar, AppLovinPostbackListener appLovinPostbackListener) {
        dispatchPostbackRequest(gVar, C1907s.C1909a.POSTBACKS, appLovinPostbackListener);
    }

    public String toString() {
        return "PostbackService{}";
    }
}
