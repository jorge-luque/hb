package com.google.firebase.messaging;

import android.content.Context;
import android.os.Build;
import android.util.Log;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.FirebaseApp;
import com.google.firebase.iid.C3690a;
import com.google.firebase.iid.C3700d1;
import com.google.firebase.iid.C3731q;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.installations.C3764h;
import com.google.firebase.p073h.C3687h;
import com.google.firebase.p124e.C3666c;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import p075d.p080b.C3191a;

/* renamed from: com.google.firebase.messaging.d */
/* compiled from: com.google.firebase:firebase-messaging@@20.1.7 */
final class C3804d {

    /* renamed from: i */
    private static final long f10521i = TimeUnit.HOURS.toSeconds(8);

    /* renamed from: a */
    private final FirebaseInstanceId f10522a;

    /* renamed from: b */
    private final Context f10523b;

    /* renamed from: c */
    private final C3731q f10524c;

    /* renamed from: d */
    private final C3700d1 f10525d;

    /* renamed from: e */
    private final Map<String, ArrayDeque<TaskCompletionSource<Void>>> f10526e = new C3191a();

    /* renamed from: f */
    private final ScheduledExecutorService f10527f;

    /* renamed from: g */
    private boolean f10528g = false;

    /* renamed from: h */
    private final C3800a0 f10529h;

    private C3804d(FirebaseInstanceId firebaseInstanceId, C3731q qVar, C3800a0 a0Var, C3700d1 d1Var, Context context, ScheduledExecutorService scheduledExecutorService) {
        this.f10522a = firebaseInstanceId;
        this.f10524c = qVar;
        this.f10529h = a0Var;
        this.f10525d = d1Var;
        this.f10523b = context;
        this.f10527f = scheduledExecutorService;
    }

    /* renamed from: a */
    static Task<C3804d> m12850a(FirebaseApp firebaseApp, FirebaseInstanceId firebaseInstanceId, C3731q qVar, C3687h hVar, C3666c cVar, C3764h hVar2, Context context, Executor executor, ScheduledExecutorService scheduledExecutorService) {
        return Tasks.call(scheduledExecutorService, new C3803c(context, scheduledExecutorService, firebaseInstanceId, qVar, new C3700d1(firebaseApp, qVar, executor, hVar, cVar, hVar2)));
    }

    /* renamed from: c */
    private final synchronized boolean m12854c() {
        return this.f10528g;
    }

    /* renamed from: d */
    private static boolean m12855d() {
        if (!Log.isLoggable("FirebaseMessaging", 3)) {
            return Build.VERSION.SDK_INT == 23 && Log.isLoggable("FirebaseMessaging", 3);
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0017, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0019, code lost:
        r5.f10529h.mo27487a(r0);
        r1 = r5.f10526e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0020, code lost:
        monitor-enter(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:?, code lost:
        r0 = r0.mo27490c();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x002b, code lost:
        if (r5.f10526e.containsKey(r0) != false) goto L_0x002f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x002d, code lost:
        monitor-exit(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x002f, code lost:
        r2 = r5.f10526e.get(r0);
        r3 = (com.google.android.gms.tasks.TaskCompletionSource) r2.poll();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x003d, code lost:
        if (r3 == null) goto L_0x0043;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x003f, code lost:
        r3.setResult(null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0047, code lost:
        if (r2.isEmpty() == false) goto L_0x004e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0049, code lost:
        r5.f10526e.remove(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x004e, code lost:
        monitor-exit(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0015, code lost:
        if (m12853a(r0) != false) goto L_0x0019;
     */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean mo27498b() throws java.io.IOException {
        /*
            r5 = this;
        L_0x0000:
            monitor-enter(r5)
            com.google.firebase.messaging.a0 r0 = r5.f10529h     // Catch:{ all -> 0x0053 }
            com.google.firebase.messaging.b0 r0 = r0.mo27486a()     // Catch:{ all -> 0x0053 }
            if (r0 != 0) goto L_0x0010
            boolean r0 = m12855d()     // Catch:{ all -> 0x0053 }
            r0 = 1
            monitor-exit(r5)     // Catch:{ all -> 0x0053 }
            return r0
        L_0x0010:
            monitor-exit(r5)     // Catch:{ all -> 0x0053 }
            boolean r1 = r5.m12853a((com.google.firebase.messaging.C3802b0) r0)
            if (r1 != 0) goto L_0x0019
            r0 = 0
            return r0
        L_0x0019:
            com.google.firebase.messaging.a0 r1 = r5.f10529h
            r1.mo27487a(r0)
            java.util.Map<java.lang.String, java.util.ArrayDeque<com.google.android.gms.tasks.TaskCompletionSource<java.lang.Void>>> r1 = r5.f10526e
            monitor-enter(r1)
            java.lang.String r0 = r0.mo27490c()     // Catch:{ all -> 0x0050 }
            java.util.Map<java.lang.String, java.util.ArrayDeque<com.google.android.gms.tasks.TaskCompletionSource<java.lang.Void>>> r2 = r5.f10526e     // Catch:{ all -> 0x0050 }
            boolean r2 = r2.containsKey(r0)     // Catch:{ all -> 0x0050 }
            if (r2 != 0) goto L_0x002f
            monitor-exit(r1)     // Catch:{ all -> 0x0050 }
            goto L_0x0000
        L_0x002f:
            java.util.Map<java.lang.String, java.util.ArrayDeque<com.google.android.gms.tasks.TaskCompletionSource<java.lang.Void>>> r2 = r5.f10526e     // Catch:{ all -> 0x0050 }
            java.lang.Object r2 = r2.get(r0)     // Catch:{ all -> 0x0050 }
            java.util.ArrayDeque r2 = (java.util.ArrayDeque) r2     // Catch:{ all -> 0x0050 }
            java.lang.Object r3 = r2.poll()     // Catch:{ all -> 0x0050 }
            com.google.android.gms.tasks.TaskCompletionSource r3 = (com.google.android.gms.tasks.TaskCompletionSource) r3     // Catch:{ all -> 0x0050 }
            if (r3 == 0) goto L_0x0043
            r4 = 0
            r3.setResult(r4)     // Catch:{ all -> 0x0050 }
        L_0x0043:
            boolean r2 = r2.isEmpty()     // Catch:{ all -> 0x0050 }
            if (r2 == 0) goto L_0x004e
            java.util.Map<java.lang.String, java.util.ArrayDeque<com.google.android.gms.tasks.TaskCompletionSource<java.lang.Void>>> r2 = r5.f10526e     // Catch:{ all -> 0x0050 }
            r2.remove(r0)     // Catch:{ all -> 0x0050 }
        L_0x004e:
            monitor-exit(r1)     // Catch:{ all -> 0x0050 }
            goto L_0x0000
        L_0x0050:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x0050 }
            throw r0
        L_0x0053:
            r0 = move-exception
            monitor-exit(r5)     // Catch:{ all -> 0x0053 }
            goto L_0x0057
        L_0x0056:
            throw r0
        L_0x0057:
            goto L_0x0056
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.messaging.C3804d.mo27498b():boolean");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo27494a() {
        if ((this.f10529h.mo27486a() != null) && !m12854c()) {
            mo27495a(0);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo27495a(long j) {
        mo27496a(new C3806f(this, this.f10523b, this.f10524c, Math.min(Math.max(30, j << 1), f10521i)), j);
        mo27497a(true);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo27496a(Runnable runnable, long j) {
        this.f10527f.schedule(runnable, j, TimeUnit.SECONDS);
    }

    /* renamed from: a */
    private final boolean m12853a(C3802b0 b0Var) throws IOException {
        try {
            String b = b0Var.mo27489b();
            char c = 65535;
            int hashCode = b.hashCode();
            if (hashCode != 83) {
                if (hashCode == 85) {
                    if (b.equals("U")) {
                        c = 1;
                    }
                }
            } else if (b.equals("S")) {
                c = 0;
            }
            if (c == 0) {
                String a = b0Var.mo27488a();
                C3690a aVar = (C3690a) m12852a(this.f10522a.mo27297b());
                m12852a(this.f10525d.mo27320b(aVar.getId(), aVar.getToken(), a));
                if (m12855d()) {
                    String a2 = b0Var.mo27488a();
                    StringBuilder sb = new StringBuilder(String.valueOf(a2).length() + 31);
                    sb.append("Subscribe to topic: ");
                    sb.append(a2);
                    sb.append(" succeeded.");
                    sb.toString();
                }
            } else if (c == 1) {
                String a3 = b0Var.mo27488a();
                C3690a aVar2 = (C3690a) m12852a(this.f10522a.mo27297b());
                m12852a(this.f10525d.mo27321c(aVar2.getId(), aVar2.getToken(), a3));
                if (m12855d()) {
                    String a4 = b0Var.mo27488a();
                    StringBuilder sb2 = new StringBuilder(String.valueOf(a4).length() + 35);
                    sb2.append("Unsubscribe from topic: ");
                    sb2.append(a4);
                    sb2.append(" succeeded.");
                    sb2.toString();
                }
            } else if (m12855d()) {
                String valueOf = String.valueOf(b0Var);
                StringBuilder sb3 = new StringBuilder(String.valueOf(valueOf).length() + 24);
                sb3.append("Unknown topic operation");
                sb3.append(valueOf);
                sb3.append(".");
                sb3.toString();
            }
            return true;
        } catch (IOException e) {
            if ("SERVICE_NOT_AVAILABLE".equals(e.getMessage()) || "INTERNAL_SERVER_ERROR".equals(e.getMessage())) {
                String message = e.getMessage();
                StringBuilder sb4 = new StringBuilder(String.valueOf(message).length() + 53);
                sb4.append("Topic operation failed: ");
                sb4.append(message);
                sb4.append(". Will retry Topic operation.");
                Log.e("FirebaseMessaging", sb4.toString());
                return false;
            } else if (e.getMessage() == null) {
                Log.e("FirebaseMessaging", "Topic operation failed without exception message. Will retry Topic operation.");
                return false;
            } else {
                throw e;
            }
        }
    }

    /* renamed from: a */
    private static <T> T m12852a(Task<T> task) throws IOException {
        try {
            return Tasks.await(task, 30, TimeUnit.SECONDS);
        } catch (ExecutionException e) {
            Throwable cause = e.getCause();
            if (cause instanceof IOException) {
                throw ((IOException) cause);
            } else if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            } else {
                throw new IOException(e);
            }
        } catch (InterruptedException | TimeoutException e2) {
            throw new IOException("SERVICE_NOT_AVAILABLE", e2);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final synchronized void mo27497a(boolean z) {
        this.f10528g = z;
    }

    /* renamed from: a */
    static final /* synthetic */ C3804d m12851a(Context context, ScheduledExecutorService scheduledExecutorService, FirebaseInstanceId firebaseInstanceId, C3731q qVar, C3700d1 d1Var) throws Exception {
        return new C3804d(firebaseInstanceId, qVar, C3800a0.m12842a(context, scheduledExecutorService), d1Var, context, scheduledExecutorService);
    }
}
