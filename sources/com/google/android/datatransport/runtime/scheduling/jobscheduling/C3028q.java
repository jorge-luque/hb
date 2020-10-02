package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import com.google.android.datatransport.runtime.synchronization.C3031a;
import java.util.concurrent.Executor;
import p093e.p101c.p102a.p103a.p104i.C3406l;
import p093e.p101c.p102a.p103a.p104i.p107v.p108j.C3435c;

/* renamed from: com.google.android.datatransport.runtime.scheduling.jobscheduling.q */
/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
public class C3028q {

    /* renamed from: a */
    private final Executor f8421a;

    /* renamed from: b */
    private final C3435c f8422b;

    /* renamed from: c */
    private final C3030s f8423c;

    /* renamed from: d */
    private final C3031a f8424d;

    C3028q(Executor executor, C3435c cVar, C3030s sVar, C3031a aVar) {
        this.f8421a = executor;
        this.f8422b = cVar;
        this.f8423c = sVar;
        this.f8424d = aVar;
    }

    /* renamed from: a */
    public void mo13005a() {
        this.f8421a.execute(C3026o.m9937a(this));
    }

    /* renamed from: a */
    static /* synthetic */ Object m9939a(C3028q qVar) {
        for (C3406l a : qVar.f8422b.mo19240I()) {
            qVar.f8423c.mo12974a(a, 1);
        }
        return null;
    }
}
