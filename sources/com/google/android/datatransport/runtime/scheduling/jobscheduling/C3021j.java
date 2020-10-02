package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import com.google.android.datatransport.runtime.backends.C2997g;
import com.google.android.datatransport.runtime.synchronization.C3031a;
import p093e.p101c.p102a.p103a.p104i.C3406l;

/* renamed from: com.google.android.datatransport.runtime.scheduling.jobscheduling.j */
/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
final /* synthetic */ class C3021j implements C3031a.C3032a {

    /* renamed from: a */
    private final C3024m f8396a;

    /* renamed from: b */
    private final C2997g f8397b;

    /* renamed from: c */
    private final Iterable f8398c;

    /* renamed from: d */
    private final C3406l f8399d;

    /* renamed from: e */
    private final int f8400e;

    private C3021j(C3024m mVar, C2997g gVar, Iterable iterable, C3406l lVar, int i) {
        this.f8396a = mVar;
        this.f8397b = gVar;
        this.f8398c = iterable;
        this.f8399d = lVar;
        this.f8400e = i;
    }

    /* renamed from: a */
    public static C3031a.C3032a m9926a(C3024m mVar, C2997g gVar, Iterable iterable, C3406l lVar, int i) {
        return new C3021j(mVar, gVar, iterable, lVar, i);
    }

    public Object execute() {
        return C3024m.m9930a(this.f8396a, this.f8397b, this.f8398c, this.f8399d, this.f8400e);
    }
}
