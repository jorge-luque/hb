package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
public final class zzbny {
    public final List<? extends zzdri<? extends zzbns>> zzfkv;

    public zzbny(List<? extends zzdri<? extends zzbns>> list) {
        this.zzfkv = list;
    }

    public static zzcnj<zzbny> zza(zzcpk<? extends zzbns> zzcpk) {
        return new zzcni(zzcpk, zzbob.zzdsc);
    }

    public static zzcnj<zzbny> zza(zzcnj<? extends zzbns> zzcnj) {
        return new zzcni(zzcnj, zzboa.zzdsc);
    }

    public zzbny(zzbns zzbns) {
        this.zzfkv = Collections.singletonList(zzdqw.zzag(zzbns));
    }
}
