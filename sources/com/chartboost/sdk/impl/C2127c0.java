package com.chartboost.sdk.impl;

/* renamed from: com.chartboost.sdk.impl.c0 */
public class C2127c0 {

    /* renamed from: a */
    private String f7120a;

    /* renamed from: b */
    private String f7121b;

    /* renamed from: c */
    private Double f7122c;

    /* renamed from: d */
    private String f7123d;

    /* renamed from: e */
    private String f7124e;

    /* renamed from: f */
    private String f7125f;

    /* renamed from: g */
    private C2132d0 f7126g;

    public C2127c0() {
        this.f7120a = "";
        this.f7121b = "";
        this.f7122c = Double.valueOf(0.0d);
        this.f7123d = "";
        this.f7124e = "";
        this.f7125f = "";
        this.f7126g = new C2132d0();
    }

    /* renamed from: a */
    public String mo9285a() {
        return this.f7125f;
    }

    /* renamed from: b */
    public String mo9286b() {
        return this.f7124e;
    }

    /* renamed from: c */
    public C2132d0 mo9287c() {
        return this.f7126g;
    }

    public String toString() {
        return "id: " + this.f7120a + "\nimpid: " + this.f7121b + "\nprice: " + this.f7122c + "\nburl: " + this.f7123d + "\ncrid: " + this.f7124e + "\nadm: " + this.f7125f + "\next: " + this.f7126g.toString() + "\n";
    }

    public C2127c0(String str, String str2, Double d, String str3, String str4, String str5, C2132d0 d0Var) {
        this.f7120a = str;
        this.f7121b = str2;
        this.f7122c = d;
        this.f7123d = str3;
        this.f7124e = str4;
        this.f7125f = str5;
        this.f7126g = d0Var;
    }
}
