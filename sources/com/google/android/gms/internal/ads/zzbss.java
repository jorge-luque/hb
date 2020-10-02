package com.google.android.gms.internal.ads;

import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
public final class zzbss implements zzegz<zzbsq> {
    private final zzehm<Set<zzbvt<zzbsr>>> zzfjp;

    private zzbss(zzehm<Set<zzbvt<zzbsr>>> zzehm) {
        this.zzfjp = zzehm;
    }

    public static zzbss zzn(zzehm<Set<zzbvt<zzbsr>>> zzehm) {
        return new zzbss(zzehm);
    }

    public final /* synthetic */ Object get() {
        return new zzbsq(this.zzfjp.get());
    }
}
