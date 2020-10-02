package org.cocos2dx.cpp;

import admost.sdk.AdMostInterstitial;
import admost.sdk.base.AdMost;
import admost.sdk.base.AdMostConfiguration;
import admost.sdk.listener.AdMostAdListener;
import admost.sdk.listener.AdMostVirtualCurrencyListener;
import android.os.Handler;
import p118io.fabric.sdk.android.p200m.p202b.C6078a;

/* renamed from: org.cocos2dx.cpp.a */
/* compiled from: AdManager */
public class C6702a {

    /* renamed from: r */
    private static C6702a f17525r;

    /* renamed from: a */
    private boolean f17526a = false;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public boolean f17527b = false;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public boolean f17528c = false;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public boolean f17529d = false;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public int f17530e = 0;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public boolean f17531f = false;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public boolean f17532g = false;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public AdMostInterstitial f17533h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public AdMostInterstitial f17534i = null;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public AdMostInterstitial f17535j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public AdMostAdListener f17536k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public AdMostAdListener f17537l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public AdMostInterstitial f17538m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public String f17539n;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public String f17540o;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public int f17541p = 0;
    /* access modifiers changed from: private */

    /* renamed from: q */
    public int f17542q = 0;

    /* renamed from: org.cocos2dx.cpp.a$a */
    /* compiled from: AdManager */
    class C6703a implements AdMostAdListener {

        /* renamed from: org.cocos2dx.cpp.a$a$a */
        /* compiled from: AdManager */
        class C6704a implements Runnable {

            /* renamed from: org.cocos2dx.cpp.a$a$a$a */
            /* compiled from: AdManager */
            class C6705a implements Runnable {
                C6705a() {
                }

                public void run() {
                    C6702a.this.mo35839c();
                }
            }

            C6704a() {
            }

            public void run() {
                C3597b.m12267a().f10092a.runOnUiThread(new C6705a());
            }
        }

        C6703a() {
        }

        public void onClicked(String str) {
        }

        public void onComplete(String str) {
        }

        public void onDismiss(String str) {
            AppActivity.advertisementDismissed(true, 669);
            C6702a.this.mo35839c();
        }

        public void onFail(int i) {
            C6702a.m21939d(C6702a.this);
            AppActivity.advertisementDismissed(false, i);
            new Handler().postDelayed(new C6704a(), (long) (C6702a.this.f17530e > 5 ? C6078a.DEFAULT_TIMEOUT : 1000));
        }

        public void onReady(String str, int i) {
            int unused = C6702a.this.f17541p = i;
            int unused2 = C6702a.this.f17530e = 0;
            String unused3 = C6702a.this.f17540o = str;
            if (C6702a.this.f17527b) {
                boolean unused4 = C6702a.this.f17527b = false;
                if (C6702a.this.f17535j != null && AppActivity.isWaitingToShowAd()) {
                    if (!AppActivity.isInterstitialWorthToShow((float) i)) {
                        AppActivity.advertisementDismissed(false, 667);
                        C6702a.this.mo35839c();
                        return;
                    }
                    AppActivity.advertisementShown(C6702a.this.f17540o, (float) C6702a.this.f17541p);
                    C6702a.this.f17535j.show();
                }
            }
        }

        public void onShown(String str) {
        }

        public void onStatusChanged(int i) {
        }
    }

    /* renamed from: org.cocos2dx.cpp.a$b */
    /* compiled from: AdManager */
    class C6706b extends AdMostVirtualCurrencyListener {
        C6706b(C6702a aVar) {
        }

        public void onSuccess(String str, String str2, double d) {
            AppActivity.offerwallCallback(false, false, (int) d, str2);
        }
    }

    /* renamed from: org.cocos2dx.cpp.a$c */
    /* compiled from: AdManager */
    class C6707c implements AdMostAdListener {
        C6707c() {
        }

        public void onClicked(String str) {
        }

        public void onComplete(String str) {
            boolean unused = C6702a.this.f17529d = true;
        }

        public void onDismiss(String str) {
            if (C6702a.this.f17538m != null) {
                C6702a.this.f17538m.destroy();
                AdMostInterstitial unused = C6702a.this.f17538m = null;
            }
            AppActivity.advertisementDismissed(C6702a.this.f17529d, C6702a.this.f17529d ? 0 : 669);
        }

        public void onFail(int i) {
            if (C6702a.this.f17538m != null) {
                C6702a.this.f17538m.destroy();
                AdMostInterstitial unused = C6702a.this.f17538m = null;
            }
            if (C6702a.this.f17528c) {
                boolean unused2 = C6702a.this.f17528c = false;
                AppActivity.advertisementDismissed(false, i);
            }
        }

        public void onReady(String str, int i) {
            int unused = C6702a.this.f17541p = i;
            String unused2 = C6702a.this.f17539n = str;
            if (C6702a.this.f17528c) {
                boolean unused3 = C6702a.this.f17528c = false;
                if (AppActivity.isWaitingToShowAd()) {
                    AppActivity.advertisementShown(str, (float) C6702a.this.f17541p);
                    C6702a.this.f17538m.show();
                }
            }
        }

        public void onShown(String str) {
        }

        public void onStatusChanged(int i) {
        }
    }

    /* renamed from: org.cocos2dx.cpp.a$d */
    /* compiled from: AdManager */
    class C6708d implements Runnable {
        C6708d() {
        }

        public void run() {
            if (C6702a.this.f17535j != null) {
                C6702a.this.f17535j.destroy();
            }
            AdMostInterstitial unused = C6702a.this.f17535j = new AdMostInterstitial(C3597b.m12267a().f10092a, "87548859-b7bd-4592-a0eb-9076087f84ac", C6702a.this.f17536k);
            C6702a.this.f17535j.refreshAd(false);
        }
    }

    /* renamed from: org.cocos2dx.cpp.a$e */
    /* compiled from: AdManager */
    class C6709e implements Runnable {
        C6709e() {
        }

        public void run() {
            if (C6702a.this.f17538m != null) {
                C6702a.this.f17538m.destroy();
            }
            AdMostInterstitial unused = C6702a.this.f17538m = new AdMostInterstitial(C3597b.m12267a().f10092a, "40c2e609-ae41-4fea-b8c6-1d3573617a95", C6702a.this.f17537l);
            C6702a.this.f17538m.refreshAd(false);
        }
    }

    /* renamed from: org.cocos2dx.cpp.a$f */
    /* compiled from: AdManager */
    class C6710f implements Runnable {

        /* renamed from: a */
        final /* synthetic */ boolean f17549a;

        C6710f(boolean z) {
            this.f17549a = z;
        }

        public void run() {
            if (this.f17549a) {
                boolean unused = C6702a.this.f17529d = false;
                if (C6702a.this.f17538m != null && C6702a.this.f17538m.isLoaded()) {
                    AppActivity.advertisementShown(C6702a.this.f17539n, (float) C6702a.this.f17541p);
                    C6702a.this.f17538m.show();
                } else if (C6702a.this.f17538m == null || !C6702a.this.f17538m.isLoading()) {
                    boolean unused2 = C6702a.this.f17528c = true;
                    C6702a.this.mo35840d();
                } else {
                    boolean unused3 = C6702a.this.f17528c = true;
                }
            } else if (C6702a.this.f17535j == null || !C6702a.this.f17535j.isLoaded()) {
                if (C6702a.this.f17535j == null || !C6702a.this.f17535j.isLoading()) {
                    AppActivity.advertisementDismissed(false, 0);
                    boolean unused4 = C6702a.this.f17527b = false;
                    C6702a.this.mo35839c();
                    return;
                }
                boolean unused5 = C6702a.this.f17527b = true;
            } else if (!AppActivity.isInterstitialWorthToShow((float) C6702a.this.f17541p)) {
                AppActivity.advertisementDismissed(false, 667);
                boolean unused6 = C6702a.this.f17527b = false;
                C6702a.this.mo35839c();
            } else {
                AppActivity.advertisementShown(C6702a.this.f17540o, (float) C6702a.this.f17541p);
                C6702a.this.f17535j.show();
            }
        }
    }

    /* renamed from: org.cocos2dx.cpp.a$g */
    /* compiled from: AdManager */
    class C6711g implements AdMostAdListener {

        /* renamed from: a */
        final /* synthetic */ boolean f17551a;

        C6711g(boolean z) {
            this.f17551a = z;
        }

        public void onClicked(String str) {
        }

        public void onComplete(String str) {
        }

        public void onDismiss(String str) {
            AdMostInterstitial unused = C6702a.this.f17534i = null;
            C6702a.this.mo35836a(false, false);
        }

        public void onFail(int i) {
            AdMostInterstitial unused = C6702a.this.f17534i = null;
            C6702a.this.mo35836a(false, !this.f17551a);
        }

        public void onReady(String str, int i) {
            if (this.f17551a) {
                C6702a.this.f17534i.show();
            } else {
                C6702a.this.mo35836a(true, true);
            }
        }

        public void onShown(String str) {
        }

        public void onStatusChanged(int i) {
        }
    }

    /* renamed from: org.cocos2dx.cpp.a$h */
    /* compiled from: AdManager */
    class C6712h implements Runnable {

        /* renamed from: a */
        final /* synthetic */ int f17553a;

        /* renamed from: org.cocos2dx.cpp.a$h$a */
        /* compiled from: AdManager */
        class C6713a implements Runnable {
            C6713a() {
            }

            public void run() {
                if (C6702a.this.f17532g) {
                    C6712h hVar = C6712h.this;
                    if (hVar.f17553a == C6702a.this.f17542q) {
                        C6702a.this.mo35836a(false, false);
                    }
                }
            }
        }

        C6712h(int i) {
            this.f17553a = i;
        }

        public void run() {
            C3597b.m12267a().f10092a.runOnUiThread(new C6713a());
        }
    }

    /* renamed from: org.cocos2dx.cpp.a$i */
    /* compiled from: AdManager */
    class C6714i implements AdMostAdListener {
        C6714i() {
        }

        public void onClicked(String str) {
        }

        public void onComplete(String str) {
        }

        public void onDismiss(String str) {
            boolean unused = C6702a.this.f17531f = false;
            AppActivity.offerwallCallback(true, false, 0, "");
        }

        public void onFail(int i) {
            boolean unused = C6702a.this.f17531f = false;
            AppActivity.offerwallCallback(false, true, 0, "");
        }

        public void onReady(String str, int i) {
            boolean unused = C6702a.this.f17531f = false;
            C6702a.this.f17533h.show();
        }

        public void onShown(String str) {
        }

        public void onStatusChanged(int i) {
        }
    }

    /* renamed from: org.cocos2dx.cpp.a$j */
    /* compiled from: AdManager */
    class C6715j implements Runnable {

        /* renamed from: org.cocos2dx.cpp.a$j$a */
        /* compiled from: AdManager */
        class C6716a implements Runnable {
            C6716a() {
            }

            public void run() {
                if (C6702a.this.f17531f) {
                    boolean unused = C6702a.this.f17531f = false;
                    AppActivity.offerwallCallback(true, false, 0, "");
                }
            }
        }

        C6715j() {
        }

        public void run() {
            C3597b.m12267a().f10092a.runOnUiThread(new C6716a());
        }
    }

    /* renamed from: d */
    static /* synthetic */ int m21939d(C6702a aVar) {
        int i = aVar.f17530e;
        aVar.f17530e = i + 1;
        return i;
    }

    /* renamed from: j */
    public static synchronized C6702a m21947j() {
        C6702a aVar;
        synchronized (C6702a.class) {
            if (f17525r == null) {
                f17525r = new C6702a();
            }
            aVar = f17525r;
        }
        return aVar;
    }

    /* renamed from: e */
    public float mo35841e() {
        AdMostInterstitial adMostInterstitial = this.f17538m;
        if (adMostInterstitial == null || !adMostInterstitial.isLoaded()) {
            return 0.0f;
        }
        return (float) this.f17541p;
    }

    /* renamed from: f */
    public void mo35842f() {
        m21937c(false);
    }

    /* renamed from: g */
    public void mo35843g() {
        this.f17531f = true;
        AdMostInterstitial adMostInterstitial = new AdMostInterstitial(C3597b.m12267a().f10092a, "28e2fdd0-950b-4c26-a11d-91fac9091e8d", new C6714i());
        this.f17533h = adMostInterstitial;
        adMostInterstitial.refreshAd(false);
        new Handler().postDelayed(new C6715j(), 15000);
    }

    /* renamed from: h */
    public void mo35844h() {
        AdMostInterstitial adMostInterstitial = this.f17534i;
        if (adMostInterstitial != null) {
            adMostInterstitial.show();
        } else {
            m21937c(true);
        }
    }

    /* renamed from: i */
    public void mo35845i() {
        AdMost.getInstance().startTestSuite(new String[]{"87548859-b7bd-4592-a0eb-9076087f84ac", "40c2e609-ae41-4fea-b8c6-1d3573617a95"});
    }

    /* renamed from: d */
    public void mo35840d() {
        C3597b.m12267a().f10092a.runOnUiThread(new C6709e());
    }

    /* renamed from: c */
    public void mo35839c() {
        C3597b.m12267a().f10092a.runOnUiThread(new C6708d());
    }

    /* renamed from: c */
    private void m21937c(boolean z) {
        this.f17532g = true;
        this.f17542q++;
        AdMostInterstitial adMostInterstitial = new AdMostInterstitial(C3597b.m12267a().f10092a, "0b420645-840e-42a1-b996-f4da68c85119", new C6711g(z));
        this.f17534i = adMostInterstitial;
        adMostInterstitial.refreshAd(false);
        if (z) {
            new Handler().postDelayed(new C6712h(this.f17542q), 15000);
        }
    }

    /* renamed from: a */
    public void mo35835a(boolean z) {
        if (!this.f17526a) {
            this.f17526a = true;
            AdMostConfiguration.Builder builder = new AdMostConfiguration.Builder(C3597b.m12267a().f10092a, "e49e63de-3ef4-442d-a235-0e23dc28741f");
            builder.interests("Gamer");
            builder.setSubjectToGDPR(true);
            builder.setUserConsent(z);
            AdMost.getInstance().init(builder.build());
            this.f17536k = new C6703a();
            this.f17537l = new C6707c();
        }
    }

    /* renamed from: b */
    public void mo35838b(boolean z) {
        C3597b.m12267a().f10092a.runOnUiThread(new C6710f(z));
    }

    /* renamed from: b */
    public void mo35837b() {
        AdMost.getInstance().spendVirtualCurrency(new C6706b(this));
    }

    /* renamed from: a */
    public void mo35834a(String str) {
        AdMost.getInstance().setAdjustUserId(str);
    }

    /* renamed from: a */
    public void mo35833a() {
        this.f17527b = false;
        this.f17528c = false;
        AdMostInterstitial adMostInterstitial = this.f17538m;
        if (adMostInterstitial != null) {
            adMostInterstitial.destroy();
        }
        AdMostInterstitial adMostInterstitial2 = this.f17535j;
        if (adMostInterstitial2 != null) {
            adMostInterstitial2.destroy();
        }
    }

    /* renamed from: a */
    public void mo35836a(boolean z, boolean z2) {
        this.f17532g = false;
        AppActivity.surveyCallback(z, z2);
    }
}
