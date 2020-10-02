package com.applovin.impl.sdk;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/* renamed from: com.applovin.impl.sdk.m */
public class C1954m {

    /* renamed from: a */
    private final String f6531a = UUID.randomUUID().toString();

    /* renamed from: b */
    private final String f6532b;

    /* renamed from: c */
    private final Map<String, Object> f6533c;

    /* renamed from: d */
    private final long f6534d;

    public C1954m(String str, Map<String, String> map, Map<String, Object> map2) {
        this.f6532b = str;
        HashMap hashMap = new HashMap();
        this.f6533c = hashMap;
        hashMap.putAll(map);
        this.f6533c.put("applovin_sdk_super_properties", map2);
        this.f6534d = System.currentTimeMillis();
    }

    /* renamed from: a */
    public String mo8622a() {
        return this.f6532b;
    }

    /* renamed from: b */
    public Map<String, Object> mo8623b() {
        return this.f6533c;
    }

    /* renamed from: c */
    public long mo8624c() {
        return this.f6534d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || C1954m.class != obj.getClass()) {
            return false;
        }
        C1954m mVar = (C1954m) obj;
        if (this.f6534d != mVar.f6534d) {
            return false;
        }
        String str = this.f6532b;
        if (str == null ? mVar.f6532b != null : !str.equals(mVar.f6532b)) {
            return false;
        }
        Map<String, Object> map = this.f6533c;
        if (map == null ? mVar.f6533c != null : !map.equals(mVar.f6533c)) {
            return false;
        }
        String str2 = this.f6531a;
        String str3 = mVar.f6531a;
        if (str2 != null) {
            return str2.equals(str3);
        }
        if (str3 == null) {
            return true;
        }
    }

    public int hashCode() {
        String str = this.f6532b;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        Map<String, Object> map = this.f6533c;
        int hashCode2 = map != null ? map.hashCode() : 0;
        long j = this.f6534d;
        int i2 = (((hashCode + hashCode2) * 31) + ((int) (j ^ (j >>> 32)))) * 31;
        String str2 = this.f6531a;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return i2 + i;
    }

    public String toString() {
        return "Event{name='" + this.f6532b + '\'' + ", id='" + this.f6531a + '\'' + ", creationTimestampMillis=" + this.f6534d + ", parameters=" + this.f6533c + '}';
    }
}
