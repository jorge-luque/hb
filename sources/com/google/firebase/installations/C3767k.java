package com.google.firebase.installations;

import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.installations.p129p.C3779d;

/* renamed from: com.google.firebase.installations.k */
/* compiled from: com.google.firebase:firebase-installations@@16.3.0 */
class C3767k implements C3771n {

    /* renamed from: a */
    final TaskCompletionSource<String> f10440a;

    public C3767k(TaskCompletionSource<String> taskCompletionSource) {
        this.f10440a = taskCompletionSource;
    }

    /* renamed from: a */
    public boolean mo27408a(C3779d dVar) {
        if (!dVar.mo27443k() && !dVar.mo27442j() && !dVar.mo27440h()) {
            return false;
        }
        this.f10440a.trySetResult(dVar.mo27415c());
        return true;
    }

    /* renamed from: a */
    public boolean mo27409a(C3779d dVar, Exception exc) {
        return false;
    }
}
