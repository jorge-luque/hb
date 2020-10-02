package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzq;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
final class zzbdj implements Runnable {
    private final /* synthetic */ zzbdk zzegm;

    zzbdj(zzbdk zzbdk) {
        this.zzegm = zzbdk;
    }

    public final void run() {
        zzq.zzls().zzb(this.zzegm);
    }
}
