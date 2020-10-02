package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
final /* synthetic */ class zzcop implements Callable {
    private final zzdgo zzfjm;
    private final zzdha zzfvc;
    private final zzcom zzgfh;

    zzcop(zzcom zzcom, zzdha zzdha, zzdgo zzdgo) {
        this.zzgfh = zzcom;
        this.zzfvc = zzdha;
        this.zzfjm = zzdgo;
    }

    public final Object call() {
        return this.zzgfh.zzc(this.zzfvc, this.zzfjm);
    }
}
