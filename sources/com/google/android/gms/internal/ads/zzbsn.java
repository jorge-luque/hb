package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.reward.AdMetadataListener;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
public final class zzbsn implements zzegz<zzbsl> {
    private final zzehm<Set<zzbvt<AdMetadataListener>>> zzfjp;

    private zzbsn(zzehm<Set<zzbvt<AdMetadataListener>>> zzehm) {
        this.zzfjp = zzehm;
    }

    public static zzbsn zzm(zzehm<Set<zzbvt<AdMetadataListener>>> zzehm) {
        return new zzbsn(zzehm);
    }

    public final /* synthetic */ Object get() {
        return new zzbsl(this.zzfjp.get());
    }
}
