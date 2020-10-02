package com.chartboost.sdk.impl;

import java.lang.ref.WeakReference;

/* renamed from: com.chartboost.sdk.impl.u */
public class C2214u extends C2221w {

    /* renamed from: e */
    private WeakReference<C2211t> f7463e;

    public C2214u(WeakReference<C2211t> weakReference, double d) {
        super(d);
        this.f7463e = weakReference;
    }

    /* renamed from: a */
    public void mo9510a() {
        C2211t tVar;
        WeakReference<C2211t> weakReference = this.f7463e;
        if (weakReference != null && (tVar = (C2211t) weakReference.get()) != null) {
            tVar.mo9012b();
        }
    }

    /* renamed from: g */
    public void mo9511g() {
        WeakReference<C2211t> weakReference = this.f7463e;
        if (weakReference != null) {
            weakReference.clear();
            this.f7463e = null;
        }
        super.mo9511g();
    }
}
