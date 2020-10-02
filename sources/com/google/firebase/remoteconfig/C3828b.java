package com.google.firebase.remoteconfig;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.firebase.remoteconfig.internal.C3845f;

/* renamed from: com.google.firebase.remoteconfig.b */
/* compiled from: com.google.firebase:firebase-config@@19.1.4 */
final /* synthetic */ class C3828b implements Continuation {

    /* renamed from: a */
    private final C3833g f10574a;

    private C3828b(C3833g gVar) {
        this.f10574a = gVar;
    }

    /* renamed from: a */
    public static Continuation m12939a(C3833g gVar) {
        return new C3828b(gVar);
    }

    public Object then(Task task) {
        return Boolean.valueOf(this.f10574a.m12951a((Task<C3845f>) task));
    }
}
