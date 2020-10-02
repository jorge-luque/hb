package com.tapjoy.internal;

import android.os.Handler;
import android.os.Looper;

/* renamed from: com.tapjoy.internal.u */
public final class C5269u {

    /* renamed from: a */
    private static Handler f14461a;

    /* renamed from: a */
    public static synchronized Handler m17670a() {
        Handler handler;
        synchronized (C5269u.class) {
            if (f14461a == null) {
                f14461a = new Handler(Looper.getMainLooper());
            }
            handler = f14461a;
        }
        return handler;
    }

    /* renamed from: a */
    public static C4904ba m17671a(final Handler handler) {
        return new C4904ba() {
            /* renamed from: a */
            public final boolean mo30981a(Runnable runnable) {
                return handler.post(runnable);
            }
        };
    }
}
