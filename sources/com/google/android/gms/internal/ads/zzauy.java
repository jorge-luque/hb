package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
final /* synthetic */ class zzauy implements Runnable {
    private final String zzdep;
    private final zzauu zzdtd;
    private final zzavk zzdte;

    zzauy(zzauu zzauu, zzavk zzavk, String str) {
        this.zzdtd = zzauu;
        this.zzdte = zzavk;
        this.zzdep = str;
    }

    public final void run() {
        this.zzdtd.zza(this.zzdte, this.zzdep);
    }
}
