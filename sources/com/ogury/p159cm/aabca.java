package com.ogury.p159cm;

import com.facebook.appevents.AppEventsConstants;

/* renamed from: com.ogury.cm.aabca */
public final class aabca {

    /* renamed from: a */
    public static final aabca f12012a = new aabca();

    private aabca() {
    }

    /* renamed from: a */
    public static String m15003a(int i) {
        String binaryString = Integer.toBinaryString(i);
        accbb.m15215a((Object) binaryString, "binaryString");
        accbb.m15218b(binaryString, "receiver$0");
        int length = 32 - binaryString.length();
        if (length > 0) {
            int i2 = 1;
            while (true) {
                binaryString = AppEventsConstants.EVENT_PARAM_VALUE_NO.concat(String.valueOf(binaryString));
                if (i2 == length) {
                    break;
                }
                i2++;
            }
        }
        return binaryString;
    }
}
