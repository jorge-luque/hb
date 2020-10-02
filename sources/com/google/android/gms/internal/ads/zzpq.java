package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
final class zzpq implements Runnable {
    private final /* synthetic */ zzhf zzaiq;
    private final /* synthetic */ zzpl zzbki;

    zzpq(zzpl zzpl, zzhf zzhf) {
        this.zzbki = zzpl;
        this.zzaiq = zzhf;
    }

    public final void run() {
        this.zzbki.zzbkh.zzk(this.zzaiq);
    }
}
