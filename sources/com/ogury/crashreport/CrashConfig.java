package com.ogury.crashreport;

/* compiled from: CrashConfig.kt */
public final class CrashConfig {
    private final String packageName;
    private final String url;

    public CrashConfig(String str, String str2) {
        tx7920.m15333b(str, "url");
        tx7920.m15333b(str2, "packageName");
        this.url = str;
        this.packageName = str2;
    }

    public final String getPackageName() {
        return this.packageName;
    }

    public final String getUrl() {
        return this.url;
    }
}
