package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
public final class zzbps implements zzegz<zzbvt<zzbsm>> {
    private final zzehm<zzbqa> zzfhv;
    private final zzbpm zzfme;

    private zzbps(zzbpm zzbpm, zzehm<zzbqa> zzehm) {
        this.zzfme = zzbpm;
        this.zzfhv = zzehm;
    }

    public static zzbps zzb(zzbpm zzbpm, zzehm<zzbqa> zzehm) {
        return new zzbps(zzbpm, zzehm);
    }

    public final /* synthetic */ Object get() {
        return (zzbvt) zzehf.zza(new zzbvt(this.zzfhv.get(), zzbab.zzdzw), "Cannot return null from a non-@Nullable @Provides method");
    }
}
