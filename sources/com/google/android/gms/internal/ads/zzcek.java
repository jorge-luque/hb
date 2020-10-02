package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
final /* synthetic */ class zzcek implements Runnable {
    private final zzbek zzelg;

    private zzcek(zzbek zzbek) {
        this.zzelg = zzbek;
    }

    static Runnable zzh(zzbek zzbek) {
        return new zzcek(zzbek);
    }

    public final void run() {
        this.zzelg.destroy();
    }
}
