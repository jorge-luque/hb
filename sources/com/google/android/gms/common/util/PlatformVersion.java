package com.google.android.gms.common.util;

import android.os.Build;
import android.util.Log;
import androidx.core.p022os.C0863a;
import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
@VisibleForTesting
/* compiled from: com.google.android.gms:play-services-basement@@17.2.0 */
public final class PlatformVersion {
    private static Boolean zzhu;

    private PlatformVersion() {
    }

    @KeepForSdk
    public static boolean isAtLeastHoneycomb() {
        return true;
    }

    @KeepForSdk
    public static boolean isAtLeastHoneycombMR1() {
        return true;
    }

    @KeepForSdk
    public static boolean isAtLeastIceCreamSandwich() {
        return true;
    }

    @KeepForSdk
    public static boolean isAtLeastIceCreamSandwichMR1() {
        return Build.VERSION.SDK_INT >= 15;
    }

    @KeepForSdk
    public static boolean isAtLeastJellyBean() {
        return Build.VERSION.SDK_INT >= 16;
    }

    @KeepForSdk
    public static boolean isAtLeastJellyBeanMR1() {
        return Build.VERSION.SDK_INT >= 17;
    }

    @KeepForSdk
    public static boolean isAtLeastJellyBeanMR2() {
        return Build.VERSION.SDK_INT >= 18;
    }

    @KeepForSdk
    public static boolean isAtLeastKitKat() {
        return Build.VERSION.SDK_INT >= 19;
    }

    @KeepForSdk
    public static boolean isAtLeastKitKatWatch() {
        return Build.VERSION.SDK_INT >= 20;
    }

    @KeepForSdk
    public static boolean isAtLeastLollipop() {
        return Build.VERSION.SDK_INT >= 21;
    }

    @KeepForSdk
    public static boolean isAtLeastLollipopMR1() {
        return Build.VERSION.SDK_INT >= 22;
    }

    @KeepForSdk
    public static boolean isAtLeastM() {
        return Build.VERSION.SDK_INT >= 23;
    }

    @KeepForSdk
    public static boolean isAtLeastN() {
        return Build.VERSION.SDK_INT >= 24;
    }

    @KeepForSdk
    public static boolean isAtLeastO() {
        return Build.VERSION.SDK_INT >= 26;
    }

    @KeepForSdk
    public static boolean isAtLeastP() {
        return Build.VERSION.SDK_INT >= 28;
    }

    @KeepForSdk
    public static boolean isAtLeastQ() {
        return Build.VERSION.SDK_INT >= 29;
    }

    @KeepForSdk
    public static boolean isAtLeastR() {
        boolean z = false;
        if (!isAtLeastQ()) {
            return false;
        }
        if (!(C0863a.m2830a() || (Build.VERSION.CODENAME.equals("REL") && Build.VERSION.SDK_INT >= 30) || (Build.VERSION.CODENAME.length() == 1 && Build.VERSION.CODENAME.charAt(0) >= 'R' && Build.VERSION.CODENAME.charAt(0) <= 'Z'))) {
            return false;
        }
        Boolean bool = zzhu;
        if (bool != null) {
            return bool.booleanValue();
        }
        try {
            if ("google".equals(Build.BRAND) && Integer.parseInt(Build.VERSION.INCREMENTAL) >= 5954562) {
                z = true;
            }
            zzhu = Boolean.valueOf(z);
        } catch (NumberFormatException unused) {
            zzhu = true;
        }
        if (!zzhu.booleanValue()) {
            Log.w("PlatformVersion", "Build version must be at least 5954562 to support R in gmscore");
        }
        return zzhu.booleanValue();
    }
}
