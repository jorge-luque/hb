package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
public final class zzboz implements zzegz<zzbvt<zzbqx>> {
    private final zzbox zzflw;
    private final zzehm<zzbpc> zzflx;

    private zzboz(zzbox zzbox, zzehm<zzbpc> zzehm) {
        this.zzflw = zzbox;
        this.zzflx = zzehm;
    }

    public static zzboz zzc(zzbox zzbox, zzehm<zzbpc> zzehm) {
        return new zzboz(zzbox, zzehm);
    }

    public final /* synthetic */ Object get() {
        return (zzbvt) zzehf.zza(new zzbvt(this.zzflx.get(), zzbab.zzdzw), "Cannot return null from a non-@Nullable @Provides method");
    }
}
