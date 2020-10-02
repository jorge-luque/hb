package com.iab.omid.library.adcolony.adsession;

import com.tapjoy.TJAdUnitConstants;

public enum AdSessionContextType {
    HTML(TJAdUnitConstants.String.HTML),
    NATIVE("native"),
    JAVASCRIPT("javascript");
    

    /* renamed from: a */
    private final String f11128a;

    private AdSessionContextType(String str) {
        this.f11128a = str;
    }

    public String toString() {
        return this.f11128a;
    }
}
