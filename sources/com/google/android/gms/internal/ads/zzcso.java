package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
public final class zzcso implements zzegz<zzcsm> {
    private final zzcsm zzgim;

    private zzcso(zzcsm zzcsm) {
        this.zzgim = zzcsm;
    }

    public static zzcso zzc(zzcsm zzcsm) {
        return new zzcso(zzcsm);
    }

    public final /* synthetic */ Object get() {
        zzcsm zzcsm = this.zzgim;
        if (zzcsm != null) {
            return (zzcsm) zzehf.zza(zzcsm, "Cannot return null from a non-@Nullable @Provides method");
        }
        throw null;
    }
}
