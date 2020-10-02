package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
public final class zzbvt<T> {
    public Executor executor;
    public T zzfom;

    public zzbvt(T t, Executor executor2) {
        this.zzfom = t;
        this.executor = executor2;
    }

    public static <T> zzbvt<T> zzb(T t, Executor executor2) {
        return new zzbvt<>(t, executor2);
    }
}
