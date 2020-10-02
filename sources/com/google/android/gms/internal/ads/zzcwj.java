package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
public final class zzcwj implements zzegz<zzcwi> {
    private final zzehm<Executor> zzenm;
    private final zzehm<zzawd> zzglv;

    private zzcwj(zzehm<Executor> zzehm, zzehm<zzawd> zzehm2) {
        this.zzenm = zzehm;
        this.zzglv = zzehm2;
    }

    public static zzcwi zza(Executor executor, zzawd zzawd) {
        return new zzcwi(executor, zzawd);
    }

    public static zzcwj zzas(zzehm<Executor> zzehm, zzehm<zzawd> zzehm2) {
        return new zzcwj(zzehm, zzehm2);
    }

    public final /* synthetic */ Object get() {
        return zza(this.zzenm.get(), this.zzglv.get());
    }
}
