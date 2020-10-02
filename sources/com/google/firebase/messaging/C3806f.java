package com.google.firebase.messaging;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.PowerManager;
import android.util.Log;
import com.google.firebase.iid.C3731q;
import java.io.IOException;

/* renamed from: com.google.firebase.messaging.f */
/* compiled from: com.google.firebase:firebase-messaging@@20.1.7 */
final class C3806f implements Runnable {

    /* renamed from: f */
    private static final Object f10532f = new Object();

    /* renamed from: g */
    private static Boolean f10533g;

    /* renamed from: h */
    private static Boolean f10534h;

    /* renamed from: a */
    private final Context f10535a;

    /* renamed from: b */
    private final C3731q f10536b;

    /* renamed from: c */
    private final PowerManager.WakeLock f10537c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final C3804d f10538d;

    /* renamed from: e */
    private final long f10539e;

    C3806f(C3804d dVar, Context context, C3731q qVar, long j) {
        this.f10538d = dVar;
        this.f10535a = context;
        this.f10539e = j;
        this.f10536b = qVar;
        this.f10537c = ((PowerManager) context.getSystemService("power")).newWakeLock(1, "wake:com.google.firebase.messaging");
    }

    /* renamed from: a */
    private static boolean m12862a(Context context) {
        boolean z;
        boolean booleanValue;
        synchronized (f10532f) {
            if (f10533g == null) {
                z = m12863a(context, "android.permission.WAKE_LOCK", f10533g);
            } else {
                z = f10533g.booleanValue();
            }
            Boolean valueOf = Boolean.valueOf(z);
            f10533g = valueOf;
            booleanValue = valueOf.booleanValue();
        }
        return booleanValue;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public final synchronized boolean m12866b() {
        NetworkInfo activeNetworkInfo;
        ConnectivityManager connectivityManager = (ConnectivityManager) this.f10535a.getSystemService("connectivity");
        activeNetworkInfo = connectivityManager != null ? connectivityManager.getActiveNetworkInfo() : null;
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public static boolean m12868c() {
        if (!Log.isLoggable("FirebaseMessaging", 3)) {
            return Build.VERSION.SDK_INT == 23 && Log.isLoggable("FirebaseMessaging", 3);
        }
        return true;
    }

    @SuppressLint({"Wakelock"})
    public final void run() {
        if (m12862a(this.f10535a)) {
            this.f10537c.acquire(C3809i.f10544a);
        }
        try {
            this.f10538d.mo27497a(true);
            if (!this.f10536b.mo27361a()) {
                this.f10538d.mo27497a(false);
                if (m12862a(this.f10535a)) {
                    try {
                        this.f10537c.release();
                    } catch (RuntimeException unused) {
                    }
                }
            } else if (!m12867b(this.f10535a) || m12866b()) {
                if (this.f10538d.mo27498b()) {
                    this.f10538d.mo27497a(false);
                } else {
                    this.f10538d.mo27495a(this.f10539e);
                }
                if (m12862a(this.f10535a)) {
                    try {
                        this.f10537c.release();
                    } catch (RuntimeException unused2) {
                    }
                }
            } else {
                C3805e eVar = new C3805e(this, this);
                if (!Log.isLoggable("FirebaseMessaging", 3)) {
                    if (Build.VERSION.SDK_INT != 23 || !Log.isLoggable("FirebaseMessaging", 3)) {
                    }
                }
                eVar.f10531b.f10535a.registerReceiver(eVar, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
                if (m12862a(this.f10535a)) {
                    try {
                        this.f10537c.release();
                    } catch (RuntimeException unused3) {
                    }
                }
            }
        } catch (IOException e) {
            String valueOf = String.valueOf(e.getMessage());
            Log.e("FirebaseMessaging", valueOf.length() != 0 ? "Failed to sync topics. Won't retry sync. ".concat(valueOf) : new String("Failed to sync topics. Won't retry sync. "));
            this.f10538d.mo27497a(false);
            if (m12862a(this.f10535a)) {
                try {
                    this.f10537c.release();
                } catch (RuntimeException unused4) {
                }
            }
        } catch (Throwable th) {
            if (m12862a(this.f10535a)) {
                try {
                    this.f10537c.release();
                } catch (RuntimeException unused5) {
                }
            }
            throw th;
        }
    }

    /* renamed from: b */
    private static boolean m12867b(Context context) {
        boolean z;
        boolean booleanValue;
        synchronized (f10532f) {
            if (f10534h == null) {
                z = m12863a(context, "android.permission.ACCESS_NETWORK_STATE", f10534h);
            } else {
                z = f10534h.booleanValue();
            }
            Boolean valueOf = Boolean.valueOf(z);
            f10534h = valueOf;
            booleanValue = valueOf.booleanValue();
        }
        return booleanValue;
    }

    /* renamed from: a */
    private static boolean m12863a(Context context, String str, Boolean bool) {
        if (bool != null) {
            return bool.booleanValue();
        }
        boolean z = context.checkCallingOrSelfPermission(str) == 0;
        if (!z && Log.isLoggable("FirebaseMessaging", 3)) {
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 142);
            sb.append("Missing Permission: ");
            sb.append(str);
            sb.append(". This permission should normally be included by the manifest merger, but may needed to be manually added to your manifest");
            sb.toString();
        }
        return z;
    }
}
