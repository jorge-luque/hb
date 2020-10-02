package com.chartboost.sdk.impl;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import com.chartboost.sdk.C2242k;
import com.chartboost.sdk.Libraries.CBLogging;
import com.facebook.places.model.PlaceFields;

/* renamed from: com.chartboost.sdk.impl.w0 */
public class C2222w0 {
    /* renamed from: d */
    private ConnectivityManager m8799d() {
        Context context = C2242k.f7612l;
        if (context == null) {
            CBLogging.m8154b("CBReachability", "ConnectivityManager cannot be accessed due to missing context");
            return null;
        }
        try {
            return (ConnectivityManager) context.getSystemService("connectivity");
        } catch (Exception unused) {
            CBLogging.m8154b("CBReachability", "Chartboost SDK requires 'android.permission.ACCESS_NETWORK_STATE' permission set in your AndroidManifest.xml");
            return null;
        }
    }

    /* renamed from: e */
    private TelephonyManager m8800e() {
        Context context = C2242k.f7612l;
        if (context == null) {
            CBLogging.m8154b("CBReachability", "TelephonyManager cannot be accessed due to missing context");
            return null;
        }
        try {
            return (TelephonyManager) context.getSystemService(PlaceFields.PHONE);
        } catch (Exception unused) {
            CBLogging.m8154b("CBReachability", "Chartboost SDK requires 'android.permission.READ_PHONE_STATE' permission set in your AndroidManifest.xml");
            return null;
        }
    }

    /* renamed from: a */
    public int mo9537a() {
        ConnectivityManager d = m8799d();
        if (d == null) {
            CBLogging.m8152a("CBReachability", "NETWORK TYPE: unknown");
            return -1;
        }
        NetworkInfo activeNetworkInfo = d.getActiveNetworkInfo();
        if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
            CBLogging.m8152a("CBReachability", "NETWORK TYPE: NO Network");
            return 0;
        } else if (activeNetworkInfo.getType() == 1) {
            CBLogging.m8152a("CBReachability", "NETWORK TYPE: TYPE_WIFI");
            return 1;
        } else {
            CBLogging.m8152a("CBReachability", "NETWORK TYPE: TYPE_MOBILE");
            return 2;
        }
    }

    /* renamed from: b */
    public Integer mo9538b() {
        NetworkInfo activeNetworkInfo;
        ConnectivityManager d = m8799d();
        if (d != null && (activeNetworkInfo = d.getActiveNetworkInfo()) != null && activeNetworkInfo.isConnected() && activeNetworkInfo.getType() == 1) {
            return 2;
        }
        TelephonyManager e = m8800e();
        int i = 0;
        if (e != null) {
            try {
                i = e.getNetworkType();
            } catch (SecurityException unused) {
                CBLogging.m8154b("CBReachability", "Chartboost SDK requires 'android.permission.READ_PHONE_STATE' permission set in your AndroidManifest.xml");
            }
        }
        switch (i) {
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
                return 4;
            case 3:
            case 5:
            case 6:
            case 8:
            case 9:
            case 10:
            case 12:
            case 14:
            case 15:
                return 5;
            case 13:
                return 6;
            default:
                return 3;
        }
    }

    /* renamed from: c */
    public boolean mo9539c() {
        NetworkInfo activeNetworkInfo;
        ConnectivityManager d = m8799d();
        if (d == null || (activeNetworkInfo = d.getActiveNetworkInfo()) == null) {
            return false;
        }
        return activeNetworkInfo.isConnected();
    }
}
