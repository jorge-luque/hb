package com.applovin.impl.sdk.p052d;

import com.applovin.impl.sdk.C1941j;
import com.applovin.impl.sdk.C1973o;
import com.applovin.impl.sdk.p049ad.NativeAdImpl;
import com.applovin.impl.sdk.p050b.C1841c;
import com.applovin.impl.sdk.utils.C1992h;
import com.applovin.impl.sdk.utils.C2025o;
import com.applovin.nativeAds.AppLovinNativeAdLoadListener;
import com.applovin.nativeAds.AppLovinNativeAdPrecacheListener;
import com.applovin.sdk.AppLovinErrorCodes;
import java.util.List;

/* renamed from: com.applovin.impl.sdk.d.g */
public class C1885g extends C1884f {
    public C1885g(List<NativeAdImpl> list, C1941j jVar, AppLovinNativeAdLoadListener appLovinNativeAdLoadListener) {
        super("TaskCacheNativeAdVideos", list, jVar, appLovinNativeAdLoadListener);
    }

    public C1885g(List<NativeAdImpl> list, C1941j jVar, AppLovinNativeAdPrecacheListener appLovinNativeAdPrecacheListener) {
        super("TaskCacheNativeAdVideos", list, jVar, appLovinNativeAdPrecacheListener);
    }

    /* renamed from: b */
    private boolean m7277b(NativeAdImpl nativeAdImpl) {
        mo8408c("Unable to cache video resource " + nativeAdImpl.getSourceVideoUrl());
        mo8447a(nativeAdImpl, !C1992h.m7853a(mo8412f()) ? AppLovinErrorCodes.NO_NETWORK : AppLovinErrorCodes.UNABLE_TO_PRECACHE_VIDEO_RESOURCES);
        return false;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo8446a(NativeAdImpl nativeAdImpl) {
        AppLovinNativeAdPrecacheListener appLovinNativeAdPrecacheListener = this.f6247a;
        if (appLovinNativeAdPrecacheListener != null) {
            appLovinNativeAdPrecacheListener.onNativeAdVideoPreceached(nativeAdImpl);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo8447a(NativeAdImpl nativeAdImpl, int i) {
        AppLovinNativeAdPrecacheListener appLovinNativeAdPrecacheListener = this.f6247a;
        if (appLovinNativeAdPrecacheListener != null) {
            appLovinNativeAdPrecacheListener.onNativeAdVideoPrecachingFailed(nativeAdImpl, i);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo8448a(NativeAdImpl nativeAdImpl, C1973o oVar) {
        if (!C2025o.m7963b(nativeAdImpl.getSourceVideoUrl())) {
            return true;
        }
        mo8405a("Beginning native ad video caching" + nativeAdImpl.getAdId());
        if (((Boolean) this.f6217b.mo8549a(C1841c.f5858bE)).booleanValue()) {
            String a = mo8450a(nativeAdImpl.getSourceVideoUrl(), oVar, nativeAdImpl.getResourcePrefixes());
            if (a == null) {
                return m7277b(nativeAdImpl);
            }
            nativeAdImpl.setVideoUrl(a);
        } else {
            mo8405a("Resource caching is disabled, skipping...");
        }
        return true;
    }

    public /* bridge */ /* synthetic */ void run() {
        super.run();
    }
}
