package com.google.android.gms.measurement.internal;

import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
final class zziv implements Runnable {
    private final /* synthetic */ zzii zza;
    private final /* synthetic */ zzin zzb;

    zziv(zzin zzin, zzii zzii) {
        this.zzb = zzin;
        this.zza = zzii;
    }

    public final void run() {
        zzel zzd = this.zzb.zzb;
        if (zzd == null) {
            this.zzb.zzr().zzf().zza("Failed to send current screen to service");
            return;
        }
        try {
            if (this.zza == null) {
                zzd.zza(0, (String) null, (String) null, this.zzb.zzn().getPackageName());
            } else {
                zzd.zza(this.zza.zzc, this.zza.zza, this.zza.zzb, this.zzb.zzn().getPackageName());
            }
            this.zzb.zzak();
        } catch (RemoteException e) {
            this.zzb.zzr().zzf().zza("Failed to send current screen to the service", e);
        }
    }
}
