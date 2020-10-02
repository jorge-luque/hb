package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
final /* synthetic */ class zzbjd implements Runnable {
    private final zzbja zzfft;
    private final Runnable zzffu;

    zzbjd(zzbja zzbja, Runnable runnable) {
        this.zzfft = zzbja;
        this.zzffu = runnable;
    }

    public final void run() {
        zzbab.zzdzv.execute(new zzbjc(this.zzfft, this.zzffu));
    }
}
