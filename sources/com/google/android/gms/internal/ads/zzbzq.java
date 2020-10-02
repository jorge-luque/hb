package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
final /* synthetic */ class zzbzq implements Runnable {
    private final boolean zzecc;
    private final zzbzm zzfrn;

    zzbzq(zzbzm zzbzm, boolean z) {
        this.zzfrn = zzbzm;
        this.zzecc = z;
    }

    public final void run() {
        this.zzfrn.zzbj(this.zzecc);
    }
}
