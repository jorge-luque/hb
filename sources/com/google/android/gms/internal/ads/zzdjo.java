package com.google.android.gms.internal.ads;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
final class zzdjo implements ThreadFactory {
    private final AtomicInteger zzyi = new AtomicInteger(1);

    zzdjo() {
    }

    public final Thread newThread(Runnable runnable) {
        int andIncrement = this.zzyi.getAndIncrement();
        StringBuilder sb = new StringBuilder(25);
        sb.append("AdWorker(NG) #");
        sb.append(andIncrement);
        return new Thread(runnable, sb.toString());
    }
}
