package com.iab.omid.library.oguryco.adsession.media;

import com.tapjoy.TJAdUnitConstants;

public enum InteractionType {
    CLICK(TJAdUnitConstants.String.CLICK),
    INVITATION_ACCEPTED("invitationAccept");
    
    String interactionType;

    private InteractionType(String str) {
        this.interactionType = str;
    }

    public final String toString() {
        return this.interactionType;
    }
}
