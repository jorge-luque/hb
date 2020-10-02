package com.google.android.gms.internal.ads;

import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
public final class zzbuy implements zzegz<Set<zzbvt<zzbtb>>> {
    private final zzbuj zzfoh;

    private zzbuy(zzbuj zzbuj) {
        this.zzfoh = zzbuj;
    }

    public static zzbuy zzt(zzbuj zzbuj) {
        return new zzbuy(zzbuj);
    }

    public final /* synthetic */ Object get() {
        return (Set) zzehf.zza(this.zzfoh.zzajk(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
