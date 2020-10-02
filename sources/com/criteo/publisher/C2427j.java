package com.criteo.publisher;

import android.content.Context;
import com.criteo.publisher.model.AdUnit;
import com.criteo.publisher.model.C2455p;
import com.criteo.publisher.model.C2456q;
import com.criteo.publisher.model.C2459r;
import com.criteo.publisher.model.C2465w;
import com.criteo.publisher.p054a0.C2321a;
import com.criteo.publisher.p054a0.C2332j;
import com.criteo.publisher.p056o.C2497b;
import com.criteo.publisher.p060s.C2508a;
import com.criteo.publisher.p063v.C2570a;
import java.util.concurrent.Future;

/* renamed from: com.criteo.publisher.j */
public class C2427j extends Criteo {

    /* renamed from: com.criteo.publisher.j$b */
    private static class C2429b extends C2456q {
        /* renamed from: a */
        public Future<String> mo10295a() {
            return C2332j.m8977b("");
        }

        /* renamed from: b */
        public void mo10296b() {
        }

        private C2429b() {
            super((Context) null, new C2508a());
        }
    }

    /* renamed from: com.criteo.publisher.j$c */
    private static class C2430c extends C2570a {
        C2430c() {
            super((Context) null, (C2497b) null);
        }

        /* renamed from: a */
        public void mo10297a(String str, CriteoInterstitialAdListener criteoInterstitialAdListener) {
        }

        /* renamed from: a */
        public boolean mo10298a() {
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public C2455p mo10076a() {
        return new C2455p();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public C2459r mo10077a(BidToken bidToken, C2321a aVar) {
        return null;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public C2465w mo10078a(AdUnit adUnit) {
        return null;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public C2456q mo10079b() {
        return new C2429b();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public C2570a mo10080c() {
        return new C2430c();
    }

    public C2380d createBannerController(CriteoBannerView criteoBannerView) {
        return new C2380d(criteoBannerView, this, C2387i.m9085U().mo10262O(), C2387i.m9085U().mo10260M());
    }

    public BidResponse getBidResponse(AdUnit adUnit) {
        return new BidResponse();
    }

    public void setBidsForAdUnit(Object obj, AdUnit adUnit) {
    }

    public void setMopubConsent(String str) {
    }

    public void setUsPrivacyOptOut(boolean z) {
    }
}
