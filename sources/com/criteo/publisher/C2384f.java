package com.criteo.publisher;

import com.criteo.publisher.model.AdUnit;
import com.criteo.publisher.model.C2456q;
import com.criteo.publisher.model.C2459r;
import com.criteo.publisher.model.C2465w;
import com.criteo.publisher.model.C2467y;
import com.criteo.publisher.p054a0.C2321a;
import com.criteo.publisher.p060s.C2508a;
import com.criteo.publisher.p063v.C2570a;
import com.criteo.publisher.p068z.C2593c;

/* renamed from: com.criteo.publisher.f */
public class C2384f {

    /* renamed from: a */
    private final CriteoInterstitialAdListener f7793a;

    /* renamed from: b */
    private final CriteoInterstitialAdDisplayListener f7794b;

    /* renamed from: c */
    private final C2467y f7795c;

    /* renamed from: d */
    private final C2456q f7796d;

    /* renamed from: e */
    private final Criteo f7797e;

    /* renamed from: f */
    private final C2570a f7798f;

    /* renamed from: g */
    private final C2508a f7799g = C2387i.m9085U().mo10260M();

    public C2384f(CriteoInterstitialAdListener criteoInterstitialAdListener, CriteoInterstitialAdDisplayListener criteoInterstitialAdDisplayListener, C2467y yVar, C2570a aVar, Criteo criteo) {
        this.f7793a = criteoInterstitialAdListener;
        this.f7794b = criteoInterstitialAdDisplayListener;
        this.f7795c = yVar;
        this.f7798f = aVar;
        this.f7797e = criteo;
        this.f7796d = criteo.mo10079b();
    }

    /* renamed from: a */
    public boolean mo10246a() {
        return this.f7795c.mo10424e();
    }

    /* renamed from: b */
    public void mo10247b() {
        if (mo10246a()) {
            this.f7798f.mo10297a(this.f7795c.mo10423d(), this.f7793a);
            CriteoInterstitialAdListener criteoInterstitialAdListener = this.f7793a;
            if (criteoInterstitialAdListener != null) {
                criteoInterstitialAdListener.onAdOpened();
            }
            this.f7795c.mo10426g();
        }
    }

    /* renamed from: a */
    public void mo10244a(AdUnit adUnit) {
        if (!this.f7798f.mo10298a()) {
            mo10243a(C2385g.INVALID);
        } else if (!this.f7795c.mo10425f()) {
            this.f7795c.mo10421b();
            C2465w a = this.f7797e.mo10078a(adUnit);
            if (a == null) {
                mo10243a(C2385g.INVALID);
                this.f7795c.mo10418a();
                return;
            }
            mo10243a(C2385g.VALID);
            mo10245a(a.mo10406c());
        }
    }

    /* renamed from: a */
    public void mo10242a(BidToken bidToken) {
        C2459r a = this.f7797e.mo10077a(bidToken, C2321a.CRITEO_INTERSTITIAL);
        if (a == null) {
            mo10243a(C2385g.INVALID);
            return;
        }
        mo10243a(C2385g.VALID);
        mo10245a(a.mo10391b());
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo10243a(C2385g gVar) {
        this.f7799g.mo10520a(new C2593c(this.f7793a, gVar));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo10245a(String str) {
        this.f7795c.mo10420a(str, this.f7796d, this.f7794b);
    }
}
