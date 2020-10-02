package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
final class zzpo implements Runnable {
    private final /* synthetic */ zziy zzaim;
    private final /* synthetic */ zzpl zzbki;

    zzpo(zzpl zzpl, zziy zziy) {
        this.zzbki = zzpl;
        this.zzaim = zziy;
    }

    public final void run() {
        this.zzbki.zzbkh.zze(this.zzaim);
    }
}
