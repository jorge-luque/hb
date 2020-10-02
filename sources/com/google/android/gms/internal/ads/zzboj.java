package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
final class zzboj implements zzdqx<zzbns> {
    private final /* synthetic */ zzdqx zzfld;
    private final /* synthetic */ zzbod zzfle;

    zzboj(zzbod zzbod, zzdqx zzdqx) {
        this.zzfle = zzbod;
        this.zzfld = zzdqx;
    }

    public final /* synthetic */ void onSuccess(Object obj) {
        this.zzfle.zzaic();
        this.zzfld.onSuccess((zzbns) obj);
    }

    public final void zzb(Throwable th) {
        this.zzfle.zzaic();
        this.zzfld.zzb(th);
    }
}
