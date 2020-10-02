package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import com.google.android.datatransport.runtime.synchronization.C3031a;
import p093e.p101c.p102a.p103a.p104i.C3406l;

/* renamed from: com.google.android.datatransport.runtime.scheduling.jobscheduling.i */
/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
final /* synthetic */ class C3020i implements C3031a.C3032a {

    /* renamed from: a */
    private final C3024m f8394a;

    /* renamed from: b */
    private final C3406l f8395b;

    private C3020i(C3024m mVar, C3406l lVar) {
        this.f8394a = mVar;
        this.f8395b = lVar;
    }

    /* renamed from: a */
    public static C3031a.C3032a m9925a(C3024m mVar, C3406l lVar) {
        return new C3020i(mVar, lVar);
    }

    public Object execute() {
        return this.f8394a.f8407c.mo19242a(this.f8395b);
    }
}
