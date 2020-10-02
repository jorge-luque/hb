package com.google.android.exoplayer2.util;

import org.checkerframework.checker.nullness.qual.EnsuresNonNull;

/* renamed from: com.google.android.exoplayer2.util.a */
/* compiled from: Assertions */
public final class C3069a {
    /* renamed from: a */
    public static void m10121a(boolean z) {
        if (!z) {
            throw new IllegalArgumentException();
        }
    }

    @EnsuresNonNull({"#1"})
    /* renamed from: a */
    public static <T> T m10120a(T t) {
        if (t != null) {
            return t;
        }
        throw null;
    }
}
