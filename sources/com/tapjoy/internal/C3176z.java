package com.tapjoy.internal;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Build;
import javax.annotation.Nullable;

/* renamed from: com.tapjoy.internal.z */
public final class C3176z {
    @Nullable
    /* renamed from: a */
    public static String m10468a(PackageManager packageManager, String str) {
        try {
            return packageManager.getPackageInfo(str, 0).versionName;
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    /* renamed from: b */
    public static int m10469b(PackageManager packageManager, String str) {
        try {
            return packageManager.getPackageInfo(str, 0).versionCode;
        } catch (PackageManager.NameNotFoundException unused) {
            return 0;
        }
    }

    @SuppressLint({"NewApi"})
    /* renamed from: c */
    public static long m10470c(PackageManager packageManager, String str) {
        if (Build.VERSION.SDK_INT >= 9) {
            try {
                long j = packageManager.getPackageInfo(str, 0).firstInstallTime;
                if (j > 0) {
                    return j;
                }
            } catch (PackageManager.NameNotFoundException unused) {
            }
        }
        return 0;
    }

    /* renamed from: d */
    public static String m10471d(PackageManager packageManager, String str) {
        try {
            return C3166jq.m10435b(packageManager.getApplicationInfo(str, 0).sourceDir);
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    @Nullable
    /* renamed from: e */
    public static Signature[] m10472e(PackageManager packageManager, String str) {
        try {
            return packageManager.getPackageInfo(str, 64).signatures;
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    /* renamed from: a */
    public static int m10467a(Context context) {
        return m10469b(context.getPackageManager(), context.getPackageName());
    }
}
