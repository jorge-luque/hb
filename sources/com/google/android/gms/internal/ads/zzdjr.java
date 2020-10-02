package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
public final class zzdjr implements zzegz<zzdrh> {
    public static zzdjr zzatp() {
        return zzdju.zzgyu;
    }

    public final /* synthetic */ Object get() {
        zzdrh zzdrh;
        if (((Boolean) zzvj.zzpv().zzd(zzzz.zzcrx)).booleanValue()) {
            zzdrh = zzbab.zzdzt;
        } else {
            if (((Boolean) zzvj.zzpv().zzd(zzzz.zzcrw)).booleanValue()) {
                zzdrh = zzbab.zzdzr;
            } else {
                zzdrh = zzbab.zzdzv;
            }
        }
        return (zzdrh) zzehf.zza(zzdrh, "Cannot return null from a non-@Nullable @Provides method");
    }
}
