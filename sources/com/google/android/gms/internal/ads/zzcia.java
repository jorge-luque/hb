package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
public final class zzcia implements zzegz<zzchz> {
    private final zzehm<Executor> zzenm;
    private final zzehm<zzcie> zzeoi;

    public zzcia(zzehm<zzcie> zzehm, zzehm<Executor> zzehm2) {
        this.zzeoi = zzehm;
        this.zzenm = zzehm2;
    }

    public final /* synthetic */ Object get() {
        return new zzchz(this.zzeoi.get(), this.zzenm.get());
    }
}
