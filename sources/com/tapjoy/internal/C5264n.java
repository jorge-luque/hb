package com.tapjoy.internal;

import android.content.SharedPreferences;

/* renamed from: com.tapjoy.internal.n */
public final class C5264n {
    /* renamed from: a */
    public static void m17649a(SharedPreferences sharedPreferences, String str, boolean z) {
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putBoolean(str, z);
        edit.apply();
    }

    /* renamed from: a */
    public static void m17647a(SharedPreferences sharedPreferences, String str, int i) {
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putInt(str, i);
        edit.apply();
    }

    /* renamed from: a */
    public static void m17648a(SharedPreferences sharedPreferences, String str, String str2) {
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putString(str, str2);
        edit.apply();
    }
}
