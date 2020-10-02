package com.google.firebase.components;

/* renamed from: com.google.firebase.components.r */
/* compiled from: com.google.firebase:firebase-components@@16.0.0 */
public final class C3656r {
    /* renamed from: a */
    public static void m12445a(boolean z, String str) {
        if (!z) {
            throw new IllegalArgumentException(str);
        }
    }

    /* renamed from: b */
    public static void m12446b(boolean z, String str) {
        if (!z) {
            throw new IllegalStateException(str);
        }
    }

    /* renamed from: a */
    public static <T> T m12443a(T t) {
        if (t != null) {
            return t;
        }
        throw null;
    }

    /* renamed from: a */
    public static <T> T m12444a(T t, String str) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(str);
    }
}
