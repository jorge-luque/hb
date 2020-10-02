package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
public final class zzboy implements zzegz<zzbvt<zzbrp>> {
    private final zzbox zzflw;
    private final zzehm<zzbpc> zzflx;

    private zzboy(zzbox zzbox, zzehm<zzbpc> zzehm) {
        this.zzflw = zzbox;
        this.zzflx = zzehm;
    }

    public static zzboy zzb(zzbox zzbox, zzehm<zzbpc> zzehm) {
        return new zzboy(zzbox, zzehm);
    }

    public final /* synthetic */ Object get() {
        return (zzbvt) zzehf.zza(new zzbvt(this.zzflx.get(), zzbab.zzdzw), "Cannot return null from a non-@Nullable @Provides method");
    }
}
