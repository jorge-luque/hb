package com.adcolony.sdk;

import admost.sdk.AdMostManager;
import admost.sdk.base.AdMost;

public class AdColonyAdSize {
    public static final AdColonyAdSize BANNER = new AdColonyAdSize(320, 50);
    public static final AdColonyAdSize LEADERBOARD = new AdColonyAdSize(728, 90);
    public static final AdColonyAdSize MEDIUM_RECTANGLE = new AdColonyAdSize(AdMost.AD_ERROR_FREQ_CAP, AdMostManager.AD_MEDIUM_RECTANGLE);
    public static final AdColonyAdSize SKYSCRAPER = new AdColonyAdSize(160, 600);

    /* renamed from: a */
    int f3261a;

    /* renamed from: b */
    int f3262b;

    public AdColonyAdSize(int i, int i2) {
        this.f3261a = i;
        this.f3262b = i2;
    }

    public int getHeight() {
        return this.f3262b;
    }

    public int getWidth() {
        return this.f3261a;
    }
}
