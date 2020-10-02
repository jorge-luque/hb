package p093e.p101c.p102a.p103a.p104i.p105t;

import android.util.Log;

/* renamed from: e.c.a.a.i.t.a */
/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
public final class C3416a {
    /* renamed from: a */
    private static String m11377a(String str) {
        return "TransportRuntime." + str;
    }

    /* renamed from: b */
    public static void m11382b(String str, String str2, Object obj) {
        Log.w(m11377a(str), String.format(str2, new Object[]{obj}));
    }

    /* renamed from: a */
    public static void m11379a(String str, String str2, Object obj) {
        m11377a(str);
        String.format(str2, new Object[]{obj});
    }

    /* renamed from: a */
    public static void m11381a(String str, String str2, Object... objArr) {
        m11377a(str);
        String.format(str2, objArr);
    }

    /* renamed from: a */
    public static void m11378a(String str, String str2) {
        m11377a(str);
    }

    /* renamed from: a */
    public static void m11380a(String str, String str2, Throwable th) {
        Log.e(m11377a(str), str2, th);
    }
}
