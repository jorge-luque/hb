package com.ogury.crashreport;

import java.lang.Thread;

/* compiled from: ExceptionHandler.kt */
public final class fcharset0 implements Thread.UncaughtExceptionHandler {

    /* renamed from: a */
    public static final rtf1 f12202a = new rtf1((byte) 0);

    /* renamed from: b */
    private final cocoartf1671 f12203b;

    /* renamed from: c */
    private final Thread.UncaughtExceptionHandler f12204c;

    /* compiled from: ExceptionHandler.kt */
    public static final class rtf1 {
        private rtf1() {
        }

        public /* synthetic */ rtf1(byte b) {
            this();
        }
    }

    public fcharset0(cocoartf1671 cocoartf1671, Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        tx7920.m15333b(cocoartf1671, "crashFileStore");
        this.f12203b = cocoartf1671;
        this.f12204c = uncaughtExceptionHandler;
    }

    public final void uncaughtException(Thread thread, Throwable th) {
        tx7920.m15333b(thread, "thread");
        tx7920.m15333b(th, "exception");
        try {
            this.f12203b.mo29591a(th);
            Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.f12204c;
            if (uncaughtExceptionHandler != null) {
                uncaughtExceptionHandler.uncaughtException(thread, th);
            }
        } catch (Exception e) {
            C4454f0 f0Var = C4454f0.f12201a;
            C4454f0.m15288a(e);
        }
    }
}
