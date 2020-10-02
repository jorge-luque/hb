package com.tapjoy.internal;

import javax.annotation.Nullable;

/* renamed from: com.tapjoy.internal.jr */
public final class C3167jr {
    /* renamed from: a */
    private static void m10438a(@Nullable Throwable th, Class cls) {
        if (th != null && cls.isInstance(th)) {
            throw ((Throwable) cls.cast(th));
        }
    }

    /* renamed from: a */
    public static RuntimeException m10437a(Throwable th) {
        Throwable th2 = (Throwable) C5241jp.m17607a(th);
        m10438a(th2, Error.class);
        m10438a(th2, RuntimeException.class);
        throw new RuntimeException(th);
    }
}
