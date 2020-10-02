package com.ogury.crashreport;

/* compiled from: Thread.kt */
public final class tx1440 {

    /* compiled from: Thread.kt */
    public static final class rtf1 extends Thread {

        /* renamed from: a */
        private /* synthetic */ tx6480 f12230a;

        rtf1(tx6480 tx6480) {
            this.f12230a = tx6480;
        }

        public final void run() {
            this.f12230a.mo29600a();
        }
    }

    /* renamed from: a */
    public static final Thread m15318a(boolean z, boolean z2, ClassLoader classLoader, String str, int i, tx6480<vieww10800> tx6480) {
        tx7920.m15333b(tx6480, "block");
        rtf1 rtf12 = new rtf1(tx6480);
        if (z2) {
            rtf12.setDaemon(true);
        }
        if (i > 0) {
            rtf12.setPriority(i);
        }
        if (str != null) {
            rtf12.setName(str);
        }
        if (classLoader != null) {
            rtf12.setContextClassLoader(classLoader);
        }
        if (z) {
            rtf12.start();
        }
        return rtf12;
    }
}
