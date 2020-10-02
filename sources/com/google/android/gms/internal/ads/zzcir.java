package com.google.android.gms.internal.ads;

import java.util.Set;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
public final class zzcir implements zzegz<Set<zzbvt<zzbsm>>> {
    private final zzehm<Executor> zzenm;
    private final zzehm<zzcix> zzfyg;
    private final zzcin zzfzt;

    private zzcir(zzcin zzcin, zzehm<zzcix> zzehm, zzehm<Executor> zzehm2) {
        this.zzfzt = zzcin;
        this.zzfyg = zzehm;
        this.zzenm = zzehm2;
    }

    public static Set<zzbvt<zzbsm>> zzb(zzcin zzcin, zzcix zzcix, Executor executor) {
        return (Set) zzehf.zza(zzcin.zzc(zzcix, executor), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static zzcir zzd(zzcin zzcin, zzehm<zzcix> zzehm, zzehm<Executor> zzehm2) {
        return new zzcir(zzcin, zzehm, zzehm2);
    }

    public final /* synthetic */ Object get() {
        return zzb(this.zzfzt, this.zzfyg.get(), this.zzenm.get());
    }
}
