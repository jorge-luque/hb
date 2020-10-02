package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
final class zzcor implements zzdqx<zzblx> {
    private final /* synthetic */ zzcom zzgfj;

    zzcor(zzcom zzcom) {
        this.zzgfj = zzcom;
    }

    public final /* synthetic */ void onSuccess(Object obj) {
        ((zzblx) obj).zzahk();
    }

    public final void zzb(Throwable th) {
        this.zzgfj.zzfoe.onAdFailedToLoad(zzcjk.zzd(th));
        zzdhn.zzc(th, "DelayedBannerAd.onFailure");
    }
}
