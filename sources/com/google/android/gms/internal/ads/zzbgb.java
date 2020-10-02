package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.overlay.zzc;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
final /* synthetic */ class zzbgb implements Runnable {
    private final zzbgc zzelk;

    zzbgb(zzbgc zzbgc) {
        this.zzelk = zzbgc;
    }

    public final void run() {
        zzbgc zzbgc = this.zzelk;
        zzbgc.zzehs.zzabs();
        zzc zzabf = zzbgc.zzehs.zzabf();
        if (zzabf != null) {
            zzabf.zzui();
        }
    }
}
