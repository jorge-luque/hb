package com.chartboost.sdk.impl;

import android.os.Handler;
import com.chartboost.sdk.Libraries.C2082i;
import com.chartboost.sdk.Libraries.CBLogging;
import java.util.concurrent.Executor;

/* renamed from: com.chartboost.sdk.impl.v0 */
public class C2218v0 {

    /* renamed from: a */
    private final Executor f7470a;

    /* renamed from: b */
    private final Executor f7471b;

    /* renamed from: c */
    private final C2120a1 f7472c;

    /* renamed from: d */
    private final C2222w0 f7473d;

    /* renamed from: e */
    private final C2082i f7474e;

    /* renamed from: f */
    private final Handler f7475f;

    public C2218v0(Executor executor, C2120a1 a1Var, C2222w0 w0Var, C2082i iVar, Handler handler, Executor executor2) {
        this.f7470a = executor2;
        this.f7471b = executor;
        this.f7472c = a1Var;
        this.f7473d = w0Var;
        this.f7474e = iVar;
        this.f7475f = handler;
    }

    /* renamed from: a */
    public <T> void mo9524a(C2203r0<T> r0Var) {
        CBLogging.m8158d("CBRequest", "Execute request: " + r0Var.f7433b);
        this.f7470a.execute(new C2237z0(this.f7471b, this.f7472c, this.f7473d, this.f7474e, this.f7475f, r0Var));
    }
}
