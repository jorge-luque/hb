package com.chartboost.sdk.impl;

import com.chartboost.sdk.Libraries.CBLogging;
import java.lang.ref.WeakReference;

/* renamed from: com.chartboost.sdk.impl.s */
public class C2208s extends C2221w {

    /* renamed from: e */
    private WeakReference<C2202r> f7449e;

    public C2208s(WeakReference<C2202r> weakReference, double d) {
        super(d);
        this.f7449e = weakReference;
    }

    /* renamed from: a */
    public void mo9510a() {
        WeakReference<C2202r> weakReference = this.f7449e;
        if (weakReference != null) {
            C2202r rVar = (C2202r) weakReference.get();
            if (rVar != null) {
                rVar.mo9006a();
            } else {
                CBLogging.m8152a("BannerRefreshTimer", "Refresh callback is disposed");
            }
        }
    }

    /* renamed from: g */
    public void mo9511g() {
        WeakReference<C2202r> weakReference = this.f7449e;
        if (weakReference != null) {
            weakReference.clear();
            this.f7449e = null;
        }
        super.mo9511g();
    }
}
