package com.google.android.gms.common.util;

import android.os.SystemClock;
import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
/* compiled from: com.google.android.gms:play-services-basement@@17.2.0 */
public class DefaultClock implements Clock {
    private static final DefaultClock zzhb = new DefaultClock();

    private DefaultClock() {
    }

    @KeepForSdk
    public static Clock getInstance() {
        return zzhb;
    }

    public long currentThreadTimeMillis() {
        return SystemClock.currentThreadTimeMillis();
    }

    public long currentTimeMillis() {
        return System.currentTimeMillis();
    }

    public long elapsedRealtime() {
        return SystemClock.elapsedRealtime();
    }

    public long nanoTime() {
        return System.nanoTime();
    }
}
