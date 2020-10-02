package com.applovin.impl.sdk.p052d;

import com.applovin.impl.sdk.C1941j;
import com.applovin.impl.sdk.C1973o;
import com.applovin.impl.sdk.C1977q;
import com.applovin.impl.sdk.p049ad.NativeAdImpl;
import com.applovin.impl.sdk.p051c.C1855e;
import com.applovin.impl.sdk.utils.C2025o;
import com.applovin.impl.sdk.utils.C2029r;
import com.applovin.nativeAds.AppLovinNativeAd;
import com.applovin.nativeAds.AppLovinNativeAdLoadListener;
import com.applovin.nativeAds.AppLovinNativeAdPrecacheListener;
import java.util.List;

/* renamed from: com.applovin.impl.sdk.d.f */
abstract class C1884f extends C1864a {

    /* renamed from: a */
    protected final AppLovinNativeAdPrecacheListener f6247a;

    /* renamed from: c */
    private final List<NativeAdImpl> f6248c;

    /* renamed from: d */
    private final AppLovinNativeAdLoadListener f6249d;

    /* renamed from: e */
    private int f6250e;

    C1884f(String str, List<NativeAdImpl> list, C1941j jVar, AppLovinNativeAdLoadListener appLovinNativeAdLoadListener) {
        super(str, jVar);
        this.f6248c = list;
        this.f6249d = appLovinNativeAdLoadListener;
        this.f6247a = null;
    }

    C1884f(String str, List<NativeAdImpl> list, C1941j jVar, AppLovinNativeAdPrecacheListener appLovinNativeAdPrecacheListener) {
        super(str, jVar);
        if (list != null) {
            this.f6248c = list;
            this.f6249d = null;
            this.f6247a = appLovinNativeAdPrecacheListener;
            return;
        }
        throw new IllegalArgumentException("Native ads cannot be null");
    }

    /* renamed from: a */
    private void m7271a(int i) {
        AppLovinNativeAdLoadListener appLovinNativeAdLoadListener = this.f6249d;
        if (appLovinNativeAdLoadListener != null) {
            appLovinNativeAdLoadListener.onNativeAdsFailedToLoad(i);
        }
    }

    /* renamed from: a */
    private void m7272a(List<AppLovinNativeAd> list) {
        AppLovinNativeAdLoadListener appLovinNativeAdLoadListener = this.f6249d;
        if (appLovinNativeAdLoadListener != null) {
            appLovinNativeAdLoadListener.onNativeAdsLoaded(list);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public String mo8450a(String str, C1973o oVar, List<String> list) {
        if (!C2025o.m7963b(str)) {
            mo8405a("Asked to cache file with null/empty URL, nothing to do.");
            return null;
        } else if (!C2029r.m8021a(str, list)) {
            mo8405a("Domain is not whitelisted, skipping precache for URL " + str);
            return null;
        } else {
            try {
                String a = oVar.mo8725a(mo8412f(), str, (String) null, list, true, true, (C1855e) null);
                if (a != null) {
                    return a;
                }
                mo8408c("Unable to cache icon resource " + str);
                return null;
            } catch (Exception e) {
                mo8406a("Unable to cache icon resource " + str, e);
                return null;
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract void mo8446a(NativeAdImpl nativeAdImpl);

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract void mo8447a(NativeAdImpl nativeAdImpl, int i);

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract boolean mo8448a(NativeAdImpl nativeAdImpl, C1973o oVar);

    public void run() {
        for (NativeAdImpl next : this.f6248c) {
            mo8405a("Beginning resource caching phase...");
            if (mo8448a(next, this.f6217b.mo8543V())) {
                this.f6250e++;
                mo8446a(next);
            } else {
                mo8410d("Unable to cache resources");
            }
        }
        try {
            if (this.f6250e == this.f6248c.size()) {
                m7272a((List<AppLovinNativeAd>) this.f6248c);
                return;
            }
            mo8410d("Mismatch between successful populations and requested size");
            m7271a(-6);
        } catch (Throwable th) {
            C1977q.m7747c(mo8411e(), "Encountered exception while notifying publisher code", th);
        }
    }
}
