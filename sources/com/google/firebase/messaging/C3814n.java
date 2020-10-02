package com.google.firebase.messaging;

import com.google.android.gms.common.util.concurrent.NamedThreadFactory;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* renamed from: com.google.firebase.messaging.n */
/* compiled from: com.google.firebase:firebase-messaging@@20.1.7 */
final class C3814n {
    /* renamed from: a */
    static Executor m12884a() {
        return m12885a("Firebase-Messaging-Rpc-Task");
    }

    /* renamed from: b */
    static Executor m12886b() {
        return m12885a("Firebase-Messaging-Trigger-Topics-Io");
    }

    /* renamed from: a */
    private static Executor m12885a(String str) {
        return new ThreadPoolExecutor(0, 1, 30, TimeUnit.SECONDS, new LinkedBlockingQueue(), new NamedThreadFactory(str));
    }
}
