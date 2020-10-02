package com.google.firebase.iid;

import admost.sdk.base.AdMost;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.util.Log;
import java.util.ArrayDeque;
import java.util.Queue;
import javax.annotation.concurrent.GuardedBy;

/* renamed from: com.google.firebase.iid.y */
/* compiled from: com.google.firebase:firebase-iid@@20.1.7 */
public final class C3747y {

    /* renamed from: e */
    private static C3747y f10391e;
    @GuardedBy("this")

    /* renamed from: a */
    private String f10392a = null;

    /* renamed from: b */
    private Boolean f10393b = null;

    /* renamed from: c */
    private Boolean f10394c = null;

    /* renamed from: d */
    private final Queue<Intent> f10395d = new ArrayDeque();

    private C3747y() {
    }

    /* renamed from: b */
    public static synchronized C3747y m12648b() {
        C3747y yVar;
        synchronized (C3747y.class) {
            if (f10391e == null) {
                f10391e = new C3747y();
            }
            yVar = f10391e;
        }
        return yVar;
    }

    /* renamed from: c */
    private final synchronized String m12649c(Context context, Intent intent) {
        if (this.f10392a != null) {
            return this.f10392a;
        }
        ResolveInfo resolveService = context.getPackageManager().resolveService(intent, 0);
        if (resolveService != null) {
            if (resolveService.serviceInfo != null) {
                ServiceInfo serviceInfo = resolveService.serviceInfo;
                if (context.getPackageName().equals(serviceInfo.packageName)) {
                    if (serviceInfo.name != null) {
                        if (serviceInfo.name.startsWith(".")) {
                            String valueOf = String.valueOf(context.getPackageName());
                            String valueOf2 = String.valueOf(serviceInfo.name);
                            this.f10392a = valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
                        } else {
                            this.f10392a = serviceInfo.name;
                        }
                        return this.f10392a;
                    }
                }
                String str = serviceInfo.packageName;
                String str2 = serviceInfo.name;
                StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 94 + String.valueOf(str2).length());
                sb.append("Error resolving target intent service, skipping classname enforcement. Resolved service was: ");
                sb.append(str);
                sb.append("/");
                sb.append(str2);
                Log.e("FirebaseInstanceId", sb.toString());
                return null;
            }
        }
        Log.e("FirebaseInstanceId", "Failed to resolve target intent service, skipping classname enforcement");
        return null;
    }

    /* renamed from: a */
    public final Intent mo27376a() {
        return this.f10395d.poll();
    }

    /* renamed from: a */
    public final int mo27375a(Context context, Intent intent) {
        boolean isLoggable = Log.isLoggable("FirebaseInstanceId", 3);
        this.f10395d.offer(intent);
        Intent intent2 = new Intent("com.google.firebase.MESSAGING_EVENT");
        intent2.setPackage(context.getPackageName());
        return m12647b(context, intent2);
    }

    /* renamed from: b */
    private final int m12647b(Context context, Intent intent) {
        ComponentName componentName;
        String c = m12649c(context, intent);
        if (c != null) {
            if (Log.isLoggable("FirebaseInstanceId", 3)) {
                String valueOf = String.valueOf(c);
                if (valueOf.length() != 0) {
                    "Restricting intent to a specific service: ".concat(valueOf);
                } else {
                    new String("Restricting intent to a specific service: ");
                }
            }
            intent.setClassName(context.getPackageName(), c);
        }
        try {
            if (mo27377a(context)) {
                componentName = C3708g0.m12605a(context, intent);
            } else {
                componentName = context.startService(intent);
            }
            if (componentName != null) {
                return -1;
            }
            Log.e("FirebaseInstanceId", "Error while delivering the message: ServiceIntent not found.");
            return 404;
        } catch (SecurityException e) {
            Log.e("FirebaseInstanceId", "Error while delivering the message to the serviceIntent", e);
            return AdMost.AD_ERROR_WATERFALL_EMPTY;
        } catch (IllegalStateException e2) {
            String valueOf2 = String.valueOf(e2);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf2).length() + 45);
            sb.append("Failed to start service while in background: ");
            sb.append(valueOf2);
            Log.e("FirebaseInstanceId", sb.toString());
            return AdMost.AD_ERROR_INCOMPATIBLE_APP_ZONE_ID;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final boolean mo27377a(Context context) {
        if (this.f10393b == null) {
            this.f10393b = Boolean.valueOf(context.checkCallingOrSelfPermission("android.permission.WAKE_LOCK") == 0);
        }
        if (!this.f10393b.booleanValue()) {
            boolean isLoggable = Log.isLoggable("FirebaseInstanceId", 3);
        }
        return this.f10393b.booleanValue();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final boolean mo27378b(Context context) {
        if (this.f10394c == null) {
            this.f10394c = Boolean.valueOf(context.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") == 0);
        }
        if (!this.f10393b.booleanValue()) {
            boolean isLoggable = Log.isLoggable("FirebaseInstanceId", 3);
        }
        return this.f10394c.booleanValue();
    }
}
