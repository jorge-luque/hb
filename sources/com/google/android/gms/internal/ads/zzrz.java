package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
final class zzrz implements zzqq {
    private final /* synthetic */ zzrx zzbsk;

    zzrz(zzrx zzrx) {
        this.zzbsk = zzrx;
    }

    public final void zzp(boolean z) {
        if (z) {
            this.zzbsk.connect();
        } else {
            this.zzbsk.disconnect();
        }
    }
}
