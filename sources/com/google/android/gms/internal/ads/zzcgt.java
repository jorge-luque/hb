package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
public final class zzcgt implements zzegz<Set<zzbvt<zzdla>>> {
    private final zzehm<Executor> zzenm;
    private final zzehm<zzchj> zzfhv;

    private zzcgt(zzehm<Executor> zzehm, zzehm<zzchj> zzehm2) {
        this.zzenm = zzehm;
        this.zzfhv = zzehm2;
    }

    public static zzcgt zzz(zzehm<Executor> zzehm, zzehm<zzchj> zzehm2) {
        return new zzcgt(zzehm, zzehm2);
    }

    public final /* synthetic */ Object get() {
        Set set;
        Executor executor = this.zzenm.get();
        zzchj zzchj = this.zzfhv.get();
        if (((Boolean) zzvj.zzpv().zzd(zzzz.zzcqq)).booleanValue()) {
            set = Collections.singleton(new zzbvt(zzchj, executor));
        } else {
            set = Collections.emptySet();
        }
        return (Set) zzehf.zza(set, "Cannot return null from a non-@Nullable @Provides method");
    }
}
