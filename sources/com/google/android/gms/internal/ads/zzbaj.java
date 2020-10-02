package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzq;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
public class zzbaj<T> implements zzdri<T> {
    private final zzdrp<T> zzeab = zzdrp.zzaws();

    private static boolean zzas(boolean z) {
        if (!z) {
            zzq.zzla().zzb(new IllegalStateException("Provided SettableFuture with multiple values."), "SettableFuture");
        }
        return z;
    }

    public void addListener(Runnable runnable, Executor executor) {
        this.zzeab.addListener(runnable, executor);
    }

    public boolean cancel(boolean z) {
        return this.zzeab.cancel(z);
    }

    public T get() throws ExecutionException, InterruptedException {
        return this.zzeab.get();
    }

    public boolean isCancelled() {
        return this.zzeab.isCancelled();
    }

    public boolean isDone() {
        return this.zzeab.isDone();
    }

    public final boolean set(T t) {
        return zzas(this.zzeab.set(t));
    }

    public final boolean setException(Throwable th) {
        return zzas(this.zzeab.setException(th));
    }

    public T get(long j, TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
        return this.zzeab.get(j, timeUnit);
    }
}
