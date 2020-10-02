package com.google.firebase.messaging;

import java.util.concurrent.Executor;

/* renamed from: com.google.firebase.messaging.l */
/* compiled from: com.google.firebase:firebase-messaging@@20.1.7 */
final /* synthetic */ class C3812l implements Executor {

    /* renamed from: a */
    static final Executor f10551a = new C3812l();

    private C3812l() {
    }

    public final void execute(Runnable runnable) {
        runnable.run();
    }
}
