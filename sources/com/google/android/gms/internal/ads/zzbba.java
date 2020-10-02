package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
final class zzbba implements Runnable {
    private final /* synthetic */ zzbav zzeba;

    zzbba(zzbav zzbav) {
        this.zzeba = zzbav;
    }

    public final void run() {
        if (this.zzeba.zzeay != null) {
            this.zzeba.zzeay.zzyr();
        }
    }
}
