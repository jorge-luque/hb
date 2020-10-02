package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.1.0 */
final /* synthetic */ class zzxy implements Runnable {
    private final zzxw zzchl;
    private final OnInitializationCompleteListener zzchm;

    zzxy(zzxw zzxw, OnInitializationCompleteListener onInitializationCompleteListener) {
        this.zzchl = zzxw;
        this.zzchm = onInitializationCompleteListener;
    }

    public final void run() {
        this.zzchl.zza(this.zzchm);
    }
}
