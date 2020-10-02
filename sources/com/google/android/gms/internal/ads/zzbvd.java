package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
public final class zzbvd implements zzegz<Set<zzbvt<zzpz>>> {
    private final zzbuj zzfoh;

    private zzbvd(zzbuj zzbuj) {
        this.zzfoh = zzbuj;
    }

    public static zzbvd zzy(zzbuj zzbuj) {
        return new zzbvd(zzbuj);
    }

    public final /* synthetic */ Object get() {
        return (Set) zzehf.zza(Collections.emptySet(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
