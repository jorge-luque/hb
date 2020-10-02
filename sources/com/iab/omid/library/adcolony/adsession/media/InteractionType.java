package com.iab.omid.library.adcolony.adsession.media;

import com.tapjoy.TJAdUnitConstants;

public enum InteractionType {
    CLICK(TJAdUnitConstants.String.CLICK),
    INVITATION_ACCEPTED("invitationAccept");
    

    /* renamed from: a */
    String f11155a;

    private InteractionType(String str) {
        this.f11155a = str;
    }

    public String toString() {
        return this.f11155a;
    }
}
