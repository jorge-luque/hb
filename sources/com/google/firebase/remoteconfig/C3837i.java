package com.google.firebase.remoteconfig;

import java.util.concurrent.Callable;

/* renamed from: com.google.firebase.remoteconfig.i */
/* compiled from: com.google.firebase:firebase-config@@19.1.4 */
final /* synthetic */ class C3837i implements Callable {

    /* renamed from: a */
    private final C3862k f10597a;

    private C3837i(C3862k kVar) {
        this.f10597a = kVar;
    }

    /* renamed from: a */
    public static Callable m12972a(C3862k kVar) {
        return new C3837i(kVar);
    }

    public Object call() {
        return this.f10597a.mo27604a();
    }
}
