package com.tapjoy.internal;

import android.content.SharedPreferences;

/* renamed from: com.tapjoy.internal.k */
public final class C5251k extends C5263m {

    /* renamed from: c */
    private final int f14430c;

    public C5251k(SharedPreferences sharedPreferences, String str, int i) {
        super(sharedPreferences, str);
        this.f14430c = i;
    }

    /* renamed from: a */
    public final Integer mo31463a() {
        return Integer.valueOf(mo31466b());
    }

    /* renamed from: b */
    public final int mo31466b() {
        return this.f14455a.getInt(this.f14456b, this.f14430c);
    }

    /* renamed from: a */
    public final void mo31465a(Integer num) {
        if (num != null) {
            mo31464a(num.intValue());
        } else {
            mo31483c();
        }
    }

    /* renamed from: a */
    public final void mo31464a(int i) {
        this.f14455a.edit().putInt(this.f14456b, i).apply();
    }

    /* renamed from: a */
    public final SharedPreferences.Editor mo31462a(SharedPreferences.Editor editor, int i) {
        return editor.putInt(this.f14456b, i);
    }
}
