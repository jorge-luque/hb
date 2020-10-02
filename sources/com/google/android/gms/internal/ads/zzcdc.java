package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
public final class zzcdc implements zzegz<zzccr> {
    private final zzehm<Executor> zzfjj;
    private final zzehm<zzdhe> zzfjq;
    private final zzehm<zzcey> zzfuf;

    public zzcdc(zzehm<zzdhe> zzehm, zzehm<Executor> zzehm2, zzehm<zzcey> zzehm3) {
        this.zzfjq = zzehm;
        this.zzfjj = zzehm2;
        this.zzfuf = zzehm3;
    }

    public final /* synthetic */ Object get() {
        return new zzccr(this.zzfjq.get(), this.zzfjj.get(), this.zzfuf.get());
    }
}
