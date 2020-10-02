package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
public interface zzdrh extends ExecutorService {
    <T> zzdri<T> zzd(Callable<T> callable);

    zzdri<?> zzf(Runnable runnable);
}
