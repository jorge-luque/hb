package com.google.android.gms.internal.ads;

import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
public final class zzbus implements zzegz<Set<zzbvt<zzbrl>>> {
    private final zzbuj zzfoh;

    private zzbus(zzbuj zzbuj) {
        this.zzfoh = zzbuj;
    }

    public static zzbus zzm(zzbuj zzbuj) {
        return new zzbus(zzbuj);
    }

    public final /* synthetic */ Object get() {
        return (Set) zzehf.zza(this.zzfoh.zzaje(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
