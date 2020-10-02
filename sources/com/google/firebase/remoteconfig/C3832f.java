package com.google.firebase.remoteconfig;

import java.util.concurrent.Callable;

/* renamed from: com.google.firebase.remoteconfig.f */
/* compiled from: com.google.firebase:firebase-config@@19.1.4 */
final /* synthetic */ class C3832f implements Callable {

    /* renamed from: a */
    private final C3833g f10580a;

    /* renamed from: b */
    private final C3834h f10581b;

    private C3832f(C3833g gVar, C3834h hVar) {
        this.f10580a = gVar;
        this.f10581b = hVar;
    }

    /* renamed from: a */
    public static Callable m12943a(C3833g gVar, C3834h hVar) {
        return new C3832f(gVar, hVar);
    }

    public Object call() {
        return this.f10580a.f10590i.mo27587a(this.f10581b);
    }
}
