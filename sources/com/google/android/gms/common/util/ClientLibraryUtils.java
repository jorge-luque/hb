package com.google.android.gms.common.util;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.wrappers.Wrappers;
import com.ogury.p159cm.OguryChoiceManager;

@KeepForSdk
/* compiled from: com.google.android.gms:play-services-basement@@17.2.0 */
public class ClientLibraryUtils {
    private ClientLibraryUtils() {
    }

    @KeepForSdk
    public static int getClientVersion(Context context, String str) {
        ApplicationInfo applicationInfo;
        Bundle bundle;
        PackageInfo zzb = zzb(context, str);
        if (zzb == null || (applicationInfo = zzb.applicationInfo) == null || (bundle = applicationInfo.metaData) == null) {
            return -1;
        }
        return bundle.getInt("com.google.android.gms.version", -1);
    }

    @KeepForSdk
    public static boolean isPackageSide() {
        return false;
    }

    private static PackageInfo zzb(Context context, String str) {
        try {
            return Wrappers.packageManager(context).getPackageInfo(str, OguryChoiceManager.TcfV2.Purpose.MEASURE_AD_PERFORMANCE);
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    public static boolean zzc(Context context, String str) {
        "com.google.android.gms".equals(str);
        try {
            if ((Wrappers.packageManager(context).getApplicationInfo(str, 0).flags & 2097152) != 0) {
                return true;
            }
            return false;
        } catch (PackageManager.NameNotFoundException unused) {
        }
    }
}
