package com.google.android.gms.internal.ads;

import java.util.concurrent.ExecutionException;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
final /* synthetic */ class zzcle implements zzdqj {
    static final zzdqj zzbly = new zzcle();

    private zzcle() {
    }

    public final zzdri zzf(Object obj) {
        return zzdqw.immediateFailedFuture(((ExecutionException) obj).getCause());
    }
}
