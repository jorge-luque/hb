package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
final class zzbap implements zzdqx<T> {
    private final /* synthetic */ zzbaq zzead;

    zzbap(zzbaq zzbaq) {
        this.zzead = zzbaq;
    }

    public final void onSuccess(T t) {
        this.zzead.zzeaf.set(1);
    }

    public final void zzb(Throwable th) {
        this.zzead.zzeaf.set(-1);
    }
}
