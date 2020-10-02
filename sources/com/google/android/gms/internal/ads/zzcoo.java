package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
final /* synthetic */ class zzcoo implements Runnable {
    private final zzdgo zzfjm;
    private final zzdha zzfvc;
    private final zzcom zzgfh;

    zzcoo(zzcom zzcom, zzdha zzdha, zzdgo zzdgo) {
        this.zzgfh = zzcom;
        this.zzfvc = zzdha;
        this.zzfjm = zzdgo;
    }

    public final void run() {
        this.zzgfh.zzd(this.zzfvc, this.zzfjm);
    }
}
