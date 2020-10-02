package com.applovin.impl.p033a;

import admost.sdk.base.AdMost;

/* renamed from: com.applovin.impl.a.d */
public enum C1483d {
    UNSPECIFIED(-1),
    XML_PARSING(100),
    GENERAL_WRAPPER_ERROR(AdMost.AD_ERROR_FREQ_CAP),
    TIMED_OUT(AdMost.AD_ERROR_FREQ_CAP_ON_SHOWN),
    WRAPPER_LIMIT_REACHED(AdMost.AD_ERROR_TAG_PASSIVE),
    NO_WRAPPER_RESPONSE(AdMost.AD_ERROR_ZONE_PASSIVE),
    GENERAL_LINEAR_ERROR(400),
    NO_MEDIA_FILE_PROVIDED(AdMost.AD_ERROR_WATERFALL_EMPTY),
    MEDIA_FILE_TIMEOUT(AdMost.AD_ERROR_INCOMPATIBLE_APP_ZONE_ID),
    MEDIA_FILE_ERROR(405),
    GENERAL_COMPANION_AD_ERROR(600),
    UNABLE_TO_FETCH_COMPANION_AD_RESOURCE(603),
    CAN_NOT_FIND_COMPANION_AD_RESOURCE(604);
    

    /* renamed from: n */
    private final int f4641n;

    private C1483d(int i) {
        this.f4641n = i;
    }

    /* renamed from: a */
    public int mo7199a() {
        return this.f4641n;
    }
}
