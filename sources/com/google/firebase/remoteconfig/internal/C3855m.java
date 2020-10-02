package com.google.firebase.remoteconfig.internal;

import android.content.SharedPreferences;
import com.google.firebase.remoteconfig.C3834h;
import java.util.Date;

/* renamed from: com.google.firebase.remoteconfig.internal.m */
/* compiled from: com.google.firebase:firebase-config@@19.1.4 */
public class C3855m {

    /* renamed from: d */
    static final Date f10650d = new Date(-1);

    /* renamed from: e */
    static final Date f10651e = new Date(-1);

    /* renamed from: a */
    private final SharedPreferences f10652a;

    /* renamed from: b */
    private final Object f10653b = new Object();

    /* renamed from: c */
    private final Object f10654c = new Object();

    /* renamed from: com.google.firebase.remoteconfig.internal.m$a */
    /* compiled from: com.google.firebase:firebase-config@@19.1.4 */
    static class C3856a {

        /* renamed from: a */
        private int f10655a;

        /* renamed from: b */
        private Date f10656b;

        C3856a(int i, Date date) {
            this.f10655a = i;
            this.f10656b = date;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public Date mo27598a() {
            return this.f10656b;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public int mo27599b() {
            return this.f10655a;
        }
    }

    public C3855m(SharedPreferences sharedPreferences) {
        this.f10652a = sharedPreferences;
    }

    /* renamed from: a */
    public void mo27587a(C3834h hVar) {
        synchronized (this.f10653b) {
            this.f10652a.edit().putBoolean("is_developer_mode_enabled", hVar.mo27552c()).putLong("fetch_timeout_in_seconds", hVar.mo27550a()).putLong("minimum_fetch_interval_in_seconds", hVar.mo27551b()).commit();
        }
    }

    /* renamed from: b */
    public long mo27590b() {
        return this.f10652a.getLong("fetch_timeout_in_seconds", 60);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public String mo27591c() {
        return this.f10652a.getString("last_fetch_etag", (String) null);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public Date mo27592d() {
        return new Date(this.f10652a.getLong("last_fetch_time_in_millis", -1));
    }

    /* renamed from: e */
    public long mo27593e() {
        return this.f10652a.getLong("minimum_fetch_interval_in_seconds", C3852k.f10634j);
    }

    /* renamed from: f */
    public boolean mo27594f() {
        return this.f10652a.getBoolean("is_developer_mode_enabled", false);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: g */
    public void mo27595g() {
        mo27586a(0, f10651e);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: h */
    public void mo27596h() {
        synchronized (this.f10653b) {
            this.f10652a.edit().putInt("last_fetch_status", 1).apply();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: i */
    public void mo27597i() {
        synchronized (this.f10653b) {
            this.f10652a.edit().putInt("last_fetch_status", 2).apply();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo27589a(Date date) {
        synchronized (this.f10653b) {
            this.f10652a.edit().putInt("last_fetch_status", -1).putLong("last_fetch_time_in_millis", date.getTime()).apply();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo27588a(String str) {
        synchronized (this.f10653b) {
            this.f10652a.edit().putString("last_fetch_etag", str).apply();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public C3856a mo27585a() {
        C3856a aVar;
        synchronized (this.f10654c) {
            aVar = new C3856a(this.f10652a.getInt("num_failed_fetches", 0), new Date(this.f10652a.getLong("backoff_end_time_in_millis", -1)));
        }
        return aVar;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo27586a(int i, Date date) {
        synchronized (this.f10654c) {
            this.f10652a.edit().putInt("num_failed_fetches", i).putLong("backoff_end_time_in_millis", date.getTime()).apply();
        }
    }
}
