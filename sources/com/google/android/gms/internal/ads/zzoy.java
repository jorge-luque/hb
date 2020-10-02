package com.google.android.gms.internal.ads;

import java.util.concurrent.ThreadFactory;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
final class zzoy implements ThreadFactory {
    private final /* synthetic */ String zzbia;

    zzoy(String str) {
        this.zzbia = str;
    }

    public final Thread newThread(Runnable runnable) {
        return new Thread(runnable, this.zzbia);
    }
}
