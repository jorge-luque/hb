package com.chartboost.sdk.Libraries;

import android.util.Log;

public final class CBLogging {

    /* renamed from: a */
    public static Level f6849a = Level.INTEGRATION;

    public enum Level {
        NONE,
        INTEGRATION,
        ALL
    }

    /* renamed from: a */
    public static void m8152a(String str, String str2) {
        Level level = f6849a;
        Level level2 = Level.ALL;
    }

    /* renamed from: b */
    public static void m8154b(String str, String str2) {
        if (f6849a == Level.ALL) {
            Log.e(str, str2);
        }
    }

    /* renamed from: c */
    public static void m8157c(String str, String str2, Throwable th) {
        if (f6849a == Level.ALL) {
            Log.w(str, str2, th);
        }
    }

    /* renamed from: d */
    public static void m8158d(String str, String str2) {
        Level level = f6849a;
        Level level2 = Level.ALL;
    }

    /* renamed from: e */
    public static void m8159e(String str, String str2) {
        if (f6849a == Level.ALL) {
            Log.w(str, str2);
        }
    }

    /* renamed from: a */
    public static void m8153a(String str, String str2, Throwable th) {
        if (f6849a == Level.ALL) {
            Log.e(str, str2, th);
        }
    }

    /* renamed from: b */
    public static void m8155b(String str, String str2, Throwable th) {
        Level level = f6849a;
        Level level2 = Level.ALL;
    }

    /* renamed from: c */
    public static void m8156c(String str, String str2) {
        Level level = f6849a;
        Level level2 = Level.ALL;
    }
}
