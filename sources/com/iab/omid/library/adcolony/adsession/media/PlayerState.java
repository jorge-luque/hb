package com.iab.omid.library.adcolony.adsession.media;

import admost.sdk.base.AdMostZoneType;

public enum PlayerState {
    MINIMIZED("minimized"),
    COLLAPSED("collapsed"),
    NORMAL("normal"),
    EXPANDED("expanded"),
    FULLSCREEN(AdMostZoneType.FULLSCREEN);
    

    /* renamed from: a */
    private final String f11158a;

    private PlayerState(String str) {
        this.f11158a = str;
    }

    public String toString() {
        return this.f11158a;
    }
}
