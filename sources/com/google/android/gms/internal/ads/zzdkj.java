package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
final /* synthetic */ class zzdkj implements Callable {
    private final zzdke zzgzg;

    zzdkj(zzdke zzdke) {
        this.zzgzg = zzdke;
    }

    public final Object call() {
        this.zzgzg.run();
        return null;
    }
}
