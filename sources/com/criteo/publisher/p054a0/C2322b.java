package com.criteo.publisher.p054a0;

import android.content.Context;
import android.util.Log;

/* renamed from: com.criteo.publisher.a0.b */
public class C2322b {
    /* renamed from: a */
    public String mo10115a(Context context) {
        try {
            return (String) C2342q.m9000a("getId", context);
        } catch (Exception e) {
            Log.e("AdvertisingInfo", "Error getting advertising id: " + e.getMessage());
            return null;
        }
    }

    /* renamed from: b */
    public boolean mo10116b(Context context) {
        try {
            return ((Boolean) C2342q.m9000a("isLimitAdTrackingEnabled", context)).booleanValue();
        } catch (Exception e) {
            Log.e("AdvertisingInfo", "Error checking if ad tracking is limited: " + e.getMessage());
            return false;
        }
    }
}
