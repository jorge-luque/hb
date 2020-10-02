package com.applovin.sdk;

import admost.sdk.AdMostManager;
import admost.sdk.base.AdMost;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

public class AppLovinAdSize {
    public static final AppLovinAdSize BANNER = new AppLovinAdSize(-1, 50, "BANNER");
    public static final AppLovinAdSize INTERSTITIAL = new AppLovinAdSize(-1, -1, "INTER");
    public static final AppLovinAdSize LEADER = new AppLovinAdSize(-1, 90, "LEADER");
    public static final AppLovinAdSize MREC = new AppLovinAdSize(AdMost.AD_ERROR_FREQ_CAP, AdMostManager.AD_MEDIUM_RECTANGLE, "MREC");
    public static final AppLovinAdSize NATIVE = new AppLovinAdSize("NATIVE");
    public static final int SPAN = -1;

    /* renamed from: a */
    private final int f6796a;

    /* renamed from: b */
    private final int f6797b;

    /* renamed from: c */
    private final String f6798c;

    private AppLovinAdSize(int i, int i2, String str) {
        if (i < 0 && i != -1) {
            throw new IllegalArgumentException("Ad width must be a positive number. Number provided: " + i);
        } else if (i > 9999) {
            throw new IllegalArgumentException("Ad width must be less then 9999. Number provided: " + i);
        } else if (i2 < 0 && i2 != -1) {
            throw new IllegalArgumentException("Ad height must be a positive number. Number provided: " + i2);
        } else if (i2 > 9999) {
            throw new IllegalArgumentException("Ad height must be less then 9999. Number provided: " + i2);
        } else if (str == null) {
            throw new IllegalArgumentException("No label specified");
        } else if (str.length() <= 9) {
            this.f6796a = i;
            this.f6797b = i2;
            this.f6798c = str;
        } else {
            throw new IllegalArgumentException("Provided label is too long. Label provided: " + str);
        }
    }

    private AppLovinAdSize(String str) {
        this(0, 0, str);
    }

    public static Set<AppLovinAdSize> allSizes() {
        HashSet hashSet = new HashSet(4);
        hashSet.add(BANNER);
        hashSet.add(MREC);
        hashSet.add(INTERSTITIAL);
        hashSet.add(LEADER);
        return hashSet;
    }

    public static AppLovinAdSize fromString(String str) {
        if ("BANNER".equalsIgnoreCase(str)) {
            return BANNER;
        }
        if ("MREC".equalsIgnoreCase(str)) {
            return MREC;
        }
        if ("LEADER".equalsIgnoreCase(str)) {
            return LEADER;
        }
        if ("INTERSTITIAL".equalsIgnoreCase(str) || "INTER".equalsIgnoreCase(str)) {
            return INTERSTITIAL;
        }
        if ("NATIVE".equalsIgnoreCase(str)) {
            return NATIVE;
        }
        throw new IllegalArgumentException("Unknown Ad Size: " + str);
    }

    public int getHeight() {
        return this.f6797b;
    }

    public String getLabel() {
        return this.f6798c.toUpperCase(Locale.ENGLISH);
    }

    public int getWidth() {
        return this.f6796a;
    }

    public String toString() {
        return getLabel();
    }
}
