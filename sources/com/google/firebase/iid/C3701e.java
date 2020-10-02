package com.google.firebase.iid;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.common.util.concurrent.NamedThreadFactory;
import com.google.android.gms.internal.firebase_messaging.zza;
import com.google.android.gms.internal.firebase_messaging.zzf;
import com.google.android.gms.tasks.Task;
import java.util.concurrent.ScheduledExecutorService;
import javax.annotation.concurrent.GuardedBy;

/* renamed from: com.google.firebase.iid.e */
/* compiled from: com.google.firebase:firebase-iid@@20.1.7 */
public final class C3701e {
    @GuardedBy("MessengerIpcClient.class")

    /* renamed from: e */
    private static C3701e f10311e;
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final Context f10312a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final ScheduledExecutorService f10313b;
    @GuardedBy("this")

    /* renamed from: c */
    private C3704f f10314c = new C3704f(this);
    @GuardedBy("this")

    /* renamed from: d */
    private int f10315d = 1;

    private C3701e(Context context, ScheduledExecutorService scheduledExecutorService) {
        this.f10313b = scheduledExecutorService;
        this.f10312a = context.getApplicationContext();
    }

    /* renamed from: a */
    public static synchronized C3701e m12590a(Context context) {
        C3701e eVar;
        synchronized (C3701e.class) {
            if (f10311e == null) {
                f10311e = new C3701e(context, zza.zza().zza(1, new NamedThreadFactory("MessengerIpcClient"), zzf.zzb));
            }
            eVar = f10311e;
        }
        return eVar;
    }

    /* renamed from: b */
    public final Task<Bundle> mo27323b(int i, Bundle bundle) {
        return m12589a(new C3733r(m12587a(), 1, bundle));
    }

    /* renamed from: a */
    public final Task<Void> mo27322a(int i, Bundle bundle) {
        return m12589a(new C3725n(m12587a(), 2, bundle));
    }

    /* renamed from: a */
    private final synchronized <T> Task<T> m12589a(C3729p<T> pVar) {
        if (Log.isLoggable("MessengerIpcClient", 3)) {
            String valueOf = String.valueOf(pVar);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 9);
            sb.append("Queueing ");
            sb.append(valueOf);
            sb.toString();
        }
        if (!this.f10314c.mo27331a((C3729p<?>) pVar)) {
            C3704f fVar = new C3704f(this);
            this.f10314c = fVar;
            fVar.mo27331a((C3729p<?>) pVar);
        }
        return pVar.f10359b.getTask();
    }

    /* renamed from: a */
    private final synchronized int m12587a() {
        int i;
        i = this.f10315d;
        this.f10315d = i + 1;
        return i;
    }
}
