package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
public final class zzbur implements zzegz<Set<zzbvt<zzbtq>>> {
    private final zzbuj zzfoh;

    private zzbur(zzbuj zzbuj) {
        this.zzfoh = zzbuj;
    }

    public static zzbur zzl(zzbuj zzbuj) {
        return new zzbur(zzbuj);
    }

    public final /* synthetic */ Object get() {
        return (Set) zzehf.zza(Collections.emptySet(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
