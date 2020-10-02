package com.applovin.impl.sdk.p048a;

import java.util.Map;

/* renamed from: com.applovin.impl.sdk.a.c */
public class C1814c {

    /* renamed from: a */
    private final String f5600a;

    /* renamed from: b */
    private Map<String, String> f5601b;

    private C1814c(String str, Map<String, String> map) {
        this.f5600a = str;
        this.f5601b = map;
    }

    /* renamed from: a */
    public static C1814c m6808a(String str) {
        return m6809a(str, (Map<String, String>) null);
    }

    /* renamed from: a */
    public static C1814c m6809a(String str, Map<String, String> map) {
        return new C1814c(str, map);
    }

    /* renamed from: a */
    public Map<String, String> mo8101a() {
        return this.f5601b;
    }

    /* renamed from: b */
    public String mo8102b() {
        return this.f5600a;
    }
}
