package com.google.firebase.iid;

import android.content.Intent;
import android.util.Log;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;

/* renamed from: com.google.firebase.iid.j0 */
/* compiled from: com.google.firebase:firebase-iid@@20.1.7 */
final class C3717j0 {

    /* renamed from: a */
    final Intent f10336a;

    /* renamed from: b */
    private final TaskCompletionSource<Void> f10337b = new TaskCompletionSource<>();

    C3717j0(Intent intent) {
        this.f10336a = intent;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final Task<Void> mo27344a() {
        return this.f10337b.getTask();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final void mo27345b() {
        this.f10337b.trySetResult(null);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public final /* synthetic */ void mo27346c() {
        String action = this.f10336a.getAction();
        StringBuilder sb = new StringBuilder(String.valueOf(action).length() + 61);
        sb.append("Service took too long to process intent: ");
        sb.append(action);
        sb.append(" App may get closed.");
        Log.w("FirebaseInstanceId", sb.toString());
        mo27345b();
    }
}
