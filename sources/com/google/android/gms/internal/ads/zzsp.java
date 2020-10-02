package com.google.android.gms.internal.ads;

import java.util.concurrent.Future;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
final /* synthetic */ class zzsp implements Runnable {
    private final zzbaj zzbsx;
    private final Future zzbsy;

    zzsp(zzbaj zzbaj, Future future) {
        this.zzbsx = zzbaj;
        this.zzbsy = future;
    }

    public final void run() {
        zzbaj zzbaj = this.zzbsx;
        Future future = this.zzbsy;
        if (zzbaj.isCancelled()) {
            future.cancel(true);
        }
    }
}
