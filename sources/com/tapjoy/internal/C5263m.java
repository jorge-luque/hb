package com.tapjoy.internal;

import android.content.SharedPreferences;

/* renamed from: com.tapjoy.internal.m */
public abstract class C5263m {

    /* renamed from: a */
    protected SharedPreferences f14455a;

    /* renamed from: b */
    protected String f14456b;

    public C5263m(SharedPreferences sharedPreferences, String str) {
        this.f14455a = sharedPreferences;
        this.f14456b = str;
    }

    /* renamed from: c */
    public final void mo31483c() {
        this.f14455a.edit().remove(this.f14456b).apply();
    }
}
