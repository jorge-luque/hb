package com.criteo.publisher.p061t;

import com.criteo.publisher.p054a0.C2330h;
import java.util.List;

/* renamed from: com.criteo.publisher.t.j */
class C2527j extends C2554u {

    /* renamed from: a */
    private final C2554u f8049a;

    /* renamed from: b */
    private final Object f8050b = new Object();

    /* renamed from: c */
    private final C2330h f8051c;

    C2527j(C2554u uVar, C2330h hVar) {
        this.f8049a = uVar;
        this.f8051c = hVar;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo10579a(C2540m mVar) {
        boolean a;
        synchronized (this.f8050b) {
            if (mo10577a() >= this.f8051c.mo10135h()) {
                this.f8049a.mo10578a(1);
            }
            a = this.f8049a.mo10579a(mVar);
        }
        return a;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public List<C2540m> mo10578a(int i) {
        List<C2540m> a;
        synchronized (this.f8050b) {
            a = this.f8049a.mo10578a(i);
        }
        return a;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public int mo10577a() {
        return this.f8049a.mo10577a();
    }
}
