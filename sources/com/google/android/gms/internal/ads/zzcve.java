package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
public final class zzcve implements zzegz<zzcvc> {
    private final zzehm<Executor> zzenm;
    private final zzehm<zzckv> zzglj;

    public zzcve(zzehm<Executor> zzehm, zzehm<zzckv> zzehm2) {
        this.zzenm = zzehm;
        this.zzglj = zzehm2;
    }

    public final /* synthetic */ Object get() {
        return new zzcvc(this.zzenm.get(), this.zzglj.get());
    }
}
