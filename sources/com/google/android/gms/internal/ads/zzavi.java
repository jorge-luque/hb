package com.google.android.gms.internal.ads;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
final class zzavi implements ThreadFactory {
    private final AtomicInteger zzyi = new AtomicInteger(1);

    zzavi(zzauu zzauu) {
    }

    public final Thread newThread(Runnable runnable) {
        int andIncrement = this.zzyi.getAndIncrement();
        StringBuilder sb = new StringBuilder(42);
        sb.append("AdWorker(SCION_TASK_EXECUTOR) #");
        sb.append(andIncrement);
        return new Thread(runnable, sb.toString());
    }
}
