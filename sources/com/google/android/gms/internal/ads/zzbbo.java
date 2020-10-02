package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
final class zzbbo implements Runnable {
    private final /* synthetic */ zzbbk zzeca;

    zzbbo(zzbbk zzbbk) {
        this.zzeca = zzbbk;
    }

    public final void run() {
        this.zzeca.zzd("surfaceDestroyed", new String[0]);
    }
}
