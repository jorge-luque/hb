package com.applovin.nativeAds;

public interface AppLovinNativeAdService {
    @Deprecated
    void loadNativeAds(int i, AppLovinNativeAdLoadListener appLovinNativeAdLoadListener);

    void loadNextAd(AppLovinNativeAdLoadListener appLovinNativeAdLoadListener);

    void precacheResources(AppLovinNativeAd appLovinNativeAd, AppLovinNativeAdPrecacheListener appLovinNativeAdPrecacheListener);
}
