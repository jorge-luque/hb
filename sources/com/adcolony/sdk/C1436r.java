package com.adcolony.sdk;

/* renamed from: com.adcolony.sdk.r */
class C1436r {

    /* renamed from: a */
    private String f4505a;

    /* renamed from: b */
    private String f4506b;

    /* renamed from: c */
    private String f4507c;

    /* renamed from: d */
    private String f4508d = "%s_%s_%s";

    public C1436r(String str, String str2, String str3) {
        this.f4505a = str;
        this.f4506b = str2;
        this.f4507c = str3;
    }

    /* renamed from: a */
    public String mo6792a() {
        return this.f4507c;
    }

    /* renamed from: b */
    public String mo6793b() {
        return String.format(this.f4508d, new Object[]{mo6794c(), mo6795d(), mo6792a()});
    }

    /* renamed from: c */
    public String mo6794c() {
        return this.f4505a;
    }

    /* renamed from: d */
    public String mo6795d() {
        return this.f4506b;
    }
}
