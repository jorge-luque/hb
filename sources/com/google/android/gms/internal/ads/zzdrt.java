package com.google.android.gms.internal.ads;

import java.util.concurrent.TimeoutException;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
final class zzdrt extends TimeoutException {
    private zzdrt(String str) {
        super(str);
    }

    public final synchronized Throwable fillInStackTrace() {
        setStackTrace(new StackTraceElement[0]);
        return this;
    }
}
