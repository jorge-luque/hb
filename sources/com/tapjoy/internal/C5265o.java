package com.tapjoy.internal;

import android.content.SharedPreferences;

/* renamed from: com.tapjoy.internal.o */
public final class C5265o extends C5263m {

    /* renamed from: c */
    private final String f14457c = null;

    public C5265o(SharedPreferences sharedPreferences, String str) {
        super(sharedPreferences, str);
    }

    /* renamed from: a */
    public final String mo31485a() {
        return this.f14455a.getString(this.f14456b, this.f14457c);
    }

    /* renamed from: a */
    public final void mo31486a(String str) {
        this.f14455a.edit().putString(this.f14456b, str).apply();
    }

    /* renamed from: a */
    public final SharedPreferences.Editor mo31484a(SharedPreferences.Editor editor, String str) {
        return str != null ? editor.putString(this.f14456b, str) : editor.remove(this.f14456b);
    }
}
