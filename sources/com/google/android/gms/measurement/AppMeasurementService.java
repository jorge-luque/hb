package com.google.android.gms.measurement;

import android.app.Service;
import android.app.job.JobParameters;
import android.content.Intent;
import android.os.IBinder;
import com.google.android.gms.measurement.internal.zzjl;
import com.google.android.gms.measurement.internal.zzjp;
import p075d.p088f.p089a.C3217a;

/* compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
public final class AppMeasurementService extends Service implements zzjp {
    private zzjl<AppMeasurementService> zza;

    private final zzjl<AppMeasurementService> zza() {
        if (this.zza == null) {
            this.zza = new zzjl<>(this);
        }
        return this.zza;
    }

    public final IBinder onBind(Intent intent) {
        return zza().zza(intent);
    }

    public final void onCreate() {
        super.onCreate();
        zza().zza();
    }

    public final void onDestroy() {
        zza().zzb();
        super.onDestroy();
    }

    public final void onRebind(Intent intent) {
        zza().zzc(intent);
    }

    public final int onStartCommand(Intent intent, int i, int i2) {
        return zza().zza(intent, i, i2);
    }

    public final boolean onUnbind(Intent intent) {
        return zza().zzb(intent);
    }

    public final boolean zza(int i) {
        return stopSelfResult(i);
    }

    public final void zza(JobParameters jobParameters, boolean z) {
        throw new UnsupportedOperationException();
    }

    public final void zza(Intent intent) {
        C3217a.completeWakefulIntent(intent);
    }
}
