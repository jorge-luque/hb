package com.onesignal;

import android.os.Bundle;
import android.os.Parcelable;

/* renamed from: com.onesignal.k */
/* compiled from: BundleCompat */
class C4534k implements C4528j<Bundle> {

    /* renamed from: a */
    private Bundle f12391a;

    C4534k() {
        this.f12391a = new Bundle();
    }

    /* renamed from: b */
    public Integer mo29795b(String str) {
        return Integer.valueOf(this.f12391a.getInt(str));
    }

    /* renamed from: c */
    public boolean mo29796c(String str) {
        return this.f12391a.containsKey(str);
    }

    public boolean getBoolean(String str, boolean z) {
        return this.f12391a.getBoolean(str, z);
    }

    public String getString(String str) {
        return this.f12391a.getString(str);
    }

    /* renamed from: a */
    public void mo29794a(String str, String str2) {
        this.f12391a.putString(str, str2);
    }

    C4534k(Bundle bundle) {
        this.f12391a = bundle;
    }

    /* renamed from: a */
    public void mo29793a(String str, Long l) {
        this.f12391a.putLong(str, l.longValue());
    }

    /* renamed from: a */
    public Long mo29790a(String str) {
        return Long.valueOf(this.f12391a.getLong(str));
    }

    /* renamed from: a */
    public Bundle m15600a() {
        return this.f12391a;
    }

    /* renamed from: a */
    public void mo29792a(Parcelable parcelable) {
        this.f12391a = (Bundle) parcelable;
    }
}
