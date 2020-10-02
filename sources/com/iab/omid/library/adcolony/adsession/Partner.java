package com.iab.omid.library.adcolony.adsession;

import com.iab.omid.library.adcolony.p146d.C4170e;

public class Partner {

    /* renamed from: a */
    private final String f11138a;

    /* renamed from: b */
    private final String f11139b;

    private Partner(String str, String str2) {
        this.f11138a = str;
        this.f11139b = str2;
    }

    public static Partner createPartner(String str, String str2) {
        C4170e.m14003a(str, "Name is null or empty");
        C4170e.m14003a(str2, "Version is null or empty");
        return new Partner(str, str2);
    }

    public String getName() {
        return this.f11138a;
    }

    public String getVersion() {
        return this.f11139b;
    }
}
