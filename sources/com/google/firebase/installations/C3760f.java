package com.google.firebase.installations;

/* renamed from: com.google.firebase.installations.f */
/* compiled from: com.google.firebase:firebase-installations@@16.3.0 */
final /* synthetic */ class C3760f implements Runnable {

    /* renamed from: a */
    private final C3761g f10420a;

    /* renamed from: b */
    private final boolean f10421b;

    private C3760f(C3761g gVar, boolean z) {
        this.f10420a = gVar;
        this.f10421b = z;
    }

    /* renamed from: a */
    public static Runnable m12669a(C3761g gVar, boolean z) {
        return new C3760f(gVar, z);
    }

    public void run() {
        this.f10420a.m12676b(this.f10421b);
    }
}
