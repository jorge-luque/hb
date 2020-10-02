package com.google.android.exoplayer2;

import java.util.HashSet;

/* renamed from: com.google.android.exoplayer2.e */
/* compiled from: ExoPlayerLibraryInfo */
public final class C3037e {

    /* renamed from: a */
    private static final HashSet<String> f8431a = new HashSet<>();

    /* renamed from: b */
    private static String f8432b = "goog.exo.core";

    /* renamed from: a */
    public static synchronized void m9965a(String str) {
        synchronized (C3037e.class) {
            if (f8431a.add(str)) {
                f8432b += ", " + str;
            }
        }
    }
}
