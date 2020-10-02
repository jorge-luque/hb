package com.tapjoy.internal;

import android.content.SharedPreferences;

/* renamed from: com.tapjoy.internal.i */
public final class C5184i extends C5263m {

    /* renamed from: c */
    private final double f14208c = 0.0d;

    public C5184i(SharedPreferences sharedPreferences, String str) {
        super(sharedPreferences, str);
    }

    /* renamed from: a */
    public final double mo31348a() {
        String string = this.f14455a.getString(this.f14456b, (String) null);
        if (string != null) {
            try {
                return Double.parseDouble(string);
            } catch (NumberFormatException unused) {
            }
        }
        return this.f14208c;
    }

    /* renamed from: a */
    public final SharedPreferences.Editor mo31349a(SharedPreferences.Editor editor) {
        return editor.remove(this.f14456b);
    }

    /* renamed from: a */
    public final SharedPreferences.Editor mo31350a(SharedPreferences.Editor editor, double d) {
        return editor.putString(this.f14456b, Double.toString(d));
    }
}
