package com.google.firebase.remoteconfig.internal;

import java.util.concurrent.Callable;

/* renamed from: com.google.firebase.remoteconfig.internal.a */
/* compiled from: com.google.firebase:firebase-config@@19.1.4 */
final /* synthetic */ class C3838a implements Callable {

    /* renamed from: a */
    private final C3842e f10606a;

    /* renamed from: b */
    private final C3845f f10607b;

    private C3838a(C3842e eVar, C3845f fVar) {
        this.f10606a = eVar;
        this.f10607b = fVar;
    }

    /* renamed from: a */
    public static Callable m12985a(C3842e eVar, C3845f fVar) {
        return new C3838a(eVar, fVar);
    }

    public Object call() {
        return this.f10606a.f10616b.mo18336a(this.f10607b);
    }
}
