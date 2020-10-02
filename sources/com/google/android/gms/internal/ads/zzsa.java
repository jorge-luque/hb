package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
final class zzsa implements Runnable {
    private final /* synthetic */ zzrx zzbsk;

    zzsa(zzrx zzrx) {
        this.zzbsk = zzrx;
    }

    public final void run() {
        this.zzbsk.disconnect();
    }
}
