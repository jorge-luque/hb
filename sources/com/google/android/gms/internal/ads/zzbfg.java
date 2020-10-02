package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
final /* synthetic */ class zzbfg implements Runnable {
    private final int zzdwt;
    private final int zzdwu;
    private final boolean zzeiu;
    private final boolean zzeiv;
    private final zzbfe zzeku;

    zzbfg(zzbfe zzbfe, int i, int i2, boolean z, boolean z2) {
        this.zzeku = zzbfe;
        this.zzdwt = i;
        this.zzdwu = i2;
        this.zzeiu = z;
        this.zzeiv = z2;
    }

    public final void run() {
        this.zzeku.zzb(this.zzdwt, this.zzdwu, this.zzeiu, this.zzeiv);
    }
}
