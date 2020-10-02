package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import android.content.Context;
import com.google.android.datatransport.runtime.backends.C2994e;
import com.google.android.datatransport.runtime.synchronization.C3031a;
import java.util.concurrent.Executor;
import p093e.p101c.p102a.p103a.p104i.p107v.p108j.C3435c;
import p093e.p101c.p102a.p103a.p104i.p109w.C3469a;
import p188f.p189a.C5913b;
import p193h.p194a.C5925a;

/* renamed from: com.google.android.datatransport.runtime.scheduling.jobscheduling.n */
/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
public final class C3025n implements C5913b<C3024m> {

    /* renamed from: a */
    private final C5925a<Context> f8412a;

    /* renamed from: b */
    private final C5925a<C2994e> f8413b;

    /* renamed from: c */
    private final C5925a<C3435c> f8414c;

    /* renamed from: d */
    private final C5925a<C3030s> f8415d;

    /* renamed from: e */
    private final C5925a<Executor> f8416e;

    /* renamed from: f */
    private final C5925a<C3031a> f8417f;

    /* renamed from: g */
    private final C5925a<C3469a> f8418g;

    public C3025n(C5925a<Context> aVar, C5925a<C2994e> aVar2, C5925a<C3435c> aVar3, C5925a<C3030s> aVar4, C5925a<Executor> aVar5, C5925a<C3031a> aVar6, C5925a<C3469a> aVar7) {
        this.f8412a = aVar;
        this.f8413b = aVar2;
        this.f8414c = aVar3;
        this.f8415d = aVar4;
        this.f8416e = aVar5;
        this.f8417f = aVar6;
        this.f8418g = aVar7;
    }

    /* renamed from: a */
    public static C3025n m9936a(C5925a<Context> aVar, C5925a<C2994e> aVar2, C5925a<C3435c> aVar3, C5925a<C3030s> aVar4, C5925a<Executor> aVar5, C5925a<C3031a> aVar6, C5925a<C3469a> aVar7) {
        return new C3025n(aVar, aVar2, aVar3, aVar4, aVar5, aVar6, aVar7);
    }

    public C3024m get() {
        return new C3024m(this.f8412a.get(), this.f8413b.get(), this.f8414c.get(), this.f8415d.get(), this.f8416e.get(), this.f8417f.get(), this.f8418g.get());
    }
}
