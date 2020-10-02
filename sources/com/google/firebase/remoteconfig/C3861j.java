package com.google.firebase.remoteconfig;

import com.google.firebase.remoteconfig.internal.C3858p;
import java.util.concurrent.Callable;

/* renamed from: com.google.firebase.remoteconfig.j */
/* compiled from: com.google.firebase:firebase-config@@19.1.4 */
final /* synthetic */ class C3861j implements Callable {

    /* renamed from: a */
    private final C3858p f10665a;

    private C3861j(C3858p pVar) {
        this.f10665a = pVar;
    }

    /* renamed from: a */
    public static Callable m13084a(C3858p pVar) {
        return new C3861j(pVar);
    }

    public Object call() {
        return Boolean.valueOf(this.f10665a.mo27601a());
    }
}
