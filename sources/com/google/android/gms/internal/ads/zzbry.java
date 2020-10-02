package com.google.android.gms.internal.ads;

import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
public final class zzbry implements zzegz<zzbrr> {
    private final zzehm<Set<zzbvt<zzbrs>>> zzfjp;

    private zzbry(zzehm<Set<zzbvt<zzbrs>>> zzehm) {
        this.zzfjp = zzehm;
    }

    public static zzbry zzj(zzehm<Set<zzbvt<zzbrs>>> zzehm) {
        return new zzbry(zzehm);
    }

    public final /* synthetic */ Object get() {
        return new zzbrr(this.zzfjp.get());
    }
}
