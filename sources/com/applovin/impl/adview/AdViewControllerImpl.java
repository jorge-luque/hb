package com.applovin.impl.adview;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.PointF;
import android.net.Uri;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.WebView;
import android.widget.RelativeLayout;
import com.applovin.adview.AdViewController;
import com.applovin.adview.AppLovinAdView;
import com.applovin.adview.AppLovinAdViewEventListener;
import com.applovin.communicator.AppLovinCommunicator;
import com.applovin.communicator.AppLovinCommunicatorMessage;
import com.applovin.communicator.AppLovinCommunicatorSubscriber;
import com.applovin.impl.p033a.C1476a;
import com.applovin.impl.sdk.AppLovinAdServiceImpl;
import com.applovin.impl.sdk.C1941j;
import com.applovin.impl.sdk.C1977q;
import com.applovin.impl.sdk.p049ad.C1817a;
import com.applovin.impl.sdk.p049ad.C1827g;
import com.applovin.impl.sdk.p050b.C1841c;
import com.applovin.impl.sdk.p051c.C1854d;
import com.applovin.impl.sdk.p051c.C1859g;
import com.applovin.impl.sdk.utils.C1985b;
import com.applovin.impl.sdk.utils.C1994j;
import com.applovin.impl.sdk.utils.C2021k;
import com.applovin.impl.sdk.utils.C2029r;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdClickListener;
import com.applovin.sdk.AppLovinAdDisplayListener;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkUtils;
import java.util.concurrent.atomic.AtomicReference;

public class AdViewControllerImpl implements AdViewController, AppLovinCommunicatorSubscriber {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public Context f4682a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public ViewGroup f4683b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public C1941j f4684c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public AppLovinAdServiceImpl f4685d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public C1977q f4686e;

    /* renamed from: f */
    private AppLovinCommunicator f4687f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public AppLovinAdSize f4688g;

    /* renamed from: h */
    private String f4689h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public C1854d f4690i;

    /* renamed from: j */
    private C1556d f4691j;

    /* renamed from: k */
    private C1506c f4692k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public C1548c f4693l;

    /* renamed from: m */
    private Runnable f4694m;

    /* renamed from: n */
    private Runnable f4695n;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public volatile C1827g f4696o = null;

    /* renamed from: p */
    private volatile AppLovinAd f4697p = null;
    /* access modifiers changed from: private */

    /* renamed from: q */
    public C1570k f4698q = null;
    /* access modifiers changed from: private */

    /* renamed from: r */
    public C1570k f4699r = null;

    /* renamed from: s */
    private final AtomicReference<AppLovinAd> f4700s = new AtomicReference<>();

    /* renamed from: t */
    private volatile boolean f4701t = false;
    /* access modifiers changed from: private */

    /* renamed from: u */
    public volatile boolean f4702u = false;
    /* access modifiers changed from: private */

    /* renamed from: v */
    public volatile AppLovinAdLoadListener f4703v;

    /* renamed from: w */
    private volatile AppLovinAdDisplayListener f4704w;
    /* access modifiers changed from: private */

    /* renamed from: x */
    public volatile AppLovinAdViewEventListener f4705x;

    /* renamed from: y */
    private volatile AppLovinAdClickListener f4706y;

    /* renamed from: com.applovin.impl.adview.AdViewControllerImpl$a */
    private class C1504a implements Runnable {
        private C1504a() {
        }

        public void run() {
            if (AdViewControllerImpl.this.f4693l != null) {
                AdViewControllerImpl.this.f4693l.setVisibility(8);
            }
        }
    }

    /* renamed from: com.applovin.impl.adview.AdViewControllerImpl$b */
    private class C1505b implements Runnable {
        private C1505b() {
        }

        public void run() {
            if (AdViewControllerImpl.this.f4696o == null) {
                return;
            }
            if (AdViewControllerImpl.this.f4693l != null) {
                AdViewControllerImpl.this.m5829f();
                C1977q c = AdViewControllerImpl.this.f4686e;
                c.mo8742b("AppLovinAdView", "Rendering advertisement ad for #" + AdViewControllerImpl.this.f4696o.getAdIdNumber() + "...");
                AdViewControllerImpl.m5821b((View) AdViewControllerImpl.this.f4693l, AdViewControllerImpl.this.f4696o.getSize());
                AdViewControllerImpl.this.f4693l.mo7371a(AdViewControllerImpl.this.f4696o);
                if (AdViewControllerImpl.this.f4696o.getSize() != AppLovinAdSize.INTERSTITIAL && !AdViewControllerImpl.this.f4702u) {
                    AdViewControllerImpl adViewControllerImpl = AdViewControllerImpl.this;
                    C1854d unused = adViewControllerImpl.f4690i = new C1854d(adViewControllerImpl.f4696o, AdViewControllerImpl.this.f4684c);
                    AdViewControllerImpl.this.f4690i.mo8359a();
                    AdViewControllerImpl.this.f4693l.setStatsManagerHelper(AdViewControllerImpl.this.f4690i);
                    AdViewControllerImpl.this.f4696o.setHasShown(true);
                }
                if (AdViewControllerImpl.this.f4693l.getStatsManagerHelper() != null) {
                    AdViewControllerImpl.this.f4693l.getStatsManagerHelper().mo8360a(AdViewControllerImpl.this.f4696o.mo8285v() ? 0 : 1);
                    return;
                }
                return;
            }
            C1977q.m7751i("AppLovinAdView", "Unable to render advertisement for ad #" + AdViewControllerImpl.this.f4696o.getAdIdNumber() + ". Please make sure you are not calling AppLovinAdView.destroy() prematurely.");
        }
    }

    /* renamed from: com.applovin.impl.adview.AdViewControllerImpl$c */
    static class C1506c implements AppLovinAdLoadListener {

        /* renamed from: a */
        private final AdViewControllerImpl f4721a;

        C1506c(AdViewControllerImpl adViewControllerImpl, C1941j jVar) {
            if (adViewControllerImpl == null) {
                throw new IllegalArgumentException("No view specified");
            } else if (jVar != null) {
                this.f4721a = adViewControllerImpl;
            } else {
                throw new IllegalArgumentException("No sdk specified");
            }
        }

        /* renamed from: a */
        private AdViewControllerImpl m5844a() {
            return this.f4721a;
        }

        public void adReceived(AppLovinAd appLovinAd) {
            AdViewControllerImpl a = m5844a();
            if (a != null) {
                a.mo7239a(appLovinAd);
            } else {
                C1977q.m7751i("AppLovinAdView", "Ad view has been garbage collected by the time an ad was received");
            }
        }

        public void failedToReceiveAd(int i) {
            AdViewControllerImpl a = m5844a();
            if (a != null) {
                a.mo7237a(i);
            }
        }
    }

    /* renamed from: a */
    private void m5816a(AppLovinAdView appLovinAdView, C1941j jVar, AppLovinAdSize appLovinAdSize, String str, Context context) {
        if (appLovinAdView == null) {
            throw new IllegalArgumentException("No parent view specified");
        } else if (jVar == null) {
            throw new IllegalArgumentException("No sdk specified");
        } else if (appLovinAdSize != null) {
            this.f4684c = jVar;
            this.f4685d = jVar.mo8594o();
            this.f4686e = jVar.mo8602v();
            this.f4687f = AppLovinCommunicator.getInstance(context);
            this.f4688g = appLovinAdSize;
            this.f4689h = str;
            this.f4682a = context;
            this.f4683b = appLovinAdView;
            this.f4691j = new C1556d(this, jVar);
            this.f4695n = new C1504a();
            this.f4694m = new C1505b();
            this.f4692k = new C1506c(this, jVar);
            attachNewAdView(appLovinAdSize);
        } else {
            throw new IllegalArgumentException("No ad size specified");
        }
    }

    /* renamed from: a */
    private void m5817a(Runnable runnable) {
        AppLovinSdkUtils.runOnUiThread(runnable);
    }

    /* renamed from: b */
    private void m5820b() {
        C1977q qVar = this.f4686e;
        if (qVar != null) {
            qVar.mo8742b("AppLovinAdView", "Destroying...");
        }
        C1548c cVar = this.f4693l;
        if (cVar != null) {
            ViewParent parent = cVar.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.f4693l);
            }
            this.f4693l.removeAllViews();
            if (this.f4693l.mo7374a()) {
                this.f4693l.loadUrl("about:blank");
                this.f4693l.clearHistory();
            } else {
                if (((Boolean) this.f4684c.mo8549a(C1841c.f6024eO)).booleanValue()) {
                    this.f4693l.loadUrl("about:blank");
                    this.f4693l.onPause();
                    this.f4693l.destroyDrawingCache();
                }
                this.f4693l.destroy();
            }
            this.f4693l = null;
            this.f4684c.mo8571ag().mo8620b(this.f4696o);
        }
        this.f4702u = true;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static void m5821b(View view, AppLovinAdSize appLovinAdSize) {
        if (view != null) {
            DisplayMetrics displayMetrics = view.getResources().getDisplayMetrics();
            int i = -1;
            int applyDimension = appLovinAdSize.getLabel().equals(AppLovinAdSize.INTERSTITIAL.getLabel()) ? -1 : appLovinAdSize.getWidth() == -1 ? displayMetrics.widthPixels : (int) TypedValue.applyDimension(1, (float) appLovinAdSize.getWidth(), displayMetrics);
            if (!appLovinAdSize.getLabel().equals(AppLovinAdSize.INTERSTITIAL.getLabel())) {
                i = appLovinAdSize.getHeight() == -1 ? displayMetrics.heightPixels : (int) TypedValue.applyDimension(1, (float) appLovinAdSize.getHeight(), displayMetrics);
            }
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            }
            layoutParams.width = applyDimension;
            layoutParams.height = i;
            if (layoutParams instanceof RelativeLayout.LayoutParams) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
                layoutParams2.addRule(10);
                layoutParams2.addRule(9);
            }
            view.setLayoutParams(layoutParams);
        }
    }

    /* renamed from: c */
    private void m5823c() {
        m5817a((Runnable) new Runnable() {
            public void run() {
                if (AdViewControllerImpl.this.f4698q != null) {
                    C1977q c = AdViewControllerImpl.this.f4686e;
                    c.mo8742b("AppLovinAdView", "Detaching expanded ad: " + AdViewControllerImpl.this.f4698q.mo7449a());
                    AdViewControllerImpl adViewControllerImpl = AdViewControllerImpl.this;
                    C1570k unused = adViewControllerImpl.f4699r = adViewControllerImpl.f4698q;
                    C1570k unused2 = AdViewControllerImpl.this.f4698q = null;
                    AdViewControllerImpl adViewControllerImpl2 = AdViewControllerImpl.this;
                    adViewControllerImpl2.attachNewAdView(adViewControllerImpl2.f4688g);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m5825d() {
        m5817a((Runnable) new Runnable() {
            public void run() {
                C1817a aVar;
                if (AdViewControllerImpl.this.f4699r != null || AdViewControllerImpl.this.f4698q != null) {
                    if (AdViewControllerImpl.this.f4699r != null) {
                        aVar = AdViewControllerImpl.this.f4699r.mo7449a();
                        AdViewControllerImpl.this.f4699r.dismiss();
                        C1570k unused = AdViewControllerImpl.this.f4699r = null;
                    } else {
                        aVar = AdViewControllerImpl.this.f4698q.mo7449a();
                        AdViewControllerImpl.this.f4698q.dismiss();
                        C1570k unused2 = AdViewControllerImpl.this.f4698q = null;
                    }
                    C1994j.m7923b(AdViewControllerImpl.this.f4705x, (AppLovinAd) aVar, (AppLovinAdView) AdViewControllerImpl.this.f4683b);
                }
            }
        });
    }

    /* renamed from: e */
    private void m5827e() {
        C1854d dVar = this.f4690i;
        if (dVar != null) {
            dVar.mo8363c();
            this.f4690i = null;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public void m5829f() {
        C1827g gVar = this.f4696o;
        C2021k kVar = new C2021k();
        boolean z = gVar instanceof C1476a;
        kVar.mo8801a().mo8803a("Format", gVar.getAdZone().mo8175b().getLabel()).mo8803a("Ad Id", Long.valueOf(gVar.getAdIdNumber())).mo8803a("Zone Id", gVar.getAdZone().mo8174a()).mo8803a("Source", gVar.getSource()).mo8803a("Ad Class", z ? "VastAd" : "AdServerAd");
        if (z) {
            kVar.mo8803a("VAST DSP", ((C1476a) gVar).mo7164j());
        }
        if (!C2029r.m8019a(gVar.getSize())) {
            kVar.mo8801a().mo8802a("Fullscreen Ad Properties");
            kVar.mo8803a("Target", gVar.mo8278o()).mo8803a("close_style", gVar.mo8282s()).mo8804a("close_delay_graphic", Long.valueOf(gVar.mo8281r()), "s");
            if (gVar.hasVideoUrl()) {
                kVar.mo8804a("close_delay", Long.valueOf(gVar.mo8279p()), "s").mo8803a("skip_style", gVar.mo8283t()).mo8803a("Streaming", Boolean.valueOf(gVar.mo7154d())).mo8803a("Video Location", gVar.mo7153c()).mo8803a("video_button_properties", gVar.mo8288y());
            }
        }
        kVar.mo8801a();
        C1977q.m7748f("AppLovinAdView", kVar.toString());
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo7236a() {
        if (this.f4698q == null && this.f4699r == null) {
            C1977q qVar = this.f4686e;
            qVar.mo8742b("AppLovinAdView", "Ad: " + this.f4696o + " closed.");
            m5817a(this.f4695n);
            C1994j.m7925b(this.f4704w, (AppLovinAd) this.f4696o);
            this.f4684c.mo8571ag().mo8620b(this.f4696o);
            this.f4696o = null;
        } else if (((Boolean) this.f4684c.mo8549a(C1841c.f5942ck)).booleanValue()) {
            contractAd();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo7237a(final int i) {
        if (!this.f4702u) {
            m5817a(this.f4695n);
        }
        m5817a((Runnable) new Runnable() {
            public void run() {
                try {
                    if (AdViewControllerImpl.this.f4703v != null) {
                        AdViewControllerImpl.this.f4703v.failedToReceiveAd(i);
                    }
                } catch (Throwable th) {
                    C1977q.m7747c("AppLovinAdView", "Exception while running app load  callback", th);
                }
            }
        });
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo7238a(C1827g gVar, AppLovinAdView appLovinAdView, Uri uri, PointF pointF) {
        C1994j.m7913a(this.f4706y, (AppLovinAd) gVar);
        if (appLovinAdView != null) {
            this.f4685d.trackAndLaunchClick(gVar, appLovinAdView, this, uri, pointF);
        } else {
            this.f4686e.mo8746e("AppLovinAdView", "Unable to process ad click - AppLovinAdView destroyed prematurely");
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo7239a(final AppLovinAd appLovinAd) {
        if (appLovinAd != null) {
            if (!this.f4702u) {
                renderAd(appLovinAd);
            } else {
                this.f4700s.set(appLovinAd);
                this.f4686e.mo8742b("AppLovinAdView", "Ad view has paused when an ad was received, ad saved for later");
            }
            m5817a((Runnable) new Runnable() {
                public void run() {
                    try {
                        if (AdViewControllerImpl.this.f4703v != null) {
                            AdViewControllerImpl.this.f4703v.adReceived(appLovinAd);
                        }
                    } catch (Throwable th) {
                        C1977q.m7751i("AppLovinAdView", "Exception while running ad load callback: " + th.getMessage());
                    }
                }
            });
            return;
        }
        this.f4686e.mo8746e("AppLovinAdView", "No provided when to the view controller");
        mo7237a(-1);
    }

    /* access modifiers changed from: protected */
    public void attachNewAdView(AppLovinAdSize appLovinAdSize) {
        C1548c a = C1548c.m5984a(appLovinAdSize, this.f4691j, this.f4684c, this.f4682a);
        this.f4693l = a;
        a.setBackgroundColor(0);
        this.f4693l.setWillNotCacheDrawing(false);
        this.f4683b.setBackgroundColor(0);
        this.f4683b.addView(this.f4693l);
        m5821b((View) this.f4693l, appLovinAdSize);
        if (!this.f4701t) {
            m5817a(this.f4695n);
        }
        m5817a((Runnable) new Runnable() {
            public void run() {
                AdViewControllerImpl.this.f4693l.loadDataWithBaseURL("/", "<html></html>", "text/html", (String) null, "");
            }
        });
        this.f4701t = true;
    }

    public void contractAd() {
        m5817a((Runnable) new Runnable() {
            public void run() {
                AdViewControllerImpl.this.m5825d();
                if (AdViewControllerImpl.this.f4683b != null && AdViewControllerImpl.this.f4693l != null && AdViewControllerImpl.this.f4693l.getParent() == null) {
                    AdViewControllerImpl.this.f4683b.addView(AdViewControllerImpl.this.f4693l);
                    AdViewControllerImpl.m5821b((View) AdViewControllerImpl.this.f4693l, AdViewControllerImpl.this.f4696o.getSize());
                }
            }
        });
    }

    public void destroy() {
        if (!(this.f4693l == null || this.f4698q == null)) {
            contractAd();
        }
        m5820b();
    }

    public void dismissInterstitialIfRequired() {
        if ((this.f4682a instanceof C1569j) && this.f4696o != null) {
            if (this.f4696o.mo8210J() == C1827g.C1829a.DISMISS) {
                ((C1569j) this.f4682a).dismiss();
            }
        }
    }

    public void expandAd(final PointF pointF) {
        m5817a((Runnable) new Runnable() {
            public void run() {
                if (AdViewControllerImpl.this.f4698q == null && (AdViewControllerImpl.this.f4696o instanceof C1817a) && AdViewControllerImpl.this.f4693l != null) {
                    C1817a aVar = (C1817a) AdViewControllerImpl.this.f4696o;
                    Activity a = AdViewControllerImpl.this.f4682a instanceof Activity ? (Activity) AdViewControllerImpl.this.f4682a : C2029r.m7988a((View) AdViewControllerImpl.this.f4693l, AdViewControllerImpl.this.f4684c);
                    if (a != null) {
                        if (AdViewControllerImpl.this.f4683b != null) {
                            AdViewControllerImpl.this.f4683b.removeView(AdViewControllerImpl.this.f4693l);
                        }
                        C1570k unused = AdViewControllerImpl.this.f4698q = new C1570k(aVar, AdViewControllerImpl.this.f4693l, a, AdViewControllerImpl.this.f4684c);
                        AdViewControllerImpl.this.f4698q.setOnDismissListener(new DialogInterface.OnDismissListener() {
                            public void onDismiss(DialogInterface dialogInterface) {
                                AdViewControllerImpl.this.contractAd();
                            }
                        });
                        AdViewControllerImpl.this.f4698q.show();
                        C1994j.m7908a(AdViewControllerImpl.this.f4705x, (AppLovinAd) AdViewControllerImpl.this.f4696o, (AppLovinAdView) AdViewControllerImpl.this.f4683b);
                        if (AdViewControllerImpl.this.f4690i != null) {
                            AdViewControllerImpl.this.f4690i.mo8365d();
                            return;
                        }
                        return;
                    }
                    C1977q.m7751i("AppLovinAdView", "Unable to expand ad. No Activity found.");
                    Uri h = aVar.mo7160h();
                    if (h != null && ((Boolean) AdViewControllerImpl.this.f4684c.mo8549a(C1841c.f5949cr)).booleanValue()) {
                        AdViewControllerImpl.this.f4685d.trackAndLaunchClick(aVar, AdViewControllerImpl.this.getParentView(), AdViewControllerImpl.this, h, pointF);
                        if (AdViewControllerImpl.this.f4690i != null) {
                            AdViewControllerImpl.this.f4690i.mo8361b();
                        }
                    }
                    AdViewControllerImpl.this.f4693l.mo7372a("javascript:al_onFailedExpand();");
                }
            }
        });
    }

    public AppLovinAdViewEventListener getAdViewEventListener() {
        return this.f4705x;
    }

    public C1548c getAdWebView() {
        return this.f4693l;
    }

    public String getCommunicatorId() {
        return AdViewControllerImpl.class.getSimpleName();
    }

    public C1827g getCurrentAd() {
        return this.f4696o;
    }

    public AppLovinAdView getParentView() {
        return (AppLovinAdView) this.f4683b;
    }

    public C1941j getSdk() {
        return this.f4684c;
    }

    public AppLovinAdSize getSize() {
        return this.f4688g;
    }

    public String getZoneId() {
        return this.f4689h;
    }

    public void initializeAdView(AppLovinAdView appLovinAdView, Context context, AppLovinAdSize appLovinAdSize, String str, AppLovinSdk appLovinSdk, AttributeSet attributeSet) {
        if (appLovinAdView == null) {
            throw new IllegalArgumentException("No parent view specified");
        } else if (context == null) {
            C1977q.m7751i("AppLovinAdView", "Unable to build AppLovinAdView: no context provided. Please use a different constructor for this view.");
        } else {
            if (appLovinAdSize == null && (appLovinAdSize = C1985b.m7816a(attributeSet)) == null) {
                appLovinAdSize = AppLovinAdSize.BANNER;
            }
            AppLovinAdSize appLovinAdSize2 = appLovinAdSize;
            if (appLovinSdk == null) {
                appLovinSdk = AppLovinSdk.getInstance(context);
            }
            if (appLovinSdk != null && !appLovinSdk.hasCriticalErrors()) {
                m5816a(appLovinAdView, C2029r.m7993a(appLovinSdk), appLovinAdSize2, str, context);
                if (C1985b.m7819b(attributeSet)) {
                    loadNextAd();
                }
            }
        }
    }

    public boolean isAdReadyToDisplay() {
        return !TextUtils.isEmpty(this.f4689h) ? this.f4685d.hasPreloadedAdForZoneId(this.f4689h) : this.f4685d.hasPreloadedAd(this.f4688g);
    }

    public void loadNextAd() {
        if (this.f4684c == null || this.f4692k == null || this.f4682a == null || !this.f4701t) {
            C1977q.m7749g("AppLovinAdView", "Unable to load next ad: AppLovinAdView is not initialized.");
        } else {
            this.f4685d.loadNextAd(this.f4689h, this.f4688g, this.f4692k);
        }
    }

    public void onAdHtmlLoaded(WebView webView) {
        webView.setVisibility(0);
        try {
            if (this.f4696o != this.f4697p && this.f4704w != null) {
                this.f4697p = this.f4696o;
                C1994j.m7914a(this.f4704w, (AppLovinAd) this.f4696o);
                this.f4684c.mo8571ag().mo8619a((Object) this.f4696o);
                this.f4693l.mo7372a("javascript:al_onAdViewRendered();");
            }
        } catch (Throwable th) {
            C1977q.m7747c("AppLovinAdView", "Exception while notifying ad display listener", th);
        }
    }

    public void onAttachedToWindow() {
        if (C1985b.m7818a((View) this.f4693l)) {
            this.f4684c.mo8534M().mo8387a(C1859g.f6198m);
        }
    }

    public void onDetachedFromWindow() {
        if (this.f4701t) {
            C1994j.m7925b(this.f4704w, (AppLovinAd) this.f4696o);
            this.f4684c.mo8571ag().mo8620b(this.f4696o);
            if (this.f4693l == null || this.f4698q == null) {
                this.f4686e.mo8742b("AppLovinAdView", "onDetachedFromWindowCalled without an expanded ad present");
                return;
            }
            this.f4686e.mo8742b("AppLovinAdView", "onDetachedFromWindowCalled with expanded ad present");
            if (((Boolean) this.f4684c.mo8549a(C1841c.f5941cj)).booleanValue()) {
                contractAd();
            } else {
                m5823c();
            }
        }
    }

    public void onMessageReceived(AppLovinCommunicatorMessage appLovinCommunicatorMessage) {
        if ("crash_applovin_ad_webview".equals(appLovinCommunicatorMessage.getTopic())) {
            m5817a((Runnable) new Runnable() {
                public void run() {
                    AdViewControllerImpl.this.getAdWebView().loadUrl("chrome://crash");
                }
            });
        }
    }

    public void pause() {
        if (this.f4701t && !this.f4702u) {
            this.f4702u = true;
        }
    }

    public void renderAd(AppLovinAd appLovinAd) {
        renderAd(appLovinAd, (String) null);
    }

    public void renderAd(AppLovinAd appLovinAd, String str) {
        if (appLovinAd != null) {
            C2029r.m8027b(appLovinAd, this.f4684c);
            if (this.f4701t) {
                C1827g gVar = (C1827g) C2029r.m7994a(appLovinAd, this.f4684c);
                if (gVar != null && gVar != this.f4696o) {
                    C1977q qVar = this.f4686e;
                    qVar.mo8742b("AppLovinAdView", "Rendering ad #" + gVar.getAdIdNumber() + " (" + gVar.getSize() + ")");
                    C1994j.m7925b(this.f4704w, (AppLovinAd) this.f4696o);
                    this.f4684c.mo8571ag().mo8620b(this.f4696o);
                    if (gVar.getSize() != AppLovinAdSize.INTERSTITIAL) {
                        m5827e();
                    }
                    this.f4700s.set((Object) null);
                    this.f4697p = null;
                    this.f4696o = gVar;
                    if (!this.f4702u && C2029r.m8019a(this.f4688g)) {
                        this.f4684c.mo8594o().trackImpression(gVar);
                    }
                    if (this.f4698q != null) {
                        if (((Boolean) this.f4684c.mo8549a(C1841c.f5940ci)).booleanValue()) {
                            m5825d();
                            this.f4686e.mo8742b("AppLovinAdView", "Fade out the old ad scheduled");
                        } else {
                            m5823c();
                        }
                    }
                    m5817a(this.f4694m);
                } else if (gVar == null) {
                    this.f4686e.mo8745d("AppLovinAdView", "Unable to render ad. Ad is null. Internal inconsistency error.");
                } else {
                    C1977q qVar2 = this.f4686e;
                    qVar2.mo8745d("AppLovinAdView", "Ad #" + gVar.getAdIdNumber() + " is already showing, ignoring");
                    if (((Boolean) this.f4684c.mo8549a(C1841c.f5950cs)).booleanValue()) {
                        throw new IllegalStateException("Failed to display ad - ad can only be displayed once. Load the next ad.");
                    }
                }
            } else {
                C1977q.m7749g("AppLovinAdView", "Unable to render ad: AppLovinAdView is not initialized.");
            }
        } else {
            throw new IllegalArgumentException("No ad specified");
        }
    }

    public void resume() {
        if (this.f4701t) {
            AppLovinAd andSet = this.f4700s.getAndSet((Object) null);
            if (andSet != null) {
                renderAd(andSet);
            }
            this.f4702u = false;
        }
    }

    public void setAdClickListener(AppLovinAdClickListener appLovinAdClickListener) {
        this.f4706y = appLovinAdClickListener;
    }

    public void setAdDisplayListener(AppLovinAdDisplayListener appLovinAdDisplayListener) {
        this.f4704w = appLovinAdDisplayListener;
    }

    public void setAdLoadListener(AppLovinAdLoadListener appLovinAdLoadListener) {
        this.f4703v = appLovinAdLoadListener;
    }

    public void setAdViewEventListener(AppLovinAdViewEventListener appLovinAdViewEventListener) {
        this.f4705x = appLovinAdViewEventListener;
    }

    public void setStatsManagerHelper(C1854d dVar) {
        C1548c cVar = this.f4693l;
        if (cVar != null) {
            cVar.setStatsManagerHelper(dVar);
        }
    }
}
