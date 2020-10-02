package com.chartboost.sdk.impl;

import java.util.ArrayList;
import java.util.List;

/* renamed from: com.chartboost.sdk.impl.d0 */
public class C2132d0 {

    /* renamed from: a */
    private String f7135a;

    /* renamed from: b */
    private String f7136b;

    /* renamed from: c */
    private String f7137c;

    /* renamed from: d */
    private String f7138d;

    /* renamed from: e */
    private List<String> f7139e;

    public C2132d0() {
        this.f7135a = "";
        this.f7136b = "";
        this.f7137c = "";
        this.f7138d = "";
        this.f7139e = new ArrayList();
    }

    /* renamed from: a */
    public String mo9309a() {
        return this.f7136b;
    }

    /* renamed from: b */
    public String mo9310b() {
        return this.f7137c;
    }

    /* renamed from: c */
    public String mo9311c() {
        return this.f7135a;
    }

    /* renamed from: d */
    public List<String> mo9312d() {
        return this.f7139e;
    }

    /* renamed from: e */
    public String mo9313e() {
        return this.f7138d;
    }

    public String toString() {
        return "crtype: " + this.f7135a + "\ncgn: " + this.f7137c + "\ntemplate: " + this.f7138d + "\nimptrackers: " + this.f7139e.size() + "\nadId: " + this.f7136b;
    }

    public C2132d0(String str, String str2, String str3, String str4, List<String> list) {
        this.f7135a = str;
        this.f7136b = str2;
        this.f7137c = str3;
        this.f7138d = str4;
        this.f7139e = list;
    }
}
