package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
public final class zzcmq implements zzegz<zzcmp> {
    private final zzehm<zzcmn> zzetk;
    private final zzehm<zzdrh> zzgde;

    private zzcmq(zzehm<zzcmn> zzehm, zzehm<zzdrh> zzehm2) {
        this.zzetk = zzehm;
        this.zzgde = zzehm2;
    }

    public static zzcmq zzap(zzehm<zzcmn> zzehm, zzehm<zzdrh> zzehm2) {
        return new zzcmq(zzehm, zzehm2);
    }

    public final /* synthetic */ Object get() {
        return new zzcmp(this.zzetk.get(), this.zzgde.get());
    }
}
