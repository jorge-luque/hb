package com.applovin.impl.adview.p034a.p036b;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.applovin.adview.AppLovinAdView;
import com.applovin.adview.AppLovinFullscreenActivity;
import com.applovin.impl.adview.AdViewControllerImpl;
import com.applovin.impl.adview.C1548c;
import com.applovin.impl.adview.C1578l;
import com.applovin.impl.adview.C1579m;
import com.applovin.impl.adview.p034a.C1516a;
import com.applovin.impl.sdk.AppLovinBroadcastManager;
import com.applovin.impl.sdk.C1924e;
import com.applovin.impl.sdk.C1941j;
import com.applovin.impl.sdk.C1977q;
import com.applovin.impl.sdk.p048a.C1805b;
import com.applovin.impl.sdk.p049ad.C1827g;
import com.applovin.impl.sdk.p050b.C1841c;
import com.applovin.impl.sdk.p051c.C1854d;
import com.applovin.impl.sdk.p052d.C1864a;
import com.applovin.impl.sdk.p052d.C1871ad;
import com.applovin.impl.sdk.p052d.C1907s;
import com.applovin.impl.sdk.p052d.C1923z;
import com.applovin.impl.sdk.utils.AppKilledService;
import com.applovin.impl.sdk.utils.C1984a;
import com.applovin.impl.sdk.utils.C1994j;
import com.applovin.impl.sdk.utils.C2025o;
import com.applovin.impl.sdk.utils.C2026p;
import com.applovin.impl.sdk.utils.C2029r;
import com.applovin.impl.sdk.utils.C2030s;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdClickListener;
import com.applovin.sdk.AppLovinAdDisplayListener;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinAdType;
import com.applovin.sdk.AppLovinAdVideoPlaybackListener;
import com.applovin.sdk.AppLovinSdkUtils;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.applovin.impl.adview.a.b.a */
public abstract class C1520a implements C1805b.C1813a {

    /* renamed from: a */
    protected final C1827g f4782a;

    /* renamed from: b */
    protected final C1941j f4783b;

    /* renamed from: c */
    protected final C1977q f4784c;

    /* renamed from: d */
    protected final AppLovinFullscreenActivity f4785d;

    /* renamed from: e */
    protected final C1854d f4786e;

    /* renamed from: f */
    protected final AppLovinAdView f4787f;

    /* renamed from: g */
    protected final C1578l f4788g;

    /* renamed from: h */
    protected final long f4789h = SystemClock.elapsedRealtime();

    /* renamed from: i */
    protected long f4790i = -1;

    /* renamed from: j */
    protected int f4791j = C1924e.f6359a;

    /* renamed from: k */
    protected boolean f4792k;

    /* renamed from: l */
    protected final AppLovinAdClickListener f4793l;

    /* renamed from: m */
    protected final AppLovinAdDisplayListener f4794m;

    /* renamed from: n */
    protected final AppLovinAdVideoPlaybackListener f4795n;

    /* renamed from: o */
    protected final C1805b f4796o;

    /* renamed from: p */
    protected C2026p f4797p;

    /* renamed from: q */
    private final Handler f4798q = new Handler(Looper.getMainLooper());

    /* renamed from: r */
    private final C1984a f4799r;
    /* access modifiers changed from: private */

    /* renamed from: s */
    public final AppLovinBroadcastManager.Receiver f4800s;

    /* renamed from: t */
    private final C1924e.C1926a f4801t;

    /* renamed from: u */
    private final AtomicBoolean f4802u = new AtomicBoolean();
    /* access modifiers changed from: private */

    /* renamed from: v */
    public final AtomicBoolean f4803v = new AtomicBoolean();

    /* renamed from: w */
    private long f4804w;

    /* renamed from: com.applovin.impl.adview.a.b.a$a */
    private class C1532a implements View.OnClickListener, AppLovinAdClickListener {
        private C1532a() {
        }

        public void adClicked(AppLovinAd appLovinAd) {
            C1520a.this.f4784c.mo8742b("InterActivityV2", "Clicking through graphic");
            C1994j.m7913a(C1520a.this.f4793l, appLovinAd);
            C1520a.this.f4786e.mo8361b();
        }

        public void onClick(View view) {
            C1520a aVar = C1520a.this;
            if (view == aVar.f4788g) {
                if (aVar.f4782a.mo8249ac()) {
                    C1520a.this.mo7311b("javascript:al_onCloseButtonTapped();");
                }
                C1520a.this.mo7317f();
                return;
            }
            C1977q qVar = aVar.f4784c;
            qVar.mo8746e("InterActivityV2", "Unhandled click on widget: " + view);
        }
    }

    C1520a(C1827g gVar, AppLovinFullscreenActivity appLovinFullscreenActivity, final C1941j jVar, AppLovinAdClickListener appLovinAdClickListener, AppLovinAdDisplayListener appLovinAdDisplayListener, AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener) {
        this.f4782a = gVar;
        this.f4783b = jVar;
        this.f4784c = jVar.mo8602v();
        this.f4785d = appLovinFullscreenActivity;
        this.f4793l = appLovinAdClickListener;
        this.f4794m = appLovinAdDisplayListener;
        this.f4795n = appLovinAdVideoPlaybackListener;
        C1805b bVar = new C1805b(appLovinFullscreenActivity, jVar);
        this.f4796o = bVar;
        bVar.mo8090a((C1805b.C1813a) this);
        this.f4786e = new C1854d(gVar, jVar);
        C1532a aVar = new C1532a();
        C1579m mVar = new C1579m(jVar.mo8540S(), AppLovinAdSize.INTERSTITIAL, appLovinFullscreenActivity);
        this.f4787f = mVar;
        mVar.setAdClickListener(aVar);
        this.f4787f.setAdDisplayListener(new AppLovinAdDisplayListener() {
            public void adDisplayed(AppLovinAd appLovinAd) {
                C1520a.this.f4784c.mo8742b("InterActivityV2", "Web content rendered");
            }

            public void adHidden(AppLovinAd appLovinAd) {
                C1520a.this.f4784c.mo8742b("InterActivityV2", "Closing from WebView");
                C1520a.this.mo7317f();
            }
        });
        AdViewControllerImpl adViewControllerImpl = (AdViewControllerImpl) this.f4787f.getAdViewController();
        adViewControllerImpl.setStatsManagerHelper(this.f4786e);
        adViewControllerImpl.getAdWebView().setIsShownOutOfContext(gVar.mo8268av());
        jVar.mo8594o().trackImpression(gVar);
        if (gVar.mo8281r() >= 0) {
            C1578l lVar = new C1578l(gVar.mo8282s(), appLovinFullscreenActivity);
            this.f4788g = lVar;
            lVar.setVisibility(8);
            this.f4788g.setOnClickListener(aVar);
        } else {
            this.f4788g = null;
        }
        if (((Boolean) jVar.mo8549a(C1841c.f5924cS)).booleanValue()) {
            Intent intent = new Intent(appLovinFullscreenActivity.getApplicationContext(), AppKilledService.class);
            final C1941j jVar2 = jVar;
            final C1827g gVar2 = gVar;
            final AppLovinFullscreenActivity appLovinFullscreenActivity2 = appLovinFullscreenActivity;
            final Intent intent2 = intent;
            this.f4800s = new AppLovinBroadcastManager.Receiver() {
                public void onReceive(Context context, Intent intent, Map<String, Object> map) {
                    jVar2.mo8594o().trackAppKilled(gVar2);
                    appLovinFullscreenActivity2.stopService(intent2);
                    jVar2.mo8570af().unregisterReceiver(this);
                }
            };
            jVar.mo8570af().registerReceiver(this.f4800s, new IntentFilter(AppKilledService.ACTION_APP_KILLED));
            appLovinFullscreenActivity.startService(intent);
        } else {
            this.f4800s = null;
        }
        if (gVar.mo8267au()) {
            this.f4801t = new C1924e.C1926a() {
                public void onRingerModeChanged(int i) {
                    String str;
                    C1520a aVar = C1520a.this;
                    if (aVar.f4791j != C1924e.f6359a) {
                        aVar.f4792k = true;
                    }
                    C1548c adWebView = ((AdViewControllerImpl) C1520a.this.f4787f.getAdViewController()).getAdWebView();
                    if (!C1924e.m7397a(i) || C1924e.m7397a(C1520a.this.f4791j)) {
                        if (i == 2) {
                            str = "javascript:al_muteSwitchOff();";
                        }
                        C1520a.this.f4791j = i;
                    }
                    str = "javascript:al_muteSwitchOn();";
                    adWebView.mo7372a(str);
                    C1520a.this.f4791j = i;
                }
            };
            jVar.mo8569ae().mo8501a(this.f4801t);
        } else {
            this.f4801t = null;
        }
        if (((Boolean) jVar.mo8549a(C1841c.f6027eR)).booleanValue()) {
            this.f4799r = new C1984a() {
                public void onActivityCreated(Activity activity, Bundle bundle) {
                    if (!C1520a.this.f4803v.get()) {
                        if (activity.getClass().getName().equals(C2029r.m8032c(activity.getApplicationContext()))) {
                            jVar.mo8533L().mo8475a((C1864a) new C1871ad(jVar, new Runnable() {
                                public void run() {
                                    C1977q.m7751i("InterActivityV2", "Dismissing on-screen ad due to app relaunched via launcher.");
                                    C1520a.this.mo7317f();
                                }
                            }), C1907s.C1909a.MAIN);
                        }
                    }
                }
            };
            jVar.mo8565aa().mo8071a(this.f4799r);
            return;
        }
        this.f4799r = null;
    }

    /* renamed from: a */
    public void mo7301a(int i, KeyEvent keyEvent) {
        C1977q qVar = this.f4784c;
        qVar.mo8744c("InterActivityV2", "onKeyDown(int, KeyEvent) -  " + i + ", " + keyEvent);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo7302a(int i, boolean z, boolean z2, long j) {
        int i2 = i;
        if (this.f4802u.compareAndSet(false, true)) {
            if (this.f4782a.hasVideoUrl() || mo7322k()) {
                C1994j.m7919a(this.f4795n, this.f4782a, (double) i2, z2);
            }
            if (this.f4782a.hasVideoUrl()) {
                this.f4786e.mo8364c((long) i2);
            }
            long elapsedRealtime = SystemClock.elapsedRealtime() - this.f4789h;
            this.f4783b.mo8594o().trackVideoEnd(this.f4782a, TimeUnit.MILLISECONDS.toSeconds(elapsedRealtime), i, z);
            long j2 = -1;
            if (this.f4790i != -1) {
                j2 = SystemClock.elapsedRealtime() - this.f4790i;
            }
            this.f4783b.mo8594o().trackFullScreenAdClosed(this.f4782a, j2, j, this.f4792k, this.f4791j);
            C1977q qVar = this.f4784c;
            qVar.mo8742b("InterActivityV2", "Video ad ended at percent: " + i2 + "%, elapsedTime: " + elapsedRealtime + "ms, skipTimeMillis: " + j + "ms, closeTimeMillis: " + j2 + "ms");
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo7303a(long j) {
        C1977q qVar = this.f4784c;
        qVar.mo8742b("InterActivityV2", "Scheduling report reward in " + TimeUnit.MILLISECONDS.toSeconds(j) + " seconds...");
        this.f4797p = C2026p.m7968a(j, this.f4783b, new Runnable() {
            public void run() {
                if (!C1520a.this.f4782a.mo8262ap().getAndSet(true)) {
                    C1520a aVar = C1520a.this;
                    C1520a.this.f4783b.mo8533L().mo8475a((C1864a) new C1923z(aVar.f4782a, aVar.f4783b), C1907s.C1909a.REWARD);
                }
            }
        });
    }

    /* renamed from: a */
    public void mo7304a(Configuration configuration) {
        C1977q qVar = this.f4784c;
        qVar.mo8744c("InterActivityV2", "onConfigurationChanged(Configuration) -  " + configuration);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo7305a(final C1578l lVar, long j, final Runnable runnable) {
        this.f4783b.mo8533L().mo8477a((C1864a) new C1871ad(this.f4783b, new Runnable() {
            public void run() {
                AppLovinSdkUtils.runOnUiThread(new Runnable() {
                    public void run() {
                        C2030s.m8041a((View) lVar, 400, (Runnable) new Runnable() {
                            public void run() {
                                runnable.run();
                            }
                        });
                    }
                });
            }
        }), C1907s.C1909a.MAIN, TimeUnit.SECONDS.toMillis(j), true);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo7306a(Runnable runnable, long j) {
        AppLovinSdkUtils.runOnUiThreadDelayed(runnable, j, this.f4798q);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo7307a(String str) {
        if (this.f4782a.mo8251ae()) {
            mo7308a(str, 0);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo7308a(final String str, long j) {
        if (j >= 0) {
            mo7306a((Runnable) new Runnable() {
                public void run() {
                    C1548c adWebView;
                    if (C2025o.m7963b(str) && (adWebView = ((AdViewControllerImpl) C1520a.this.f4787f.getAdViewController()).getAdWebView()) != null) {
                        adWebView.mo7372a(str);
                    }
                }
            }, j);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo7309a(boolean z) {
        List<Uri> a = C2029r.m8006a(z, this.f4782a, this.f4783b, (Context) this.f4785d);
        if (a.isEmpty()) {
            return;
        }
        if (!((Boolean) this.f4783b.mo8549a(C1841c.f6062fa)).booleanValue()) {
            this.f4782a.mo7144a();
            return;
        }
        throw new IllegalStateException("Missing cached resource(s): " + a);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo7310a(boolean z, long j) {
        if (this.f4782a.mo8248ab()) {
            mo7308a(z ? "javascript:al_mute();" : "javascript:al_unmute();", j);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo7311b(String str) {
        mo7308a(str, 0);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo7312b(boolean z) {
        mo7310a(z, ((Long) this.f4783b.mo8549a(C1841c.f5994dk)).longValue());
        C1994j.m7914a(this.f4794m, (AppLovinAd) this.f4782a);
        this.f4783b.mo8547Z().mo8731a((Object) this.f4782a);
        if (this.f4782a.hasVideoUrl() || mo7322k()) {
            C1994j.m7918a(this.f4795n, (AppLovinAd) this.f4782a);
        }
        new C1516a(this.f4785d).mo7296a(this.f4782a);
        this.f4786e.mo8359a();
        this.f4782a.setHasShown(true);
    }

    /* renamed from: c */
    public abstract void mo7313c();

    /* renamed from: c */
    public void mo7314c(boolean z) {
        C1977q qVar = this.f4784c;
        qVar.mo8744c("InterActivityV2", "onWindowFocusChanged(boolean) - " + z);
        mo7307a("javascript:al_onWindowFocusChanged( " + z + " );");
    }

    /* renamed from: d */
    public void mo7315d() {
        this.f4784c.mo8744c("InterActivityV2", "onResume()");
        this.f4786e.mo8366d(SystemClock.elapsedRealtime() - this.f4804w);
        mo7307a("javascript:al_onAppResumed();");
        mo7326o();
        if (this.f4796o.mo8093d()) {
            this.f4796o.mo8089a();
        }
    }

    /* renamed from: e */
    public void mo7316e() {
        this.f4784c.mo8744c("InterActivityV2", "onPause()");
        this.f4804w = SystemClock.elapsedRealtime();
        mo7307a("javascript:al_onAppPaused();");
        this.f4796o.mo8089a();
        mo7325n();
    }

    /* renamed from: f */
    public void mo7317f() {
        this.f4784c.mo8744c("InterActivityV2", "dismiss()");
        this.f4798q.removeCallbacksAndMessages((Object) null);
        mo7308a("javascript:al_onPoststitialDismiss();", (long) this.f4782a.mo8247aa());
        mo7324m();
        this.f4786e.mo8363c();
        if (this.f4800s != null) {
            C2026p.m7968a(TimeUnit.SECONDS.toMillis(2), this.f4783b, new Runnable() {
                public void run() {
                    C1520a.this.f4785d.stopService(new Intent(C1520a.this.f4785d.getApplicationContext(), AppKilledService.class));
                    C1520a.this.f4783b.mo8570af().unregisterReceiver(C1520a.this.f4800s);
                }
            });
        }
        if (this.f4801t != null) {
            this.f4783b.mo8569ae().mo8502b(this.f4801t);
        }
        if (this.f4799r != null) {
            this.f4783b.mo8565aa().mo8073b(this.f4799r);
        }
        this.f4785d.finish();
    }

    /* renamed from: g */
    public void mo7318g() {
        this.f4784c.mo8744c("InterActivityV2", "onStop()");
    }

    /* renamed from: h */
    public void mo7319h() {
        AppLovinAdView appLovinAdView = this.f4787f;
        if (appLovinAdView != null) {
            ViewParent parent = appLovinAdView.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeAllViews();
            }
            this.f4787f.destroy();
        }
        mo7323l();
        mo7324m();
    }

    /* renamed from: i */
    public void mo7320i() {
        C1977q.m7751i("InterActivityV2", "---low memory detected - running garbage collection---");
        System.gc();
    }

    /* renamed from: j */
    public void mo7321j() {
        this.f4784c.mo8744c("InterActivityV2", "onBackPressed()");
        if (this.f4782a.mo8249ac()) {
            mo7311b("javascript:onBackPressed();");
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: k */
    public boolean mo7322k() {
        return this.f4782a.getType() == AppLovinAdType.INCENTIVIZED;
    }

    /* access modifiers changed from: protected */
    /* renamed from: l */
    public abstract void mo7323l();

    /* access modifiers changed from: protected */
    /* renamed from: m */
    public void mo7324m() {
        if (this.f4803v.compareAndSet(false, true)) {
            C1994j.m7925b(this.f4794m, (AppLovinAd) this.f4782a);
            this.f4783b.mo8547Z().mo8734b((Object) this.f4782a);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: n */
    public void mo7325n() {
        C2026p pVar = this.f4797p;
        if (pVar != null) {
            pVar.mo8812b();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: o */
    public void mo7326o() {
        C2026p pVar = this.f4797p;
        if (pVar != null) {
            pVar.mo8813c();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: p */
    public abstract boolean mo7327p();

    /* access modifiers changed from: protected */
    /* renamed from: q */
    public abstract void mo7328q();

    /* access modifiers changed from: protected */
    /* renamed from: r */
    public boolean mo7329r() {
        return ((Boolean) this.f4783b.mo8549a(C1841c.f5930cY)).booleanValue() ? this.f4783b.mo8591l().isMuted() : ((Boolean) this.f4783b.mo8549a(C1841c.f5928cW)).booleanValue();
    }
}
