package com.ogury.consent.manager.util.consent;

import com.ogury.p159cm.accbb;

public final class ConsentException extends Exception {
    private String type;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ConsentException(String str, String str2) {
        super(str2);
        accbb.m15218b(str, "type");
        accbb.m15218b(str2, "message");
        this.type = str;
    }

    public final String getType() {
        return this.type;
    }

    public final void setType(String str) {
        accbb.m15218b(str, "<set-?>");
        this.type = str;
    }
}
