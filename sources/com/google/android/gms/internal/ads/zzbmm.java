package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
public final class zzbmm implements zzegz<Set<zzbvt<zzpz>>> {
    private final zzehm<zzbnn> zzfip;
    private final zzbma zzfjo;

    public zzbmm(zzbma zzbma, zzehm<zzbnn> zzehm) {
        this.zzfjo = zzbma;
        this.zzfip = zzehm;
    }

    public final /* synthetic */ Object get() {
        return (Set) zzehf.zza(Collections.singleton(new zzbvt(this.zzfip.get(), zzbab.zzdzw)), "Cannot return null from a non-@Nullable @Provides method");
    }
}
