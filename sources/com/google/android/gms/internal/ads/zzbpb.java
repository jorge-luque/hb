package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
public final class zzbpb implements zzegz<zzbvt<zzbsm>> {
    private final zzbox zzflw;
    private final zzehm<zzbpc> zzflx;

    private zzbpb(zzbox zzbox, zzehm<zzbpc> zzehm) {
        this.zzflw = zzbox;
        this.zzflx = zzehm;
    }

    public static zzbpb zzd(zzbox zzbox, zzehm<zzbpc> zzehm) {
        return new zzbpb(zzbox, zzehm);
    }

    public final /* synthetic */ Object get() {
        return (zzbvt) zzehf.zza(new zzbvt(this.zzflx.get(), zzbab.zzdzw), "Cannot return null from a non-@Nullable @Provides method");
    }
}
