package com.google.android.gms.internal.ads;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
final class zzbae implements ThreadFactory {
    private final /* synthetic */ String zzdzy;
    private final AtomicInteger zzyi = new AtomicInteger(1);

    zzbae(String str) {
        this.zzdzy = str;
    }

    public final Thread newThread(Runnable runnable) {
        String str = this.zzdzy;
        int andIncrement = this.zzyi.getAndIncrement();
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 23);
        sb.append("AdWorker(");
        sb.append(str);
        sb.append(") #");
        sb.append(andIncrement);
        return new Thread(runnable, sb.toString());
    }
}
