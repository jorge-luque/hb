package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import android.text.TextUtils;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
final class zzjb implements Runnable {
    private final /* synthetic */ AtomicReference zza;
    private final /* synthetic */ String zzb;
    private final /* synthetic */ String zzc;
    private final /* synthetic */ String zzd;
    private final /* synthetic */ zzm zze;
    private final /* synthetic */ zzin zzf;

    zzjb(zzin zzin, AtomicReference atomicReference, String str, String str2, String str3, zzm zzm) {
        this.zzf = zzin;
        this.zza = atomicReference;
        this.zzb = str;
        this.zzc = str2;
        this.zzd = str3;
        this.zze = zzm;
    }

    public final void run() {
        synchronized (this.zza) {
            try {
                zzel zzd2 = this.zzf.zzb;
                if (zzd2 == null) {
                    this.zzf.zzr().zzf().zza("(legacy) Failed to get conditional properties; not connected to service", zzet.zza(this.zzb), this.zzc, this.zzd);
                    this.zza.set(Collections.emptyList());
                    this.zza.notify();
                    return;
                }
                if (TextUtils.isEmpty(this.zzb)) {
                    this.zza.set(zzd2.zza(this.zzc, this.zzd, this.zze));
                } else {
                    this.zza.set(zzd2.zza(this.zzb, this.zzc, this.zzd));
                }
                this.zzf.zzak();
                this.zza.notify();
            } catch (RemoteException e) {
                try {
                    this.zzf.zzr().zzf().zza("(legacy) Failed to get conditional properties; remote exception", zzet.zza(this.zzb), this.zzc, e);
                    this.zza.set(Collections.emptyList());
                    this.zza.notify();
                } catch (Throwable th) {
                    this.zza.notify();
                    throw th;
                }
            }
        }
    }
}
