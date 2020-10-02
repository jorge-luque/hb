package com.tapjoy.internal;

import android.content.SharedPreferences;

/* renamed from: com.tapjoy.internal.h */
public final class C5142h extends C5263m {

    /* renamed from: c */
    private final boolean f14062c = false;

    public C5142h(SharedPreferences sharedPreferences, String str) {
        super(sharedPreferences, str);
    }

    /* renamed from: a */
    public final void mo31321a(boolean z) {
        this.f14455a.edit().putBoolean(this.f14456b, z).apply();
    }

    /* renamed from: a */
    public final Boolean mo31320a() {
        return Boolean.valueOf(this.f14455a.getBoolean(this.f14456b, this.f14062c));
    }
}
