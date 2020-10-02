package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
public final class zzdrb<V> {
    private final boolean zzhhf;
    private final zzdou<zzdri<? extends V>> zzhhz;

    private zzdrb(boolean z, zzdou<zzdri<? extends V>> zzdou) {
        this.zzhhf = z;
        this.zzhhz = zzdou;
    }

    public final <C> zzdri<C> zza(Callable<C> callable, Executor executor) {
        return new zzdqk(this.zzhhz, this.zzhhf, executor, callable);
    }

    /* synthetic */ zzdrb(boolean z, zzdou zzdou, zzdqz zzdqz) {
        this(z, zzdou);
    }
}
