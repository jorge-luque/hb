package com.applovin.impl.sdk;

import com.applovin.impl.sdk.p049ad.C1821d;
import com.applovin.impl.sdk.p049ad.C1835j;
import com.applovin.impl.sdk.p049ad.NativeAdImpl;
import com.applovin.impl.sdk.p050b.C1841c;
import com.applovin.impl.sdk.p052d.C1864a;
import com.applovin.impl.sdk.p052d.C1898n;
import com.applovin.impl.sdk.utils.C2025o;
import com.applovin.nativeAds.AppLovinNativeAd;
import com.applovin.nativeAds.AppLovinNativeAdLoadListener;
import com.applovin.nativeAds.AppLovinNativeAdPrecacheListener;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdLoadListener;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;

/* renamed from: com.applovin.impl.sdk.s */
public class C1979s extends C1981t {
    C1979s(C1941j jVar) {
        super(jVar);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public C1821d mo8323a(C1835j jVar) {
        return ((NativeAdImpl) jVar).getAdZone();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public C1864a mo8324a(C1821d dVar) {
        return new C1898n(this.f6628a, this);
    }

    /* renamed from: a */
    public void mo8750a() {
        mo8338h(C1821d.m6871g(this.f6628a));
    }

    /* renamed from: a */
    public void mo8326a(C1821d dVar, int i) {
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo8327a(Object obj, C1821d dVar, int i) {
        ((AppLovinNativeAdLoadListener) obj).onNativeAdsFailedToLoad(i);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo8328a(Object obj, C1835j jVar) {
        AppLovinNativeAdLoadListener appLovinNativeAdLoadListener = (AppLovinNativeAdLoadListener) obj;
        appLovinNativeAdLoadListener.onNativeAdsLoaded(Arrays.asList(new AppLovinNativeAd[]{(AppLovinNativeAd) jVar}));
    }

    /* renamed from: a */
    public /* bridge */ /* synthetic */ void mo8329a(LinkedHashSet linkedHashSet) {
        super.mo8329a((LinkedHashSet<C1821d>) linkedHashSet);
    }

    /* renamed from: a */
    public /* bridge */ /* synthetic */ boolean mo8330a(C1821d dVar, AppLovinAdLoadListener appLovinAdLoadListener) {
        return super.mo8330a(dVar, appLovinAdLoadListener);
    }

    public void adReceived(AppLovinAd appLovinAd) {
    }

    /* renamed from: b */
    public /* bridge */ /* synthetic */ void mo8331b(C1821d dVar, int i) {
        super.mo8331b(dVar, i);
    }

    /* renamed from: b */
    public /* bridge */ /* synthetic */ boolean mo8332b(C1821d dVar) {
        return super.mo8332b(dVar);
    }

    /* renamed from: c */
    public /* bridge */ /* synthetic */ C1835j mo8333c(C1821d dVar) {
        return super.mo8333c(dVar);
    }

    /* renamed from: d */
    public /* bridge */ /* synthetic */ C1835j mo8334d(C1821d dVar) {
        return super.mo8334d(dVar);
    }

    /* renamed from: e */
    public /* bridge */ /* synthetic */ C1835j mo8335e(C1821d dVar) {
        return super.mo8335e(dVar);
    }

    /* renamed from: f */
    public /* bridge */ /* synthetic */ void mo8336f(C1821d dVar) {
        super.mo8336f(dVar);
    }

    public void failedToReceiveAd(int i) {
    }

    /* renamed from: g */
    public /* bridge */ /* synthetic */ boolean mo8337g(C1821d dVar) {
        return super.mo8337g(dVar);
    }

    /* renamed from: h */
    public /* bridge */ /* synthetic */ void mo8338h(C1821d dVar) {
        super.mo8338h(dVar);
    }

    /* renamed from: i */
    public /* bridge */ /* synthetic */ void mo8339i(C1821d dVar) {
        super.mo8339i(dVar);
    }

    public void onNativeAdsFailedToLoad(int i) {
        mo8752c(C1821d.m6871g(this.f6628a), i);
    }

    public void onNativeAdsLoaded(List<AppLovinNativeAd> list) {
        AppLovinNativeAd appLovinNativeAd = list.get(0);
        if (((Boolean) this.f6628a.mo8549a(C1841c.f5857bD)).booleanValue()) {
            this.f6628a.mo8595p().precacheResources(appLovinNativeAd, new AppLovinNativeAdPrecacheListener() {
                public void onNativeAdImagePrecachingFailed(AppLovinNativeAd appLovinNativeAd, int i) {
                    C1979s sVar = C1979s.this;
                    sVar.mo8752c(C1821d.m6871g(sVar.f6628a), i);
                }

                public void onNativeAdImagesPrecached(AppLovinNativeAd appLovinNativeAd) {
                    if (!C2025o.m7963b(appLovinNativeAd.getVideoUrl())) {
                        C1979s.this.mo8751b((C1835j) appLovinNativeAd);
                    }
                }

                public void onNativeAdVideoPrecachingFailed(AppLovinNativeAd appLovinNativeAd, int i) {
                    C1977q qVar = C1979s.this.f6629b;
                    qVar.mo8745d("NativeAdPreloadManager", "Video failed to cache during native ad preload. " + i);
                    C1979s.this.mo8751b((C1835j) appLovinNativeAd);
                }

                public void onNativeAdVideoPreceached(AppLovinNativeAd appLovinNativeAd) {
                    C1979s.this.mo8751b((C1835j) appLovinNativeAd);
                }
            });
        } else {
            mo8751b((C1835j) appLovinNativeAd);
        }
    }
}
