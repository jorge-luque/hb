package com.chartboost.sdk.impl;

import com.chartboost.sdk.Events.ChartboostCacheError;
import com.chartboost.sdk.Events.ChartboostClickError;
import com.chartboost.sdk.Events.ChartboostShowError;

/* renamed from: com.chartboost.sdk.impl.c */
public interface C2126c {
    void didCacheBanner(String str, ChartboostCacheError chartboostCacheError);

    void didClickBanner(String str, ChartboostClickError chartboostClickError);

    void didShowBanner(String str, ChartboostShowError chartboostShowError);

    void onBannerCacheFail(String str, ChartboostCacheError chartboostCacheError);

    void onBannerShowFail(String str, ChartboostShowError chartboostShowError);
}
