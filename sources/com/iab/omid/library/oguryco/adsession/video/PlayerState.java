package com.iab.omid.library.oguryco.adsession.video;

import admost.sdk.base.AdMostZoneType;

public enum PlayerState {
    MINIMIZED("minimized"),
    COLLAPSED("collapsed"),
    NORMAL("normal"),
    EXPANDED("expanded"),
    FULLSCREEN(AdMostZoneType.FULLSCREEN);
    
    private final String playerState;

    private PlayerState(String str) {
        this.playerState = str;
    }

    public final String toString() {
        return this.playerState;
    }
}
