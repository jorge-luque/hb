package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
public final class zzbna implements zzegz<Boolean> {
    private final zzehm<zzdhe> zzfjq;

    public zzbna(zzehm<zzdhe> zzehm) {
        this.zzfjq = zzehm;
    }

    public final /* synthetic */ Object get() {
        boolean z;
        if (this.zzfjq.get().zzarx() != null) {
            z = ((Boolean) zzvj.zzpv().zzd(zzzz.zzcmc)).booleanValue();
        } else {
            z = ((Boolean) zzvj.zzpv().zzd(zzzz.zzcrs)).booleanValue();
        }
        return Boolean.valueOf(z);
    }
}
