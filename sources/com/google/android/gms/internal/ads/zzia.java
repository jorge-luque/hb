package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
final class zzia implements Runnable {
    private final /* synthetic */ zzhw zzail;
    private final /* synthetic */ int zzain;
    private final /* synthetic */ long zzaio;
    private final /* synthetic */ long zzaip;

    zzia(zzhw zzhw, int i, long j, long j2) {
        this.zzail = zzhw;
        this.zzain = i;
        this.zzaio = j;
        this.zzaip = j2;
    }

    public final void run() {
        this.zzail.zzaih.zzb(this.zzain, this.zzaio, this.zzaip);
    }
}
