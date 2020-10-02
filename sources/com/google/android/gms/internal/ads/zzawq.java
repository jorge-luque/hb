package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
final class zzawq implements Runnable {
    private final /* synthetic */ zzawn zzdvg;

    zzawq(zzawn zzawn) {
        this.zzdvg = zzawn;
    }

    public final void run() {
        Thread unused = this.zzdvg.thread = Thread.currentThread();
        this.zzdvg.zzup();
    }
}
