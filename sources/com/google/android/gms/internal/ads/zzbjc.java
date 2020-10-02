package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
final /* synthetic */ class zzbjc implements Runnable {
    private final zzbja zzfft;
    private final Runnable zzffu;

    zzbjc(zzbja zzbja, Runnable runnable) {
        this.zzfft = zzbja;
        this.zzffu = runnable;
    }

    public final void run() {
        this.zzfft.zzd(this.zzffu);
    }
}
