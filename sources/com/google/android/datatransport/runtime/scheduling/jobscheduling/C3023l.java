package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import com.google.android.datatransport.runtime.synchronization.C3031a;
import p093e.p101c.p102a.p103a.p104i.C3406l;

/* renamed from: com.google.android.datatransport.runtime.scheduling.jobscheduling.l */
/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
final /* synthetic */ class C3023l implements C3031a.C3032a {

    /* renamed from: a */
    private final C3024m f8402a;

    /* renamed from: b */
    private final C3406l f8403b;

    /* renamed from: c */
    private final int f8404c;

    private C3023l(C3024m mVar, C3406l lVar, int i) {
        this.f8402a = mVar;
        this.f8403b = lVar;
        this.f8404c = i;
    }

    /* renamed from: a */
    public static C3031a.C3032a m9928a(C3024m mVar, C3406l lVar, int i) {
        return new C3023l(mVar, lVar, i);
    }

    public Object execute() {
        return this.f8402a.f8408d.mo12974a(this.f8403b, this.f8404c + 1);
    }
}
