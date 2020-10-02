package com.google.android.gms.internal.ads;

import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
public final class zzbtc implements zzegz<zzbta> {
    private final zzehm<zzdgo> zzfgv;
    private final zzehm<Set<zzbvt<zzbtb>>> zzfjp;

    private zzbtc(zzehm<Set<zzbvt<zzbtb>>> zzehm, zzehm<zzdgo> zzehm2) {
        this.zzfjp = zzehm;
        this.zzfgv = zzehm2;
    }

    public static zzbtc zzn(zzehm<Set<zzbvt<zzbtb>>> zzehm, zzehm<zzdgo> zzehm2) {
        return new zzbtc(zzehm, zzehm2);
    }

    public final /* synthetic */ Object get() {
        return new zzbta(this.zzfjp.get(), this.zzfgv.get());
    }
}
