package com.google.firebase.iid;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.PowerManager;
import android.util.Log;
import com.google.android.gms.common.util.VisibleForTesting;
import java.io.IOException;

/* renamed from: com.google.firebase.iid.e0 */
/* compiled from: com.google.firebase:firebase-iid@@20.1.7 */
final class C3702e0 implements Runnable {

    /* renamed from: a */
    private final long f10316a;

    /* renamed from: b */
    private final PowerManager.WakeLock f10317b;

    /* renamed from: c */
    private final FirebaseInstanceId f10318c;

    @VisibleForTesting
    C3702e0(FirebaseInstanceId firebaseInstanceId, long j) {
        this.f10318c = firebaseInstanceId;
        this.f10316a = j;
        PowerManager.WakeLock newWakeLock = ((PowerManager) mo27324a().getSystemService("power")).newWakeLock(1, "fiid-sync");
        this.f10317b = newWakeLock;
        newWakeLock.setReferenceCounted(false);
    }

    @VisibleForTesting
    /* renamed from: c */
    private final boolean m12594c() throws IOException {
        C3691a0 d = this.f10318c.mo27299d();
        boolean z = true;
        if (!this.f10318c.mo27296a(d)) {
            return true;
        }
        try {
            String e = this.f10318c.mo27300e();
            if (e == null) {
                Log.e("FirebaseInstanceId", "Token retrieval failed: null");
                return false;
            }
            boolean isLoggable = Log.isLoggable("FirebaseInstanceId", 3);
            if ((d == null || (d != null && !e.equals(d.f10283a))) && "[DEFAULT]".equals(this.f10318c.mo27298c().mo27172b())) {
                if (Log.isLoggable("FirebaseInstanceId", 3)) {
                    String valueOf = String.valueOf(this.f10318c.mo27298c().mo27172b());
                    if (valueOf.length() != 0) {
                        "Invoking onNewToken for app: ".concat(valueOf);
                    } else {
                        new String("Invoking onNewToken for app: ");
                    }
                }
                Intent intent = new Intent("com.google.firebase.messaging.NEW_TOKEN");
                intent.putExtra("token", e);
                Context a = mo27324a();
                Intent intent2 = new Intent(a, FirebaseInstanceIdReceiver.class);
                intent2.setAction("com.google.firebase.MESSAGING_EVENT");
                intent2.putExtra("wrapped_intent", intent);
                a.sendBroadcast(intent2);
            }
            return true;
        } catch (IOException e2) {
            String message = e2.getMessage();
            if (!"SERVICE_NOT_AVAILABLE".equals(message) && !"INTERNAL_SERVER_ERROR".equals(message) && !"InternalServerError".equals(message)) {
                z = false;
            }
            if (z) {
                String message2 = e2.getMessage();
                StringBuilder sb = new StringBuilder(String.valueOf(message2).length() + 52);
                sb.append("Token retrieval failed: ");
                sb.append(message2);
                sb.append(". Will retry token retrieval");
                Log.w("FirebaseInstanceId", sb.toString());
                return false;
            } else if (e2.getMessage() == null) {
                Log.w("FirebaseInstanceId", "Token retrieval failed without exception message. Will retry token retrieval");
                return false;
            } else {
                throw e2;
            }
        } catch (SecurityException unused) {
            Log.w("FirebaseInstanceId", "Token retrieval failed with SecurityException. Will retry token retrieval");
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final Context mo27324a() {
        return this.f10318c.mo27298c().mo27170a();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final boolean mo27325b() {
        ConnectivityManager connectivityManager = (ConnectivityManager) mo27324a().getSystemService("connectivity");
        NetworkInfo activeNetworkInfo = connectivityManager != null ? connectivityManager.getActiveNetworkInfo() : null;
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    @SuppressLint({"Wakelock"})
    public final void run() {
        if (C3747y.m12648b().mo27377a(mo27324a())) {
            this.f10317b.acquire();
        }
        try {
            this.f10318c.mo27295a(true);
            if (!this.f10318c.mo27302g()) {
                this.f10318c.mo27295a(false);
                if (C3747y.m12648b().mo27377a(mo27324a())) {
                    this.f10317b.release();
                }
            } else if (!C3747y.m12648b().mo27378b(mo27324a()) || mo27325b()) {
                if (m12594c()) {
                    this.f10318c.mo27295a(false);
                } else {
                    this.f10318c.mo27294a(this.f10316a);
                }
                if (C3747y.m12648b().mo27377a(mo27324a())) {
                    this.f10317b.release();
                }
            } else {
                new C3100d0(this).mo18333a();
                if (C3747y.m12648b().mo27377a(mo27324a())) {
                    this.f10317b.release();
                }
            }
        } catch (IOException e) {
            String message = e.getMessage();
            StringBuilder sb = new StringBuilder(String.valueOf(message).length() + 93);
            sb.append("Topic sync or token retrieval failed on hard failure exceptions: ");
            sb.append(message);
            sb.append(". Won't retry the operation.");
            Log.e("FirebaseInstanceId", sb.toString());
            this.f10318c.mo27295a(false);
            if (C3747y.m12648b().mo27377a(mo27324a())) {
                this.f10317b.release();
            }
        } catch (Throwable th) {
            if (C3747y.m12648b().mo27377a(mo27324a())) {
                this.f10317b.release();
            }
            throw th;
        }
    }
}
