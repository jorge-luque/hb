package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import com.google.android.gms.internal.ads.zzdah;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
final class zzcxf<S extends zzdah<?>> {
    private final Clock zzbnt;
    public final zzdri<S> zzgms;
    private final long zzgmt;

    public zzcxf(zzdri<S> zzdri, long j, Clock clock) {
        this.zzgms = zzdri;
        this.zzbnt = clock;
        this.zzgmt = clock.elapsedRealtime() + j;
    }

    public final boolean hasExpired() {
        return this.zzgmt < this.zzbnt.elapsedRealtime();
    }
}
