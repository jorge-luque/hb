package com.ogury.p159cm;

import com.ogury.core.OguryError;

/* renamed from: com.ogury.cm.aaccb */
public final class aaccb {

    /* renamed from: a */
    public static final aaccb f12044a = new aaccb();

    private aaccb() {
    }

    /* renamed from: a */
    public static String m15046a(OguryError oguryError) {
        accbb.m15218b(oguryError, "oguryError");
        int errorCode = oguryError.getErrorCode();
        return errorCode != 0 ? errorCode != 1 ? errorCode != 2 ? errorCode != 3 ? errorCode != 1003 ? (errorCode == 1005 || errorCode == 1006) ? "fair-choice-error" : "system-error" : "form-error" : "server-not-responding" : "bundle-not-matching" : "assetKey-unknown" : "no-internet-connection";
    }
}
