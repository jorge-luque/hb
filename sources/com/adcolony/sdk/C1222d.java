package com.adcolony.sdk;

import admost.sdk.base.AdMostZoneType;
import android.app.AlertDialog;
import android.content.Context;
import android.view.View;
import com.adcolony.sdk.C1439u;
import com.facebook.GraphResponse;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* renamed from: com.adcolony.sdk.d */
class C1222d {

    /* renamed from: a */
    private HashMap<String, C1205c> f3423a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public ConcurrentHashMap<String, AdColonyInterstitial> f3424b;

    /* renamed from: c */
    private HashMap<String, AdColonyAdViewListener> f3425c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public HashMap<String, AdColonyAdView> f3426d;

    /* renamed from: com.adcolony.sdk.d$a */
    class C1223a implements C1458z {
        C1223a() {
        }

        /* renamed from: a */
        public void mo6395a(C1454x xVar) {
            boolean unused = C1222d.this.m4979a(xVar);
        }
    }

    /* renamed from: com.adcolony.sdk.d$b */
    class C1224b implements C1458z {
        C1224b() {
        }

        /* renamed from: a */
        public void mo6395a(C1454x xVar) {
            C1222d.this.mo6462e(xVar);
        }
    }

    /* renamed from: com.adcolony.sdk.d$c */
    class C1225c implements C1458z {

        /* renamed from: com.adcolony.sdk.d$c$a */
        class C1226a implements Runnable {

            /* renamed from: a */
            final /* synthetic */ C1454x f3430a;

            C1226a(C1454x xVar) {
                this.f3430a = xVar;
            }

            public void run() {
                AdColonyInterstitial adColonyInterstitial = (AdColonyInterstitial) C1222d.this.f3424b.get(C1437s.m5613h(this.f3430a.mo6830b(), "id"));
                if (adColonyInterstitial != null && adColonyInterstitial.getListener() != null) {
                    adColonyInterstitial.getListener().onAudioStopped(adColonyInterstitial);
                }
            }
        }

        C1225c() {
        }

        /* renamed from: a */
        public void mo6395a(C1454x xVar) {
            C1359k0.m5309a((Runnable) new C1226a(xVar));
        }
    }

    /* renamed from: com.adcolony.sdk.d$d */
    class C1227d implements C1458z {

        /* renamed from: com.adcolony.sdk.d$d$a */
        class C1228a implements Runnable {

            /* renamed from: a */
            final /* synthetic */ C1454x f3433a;

            C1228a(C1454x xVar) {
                this.f3433a = xVar;
            }

            public void run() {
                AdColonyInterstitial adColonyInterstitial = (AdColonyInterstitial) C1222d.this.f3424b.get(C1437s.m5613h(this.f3433a.mo6830b(), "id"));
                if (adColonyInterstitial != null && adColonyInterstitial.getListener() != null) {
                    adColonyInterstitial.getListener().onAudioStarted(adColonyInterstitial);
                }
            }
        }

        C1227d() {
        }

        /* renamed from: a */
        public void mo6395a(C1454x xVar) {
            C1359k0.m5309a((Runnable) new C1228a(xVar));
        }
    }

    /* renamed from: com.adcolony.sdk.d$e */
    class C1229e implements C1458z {
        C1229e() {
        }

        /* renamed from: a */
        public void mo6395a(C1454x xVar) {
            boolean unused = C1222d.this.m4994i(xVar);
        }
    }

    /* renamed from: com.adcolony.sdk.d$f */
    class C1230f implements C1458z {
        C1230f() {
        }

        /* renamed from: a */
        public void mo6395a(C1454x xVar) {
            C1222d.this.mo6463h(xVar);
        }
    }

    /* renamed from: com.adcolony.sdk.d$g */
    class C1231g implements C1458z {
        C1231g() {
        }

        /* renamed from: a */
        public void mo6395a(C1454x xVar) {
            boolean unused = C1222d.this.m4991g(xVar);
        }
    }

    /* renamed from: com.adcolony.sdk.d$h */
    class C1232h implements C1458z {
        C1232h() {
        }

        /* renamed from: a */
        public void mo6395a(C1454x xVar) {
            JSONObject b = C1437s.m5599b();
            C1437s.m5603b(b, GraphResponse.SUCCESS_KEY, true);
            xVar.mo6829a(b).mo6834d();
        }
    }

    /* renamed from: com.adcolony.sdk.d$i */
    class C1233i implements C1458z {

        /* renamed from: com.adcolony.sdk.d$i$a */
        class C1234a implements Runnable {

            /* renamed from: a */
            final /* synthetic */ C1454x f3440a;

            C1234a(C1454x xVar) {
                this.f3440a = xVar;
            }

            public void run() {
                C1454x xVar = this.f3440a;
                xVar.mo6829a(xVar.mo6830b()).mo6834d();
            }
        }

        C1233i() {
        }

        /* renamed from: a */
        public void mo6395a(C1454x xVar) {
            C1359k0.m5309a((Runnable) new C1234a(xVar));
        }
    }

    /* renamed from: com.adcolony.sdk.d$j */
    class C1235j implements Runnable {

        /* renamed from: a */
        final /* synthetic */ AdColonyInterstitial f3442a;

        /* renamed from: b */
        final /* synthetic */ AdColonyInterstitialListener f3443b;

        C1235j(AdColonyInterstitial adColonyInterstitial, AdColonyInterstitialListener adColonyInterstitialListener) {
            this.f3442a = adColonyInterstitial;
            this.f3443b = adColonyInterstitialListener;
        }

        public void run() {
            this.f3442a.mo6322a(true);
            this.f3443b.onExpiring(this.f3442a);
            C1353k i = C1199a.m4880c().mo6543i();
            if (i.mo6663a() != null) {
                i.mo6663a().dismiss();
                i.mo6664a((AlertDialog) null);
            }
        }
    }

    /* renamed from: com.adcolony.sdk.d$k */
    class C1236k implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Context f3445a;

        /* renamed from: b */
        final /* synthetic */ C1454x f3446b;

        /* renamed from: c */
        final /* synthetic */ AdColonyAdViewListener f3447c;

        /* renamed from: d */
        final /* synthetic */ String f3448d;

        C1236k(Context context, C1454x xVar, AdColonyAdViewListener adColonyAdViewListener, String str) {
            this.f3445a = context;
            this.f3446b = xVar;
            this.f3447c = adColonyAdViewListener;
            this.f3448d = str;
        }

        public void run() {
            AdColonyAdView adColonyAdView = new AdColonyAdView(this.f3445a, this.f3446b, this.f3447c);
            C1222d.this.f3426d.put(this.f3448d, adColonyAdView);
            adColonyAdView.setOmidManager(this.f3447c.mo6264b());
            adColonyAdView.mo6230d();
            this.f3447c.mo6262a((C1218c0) null);
            this.f3447c.onRequestFilled(adColonyAdView);
        }
    }

    /* renamed from: com.adcolony.sdk.d$l */
    class C1237l implements Runnable {

        /* renamed from: a */
        final /* synthetic */ AdColonyInterstitial f3450a;

        /* renamed from: b */
        final /* synthetic */ C1454x f3451b;

        /* renamed from: c */
        final /* synthetic */ AdColonyInterstitialListener f3452c;

        C1237l(AdColonyInterstitial adColonyInterstitial, C1454x xVar, AdColonyInterstitialListener adColonyInterstitialListener) {
            this.f3450a = adColonyInterstitial;
            this.f3451b = xVar;
            this.f3452c = adColonyInterstitialListener;
        }

        public void run() {
            if (this.f3450a.mo6331e() == null) {
                this.f3450a.mo6321a(C1437s.m5612g(this.f3451b.mo6830b(), "iab"));
            }
            this.f3450a.mo6320a(C1437s.m5613h(this.f3451b.mo6830b(), "ad_id"));
            this.f3450a.mo6325b(C1437s.m5613h(this.f3451b.mo6830b(), "creative_id"));
            C1218c0 e = this.f3450a.mo6331e();
            if (!(e == null || e.mo6449d() == 2)) {
                try {
                    e.mo6442a();
                } catch (IllegalArgumentException unused) {
                    new C1439u.C1440a().mo6801a("IllegalArgumentException when creating omid session").mo6803a(C1439u.f4517j);
                }
            }
            this.f3452c.onRequestFilled(this.f3450a);
        }
    }

    /* renamed from: com.adcolony.sdk.d$m */
    class C1238m implements Runnable {

        /* renamed from: a */
        final /* synthetic */ AdColonyInterstitial f3454a;

        /* renamed from: b */
        final /* synthetic */ AdColonyInterstitialListener f3455b;

        C1238m(AdColonyInterstitial adColonyInterstitial, AdColonyInterstitialListener adColonyInterstitialListener) {
            this.f3454a = adColonyInterstitial;
            this.f3455b = adColonyInterstitialListener;
        }

        public void run() {
            AdColonyZone adColonyZone = C1199a.m4880c().mo6558y().get(this.f3454a.getZoneID());
            if (adColonyZone == null) {
                adColonyZone = new AdColonyZone(this.f3454a.getZoneID());
                adColonyZone.mo6375c(6);
            }
            this.f3455b.onRequestNotFilled(adColonyZone);
        }
    }

    /* renamed from: com.adcolony.sdk.d$n */
    class C1239n implements Runnable {

        /* renamed from: a */
        final /* synthetic */ AdColonyInterstitialListener f3457a;

        /* renamed from: b */
        final /* synthetic */ AdColonyInterstitial f3458b;

        C1239n(AdColonyInterstitialListener adColonyInterstitialListener, AdColonyInterstitial adColonyInterstitial) {
            this.f3457a = adColonyInterstitialListener;
            this.f3458b = adColonyInterstitial;
        }

        public void run() {
            C1199a.m4880c().mo6538d(false);
            this.f3457a.onClosed(this.f3458b);
        }
    }

    /* renamed from: com.adcolony.sdk.d$o */
    class C1240o implements Runnable {

        /* renamed from: a */
        final /* synthetic */ C1205c f3460a;

        C1240o(C1205c cVar) {
            this.f3460a = cVar;
        }

        public void run() {
            for (int i = 0; i < this.f3460a.mo6424i().size(); i++) {
                C1199a.m4879b(this.f3460a.mo6426j().get(i), this.f3460a.mo6424i().get(i));
            }
            this.f3460a.mo6426j().clear();
            this.f3460a.mo6424i().clear();
            this.f3460a.removeAllViews();
            C1205c cVar = this.f3460a;
            cVar.f3354A = null;
            cVar.f3380z = null;
            for (C1379m0 next : cVar.mo6431n().values()) {
                if (!next.mo6731t()) {
                    int c = next.mo6389c();
                    if (c <= 0) {
                        c = next.mo6390d();
                    }
                    C1199a.m4880c().mo6528a(c);
                    next.loadUrl("about:blank");
                    next.clearCache(true);
                    next.removeAllViews();
                    next.mo6711a(true);
                }
            }
            for (C1364l0 next2 : this.f3460a.mo6430m().values()) {
                next2.mo6687j();
                next2.mo6688k();
            }
            this.f3460a.mo6430m().clear();
            this.f3460a.mo6429l().clear();
            this.f3460a.mo6431n().clear();
            this.f3460a.mo6422h().clear();
            this.f3460a.mo6416e().clear();
            this.f3460a.mo6418f().clear();
            this.f3460a.mo6420g().clear();
            this.f3460a.f3367m = true;
        }
    }

    /* renamed from: com.adcolony.sdk.d$p */
    class C1241p implements Runnable {

        /* renamed from: a */
        final /* synthetic */ AdColonyAdViewListener f3462a;

        C1241p(AdColonyAdViewListener adColonyAdViewListener) {
            this.f3462a = adColonyAdViewListener;
        }

        public void run() {
            String c = this.f3462a.mo6265c();
            AdColonyZone adColonyZone = C1199a.m4880c().mo6558y().get(c);
            if (adColonyZone == null) {
                adColonyZone = new AdColonyZone(c);
                adColonyZone.mo6375c(6);
            }
            this.f3462a.onRequestNotFilled(adColonyZone);
        }
    }

    /* renamed from: com.adcolony.sdk.d$q */
    class C1242q implements C1458z {

        /* renamed from: com.adcolony.sdk.d$q$a */
        class C1243a implements Runnable {

            /* renamed from: a */
            final /* synthetic */ C1454x f3465a;

            C1243a(C1454x xVar) {
                this.f3465a = xVar;
            }

            public void run() {
                boolean unused = C1222d.this.m4984c(this.f3465a);
            }
        }

        C1242q() {
        }

        /* renamed from: a */
        public void mo6395a(C1454x xVar) {
            C1359k0.m5309a((Runnable) new C1243a(xVar));
        }
    }

    /* renamed from: com.adcolony.sdk.d$r */
    class C1244r implements C1458z {

        /* renamed from: com.adcolony.sdk.d$r$a */
        class C1245a implements Runnable {

            /* renamed from: a */
            final /* synthetic */ C1454x f3468a;

            C1245a(C1454x xVar) {
                this.f3468a = xVar;
            }

            public void run() {
                boolean unused = C1222d.this.m4986d(this.f3468a);
            }
        }

        C1244r() {
        }

        /* renamed from: a */
        public void mo6395a(C1454x xVar) {
            C1359k0.m5309a((Runnable) new C1245a(xVar));
        }
    }

    /* renamed from: com.adcolony.sdk.d$s */
    class C1246s implements C1458z {
        C1246s() {
        }

        /* renamed from: a */
        public void mo6395a(C1454x xVar) {
            boolean unused = C1222d.this.m4997k(xVar);
        }
    }

    /* renamed from: com.adcolony.sdk.d$t */
    class C1247t implements C1458z {
        C1247t() {
        }

        /* renamed from: a */
        public void mo6395a(C1454x xVar) {
            boolean unused = C1222d.this.m4996j(xVar);
        }
    }

    /* renamed from: com.adcolony.sdk.d$u */
    class C1248u implements C1458z {
        C1248u() {
        }

        /* renamed from: a */
        public void mo6395a(C1454x xVar) {
            boolean unused = C1222d.this.m4989f(xVar);
        }
    }

    /* renamed from: com.adcolony.sdk.d$v */
    class C1249v implements C1458z {
        C1249v() {
        }

        /* renamed from: a */
        public void mo6395a(C1454x xVar) {
            boolean unused = C1222d.this.m4998l(xVar);
        }
    }

    /* renamed from: com.adcolony.sdk.d$w */
    class C1250w implements C1458z {
        C1250w() {
        }

        /* renamed from: a */
        public void mo6395a(C1454x xVar) {
            boolean unused = C1222d.this.m4982b(xVar);
        }
    }

    C1222d() {
    }

    /* access modifiers changed from: private */
    /* renamed from: k */
    public boolean m4997k(C1454x xVar) {
        JSONObject b = xVar.mo6830b();
        String c = xVar.mo6833c();
        String h = C1437s.m5613h(b, "ad_session_id");
        int f = C1437s.m5611f(b, "view_id");
        C1205c cVar = this.f3423a.get(h);
        View view = cVar.mo6416e().get(Integer.valueOf(f));
        if (cVar == null) {
            mo6457a(c, h);
            return false;
        } else if (view == null) {
            mo6457a(c, "" + f);
            return false;
        } else {
            view.bringToFront();
            return true;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: l */
    public boolean m4998l(C1454x xVar) {
        JSONObject b = xVar.mo6830b();
        String h = C1437s.m5613h(b, "id");
        AdColonyInterstitial adColonyInterstitial = this.f3424b.get(h);
        AdColonyAdView adColonyAdView = this.f3426d.get(h);
        int a = C1437s.m5578a(b, "orientation", -1);
        boolean z = adColonyAdView != null;
        if (adColonyInterstitial != null || z) {
            C1437s.m5592a(C1437s.m5599b(), "id", h);
            if (adColonyInterstitial != null) {
                adColonyInterstitial.mo6317a(a);
                adColonyInterstitial.mo6337i();
            }
            return true;
        }
        mo6457a(xVar.mo6833c(), h);
        return false;
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public boolean m4984c(C1454x xVar) {
        Context b = C1199a.m4878b();
        if (b == null) {
            return false;
        }
        JSONObject b2 = xVar.mo6830b();
        String h = C1437s.m5613h(b2, "ad_session_id");
        C1205c cVar = new C1205c(b.getApplicationContext(), h);
        cVar.mo6427j(xVar);
        this.f3423a.put(h, cVar);
        if (C1437s.m5611f(b2, "width") == 0) {
            AdColonyInterstitial adColonyInterstitial = this.f3424b.get(h);
            if (adColonyInterstitial == null) {
                mo6457a(xVar.mo6833c(), h);
                return false;
            }
            adColonyInterstitial.mo6319a(cVar);
        } else {
            cVar.mo6409b(false);
        }
        JSONObject b3 = C1437s.m5599b();
        C1437s.m5603b(b3, GraphResponse.SUCCESS_KEY, true);
        xVar.mo6829a(b3).mo6834d();
        return true;
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public boolean m4986d(C1454x xVar) {
        String h = C1437s.m5613h(xVar.mo6830b(), "ad_session_id");
        C1205c cVar = this.f3423a.get(h);
        if (cVar == null) {
            mo6457a(xVar.mo6833c(), h);
            return false;
        }
        mo6454a(cVar);
        return true;
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public boolean m4989f(C1454x xVar) {
        AdColonyInterstitialListener adColonyInterstitialListener;
        JSONObject b = xVar.mo6830b();
        int f = C1437s.m5611f(b, "status");
        if (f == 5 || f == 1 || f == 0 || f == 6) {
            return false;
        }
        String h = C1437s.m5613h(b, "id");
        AdColonyInterstitial remove = this.f3424b.remove(h);
        if (remove == null) {
            adColonyInterstitialListener = null;
        } else {
            adColonyInterstitialListener = remove.getListener();
        }
        if (adColonyInterstitialListener == null) {
            mo6457a(xVar.mo6833c(), h);
            return false;
        }
        C1359k0.m5309a((Runnable) new C1239n(adColonyInterstitialListener, remove));
        remove.mo6319a((C1205c) null);
        return true;
    }

    /* access modifiers changed from: private */
    /* renamed from: g */
    public boolean m4991g(C1454x xVar) {
        String h = C1437s.m5613h(xVar.mo6830b(), "id");
        JSONObject b = C1437s.m5599b();
        C1437s.m5592a(b, "id", h);
        Context b2 = C1199a.m4878b();
        if (b2 == null) {
            C1437s.m5603b(b, "has_audio", false);
            xVar.mo6829a(b).mo6834d();
            return false;
        }
        boolean b3 = C1359k0.m5320b(C1359k0.m5300a(b2));
        double a = C1359k0.m5294a(C1359k0.m5300a(b2));
        C1437s.m5603b(b, "has_audio", b3);
        C1437s.m5590a(b, "volume", a);
        xVar.mo6829a(b).mo6834d();
        return b3;
    }

    /* access modifiers changed from: private */
    /* renamed from: i */
    public boolean m4994i(C1454x xVar) {
        AdColonyInterstitialListener adColonyInterstitialListener;
        String h = C1437s.m5613h(xVar.mo6830b(), "id");
        AdColonyInterstitial adColonyInterstitial = this.f3424b.get(h);
        if (adColonyInterstitial == null) {
            adColonyInterstitialListener = null;
        } else {
            adColonyInterstitialListener = adColonyInterstitial.getListener();
        }
        if (adColonyInterstitialListener == null) {
            mo6457a(xVar.mo6833c(), h);
            return false;
        } else if (!C1199a.m4881d()) {
            return false;
        } else {
            C1359k0.m5309a((Runnable) new C1237l(adColonyInterstitial, xVar, adColonyInterstitialListener));
            return true;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: j */
    public boolean m4996j(C1454x xVar) {
        JSONObject b = xVar.mo6830b();
        String c = xVar.mo6833c();
        String h = C1437s.m5613h(b, "ad_session_id");
        int f = C1437s.m5611f(b, "view_id");
        C1205c cVar = this.f3423a.get(h);
        if (cVar == null) {
            mo6457a(c, h);
            return false;
        }
        View view = cVar.mo6416e().get(Integer.valueOf(f));
        if (view == null) {
            mo6457a(c, "" + f);
            return false;
        }
        cVar.removeView(view);
        cVar.addView(view, view.getLayoutParams());
        return true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public void mo6461e() {
        this.f3423a = new HashMap<>();
        this.f3424b = new ConcurrentHashMap<>();
        this.f3425c = new HashMap<>();
        this.f3426d = new HashMap<>();
        C1199a.m4876a("AdContainer.create", (C1458z) new C1242q());
        C1199a.m4876a("AdContainer.destroy", (C1458z) new C1244r());
        C1199a.m4876a("AdContainer.move_view_to_index", (C1458z) new C1246s());
        C1199a.m4876a("AdContainer.move_view_to_front", (C1458z) new C1247t());
        C1199a.m4876a("AdSession.finish_fullscreen_ad", (C1458z) new C1248u());
        C1199a.m4876a("AdSession.start_fullscreen_ad", (C1458z) new C1249v());
        C1199a.m4876a("AdSession.ad_view_available", (C1458z) new C1250w());
        C1199a.m4876a("AdSession.ad_view_unavailable", (C1458z) new C1223a());
        C1199a.m4876a("AdSession.expiring", (C1458z) new C1224b());
        C1199a.m4876a("AdSession.audio_stopped", (C1458z) new C1225c());
        C1199a.m4876a("AdSession.audio_started", (C1458z) new C1227d());
        C1199a.m4876a("AdSession.interstitial_available", (C1458z) new C1229e());
        C1199a.m4876a("AdSession.interstitial_unavailable", (C1458z) new C1230f());
        C1199a.m4876a("AdSession.has_audio", (C1458z) new C1231g());
        C1199a.m4876a("WebView.prepare", (C1458z) new C1232h());
        C1199a.m4876a("AdSession.expanded", (C1458z) new C1233i());
    }

    /* access modifiers changed from: package-private */
    /* renamed from: h */
    public boolean mo6463h(C1454x xVar) {
        AdColonyInterstitialListener adColonyInterstitialListener;
        String h = C1437s.m5613h(xVar.mo6830b(), "id");
        AdColonyInterstitial remove = this.f3424b.remove(h);
        if (remove == null) {
            adColonyInterstitialListener = null;
        } else {
            adColonyInterstitialListener = remove.getListener();
        }
        if (adColonyInterstitialListener == null) {
            mo6457a(xVar.mo6833c(), h);
            return false;
        } else if (!C1199a.m4881d()) {
            return false;
        } else {
            C1359k0.m5309a((Runnable) new C1238m(remove, adColonyInterstitialListener));
            return true;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public boolean m4979a(C1454x xVar) {
        String h = C1437s.m5613h(xVar.mo6830b(), "id");
        AdColonyAdViewListener remove = this.f3425c.remove(h);
        if (remove == null) {
            mo6457a(xVar.mo6833c(), h);
            return false;
        }
        C1359k0.m5309a((Runnable) new C1241p(remove));
        return true;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public boolean m4982b(C1454x xVar) {
        String h = C1437s.m5613h(xVar.mo6830b(), "id");
        AdColonyAdViewListener remove = this.f3425c.remove(h);
        if (remove == null) {
            mo6457a(xVar.mo6833c(), h);
            return false;
        }
        Context b = C1199a.m4878b();
        if (b == null) {
            return false;
        }
        C1359k0.m5309a((Runnable) new C1236k(b, xVar, remove, h));
        return true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public HashMap<String, C1205c> mo6460d() {
        return this.f3423a;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo6455a(String str, AdColonyAdViewListener adColonyAdViewListener, AdColonyAdSize adColonyAdSize, AdColonyAdOptions adColonyAdOptions) {
        JSONObject jSONObject;
        String a = C1359k0.m5301a();
        JSONObject b = C1437s.m5599b();
        float n = C1199a.m4880c().mo6542h().mo6630n();
        C1437s.m5592a(b, "zone_id", str);
        C1437s.m5602b(b, "type", 1);
        C1437s.m5602b(b, "width_pixels", (int) (((float) adColonyAdSize.getWidth()) * n));
        C1437s.m5602b(b, "height_pixels", (int) (((float) adColonyAdSize.getHeight()) * n));
        C1437s.m5602b(b, "width", adColonyAdSize.getWidth());
        C1437s.m5602b(b, "height", adColonyAdSize.getHeight());
        C1437s.m5592a(b, "id", a);
        adColonyAdViewListener.mo6263a(str);
        adColonyAdViewListener.mo6261a(adColonyAdSize);
        if (!(adColonyAdOptions == null || (jSONObject = adColonyAdOptions.f3260d) == null)) {
            C1437s.m5594a(b, "options", jSONObject);
        }
        this.f3425c.put(a, adColonyAdViewListener);
        new C1454x("AdSession.on_request", 1, b).mo6834d();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public HashMap<String, AdColonyAdView> mo6458b() {
        return this.f3426d;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public HashMap<String, AdColonyAdViewListener> mo6459c() {
        return this.f3425c;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public boolean mo6462e(C1454x xVar) {
        AdColonyInterstitialListener adColonyInterstitialListener;
        JSONObject b = xVar.mo6830b();
        String h = C1437s.m5613h(b, "id");
        if (C1437s.m5611f(b, "type") != 0) {
            return true;
        }
        AdColonyInterstitial remove = this.f3424b.remove(h);
        if (remove == null) {
            adColonyInterstitialListener = null;
        } else {
            adColonyInterstitialListener = remove.getListener();
        }
        if (adColonyInterstitialListener == null) {
            mo6457a(xVar.mo6833c(), h);
            return false;
        } else if (!C1199a.m4881d()) {
            return false;
        } else {
            C1359k0.m5309a((Runnable) new C1235j(remove, adColonyInterstitialListener));
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo6456a(String str, AdColonyInterstitialListener adColonyInterstitialListener, AdColonyAdOptions adColonyAdOptions) {
        String a = C1359k0.m5301a();
        C1290h c = C1199a.m4880c();
        JSONObject b = C1437s.m5599b();
        C1437s.m5592a(b, "zone_id", str);
        C1437s.m5603b(b, AdMostZoneType.FULLSCREEN, true);
        C1437s.m5602b(b, "width", c.mo6542h().mo6634r());
        C1437s.m5602b(b, "height", c.mo6542h().mo6633q());
        C1437s.m5602b(b, "type", 0);
        C1437s.m5592a(b, "id", a);
        AdColonyInterstitial adColonyInterstitial = new AdColonyInterstitial(a, adColonyInterstitialListener, str);
        this.f3424b.put(a, adColonyInterstitial);
        if (!(adColonyAdOptions == null || adColonyAdOptions.f3260d == null)) {
            adColonyInterstitial.mo6318a(adColonyAdOptions);
            C1437s.m5594a(b, "options", adColonyAdOptions.f3260d);
        }
        new C1454x("AdSession.on_request", 1, b).mo6834d();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo6454a(C1205c cVar) {
        C1359k0.m5309a((Runnable) new C1240o(cVar));
        AdColonyAdView adColonyAdView = this.f3426d.get(cVar.mo6400a());
        if (adColonyAdView == null || adColonyAdView.mo6229c()) {
            this.f3423a.remove(cVar.mo6400a());
            cVar.f3380z = null;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo6457a(String str, String str2) {
        new C1439u.C1440a().mo6801a("Message '").mo6801a(str).mo6801a("' sent with invalid id: ").mo6801a(str2).mo6803a(C1439u.f4516i);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public ConcurrentHashMap<String, AdColonyInterstitial> mo6453a() {
        return this.f3424b;
    }
}
