package com.google.firebase.remoteconfig.internal;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;

/* renamed from: com.google.firebase.remoteconfig.internal.g */
/* compiled from: com.google.firebase:firebase-config@@19.1.4 */
final /* synthetic */ class C3848g implements Continuation {

    /* renamed from: a */
    private final C3852k f10627a;

    /* renamed from: b */
    private final long f10628b;

    private C3848g(C3852k kVar, long j) {
        this.f10627a = kVar;
        this.f10628b = j;
    }

    /* renamed from: a */
    public static Continuation m13012a(C3852k kVar, long j) {
        return new C3848g(kVar, j);
    }

    public Object then(Task task) {
        return this.f10627a.m13017a((Task<C3845f>) task, this.f10628b);
    }
}
