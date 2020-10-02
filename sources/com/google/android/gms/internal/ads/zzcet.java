package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
public final class zzcet implements zzegz<zzcnj<zzcel>> {
    private final zzehm<zzcru<zzcel, zzdhq, zzcos>> zzfho;
    private final zzehm<zzdhe> zzfjq;
    private final zzehm<zzcru<zzcel, zzdhq, zzcot>> zzfwy;

    public zzcet(zzehm<zzcru<zzcel, zzdhq, zzcos>> zzehm, zzehm<zzcru<zzcel, zzdhq, zzcot>> zzehm2, zzehm<zzdhe> zzehm3) {
        this.zzfho = zzehm;
        this.zzfwy = zzehm2;
        this.zzfjq = zzehm3;
    }

    public final /* synthetic */ Object get() {
        zzcnj zzcnj;
        zzehm<zzcru<zzcel, zzdhq, zzcos>> zzehm = this.zzfho;
        zzehm<zzcru<zzcel, zzdhq, zzcot>> zzehm2 = this.zzfwy;
        if (zzceq.zzfwx[this.zzfjq.get().zzgvd.zzguh - 1] != 1) {
            zzcnj = zzehm2.get();
        } else {
            zzcnj = zzehm.get();
        }
        return (zzcnj) zzehf.zza(zzcnj, "Cannot return null from a non-@Nullable @Provides method");
    }
}
