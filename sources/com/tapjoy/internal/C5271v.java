package com.tapjoy.internal;

import android.os.SystemClock;

/* renamed from: com.tapjoy.internal.v */
public final class C5271v {

    /* renamed from: a */
    private static String f14463a = "pool.ntp.org";

    /* renamed from: b */
    private static long f14464b = 20000;

    /* renamed from: c */
    private static volatile boolean f14465c = false;

    /* renamed from: d */
    private static volatile String f14466d;

    /* renamed from: e */
    private static volatile long f14467e;

    /* renamed from: f */
    private static volatile long f14468f;

    /* renamed from: g */
    private static volatile long f14469g;

    /* renamed from: h */
    private static volatile long f14470h;

    /* renamed from: i */
    private static volatile long f14471i;

    static {
        m17674a(false, "System", System.currentTimeMillis(), SystemClock.elapsedRealtime(), Long.MAX_VALUE);
    }

    /* renamed from: a */
    private static synchronized void m17674a(boolean z, String str, long j, long j2, long j3) {
        synchronized (C5271v.class) {
            f14465c = z;
            f14466d = str;
            f14467e = j;
            f14468f = j2;
            f14469g = j3;
            f14470h = f14467e - f14468f;
            f14471i = (SystemClock.elapsedRealtime() + f14470h) - System.currentTimeMillis();
        }
    }

    /* renamed from: b */
    public static long m17676b() {
        return SystemClock.elapsedRealtime() + f14470h;
    }

    /* renamed from: c */
    public static boolean m17677c() {
        return f14465c;
    }

    /* renamed from: a */
    public static boolean m17675a() {
        String str = f14463a;
        long j = f14464b;
        C5123gk gkVar = new C5123gk();
        if (!gkVar.mo31304a(str, (int) j)) {
            return false;
        }
        m17674a(true, "SNTP", gkVar.f14028a, gkVar.f14029b, gkVar.f14030c / 2);
        return true;
    }

    /* renamed from: a */
    public static long m17673a(long j) {
        return j + f14470h;
    }
}
