package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
public final class zzbxc implements zzegz<zzbvt<zzbsm>> {
    private final zzehm<zzbyb> zzfip;
    private final zzbwx zzfpa;

    private zzbxc(zzbwx zzbwx, zzehm<zzbyb> zzehm) {
        this.zzfpa = zzbwx;
        this.zzfip = zzehm;
    }

    public static zzbxc zzb(zzbwx zzbwx, zzehm<zzbyb> zzehm) {
        return new zzbxc(zzbwx, zzehm);
    }

    public final /* synthetic */ Object get() {
        return (zzbvt) zzehf.zza(new zzbvt(this.zzfip.get(), zzbab.zzdzv), "Cannot return null from a non-@Nullable @Provides method");
    }
}
