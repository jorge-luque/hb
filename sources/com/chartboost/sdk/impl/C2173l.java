package com.chartboost.sdk.impl;

import com.chartboost.sdk.Libraries.C2082i;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: com.chartboost.sdk.impl.l */
class C2173l implements Comparable<C2173l> {

    /* renamed from: a */
    private final C2082i f7316a;

    /* renamed from: b */
    final int f7317b;

    /* renamed from: c */
    final String f7318c;

    /* renamed from: d */
    final String f7319d;

    /* renamed from: e */
    final String f7320e;

    /* renamed from: f */
    final AtomicInteger f7321f;

    /* renamed from: g */
    private final AtomicReference<C2167j> f7322g;

    /* renamed from: h */
    private final long f7323h;

    /* renamed from: i */
    final AtomicInteger f7324i;

    C2173l(C2082i iVar, int i, String str, String str2, String str3, AtomicInteger atomicInteger, AtomicReference<C2167j> atomicReference, long j, AtomicInteger atomicInteger2) {
        this.f7316a = iVar;
        this.f7317b = i;
        this.f7318c = str;
        this.f7319d = str2;
        this.f7320e = str3;
        this.f7321f = atomicInteger;
        this.f7322g = atomicReference;
        this.f7323h = j;
        this.f7324i = atomicInteger2;
        atomicInteger.incrementAndGet();
    }

    /* renamed from: a */
    public int compareTo(C2173l lVar) {
        return this.f7317b - lVar.f7317b;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo9391a(Executor executor, boolean z) {
        C2167j andSet;
        if ((this.f7321f.decrementAndGet() == 0 || !z) && (andSet = this.f7322g.getAndSet((Object) null)) != null) {
            executor.execute(new C2170k(andSet, z, (int) TimeUnit.NANOSECONDS.toMillis(this.f7316a.mo9111b() - this.f7323h), this.f7324i.get()));
        }
    }
}
