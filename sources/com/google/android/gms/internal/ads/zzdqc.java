package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
final class zzdqc implements Runnable {
    private final /* synthetic */ zzdri zzhhb;
    private final /* synthetic */ int zzhhc;
    private final /* synthetic */ zzdqd zzhhd;

    zzdqc(zzdqd zzdqd, zzdri zzdri, int i) {
        this.zzhhd = zzdqd;
        this.zzhhb = zzdri;
        this.zzhhc = i;
    }

    public final void run() {
        try {
            if (this.zzhhb.isCancelled()) {
                zzdot unused = this.zzhhd.zzhhe = null;
                this.zzhhd.cancel(false);
            } else {
                this.zzhhd.zza(this.zzhhc, this.zzhhb);
            }
        } finally {
            this.zzhhd.zza((zzdot) null);
        }
    }
}
