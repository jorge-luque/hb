package com.applovin.impl.sdk;

import com.applovin.impl.sdk.p049ad.C1835j;
import java.util.LinkedList;
import java.util.Queue;

/* renamed from: com.applovin.impl.sdk.u */
class C1983u {

    /* renamed from: a */
    private int f6638a;

    /* renamed from: b */
    private final Queue<C1835j> f6639b = new LinkedList();

    /* renamed from: c */
    private final Object f6640c = new Object();

    C1983u(int i) {
        mo8755a(i);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public int mo8754a() {
        int size;
        synchronized (this.f6640c) {
            size = this.f6639b.size();
        }
        return size;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo8755a(int i) {
        if (i > 25) {
            i = 25;
        }
        this.f6638a = i;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo8756a(C1835j jVar) {
        synchronized (this.f6640c) {
            if (mo8754a() <= 25) {
                this.f6639b.offer(jVar);
            } else {
                C1977q.m7751i("AppLovinSdk", "Maximum queue capacity reached - discarding ad...");
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public int mo8757b() {
        return this.f6638a;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public boolean mo8758c() {
        boolean z;
        synchronized (this.f6640c) {
            z = mo8754a() >= this.f6638a;
        }
        return z;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public boolean mo8759d() {
        boolean z;
        synchronized (this.f6640c) {
            z = mo8754a() == 0;
        }
        return z;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public C1835j mo8760e() {
        C1835j poll;
        try {
            synchronized (this.f6640c) {
                poll = !mo8759d() ? this.f6639b.poll() : null;
            }
            return poll;
        } catch (Exception unused) {
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public C1835j mo8761f() {
        C1835j peek;
        synchronized (this.f6640c) {
            peek = this.f6639b.peek();
        }
        return peek;
    }
}
