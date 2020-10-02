package com.applovin.impl.adview.p034a.p035a;

import com.applovin.adview.AppLovinAdView;
import com.applovin.adview.AppLovinFullscreenActivity;
import com.applovin.impl.adview.C1578l;
import com.applovin.impl.sdk.C1941j;
import com.applovin.impl.sdk.p049ad.C1827g;

/* renamed from: com.applovin.impl.adview.a.a.b */
public class C1518b extends C1517a {
    public C1518b(C1827g gVar, AppLovinFullscreenActivity appLovinFullscreenActivity, C1941j jVar) {
        super(gVar, appLovinFullscreenActivity, jVar);
    }

    /* renamed from: a */
    public void mo7298a(C1578l lVar, AppLovinAdView appLovinAdView) {
        this.f4780d.addView(appLovinAdView);
        if (lVar != null) {
            mo7297a(this.f4779c.mo8252af(), (this.f4779c.mo8256aj() ? 3 : 5) | 48, lVar);
        }
        this.f4778b.setContentView(this.f4780d);
    }
}
