package com.google.android.gms.measurement.internal;

import android.os.Handler;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzm;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
abstract class zzai {
    private static volatile Handler zzb;
    private final zzgu zza;
    private final Runnable zzc;
    /* access modifiers changed from: private */
    public volatile long zzd;

    zzai(zzgu zzgu) {
        Preconditions.checkNotNull(zzgu);
        this.zza = zzgu;
        this.zzc = new zzah(this, zzgu);
    }

    private final Handler zzd() {
        Handler handler;
        if (zzb != null) {
            return zzb;
        }
        synchronized (zzai.class) {
            if (zzb == null) {
                zzb = new zzm(this.zza.zzn().getMainLooper());
            }
            handler = zzb;
        }
        return handler;
    }

    public abstract void zza();

    public final void zza(long j) {
        zzc();
        if (j >= 0) {
            this.zzd = this.zza.zzm().currentTimeMillis();
            if (!zzd().postDelayed(this.zzc, j)) {
                this.zza.zzr().zzf().zza("Failed to schedule delayed post. time", Long.valueOf(j));
            }
        }
    }

    public final boolean zzb() {
        return this.zzd != 0;
    }

    /* access modifiers changed from: package-private */
    public final void zzc() {
        this.zzd = 0;
        zzd().removeCallbacks(this.zzc);
    }
}
