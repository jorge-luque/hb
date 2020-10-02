package com.google.firebase.iid;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.util.Log;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.firebase.FirebaseApp;
import java.util.List;
import javax.annotation.concurrent.GuardedBy;

/* renamed from: com.google.firebase.iid.q */
/* compiled from: com.google.firebase:firebase-iid@@20.1.7 */
public final class C3731q {

    /* renamed from: a */
    private final Context f10363a;
    @GuardedBy("this")

    /* renamed from: b */
    private String f10364b;
    @GuardedBy("this")

    /* renamed from: c */
    private String f10365c;
    @GuardedBy("this")

    /* renamed from: d */
    private int f10366d;
    @GuardedBy("this")

    /* renamed from: e */
    private int f10367e = 0;

    public C3731q(Context context) {
        this.f10363a = context;
    }

    /* renamed from: f */
    private final synchronized void m12625f() {
        PackageInfo a = m12623a(this.f10363a.getPackageName());
        if (a != null) {
            this.f10364b = Integer.toString(a.versionCode);
            this.f10365c = a.versionName;
        }
    }

    /* renamed from: a */
    public final boolean mo27361a() {
        return mo27362b() != 0;
    }

    /* renamed from: b */
    public final synchronized int mo27362b() {
        if (this.f10367e != 0) {
            return this.f10367e;
        }
        PackageManager packageManager = this.f10363a.getPackageManager();
        if (packageManager.checkPermission("com.google.android.c2dm.permission.SEND", "com.google.android.gms") == -1) {
            Log.e("FirebaseInstanceId", "Google Play services missing or without correct permission.");
            return 0;
        }
        if (!PlatformVersion.isAtLeastO()) {
            Intent intent = new Intent("com.google.android.c2dm.intent.REGISTER");
            intent.setPackage("com.google.android.gms");
            List<ResolveInfo> queryIntentServices = packageManager.queryIntentServices(intent, 0);
            if (queryIntentServices != null && queryIntentServices.size() > 0) {
                this.f10367e = 1;
                return 1;
            }
        }
        Intent intent2 = new Intent("com.google.iid.TOKEN_REQUEST");
        intent2.setPackage("com.google.android.gms");
        List<ResolveInfo> queryBroadcastReceivers = packageManager.queryBroadcastReceivers(intent2, 0);
        if (queryBroadcastReceivers == null || queryBroadcastReceivers.size() <= 0) {
            Log.w("FirebaseInstanceId", "Failed to resolve IID implementation package, falling back");
            if (PlatformVersion.isAtLeastO()) {
                this.f10367e = 2;
            } else {
                this.f10367e = 1;
            }
            return this.f10367e;
        }
        this.f10367e = 2;
        return 2;
    }

    /* renamed from: c */
    public final synchronized String mo27363c() {
        if (this.f10364b == null) {
            m12625f();
        }
        return this.f10364b;
    }

    /* renamed from: d */
    public final synchronized String mo27364d() {
        if (this.f10365c == null) {
            m12625f();
        }
        return this.f10365c;
    }

    /* renamed from: e */
    public final synchronized int mo27365e() {
        PackageInfo a;
        if (this.f10366d == 0 && (a = m12623a("com.google.android.gms")) != null) {
            this.f10366d = a.versionCode;
        }
        return this.f10366d;
    }

    /* renamed from: a */
    public static String m12624a(FirebaseApp firebaseApp) {
        String c = firebaseApp.mo27173c().mo27209c();
        if (c != null) {
            return c;
        }
        String b = firebaseApp.mo27173c().mo27208b();
        if (!b.startsWith("1:")) {
            return b;
        }
        String[] split = b.split(":");
        if (split.length < 2) {
            return null;
        }
        String str = split[1];
        if (str.isEmpty()) {
            return null;
        }
        return str;
    }

    /* renamed from: a */
    private final PackageInfo m12623a(String str) {
        try {
            return this.f10363a.getPackageManager().getPackageInfo(str, 0);
        } catch (PackageManager.NameNotFoundException e) {
            String valueOf = String.valueOf(e);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 23);
            sb.append("Failed to find package ");
            sb.append(valueOf);
            Log.w("FirebaseInstanceId", sb.toString());
            return null;
        }
    }
}
