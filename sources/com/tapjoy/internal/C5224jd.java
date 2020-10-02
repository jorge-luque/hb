package com.tapjoy.internal;

import java.io.InterruptedIOException;

/* renamed from: com.tapjoy.internal.jd */
public class C5224jd {

    /* renamed from: a */
    public static final C5224jd f14339a = new C5224jd() {
        /* renamed from: a */
        public final void mo31439a() {
        }
    };

    /* renamed from: b */
    private boolean f14340b;

    /* renamed from: c */
    private long f14341c;

    /* renamed from: a */
    public void mo31439a() {
        if (Thread.interrupted()) {
            throw new InterruptedIOException("thread interrupted");
        } else if (this.f14340b && this.f14341c - System.nanoTime() <= 0) {
            throw new InterruptedIOException("deadline reached");
        }
    }
}
