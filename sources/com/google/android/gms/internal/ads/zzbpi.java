package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
public final class zzbpi implements zzegz<zzbvt<zzbsm>> {
    private final zzehm<Executor> zzenm;
    private final zzehm<zzbke> zzfip;

    private zzbpi(zzehm<zzbke> zzehm, zzehm<Executor> zzehm2) {
        this.zzfip = zzehm;
        this.zzenm = zzehm2;
    }

    public static zzbvt<zzbsm> zza(zzbke zzbke, Executor executor) {
        return (zzbvt) zzehf.zza(new zzbvt(zzbke, executor), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static zzbpi zzh(zzehm<zzbke> zzehm, zzehm<Executor> zzehm2) {
        return new zzbpi(zzehm, zzehm2);
    }

    public final /* synthetic */ Object get() {
        return zza(this.zzfip.get(), this.zzenm.get());
    }
}
