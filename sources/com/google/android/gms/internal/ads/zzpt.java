package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
final class zzpt implements Runnable {
    private final /* synthetic */ zziy zzais;
    private final /* synthetic */ zzpl zzbki;

    zzpt(zzpl zzpl, zziy zziy) {
        this.zzbki = zzpl;
        this.zzais = zziy;
    }

    public final void run() {
        this.zzais.zzgm();
        this.zzbki.zzbkh.zzf(this.zzais);
    }
}
