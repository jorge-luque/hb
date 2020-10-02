package com.applovin.impl.sdk.p052d;

import com.applovin.impl.sdk.C1941j;

/* renamed from: com.applovin.impl.sdk.d.ad */
public class C1871ad extends C1864a {

    /* renamed from: a */
    private final Runnable f6227a;

    public C1871ad(C1941j jVar, Runnable runnable) {
        this(jVar, false, runnable);
    }

    public C1871ad(C1941j jVar, boolean z, Runnable runnable) {
        super("TaskRunnable", jVar, z);
        this.f6227a = runnable;
    }

    public void run() {
        this.f6227a.run();
    }
}
