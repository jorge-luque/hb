package com.applovin.impl.sdk;

import com.applovin.impl.sdk.p049ad.C1821d;
import com.applovin.impl.sdk.p049ad.C1835j;
import com.applovin.impl.sdk.p052d.C1864a;
import com.applovin.impl.sdk.p052d.C1896m;
import com.applovin.nativeAds.AppLovinNativeAd;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdLoadListener;
import java.util.LinkedHashSet;
import java.util.List;

/* renamed from: com.applovin.impl.sdk.c */
public class C1845c extends C1981t {
    C1845c(C1941j jVar) {
        super(jVar);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public C1821d mo8323a(C1835j jVar) {
        return ((AppLovinAdBase) jVar).getAdZone();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public C1864a mo8324a(C1821d dVar) {
        C1896m mVar = new C1896m(dVar, this, this.f6628a);
        mVar.mo8463a(true);
        return mVar;
    }

    /* renamed from: a */
    public void mo8325a() {
        for (C1821d next : C1821d.m6862a(this.f6628a)) {
            if (!next.mo8178e()) {
                mo8338h(next);
            }
        }
    }

    /* renamed from: a */
    public void mo8326a(C1821d dVar, int i) {
        mo8752c(dVar, i);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo8327a(Object obj, C1821d dVar, int i) {
        if (obj instanceof C1955n) {
            ((C1955n) obj).mo8326a(dVar, i);
        }
        if (obj instanceof AppLovinAdLoadListener) {
            ((AppLovinAdLoadListener) obj).failedToReceiveAd(i);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo8328a(Object obj, C1835j jVar) {
        ((AppLovinAdLoadListener) obj).adReceived((AppLovinAd) jVar);
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
        mo8751b((C1835j) appLovinAd);
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
    }

    public void onNativeAdsLoaded(List<AppLovinNativeAd> list) {
    }
}
