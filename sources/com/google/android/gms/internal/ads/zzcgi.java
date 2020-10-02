package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
public final class zzcgi implements zzegz<zzbvt<zzbrc>> {
    private final zzehm<Executor> zzenm;
    private final zzehm<zzcgs> zzfhv;

    private zzcgi(zzehm<zzcgs> zzehm, zzehm<Executor> zzehm2) {
        this.zzfhv = zzehm;
        this.zzenm = zzehm2;
    }

    public static zzcgi zzt(zzehm<zzcgs> zzehm, zzehm<Executor> zzehm2) {
        return new zzcgi(zzehm, zzehm2);
    }

    public final /* synthetic */ Object get() {
        return (zzbvt) zzehf.zza(new zzbvt(this.zzfhv.get(), this.zzenm.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
