package com.onesignal;

import android.os.Parcelable;
import android.os.PersistableBundle;

/* renamed from: com.onesignal.m */
/* compiled from: BundleCompat */
class C4547m implements C4528j<PersistableBundle> {

    /* renamed from: a */
    private PersistableBundle f12427a = new PersistableBundle();

    C4547m() {
    }

    /* renamed from: b */
    public Integer mo29795b(String str) {
        return Integer.valueOf(this.f12427a.getInt(str));
    }

    /* renamed from: c */
    public boolean mo29796c(String str) {
        return this.f12427a.containsKey(str);
    }

    public boolean getBoolean(String str, boolean z) {
        return this.f12427a.getBoolean(str, z);
    }

    public String getString(String str) {
        return this.f12427a.getString(str);
    }

    /* renamed from: a */
    public void mo29794a(String str, String str2) {
        this.f12427a.putString(str, str2);
    }

    /* renamed from: a */
    public void mo29793a(String str, Long l) {
        this.f12427a.putLong(str, l.longValue());
    }

    /* renamed from: a */
    public Long mo29790a(String str) {
        return Long.valueOf(this.f12427a.getLong(str));
    }

    /* renamed from: a */
    public PersistableBundle m15677a() {
        return this.f12427a;
    }

    /* renamed from: a */
    public void mo29792a(Parcelable parcelable) {
        this.f12427a = (PersistableBundle) parcelable;
    }
}
