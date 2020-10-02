package com.google.android.gms.internal.ads;

import android.os.Trace;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
public final class zzow {
    public static void beginSection(String str) {
        if (zzov.SDK_INT >= 18) {
            Trace.beginSection(str);
        }
    }

    public static void endSection() {
        if (zzov.SDK_INT >= 18) {
            Trace.endSection();
        }
    }
}
