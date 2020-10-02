package com.google.firebase.installations;

import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.installations.C3768l;
import com.google.firebase.installations.p129p.C3779d;

/* renamed from: com.google.firebase.installations.j */
/* compiled from: com.google.firebase:firebase-installations@@16.3.0 */
class C3766j implements C3771n {

    /* renamed from: a */
    private final C3772o f10438a;

    /* renamed from: b */
    private final TaskCompletionSource<C3768l> f10439b;

    public C3766j(C3772o oVar, TaskCompletionSource<C3768l> taskCompletionSource) {
        this.f10438a = oVar;
        this.f10439b = taskCompletionSource;
    }

    /* renamed from: a */
    public boolean mo27408a(C3779d dVar) {
        if (!dVar.mo27442j() || this.f10438a.mo27412a(dVar)) {
            return false;
        }
        TaskCompletionSource<C3768l> taskCompletionSource = this.f10439b;
        C3768l.C3769a d = C3768l.m12698d();
        d.mo27394a(dVar.mo27413a());
        d.mo27396b(dVar.mo27414b());
        d.mo27393a(dVar.mo27420g());
        taskCompletionSource.setResult(d.mo27395a());
        return true;
    }

    /* renamed from: a */
    public boolean mo27409a(C3779d dVar, Exception exc) {
        if (!dVar.mo27440h() && !dVar.mo27441i() && !dVar.mo27443k()) {
            return false;
        }
        this.f10439b.trySetException(exc);
        return true;
    }
}
