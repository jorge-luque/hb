package com.adcolony.sdk;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.adcolony.sdk.C1439u;
import com.tapjoy.TapjoyConstants;

/* renamed from: com.adcolony.sdk.b0 */
class C1204b0 {
    C1204b0() {
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public String mo6396a() {
        if (mo6398c()) {
            return TapjoyConstants.TJC_CONNECTION_TYPE_WIFI;
        }
        return mo6397b() ? "cell" : "none";
    }

    /* access modifiers changed from: package-private */
    @SuppressLint({"MissingPermission"})
    /* renamed from: b */
    public boolean mo6397b() {
        NetworkInfo networkInfo;
        Context b = C1199a.m4878b();
        if (b == null) {
            return false;
        }
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) b.getApplicationContext().getSystemService("connectivity");
            if (connectivityManager == null) {
                networkInfo = null;
            } else {
                networkInfo = connectivityManager.getActiveNetworkInfo();
            }
            if (networkInfo == null) {
                return false;
            }
            int type = networkInfo.getType();
            if (type == 0 || type >= 2) {
                return true;
            }
            return false;
        } catch (SecurityException e) {
            new C1439u.C1440a().mo6801a("SecurityException - please ensure you added the ").mo6801a("ACCESS_NETWORK_STATE permission: ").mo6801a(e.toString()).mo6803a(C1439u.f4516i);
            return false;
        } catch (Exception e2) {
            new C1439u.C1440a().mo6801a("Exception occurred when retrieving activeNetworkInfo in ").mo6801a("ADCNetwork.using_mobile(): ").mo6801a(e2.toString()).mo6803a(C1439u.f4517j);
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    @SuppressLint({"MissingPermission"})
    /* renamed from: c */
    public boolean mo6398c() {
        NetworkInfo networkInfo;
        Context b = C1199a.m4878b();
        if (b == null) {
            return false;
        }
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) b.getApplicationContext().getSystemService("connectivity");
            if (connectivityManager == null) {
                networkInfo = null;
            } else {
                networkInfo = connectivityManager.getActiveNetworkInfo();
            }
            if (networkInfo != null && networkInfo.getType() == 1) {
                return true;
            }
            return false;
        } catch (SecurityException e) {
            new C1439u.C1440a().mo6801a("SecurityException - please ensure you added the ").mo6801a("ACCESS_NETWORK_STATE permission: ").mo6801a(e.toString()).mo6803a(C1439u.f4516i);
            return false;
        } catch (Exception e2) {
            new C1439u.C1440a().mo6801a("Exception occurred when retrieving activeNetworkInfo in ").mo6801a("ADCNetwork.using_wifi(): ").mo6801a(e2.toString()).mo6803a(C1439u.f4517j);
            return false;
        }
    }
}
