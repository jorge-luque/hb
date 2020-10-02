package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import com.google.android.datatransport.runtime.synchronization.C3031a;
import p093e.p101c.p102a.p103a.p104i.p107v.p108j.C3435c;

/* renamed from: com.google.android.datatransport.runtime.scheduling.jobscheduling.k */
/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
final /* synthetic */ class C3022k implements C3031a.C3032a {

    /* renamed from: a */
    private final C3435c f8401a;

    private C3022k(C3435c cVar) {
        this.f8401a = cVar;
    }

    /* renamed from: a */
    public static C3031a.C3032a m9927a(C3435c cVar) {
        return new C3022k(cVar);
    }

    public Object execute() {
        return Integer.valueOf(this.f8401a.mo19239E());
    }
}
