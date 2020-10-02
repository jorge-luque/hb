package com.google.firebase.p124e;

import android.content.Context;
import android.content.SharedPreferences;

/* renamed from: com.google.firebase.e.d */
/* compiled from: com.google.firebase:firebase-common@@19.3.0 */
class C3668d {

    /* renamed from: b */
    private static C3668d f10239b;

    /* renamed from: a */
    private final SharedPreferences f10240a;

    private C3668d(Context context) {
        this.f10240a = context.getSharedPreferences("FirebaseAppHeartBeat", 0);
    }

    /* renamed from: a */
    static synchronized C3668d m12465a(Context context) {
        C3668d dVar;
        synchronized (C3668d.class) {
            if (f10239b == null) {
                f10239b = new C3668d(context);
            }
            dVar = f10239b;
        }
        return dVar;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public synchronized boolean mo27268a(String str, long j) {
        if (!this.f10240a.contains(str)) {
            this.f10240a.edit().putLong(str, j).apply();
            return true;
        } else if (j - this.f10240a.getLong(str, -1) < 86400000) {
            return false;
        } else {
            this.f10240a.edit().putLong(str, j).apply();
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public synchronized boolean mo27267a(long j) {
        return mo27268a("fire-global", j);
    }
}
