package com.google.firebase.iid;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.util.Log;
import com.google.android.gms.common.util.concurrent.NamedThreadFactory;
import com.google.android.gms.tasks.Task;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* renamed from: com.google.firebase.iid.k0 */
/* compiled from: com.google.firebase:firebase-iid@@20.1.7 */
public final class C3720k0 implements ServiceConnection {

    /* renamed from: a */
    private final Context f10341a;

    /* renamed from: b */
    private final Intent f10342b;

    /* renamed from: c */
    private final ScheduledExecutorService f10343c;

    /* renamed from: d */
    private final Queue<C3717j0> f10344d;

    /* renamed from: e */
    private C3705f0 f10345e;

    /* renamed from: f */
    private boolean f10346f;

    public C3720k0(Context context, String str) {
        this(context, str, new ScheduledThreadPoolExecutor(0, new NamedThreadFactory("Firebase-FirebaseInstanceIdServiceConnection")));
    }

    /* renamed from: b */
    private final void m12614b() {
        while (!this.f10344d.isEmpty()) {
            this.f10344d.poll().mo27345b();
        }
    }

    /* renamed from: a */
    public final synchronized Task<Void> mo27348a(Intent intent) {
        C3717j0 j0Var;
        boolean isLoggable = Log.isLoggable("FirebaseInstanceId", 3);
        j0Var = new C3717j0(intent);
        ScheduledExecutorService scheduledExecutorService = this.f10343c;
        j0Var.mo27344a().addOnCompleteListener((Executor) scheduledExecutorService, new C3722l0(scheduledExecutorService.schedule(new C3724m0(j0Var), 9000, TimeUnit.MILLISECONDS)));
        this.f10344d.add(j0Var);
        m12613a();
        return j0Var.mo27344a();
    }

    public final synchronized void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        if (Log.isLoggable("FirebaseInstanceId", 3)) {
            String valueOf = String.valueOf(componentName);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 20);
            sb.append("onServiceConnected: ");
            sb.append(valueOf);
            sb.toString();
        }
        this.f10346f = false;
        if (!(iBinder instanceof C3705f0)) {
            String valueOf2 = String.valueOf(iBinder);
            StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf2).length() + 28);
            sb2.append("Invalid service connection: ");
            sb2.append(valueOf2);
            Log.e("FirebaseInstanceId", sb2.toString());
            m12614b();
            return;
        }
        this.f10345e = (C3705f0) iBinder;
        m12613a();
    }

    public final void onServiceDisconnected(ComponentName componentName) {
        if (Log.isLoggable("FirebaseInstanceId", 3)) {
            String valueOf = String.valueOf(componentName);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 23);
            sb.append("onServiceDisconnected: ");
            sb.append(valueOf);
            sb.toString();
        }
        m12613a();
    }

    private C3720k0(Context context, String str, ScheduledExecutorService scheduledExecutorService) {
        this.f10344d = new ArrayDeque();
        this.f10346f = false;
        this.f10341a = context.getApplicationContext();
        this.f10342b = new Intent(str).setPackage(this.f10341a.getPackageName());
        this.f10343c = scheduledExecutorService;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0087, code lost:
        return;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final synchronized void m12613a() {
        /*
            r5 = this;
            monitor-enter(r5)
            java.lang.String r0 = "FirebaseInstanceId"
            r1 = 3
            boolean r0 = android.util.Log.isLoggable(r0, r1)     // Catch:{ all -> 0x008a }
        L_0x0008:
            java.util.Queue<com.google.firebase.iid.j0> r0 = r5.f10344d     // Catch:{ all -> 0x008a }
            boolean r0 = r0.isEmpty()     // Catch:{ all -> 0x008a }
            if (r0 != 0) goto L_0x0088
            java.lang.String r0 = "FirebaseInstanceId"
            boolean r0 = android.util.Log.isLoggable(r0, r1)     // Catch:{ all -> 0x008a }
            com.google.firebase.iid.f0 r0 = r5.f10345e     // Catch:{ all -> 0x008a }
            if (r0 == 0) goto L_0x0036
            com.google.firebase.iid.f0 r0 = r5.f10345e     // Catch:{ all -> 0x008a }
            boolean r0 = r0.isBinderAlive()     // Catch:{ all -> 0x008a }
            if (r0 == 0) goto L_0x0036
            java.lang.String r0 = "FirebaseInstanceId"
            boolean r0 = android.util.Log.isLoggable(r0, r1)     // Catch:{ all -> 0x008a }
            java.util.Queue<com.google.firebase.iid.j0> r0 = r5.f10344d     // Catch:{ all -> 0x008a }
            java.lang.Object r0 = r0.poll()     // Catch:{ all -> 0x008a }
            com.google.firebase.iid.j0 r0 = (com.google.firebase.iid.C3717j0) r0     // Catch:{ all -> 0x008a }
            com.google.firebase.iid.f0 r2 = r5.f10345e     // Catch:{ all -> 0x008a }
            r2.mo27336a(r0)     // Catch:{ all -> 0x008a }
            goto L_0x0008
        L_0x0036:
            java.lang.String r0 = "FirebaseInstanceId"
            boolean r0 = android.util.Log.isLoggable(r0, r1)     // Catch:{ all -> 0x008a }
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L_0x0059
            boolean r0 = r5.f10346f     // Catch:{ all -> 0x008a }
            if (r0 != 0) goto L_0x0046
            r0 = 1
            goto L_0x0047
        L_0x0046:
            r0 = 0
        L_0x0047:
            r3 = 39
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x008a }
            r4.<init>(r3)     // Catch:{ all -> 0x008a }
            java.lang.String r3 = "binder is dead. start connection? "
            r4.append(r3)     // Catch:{ all -> 0x008a }
            r4.append(r0)     // Catch:{ all -> 0x008a }
            r4.toString()     // Catch:{ all -> 0x008a }
        L_0x0059:
            boolean r0 = r5.f10346f     // Catch:{ all -> 0x008a }
            if (r0 != 0) goto L_0x0086
            r5.f10346f = r2     // Catch:{ all -> 0x008a }
            com.google.android.gms.common.stats.ConnectionTracker r0 = com.google.android.gms.common.stats.ConnectionTracker.getInstance()     // Catch:{ SecurityException -> 0x0079 }
            android.content.Context r2 = r5.f10341a     // Catch:{ SecurityException -> 0x0079 }
            android.content.Intent r3 = r5.f10342b     // Catch:{ SecurityException -> 0x0079 }
            r4 = 65
            boolean r0 = r0.bindService(r2, r3, r5, r4)     // Catch:{ SecurityException -> 0x0079 }
            if (r0 == 0) goto L_0x0071
            monitor-exit(r5)
            return
        L_0x0071:
            java.lang.String r0 = "FirebaseInstanceId"
            java.lang.String r2 = "binding to the service failed"
            android.util.Log.e(r0, r2)     // Catch:{ SecurityException -> 0x0079 }
            goto L_0x0081
        L_0x0079:
            r0 = move-exception
            java.lang.String r2 = "FirebaseInstanceId"
            java.lang.String r3 = "Exception while binding the service"
            android.util.Log.e(r2, r3, r0)     // Catch:{ all -> 0x008a }
        L_0x0081:
            r5.f10346f = r1     // Catch:{ all -> 0x008a }
            r5.m12614b()     // Catch:{ all -> 0x008a }
        L_0x0086:
            monitor-exit(r5)
            return
        L_0x0088:
            monitor-exit(r5)
            return
        L_0x008a:
            r0 = move-exception
            monitor-exit(r5)
            goto L_0x008e
        L_0x008d:
            throw r0
        L_0x008e:
            goto L_0x008d
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.iid.C3720k0.m12613a():void");
    }
}
