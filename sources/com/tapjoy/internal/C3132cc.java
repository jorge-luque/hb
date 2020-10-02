package com.tapjoy.internal;

import javax.annotation.Nullable;

/* renamed from: com.tapjoy.internal.cc */
public final class C3132cc implements Runnable {

    /* renamed from: a */
    private final C3131ca f8720a;
    @Nullable

    /* renamed from: b */
    private final C4935cf f8721b;

    protected C3132cc(C3131ca caVar, @Nullable C4935cf cfVar) {
        this.f8720a = caVar;
        this.f8721b = cfVar;
    }

    public final void run() {
        try {
            Object f = this.f8720a.mo18512f();
            C4935cf cfVar = this.f8721b;
            if (cfVar != null && !(cfVar instanceof C4936cg)) {
                cfVar.mo18560a(this.f8720a, f);
            }
        } catch (Throwable unused) {
            C4935cf cfVar2 = this.f8721b;
            if (cfVar2 != null && !(cfVar2 instanceof C4936cg)) {
                cfVar2.mo18559a(this.f8720a);
            }
        }
    }
}
