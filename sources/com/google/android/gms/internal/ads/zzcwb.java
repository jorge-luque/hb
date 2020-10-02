package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
public final class zzcwb implements zzegz<zzcvz> {
    private final zzehm<zzcfz> zzenj;
    private final zzehm<zzdrh> zzgln;
    private final zzehm<String> zzgmb;

    private zzcwb(zzehm<String> zzehm, zzehm<zzdrh> zzehm2, zzehm<zzcfz> zzehm3) {
        this.zzgmb = zzehm;
        this.zzgln = zzehm2;
        this.zzenj = zzehm3;
    }

    public static zzcwb zzq(zzehm<String> zzehm, zzehm<zzdrh> zzehm2, zzehm<zzcfz> zzehm3) {
        return new zzcwb(zzehm, zzehm2, zzehm3);
    }

    public final /* synthetic */ Object get() {
        return new zzcvz(this.zzgmb.get(), this.zzgln.get(), this.zzenj.get());
    }
}
