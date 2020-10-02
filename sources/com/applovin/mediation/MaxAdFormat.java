package com.applovin.mediation;

import admost.sdk.AdMostManager;
import admost.sdk.base.AdMost;
import com.applovin.sdk.AppLovinSdkUtils;

public class MaxAdFormat {
    public static final MaxAdFormat BANNER = new MaxAdFormat("BANNER");
    public static final MaxAdFormat INTERSTITIAL = new MaxAdFormat("INTER");
    public static final MaxAdFormat LEADER = new MaxAdFormat("LEADER");
    public static final MaxAdFormat MREC = new MaxAdFormat("MREC");
    public static final MaxAdFormat NATIVE = new MaxAdFormat("NATIVE");
    public static final MaxAdFormat REWARDED = new MaxAdFormat("REWARDED");

    /* renamed from: a */
    private final String f6784a;

    private MaxAdFormat(String str) {
        this.f6784a = str;
    }

    public String getLabel() {
        return this.f6784a;
    }

    public AppLovinSdkUtils.Size getSize() {
        return BANNER == this ? new AppLovinSdkUtils.Size(320, 50) : LEADER == this ? new AppLovinSdkUtils.Size(728, 90) : MREC == this ? new AppLovinSdkUtils.Size(AdMost.AD_ERROR_FREQ_CAP, AdMostManager.AD_MEDIUM_RECTANGLE) : new AppLovinSdkUtils.Size(0, 0);
    }

    public String toString() {
        return "MaxAdFormat{label='" + this.f6784a + '\'' + '}';
    }
}
