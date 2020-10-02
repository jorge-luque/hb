package com.iab.omid.library.adcolony.adsession;

import com.facebook.share.internal.MessengerShareContentUtility;

public enum ErrorType {
    GENERIC(MessengerShareContentUtility.TEMPLATE_GENERIC_TYPE),
    VIDEO("video");
    

    /* renamed from: a */
    private final String f11132a;

    private ErrorType(String str) {
        this.f11132a = str;
    }

    public String toString() {
        return this.f11132a;
    }
}
