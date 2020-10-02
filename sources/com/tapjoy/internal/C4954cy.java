package com.tapjoy.internal;

import java.net.URL;

/* renamed from: com.tapjoy.internal.cy */
public final class C4954cy {

    /* renamed from: a */
    public final String f13460a;

    /* renamed from: b */
    public final URL f13461b;

    /* renamed from: c */
    public final String f13462c;

    private C4954cy(String str, URL url, String str2) {
        this.f13460a = str;
        this.f13461b = url;
        this.f13462c = str2;
    }

    /* renamed from: a */
    public static C4954cy m16793a(String str, URL url, String str2) {
        C4975do.m16854a(str, "VendorKey is null or empty");
        C4975do.m16853a((Object) url, "ResourceURL is null");
        C4975do.m16854a(str2, "VerificationParameters is null or empty");
        return new C4954cy(str, url, str2);
    }

    /* renamed from: a */
    public static C4954cy m16794a(URL url) {
        C4975do.m16853a((Object) url, "ResourceURL is null");
        return new C4954cy((String) null, url, (String) null);
    }
}
