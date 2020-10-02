package com.chartboost.sdk.impl;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.games.GamesStatusCodes;

/* renamed from: com.chartboost.sdk.impl.k1 */
public class C2172k1 {
    /* renamed from: a */
    public static boolean m8630a(Context context) {
        GoogleApiAvailability instance = GoogleApiAvailability.getInstance();
        int isGooglePlayServicesAvailable = instance.isGooglePlayServicesAvailable(context);
        if (isGooglePlayServicesAvailable == 0) {
            return true;
        }
        if (!instance.isUserResolvableError(isGooglePlayServicesAvailable) || !(context instanceof Activity)) {
            return false;
        }
        instance.getErrorDialog((Activity) context, isGooglePlayServicesAvailable, GamesStatusCodes.STATUS_VIDEO_NOT_ACTIVE).show();
        return true;
    }
}
