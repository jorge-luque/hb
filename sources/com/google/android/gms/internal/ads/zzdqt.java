package com.google.android.gms.internal.ads;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
final class zzdqt<V> extends zzdqr<V> {
    private final zzdri<V> zzhhw;

    zzdqt(zzdri<V> zzdri) {
        this.zzhhw = (zzdri) zzdoj.checkNotNull(zzdri);
    }

    public final void addListener(Runnable runnable, Executor executor) {
        this.zzhhw.addListener(runnable, executor);
    }

    public final boolean cancel(boolean z) {
        return this.zzhhw.cancel(z);
    }

    public final V get() throws InterruptedException, ExecutionException {
        return this.zzhhw.get();
    }

    public final boolean isCancelled() {
        return this.zzhhw.isCancelled();
    }

    public final boolean isDone() {
        return this.zzhhw.isDone();
    }

    public final String toString() {
        return this.zzhhw.toString();
    }

    public final V get(long j, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        return this.zzhhw.get(j, timeUnit);
    }
}
