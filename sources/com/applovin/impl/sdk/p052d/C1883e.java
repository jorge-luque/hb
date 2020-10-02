package com.applovin.impl.sdk.p052d;

import com.applovin.impl.sdk.C1941j;
import com.applovin.impl.sdk.C1973o;
import com.applovin.impl.sdk.p049ad.NativeAdImpl;
import com.applovin.impl.sdk.p050b.C1841c;
import com.applovin.impl.sdk.utils.C1992h;
import com.applovin.nativeAds.AppLovinNativeAdLoadListener;
import com.applovin.nativeAds.AppLovinNativeAdPrecacheListener;
import com.applovin.sdk.AppLovinErrorCodes;
import java.util.List;

/* renamed from: com.applovin.impl.sdk.d.e */
public class C1883e extends C1884f {
    public C1883e(List<NativeAdImpl> list, C1941j jVar, AppLovinNativeAdLoadListener appLovinNativeAdLoadListener) {
        super("TaskCacheNativeAdImages", list, jVar, appLovinNativeAdLoadListener);
    }

    public C1883e(List<NativeAdImpl> list, C1941j jVar, AppLovinNativeAdPrecacheListener appLovinNativeAdPrecacheListener) {
        super("TaskCacheNativeAdImages", list, jVar, appLovinNativeAdPrecacheListener);
    }

    /* renamed from: b */
    private boolean m7267b(NativeAdImpl nativeAdImpl) {
        mo8408c("Unable to cache image resource");
        mo8447a(nativeAdImpl, !C1992h.m7853a(mo8412f()) ? AppLovinErrorCodes.NO_NETWORK : AppLovinErrorCodes.UNABLE_TO_PRECACHE_IMAGE_RESOURCES);
        return false;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo8446a(NativeAdImpl nativeAdImpl) {
        AppLovinNativeAdPrecacheListener appLovinNativeAdPrecacheListener = this.f6247a;
        if (appLovinNativeAdPrecacheListener != null) {
            appLovinNativeAdPrecacheListener.onNativeAdImagesPrecached(nativeAdImpl);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo8447a(NativeAdImpl nativeAdImpl, int i) {
        AppLovinNativeAdPrecacheListener appLovinNativeAdPrecacheListener = this.f6247a;
        if (appLovinNativeAdPrecacheListener != null) {
            appLovinNativeAdPrecacheListener.onNativeAdImagePrecachingFailed(nativeAdImpl, i);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo8448a(NativeAdImpl nativeAdImpl, C1973o oVar) {
        mo8405a("Beginning native ad image caching for #" + nativeAdImpl.getAdId());
        if (((Boolean) this.f6217b.mo8549a(C1841c.f5858bE)).booleanValue()) {
            String a = mo8450a(nativeAdImpl.getSourceIconUrl(), oVar, nativeAdImpl.getResourcePrefixes());
            if (a == null) {
                return m7267b(nativeAdImpl);
            }
            nativeAdImpl.setIconUrl(a);
            String a2 = mo8450a(nativeAdImpl.getSourceImageUrl(), oVar, nativeAdImpl.getResourcePrefixes());
            if (a2 == null) {
                return m7267b(nativeAdImpl);
            }
            nativeAdImpl.setImageUrl(a2);
            return true;
        }
        mo8405a("Resource caching is disabled, skipping...");
        return true;
    }

    public /* bridge */ /* synthetic */ void run() {
        super.run();
    }
}
