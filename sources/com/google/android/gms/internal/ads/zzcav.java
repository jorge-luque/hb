package com.google.android.gms.internal.ads;

import android.view.ViewGroup;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
final /* synthetic */ class zzcav implements Runnable {
    private final zzcat zzftn;
    private final ViewGroup zzftt;

    zzcav(zzcat zzcat, ViewGroup viewGroup) {
        this.zzftn = zzcat;
        this.zzftt = viewGroup;
    }

    public final void run() {
        this.zzftn.zzb(this.zzftt);
    }
}
