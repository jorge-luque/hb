package com.applovin.sdk;

import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

public class AppLovinAdType {
    public static final AppLovinAdType INCENTIVIZED = new AppLovinAdType("VIDEOA");
    public static final AppLovinAdType NATIVE = new AppLovinAdType("NATIVE");
    public static final AppLovinAdType REGULAR = new AppLovinAdType("REGULAR");

    /* renamed from: a */
    private final String f6799a;

    private AppLovinAdType(String str) {
        this.f6799a = str;
    }

    public static Set<AppLovinAdType> allTypes() {
        HashSet hashSet = new HashSet(2);
        hashSet.add(REGULAR);
        hashSet.add(INCENTIVIZED);
        return hashSet;
    }

    public static AppLovinAdType fromString(String str) {
        if ("REGULAR".equalsIgnoreCase(str)) {
            return REGULAR;
        }
        if ("VIDEOA".equalsIgnoreCase(str)) {
            return INCENTIVIZED;
        }
        if ("NATIVE".equalsIgnoreCase(str)) {
            return NATIVE;
        }
        throw new IllegalArgumentException("Unknown Ad Type: " + str);
    }

    public String getLabel() {
        return this.f6799a.toUpperCase(Locale.ENGLISH);
    }

    public String toString() {
        return getLabel();
    }
}
