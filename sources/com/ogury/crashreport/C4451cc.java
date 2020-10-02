package com.ogury.crashreport;

/* renamed from: com.ogury.crashreport.cc */
/* compiled from: CharJVM.kt */
class C4451cc {
    /* renamed from: a */
    public static boolean m15281a(char c, char c2, boolean z) {
        if (c == c2) {
            return true;
        }
        if (!z) {
            return false;
        }
        return Character.toUpperCase(c) == Character.toUpperCase(c2) || Character.toLowerCase(c) == Character.toLowerCase(c2);
    }
}
