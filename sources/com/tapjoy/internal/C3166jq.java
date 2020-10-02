package com.tapjoy.internal;

import javax.annotation.Nullable;

/* renamed from: com.tapjoy.internal.jq */
public final class C3166jq {
    /* renamed from: a */
    public static String m10434a(@Nullable String str) {
        return str == null ? "" : str;
    }

    @Nullable
    /* renamed from: b */
    public static String m10435b(@Nullable String str) {
        if (m10436c(str)) {
            return null;
        }
        return str;
    }

    /* renamed from: c */
    public static boolean m10436c(@Nullable String str) {
        return str == null || str.length() == 0;
    }
}
