package com.google.android.gms.internal.ads;

import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
public final class zzbsg implements zzegz<zzbrx> {
    private final zzehm<Set<zzbvt<zzbqx>>> zzfjp;

    private zzbsg(zzehm<Set<zzbvt<zzbqx>>> zzehm) {
        this.zzfjp = zzehm;
    }

    public static zzbsg zzk(zzehm<Set<zzbvt<zzbqx>>> zzehm) {
        return new zzbsg(zzehm);
    }

    public final /* synthetic */ Object get() {
        return new zzbrx(this.zzfjp.get());
    }
}
