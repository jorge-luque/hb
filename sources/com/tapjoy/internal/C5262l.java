package com.tapjoy.internal;

import android.content.SharedPreferences;

/* renamed from: com.tapjoy.internal.l */
public final class C5262l extends C5263m {

    /* renamed from: c */
    private final long f14454c = 0;

    public C5262l(SharedPreferences sharedPreferences, String str) {
        super(sharedPreferences, str);
    }

    /* renamed from: a */
    public final long mo31479a() {
        return this.f14455a.getLong(this.f14456b, this.f14454c);
    }

    /* renamed from: a */
    public final void mo31482a(long j) {
        this.f14455a.edit().putLong(this.f14456b, j).apply();
    }

    /* renamed from: a */
    public final SharedPreferences.Editor mo31480a(SharedPreferences.Editor editor) {
        return editor.remove(this.f14456b);
    }

    /* renamed from: a */
    public final SharedPreferences.Editor mo31481a(SharedPreferences.Editor editor, long j) {
        return editor.putLong(this.f14456b, j);
    }
}
