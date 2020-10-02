package com.google.android.gms.common.util;

import android.os.Looper;

/* compiled from: com.google.android.gms:play-services-basement@@17.2.0 */
public final class zzc {
    public static boolean isMainThread() {
        return Looper.getMainLooper() == Looper.myLooper();
    }
}
