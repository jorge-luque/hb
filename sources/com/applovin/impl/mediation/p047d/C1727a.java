package com.applovin.impl.mediation.p047d;

import com.applovin.impl.sdk.C1941j;
import com.applovin.impl.sdk.utils.C1994j;
import com.applovin.mediation.MaxAd;
import com.applovin.mediation.MaxAdListener;
import com.applovin.mediation.MaxAdViewAdListener;
import com.applovin.mediation.MaxReward;
import com.applovin.mediation.MaxRewardedAdListener;

/* renamed from: com.applovin.impl.mediation.d.a */
public class C1727a implements MaxAdListener, MaxAdViewAdListener, MaxRewardedAdListener {

    /* renamed from: a */
    private final C1941j f5366a;

    /* renamed from: b */
    private final MaxAdListener f5367b;

    public C1727a(MaxAdListener maxAdListener, C1941j jVar) {
        this.f5366a = jVar;
        this.f5367b = maxAdListener;
    }

    public void onAdClicked(MaxAd maxAd) {
        C1994j.m7930d(this.f5367b, maxAd);
    }

    public void onAdCollapsed(MaxAd maxAd) {
        C1994j.m7934h(this.f5367b, maxAd);
    }

    public void onAdDisplayFailed(MaxAd maxAd, int i) {
        C1994j.m7910a(this.f5367b, maxAd, i);
    }

    public void onAdDisplayed(MaxAd maxAd) {
        C1994j.m7924b(this.f5367b, maxAd);
    }

    public void onAdExpanded(MaxAd maxAd) {
        C1994j.m7933g(this.f5367b, maxAd);
    }

    public void onAdHidden(MaxAd maxAd) {
        C1994j.m7928c(this.f5367b, maxAd);
    }

    public void onAdLoadFailed(String str, int i) {
        C1994j.m7912a(this.f5367b, str, i);
    }

    public void onAdLoaded(MaxAd maxAd) {
        C1994j.m7909a(this.f5367b, maxAd);
    }

    public void onRewardedVideoCompleted(MaxAd maxAd) {
        C1994j.m7932f(this.f5367b, maxAd);
    }

    public void onRewardedVideoStarted(MaxAd maxAd) {
        C1994j.m7931e(this.f5367b, maxAd);
    }

    public void onUserRewarded(MaxAd maxAd, MaxReward maxReward) {
        C1994j.m7911a(this.f5367b, maxAd, maxReward);
    }
}
