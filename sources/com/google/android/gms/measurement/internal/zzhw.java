package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
final class zzhw implements Runnable {
    private final /* synthetic */ boolean zza;
    private final /* synthetic */ zzhc zzb;

    zzhw(zzhc zzhc, boolean z) {
        this.zzb = zzhc;
        this.zza = z;
    }

    public final void run() {
        boolean zzab = this.zzb.zzz.zzab();
        boolean zzaa = this.zzb.zzz.zzaa();
        this.zzb.zzz.zza(this.zza);
        if (zzaa == this.zza) {
            this.zzb.zzz.zzr().zzx().zza("Default data collection state already set to", Boolean.valueOf(this.zza));
        }
        if (this.zzb.zzz.zzab() == zzab || this.zzb.zzz.zzab() != this.zzb.zzz.zzaa()) {
            this.zzb.zzz.zzr().zzk().zza("Default data collection is different than actual status", Boolean.valueOf(this.zza), Boolean.valueOf(zzab));
        }
        this.zzb.zzam();
    }
}
