package com.tapjoy.internal;

import android.os.SystemClock;

/* renamed from: com.tapjoy.internal.im */
public abstract class C5200im implements Runnable {

    /* renamed from: a */
    private final long f14272a = 300;

    /* renamed from: a */
    public abstract boolean mo31319a();

    public void run() {
        long elapsedRealtime = SystemClock.elapsedRealtime() + this.f14272a;
        while (!mo31319a() && elapsedRealtime - SystemClock.elapsedRealtime() > 0) {
            try {
                Thread.sleep(0);
            } catch (InterruptedException unused) {
                return;
            }
        }
    }
}
