package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
final /* synthetic */ class zzbwv implements Runnable {
    private final zzbek zzelg;

    private zzbwv(zzbek zzbek) {
        this.zzelg = zzbek;
    }

    static Runnable zzh(zzbek zzbek) {
        return new zzbwv(zzbek);
    }

    public final void run() {
        this.zzelg.destroy();
    }
}
