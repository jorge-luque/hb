package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
public final class zzctd implements zzegz<zzcsz> {
    private final zzehm<Executor> zzenm;

    public zzctd(zzehm<Executor> zzehm) {
        this.zzenm = zzehm;
    }

    public final /* synthetic */ Object get() {
        return new zzcsz(this.zzenm.get());
    }
}
