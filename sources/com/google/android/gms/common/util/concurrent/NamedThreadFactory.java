package com.google.android.gms.common.util.concurrent;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

@KeepForSdk
/* compiled from: com.google.android.gms:play-services-basement@@17.2.0 */
public class NamedThreadFactory implements ThreadFactory {
    private final String name;
    private final int priority;
    private final ThreadFactory zzij;

    @KeepForSdk
    public NamedThreadFactory(String str) {
        this(str, 0);
    }

    public Thread newThread(Runnable runnable) {
        Thread newThread = this.zzij.newThread(new zza(runnable, 0));
        newThread.setName(this.name);
        return newThread;
    }

    private NamedThreadFactory(String str, int i) {
        this.zzij = Executors.defaultThreadFactory();
        this.name = (String) Preconditions.checkNotNull(str, "Name must not be null");
        this.priority = 0;
    }
}
