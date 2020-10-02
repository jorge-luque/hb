package com.google.android.datatransport.runtime.backends;

import android.content.Context;
import p188f.p189a.C5913b;
import p193h.p194a.C5925a;

/* renamed from: com.google.android.datatransport.runtime.backends.l */
/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
public final class C3004l implements C5913b<C3002k> {

    /* renamed from: a */
    private final C5925a<Context> f8364a;

    /* renamed from: b */
    private final C5925a<C3000i> f8365b;

    public C3004l(C5925a<Context> aVar, C5925a<C3000i> aVar2) {
        this.f8364a = aVar;
        this.f8365b = aVar2;
    }

    /* renamed from: a */
    public static C3004l m9883a(C5925a<Context> aVar, C5925a<C3000i> aVar2) {
        return new C3004l(aVar, aVar2);
    }

    public C3002k get() {
        return new C3002k(this.f8364a.get(), this.f8365b.get());
    }
}
