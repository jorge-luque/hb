package com.google.android.datatransport.runtime.scheduling.jobscheduling;

/* renamed from: com.google.android.datatransport.runtime.scheduling.jobscheduling.o */
/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
final /* synthetic */ class C3026o implements Runnable {

    /* renamed from: a */
    private final C3028q f8419a;

    private C3026o(C3028q qVar) {
        this.f8419a = qVar;
    }

    /* renamed from: a */
    public static Runnable m9937a(C3028q qVar) {
        return new C3026o(qVar);
    }

    public void run() {
        this.f8419a.f8424d.mo13006a(C3027p.m9938a(this.f8419a));
    }
}
