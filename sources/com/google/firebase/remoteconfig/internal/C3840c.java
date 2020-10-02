package com.google.firebase.remoteconfig.internal;

import java.util.concurrent.Callable;

/* renamed from: com.google.firebase.remoteconfig.internal.c */
/* compiled from: com.google.firebase:firebase-config@@19.1.4 */
final /* synthetic */ class C3840c implements Callable {

    /* renamed from: a */
    private final C3101n f10611a;

    private C3840c(C3101n nVar) {
        this.f10611a = nVar;
    }

    /* renamed from: a */
    public static Callable m12987a(C3101n nVar) {
        return new C3840c(nVar);
    }

    public Object call() {
        return this.f10611a.mo18338c();
    }
}
