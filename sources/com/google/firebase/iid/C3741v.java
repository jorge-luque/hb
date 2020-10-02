package com.google.firebase.iid;

import android.util.Pair;
import com.google.android.gms.tasks.Task;
import java.util.Map;
import java.util.concurrent.Executor;
import javax.annotation.concurrent.GuardedBy;
import p075d.p080b.C3191a;

/* renamed from: com.google.firebase.iid.v */
/* compiled from: com.google.firebase:firebase-iid@@20.1.7 */
final class C3741v {

    /* renamed from: a */
    private final Executor f10378a;
    @GuardedBy("this")

    /* renamed from: b */
    private final Map<Pair<String, String>, Task<C3690a>> f10379b = new C3191a();

    C3741v(Executor executor) {
        this.f10378a = executor;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0038, code lost:
        return r3;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized com.google.android.gms.tasks.Task<com.google.firebase.iid.C3690a> mo27370a(java.lang.String r3, java.lang.String r4, com.google.firebase.iid.C3745x r5) {
        /*
            r2 = this;
            monitor-enter(r2)
            android.util.Pair r0 = new android.util.Pair     // Catch:{ all -> 0x0075 }
            r0.<init>(r3, r4)     // Catch:{ all -> 0x0075 }
            java.util.Map<android.util.Pair<java.lang.String, java.lang.String>, com.google.android.gms.tasks.Task<com.google.firebase.iid.a>> r3 = r2.f10379b     // Catch:{ all -> 0x0075 }
            java.lang.Object r3 = r3.get(r0)     // Catch:{ all -> 0x0075 }
            com.google.android.gms.tasks.Task r3 = (com.google.android.gms.tasks.Task) r3     // Catch:{ all -> 0x0075 }
            r4 = 3
            if (r3 == 0) goto L_0x0039
            java.lang.String r5 = "FirebaseInstanceId"
            boolean r4 = android.util.Log.isLoggable(r5, r4)     // Catch:{ all -> 0x0075 }
            if (r4 == 0) goto L_0x0037
            java.lang.String r4 = java.lang.String.valueOf(r0)     // Catch:{ all -> 0x0075 }
            java.lang.String r5 = java.lang.String.valueOf(r4)     // Catch:{ all -> 0x0075 }
            int r5 = r5.length()     // Catch:{ all -> 0x0075 }
            int r5 = r5 + 29
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0075 }
            r0.<init>(r5)     // Catch:{ all -> 0x0075 }
            java.lang.String r5 = "Joining ongoing request for: "
            r0.append(r5)     // Catch:{ all -> 0x0075 }
            r0.append(r4)     // Catch:{ all -> 0x0075 }
            r0.toString()     // Catch:{ all -> 0x0075 }
        L_0x0037:
            monitor-exit(r2)
            return r3
        L_0x0039:
            java.lang.String r3 = "FirebaseInstanceId"
            boolean r3 = android.util.Log.isLoggable(r3, r4)     // Catch:{ all -> 0x0075 }
            if (r3 == 0) goto L_0x005f
            java.lang.String r3 = java.lang.String.valueOf(r0)     // Catch:{ all -> 0x0075 }
            java.lang.String r4 = java.lang.String.valueOf(r3)     // Catch:{ all -> 0x0075 }
            int r4 = r4.length()     // Catch:{ all -> 0x0075 }
            int r4 = r4 + 24
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0075 }
            r1.<init>(r4)     // Catch:{ all -> 0x0075 }
            java.lang.String r4 = "Making new request for: "
            r1.append(r4)     // Catch:{ all -> 0x0075 }
            r1.append(r3)     // Catch:{ all -> 0x0075 }
            r1.toString()     // Catch:{ all -> 0x0075 }
        L_0x005f:
            com.google.android.gms.tasks.Task r3 = r5.zza()     // Catch:{ all -> 0x0075 }
            java.util.concurrent.Executor r4 = r2.f10378a     // Catch:{ all -> 0x0075 }
            com.google.firebase.iid.u r5 = new com.google.firebase.iid.u     // Catch:{ all -> 0x0075 }
            r5.<init>(r2, r0)     // Catch:{ all -> 0x0075 }
            com.google.android.gms.tasks.Task r3 = r3.continueWithTask(r4, r5)     // Catch:{ all -> 0x0075 }
            java.util.Map<android.util.Pair<java.lang.String, java.lang.String>, com.google.android.gms.tasks.Task<com.google.firebase.iid.a>> r4 = r2.f10379b     // Catch:{ all -> 0x0075 }
            r4.put(r0, r3)     // Catch:{ all -> 0x0075 }
            monitor-exit(r2)
            return r3
        L_0x0075:
            r3 = move-exception
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.iid.C3741v.mo27370a(java.lang.String, java.lang.String, com.google.firebase.iid.x):com.google.android.gms.tasks.Task");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final /* synthetic */ Task mo27369a(Pair pair, Task task) throws Exception {
        synchronized (this) {
            this.f10379b.remove(pair);
        }
        return task;
    }
}
