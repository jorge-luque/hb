package com.applovin.impl.sdk.p051c;

import java.util.Map;

/* renamed from: com.applovin.impl.sdk.c.a */
public class C1846a {

    /* renamed from: a */
    private final String f6117a;

    /* renamed from: b */
    private final String f6118b;

    /* renamed from: c */
    private final Map<String, String> f6119c;

    public C1846a(String str, String str2) {
        this(str, str2, (Map<String, String>) null);
    }

    public C1846a(String str, String str2, Map<String, String> map) {
        this.f6117a = str;
        this.f6118b = str2;
        this.f6119c = map;
    }

    /* renamed from: a */
    public String mo8340a() {
        return this.f6117a;
    }

    /* renamed from: b */
    public String mo8341b() {
        return this.f6118b;
    }

    /* renamed from: c */
    public Map<String, String> mo8342c() {
        return this.f6119c;
    }

    public String toString() {
        return "AdEventPostback{url='" + this.f6117a + '\'' + ", backupUrl='" + this.f6118b + '\'' + ", headers='" + this.f6119c + '\'' + '}';
    }
}
