package com.google.android.datatransport.runtime.backends;

import android.content.Context;
import p093e.p101c.p102a.p103a.p104i.p109w.C3469a;
import p188f.p189a.C5913b;
import p193h.p194a.C5925a;

/* renamed from: com.google.android.datatransport.runtime.backends.j */
/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
public final class C3001j implements C5913b<C3000i> {

    /* renamed from: a */
    private final C5925a<Context> f8356a;

    /* renamed from: b */
    private final C5925a<C3469a> f8357b;

    /* renamed from: c */
    private final C5925a<C3469a> f8358c;

    public C3001j(C5925a<Context> aVar, C5925a<C3469a> aVar2, C5925a<C3469a> aVar3) {
        this.f8356a = aVar;
        this.f8357b = aVar2;
        this.f8358c = aVar3;
    }

    /* renamed from: a */
    public static C3001j m9878a(C5925a<Context> aVar, C5925a<C3469a> aVar2, C5925a<C3469a> aVar3) {
        return new C3001j(aVar, aVar2, aVar3);
    }

    public C3000i get() {
        return new C3000i(this.f8356a.get(), this.f8357b.get(), this.f8358c.get());
    }
}
