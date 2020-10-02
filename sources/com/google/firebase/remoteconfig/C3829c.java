package com.google.firebase.remoteconfig;

import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;

/* renamed from: com.google.firebase.remoteconfig.c */
/* compiled from: com.google.firebase:firebase-config@@19.1.4 */
final /* synthetic */ class C3829c implements SuccessContinuation {

    /* renamed from: a */
    private final C3833g f10575a;

    private C3829c(C3833g gVar) {
        this.f10575a = gVar;
    }

    /* renamed from: a */
    public static SuccessContinuation m12940a(C3833g gVar) {
        return new C3829c(gVar);
    }

    public Task then(Object obj) {
        return this.f10575a.mo27542a();
    }
}
