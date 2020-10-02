package com.google.android.gms.internal.ads;

import android.location.Location;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
final /* synthetic */ class zzcxo implements zzdnx {
    private final zzcxm zzgmz;

    zzcxo(zzcxm zzcxm) {
        this.zzgmz = zzcxm;
    }

    public final Object apply(Object obj) {
        zzcxm zzcxm = this.zzgmz;
        Location location = (Location) obj;
        if (location != null) {
            return location;
        }
        return zzcxm.zzfll.zzguw.zzmp;
    }
}
