package com.google.firebase.iid;

import android.content.Intent;
import com.google.android.gms.stats.WakeLock;
import java.util.concurrent.TimeUnit;
import javax.annotation.concurrent.GuardedBy;

/* renamed from: com.google.firebase.iid.g0 */
/* compiled from: com.google.firebase:firebase-iid@@20.1.7 */
public final class C3708g0 {

    /* renamed from: a */
    private static final long f10327a = TimeUnit.MINUTES.toMillis(1);

    /* renamed from: b */
    private static final Object f10328b = new Object();
    @GuardedBy("WakeLockHolder.syncObject")

    /* renamed from: c */
    private static WakeLock f10329c;

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0031, code lost:
        return r4;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.content.ComponentName m12605a(android.content.Context r4, android.content.Intent r5) {
        /*
            java.lang.Object r0 = f10328b
            monitor-enter(r0)
            com.google.android.gms.stats.WakeLock r1 = f10329c     // Catch:{ all -> 0x0032 }
            r2 = 1
            if (r1 != 0) goto L_0x0014
            com.google.android.gms.stats.WakeLock r1 = new com.google.android.gms.stats.WakeLock     // Catch:{ all -> 0x0032 }
            java.lang.String r3 = "wake:com.google.firebase.iid.WakeLockHolder"
            r1.<init>(r4, r2, r3)     // Catch:{ all -> 0x0032 }
            f10329c = r1     // Catch:{ all -> 0x0032 }
            r1.setReferenceCounted(r2)     // Catch:{ all -> 0x0032 }
        L_0x0014:
            java.lang.String r1 = "com.google.firebase.iid.WakeLockHolder.wakefulintent"
            r3 = 0
            boolean r1 = r5.getBooleanExtra(r1, r3)     // Catch:{ all -> 0x0032 }
            m12607a((android.content.Intent) r5, (boolean) r2)     // Catch:{ all -> 0x0032 }
            android.content.ComponentName r4 = r4.startService(r5)     // Catch:{ all -> 0x0032 }
            if (r4 != 0) goto L_0x0027
            r4 = 0
            monitor-exit(r0)     // Catch:{ all -> 0x0032 }
            return r4
        L_0x0027:
            if (r1 != 0) goto L_0x0030
            com.google.android.gms.stats.WakeLock r5 = f10329c     // Catch:{ all -> 0x0032 }
            long r1 = f10327a     // Catch:{ all -> 0x0032 }
            r5.acquire(r1)     // Catch:{ all -> 0x0032 }
        L_0x0030:
            monitor-exit(r0)     // Catch:{ all -> 0x0032 }
            return r4
        L_0x0032:
            r4 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0032 }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.iid.C3708g0.m12605a(android.content.Context, android.content.Intent):android.content.ComponentName");
    }

    /* renamed from: a */
    private static void m12607a(Intent intent, boolean z) {
        intent.putExtra("com.google.firebase.iid.WakeLockHolder.wakefulintent", z);
    }

    /* renamed from: a */
    public static void m12606a(Intent intent) {
        synchronized (f10328b) {
            if (f10329c != null && intent.getBooleanExtra("com.google.firebase.iid.WakeLockHolder.wakefulintent", false)) {
                m12607a(intent, false);
                f10329c.release();
            }
        }
    }
}
