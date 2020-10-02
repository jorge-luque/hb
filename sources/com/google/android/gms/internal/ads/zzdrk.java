package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
public final class zzdrk {
    public static zzdrh zza(ExecutorService executorService) {
        if (executorService instanceof zzdrh) {
            return (zzdrh) executorService;
        }
        if (executorService instanceof ScheduledExecutorService) {
            return new zzdro((ScheduledExecutorService) executorService);
        }
        return new zzdrl(executorService);
    }

    public static Executor zzawr() {
        return zzdqp.INSTANCE;
    }

    static Executor zza(Executor executor, zzdpw<?> zzdpw) {
        zzdoj.checkNotNull(executor);
        zzdoj.checkNotNull(zzdpw);
        if (executor == zzdqp.INSTANCE) {
            return executor;
        }
        return new zzdrj(executor, zzdpw);
    }
}
