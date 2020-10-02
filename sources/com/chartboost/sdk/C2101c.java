package com.chartboost.sdk;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.text.TextUtils;
import com.chartboost.sdk.Libraries.CBLogging;
import com.chartboost.sdk.Model.C2093h;
import com.chartboost.sdk.Tracking.C2098a;
import com.chartboost.sdk.impl.C2224x;
import com.facebook.internal.AnalyticsEvents;
import com.ogury.p159cm.OguryChoiceManager;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONObject;

/* renamed from: com.chartboost.sdk.c */
public final class C2101c {
    /* renamed from: a */
    static void m8324a(String str) {
        if (C2242k.f7605e == null) {
            CBLogging.m8154b("CBConfig", "Set a valid CBFramework first");
        } else if (TextUtils.isEmpty(str)) {
            CBLogging.m8154b("CBConfig", "Invalid Version String");
        } else {
            C2242k.f7603c = str;
        }
    }

    /* renamed from: b */
    private static boolean m8329b() {
        return C2239j.m8897n() != null;
    }

    /* renamed from: c */
    public static boolean m8331c() {
        return m8325a() && m8329b();
    }

    /* renamed from: b */
    public static boolean m8330b(Context context) {
        int i;
        int i2;
        int i3;
        int i4;
        if (context != null) {
            try {
                if (C2224x.m8805e().mo9548a(23)) {
                    i4 = context.checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE");
                    i2 = context.checkSelfPermission("android.permission.ACCESS_NETWORK_STATE");
                    i3 = context.checkSelfPermission("android.permission.INTERNET");
                    i = context.checkSelfPermission("android.permission.READ_PHONE_STATE");
                } else {
                    i4 = context.checkCallingOrSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE");
                    i2 = context.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE");
                    i3 = context.checkCallingOrSelfPermission("android.permission.INTERNET");
                    i = context.checkCallingOrSelfPermission("android.permission.READ_PHONE_STATE");
                }
                C2242k.f7613m = i4 != 0;
                C2242k.f7614n = i3 != 0;
                C2242k.f7615o = i2 != 0;
                C2242k.f7616p = i != 0;
                if (C2242k.f7614n) {
                    throw new RuntimeException("Please add the permission : android.permission.INTERNET in your android manifest.xml");
                } else if (!C2242k.f7615o) {
                    return true;
                } else {
                    throw new RuntimeException("Please add the permission : android.permission.ACCESS_NETWORK_STATE in your android manifest.xml");
                }
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        } else {
            throw new RuntimeException("Invalid activity context passed during intitalization");
        }
    }

    /* renamed from: a */
    public static boolean m8328a(AtomicReference<C2093h> atomicReference, JSONObject jSONObject, SharedPreferences sharedPreferences) {
        try {
            atomicReference.set(new C2093h(jSONObject));
            return true;
        } catch (Exception e) {
            C2098a.m8288a(C2101c.class, "updateConfig", e);
            return false;
        }
    }

    /* renamed from: a */
    static boolean m8326a(Activity activity) {
        if (activity != null) {
            return true;
        }
        try {
            throw new Exception("Invalid activity context: Host Activity object is null, Please send a valid activity object");
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /* renamed from: a */
    static boolean m8325a() {
        try {
            if (C2239j.m8897n() == null) {
                throw new Exception("SDK Initialization error. SDK seems to be not initialized properly, check for any integration issues");
            } else if (C2242k.f7612l == null) {
                throw new Exception("SDK Initialization error. Activity context seems to be not initialized properly, host activity or application context is being sent as null");
            } else if (TextUtils.isEmpty(C2242k.f7610j)) {
                throw new Exception("SDK Initialization error. AppId is missing");
            } else if (!TextUtils.isEmpty(C2242k.f7611k)) {
                return true;
            } else {
                throw new Exception("SDK Initialization error. AppSignature is missing");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /* renamed from: a */
    public static boolean m8327a(Context context) {
        List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(new Intent(context, CBImpressionActivity.class), 0);
        if (queryIntentActivities.isEmpty()) {
            return false;
        }
        ActivityInfo activityInfo = queryIntentActivities.get(0).activityInfo;
        int i = activityInfo.flags;
        if ((i & 512) == 0 || (i & 32) == 0) {
            return false;
        }
        int i2 = activityInfo.configChanges;
        if ((i2 & OguryChoiceManager.TcfV2.Purpose.MEASURE_AD_PERFORMANCE) == 0 || (i2 & 32) == 0 || (i2 & OguryChoiceManager.TcfV2.Purpose.DEVELOP_AND_IMPROVE_PRODUCTS) == 0) {
            return false;
        }
        return true;
    }

    /* renamed from: a */
    public static String m8323a(C2093h hVar) {
        return !hVar.f7023w ? "native" : AnalyticsEvents.PARAMETER_SHARE_DIALOG_SHOW_WEB;
    }
}
