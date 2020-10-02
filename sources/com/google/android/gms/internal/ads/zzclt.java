package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
final /* synthetic */ class zzclt implements Callable {
    private final zzdri zzfmu;
    private final zzdri zzfvm;

    zzclt(zzdri zzdri, zzdri zzdri2) {
        this.zzfvm = zzdri;
        this.zzfmu = zzdri2;
    }

    public final Object call() {
        zzdri zzdri = this.zzfvm;
        zzdri zzdri2 = this.zzfmu;
        return new zzcmc((zzcmj) zzdri.get(), ((zzcmd) zzdri2.get()).zzgcr, ((zzcmd) zzdri2.get()).zzgcs);
    }
}
