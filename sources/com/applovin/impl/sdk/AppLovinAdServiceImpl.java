package com.applovin.impl.sdk;

import android.graphics.PointF;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.StrictMode;
import android.text.TextUtils;
import com.applovin.adview.AppLovinAdView;
import com.applovin.impl.adview.AdViewControllerImpl;
import com.applovin.impl.sdk.network.C1968f;
import com.applovin.impl.sdk.p049ad.C1821d;
import com.applovin.impl.sdk.p049ad.C1827g;
import com.applovin.impl.sdk.p049ad.C1833h;
import com.applovin.impl.sdk.p049ad.NativeAdImpl;
import com.applovin.impl.sdk.p051c.C1846a;
import com.applovin.impl.sdk.p052d.C1864a;
import com.applovin.impl.sdk.p052d.C1895l;
import com.applovin.impl.sdk.p052d.C1896m;
import com.applovin.impl.sdk.p052d.C1907s;
import com.applovin.impl.sdk.utils.C1989e;
import com.applovin.impl.sdk.utils.C1994j;
import com.applovin.impl.sdk.utils.C2025o;
import com.applovin.impl.sdk.utils.C2029r;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.applovin.sdk.AppLovinAdService;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinAdType;
import com.applovin.sdk.AppLovinAdUpdateListener;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class AppLovinAdServiceImpl implements AppLovinAdService {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final C1941j f5500a;

    /* renamed from: b */
    private final C1977q f5501b;

    /* renamed from: c */
    private final Handler f5502c = new Handler(Looper.getMainLooper());

    /* renamed from: d */
    private final Map<C1821d, C1784b> f5503d;

    /* renamed from: e */
    private final Object f5504e = new Object();

    /* renamed from: com.applovin.impl.sdk.AppLovinAdServiceImpl$a */
    private class C1783a implements AppLovinAdLoadListener {

        /* renamed from: b */
        private final C1784b f5512b;

        private C1783a(C1784b bVar) {
            this.f5512b = bVar;
        }

        public void adReceived(AppLovinAd appLovinAd) {
            HashSet<AppLovinAdLoadListener> hashSet;
            C1821d adZone = ((AppLovinAdBase) appLovinAd).getAdZone();
            if (!(appLovinAd instanceof C1833h)) {
                AppLovinAdServiceImpl.this.f5500a.mo8541T().adReceived(appLovinAd);
                appLovinAd = new C1833h(adZone, AppLovinAdServiceImpl.this.f5500a);
            }
            synchronized (this.f5512b.f5513a) {
                hashSet = new HashSet<>(this.f5512b.f5515c);
                this.f5512b.f5515c.clear();
                this.f5512b.f5514b = false;
            }
            for (AppLovinAdLoadListener a : hashSet) {
                AppLovinAdServiceImpl.this.m6731a(appLovinAd, a);
            }
        }

        public void failedToReceiveAd(int i) {
            HashSet<AppLovinAdLoadListener> hashSet;
            synchronized (this.f5512b.f5513a) {
                hashSet = new HashSet<>(this.f5512b.f5515c);
                this.f5512b.f5515c.clear();
                this.f5512b.f5514b = false;
            }
            for (AppLovinAdLoadListener a : hashSet) {
                AppLovinAdServiceImpl.this.m6723a(i, a);
            }
        }
    }

    /* renamed from: com.applovin.impl.sdk.AppLovinAdServiceImpl$b */
    private static class C1784b {

        /* renamed from: a */
        final Object f5513a;

        /* renamed from: b */
        boolean f5514b;

        /* renamed from: c */
        final Collection<AppLovinAdLoadListener> f5515c;

        private C1784b() {
            this.f5513a = new Object();
            this.f5515c = new HashSet();
        }

        public String toString() {
            return "AdLoadState{, isWaitingForAd=" + this.f5514b + ", pendingAdListeners=" + this.f5515c + '}';
        }
    }

    AppLovinAdServiceImpl(C1941j jVar) {
        this.f5500a = jVar;
        this.f5501b = jVar.mo8602v();
        HashMap hashMap = new HashMap(5);
        this.f5503d = hashMap;
        hashMap.put(C1821d.m6865b(jVar), new C1784b());
        this.f5503d.put(C1821d.m6867c(jVar), new C1784b());
        this.f5503d.put(C1821d.m6868d(jVar), new C1784b());
        this.f5503d.put(C1821d.m6869e(jVar), new C1784b());
        this.f5503d.put(C1821d.m6870f(jVar), new C1784b());
    }

    /* renamed from: a */
    private C1784b m6719a(C1821d dVar) {
        C1784b bVar;
        synchronized (this.f5504e) {
            bVar = this.f5503d.get(dVar);
            if (bVar == null) {
                bVar = new C1784b();
                this.f5503d.put(dVar, bVar);
            }
        }
        return bVar;
    }

    /* renamed from: a */
    private String m6721a(String str, long j, int i, String str2, boolean z) {
        try {
            if (!C2025o.m7963b(str)) {
                return null;
            }
            if (i < 0 || i > 100) {
                i = 0;
            }
            return Uri.parse(str).buildUpon().appendQueryParameter("et_s", Long.toString(j)).appendQueryParameter(NativeAdImpl.QUERY_PARAM_VIDEO_PERCENT_VIEWED, Integer.toString(i)).appendQueryParameter("vid_ts", str2).appendQueryParameter("uvs", Boolean.toString(z)).build().toString();
        } catch (Throwable th) {
            C1977q qVar = this.f5501b;
            qVar.mo8743b("AppLovinAdService", "Unknown error parsing the video end url: " + str, th);
            return null;
        }
    }

    /* renamed from: a */
    private String m6722a(String str, long j, long j2, boolean z, int i) {
        if (!C2025o.m7963b(str)) {
            return null;
        }
        Uri.Builder appendQueryParameter = Uri.parse(str).buildUpon().appendQueryParameter("et_ms", Long.toString(j)).appendQueryParameter("vs_ms", Long.toString(j2));
        if (i != C1924e.f6359a) {
            appendQueryParameter.appendQueryParameter("musw_ch", Boolean.toString(z));
            appendQueryParameter.appendQueryParameter("musw_st", Boolean.toString(C1924e.m7397a(i)));
        }
        return appendQueryParameter.build().toString();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m6723a(final int i, final AppLovinAdLoadListener appLovinAdLoadListener) {
        this.f5502c.post(new Runnable() {
            public void run() {
                try {
                    appLovinAdLoadListener.failedToReceiveAd(i);
                } catch (Throwable th) {
                    C1977q.m7747c("AppLovinAdService", "Unable to notify listener about ad load failure", th);
                }
            }
        });
    }

    /* renamed from: a */
    private void m6724a(Uri uri, C1827g gVar, AppLovinAdView appLovinAdView, AdViewControllerImpl adViewControllerImpl) {
        if (appLovinAdView != null) {
            if (C2029r.m8016a(appLovinAdView.getContext(), uri, this.f5500a)) {
                C1994j.m7927c(adViewControllerImpl.getAdViewEventListener(), (AppLovinAd) gVar, appLovinAdView);
            }
            adViewControllerImpl.dismissInterstitialIfRequired();
            return;
        }
        this.f5501b.mo8746e("AppLovinAdService", "Unable to launch click - adView has been prematurely destroyed");
    }

    /* renamed from: a */
    private void m6727a(C1821d dVar, C1783a aVar) {
        AppLovinAd appLovinAd = (AppLovinAd) this.f5500a.mo8541T().mo8335e(dVar);
        if (appLovinAd != null) {
            C1977q qVar = this.f5501b;
            qVar.mo8742b("AppLovinAdService", "Using pre-loaded ad: " + appLovinAd + " for " + dVar);
            this.f5500a.mo8544W().mo8188a((AppLovinAdBase) appLovinAd, true, false);
            aVar.adReceived(appLovinAd);
            if (dVar.mo8185j() || dVar.mo8182h() > 0) {
                this.f5500a.mo8541T().mo8339i(dVar);
                return;
            }
            return;
        }
        m6730a((C1864a) new C1896m(dVar, aVar, this.f5500a));
    }

    /* renamed from: a */
    private void m6728a(C1821d dVar, AppLovinAdLoadListener appLovinAdLoadListener) {
        C1977q qVar;
        String str;
        String str2;
        if (dVar == null) {
            throw new IllegalArgumentException("No zone specified");
        } else if (appLovinAdLoadListener != null) {
            C1977q v = this.f5500a.mo8602v();
            v.mo8742b("AppLovinAdService", "Loading next ad of zone {" + dVar + "}...");
            C1784b a = m6719a(dVar);
            synchronized (a.f5513a) {
                a.f5515c.add(appLovinAdLoadListener);
                if (!a.f5514b) {
                    this.f5501b.mo8742b("AppLovinAdService", "Loading next ad...");
                    a.f5514b = true;
                    C1783a aVar = new C1783a(a);
                    if (!dVar.mo8184i()) {
                        this.f5501b.mo8742b("AppLovinAdService", "Task merge not necessary.");
                    } else if (this.f5500a.mo8541T().mo8330a(dVar, (AppLovinAdLoadListener) aVar)) {
                        qVar = this.f5501b;
                        str = "AppLovinAdService";
                        str2 = "Attaching load listener to initial preload task...";
                    } else {
                        this.f5501b.mo8742b("AppLovinAdService", "Skipped attach of initial preload callback.");
                    }
                    m6727a(dVar, aVar);
                } else {
                    qVar = this.f5501b;
                    str = "AppLovinAdService";
                    str2 = "Already waiting on an ad load...";
                }
                qVar.mo8742b(str, str2);
            }
        } else {
            throw new IllegalArgumentException("No callback specified");
        }
    }

    /* renamed from: a */
    private void m6729a(C1846a aVar) {
        if (C2025o.m7963b(aVar.mo8340a())) {
            this.f5500a.mo8535N().mo8678a(C1968f.m7656m().mo8703c(C2029r.m8025b(aVar.mo8340a())).mo8705d(C2025o.m7963b(aVar.mo8341b()) ? C2029r.m8025b(aVar.mo8341b()) : null).mo8702b(aVar.mo8342c()).mo8699a(false).mo8700a());
            return;
        }
        this.f5501b.mo8745d("AppLovinAdService", "Requested a postback dispatch for a null URL; nothing to do...");
    }

    /* renamed from: a */
    private void m6730a(C1864a aVar) {
        if (!this.f5500a.mo8583d()) {
            C1977q.m7750h("AppLovinSdk", "Attempted to load ad before SDK initialization. Please wait until after the SDK has initialized, e.g. AppLovinSdk.initializeSdk(Context, SdkInitializationListener).");
        }
        this.f5500a.mo8552a();
        this.f5500a.mo8533L().mo8475a(aVar, C1907s.C1909a.MAIN);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m6731a(final AppLovinAd appLovinAd, final AppLovinAdLoadListener appLovinAdLoadListener) {
        this.f5502c.post(new Runnable() {
            public void run() {
                try {
                    appLovinAdLoadListener.adReceived(appLovinAd);
                } catch (Throwable th) {
                    C1977q.m7747c("AppLovinAdService", "Unable to notify listener about a newly loaded ad", th);
                }
            }
        });
    }

    /* renamed from: a */
    private void m6732a(List<C1846a> list) {
        if (list != null && !list.isEmpty()) {
            for (C1846a a : list) {
                m6729a(a);
            }
        }
    }

    public void addAdUpdateListener(AppLovinAdUpdateListener appLovinAdUpdateListener) {
    }

    public void addAdUpdateListener(AppLovinAdUpdateListener appLovinAdUpdateListener, AppLovinAdSize appLovinAdSize) {
    }

    public AppLovinAd dequeueAd(C1821d dVar) {
        AppLovinAd appLovinAd = (AppLovinAd) this.f5500a.mo8541T().mo8334d(dVar);
        C1977q qVar = this.f5501b;
        qVar.mo8742b("AppLovinAdService", "Dequeued ad: " + appLovinAd + " for zone: " + dVar + "...");
        return appLovinAd;
    }

    public String getBidToken() {
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        String a = this.f5500a.mo8536O().mo8611a();
        StrictMode.setThreadPolicy(allowThreadDiskReads);
        return a;
    }

    public boolean hasPreloadedAd(AppLovinAdSize appLovinAdSize) {
        return this.f5500a.mo8541T().mo8337g(C1821d.m6857a(appLovinAdSize, AppLovinAdType.REGULAR, this.f5500a));
    }

    public boolean hasPreloadedAdForZoneId(String str) {
        if (TextUtils.isEmpty(str)) {
            C1977q.m7751i("AppLovinAdService", "Unable to check if ad is preloaded - invalid zone id");
            return false;
        }
        return this.f5500a.mo8541T().mo8337g(C1821d.m6859a(str, this.f5500a));
    }

    public void loadNextAd(AppLovinAdSize appLovinAdSize, AppLovinAdLoadListener appLovinAdLoadListener) {
        m6728a(C1821d.m6857a(appLovinAdSize, AppLovinAdType.REGULAR, this.f5500a), appLovinAdLoadListener);
    }

    public void loadNextAd(String str, AppLovinAdSize appLovinAdSize, AppLovinAdLoadListener appLovinAdLoadListener) {
        C1977q qVar = this.f5501b;
        qVar.mo8742b("AppLovinAdService", "Loading next ad of zone {" + str + "} with size " + appLovinAdSize);
        m6728a(C1821d.m6858a(appLovinAdSize, AppLovinAdType.REGULAR, str, this.f5500a), appLovinAdLoadListener);
    }

    /* JADX WARNING: type inference failed for: r11v22, types: [com.applovin.impl.sdk.d.o] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void loadNextAdForAdToken(java.lang.String r11, com.applovin.sdk.AppLovinAdLoadListener r12) {
        /*
            r10 = this;
            if (r11 == 0) goto L_0x0007
            java.lang.String r11 = r11.trim()
            goto L_0x0008
        L_0x0007:
            r11 = 0
        L_0x0008:
            boolean r0 = android.text.TextUtils.isEmpty(r11)
            r1 = -8
            java.lang.String r2 = "AppLovinAdService"
            if (r0 == 0) goto L_0x001a
            java.lang.String r11 = "Invalid ad token specified"
            com.applovin.impl.sdk.C1977q.m7751i(r2, r11)
            r10.m6723a((int) r1, (com.applovin.sdk.AppLovinAdLoadListener) r12)
            return
        L_0x001a:
            com.applovin.impl.sdk.ad.c r0 = new com.applovin.impl.sdk.ad.c
            com.applovin.impl.sdk.j r3 = r10.f5500a
            r0.<init>(r11, r3)
            com.applovin.impl.sdk.ad.c$a r11 = r0.mo8167b()
            com.applovin.impl.sdk.ad.c$a r3 = com.applovin.impl.sdk.p049ad.C1819c.C1820a.REGULAR
            if (r11 != r3) goto L_0x004b
            com.applovin.impl.sdk.q r11 = r10.f5501b
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = "Loading next ad for token: "
            r1.append(r3)
            r1.append(r0)
            java.lang.String r1 = r1.toString()
            r11.mo8742b(r2, r1)
            com.applovin.impl.sdk.d.o r11 = new com.applovin.impl.sdk.d.o
            com.applovin.impl.sdk.j r1 = r10.f5500a
            r11.<init>(r0, r12, r1)
        L_0x0046:
            r10.m6730a((com.applovin.impl.sdk.p052d.C1864a) r11)
            goto L_0x00f7
        L_0x004b:
            com.applovin.impl.sdk.ad.c$a r11 = r0.mo8167b()
            com.applovin.impl.sdk.ad.c$a r3 = com.applovin.impl.sdk.p049ad.C1819c.C1820a.AD_RESPONSE_JSON
            if (r11 != r3) goto L_0x00e0
            org.json.JSONObject r5 = r0.mo8169d()
            if (r5 == 0) goto L_0x00c9
            com.applovin.impl.sdk.j r11 = r10.f5500a
            com.applovin.impl.sdk.utils.C1992h.m7864g(r5, r11)
            com.applovin.impl.sdk.j r11 = r10.f5500a
            com.applovin.impl.sdk.utils.C1992h.m7858d(r5, r11)
            com.applovin.impl.sdk.j r11 = r10.f5500a
            com.applovin.impl.sdk.utils.C1992h.m7857c(r5, r11)
            org.json.JSONArray r11 = new org.json.JSONArray
            r11.<init>()
            com.applovin.impl.sdk.j r1 = r10.f5500a
            java.lang.String r3 = "ads"
            org.json.JSONArray r11 = com.applovin.impl.sdk.utils.C1993i.m7900b((org.json.JSONObject) r5, (java.lang.String) r3, (org.json.JSONArray) r11, (com.applovin.impl.sdk.C1941j) r1)
            int r11 = r11.length()
            if (r11 <= 0) goto L_0x00ad
            com.applovin.impl.sdk.q r11 = r10.f5501b
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = "Rendering ad for token: "
            r1.append(r3)
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            r11.mo8742b(r2, r0)
            com.applovin.impl.sdk.j r11 = r10.f5500a
            com.applovin.impl.sdk.ad.d r6 = com.applovin.impl.sdk.utils.C2029r.m7992a((org.json.JSONObject) r5, (com.applovin.impl.sdk.C1941j) r11)
            com.applovin.impl.sdk.ad.f$a r8 = new com.applovin.impl.sdk.ad.f$a
            com.applovin.impl.sdk.j r11 = r10.f5500a
            r8.<init>(r6, r12, r11)
            r11 = 1
            r8.mo8198a(r11)
            com.applovin.impl.sdk.d.t r11 = new com.applovin.impl.sdk.d.t
            com.applovin.impl.sdk.ad.b r7 = com.applovin.impl.sdk.p049ad.C1818b.DECODED_AD_TOKEN_JSON
            com.applovin.impl.sdk.j r9 = r10.f5500a
            r4 = r11
            r4.<init>(r5, r6, r7, r8, r9)
            goto L_0x0046
        L_0x00ad:
            com.applovin.impl.sdk.q r11 = r10.f5501b
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = "No ad returned from the server for token: "
            r1.append(r3)
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            r11.mo8746e(r2, r0)
            r11 = 204(0xcc, float:2.86E-43)
            r12.failedToReceiveAd(r11)
            goto L_0x00f7
        L_0x00c9:
            com.applovin.impl.sdk.q r11 = r10.f5501b
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Unable to retrieve ad response JSON from token: "
            r3.append(r4)
            r3.append(r0)
            java.lang.String r0 = r3.toString()
            r11.mo8746e(r2, r0)
            goto L_0x00f4
        L_0x00e0:
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r3 = "Invalid ad token specified: "
            r11.append(r3)
            r11.append(r0)
            java.lang.String r11 = r11.toString()
            com.applovin.impl.sdk.C1977q.m7751i(r2, r11)
        L_0x00f4:
            r12.failedToReceiveAd(r1)
        L_0x00f7:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.sdk.AppLovinAdServiceImpl.loadNextAdForAdToken(java.lang.String, com.applovin.sdk.AppLovinAdLoadListener):void");
    }

    public void loadNextAdForZoneId(String str, AppLovinAdLoadListener appLovinAdLoadListener) {
        if (!TextUtils.isEmpty(str)) {
            C1977q qVar = this.f5501b;
            qVar.mo8742b("AppLovinAdService", "Loading next ad of zone {" + str + "}");
            m6728a(C1821d.m6859a(str, this.f5500a), appLovinAdLoadListener);
            return;
        }
        throw new IllegalArgumentException("No zone id specified");
    }

    public void loadNextAdForZoneIds(List<String> list, AppLovinAdLoadListener appLovinAdLoadListener) {
        List<String> a = C1989e.m7833a(list);
        if (a == null || a.isEmpty()) {
            C1977q.m7751i("AppLovinAdService", "No zones were provided");
            m6723a(-7, appLovinAdLoadListener);
            return;
        }
        C1977q qVar = this.f5501b;
        qVar.mo8742b("AppLovinAdService", "Loading next ad for zones: " + a);
        m6730a((C1864a) new C1895l(a, appLovinAdLoadListener, this.f5500a));
    }

    public void loadNextIncentivizedAd(String str, AppLovinAdLoadListener appLovinAdLoadListener) {
        C1977q qVar = this.f5501b;
        qVar.mo8742b("AppLovinAdService", "Loading next incentivized ad of zone {" + str + "}");
        m6728a(C1821d.m6866b(str, this.f5500a), appLovinAdLoadListener);
    }

    public void preloadAd(AppLovinAdSize appLovinAdSize) {
        this.f5500a.mo8552a();
        this.f5500a.mo8541T().mo8339i(C1821d.m6857a(appLovinAdSize, AppLovinAdType.REGULAR, this.f5500a));
    }

    public void preloadAdForZoneId(String str) {
        if (TextUtils.isEmpty(str)) {
            C1977q.m7751i("AppLovinAdService", "Unable to preload ad for invalid zone identifier");
            return;
        }
        C1821d a = C1821d.m6859a(str, this.f5500a);
        this.f5500a.mo8541T().mo8338h(a);
        this.f5500a.mo8541T().mo8339i(a);
    }

    public void preloadAds(C1821d dVar) {
        this.f5500a.mo8541T().mo8338h(dVar);
        int h = dVar.mo8182h();
        if (h == 0 && this.f5500a.mo8541T().mo8332b(dVar)) {
            h = 1;
        }
        this.f5500a.mo8541T().mo8331b(dVar, h);
    }

    public void removeAdUpdateListener(AppLovinAdUpdateListener appLovinAdUpdateListener, AppLovinAdSize appLovinAdSize) {
    }

    public String toString() {
        return "AppLovinAdService{adLoadStates=" + this.f5503d + '}';
    }

    public void trackAndLaunchClick(C1827g gVar, AppLovinAdView appLovinAdView, AdViewControllerImpl adViewControllerImpl, Uri uri, PointF pointF) {
        if (gVar == null) {
            this.f5501b.mo8746e("AppLovinAdService", "Unable to track ad view click. No ad specified");
            return;
        }
        this.f5501b.mo8742b("AppLovinAdService", "Tracking click on an ad...");
        m6732a(gVar.mo8228a(pointF));
        m6724a(uri, gVar, appLovinAdView, adViewControllerImpl);
    }

    public void trackAndLaunchVideoClick(C1827g gVar, AppLovinAdView appLovinAdView, Uri uri, PointF pointF) {
        if (gVar == null) {
            this.f5501b.mo8746e("AppLovinAdService", "Unable to track video click. No ad specified");
            return;
        }
        this.f5501b.mo8742b("AppLovinAdService", "Tracking VIDEO click on an ad...");
        m6732a(gVar.mo8272b(pointF));
        C2029r.m8016a(appLovinAdView.getContext(), uri, this.f5500a);
    }

    public void trackAppKilled(C1827g gVar) {
        if (gVar == null) {
            this.f5501b.mo8746e("AppLovinAdService", "Unable to track app killed. No ad specified");
            return;
        }
        this.f5501b.mo8742b("AppLovinAdService", "Tracking app killed during ad...");
        List<C1846a> ay = gVar.mo8271ay();
        if (ay == null || ay.isEmpty()) {
            C1977q qVar = this.f5501b;
            qVar.mo8745d("AppLovinAdService", "Unable to track app killed during AD #" + gVar.getAdIdNumber() + ". Missing app killed tracking URL.");
            return;
        }
        for (C1846a next : ay) {
            m6729a(new C1846a(next.mo8340a(), next.mo8341b()));
        }
    }

    public void trackFullScreenAdClosed(C1827g gVar, long j, long j2, boolean z, int i) {
        C1977q qVar = this.f5501b;
        if (gVar == null) {
            qVar.mo8746e("AppLovinAdService", "Unable to track ad closed. No ad specified.");
            return;
        }
        qVar.mo8742b("AppLovinAdService", "Tracking ad closed...");
        List<C1846a> ax = gVar.mo8270ax();
        if (ax == null || ax.isEmpty()) {
            C1977q qVar2 = this.f5501b;
            qVar2.mo8745d("AppLovinAdService", "Unable to track ad closed for AD #" + gVar.getAdIdNumber() + ". Missing ad close tracking URL." + gVar.getAdIdNumber());
            return;
        }
        for (C1846a next : ax) {
            long j3 = j;
            long j4 = j2;
            boolean z2 = z;
            int i2 = i;
            String a = m6722a(next.mo8340a(), j3, j4, z2, i2);
            String a2 = m6722a(next.mo8341b(), j3, j4, z2, i2);
            if (C2025o.m7963b(a)) {
                m6729a(new C1846a(a, a2));
            } else {
                C1977q qVar3 = this.f5501b;
                qVar3.mo8746e("AppLovinAdService", "Failed to parse url: " + next.mo8340a());
            }
        }
    }

    public void trackImpression(C1827g gVar) {
        if (gVar == null) {
            this.f5501b.mo8746e("AppLovinAdService", "Unable to track impression click. No ad specified");
            return;
        }
        this.f5501b.mo8742b("AppLovinAdService", "Tracking impression on ad...");
        m6732a(gVar.mo7151az());
        this.f5500a.mo8544W().mo8190a(gVar);
    }

    public void trackVideoEnd(C1827g gVar, long j, int i, boolean z) {
        C1977q qVar = this.f5501b;
        if (gVar == null) {
            qVar.mo8746e("AppLovinAdService", "Unable to track video end. No ad specified");
            return;
        }
        qVar.mo8742b("AppLovinAdService", "Tracking video end on ad...");
        List<C1846a> aw = gVar.mo8269aw();
        if (aw == null || aw.isEmpty()) {
            C1977q qVar2 = this.f5501b;
            qVar2.mo8745d("AppLovinAdService", "Unable to submit persistent postback for AD #" + gVar.getAdIdNumber() + ". Missing video end tracking URL.");
            return;
        }
        String l = Long.toString(System.currentTimeMillis());
        for (C1846a next : aw) {
            if (C2025o.m7963b(next.mo8340a())) {
                long j2 = j;
                int i2 = i;
                String str = l;
                boolean z2 = z;
                String a = m6721a(next.mo8340a(), j2, i2, str, z2);
                String a2 = m6721a(next.mo8341b(), j2, i2, str, z2);
                if (a != null) {
                    m6729a(new C1846a(a, a2));
                } else {
                    C1977q qVar3 = this.f5501b;
                    qVar3.mo8746e("AppLovinAdService", "Failed to parse url: " + next.mo8340a());
                }
            } else {
                this.f5501b.mo8745d("AppLovinAdService", "Requested a postback dispatch for an empty video end URL; nothing to do...");
            }
        }
    }
}
