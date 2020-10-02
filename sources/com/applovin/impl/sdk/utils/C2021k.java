package com.applovin.impl.sdk.utils;

/* renamed from: com.applovin.impl.sdk.utils.k */
public class C2021k {

    /* renamed from: a */
    private final StringBuilder f6718a = new StringBuilder();

    /* renamed from: a */
    public C2021k mo8801a() {
        this.f6718a.append("\n========================================");
        return this;
    }

    /* renamed from: a */
    public C2021k mo8802a(String str) {
        StringBuilder sb = this.f6718a;
        sb.append("\n");
        sb.append(str);
        return this;
    }

    /* renamed from: a */
    public C2021k mo8803a(String str, Object obj) {
        return mo8804a(str, obj, "");
    }

    /* renamed from: a */
    public C2021k mo8804a(String str, Object obj, String str2) {
        StringBuilder sb = this.f6718a;
        sb.append("\n");
        sb.append(str);
        sb.append(": ");
        sb.append(obj);
        sb.append(str2);
        return this;
    }

    public String toString() {
        return this.f6718a.toString();
    }
}
