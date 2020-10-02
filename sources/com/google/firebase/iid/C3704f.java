package com.google.firebase.iid;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Looper;
import android.os.Messenger;
import android.util.Log;
import android.util.SparseArray;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.internal.firebase_messaging.zze;
import java.util.ArrayDeque;
import java.util.Queue;
import javax.annotation.concurrent.GuardedBy;

/* renamed from: com.google.firebase.iid.f */
/* compiled from: com.google.firebase:firebase-iid@@20.1.7 */
final class C3704f implements ServiceConnection {
    @GuardedBy("this")

    /* renamed from: a */
    int f10319a;

    /* renamed from: b */
    final Messenger f10320b;

    /* renamed from: c */
    C3727o f10321c;
    @GuardedBy("this")

    /* renamed from: d */
    final Queue<C3729p<?>> f10322d;
    @GuardedBy("this")

    /* renamed from: e */
    final SparseArray<C3729p<?>> f10323e;

    /* renamed from: f */
    final /* synthetic */ C3701e f10324f;

    private C3704f(C3701e eVar) {
        this.f10324f = eVar;
        this.f10319a = 0;
        this.f10320b = new Messenger(new zze(Looper.getMainLooper(), new C3713i(this)));
        this.f10322d = new ArrayDeque();
        this.f10323e = new SparseArray<>();
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x002f, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x008d, code lost:
        return true;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized boolean mo27331a(com.google.firebase.iid.C3729p<?> r6) {
        /*
            r5 = this;
            monitor-enter(r5)
            int r0 = r5.f10319a     // Catch:{ all -> 0x008e }
            r1 = 2
            r2 = 0
            r3 = 1
            if (r0 == 0) goto L_0x0041
            if (r0 == r3) goto L_0x003a
            if (r0 == r1) goto L_0x0030
            r6 = 3
            if (r0 == r6) goto L_0x002e
            r6 = 4
            if (r0 != r6) goto L_0x0013
            goto L_0x002e
        L_0x0013:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException     // Catch:{ all -> 0x008e }
            int r0 = r5.f10319a     // Catch:{ all -> 0x008e }
            r1 = 26
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x008e }
            r2.<init>(r1)     // Catch:{ all -> 0x008e }
            java.lang.String r1 = "Unknown state: "
            r2.append(r1)     // Catch:{ all -> 0x008e }
            r2.append(r0)     // Catch:{ all -> 0x008e }
            java.lang.String r0 = r2.toString()     // Catch:{ all -> 0x008e }
            r6.<init>(r0)     // Catch:{ all -> 0x008e }
            throw r6     // Catch:{ all -> 0x008e }
        L_0x002e:
            monitor-exit(r5)
            return r2
        L_0x0030:
            java.util.Queue<com.google.firebase.iid.p<?>> r0 = r5.f10322d     // Catch:{ all -> 0x008e }
            r0.add(r6)     // Catch:{ all -> 0x008e }
            r5.mo27327a()     // Catch:{ all -> 0x008e }
            monitor-exit(r5)
            return r3
        L_0x003a:
            java.util.Queue<com.google.firebase.iid.p<?>> r0 = r5.f10322d     // Catch:{ all -> 0x008e }
            r0.add(r6)     // Catch:{ all -> 0x008e }
            monitor-exit(r5)
            return r3
        L_0x0041:
            java.util.Queue<com.google.firebase.iid.p<?>> r0 = r5.f10322d     // Catch:{ all -> 0x008e }
            r0.add(r6)     // Catch:{ all -> 0x008e }
            int r6 = r5.f10319a     // Catch:{ all -> 0x008e }
            if (r6 != 0) goto L_0x004c
            r6 = 1
            goto L_0x004d
        L_0x004c:
            r6 = 0
        L_0x004d:
            com.google.android.gms.common.internal.Preconditions.checkState(r6)     // Catch:{ all -> 0x008e }
            java.lang.String r6 = "MessengerIpcClient"
            boolean r6 = android.util.Log.isLoggable(r6, r1)     // Catch:{ all -> 0x008e }
            r5.f10319a = r3     // Catch:{ all -> 0x008e }
            android.content.Intent r6 = new android.content.Intent     // Catch:{ all -> 0x008e }
            java.lang.String r0 = "com.google.android.c2dm.intent.REGISTER"
            r6.<init>(r0)     // Catch:{ all -> 0x008e }
            java.lang.String r0 = "com.google.android.gms"
            r6.setPackage(r0)     // Catch:{ all -> 0x008e }
            com.google.android.gms.common.stats.ConnectionTracker r0 = com.google.android.gms.common.stats.ConnectionTracker.getInstance()     // Catch:{ all -> 0x008e }
            com.google.firebase.iid.e r1 = r5.f10324f     // Catch:{ all -> 0x008e }
            android.content.Context r1 = r1.f10312a     // Catch:{ all -> 0x008e }
            boolean r6 = r0.bindService(r1, r6, r5, r3)     // Catch:{ all -> 0x008e }
            if (r6 != 0) goto L_0x007a
            java.lang.String r6 = "Unable to bind to service"
            r5.mo27329a(r2, r6)     // Catch:{ all -> 0x008e }
            goto L_0x008c
        L_0x007a:
            com.google.firebase.iid.e r6 = r5.f10324f     // Catch:{ all -> 0x008e }
            java.util.concurrent.ScheduledExecutorService r6 = r6.f10313b     // Catch:{ all -> 0x008e }
            com.google.firebase.iid.h r0 = new com.google.firebase.iid.h     // Catch:{ all -> 0x008e }
            r0.<init>(r5)     // Catch:{ all -> 0x008e }
            r1 = 30
            java.util.concurrent.TimeUnit r4 = java.util.concurrent.TimeUnit.SECONDS     // Catch:{ all -> 0x008e }
            r6.schedule(r0, r1, r4)     // Catch:{ all -> 0x008e }
        L_0x008c:
            monitor-exit(r5)
            return r3
        L_0x008e:
            r6 = move-exception
            monitor-exit(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.iid.C3704f.mo27331a(com.google.firebase.iid.p):boolean");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final synchronized void mo27332b() {
        if (this.f10319a == 2 && this.f10322d.isEmpty() && this.f10323e.size() == 0) {
            boolean isLoggable = Log.isLoggable("MessengerIpcClient", 2);
            this.f10319a = 3;
            ConnectionTracker.getInstance().unbindService(this.f10324f.f10312a, this);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public final synchronized void mo27333c() {
        if (this.f10319a == 1) {
            mo27329a(1, "Timed out while binding");
        }
    }

    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        boolean isLoggable = Log.isLoggable("MessengerIpcClient", 2);
        this.f10324f.f10313b.execute(new C3719k(this, iBinder));
    }

    public final void onServiceDisconnected(ComponentName componentName) {
        boolean isLoggable = Log.isLoggable("MessengerIpcClient", 2);
        this.f10324f.f10313b.execute(new C3723m(this));
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x004c, code lost:
        r5 = r5.getData();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0057, code lost:
        if (r5.getBoolean("unsupported", false) == false) goto L_0x0065;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0059, code lost:
        r1.mo27358a(new com.google.firebase.iid.zzam(4, "Not supported by GmsCore"));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0065, code lost:
        r1.mo27354a(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0068, code lost:
        return true;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean mo27330a(android.os.Message r5) {
        /*
            r4 = this;
            int r0 = r5.arg1
            java.lang.String r1 = "MessengerIpcClient"
            r2 = 3
            boolean r1 = android.util.Log.isLoggable(r1, r2)
            if (r1 == 0) goto L_0x001d
            r1 = 41
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>(r1)
            java.lang.String r1 = "Received response to request: "
            r2.append(r1)
            r2.append(r0)
            r2.toString()
        L_0x001d:
            monitor-enter(r4)
            android.util.SparseArray<com.google.firebase.iid.p<?>> r1 = r4.f10323e     // Catch:{ all -> 0x0069 }
            java.lang.Object r1 = r1.get(r0)     // Catch:{ all -> 0x0069 }
            com.google.firebase.iid.p r1 = (com.google.firebase.iid.C3729p) r1     // Catch:{ all -> 0x0069 }
            r2 = 1
            if (r1 != 0) goto L_0x0043
            java.lang.String r5 = "MessengerIpcClient"
            r1 = 50
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0069 }
            r3.<init>(r1)     // Catch:{ all -> 0x0069 }
            java.lang.String r1 = "Received response for unknown request: "
            r3.append(r1)     // Catch:{ all -> 0x0069 }
            r3.append(r0)     // Catch:{ all -> 0x0069 }
            java.lang.String r0 = r3.toString()     // Catch:{ all -> 0x0069 }
            android.util.Log.w(r5, r0)     // Catch:{ all -> 0x0069 }
            monitor-exit(r4)     // Catch:{ all -> 0x0069 }
            return r2
        L_0x0043:
            android.util.SparseArray<com.google.firebase.iid.p<?>> r3 = r4.f10323e     // Catch:{ all -> 0x0069 }
            r3.remove(r0)     // Catch:{ all -> 0x0069 }
            r4.mo27332b()     // Catch:{ all -> 0x0069 }
            monitor-exit(r4)     // Catch:{ all -> 0x0069 }
            android.os.Bundle r5 = r5.getData()
            r0 = 0
            java.lang.String r3 = "unsupported"
            boolean r0 = r5.getBoolean(r3, r0)
            if (r0 == 0) goto L_0x0065
            com.google.firebase.iid.zzam r5 = new com.google.firebase.iid.zzam
            r0 = 4
            java.lang.String r3 = "Not supported by GmsCore"
            r5.<init>(r0, r3)
            r1.mo27358a((com.google.firebase.iid.zzam) r5)
            goto L_0x0068
        L_0x0065:
            r1.mo27354a((android.os.Bundle) r5)
        L_0x0068:
            return r2
        L_0x0069:
            r5 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x0069 }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.iid.C3704f.mo27330a(android.os.Message):boolean");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo27327a() {
        this.f10324f.f10313b.execute(new C3716j(this));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final synchronized void mo27329a(int i, String str) {
        if (Log.isLoggable("MessengerIpcClient", 3)) {
            String valueOf = String.valueOf(str);
            if (valueOf.length() != 0) {
                "Disconnected: ".concat(valueOf);
            } else {
                new String("Disconnected: ");
            }
        }
        int i2 = this.f10319a;
        if (i2 == 0) {
            throw new IllegalStateException();
        } else if (i2 == 1 || i2 == 2) {
            boolean isLoggable = Log.isLoggable("MessengerIpcClient", 2);
            this.f10319a = 4;
            ConnectionTracker.getInstance().unbindService(this.f10324f.f10312a, this);
            zzam zzam = new zzam(i, str);
            for (C3729p a : this.f10322d) {
                a.mo27358a(zzam);
            }
            this.f10322d.clear();
            for (int i3 = 0; i3 < this.f10323e.size(); i3++) {
                this.f10323e.valueAt(i3).mo27358a(zzam);
            }
            this.f10323e.clear();
        } else if (i2 == 3) {
            this.f10319a = 4;
        } else if (i2 != 4) {
            int i4 = this.f10319a;
            StringBuilder sb = new StringBuilder(26);
            sb.append("Unknown state: ");
            sb.append(i4);
            throw new IllegalStateException(sb.toString());
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final synchronized void mo27328a(int i) {
        C3729p pVar = this.f10323e.get(i);
        if (pVar != null) {
            StringBuilder sb = new StringBuilder(31);
            sb.append("Timing out request: ");
            sb.append(i);
            Log.w("MessengerIpcClient", sb.toString());
            this.f10323e.remove(i);
            pVar.mo27358a(new zzam(3, "Timed out waiting for response"));
            mo27332b();
        }
    }
}
