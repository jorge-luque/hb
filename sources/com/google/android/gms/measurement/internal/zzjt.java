package com.google.android.gms.measurement.internal;

import com.vungle.warren.AdLoader;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
final class zzjt {
    final /* synthetic */ zzjs zza;
    private zzjw zzb;

    zzjt(zzjs zzjs) {
        this.zza = zzjs;
    }

    /* access modifiers changed from: package-private */
    public final void zza() {
        this.zza.zzd();
        if (this.zza.zzt().zza(zzas.zzbp) && this.zzb != null) {
            this.zza.zzc.removeCallbacks(this.zzb);
        }
        if (this.zza.zzt().zza(zzas.zzcd)) {
            this.zza.zzs().zzs.zza(false);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zza(long j) {
        if (this.zza.zzt().zza(zzas.zzbp)) {
            this.zzb = new zzjw(this, this.zza.zzm().currentTimeMillis(), j);
            this.zza.zzc.postDelayed(this.zzb, AdLoader.RETRY_DELAY);
        }
    }
}
