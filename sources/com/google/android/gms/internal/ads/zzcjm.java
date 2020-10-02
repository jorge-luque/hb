package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
final /* synthetic */ class zzcjm implements Callable {
    private final zzcjn zzgat;
    private final zzarj zzgau;

    zzcjm(zzcjn zzcjn, zzarj zzarj) {
        this.zzgat = zzcjn;
        this.zzgau = zzarj;
    }

    public final Object call() {
        return this.zzgat.zzf(this.zzgau);
    }
}
