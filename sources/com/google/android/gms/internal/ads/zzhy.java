package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
final class zzhy implements Runnable {
    private final /* synthetic */ String zzaii;
    private final /* synthetic */ long zzaij;
    private final /* synthetic */ long zzaik;
    private final /* synthetic */ zzhw zzail;

    zzhy(zzhw zzhw, String str, long j, long j2) {
        this.zzail = zzhw;
        this.zzaii = str;
        this.zzaij = j;
        this.zzaik = j2;
    }

    public final void run() {
        this.zzail.zzaih.zzb(this.zzaii, this.zzaij, this.zzaik);
    }
}
