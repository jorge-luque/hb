package com.google.firebase.messaging;

import android.content.Context;
import android.content.SharedPreferences;
import java.lang.ref.WeakReference;
import java.util.concurrent.Executor;

/* renamed from: com.google.firebase.messaging.a0 */
/* compiled from: com.google.firebase:firebase-messaging@@20.1.7 */
final class C3800a0 {

    /* renamed from: d */
    private static WeakReference<C3800a0> f10506d;

    /* renamed from: a */
    private final SharedPreferences f10507a;

    /* renamed from: b */
    private C3826z f10508b;

    /* renamed from: c */
    private final Executor f10509c;

    private C3800a0(SharedPreferences sharedPreferences, Executor executor) {
        this.f10509c = executor;
        this.f10507a = sharedPreferences;
    }

    /* renamed from: a */
    public static synchronized C3800a0 m12842a(Context context, Executor executor) {
        C3800a0 a0Var;
        synchronized (C3800a0.class) {
            a0Var = null;
            if (f10506d != null) {
                a0Var = (C3800a0) f10506d.get();
            }
            if (a0Var == null) {
                a0Var = new C3800a0(context.getSharedPreferences("com.google.android.gms.appid", 0), executor);
                a0Var.m12843b();
                f10506d = new WeakReference<>(a0Var);
            }
        }
        return a0Var;
    }

    /* renamed from: b */
    private final synchronized void m12843b() {
        this.f10508b = C3826z.m12931a(this.f10507a, "topic_operation_queue", ",", this.f10509c);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final synchronized C3802b0 mo27486a() {
        return C3802b0.m12846a(this.f10508b.mo27530a());
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final synchronized boolean mo27487a(C3802b0 b0Var) {
        return this.f10508b.mo27531a((Object) b0Var.mo27490c());
    }
}
