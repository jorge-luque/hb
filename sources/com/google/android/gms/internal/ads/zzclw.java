package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
final /* synthetic */ class zzclw implements Callable {
    private final zzdri zzflc;
    private final zzdri zzfmu;
    private final zzclo zzgcn;

    zzclw(zzclo zzclo, zzdri zzdri, zzdri zzdri2) {
        this.zzgcn = zzclo;
        this.zzfmu = zzdri;
        this.zzflc = zzdri2;
    }

    public final Object call() {
        return this.zzgcn.zza(this.zzfmu, this.zzflc);
    }
}
