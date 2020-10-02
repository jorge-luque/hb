package com.loopj.android.http;

/* renamed from: com.loopj.android.http.p */
/* compiled from: Utils */
class C4266p {
    /* renamed from: a */
    public static void m14398a(boolean z, String str) {
        if (!z) {
            throw new AssertionError(str);
        }
    }

    /* renamed from: a */
    public static <T> T m14397a(T t, String str) {
        if (t != null) {
            return t;
        }
        throw new IllegalArgumentException(str + " should not be null!");
    }
}
