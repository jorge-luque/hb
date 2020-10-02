package com.google.android.gms.internal.ads;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
public final class zzdkd<E, V> implements zzdri<V> {
    private final E zzgyz;
    private final String zzgza;
    private final zzdri<V> zzgzb;

    public zzdkd(E e, String str, zzdri<V> zzdri) {
        this.zzgyz = e;
        this.zzgza = str;
        this.zzgzb = zzdri;
    }

    public final void addListener(Runnable runnable, Executor executor) {
        this.zzgzb.addListener(runnable, executor);
    }

    public final boolean cancel(boolean z) {
        return this.zzgzb.cancel(z);
    }

    public final V get() throws InterruptedException, ExecutionException {
        return this.zzgzb.get();
    }

    public final boolean isCancelled() {
        return this.zzgzb.isCancelled();
    }

    public final boolean isDone() {
        return this.zzgzb.isDone();
    }

    public final String toString() {
        String str = this.zzgza;
        int identityHashCode = System.identityHashCode(this);
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 12);
        sb.append(str);
        sb.append("@");
        sb.append(identityHashCode);
        return sb.toString();
    }

    public final E zzaua() {
        return this.zzgyz;
    }

    public final String zzaub() {
        return this.zzgza;
    }

    public final V get(long j, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        return this.zzgzb.get(j, timeUnit);
    }
}
