package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
final /* synthetic */ class zzcnw implements Runnable {
    private final zzbek zzelg;

    private zzcnw(zzbek zzbek) {
        this.zzelg = zzbek;
    }

    static Runnable zzh(zzbek zzbek) {
        return new zzcnw(zzbek);
    }

    public final void run() {
        this.zzelg.zzabw();
    }
}
