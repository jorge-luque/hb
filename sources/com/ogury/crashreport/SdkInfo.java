package com.ogury.crashreport;

/* compiled from: SdkInfo.kt */
public final class SdkInfo {
    private final String aaid;
    private final String apiKey;
    private final String sdkVersion;

    public SdkInfo(String str, String str2, String str3) {
        tx7920.m15333b(str, "sdkVersion");
        tx7920.m15333b(str2, "apiKey");
        tx7920.m15333b(str3, "aaid");
        this.sdkVersion = str;
        this.apiKey = str2;
        this.aaid = str3;
    }

    public final String getAaid() {
        return this.aaid;
    }

    public final String getApiKey() {
        return this.apiKey;
    }

    public final String getSdkVersion() {
        return this.sdkVersion;
    }
}
