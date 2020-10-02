package com.tapjoy.internal;

import android.os.Looper;

/* renamed from: com.tapjoy.internal.gw */
public final class C5139gw {

    /* renamed from: a */
    public static boolean f14055a;

    /* renamed from: a */
    public static void m17323a(String str) {
        if (f14055a) {
            C3175x.m10464a(4, "Tapjoy", str, (Throwable) null);
        }
    }

    /* renamed from: b */
    public static void m17328b(String str) {
        if (f14055a) {
            C3175x.m10464a(6, "Tapjoy", str, (Throwable) null);
        }
    }

    /* renamed from: c */
    public static boolean m17330c(String str) {
        boolean z = Looper.myLooper() == Looper.getMainLooper();
        return m17327a(z, str + ": Must be called on the main/ui thread");
    }

    /* renamed from: a */
    public static void m17325a(String str, Object... objArr) {
        if (f14055a) {
            C3175x.m10465a(4, "Tapjoy", str, objArr);
        }
    }

    /* renamed from: b */
    public static void m17329b(String str, Object... objArr) {
        if (f14055a) {
            C3175x.m10466a("Tapjoy", str, objArr);
        }
    }

    /* renamed from: a */
    public static void m17324a(String str, String str2, String str3) {
        if (f14055a) {
            C3175x.m10466a("Tapjoy", "{}: {} {}", str, str2, str3);
        }
    }

    /* renamed from: a */
    public static boolean m17326a(Object obj, String str) {
        if (obj != null) {
            return true;
        }
        if (!f14055a) {
            return false;
        }
        m17328b(str);
        return false;
    }

    /* renamed from: a */
    public static boolean m17327a(boolean z, String str) {
        if (!f14055a || z) {
            return z;
        }
        m17328b(str);
        throw new IllegalStateException(str);
    }
}
