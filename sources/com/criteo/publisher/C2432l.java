package com.criteo.publisher;

import com.criteo.publisher.model.AdUnit;
import com.criteo.publisher.model.C2439e;
import com.criteo.publisher.model.C2459r;
import com.criteo.publisher.model.C2465w;
import com.criteo.publisher.model.InterstitialAdUnit;
import com.criteo.publisher.model.p055z.C2494s;
import com.criteo.publisher.p054a0.C2321a;
import com.criteo.publisher.p063v.C2570a;

/* renamed from: com.criteo.publisher.l */
public class C2432l {

    /* renamed from: a */
    private final C2376b f7840a;

    /* renamed from: b */
    private final C2495n f7841b;

    /* renamed from: c */
    private final C2379c f7842c;

    /* renamed from: d */
    private final C2570a f7843d;

    public C2432l(C2376b bVar, C2495n nVar, C2379c cVar, C2570a aVar) {
        this.f7840a = bVar;
        this.f7841b = nVar;
        this.f7842c = cVar;
        this.f7843d = aVar;
    }

    /* renamed from: a */
    public BidResponse mo10299a(AdUnit adUnit) {
        C2439e eVar;
        if ((adUnit instanceof InterstitialAdUnit) && !this.f7843d.mo10298a()) {
            return new BidResponse();
        }
        C2465w a = this.f7840a.mo10232a(adUnit);
        if (a == null || adUnit == null) {
            return new BidResponse();
        }
        if (a.mo10410f() != null) {
            eVar = new C2494s(a.mo10410f(), a, this.f7842c);
        } else {
            eVar = new C2459r(a.mo10406c(), a, this.f7842c);
        }
        return new BidResponse(a.mo10405b().doubleValue(), this.f7841b.mo10495a(eVar, adUnit), true);
    }

    /* renamed from: a */
    public C2459r mo10300a(BidToken bidToken, C2321a aVar) {
        C2439e a = this.f7841b.mo10496a(bidToken, aVar);
        if (!(a instanceof C2459r)) {
            return null;
        }
        return (C2459r) a;
    }

    /* renamed from: a */
    public C2494s mo10301a(BidToken bidToken) {
        C2439e a = this.f7841b.mo10496a(bidToken, C2321a.CRITEO_CUSTOM_NATIVE);
        if (!(a instanceof C2494s)) {
            return null;
        }
        return (C2494s) a;
    }
}
