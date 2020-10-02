package com.tapjoy.internal;

/* renamed from: com.tapjoy.internal.cx */
public final class C4953cx {

    /* renamed from: a */
    public final String f13458a;

    /* renamed from: b */
    public final String f13459b;

    private C4953cx(String str, String str2) {
        this.f13458a = str;
        this.f13459b = str2;
    }

    /* renamed from: a */
    public static C4953cx m16792a(String str, String str2) {
        C4975do.m16854a(str, "Name is null or empty");
        C4975do.m16854a(str2, "Version is null or empty");
        return new C4953cx(str, str2);
    }
}
