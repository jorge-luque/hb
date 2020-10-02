package com.chartboost.sdk.impl;

import com.chartboost.sdk.C2102d;
import com.chartboost.sdk.C2239j;
import com.chartboost.sdk.Model.C2088c;
import com.chartboost.sdk.Model.C2089d;
import com.chartboost.sdk.Model.CBError;
import com.chartboost.sdk.impl.C2143g;

/* renamed from: com.chartboost.sdk.impl.f */
class C2139f implements C2089d {

    /* renamed from: a */
    private final C2143g f7160a;

    /* renamed from: b */
    private final C2151h f7161b;

    C2139f(C2143g gVar, C2151h hVar) {
        this.f7160a = gVar;
        this.f7161b = hVar;
    }

    /* renamed from: d */
    private boolean m8495d(C2088c cVar) {
        return m8496e(cVar);
    }

    /* renamed from: e */
    private boolean m8496e(C2088c cVar) {
        return (this.f7160a.f7183p.f7101a != 0 || cVar.f6921a == 1 || cVar.f6938r.f6896b == 1) ? false : true;
    }

    /* renamed from: f */
    private void m8497f(C2088c cVar) {
        if (m8495d(cVar)) {
            mo9150c(cVar);
        }
    }

    /* renamed from: a */
    public void mo9147a(C2088c cVar) {
        C2143g gVar = this.f7160a;
        gVar.getClass();
        C2151h hVar = this.f7161b;
        this.f7160a.f7168a.execute(new C2143g.C2145b(7, hVar.f7222b, hVar, (CBError.CBImpressionError) null));
    }

    /* renamed from: b */
    public void mo9149b(C2088c cVar) {
        cVar.f6922b = 1;
        if (this.f7160a.f7183p.mo9276f(this.f7161b.f7222b)) {
            this.f7160a.f7179l.mo9193b(cVar);
            m8497f(cVar);
            return;
        }
        C2143g gVar = this.f7160a;
        gVar.getClass();
        C2151h hVar = this.f7161b;
        this.f7160a.f7168a.execute(new C2143g.C2145b(7, hVar.f7222b, hVar, (CBError.CBImpressionError) null));
    }

    /* renamed from: c */
    public void mo9150c(C2088c cVar) {
        cVar.f6946z = true;
        C2143g gVar = this.f7160a;
        gVar.getClass();
        C2151h hVar = this.f7161b;
        this.f7160a.f7168a.execute(new C2143g.C2145b(5, hVar.f7222b, hVar, (CBError.CBImpressionError) null));
    }

    /* renamed from: a */
    public void mo9148a(C2088c cVar, CBError.CBImpressionError cBImpressionError) {
        C2102d dVar = this.f7160a.f7179l;
        dVar.getClass();
        C2102d.C2106d dVar2 = new C2102d.C2106d(11);
        dVar2.f7056c = cVar;
        C2239j.m8896b((Runnable) dVar2);
        C2143g gVar = this.f7160a;
        gVar.getClass();
        C2151h hVar = this.f7161b;
        this.f7160a.f7168a.execute(new C2143g.C2145b(6, hVar.f7222b, hVar, cBImpressionError));
    }
}
