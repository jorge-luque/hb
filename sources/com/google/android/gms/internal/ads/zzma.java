package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
final class zzma implements Runnable {
    private final /* synthetic */ zzly zzbau;

    zzma(zzly zzly) {
        this.zzbau = zzly;
    }

    public final void run() {
        if (!this.zzbau.zzaez) {
            this.zzbau.zzbbh.zza(this.zzbau);
        }
    }
}
