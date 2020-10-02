package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
public final class zzcxk implements zzegz<zzdgm> {
    private final zzehm<Clock> zzfhq;

    public zzcxk(zzehm<Clock> zzehm) {
        this.zzfhq = zzehm;
    }

    public final /* synthetic */ Object get() {
        return (zzdgm) zzehf.zza(new zzdgm(this.zzfhq.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
