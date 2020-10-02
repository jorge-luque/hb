package com.applovin.impl.mediation;

import com.applovin.impl.mediation.C1643a;
import com.applovin.impl.mediation.C1705c;
import com.applovin.impl.mediation.p045b.C1699c;
import com.applovin.impl.sdk.C1941j;
import com.applovin.mediation.MaxAd;
import com.applovin.mediation.MaxAdListener;
import com.applovin.sdk.AppLovinSdkUtils;

/* renamed from: com.applovin.impl.mediation.b */
public class C1695b implements C1643a.C1644a, C1705c.C1707a {

    /* renamed from: a */
    private final C1643a f5292a;

    /* renamed from: b */
    private final C1705c f5293b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final MaxAdListener f5294c;

    public C1695b(C1941j jVar, MaxAdListener maxAdListener) {
        this.f5294c = maxAdListener;
        this.f5292a = new C1643a(jVar);
        this.f5293b = new C1705c(jVar, this);
    }

    /* renamed from: a */
    public void mo7626a(final C1699c cVar) {
        AppLovinSdkUtils.runOnUiThreadDelayed(new Runnable() {
            public void run() {
                C1695b.this.f5294c.onAdHidden(cVar);
            }
        }, cVar.mo7798o());
    }

    /* renamed from: a */
    public void mo7760a(MaxAd maxAd) {
        this.f5293b.mo7850a();
        this.f5292a.mo7624a();
    }

    /* renamed from: b */
    public void mo7761b(C1699c cVar) {
        long m = cVar.mo7796m();
        if (m >= 0) {
            this.f5293b.mo7851a(cVar, m);
        }
        if (cVar.mo7797n()) {
            this.f5292a.mo7625a(cVar, this);
        }
    }

    /* renamed from: c */
    public void mo7762c(C1699c cVar) {
        this.f5294c.onAdHidden(cVar);
    }
}
