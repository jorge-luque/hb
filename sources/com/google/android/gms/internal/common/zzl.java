package com.google.android.gms.internal.common;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;

/* compiled from: com.google.android.gms:play-services-basement@@17.2.0 */
public final class zzl {
    private static volatile boolean zzjs = (!zzam());
    private static boolean zzjt = false;

    @TargetApi(24)
    public static Context getDeviceProtectedStorageContext(Context context) {
        if (context.isDeviceProtectedStorage()) {
            return context;
        }
        return context.createDeviceProtectedStorageContext();
    }

    public static boolean zzam() {
        return Build.VERSION.SDK_INT >= 24;
    }
}
