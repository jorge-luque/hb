package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
final /* synthetic */ class zzcox implements Runnable {
    private final zzcfo zzgfr;

    private zzcox(zzcfo zzcfo) {
        this.zzgfr = zzcfo;
    }

    static Runnable zza(zzcfo zzcfo) {
        return new zzcox(zzcfo);
    }

    public final void run() {
        this.zzgfr.zzamy();
    }
}
