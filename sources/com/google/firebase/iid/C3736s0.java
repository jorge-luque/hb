package com.google.firebase.iid;

import com.google.android.gms.common.util.concurrent.NamedThreadFactory;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* renamed from: com.google.firebase.iid.s0 */
/* compiled from: com.google.firebase:firebase-iid@@20.1.7 */
final class C3736s0 {

    /* renamed from: a */
    private static final Executor f10371a = C3734r0.f10369a;

    /* renamed from: a */
    static Executor m12634a() {
        return f10371a;
    }

    /* renamed from: b */
    static ExecutorService m12635b() {
        return new ThreadPoolExecutor(0, 1, 30, TimeUnit.SECONDS, new LinkedBlockingQueue(), new NamedThreadFactory("firebase-iid-executor"));
    }
}
