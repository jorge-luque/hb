package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
final /* synthetic */ class zzcnx implements zzbrp {
    private final zzbek zzelg;

    zzcnx(zzbek zzbek) {
        this.zzelg = zzbek;
    }

    public final void onAdImpression() {
        zzbek zzbek = this.zzelg;
        if (zzbek.zzabj() != null) {
            zzbek.zzabj().zzaav();
        }
    }
}
