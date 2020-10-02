package com.applovin.impl.sdk.p052d;

import com.applovin.impl.sdk.C1941j;
import com.applovin.impl.sdk.p049ad.C1821d;
import com.applovin.impl.sdk.p050b.C1841c;
import com.applovin.nativeAds.AppLovinNativeAdLoadListener;
import com.applovin.sdk.AppLovinAdLoadListener;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.sdk.d.n */
public class C1898n extends C1896m {

    /* renamed from: a */
    private final AppLovinNativeAdLoadListener f6269a;

    public C1898n(C1941j jVar, AppLovinNativeAdLoadListener appLovinNativeAdLoadListener) {
        super(C1821d.m6871g(jVar), (AppLovinAdLoadListener) null, "TaskFetchNextNativeAd", jVar);
        this.f6269a = appLovinNativeAdLoadListener;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public C1864a mo8461a(JSONObject jSONObject) {
        return new C1919w(jSONObject, this.f6217b, this.f6269a);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo8462a(int i) {
        AppLovinNativeAdLoadListener appLovinNativeAdLoadListener = this.f6269a;
        if (appLovinNativeAdLoadListener != null) {
            appLovinNativeAdLoadListener.onNativeAdsFailedToLoad(i);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public String mo8464c() {
        return ((String) this.f6217b.mo8549a(C1841c.f5809aI)) + "4.0/nad";
    }

    /* access modifiers changed from: protected */
    /* renamed from: h */
    public String mo8465h() {
        return ((String) this.f6217b.mo8549a(C1841c.f5810aJ)) + "4.0/nad";
    }
}
