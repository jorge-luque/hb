package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.1.0 */
final class zzxu extends zzvi {
    private final /* synthetic */ zzxv zzcgw;

    zzxu(zzxv zzxv) {
        this.zzcgw = zzxv;
    }

    public final void onAdFailedToLoad(int i) {
        this.zzcgw.zzcgy.zza(this.zzcgw.zzdu());
        super.onAdFailedToLoad(i);
    }

    public final void onAdLoaded() {
        this.zzcgw.zzcgy.zza(this.zzcgw.zzdu());
        super.onAdLoaded();
    }
}
