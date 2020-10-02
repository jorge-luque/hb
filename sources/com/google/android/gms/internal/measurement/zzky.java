package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
public final class zzky implements zzde<zzlb> {
    private static zzky zza = new zzky();
    private final zzde<zzlb> zzb;

    private zzky(zzde<zzlb> zzde) {
        this.zzb = zzdh.zza(zzde);
    }

    public static boolean zzb() {
        return ((zzlb) zza.zza()).zza();
    }

    public static boolean zzc() {
        return ((zzlb) zza.zza()).zzb();
    }

    public final /* synthetic */ Object zza() {
        return this.zzb.zza();
    }

    public zzky() {
        this(zzdh.zza(new zzla()));
    }
}
