package com.applovin.impl.sdk.p052d;

import com.applovin.impl.sdk.C1941j;
import com.applovin.impl.sdk.p049ad.C1817a;
import com.applovin.impl.sdk.p049ad.C1818b;
import com.applovin.impl.sdk.p050b.C1841c;
import com.applovin.impl.sdk.p052d.C1907s;
import com.applovin.impl.sdk.utils.C1993i;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinAdType;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.sdk.d.v */
class C1918v extends C1864a {

    /* renamed from: a */
    private final JSONObject f6342a;

    /* renamed from: c */
    private final JSONObject f6343c;

    /* renamed from: d */
    private final AppLovinAdLoadListener f6344d;

    /* renamed from: e */
    private final C1818b f6345e;

    C1918v(JSONObject jSONObject, JSONObject jSONObject2, C1818b bVar, AppLovinAdLoadListener appLovinAdLoadListener, C1941j jVar) {
        super("TaskRenderAppLovinAd", jVar);
        this.f6342a = jSONObject;
        this.f6343c = jSONObject2;
        this.f6345e = bVar;
        this.f6344d = appLovinAdLoadListener;
    }

    public void run() {
        mo8405a("Rendering ad...");
        C1817a aVar = new C1817a(this.f6342a, this.f6343c, this.f6345e, this.f6217b);
        boolean booleanValue = C1993i.m7871a(this.f6342a, "gs_load_immediately", (Boolean) false, this.f6217b).booleanValue();
        boolean booleanValue2 = C1993i.m7871a(this.f6342a, "vs_load_immediately", (Boolean) true, this.f6217b).booleanValue();
        C1881d dVar = new C1881d(aVar, this.f6217b, this.f6344d);
        dVar.mo8443a(booleanValue2);
        dVar.mo8444b(booleanValue);
        C1907s.C1909a aVar2 = C1907s.C1909a.CACHING_OTHER;
        if (((Boolean) this.f6217b.mo8549a(C1841c.f5889bj)).booleanValue()) {
            if (aVar.getSize() == AppLovinAdSize.INTERSTITIAL && aVar.getType() == AppLovinAdType.REGULAR) {
                aVar2 = C1907s.C1909a.CACHING_INTERSTITIAL;
            } else if (aVar.getSize() == AppLovinAdSize.INTERSTITIAL && aVar.getType() == AppLovinAdType.INCENTIVIZED) {
                aVar2 = C1907s.C1909a.CACHING_INCENTIVIZED;
            }
        }
        this.f6217b.mo8533L().mo8475a((C1864a) dVar, aVar2);
    }
}
