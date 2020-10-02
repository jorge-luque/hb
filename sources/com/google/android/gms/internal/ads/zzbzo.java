package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
final /* synthetic */ class zzbzo implements Runnable {
    private final zzcaf zzfrm;

    private zzbzo(zzcaf zzcaf) {
        this.zzfrm = zzcaf;
    }

    static Runnable zza(zzcaf zzcaf) {
        return new zzbzo(zzcaf);
    }

    public final void run() {
        this.zzfrm.zzakn();
    }
}
