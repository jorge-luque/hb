package com.criteo.publisher;

import android.app.Application;
import android.util.Log;
import com.criteo.publisher.model.AdUnit;
import com.criteo.publisher.model.C2455p;
import com.criteo.publisher.model.C2456q;
import com.criteo.publisher.model.C2459r;
import com.criteo.publisher.model.C2465w;
import com.criteo.publisher.p054a0.C2321a;
import com.criteo.publisher.p054a0.C2325e;
import com.criteo.publisher.p062u.C2566b;
import com.criteo.publisher.p063v.C2570a;
import com.criteo.publisher.p066y.C2580a;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;

/* renamed from: com.criteo.publisher.e */
final class C2382e extends Criteo {

    /* renamed from: k */
    private static final String f7782k = "e";

    /* renamed from: c */
    private final C2387i f7783c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final C2376b f7784d;

    /* renamed from: e */
    private final C2456q f7785e;

    /* renamed from: f */
    private final C2455p f7786f;

    /* renamed from: g */
    private final C2580a f7787g;

    /* renamed from: h */
    private final C2432l f7788h;

    /* renamed from: i */
    private final C2566b f7789i;

    /* renamed from: j */
    private final C2570a f7790j;

    /* renamed from: com.criteo.publisher.e$a */
    class C2383a extends C2433m {

        /* renamed from: c */
        final /* synthetic */ List f7791c;

        C2383a(List list) {
            this.f7791c = list;
        }

        /* renamed from: a */
        public void mo10204a() {
            C2382e.this.f7784d.mo10235a((List<AdUnit>) this.f7791c);
        }
    }

    C2382e(Application application, List<AdUnit> list, Boolean bool, String str, C2387i iVar) {
        list = list == null ? new ArrayList<>() : list;
        this.f7783c = iVar;
        iVar.mo10286s().mo10154a();
        C2456q r = iVar.mo10285r();
        this.f7785e = r;
        r.mo10296b();
        this.f7786f = iVar.mo10281n();
        this.f7784d = iVar.mo10275h();
        this.f7788h = iVar.mo10290w();
        this.f7789i = iVar.mo10288u();
        this.f7790j = iVar.mo10291x();
        C2580a Q = iVar.mo10264Q();
        this.f7787g = Q;
        if (bool != null) {
            Q.mo10630a(bool.booleanValue());
        }
        if (str != null) {
            this.f7787g.mo10629a(str);
        }
        application.registerActivityLifecycleCallbacks(new C2325e(iVar.mo10272e(), this.f7784d));
        iVar.mo10262O().mo10504a(application);
        iVar.mo10274g().mo10509a();
        m9069a((Executor) iVar.mo10260M(), list);
    }

    /* renamed from: b */
    private BidResponse m9070b(AdUnit adUnit) {
        return this.f7788h.mo10299a(adUnit);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public C2570a mo10080c() {
        return this.f7790j;
    }

    public C2380d createBannerController(CriteoBannerView criteoBannerView) {
        return new C2380d(criteoBannerView, this, this.f7783c.mo10262O(), this.f7783c.mo10260M());
    }

    public BidResponse getBidResponse(AdUnit adUnit) {
        try {
            return m9070b(adUnit);
        } catch (Throwable th) {
            BidResponse bidResponse = new BidResponse();
            Log.e(f7782k, "Internal error while getting Bid Response.", th);
            return bidResponse;
        }
    }

    public void setBidsForAdUnit(Object obj, AdUnit adUnit) {
        try {
            m9068a(obj, adUnit);
        } catch (Throwable th) {
            Log.e(f7782k, "Internal error while setting bids for adUnit.", th);
        }
    }

    public void setMopubConsent(String str) {
        this.f7787g.mo10629a(str);
    }

    public void setUsPrivacyOptOut(boolean z) {
        this.f7787g.mo10630a(z);
    }

    /* renamed from: a */
    private void m9069a(Executor executor, List<AdUnit> list) {
        executor.execute(new C2383a(list));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public C2456q mo10079b() {
        return this.f7785e;
    }

    /* renamed from: a */
    private void m9068a(Object obj, AdUnit adUnit) {
        this.f7789i.mo10607a(obj, adUnit);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public C2465w mo10078a(AdUnit adUnit) {
        return this.f7784d.mo10232a(adUnit);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public C2459r mo10077a(BidToken bidToken, C2321a aVar) {
        return this.f7788h.mo10300a(bidToken, aVar);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public C2455p mo10076a() {
        return this.f7786f;
    }
}
