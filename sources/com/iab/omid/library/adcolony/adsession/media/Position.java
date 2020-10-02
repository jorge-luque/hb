package com.iab.omid.library.adcolony.adsession.media;

import com.vungle.warren.model.Advertisement;

public enum Position {
    PREROLL("preroll"),
    MIDROLL("midroll"),
    POSTROLL(Advertisement.KEY_POSTROLL),
    STANDALONE("standalone");
    

    /* renamed from: a */
    private final String f11160a;

    private Position(String str) {
        this.f11160a = str;
    }

    public String toString() {
        return this.f11160a;
    }
}
