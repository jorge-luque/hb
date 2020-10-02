package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;

@TargetApi(17)
/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
public final class zzazd {
    private static zzazd zzdyl;
    String zzdym;

    private zzazd() {
    }

    public static zzazd zzxy() {
        if (zzdyl == null) {
            zzdyl = new zzazd();
        }
        return zzdyl;
    }
}
