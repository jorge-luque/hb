package com.google.firebase.remoteconfig.internal;

import java.util.concurrent.Executor;

/* renamed from: com.google.firebase.remoteconfig.internal.d */
/* compiled from: com.google.firebase:firebase-config@@19.1.4 */
final /* synthetic */ class C3841d implements Executor {

    /* renamed from: a */
    private static final C3841d f10612a = new C3841d();

    private C3841d() {
    }

    /* renamed from: a */
    public static Executor m12988a() {
        return f10612a;
    }

    public void execute(Runnable runnable) {
        runnable.run();
    }
}
