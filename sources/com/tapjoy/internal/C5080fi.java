package com.tapjoy.internal;

import android.os.SystemClock;

/* renamed from: com.tapjoy.internal.fi */
public final class C5080fi {

    /* renamed from: a */
    public static final C5080fi f13914a = new C5080fi(-1);

    /* renamed from: b */
    public final long f13915b;

    /* renamed from: c */
    public long f13916c;

    public C5080fi(long j) {
        this.f13915b = j;
        this.f13916c = SystemClock.elapsedRealtime();
    }

    /* renamed from: a */
    public final boolean mo31235a() {
        try {
            return SystemClock.elapsedRealtime() - this.f13916c > this.f13915b;
        } catch (NullPointerException unused) {
            return true;
        }
    }

    /* renamed from: a */
    public final boolean mo31236a(long j) {
        try {
            return (SystemClock.elapsedRealtime() - this.f13916c) + j > this.f13915b;
        } catch (NullPointerException unused) {
            return true;
        }
    }

    public C5080fi() {
        this.f13915b = 3600000;
        try {
            this.f13916c = SystemClock.elapsedRealtime() - 3600000;
        } catch (NullPointerException unused) {
            this.f13916c = -1;
        }
    }
}
