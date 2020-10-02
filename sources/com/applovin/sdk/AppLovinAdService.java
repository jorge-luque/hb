package com.applovin.sdk;

import java.util.List;

public interface AppLovinAdService {
    @Deprecated
    void addAdUpdateListener(AppLovinAdUpdateListener appLovinAdUpdateListener);

    @Deprecated
    void addAdUpdateListener(AppLovinAdUpdateListener appLovinAdUpdateListener, AppLovinAdSize appLovinAdSize);

    String getBidToken();

    @Deprecated
    boolean hasPreloadedAd(AppLovinAdSize appLovinAdSize);

    @Deprecated
    boolean hasPreloadedAdForZoneId(String str);

    void loadNextAd(AppLovinAdSize appLovinAdSize, AppLovinAdLoadListener appLovinAdLoadListener);

    void loadNextAdForAdToken(String str, AppLovinAdLoadListener appLovinAdLoadListener);

    void loadNextAdForZoneId(String str, AppLovinAdLoadListener appLovinAdLoadListener);

    void loadNextAdForZoneIds(List<String> list, AppLovinAdLoadListener appLovinAdLoadListener);

    @Deprecated
    void preloadAd(AppLovinAdSize appLovinAdSize);

    @Deprecated
    void preloadAdForZoneId(String str);

    @Deprecated
    void removeAdUpdateListener(AppLovinAdUpdateListener appLovinAdUpdateListener, AppLovinAdSize appLovinAdSize);
}
