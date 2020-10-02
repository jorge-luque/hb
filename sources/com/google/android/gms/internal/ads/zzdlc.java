package com.google.android.gms.internal.ads;

import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
public final class zzdlc implements zzegz<zzdkt> {
    private final zzehm<Set<zzbvt<zzdla>>> zzfjp;

    private zzdlc(zzehm<Set<zzbvt<zzdla>>> zzehm) {
        this.zzfjp = zzehm;
    }

    public static zzdlc zzaq(zzehm<Set<zzbvt<zzdla>>> zzehm) {
        return new zzdlc(zzehm);
    }

    public final /* synthetic */ Object get() {
        return new zzdkt(this.zzfjp.get());
    }
}
