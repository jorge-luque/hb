package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
public final class zzchs implements zzegz<zzbvt<zzdla>> {
    private final zzehm<Executor> zzenm;
    private final zzehm<zzcid> zzfhv;

    private zzchs(zzehm<zzcid> zzehm, zzehm<Executor> zzehm2) {
        this.zzfhv = zzehm;
        this.zzenm = zzehm2;
    }

    public static zzchs zzaf(zzehm<zzcid> zzehm, zzehm<Executor> zzehm2) {
        return new zzchs(zzehm, zzehm2);
    }

    public final /* synthetic */ Object get() {
        return (zzbvt) zzehf.zza(new zzbvt(this.zzfhv.get(), this.zzenm.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
