package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import com.google.android.datatransport.runtime.synchronization.C3031a;

/* renamed from: com.google.android.datatransport.runtime.scheduling.jobscheduling.p */
/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
final /* synthetic */ class C3027p implements C3031a.C3032a {

    /* renamed from: a */
    private final C3028q f8420a;

    private C3027p(C3028q qVar) {
        this.f8420a = qVar;
    }

    /* renamed from: a */
    public static C3031a.C3032a m9938a(C3028q qVar) {
        return new C3027p(qVar);
    }

    public Object execute() {
        return C3028q.m9939a(this.f8420a);
    }
}
