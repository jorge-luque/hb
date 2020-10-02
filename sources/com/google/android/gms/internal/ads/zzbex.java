package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
final class zzbex implements Runnable {
    private final /* synthetic */ zzbev zzejh;

    zzbex(zzbev zzbev) {
        this.zzejh = zzbev;
    }

    public final void run() {
        this.zzejh.zzeje.destroy();
    }
}
