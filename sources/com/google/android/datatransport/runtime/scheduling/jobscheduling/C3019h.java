package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import p093e.p101c.p102a.p103a.p104i.C3406l;

/* renamed from: com.google.android.datatransport.runtime.scheduling.jobscheduling.h */
/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
final /* synthetic */ class C3019h implements Runnable {

    /* renamed from: a */
    private final C3024m f8390a;

    /* renamed from: b */
    private final C3406l f8391b;

    /* renamed from: c */
    private final int f8392c;

    /* renamed from: d */
    private final Runnable f8393d;

    private C3019h(C3024m mVar, C3406l lVar, int i, Runnable runnable) {
        this.f8390a = mVar;
        this.f8391b = lVar;
        this.f8392c = i;
        this.f8393d = runnable;
    }

    /* renamed from: a */
    public static Runnable m9924a(C3024m mVar, C3406l lVar, int i, Runnable runnable) {
        return new C3019h(mVar, lVar, i, runnable);
    }

    public void run() {
        C3024m.m9932a(this.f8390a, this.f8391b, this.f8392c, this.f8393d);
    }
}
