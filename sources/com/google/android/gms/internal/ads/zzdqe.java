package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
final class zzdqe implements Runnable {
    private final /* synthetic */ zzdqd zzhhd;
    private final /* synthetic */ zzdot zzhhk;

    zzdqe(zzdqd zzdqd, zzdot zzdot) {
        this.zzhhd = zzdqd;
        this.zzhhk = zzdot;
    }

    public final void run() {
        this.zzhhd.zza(this.zzhhk);
    }
}
