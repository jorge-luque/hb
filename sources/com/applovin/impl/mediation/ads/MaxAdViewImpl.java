package com.applovin.impl.mediation.ads;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.applovin.impl.mediation.MediationServiceImpl;
import com.applovin.impl.mediation.p045b.C1698b;
import com.applovin.impl.mediation.p047d.C1729c;
import com.applovin.impl.sdk.C1861d;
import com.applovin.impl.sdk.C1941j;
import com.applovin.impl.sdk.C1977q;
import com.applovin.impl.sdk.C2041x;
import com.applovin.impl.sdk.C2042y;
import com.applovin.impl.sdk.p050b.C1840b;
import com.applovin.impl.sdk.p052d.C1871ad;
import com.applovin.impl.sdk.utils.C1985b;
import com.applovin.impl.sdk.utils.C1994j;
import com.applovin.impl.sdk.utils.C2029r;
import com.applovin.impl.sdk.utils.C2030s;
import com.applovin.mediation.MaxAd;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.MaxAdListener;
import com.applovin.mediation.MaxAdViewAdListener;
import com.applovin.mediation.ads.MaxAdView;
import com.applovin.sdk.AppLovinSdkUtils;
import java.util.concurrent.TimeUnit;

public class MaxAdViewImpl extends C1694a implements C1861d.C1863a, C2042y.C2045a {

    /* renamed from: q */
    private static final int[] f5230q = {10, 14};
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final Activity f5231a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final MaxAdView f5232b;

    /* renamed from: c */
    private final View f5233c;

    /* renamed from: d */
    private long f5234d = Long.MAX_VALUE;

    /* renamed from: e */
    private C1698b f5235e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public String f5236f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public final C1679a f5237g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public final C1681c f5238h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public final C1861d f5239i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public final C2041x f5240j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public final C2042y f5241k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public final Object f5242l = new Object();
    /* access modifiers changed from: private */

    /* renamed from: m */
    public C1698b f5243m = null;

    /* renamed from: n */
    private boolean f5244n;

    /* renamed from: o */
    private boolean f5245o;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public boolean f5246p = false;

    /* renamed from: com.applovin.impl.mediation.ads.MaxAdViewImpl$a */
    private class C1679a extends C1680b {
        private C1679a() {
            super();
        }

        public void onAdLoadFailed(String str, int i) {
            C1994j.m7912a(MaxAdViewImpl.this.adListener, str, i);
            MaxAdViewImpl.this.m6389a(i);
        }

        public void onAdLoaded(MaxAd maxAd) {
            if (MaxAdViewImpl.this.f5246p) {
                MaxAdViewImpl maxAdViewImpl = MaxAdViewImpl.this;
                C1977q qVar = maxAdViewImpl.logger;
                String str = maxAdViewImpl.tag;
                qVar.mo8742b(str, "Pre-cache ad with ad unit ID '" + MaxAdViewImpl.this.adUnitId + "' loaded after MaxAdView was destroyed. Destroying the ad.");
                MaxAdViewImpl.this.sdk.mo8605y().destroyAd(maxAd);
            } else if (maxAd instanceof C1698b) {
                C1698b bVar = (C1698b) maxAd;
                bVar.mo7837c(MaxAdViewImpl.this.f5236f);
                MaxAdViewImpl.this.m6400a(bVar);
                if (bVar.mo7790v()) {
                    long w = bVar.mo7791w();
                    C1977q v = MaxAdViewImpl.this.sdk.mo8602v();
                    String str2 = MaxAdViewImpl.this.tag;
                    v.mo8742b(str2, "Scheduling banner ad refresh " + w + " milliseconds from now for '" + MaxAdViewImpl.this.adUnitId + "'...");
                    MaxAdViewImpl.this.f5239i.mo8396a(w);
                }
                C1994j.m7909a(MaxAdViewImpl.this.adListener, maxAd);
            } else {
                MaxAdViewImpl maxAdViewImpl2 = MaxAdViewImpl.this;
                C1977q qVar2 = maxAdViewImpl2.logger;
                String str3 = maxAdViewImpl2.tag;
                qVar2.mo8746e(str3, "Not a MediatedAdViewAd received: " + maxAd);
                onAdLoadFailed(MaxAdViewImpl.this.adUnitId, -5201);
            }
        }
    }

    /* renamed from: com.applovin.impl.mediation.ads.MaxAdViewImpl$b */
    private abstract class C1680b implements MaxAdListener, MaxAdViewAdListener {
        private C1680b() {
        }

        public void onAdClicked(MaxAd maxAd) {
            if (maxAd.equals(MaxAdViewImpl.this.f5243m)) {
                C1994j.m7930d(MaxAdViewImpl.this.adListener, maxAd);
            }
        }

        public void onAdCollapsed(MaxAd maxAd) {
            if (maxAd.equals(MaxAdViewImpl.this.f5243m)) {
                if (MaxAdViewImpl.this.f5243m.mo7792x()) {
                    MaxAdViewImpl.this.startAutoRefresh();
                }
                C1994j.m7934h(MaxAdViewImpl.this.adListener, maxAd);
            }
        }

        public void onAdDisplayFailed(MaxAd maxAd, int i) {
            if (maxAd.equals(MaxAdViewImpl.this.f5243m)) {
                C1994j.m7910a(MaxAdViewImpl.this.adListener, maxAd, i);
            }
        }

        public void onAdDisplayed(MaxAd maxAd) {
            if (maxAd.equals(MaxAdViewImpl.this.f5243m)) {
                C1994j.m7924b(MaxAdViewImpl.this.adListener, maxAd);
            }
        }

        public void onAdExpanded(MaxAd maxAd) {
            if (maxAd.equals(MaxAdViewImpl.this.f5243m)) {
                if (MaxAdViewImpl.this.f5243m.mo7792x()) {
                    MaxAdViewImpl.this.stopAutoRefresh();
                }
                C1994j.m7933g(MaxAdViewImpl.this.adListener, maxAd);
            }
        }

        public void onAdHidden(MaxAd maxAd) {
            if (maxAd.equals(MaxAdViewImpl.this.f5243m)) {
                C1994j.m7928c(MaxAdViewImpl.this.adListener, maxAd);
            }
        }
    }

    /* renamed from: com.applovin.impl.mediation.ads.MaxAdViewImpl$c */
    private class C1681c extends C1680b {
        private C1681c() {
            super();
        }

        public void onAdLoadFailed(String str, int i) {
            MaxAdViewImpl maxAdViewImpl = MaxAdViewImpl.this;
            C1977q qVar = maxAdViewImpl.logger;
            String str2 = maxAdViewImpl.tag;
            qVar.mo8742b(str2, "Failed to pre-cache ad for refresh with error code " + i);
            MaxAdViewImpl.this.m6389a(i);
        }

        public void onAdLoaded(MaxAd maxAd) {
            if (MaxAdViewImpl.this.f5246p) {
                MaxAdViewImpl maxAdViewImpl = MaxAdViewImpl.this;
                C1977q qVar = maxAdViewImpl.logger;
                String str = maxAdViewImpl.tag;
                qVar.mo8742b(str, "Ad with ad unit ID '" + MaxAdViewImpl.this.adUnitId + "' loaded after MaxAdView was destroyed. Destroying the ad.");
                MaxAdViewImpl.this.sdk.mo8605y().destroyAd(maxAd);
                return;
            }
            MaxAdViewImpl maxAdViewImpl2 = MaxAdViewImpl.this;
            maxAdViewImpl2.logger.mo8742b(maxAdViewImpl2.tag, "Successfully pre-cached ad for refresh");
            MaxAdViewImpl.this.m6403a(maxAd);
        }
    }

    public MaxAdViewImpl(String str, MaxAdFormat maxAdFormat, MaxAdView maxAdView, View view, C1941j jVar, Activity activity) {
        super(str, maxAdFormat, "MaxAdView", jVar);
        if (activity != null) {
            this.f5231a = activity;
            this.f5232b = maxAdView;
            this.f5233c = view;
            this.f5237g = new C1679a();
            this.f5238h = new C1681c();
            this.f5239i = new C1861d(jVar, this);
            this.f5240j = new C2041x(maxAdView, jVar);
            this.f5241k = new C2042y(maxAdView, jVar, this);
            C1977q qVar = this.logger;
            String str2 = this.tag;
            qVar.mo8742b(str2, "Created new MaxAdView (" + this + ")");
            return;
        }
        throw new IllegalArgumentException("No activity specified");
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m6388a() {
        C1698b bVar;
        MaxAdView maxAdView = this.f5232b;
        if (maxAdView != null) {
            C1985b.m7817a(maxAdView, this.f5233c);
        }
        this.f5241k.mo8854a();
        synchronized (this.f5242l) {
            bVar = this.f5243m;
        }
        if (bVar != null) {
            this.sdk.mo8571ag().mo8620b(bVar);
            this.sdk.mo8605y().destroyAd(bVar);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m6389a(int i) {
        if (this.sdk.mo8576b(C1840b.f5779q).contains(String.valueOf(i))) {
            C1977q v = this.sdk.mo8602v();
            String str = this.tag;
            v.mo8742b(str, "Ignoring banner ad refresh for error code '" + i + "'...");
            return;
        }
        this.f5244n = true;
        long longValue = ((Long) this.sdk.mo8549a(C1840b.f5778p)).longValue();
        if (longValue >= 0) {
            C1977q v2 = this.sdk.mo8602v();
            String str2 = this.tag;
            v2.mo8742b(str2, "Scheduling failed banner ad refresh " + longValue + " milliseconds from now for '" + this.adUnitId + "'...");
            this.f5239i.mo8396a(longValue);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m6390a(long j) {
        if (C2029r.m8014a(j, ((Long) this.sdk.mo8549a(C1840b.f5788z)).longValue())) {
            C1977q qVar = this.logger;
            String str = this.tag;
            qVar.mo8742b(str, "Undesired flags matched - current: " + Long.toBinaryString(j) + ", undesired: " + Long.toBinaryString(j));
            this.logger.mo8742b(this.tag, "Waiting for refresh timer to manually fire request");
            this.f5244n = true;
            return;
        }
        this.logger.mo8742b(this.tag, "No undesired viewability flags matched - scheduling viewability");
        this.f5244n = false;
        m6406b();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m6391a(AnimatorListenerAdapter animatorListenerAdapter) {
        C1698b bVar = this.f5243m;
        if (bVar == null || bVar.mo7782n() == null) {
            animatorListenerAdapter.onAnimationEnd((Animator) null);
            return;
        }
        View n = this.f5243m.mo7782n();
        n.animate().alpha(0.0f).setDuration(((Long) this.sdk.mo8549a(C1840b.f5785w)).longValue()).setListener(animatorListenerAdapter).start();
    }

    /* renamed from: a */
    private void m6392a(View view, C1698b bVar) {
        int l = bVar.mo7780l();
        int m = bVar.mo7781m();
        int i = -1;
        int dpToPx = l == -1 ? -1 : AppLovinSdkUtils.dpToPx(view.getContext(), l);
        if (m != -1) {
            i = AppLovinSdkUtils.dpToPx(view.getContext(), m);
        }
        int height = this.f5232b.getHeight();
        int width = this.f5232b.getWidth();
        if ((height > 0 && height < i) || (width > 0 && width < dpToPx)) {
            int pxToDp = AppLovinSdkUtils.pxToDp(view.getContext(), height);
            C1977q.m7750h("AppLovinSdk", "\n**************************************************\n`MaxAdView` size " + AppLovinSdkUtils.pxToDp(view.getContext(), width) + "x" + pxToDp + " dp smaller than required size: " + l + "x" + m + " dp\n**************************************************\n");
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new RelativeLayout.LayoutParams(dpToPx, i);
        } else {
            layoutParams.width = dpToPx;
            layoutParams.height = i;
        }
        if (layoutParams instanceof RelativeLayout.LayoutParams) {
            this.logger.mo8742b(this.tag, "Pinning ad view to MAX ad view with width: " + dpToPx + " and height: " + i + ".");
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
            for (int addRule : C2030s.m8044a(this.f5232b.getGravity(), 10, 14)) {
                layoutParams2.addRule(addRule);
            }
        }
        view.setLayoutParams(layoutParams);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m6400a(final C1698b bVar) {
        AppLovinSdkUtils.runOnUiThread(new Runnable() {
            public void run() {
                String str;
                C1977q qVar;
                String str2;
                if (bVar.mo7782n() != null) {
                    final MaxAdView d = MaxAdViewImpl.this.f5232b;
                    if (d != null) {
                        MaxAdViewImpl.this.m6391a((AnimatorListenerAdapter) new AnimatorListenerAdapter() {
                            public void onAnimationEnd(Animator animator) {
                                super.onAnimationEnd(animator);
                                MaxAdViewImpl.this.m6388a();
                                MaxAdViewImpl.this.sdk.mo8571ag().mo8619a((Object) bVar);
                                if (bVar.mo7788t()) {
                                    MaxAdViewImpl.this.f5241k.mo8855a(bVar);
                                }
                                C16752 r3 = C16752.this;
                                MaxAdViewImpl.this.m6402a(bVar, d);
                                synchronized (MaxAdViewImpl.this.f5242l) {
                                    C1698b unused = MaxAdViewImpl.this.f5243m = bVar;
                                }
                                MaxAdViewImpl maxAdViewImpl = MaxAdViewImpl.this;
                                maxAdViewImpl.logger.mo8742b(maxAdViewImpl.tag, "Scheduling impression for ad manually...");
                                MaxAdViewImpl.this.sdk.mo8605y().maybeScheduleRawAdImpressionPostback(bVar);
                                AppLovinSdkUtils.runOnUiThreadDelayed(new Runnable() {
                                    public void run() {
                                        long a = MaxAdViewImpl.this.f5240j.mo8853a(bVar);
                                        if (!bVar.mo7788t()) {
                                            C16752 r2 = C16752.this;
                                            MaxAdViewImpl.this.m6401a(bVar, a);
                                        }
                                        MaxAdViewImpl.this.m6390a(a);
                                    }
                                }, bVar.mo7783o());
                            }
                        });
                        return;
                    }
                    MaxAdViewImpl maxAdViewImpl = MaxAdViewImpl.this;
                    qVar = maxAdViewImpl.logger;
                    str2 = maxAdViewImpl.tag;
                    str = "Max ad view does not have a parent View";
                } else {
                    MaxAdViewImpl maxAdViewImpl2 = MaxAdViewImpl.this;
                    qVar = maxAdViewImpl2.logger;
                    str2 = maxAdViewImpl2.tag;
                    str = "Max ad does not have a loaded ad view";
                }
                qVar.mo8746e(str2, str);
                MaxAdViewImpl.this.f5237g.onAdDisplayFailed(bVar, -5201);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m6401a(C1698b bVar, long j) {
        this.logger.mo8742b(this.tag, "Scheduling viewability impression for ad...");
        this.sdk.mo8605y().maybeScheduleViewabilityAdImpressionPostback(bVar, j);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m6402a(C1698b bVar, MaxAdView maxAdView) {
        View n = bVar.mo7782n();
        n.setAlpha(0.0f);
        if (bVar.mo7793y() != Long.MAX_VALUE) {
            this.f5233c.setBackgroundColor((int) bVar.mo7793y());
        } else {
            long j = this.f5234d;
            if (j != Long.MAX_VALUE) {
                this.f5233c.setBackgroundColor((int) j);
            } else {
                this.f5233c.setBackgroundColor(0);
            }
        }
        maxAdView.addView(n);
        m6392a(n, bVar);
        n.animate().alpha(1.0f).setDuration(((Long) this.sdk.mo8549a(C1840b.f5784v)).longValue()).start();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m6403a(MaxAd maxAd) {
        this.sdk.mo8571ag().mo8619a((Object) maxAd);
        if (this.f5245o) {
            this.f5245o = false;
            C1977q qVar = this.logger;
            String str = this.tag;
            qVar.mo8742b(str, "Rendering precache request ad: " + maxAd.getAdUnitId() + "...");
            this.f5237g.onAdLoaded(maxAd);
            return;
        }
        this.f5235e = (C1698b) maxAd;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m6404a(final MaxAdListener maxAdListener) {
        if (m6411d()) {
            C1977q.m7751i(this.tag, "Unable to load new ad; ad is already destroyed");
            C1994j.m7912a(this.adListener, this.adUnitId, -1);
            return;
        }
        AppLovinSdkUtils.runOnUiThread(new Runnable() {
            public void run() {
                if (MaxAdViewImpl.this.f5243m != null) {
                    long a = MaxAdViewImpl.this.f5240j.mo8853a(MaxAdViewImpl.this.f5243m);
                    MaxAdViewImpl maxAdViewImpl = MaxAdViewImpl.this;
                    maxAdViewImpl.loadRequestBuilder.mo7882a("visible_ad_ad_unit_id", maxAdViewImpl.f5243m.getAdUnitId()).mo7882a("viewability_flags", String.valueOf(a));
                } else {
                    MaxAdViewImpl.this.loadRequestBuilder.mo7881a("visible_ad_ad_unit_id").mo7881a("viewability_flags");
                }
                MaxAdViewImpl maxAdViewImpl2 = MaxAdViewImpl.this;
                C1977q qVar = maxAdViewImpl2.logger;
                String str = maxAdViewImpl2.tag;
                qVar.mo8742b(str, "Loading banner ad for '" + MaxAdViewImpl.this.adUnitId + "' and notifying " + maxAdListener + "...");
                MediationServiceImpl y = MaxAdViewImpl.this.sdk.mo8605y();
                MaxAdViewImpl maxAdViewImpl3 = MaxAdViewImpl.this;
                y.loadAd(maxAdViewImpl3.adUnitId, maxAdViewImpl3.adFormat, maxAdViewImpl3.loadRequestBuilder.mo7883a(), MaxAdViewImpl.this.f5231a, maxAdListener);
            }
        });
    }

    /* renamed from: b */
    private void m6406b() {
        if (m6409c()) {
            long longValue = ((Long) this.sdk.mo8549a(C1840b.f5748A)).longValue();
            C1977q qVar = this.logger;
            String str = this.tag;
            qVar.mo8742b(str, "Scheduling refresh precache request in " + TimeUnit.MICROSECONDS.toSeconds(longValue) + " seconds...");
            this.sdk.mo8533L().mo8476a(new C1871ad(this.sdk, new Runnable() {
                public void run() {
                    MaxAdViewImpl maxAdViewImpl = MaxAdViewImpl.this;
                    maxAdViewImpl.m6404a((MaxAdListener) maxAdViewImpl.f5238h);
                }
            }), C1729c.m6621a(this.adFormat), longValue);
        }
    }

    /* renamed from: c */
    private boolean m6409c() {
        return ((Long) this.sdk.mo8549a(C1840b.f5748A)).longValue() > 0;
    }

    /* renamed from: d */
    private boolean m6411d() {
        boolean z;
        synchronized (this.f5242l) {
            z = this.f5246p;
        }
        return z;
    }

    public void destroy() {
        m6388a();
        if (this.f5235e != null) {
            this.sdk.mo8571ag().mo8620b(this.f5235e);
            this.sdk.mo8605y().destroyAd(this.f5235e);
        }
        synchronized (this.f5242l) {
            this.f5246p = true;
        }
        this.f5239i.mo8399c();
    }

    public String getPlacement() {
        return this.f5236f;
    }

    public void loadAd() {
        C1977q qVar = this.logger;
        String str = this.tag;
        qVar.mo8742b(str, "" + this + " Loading ad for " + this.adUnitId + "...");
        if (m6411d()) {
            C1977q.m7751i(this.tag, "Unable to load new ad; ad is already destroyed");
            C1994j.m7912a(this.adListener, this.adUnitId, -1);
        } else if (!((Boolean) this.sdk.mo8549a(C1840b.f5749B)).booleanValue() || !this.f5239i.mo8397a()) {
            m6404a((MaxAdListener) this.f5237g);
        } else {
            String str2 = this.tag;
            C1977q.m7751i(str2, "Unable to load a new ad. An ad refresh has already been scheduled in " + TimeUnit.MILLISECONDS.toSeconds(this.f5239i.mo8398b()) + " seconds.");
        }
    }

    public void onAdRefresh() {
        String str;
        String str2;
        C1977q qVar;
        this.f5245o = false;
        if (this.f5235e != null) {
            C1977q qVar2 = this.logger;
            String str3 = this.tag;
            qVar2.mo8742b(str3, "Refreshing for cached ad: " + this.f5235e.getAdUnitId() + "...");
            this.f5237g.onAdLoaded(this.f5235e);
            this.f5235e = null;
            return;
        }
        if (!m6409c()) {
            qVar = this.logger;
            str2 = this.tag;
            str = "Refreshing ad from network...";
        } else if (this.f5244n) {
            qVar = this.logger;
            str2 = this.tag;
            str = "Refreshing ad from network due to viewability requirements not met for refresh request...";
        } else {
            this.logger.mo8746e(this.tag, "Ignoring attempt to refresh ad - either still waiting for precache or did not attempt request due to visibility requirement not met");
            this.f5245o = true;
            return;
        }
        qVar.mo8742b(str2, str);
        loadAd();
    }

    public void onLogVisibilityImpression() {
        m6401a(this.f5243m, this.f5240j.mo8853a(this.f5243m));
    }

    public void onWindowVisibilityChanged(int i) {
        if (((Boolean) this.sdk.mo8549a(C1840b.f5783u)).booleanValue() && this.f5239i.mo8397a()) {
            if (C2030s.m8042a(i)) {
                this.logger.mo8742b(this.tag, "Ad view visible");
                this.f5239i.mo8403g();
                return;
            }
            this.logger.mo8742b(this.tag, "Ad view hidden");
            this.f5239i.mo8402f();
        }
    }

    public void setPlacement(String str) {
        this.f5236f = str;
    }

    public void setPublisherBackgroundColor(int i) {
        this.f5234d = (long) i;
    }

    public void startAutoRefresh() {
        this.f5239i.mo8401e();
        C1977q qVar = this.logger;
        String str = this.tag;
        qVar.mo8742b(str, "Resumed auto-refresh with remaining time: " + this.f5239i.mo8398b());
    }

    public void stopAutoRefresh() {
        if (this.f5243m != null) {
            C1977q qVar = this.logger;
            String str = this.tag;
            qVar.mo8742b(str, "Pausing auto-refresh with remaining time: " + this.f5239i.mo8398b());
            this.f5239i.mo8400d();
            return;
        }
        C1977q.m7750h(this.tag, "Stopping auto-refresh has no effect until after the first ad has been loaded.");
    }

    public String toString() {
        return "MaxAdView{adUnitId='" + this.adUnitId + '\'' + ", adListener=" + this.adListener + ", isDestroyed=" + m6411d() + '}';
    }
}
