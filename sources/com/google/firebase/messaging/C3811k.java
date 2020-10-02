package com.google.firebase.messaging;

import android.annotation.SuppressLint;
import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;
import com.google.android.gms.common.util.concurrent.NamedThreadFactory;
import com.google.android.gms.internal.firebase_messaging.zza;
import com.google.android.gms.internal.firebase_messaging.zzf;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.iid.C3705f0;
import com.google.firebase.iid.C3708g0;
import java.util.concurrent.ExecutorService;

@SuppressLint({"UnwrappedWakefulBroadcastReceiver"})
/* renamed from: com.google.firebase.messaging.k */
/* compiled from: com.google.firebase:firebase-messaging@@20.1.7 */
public abstract class C3811k extends Service {

    /* renamed from: a */
    private final ExecutorService f10546a = zza.zza().zza(new NamedThreadFactory("Firebase-Messaging-Intent-Handle"), zzf.zzb);

    /* renamed from: b */
    private Binder f10547b;

    /* renamed from: c */
    private final Object f10548c = new Object();

    /* renamed from: d */
    private int f10549d;

    /* renamed from: e */
    private int f10550e = 0;

    /* access modifiers changed from: private */
    /* renamed from: e */
    public final Task<Void> mo27503d(Intent intent) {
        if (mo27480b(intent)) {
            return Tasks.forResult(null);
        }
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.f10546a.execute(new C3813m(this, intent, taskCompletionSource));
        return taskCompletionSource.getTask();
    }

    /* renamed from: f */
    private final void m12878f(Intent intent) {
        if (intent != null) {
            C3708g0.m12606a(intent);
        }
        synchronized (this.f10548c) {
            int i = this.f10550e - 1;
            this.f10550e = i;
            if (i == 0) {
                stopSelfResult(this.f10549d);
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract Intent mo27474a(Intent intent);

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final /* synthetic */ void mo27502a(Intent intent, Task task) {
        m12878f(intent);
    }

    /* renamed from: b */
    public abstract boolean mo27480b(Intent intent);

    /* renamed from: c */
    public abstract void mo27481c(Intent intent);

    public final synchronized IBinder onBind(Intent intent) {
        boolean isLoggable = Log.isLoggable("EnhancedIntentService", 3);
        if (this.f10547b == null) {
            this.f10547b = new C3705f0(new C3810j(this));
        }
        return this.f10547b;
    }

    public void onDestroy() {
        this.f10546a.shutdown();
        super.onDestroy();
    }

    public final int onStartCommand(Intent intent, int i, int i2) {
        synchronized (this.f10548c) {
            this.f10549d = i2;
            this.f10550e++;
        }
        Intent a = mo27474a(intent);
        if (a == null) {
            m12878f(intent);
            return 2;
        }
        Task<Void> e = mo27503d(a);
        if (e.isComplete()) {
            m12878f(intent);
            return 2;
        }
        e.addOnCompleteListener(C3812l.f10551a, (OnCompleteListener<Void>) new C3815o(this, intent));
        return 3;
    }
}
