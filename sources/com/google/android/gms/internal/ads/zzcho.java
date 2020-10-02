package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
public final class zzcho implements zzegz<zzchp> {
    private final zzehm<zzcie> zzeoi;
    private final zzehm<zzchx> zzeqp;

    private zzcho(zzehm<zzchx> zzehm, zzehm<zzcie> zzehm2) {
        this.zzeqp = zzehm;
        this.zzeoi = zzehm2;
    }

    public static zzcho zzac(zzehm<zzchx> zzehm, zzehm<zzcie> zzehm2) {
        return new zzcho(zzehm, zzehm2);
    }

    public final /* synthetic */ Object get() {
        return new zzchp(this.zzeqp.get(), this.zzeoi.get());
    }
}
