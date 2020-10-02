package com.google.android.gms.ads.internal.overlay;

import android.graphics.drawable.Drawable;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
final /* synthetic */ class zzk implements Runnable {
    private final zzl zzdkp;
    private final Drawable zzdkq;

    zzk(zzl zzl, Drawable drawable) {
        this.zzdkp = zzl;
        this.zzdkq = drawable;
    }

    public final void run() {
        zzl zzl = this.zzdkp;
        zzl.zzdkr.zzaad.getWindow().setBackgroundDrawable(this.zzdkq);
    }
}
