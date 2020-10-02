package com.tapjoy.internal;

import android.support.p004v4.media.session.PlaybackStateCompat;

/* renamed from: com.tapjoy.internal.iz */
final class C5219iz {

    /* renamed from: a */
    static C5218iy f14335a;

    /* renamed from: b */
    static long f14336b;

    private C5219iz() {
    }

    /* renamed from: a */
    static C5218iy m17548a() {
        synchronized (C5219iz.class) {
            if (f14335a == null) {
                return new C5218iy();
            }
            C5218iy iyVar = f14335a;
            f14335a = iyVar.f14333f;
            iyVar.f14333f = null;
            f14336b -= PlaybackStateCompat.ACTION_PLAY_FROM_URI;
            return iyVar;
        }
    }

    /* renamed from: a */
    static void m17549a(C5218iy iyVar) {
        if (iyVar.f14333f != null || iyVar.f14334g != null) {
            throw new IllegalArgumentException();
        } else if (!iyVar.f14331d) {
            synchronized (C5219iz.class) {
                if (f14336b + PlaybackStateCompat.ACTION_PLAY_FROM_URI <= PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH) {
                    f14336b += PlaybackStateCompat.ACTION_PLAY_FROM_URI;
                    iyVar.f14333f = f14335a;
                    iyVar.f14330c = 0;
                    iyVar.f14329b = 0;
                    f14335a = iyVar;
                }
            }
        }
    }
}
