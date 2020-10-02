package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
public final class zzcyf implements zzegz<zzcyd> {
    private final zzehm<zzdrh> zzenm;

    private zzcyf(zzehm<zzdrh> zzehm) {
        this.zzenm = zzehm;
    }

    public static zzcyf zzan(zzehm<zzdrh> zzehm) {
        return new zzcyf(zzehm);
    }

    public final /* synthetic */ Object get() {
        return new zzcyd(this.zzenm.get());
    }
}
