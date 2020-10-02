package com.onesignal;

import android.content.Context;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.onesignal.C4564n1;

/* renamed from: com.onesignal.c */
/* compiled from: AdvertisingIdProviderGPS */
class C4479c implements C4484d {

    /* renamed from: a */
    private static String f12299a;

    C4479c() {
    }

    /* renamed from: a */
    static String m15437a() {
        return f12299a;
    }

    /* renamed from: a */
    public String mo29732a(Context context) {
        try {
            AdvertisingIdClient.Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(context);
            if (advertisingIdInfo.isLimitAdTrackingEnabled()) {
                f12299a = "OptedOut";
            } else {
                f12299a = advertisingIdInfo.getId();
            }
            return f12299a;
        } catch (Throwable th) {
            C4564n1.m15790a(C4564n1.C4566a0.INFO, "Error getting Google Ad id: ", th);
            return null;
        }
    }
}
