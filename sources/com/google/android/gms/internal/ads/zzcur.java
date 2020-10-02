package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
final /* synthetic */ class zzcur implements Runnable {
    private final zzcuh zzgkn;
    private final zzcdt[] zzgkw;

    zzcur(zzcuh zzcuh, zzcdt[] zzcdtArr) {
        this.zzgkn = zzcuh;
        this.zzgkw = zzcdtArr;
    }

    public final void run() {
        this.zzgkn.zza(this.zzgkw);
    }
}
