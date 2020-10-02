package com.tapjoy.internal;

import com.vungle.warren.model.Advertisement;

/* renamed from: com.tapjoy.internal.da */
public enum C4956da {
    PREROLL("preroll"),
    MIDROLL("midroll"),
    POSTROLL(Advertisement.KEY_POSTROLL),
    STANDALONE("standalone");
    

    /* renamed from: e */
    private final String f13477e;

    private C4956da(String str) {
        this.f13477e = str;
    }

    public final String toString() {
        return this.f13477e;
    }
}
