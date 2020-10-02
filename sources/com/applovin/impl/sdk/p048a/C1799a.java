package com.applovin.impl.sdk.p048a;

import android.content.Context;
import com.applovin.adview.AppLovinInterstitialAd;
import com.applovin.adview.AppLovinInterstitialAdDialog;
import com.applovin.impl.sdk.AppLovinAdBase;
import com.applovin.impl.sdk.AppLovinAdServiceImpl;
import com.applovin.impl.sdk.C1941j;
import com.applovin.impl.sdk.C1977q;
import com.applovin.impl.sdk.p049ad.C1827g;
import com.applovin.impl.sdk.p049ad.C1833h;
import com.applovin.impl.sdk.p049ad.C1834i;
import com.applovin.impl.sdk.p051c.C1859g;
import com.applovin.impl.sdk.p052d.C1864a;
import com.applovin.impl.sdk.p052d.C1872ae;
import com.applovin.impl.sdk.p052d.C1907s;
import com.applovin.impl.sdk.p052d.C1923z;
import com.applovin.impl.sdk.utils.C1994j;
import com.applovin.impl.sdk.utils.C2025o;
import com.applovin.impl.sdk.utils.C2029r;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdClickListener;
import com.applovin.sdk.AppLovinAdDisplayListener;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.applovin.sdk.AppLovinAdRewardListener;
import com.applovin.sdk.AppLovinAdType;
import com.applovin.sdk.AppLovinAdVideoPlaybackListener;
import com.applovin.sdk.AppLovinErrorCodes;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkUtils;
import java.lang.ref.SoftReference;
import java.util.Map;

/* renamed from: com.applovin.impl.sdk.a.a */
public class C1799a {

    /* renamed from: a */
    protected final C1941j f5569a;

    /* renamed from: b */
    protected final AppLovinAdServiceImpl f5570b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public AppLovinAd f5571c;

    /* renamed from: d */
    private String f5572d;

    /* renamed from: e */
    private SoftReference<AppLovinAdLoadListener> f5573e;

    /* renamed from: f */
    private final Object f5574f = new Object();

    /* renamed from: g */
    private volatile String f5575g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public volatile boolean f5576h = false;

    /* renamed from: com.applovin.impl.sdk.a.a$a */
    private class C1801a implements AppLovinAdLoadListener {
        /* access modifiers changed from: private */

        /* renamed from: b */
        public final AppLovinAdLoadListener f5579b;

        C1801a(AppLovinAdLoadListener appLovinAdLoadListener) {
            this.f5579b = appLovinAdLoadListener;
        }

        public void adReceived(final AppLovinAd appLovinAd) {
            AppLovinAd unused = C1799a.this.f5571c = appLovinAd;
            if (this.f5579b != null) {
                AppLovinSdkUtils.runOnUiThread(new Runnable() {
                    public void run() {
                        try {
                            C1801a.this.f5579b.adReceived(appLovinAd);
                        } catch (Throwable th) {
                            C1977q.m7747c("AppLovinIncentivizedInterstitial", "Unable to notify ad listener about a newly loaded ad", th);
                        }
                    }
                });
            }
        }

        public void failedToReceiveAd(final int i) {
            if (this.f5579b != null) {
                AppLovinSdkUtils.runOnUiThread(new Runnable() {
                    public void run() {
                        try {
                            C1801a.this.f5579b.failedToReceiveAd(i);
                        } catch (Throwable th) {
                            C1977q.m7747c("AppLovinIncentivizedInterstitial", "Unable to notify listener about ad load failure", th);
                        }
                    }
                });
            }
        }
    }

    /* renamed from: com.applovin.impl.sdk.a.a$b */
    private class C1804b implements C1834i, AppLovinAdClickListener, AppLovinAdRewardListener, AppLovinAdVideoPlaybackListener {

        /* renamed from: b */
        private final AppLovinAdDisplayListener f5585b;

        /* renamed from: c */
        private final AppLovinAdClickListener f5586c;

        /* renamed from: d */
        private final AppLovinAdVideoPlaybackListener f5587d;

        /* renamed from: e */
        private final AppLovinAdRewardListener f5588e;

        private C1804b(AppLovinAdRewardListener appLovinAdRewardListener, AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener, AppLovinAdDisplayListener appLovinAdDisplayListener, AppLovinAdClickListener appLovinAdClickListener) {
            this.f5585b = appLovinAdDisplayListener;
            this.f5586c = appLovinAdClickListener;
            this.f5587d = appLovinAdVideoPlaybackListener;
            this.f5588e = appLovinAdRewardListener;
        }

        /* renamed from: a */
        private void m6795a(C1827g gVar) {
            String str;
            int i;
            if (!C2025o.m7963b(C1799a.this.m6787e()) || !C1799a.this.f5576h) {
                gVar.mo8244aN();
                if (C1799a.this.f5576h) {
                    i = AppLovinErrorCodes.INCENTIVIZED_SERVER_TIMEOUT;
                    str = "network_timeout";
                } else {
                    i = AppLovinErrorCodes.INCENTIVIZED_USER_CLOSED_VIDEO;
                    str = "user_closed_video";
                }
                gVar.mo8229a(C1814c.m6808a(str));
                C1994j.m7916a(this.f5588e, (AppLovinAd) gVar, i);
            }
            C1799a.this.m6778a((AppLovinAd) gVar);
            C1994j.m7925b(this.f5585b, (AppLovinAd) gVar);
            if (!gVar.mo8262ap().getAndSet(true)) {
                C1799a.this.f5569a.mo8533L().mo8475a((C1864a) new C1923z(gVar, C1799a.this.f5569a), C1907s.C1909a.REWARD);
            }
        }

        public void adClicked(AppLovinAd appLovinAd) {
            C1994j.m7913a(this.f5586c, appLovinAd);
        }

        public void adDisplayed(AppLovinAd appLovinAd) {
            C1994j.m7914a(this.f5585b, appLovinAd);
        }

        public void adHidden(AppLovinAd appLovinAd) {
            if (appLovinAd instanceof C1833h) {
                appLovinAd = ((C1833h) appLovinAd).mo8289a();
            }
            if (appLovinAd instanceof C1827g) {
                m6795a((C1827g) appLovinAd);
                return;
            }
            C1977q v = C1799a.this.f5569a.mo8602v();
            v.mo8746e("IncentivizedAdController", "Something is terribly wrong. Received `adHidden` callback for invalid ad of type: " + appLovinAd);
        }

        public void onAdDisplayFailed(String str) {
            C1994j.m7915a(this.f5585b, str);
        }

        public void userDeclinedToViewAd(AppLovinAd appLovinAd) {
        }

        public void userOverQuota(AppLovinAd appLovinAd, Map<String, String> map) {
            C1799a.this.m6781a("quota_exceeded");
            C1994j.m7926b(this.f5588e, appLovinAd, map);
        }

        public void userRewardRejected(AppLovinAd appLovinAd, Map<String, String> map) {
            C1799a.this.m6781a("rejected");
            C1994j.m7929c(this.f5588e, appLovinAd, map);
        }

        public void userRewardVerified(AppLovinAd appLovinAd, Map<String, String> map) {
            C1799a.this.m6781a("accepted");
            C1994j.m7917a(this.f5588e, appLovinAd, map);
        }

        public void validationRequestFailed(AppLovinAd appLovinAd, int i) {
            C1799a.this.m6781a("network_timeout");
            C1994j.m7916a(this.f5588e, appLovinAd, i);
        }

        public void videoPlaybackBegan(AppLovinAd appLovinAd) {
            C1994j.m7918a(this.f5587d, appLovinAd);
        }

        public void videoPlaybackEnded(AppLovinAd appLovinAd, double d, boolean z) {
            C1994j.m7919a(this.f5587d, appLovinAd, d, z);
            boolean unused = C1799a.this.f5576h = z;
        }
    }

    public C1799a(String str, AppLovinSdk appLovinSdk) {
        this.f5569a = C2029r.m7993a(appLovinSdk);
        this.f5570b = (AppLovinAdServiceImpl) appLovinSdk.getAdService();
        this.f5572d = str;
    }

    /* renamed from: a */
    private void m6774a(AppLovinAdBase appLovinAdBase, Context context, AppLovinAdRewardListener appLovinAdRewardListener, AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener, AppLovinAdDisplayListener appLovinAdDisplayListener, AppLovinAdClickListener appLovinAdClickListener) {
        if (!appLovinAdBase.getType().equals(AppLovinAdType.INCENTIVIZED)) {
            C1977q v = this.f5569a.mo8602v();
            v.mo8746e("IncentivizedAdController", "Failed to render an ad of type " + appLovinAdBase.getType() + " in an Incentivized Ad interstitial.");
            m6780a(appLovinAdBase, appLovinAdVideoPlaybackListener, appLovinAdDisplayListener);
            return;
        }
        AppLovinAd a = C2029r.m7994a((AppLovinAd) appLovinAdBase, this.f5569a);
        if (a != null) {
            AppLovinInterstitialAdDialog create = AppLovinInterstitialAd.create(this.f5569a.mo8540S(), context);
            C1804b bVar = new C1804b(appLovinAdRewardListener, appLovinAdVideoPlaybackListener, appLovinAdDisplayListener, appLovinAdClickListener);
            create.setAdDisplayListener(bVar);
            create.setAdVideoPlaybackListener(bVar);
            create.setAdClickListener(bVar);
            create.showAndRender(a);
            if (a instanceof C1827g) {
                m6777a((C1827g) a, (AppLovinAdRewardListener) bVar);
                return;
            }
            return;
        }
        m6780a(appLovinAdBase, appLovinAdVideoPlaybackListener, appLovinAdDisplayListener);
    }

    /* renamed from: a */
    private void m6777a(C1827g gVar, AppLovinAdRewardListener appLovinAdRewardListener) {
        this.f5569a.mo8533L().mo8475a((C1864a) new C1872ae(gVar, appLovinAdRewardListener, this.f5569a), C1907s.C1909a.REWARD);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m6778a(AppLovinAd appLovinAd) {
        AppLovinAd appLovinAd2 = this.f5571c;
        if (appLovinAd2 != null) {
            if (appLovinAd2 instanceof C1833h) {
                if (appLovinAd != ((C1833h) appLovinAd2).mo8289a()) {
                    return;
                }
            } else if (appLovinAd != appLovinAd2) {
                return;
            }
            this.f5571c = null;
        }
    }

    /* renamed from: a */
    private void m6779a(AppLovinAd appLovinAd, Context context, AppLovinAdRewardListener appLovinAdRewardListener, AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener, AppLovinAdDisplayListener appLovinAdDisplayListener, AppLovinAdClickListener appLovinAdClickListener) {
        if (appLovinAd == null) {
            appLovinAd = this.f5571c;
        }
        AppLovinAdBase appLovinAdBase = (AppLovinAdBase) appLovinAd;
        if (appLovinAdBase != null) {
            m6774a(appLovinAdBase, context, appLovinAdRewardListener, appLovinAdVideoPlaybackListener, appLovinAdDisplayListener, appLovinAdClickListener);
            return;
        }
        C1977q.m7751i("IncentivizedAdController", "Skipping incentivized video playback: user attempted to play an incentivized video before one was preloaded.");
        m6786d();
    }

    /* renamed from: a */
    private void m6780a(AppLovinAd appLovinAd, AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener, AppLovinAdDisplayListener appLovinAdDisplayListener) {
        this.f5569a.mo8534M().mo8387a(C1859g.f6195j);
        C1994j.m7919a(appLovinAdVideoPlaybackListener, appLovinAd, 0.0d, false);
        C1994j.m7925b(appLovinAdDisplayListener, appLovinAd);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m6781a(String str) {
        synchronized (this.f5574f) {
            this.f5575g = str;
        }
    }

    /* renamed from: b */
    private void m6784b(AppLovinAdLoadListener appLovinAdLoadListener) {
        this.f5570b.loadNextIncentivizedAd(this.f5572d, appLovinAdLoadListener);
    }

    /* renamed from: d */
    private void m6786d() {
        AppLovinAdLoadListener appLovinAdLoadListener;
        SoftReference<AppLovinAdLoadListener> softReference = this.f5573e;
        if (softReference != null && (appLovinAdLoadListener = softReference.get()) != null) {
            appLovinAdLoadListener.failedToReceiveAd(AppLovinErrorCodes.INCENTIVIZED_NO_AD_PRELOADED);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public String m6787e() {
        String str;
        synchronized (this.f5574f) {
            str = this.f5575g;
        }
        return str;
    }

    /* renamed from: f */
    private AppLovinAdRewardListener m6788f() {
        return new AppLovinAdRewardListener() {
            public void userDeclinedToViewAd(AppLovinAd appLovinAd) {
                C1799a.this.f5569a.mo8602v().mo8742b("IncentivizedAdController", "User declined to view");
            }

            public void userOverQuota(AppLovinAd appLovinAd, Map<String, String> map) {
                C1977q v = C1799a.this.f5569a.mo8602v();
                v.mo8742b("IncentivizedAdController", "User over quota: " + map);
            }

            public void userRewardRejected(AppLovinAd appLovinAd, Map<String, String> map) {
                C1977q v = C1799a.this.f5569a.mo8602v();
                v.mo8742b("IncentivizedAdController", "Reward rejected: " + map);
            }

            public void userRewardVerified(AppLovinAd appLovinAd, Map<String, String> map) {
                C1977q v = C1799a.this.f5569a.mo8602v();
                v.mo8742b("IncentivizedAdController", "Reward validated: " + map);
            }

            public void validationRequestFailed(AppLovinAd appLovinAd, int i) {
                C1977q v = C1799a.this.f5569a.mo8602v();
                v.mo8742b("IncentivizedAdController", "Reward validation failed: " + i);
            }
        };
    }

    /* renamed from: a */
    public void mo8081a(AppLovinAd appLovinAd, Context context, String str, AppLovinAdRewardListener appLovinAdRewardListener, AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener, AppLovinAdDisplayListener appLovinAdDisplayListener, AppLovinAdClickListener appLovinAdClickListener) {
        if (appLovinAdRewardListener == null) {
            appLovinAdRewardListener = m6788f();
        }
        m6779a(appLovinAd, context, appLovinAdRewardListener, appLovinAdVideoPlaybackListener, appLovinAdDisplayListener, appLovinAdClickListener);
    }

    /* renamed from: a */
    public void mo8082a(AppLovinAdLoadListener appLovinAdLoadListener) {
        this.f5569a.mo8602v().mo8742b("IncentivizedAdController", "User requested preload of incentivized ad...");
        this.f5573e = new SoftReference<>(appLovinAdLoadListener);
        if (mo8083a()) {
            C1977q.m7751i("IncentivizedAdController", "Attempted to call preloadAndNotify: while an ad was already loaded or currently being played. Do not call preloadAndNotify: again until the last ad has been closed (adHidden).");
            if (appLovinAdLoadListener != null) {
                appLovinAdLoadListener.adReceived(this.f5571c);
                return;
            }
            return;
        }
        m6784b((AppLovinAdLoadListener) new C1801a(appLovinAdLoadListener));
    }

    /* renamed from: a */
    public boolean mo8083a() {
        return this.f5571c != null;
    }

    /* renamed from: b */
    public String mo8084b() {
        return this.f5572d;
    }

    /* renamed from: c */
    public void mo8085c() {
    }
}
