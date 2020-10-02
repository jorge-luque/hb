package com.google.android.gms.internal.ads;

import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
public final class zzbug implements zzegz<zzbtx> {
    private final zzehm<Set<zzbvt<zzbuf>>> zzfjp;

    private zzbug(zzehm<Set<zzbvt<zzbuf>>> zzehm) {
        this.zzfjp = zzehm;
    }

    public static zzbug zzs(zzehm<Set<zzbvt<zzbuf>>> zzehm) {
        return new zzbug(zzehm);
    }

    public final /* synthetic */ Object get() {
        return new zzbtx(this.zzfjp.get());
    }
}
