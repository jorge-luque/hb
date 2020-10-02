package com.google.android.gms.internal.ads;

import android.graphics.Bitmap;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
final /* synthetic */ class zzaud implements Runnable {
    private final zzaue zzdrm;
    private final Bitmap zzdrn;

    zzaud(zzaue zzaue, Bitmap bitmap) {
        this.zzdrm = zzaue;
        this.zzdrn = bitmap;
    }

    public final void run() {
        this.zzdrm.zza(this.zzdrn);
    }
}
