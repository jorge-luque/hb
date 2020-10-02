package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import com.google.android.datatransport.runtime.synchronization.C3031a;
import java.util.concurrent.Executor;
import p093e.p101c.p102a.p103a.p104i.p107v.p108j.C3435c;
import p188f.p189a.C5913b;
import p193h.p194a.C5925a;

/* renamed from: com.google.android.datatransport.runtime.scheduling.jobscheduling.r */
/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
public final class C3029r implements C5913b<C3028q> {

    /* renamed from: a */
    private final C5925a<Executor> f8425a;

    /* renamed from: b */
    private final C5925a<C3435c> f8426b;

    /* renamed from: c */
    private final C5925a<C3030s> f8427c;

    /* renamed from: d */
    private final C5925a<C3031a> f8428d;

    public C3029r(C5925a<Executor> aVar, C5925a<C3435c> aVar2, C5925a<C3030s> aVar3, C5925a<C3031a> aVar4) {
        this.f8425a = aVar;
        this.f8426b = aVar2;
        this.f8427c = aVar3;
        this.f8428d = aVar4;
    }

    /* renamed from: a */
    public static C3029r m9942a(C5925a<Executor> aVar, C5925a<C3435c> aVar2, C5925a<C3030s> aVar3, C5925a<C3031a> aVar4) {
        return new C3029r(aVar, aVar2, aVar3, aVar4);
    }

    public C3028q get() {
        return new C3028q(this.f8425a.get(), this.f8426b.get(), this.f8427c.get(), this.f8428d.get());
    }
}
