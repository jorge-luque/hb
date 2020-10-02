package com.ogury.core;

import com.ogury.p159cm.accbb;

public final class OguryError extends Exception {
    private final int errorCode;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public OguryError(int i, String str) {
        super(str);
        accbb.m15218b(str, "message");
        this.errorCode = i;
    }

    public final int getErrorCode() {
        return this.errorCode;
    }
}
