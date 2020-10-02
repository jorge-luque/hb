package com.google.android.gms.internal.ads;

import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
public final class zzbuq implements zzegz<Set<zzbvt<zzub>>> {
    private final zzbuj zzfoh;

    private zzbuq(zzbuj zzbuj) {
        this.zzfoh = zzbuj;
    }

    public static zzbuq zzk(zzbuj zzbuj) {
        return new zzbuq(zzbuj);
    }

    public final /* synthetic */ Object get() {
        return (Set) zzehf.zza(this.zzfoh.zzajh(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
