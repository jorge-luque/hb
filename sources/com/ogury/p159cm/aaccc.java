package com.ogury.p159cm;

import android.util.Log;

/* renamed from: com.ogury.cm.aaccc */
public final class aaccc {

    /* renamed from: a */
    public static final aaccc f12045a = new aaccc();

    private aaccc() {
    }

    /* renamed from: a */
    public static void m15047a(String str) {
        accbb.m15218b(str, "message");
        Log.e("consent_sdk", str);
    }

    /* renamed from: a */
    public static void m15048a(String str, Throwable th) {
        accbb.m15218b(str, "message");
        accbb.m15218b(th, "error");
        Log.e("consent_sdk", str, th);
    }

    /* renamed from: a */
    public static void m15049a(Throwable th) {
        accbb.m15218b(th, "error");
        Log.e("consent_sdk", "caught_error", th);
    }

    /* renamed from: b */
    public static void m15050b(String str) {
        accbb.m15218b(str, "message");
    }
}
