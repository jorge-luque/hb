package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
public final class zzbyr implements zzegz<Set<String>> {
    private final zzehm<zzcae> zzfji;

    public zzbyr(zzehm<zzcae> zzehm) {
        this.zzfji = zzehm;
    }

    public static Set<String> zza(zzcae zzcae) {
        Set set;
        if (zzcae.zzalo() != null) {
            set = Collections.singleton("banner");
        } else {
            set = Collections.emptySet();
        }
        return (Set) zzehf.zza(set, "Cannot return null from a non-@Nullable @Provides method");
    }

    public final /* synthetic */ Object get() {
        return zza(this.zzfji.get());
    }
}
