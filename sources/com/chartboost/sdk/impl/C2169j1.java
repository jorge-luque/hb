package com.chartboost.sdk.impl;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Build;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import com.chartboost.sdk.Libraries.CBLogging;
import com.facebook.places.model.PlaceFields;
import com.ogury.p159cm.OguryChoiceManager;
import com.tapjoy.TapjoyConstants;
import java.util.UUID;

/* renamed from: com.chartboost.sdk.impl.j1 */
public class C2169j1 {

    /* renamed from: a */
    private static int f7302a = 4;

    /* renamed from: b */
    private static int f7303b = 5;

    /* renamed from: a */
    public static String m8618a(Context context) {
        String str = null;
        try {
            Object obj = context.getPackageManager().getApplicationInfo(context.getPackageName(), OguryChoiceManager.TcfV2.Purpose.MEASURE_AD_PERFORMANCE).metaData.get("cb.limit.aid");
            if ((obj instanceof Integer) && ((Integer) obj).intValue() == 1) {
                return null;
            }
        } catch (Exception unused) {
        }
        String string = Settings.Secure.getString(context.getContentResolver(), TapjoyConstants.TJC_ANDROID_ID);
        if (!"9774d56d682e549c".equals(string)) {
            str = string;
        }
        return str == null ? m8621d(context) : str;
    }

    /* renamed from: b */
    public static int m8619b(Context context) {
        if (context == null) {
            return 0;
        }
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(PlaceFields.PHONE);
            if (telephonyManager != null) {
                return telephonyManager.getNetworkType();
            }
            return 0;
        } catch (SecurityException unused) {
            CBLogging.m8154b("DeviceInfo", "Chartboost SDK requires 'android.permission.READ_PHONE_STATE' permission set in your AndroidManifest.xml");
            return 0;
        }
    }

    /* renamed from: c */
    public static Integer m8620c(Context context) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        float f = ((float) displayMetrics.heightPixels) / displayMetrics.ydpi;
        float f2 = ((float) displayMetrics.widthPixels) / displayMetrics.xdpi;
        if (Math.sqrt((double) ((f2 * f2) + (f * f))) >= 6.5d) {
            return Integer.valueOf(f7303b);
        }
        return Integer.valueOf(f7302a);
    }

    /* renamed from: d */
    private static String m8621d(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("cbPrefs", 0);
        if (sharedPreferences == null) {
            return UUID.randomUUID().toString();
        }
        String string = sharedPreferences.getString("cbUUID", (String) null);
        if (string != null) {
            return string;
        }
        String uuid = UUID.randomUUID().toString();
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putString("cbUUID", uuid);
        edit.apply();
        return uuid;
    }

    /* renamed from: e */
    public static String m8622e(Context context) {
        PackageManager packageManager = context.getPackageManager();
        int i = context.getResources().getConfiguration().uiMode & 15;
        int i2 = context.getResources().getConfiguration().screenLayout & 15;
        if (packageManager.hasSystemFeature("org.chromium.arc.device_management")) {
            return "chromebook";
        }
        String str = Build.BRAND;
        if (str != null && str.equals("chromium") && Build.MANUFACTURER.equals("chromium")) {
            return "chromebook";
        }
        String str2 = Build.DEVICE;
        if (str2 != null && str2.matches(".+_cheets")) {
            return "chromebook";
        }
        if (packageManager.hasSystemFeature("android.hardware.type.watch") || i == 6) {
            return "watch";
        }
        if (packageManager.hasSystemFeature("android.hardware.type.television") || i == 4) {
            return "tv";
        }
        String str3 = Build.MANUFACTURER;
        return ((str3 == null || !str3.equalsIgnoreCase("Amazon")) && i2 != 4) ? PlaceFields.PHONE : "tablet";
    }
}
