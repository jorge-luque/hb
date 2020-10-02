package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.overlay.zzc;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
final /* synthetic */ class zzbem implements Runnable {
    private final zzbej zzeii;

    zzbem(zzbej zzbej) {
        this.zzeii = zzbej;
    }

    public final void run() {
        zzbej zzbej = this.zzeii;
        zzbej.zzehs.zzabs();
        zzc zzabf = zzbej.zzehs.zzabf();
        if (zzabf != null) {
            zzabf.zzui();
        }
    }
}
