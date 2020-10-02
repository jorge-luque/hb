package com.adcolony.sdk;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.adcolony.sdk.C1362l;
import com.adcolony.sdk.C1439u;
import com.applovin.sdk.AppLovinEventTypes;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.iab.omid.library.adcolony.Omid;
import com.iab.omid.library.adcolony.adsession.Partner;
import com.tapjoy.TapjoyConstants;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ScheduledExecutorService;
import org.json.JSONArray;
import org.json.JSONObject;
import p118io.fabric.sdk.android.p200m.p202b.C6078a;

/* renamed from: com.adcolony.sdk.h */
class C1290h implements C1362l.C1363a {

    /* renamed from: S */
    static final String f4085S = "026ae9c9824b3e483fa6c71fa88f57ae27816141";

    /* renamed from: T */
    static final String f4086T = "7bf3a1e7bbd31e612eda3310c2cdb8075c43c6b5";

    /* renamed from: U */
    static String f4087U = "https://adc3-launch.adcolony.com/v4/launch";

    /* renamed from: V */
    private static volatile String f4088V = "";

    /* renamed from: A */
    private String f4089A = "";

    /* renamed from: B */
    private boolean f4090B;
    /* access modifiers changed from: private */

    /* renamed from: C */
    public boolean f4091C;

    /* renamed from: D */
    private boolean f4092D;
    /* access modifiers changed from: private */

    /* renamed from: E */
    public boolean f4093E;

    /* renamed from: F */
    boolean f4094F;

    /* renamed from: G */
    private boolean f4095G;

    /* renamed from: H */
    private boolean f4096H;

    /* renamed from: I */
    private boolean f4097I;

    /* renamed from: J */
    private boolean f4098J;
    /* access modifiers changed from: private */

    /* renamed from: K */
    public boolean f4099K;
    /* access modifiers changed from: private */

    /* renamed from: L */
    public boolean f4100L;
    /* access modifiers changed from: private */

    /* renamed from: M */
    public boolean f4101M;

    /* renamed from: N */
    private int f4102N;
    /* access modifiers changed from: private */

    /* renamed from: O */
    public int f4103O = 1;

    /* renamed from: P */
    private final int f4104P = 120;

    /* renamed from: Q */
    private Application.ActivityLifecycleCallbacks f4105Q;
    /* access modifiers changed from: private */

    /* renamed from: R */
    public Partner f4106R = null;

    /* renamed from: a */
    private C1314i f4107a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public C1455y f4108b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public C1375m f4109c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public C1286f0 f4110d;

    /* renamed from: e */
    private C1222d f4111e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public C1353k f4112f;

    /* renamed from: g */
    private C1413p f4113g;

    /* renamed from: h */
    private C1316i0 f4114h;

    /* renamed from: i */
    private C1289g0 f4115i;

    /* renamed from: j */
    private C1443w f4116j;

    /* renamed from: k */
    private C1336j f4117k;

    /* renamed from: l */
    private C1204b0 f4118l;

    /* renamed from: m */
    private C1205c f4119m;

    /* renamed from: n */
    private AdColonyAdView f4120n;

    /* renamed from: o */
    private AdColonyInterstitial f4121o;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public AdColonyRewardListener f4122p;

    /* renamed from: q */
    private HashMap<String, AdColonyCustomMessageListener> f4123q = new HashMap<>();
    /* access modifiers changed from: private */

    /* renamed from: r */
    public AdColonyAppOptions f4124r;
    /* access modifiers changed from: private */

    /* renamed from: s */
    public C1454x f4125s;

    /* renamed from: t */
    private JSONObject f4126t;

    /* renamed from: u */
    private HashMap<String, AdColonyZone> f4127u = new HashMap<>();
    /* access modifiers changed from: private */

    /* renamed from: v */
    public HashMap<Integer, C1379m0> f4128v = new HashMap<>();

    /* renamed from: w */
    private String f4129w;

    /* renamed from: x */
    private String f4130x;

    /* renamed from: y */
    private String f4131y;

    /* renamed from: z */
    private String f4132z;

    /* renamed from: com.adcolony.sdk.h$a */
    class C1291a implements C1458z {
        C1291a() {
        }

        /* renamed from: a */
        public void mo6395a(C1454x xVar) {
            int f = C1437s.m5611f(xVar.mo6830b(), "number");
            JSONObject b = C1437s.m5599b();
            C1437s.m5593a(b, "uuids", C1359k0.m5304a(f));
            xVar.mo6829a(b).mo6834d();
        }
    }

    /* renamed from: com.adcolony.sdk.h$b */
    class C1292b implements C1458z {

        /* renamed from: com.adcolony.sdk.h$b$a */
        class C1293a implements Runnable {

            /* renamed from: a */
            final /* synthetic */ Context f4135a;

            /* renamed from: b */
            final /* synthetic */ C1454x f4136b;

            C1293a(Context context, C1454x xVar) {
                this.f4135a = context;
                this.f4136b = xVar;
            }

            public void run() {
                C1290h.this.mo6529a(this.f4135a, this.f4136b);
            }
        }

        C1292b() {
        }

        /* renamed from: a */
        public void mo6395a(C1454x xVar) {
            Context b = C1199a.m4878b();
            if (b != null) {
                C1359k0.f4258b.execute(new C1293a(b, xVar));
            }
        }
    }

    /* renamed from: com.adcolony.sdk.h$c */
    class C1294c implements C1458z {
        C1294c() {
        }

        /* renamed from: a */
        public void mo6395a(C1454x xVar) {
            C1282e0 a = C1290h.this.mo6547m().mo6816a();
            C1290h.this.mo6542h().mo6616b(C1437s.m5613h(xVar.mo6830b(), "version"));
            if (a != null) {
                a.mo6487e(C1290h.this.mo6542h().mo6626j());
            }
        }
    }

    /* renamed from: com.adcolony.sdk.h$d */
    class C1295d implements Runnable {
        C1295d() {
        }

        public void run() {
            Context b = C1199a.m4878b();
            if (!C1290h.this.f4101M && b != null) {
                try {
                    Omid.activate(b.getApplicationContext());
                    boolean unused = C1290h.this.f4101M = true;
                } catch (IllegalArgumentException unused2) {
                    new C1439u.C1440a().mo6801a("IllegalArgumentException when activating Omid").mo6803a(C1439u.f4517j);
                    boolean unused3 = C1290h.this.f4101M = false;
                }
            }
            if (C1290h.this.f4101M && C1290h.this.f4106R == null) {
                try {
                    Partner unused4 = C1290h.this.f4106R = Partner.createPartner("AdColony", "4.2.0");
                } catch (IllegalArgumentException unused5) {
                    new C1439u.C1440a().mo6801a("IllegalArgumentException when creating Omid Partner").mo6803a(C1439u.f4517j);
                    boolean unused6 = C1290h.this.f4101M = false;
                }
            }
        }
    }

    /* renamed from: com.adcolony.sdk.h$e */
    class C1296e implements Runnable {
        C1296e() {
        }

        public void run() {
            JSONObject b = C1437s.m5599b();
            C1437s.m5592a(b, "url", C1290h.f4087U);
            C1437s.m5592a(b, "content_type", C6078a.ACCEPT_JSON_VALUE);
            C1437s.m5592a(b, AppLovinEventTypes.USER_VIEWED_CONTENT, C1359k0.m5305a(C1290h.this.mo6542h().mo6612a(true)).toString());
            C1290h.this.f4109c.mo6705a(new C1362l(new C1454x("WebServices.post", 0, b), C1290h.this));
        }
    }

    /* renamed from: com.adcolony.sdk.h$f */
    class C1297f implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Context f4141a;

        /* renamed from: b */
        final /* synthetic */ boolean f4142b;

        /* renamed from: c */
        final /* synthetic */ C1454x f4143c;

        C1297f(Context context, boolean z, C1454x xVar) {
            this.f4141a = context;
            this.f4142b = z;
            this.f4143c = xVar;
        }

        public void run() {
            C1379m0 m0Var = new C1379m0(this.f4141a.getApplicationContext(), C1290h.this.f4108b.mo6844d(), this.f4142b);
            m0Var.mo6712a(true, this.f4143c);
            C1290h.this.f4128v.put(Integer.valueOf(m0Var.mo6390d()), m0Var);
        }
    }

    /* renamed from: com.adcolony.sdk.h$g */
    class C1298g implements Runnable {

        /* renamed from: com.adcolony.sdk.h$g$a */
        class C1299a implements Runnable {
            C1299a() {
            }

            public void run() {
                if (C1199a.m4880c().mo6554u().mo6501e()) {
                    C1290h.this.m5068E();
                }
            }
        }

        C1298g() {
        }

        public void run() {
            new Handler().postDelayed(new C1299a(), (long) (C1290h.this.f4103O * 1000));
        }
    }

    /* renamed from: com.adcolony.sdk.h$h */
    class C1300h implements Runnable {
        C1300h() {
        }

        public void run() {
            boolean unused = C1290h.this.m5069F();
        }
    }

    /* renamed from: com.adcolony.sdk.h$i */
    class C1301i implements Runnable {

        /* renamed from: a */
        final /* synthetic */ C1379m0 f4148a;

        C1301i(C1379m0 m0Var) {
            this.f4148a = m0Var;
        }

        public void run() {
            C1379m0 m0Var = this.f4148a;
            if (m0Var != null && m0Var.mo6731t()) {
                this.f4148a.loadUrl("about:blank");
                this.f4148a.clearCache(true);
                this.f4148a.removeAllViews();
                this.f4148a.mo6711a(true);
                this.f4148a.destroy();
            }
        }
    }

    /* renamed from: com.adcolony.sdk.h$j */
    class C1302j implements Runnable {

        /* renamed from: a */
        final /* synthetic */ C1454x f4150a;

        C1302j(C1454x xVar) {
            this.f4150a = xVar;
        }

        public void run() {
            C1290h.this.f4122p.onReward(new AdColonyReward(this.f4150a));
        }
    }

    /* renamed from: com.adcolony.sdk.h$k */
    class C1303k implements C1458z {
        C1303k() {
        }

        /* renamed from: a */
        public void mo6395a(C1454x xVar) {
            boolean unused = C1290h.this.m5091c(xVar);
        }
    }

    /* renamed from: com.adcolony.sdk.h$l */
    class C1304l implements Application.ActivityLifecycleCallbacks {
        C1304l() {
        }

        public void onActivityCreated(Activity activity, Bundle bundle) {
            if (!C1290h.this.f4110d.mo6501e()) {
                C1290h.this.f4110d.mo6497c(true);
            }
            C1199a.m4874a(activity);
        }

        public void onActivityDestroyed(Activity activity) {
        }

        public void onActivityPaused(Activity activity) {
            C1199a.f3339d = false;
            C1290h.this.f4110d.mo6498d(false);
            C1290h.this.f4110d.mo6500e(true);
        }

        public void onActivityResumed(Activity activity) {
            ScheduledExecutorService scheduledExecutorService;
            C1199a.f3339d = true;
            C1199a.m4874a(activity);
            C1282e0 a = C1290h.this.mo6547m().mo6816a();
            Context b = C1199a.m4878b();
            if (b == null || !C1290h.this.f4110d.mo6499d() || !(b instanceof C1202b) || ((C1202b) b).f3347e) {
                C1199a.m4874a(activity);
                if (C1290h.this.f4125s != null) {
                    C1290h.this.f4125s.mo6829a(C1290h.this.f4125s.mo6830b()).mo6834d();
                    C1454x unused = C1290h.this.f4125s = null;
                }
                boolean unused2 = C1290h.this.f4091C = false;
                C1290h.this.f4110d.mo6498d(true);
                C1290h.this.f4110d.mo6500e(true);
                C1290h.this.f4110d.mo6502f(false);
                C1290h hVar = C1290h.this;
                if (hVar.f4094F && !hVar.f4110d.mo6501e()) {
                    C1290h.this.f4110d.mo6497c(true);
                }
                C1290h.this.f4112f.mo6666c();
                if (a == null || (scheduledExecutorService = a.f4045b) == null || scheduledExecutorService.isShutdown() || a.f4045b.isTerminated()) {
                    AdColony.m4806a((Context) activity, C1199a.m4880c().f4124r);
                }
            }
        }

        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        public void onActivityStarted(Activity activity) {
        }

        public void onActivityStopped(Activity activity) {
        }
    }

    /* renamed from: com.adcolony.sdk.h$m */
    class C1305m implements C1458z {
        C1305m() {
        }

        /* renamed from: a */
        public void mo6395a(C1454x xVar) {
            C1290h.this.m5074a(xVar);
        }
    }

    /* renamed from: com.adcolony.sdk.h$n */
    class C1306n implements C1458z {
        C1306n() {
        }

        /* renamed from: a */
        public void mo6395a(C1454x xVar) {
            C1282e0 a = C1290h.this.mo6547m().mo6816a();
            boolean unused = C1290h.this.f4093E = true;
            if (C1290h.this.f4099K) {
                JSONObject b = C1437s.m5599b();
                JSONObject b2 = C1437s.m5599b();
                C1437s.m5592a(b2, TapjoyConstants.TJC_APP_VERSION_NAME, C1359k0.m5328e());
                C1437s.m5594a(b, "app_bundle_info", b2);
                new C1454x("AdColony.on_update", 1, b).mo6834d();
                boolean unused2 = C1290h.this.f4099K = false;
            }
            if (C1290h.this.f4100L) {
                new C1454x("AdColony.on_install", 1).mo6834d();
            }
            if (a != null) {
                a.mo6488f(C1437s.m5613h(xVar.mo6830b(), "app_session_id"));
            }
            if (AdColonyEventTracker.m4837a()) {
                AdColonyEventTracker.m4839b();
            }
            int a2 = C1437s.m5578a(xVar.mo6830b(), "concurrent_requests", 4);
            if (a2 != C1290h.this.f4109c.mo6703a()) {
                C1290h.this.f4109c.mo6704a(a2);
            }
            C1290h.this.m5070G();
        }
    }

    /* renamed from: com.adcolony.sdk.h$o */
    class C1307o implements C1458z {
        C1307o() {
        }

        /* renamed from: a */
        public void mo6395a(C1454x xVar) {
            C1290h.this.m5085b(xVar);
        }
    }

    /* renamed from: com.adcolony.sdk.h$p */
    class C1308p implements C1458z {
        C1308p() {
        }

        /* renamed from: a */
        public void mo6395a(C1454x xVar) {
            boolean unused = C1290h.this.m5098e(xVar);
        }
    }

    /* renamed from: com.adcolony.sdk.h$q */
    class C1309q implements C1458z {
        C1309q() {
        }

        /* renamed from: a */
        public void mo6395a(C1454x xVar) {
            C1290h.this.m5101f(xVar);
        }
    }

    /* renamed from: com.adcolony.sdk.h$r */
    class C1310r implements C1458z {
        C1310r() {
        }

        /* renamed from: a */
        public void mo6395a(C1454x xVar) {
            boolean unused = C1290h.this.m5082a(true, true);
        }
    }

    /* renamed from: com.adcolony.sdk.h$s */
    class C1311s implements C1458z {
        C1311s() {
        }

        /* renamed from: a */
        public void mo6395a(C1454x xVar) {
            JSONObject b = C1437s.m5599b();
            C1437s.m5592a(b, "sha1", C1359k0.m5318b(C1437s.m5613h(xVar.mo6830b(), "data")));
            xVar.mo6829a(b).mo6834d();
        }
    }

    /* renamed from: com.adcolony.sdk.h$t */
    class C1312t implements C1458z {
        C1312t() {
        }

        /* renamed from: a */
        public void mo6395a(C1454x xVar) {
            JSONObject b = C1437s.m5599b();
            C1437s.m5602b(b, "crc32", C1359k0.m5299a(C1437s.m5613h(xVar.mo6830b(), "data")));
            xVar.mo6829a(b).mo6834d();
        }
    }

    C1290h() {
    }

    /* access modifiers changed from: private */
    /* renamed from: E */
    public void m5068E() {
        new Thread(new C1296e()).start();
    }

    /* access modifiers changed from: private */
    /* renamed from: F */
    public boolean m5069F() {
        this.f4108b.mo6837a();
        return true;
    }

    /* access modifiers changed from: private */
    /* renamed from: G */
    public void m5070G() {
        JSONObject b = C1437s.m5599b();
        C1437s.m5592a(b, "type", "AdColony.on_configuration_completed");
        JSONArray jSONArray = new JSONArray();
        for (String put : mo6558y().keySet()) {
            jSONArray.put(put);
        }
        JSONObject b2 = C1437s.m5599b();
        C1437s.m5593a(b2, "zone_ids", jSONArray);
        C1437s.m5594a(b, "message", b2);
        new C1454x("CustomMessage.controller_send", 0, b).mo6834d();
    }

    /* renamed from: H */
    private void m5071H() {
        Application application;
        Context b = C1199a.m4878b();
        if (b != null && this.f4105Q == null && Build.VERSION.SDK_INT > 14) {
            this.f4105Q = new C1304l();
            if (b instanceof Application) {
                application = (Application) b;
            } else {
                application = ((Activity) b).getApplication();
            }
            application.registerActivityLifecycleCallbacks(this.f4105Q);
        }
    }

    /* renamed from: I */
    private void m5072I() {
        if (C1199a.m4880c().mo6554u().mo6501e()) {
            int i = this.f4102N + 1;
            this.f4102N = i;
            this.f4103O = Math.min(this.f4103O * i, 120);
            C1359k0.m5309a((Runnable) new C1298g());
            return;
        }
        new C1439u.C1440a().mo6801a("Max launch server download attempts hit, or AdColony is no longer").mo6801a(" active.").mo6803a(C1439u.f4515h);
    }

    /* renamed from: s */
    static String m5112s() {
        return f4088V;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: A */
    public boolean mo6516A() {
        return this.f4091C;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: B */
    public boolean mo6517B() {
        return this.f4092D;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: C */
    public boolean mo6518C() {
        return this.f4093E;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: D */
    public boolean mo6519D() {
        return this.f4090B;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: q */
    public Partner mo6551q() {
        return this.f4106R;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: r */
    public AdColonyAppOptions mo6552r() {
        if (this.f4124r == null) {
            this.f4124r = new AdColonyAppOptions();
        }
        return this.f4124r;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: t */
    public AdColonyRewardListener mo6553t() {
        return this.f4122p;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: u */
    public C1286f0 mo6554u() {
        if (this.f4110d == null) {
            C1286f0 f0Var = new C1286f0();
            this.f4110d = f0Var;
            f0Var.mo6496c();
        }
        return this.f4110d;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: v */
    public C1289g0 mo6555v() {
        if (this.f4115i == null) {
            C1289g0 g0Var = new C1289g0();
            this.f4115i = g0Var;
            g0Var.mo6513e();
        }
        return this.f4115i;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: w */
    public C1316i0 mo6556w() {
        if (this.f4114h == null) {
            C1316i0 i0Var = new C1316i0();
            this.f4114h = i0Var;
            i0Var.mo6583a();
        }
        return this.f4114h;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: x */
    public HashMap<Integer, C1379m0> mo6557x() {
        return this.f4128v;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: y */
    public HashMap<String, AdColonyZone> mo6558y() {
        return this.f4127u;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: z */
    public boolean mo6559z() {
        return this.f4124r != null;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: g */
    public HashMap<String, AdColonyCustomMessageListener> mo6541g() {
        return this.f4123q;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: h */
    public C1336j mo6542h() {
        if (this.f4117k == null) {
            C1336j jVar = new C1336j();
            this.f4117k = jVar;
            jVar.mo6608H();
        }
        return this.f4117k;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: i */
    public C1353k mo6543i() {
        if (this.f4112f == null) {
            this.f4112f = new C1353k();
        }
        return this.f4112f;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: j */
    public C1375m mo6544j() {
        if (this.f4109c == null) {
            this.f4109c = new C1375m();
        }
        return this.f4109c;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: k */
    public C1413p mo6545k() {
        if (this.f4113g == null) {
            C1413p pVar = new C1413p();
            this.f4113g = pVar;
            pVar.mo6780b();
        }
        return this.f4113g;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: l */
    public JSONObject mo6546l() {
        return this.f4126t;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: m */
    public C1443w mo6547m() {
        if (this.f4116j == null) {
            C1443w wVar = new C1443w();
            this.f4116j = wVar;
            wVar.mo6822b();
        }
        return this.f4116j;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: n */
    public C1455y mo6548n() {
        if (this.f4108b == null) {
            C1455y yVar = new C1455y();
            this.f4108b = yVar;
            yVar.mo6837a();
        }
        return this.f4108b;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: o */
    public C1204b0 mo6549o() {
        if (this.f4118l == null) {
            this.f4118l = new C1204b0();
        }
        return this.f4118l;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: p */
    public String mo6550p() {
        return this.f4129w;
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public boolean m5098e(C1454x xVar) {
        if (this.f4122p == null) {
            return false;
        }
        C1359k0.m5309a((Runnable) new C1302j(xVar));
        return true;
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public void m5101f(C1454x xVar) {
        AdColonyZone adColonyZone;
        if (!this.f4092D) {
            String h = C1437s.m5613h(xVar.mo6830b(), "zone_id");
            if (this.f4127u.containsKey(h)) {
                adColonyZone = this.f4127u.get(h);
            } else {
                AdColonyZone adColonyZone2 = new AdColonyZone(h);
                this.f4127u.put(h, adColonyZone2);
                adColonyZone = adColonyZone2;
            }
            adColonyZone.mo6372a(xVar);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo6533b(boolean z) {
        this.f4092D = z;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public String mo6534c() {
        return this.f4089A;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public void mo6537d(C1454x xVar) {
        this.f4125s = xVar;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m5085b(C1454x xVar) {
        JSONObject b = this.f4124r.mo6272b();
        C1437s.m5592a(b, "app_id", this.f4124r.mo6271a());
        C1437s.m5593a(b, "zone_ids", this.f4124r.mo6275d());
        JSONObject b2 = C1437s.m5599b();
        C1437s.m5594a(b2, "options", b);
        xVar.mo6829a(b2).mo6834d();
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public boolean m5091c(C1454x xVar) {
        Context b = C1199a.m4878b();
        if (b == null) {
            return false;
        }
        try {
            int f = xVar.mo6830b().has("id") ? C1437s.m5611f(xVar.mo6830b(), "id") : 0;
            if (f <= 0) {
                f = this.f4108b.mo6844d();
            }
            mo6528a(f);
            C1359k0.m5309a((Runnable) new C1297f(b, C1437s.m5608d(xVar.mo6830b(), "is_display_module"), xVar));
            return true;
        } catch (RuntimeException e) {
            C1439u.C1440a aVar = new C1439u.C1440a();
            aVar.mo6801a(e.toString() + ": during WebView initialization.").mo6801a(" Disabling AdColony.").mo6803a(C1439u.f4516i);
            AdColony.disable();
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public AdColonyInterstitial mo6536d() {
        return this.f4121o;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public AdColonyAdView mo6539e() {
        return this.f4120n;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public Context mo6520a() {
        return C1199a.m4878b();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public void mo6538d(boolean z) {
        this.f4090B = z;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x00ff  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo6523a(com.adcolony.sdk.AdColonyAppOptions r5, boolean r6) {
        /*
            r4 = this;
            r4.f4092D = r6
            r4.f4124r = r5
            com.adcolony.sdk.y r0 = new com.adcolony.sdk.y
            r0.<init>()
            r4.f4108b = r0
            com.adcolony.sdk.i r0 = new com.adcolony.sdk.i
            r0.<init>()
            r4.f4107a = r0
            com.adcolony.sdk.m r0 = new com.adcolony.sdk.m
            r0.<init>()
            r4.f4109c = r0
            r0.mo6707b()
            com.adcolony.sdk.f0 r0 = new com.adcolony.sdk.f0
            r0.<init>()
            r4.f4110d = r0
            r0.mo6496c()
            com.adcolony.sdk.d r0 = new com.adcolony.sdk.d
            r0.<init>()
            r4.f4111e = r0
            r0.mo6461e()
            com.adcolony.sdk.k r0 = new com.adcolony.sdk.k
            r0.<init>()
            r4.f4112f = r0
            com.adcolony.sdk.p r0 = new com.adcolony.sdk.p
            r0.<init>()
            r4.f4113g = r0
            r0.mo6780b()
            com.adcolony.sdk.w r0 = new com.adcolony.sdk.w
            r0.<init>()
            r4.f4116j = r0
            r0.mo6822b()
            com.adcolony.sdk.g0 r0 = new com.adcolony.sdk.g0
            r0.<init>()
            r4.f4115i = r0
            r0.mo6513e()
            com.adcolony.sdk.i0 r0 = new com.adcolony.sdk.i0
            r0.<init>()
            r4.f4114h = r0
            r0.mo6583a()
            com.adcolony.sdk.j r0 = new com.adcolony.sdk.j
            r0.<init>()
            r4.f4117k = r0
            r0.mo6608H()
            com.adcolony.sdk.b0 r0 = new com.adcolony.sdk.b0
            r0.<init>()
            r4.f4118l = r0
            java.lang.String r0 = r0.mo6396a()
            r4.f4129w = r0
            android.content.Context r0 = com.adcolony.sdk.C1199a.m4878b()
            com.adcolony.sdk.AdColony.m4806a((android.content.Context) r0, (com.adcolony.sdk.AdColonyAppOptions) r5)
            r5 = 0
            r0 = 1
            if (r6 != 0) goto L_0x0125
            java.io.File r6 = new java.io.File
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            com.adcolony.sdk.g0 r2 = r4.f4115i
            java.lang.String r2 = r2.mo6509a()
            r1.append(r2)
            java.lang.String r2 = "026ae9c9824b3e483fa6c71fa88f57ae27816141"
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r6.<init>(r1)
            boolean r6 = r6.exists()
            r4.f4096H = r6
            java.io.File r6 = new java.io.File
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            com.adcolony.sdk.g0 r3 = r4.f4115i
            java.lang.String r3 = r3.mo6509a()
            r1.append(r3)
            java.lang.String r3 = "7bf3a1e7bbd31e612eda3310c2cdb8075c43c6b5"
            r1.append(r3)
            java.lang.String r1 = r1.toString()
            r6.<init>(r1)
            boolean r6 = r6.exists()
            r4.f4097I = r6
            boolean r1 = r4.f4096H
            if (r1 == 0) goto L_0x00f8
            if (r6 == 0) goto L_0x00f8
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            com.adcolony.sdk.g0 r1 = r4.f4115i
            java.lang.String r1 = r1.mo6509a()
            r6.append(r1)
            r6.append(r2)
            java.lang.String r6 = r6.toString()
            org.json.JSONObject r6 = com.adcolony.sdk.C1437s.m5605c(r6)
            java.lang.String r1 = "sdkVersion"
            java.lang.String r6 = com.adcolony.sdk.C1437s.m5613h(r6, r1)
            com.adcolony.sdk.j r1 = r4.f4117k
            java.lang.String r1 = r1.mo6603C()
            boolean r6 = r6.equals(r1)
            if (r6 == 0) goto L_0x00f8
            r6 = 1
            goto L_0x00f9
        L_0x00f8:
            r6 = 0
        L_0x00f9:
            r4.f4095G = r6
            boolean r6 = r4.f4096H
            if (r6 == 0) goto L_0x011d
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            com.adcolony.sdk.g0 r1 = r4.f4115i
            java.lang.String r1 = r1.mo6509a()
            r6.append(r1)
            r6.append(r2)
            java.lang.String r6 = r6.toString()
            org.json.JSONObject r6 = com.adcolony.sdk.C1437s.m5605c(r6)
            r4.f4126t = r6
            r4.m5086b((org.json.JSONObject) r6)
        L_0x011d:
            boolean r6 = r4.f4095G
            r4.m5081a((boolean) r6)
            r4.m5071H()
        L_0x0125:
            com.adcolony.sdk.h$k r6 = new com.adcolony.sdk.h$k
            r6.<init>()
            java.lang.String r1 = "Module.load"
            com.adcolony.sdk.C1199a.m4876a((java.lang.String) r1, (com.adcolony.sdk.C1458z) r6)
            com.adcolony.sdk.h$m r6 = new com.adcolony.sdk.h$m
            r6.<init>()
            java.lang.String r1 = "Module.unload"
            com.adcolony.sdk.C1199a.m4876a((java.lang.String) r1, (com.adcolony.sdk.C1458z) r6)
            com.adcolony.sdk.h$n r6 = new com.adcolony.sdk.h$n
            r6.<init>()
            java.lang.String r1 = "AdColony.on_configured"
            com.adcolony.sdk.C1199a.m4876a((java.lang.String) r1, (com.adcolony.sdk.C1458z) r6)
            com.adcolony.sdk.h$o r6 = new com.adcolony.sdk.h$o
            r6.<init>()
            java.lang.String r1 = "AdColony.get_app_info"
            com.adcolony.sdk.C1199a.m4876a((java.lang.String) r1, (com.adcolony.sdk.C1458z) r6)
            com.adcolony.sdk.h$p r6 = new com.adcolony.sdk.h$p
            r6.<init>()
            java.lang.String r1 = "AdColony.v4vc_reward"
            com.adcolony.sdk.C1199a.m4876a((java.lang.String) r1, (com.adcolony.sdk.C1458z) r6)
            com.adcolony.sdk.h$q r6 = new com.adcolony.sdk.h$q
            r6.<init>()
            java.lang.String r1 = "AdColony.zone_info"
            com.adcolony.sdk.C1199a.m4876a((java.lang.String) r1, (com.adcolony.sdk.C1458z) r6)
            com.adcolony.sdk.h$r r6 = new com.adcolony.sdk.h$r
            r6.<init>()
            java.lang.String r1 = "AdColony.probe_launch_server"
            com.adcolony.sdk.C1199a.m4876a((java.lang.String) r1, (com.adcolony.sdk.C1458z) r6)
            com.adcolony.sdk.h$s r6 = new com.adcolony.sdk.h$s
            r6.<init>()
            java.lang.String r1 = "Crypto.sha1"
            com.adcolony.sdk.C1199a.m4876a((java.lang.String) r1, (com.adcolony.sdk.C1458z) r6)
            com.adcolony.sdk.h$t r6 = new com.adcolony.sdk.h$t
            r6.<init>()
            java.lang.String r1 = "Crypto.crc32"
            com.adcolony.sdk.C1199a.m4876a((java.lang.String) r1, (com.adcolony.sdk.C1458z) r6)
            com.adcolony.sdk.h$a r6 = new com.adcolony.sdk.h$a
            r6.<init>()
            java.lang.String r1 = "Crypto.uuid"
            com.adcolony.sdk.C1199a.m4876a((java.lang.String) r1, (com.adcolony.sdk.C1458z) r6)
            com.adcolony.sdk.h$b r6 = new com.adcolony.sdk.h$b
            r6.<init>()
            java.lang.String r1 = "Device.query_advertiser_info"
            com.adcolony.sdk.C1199a.m4876a((java.lang.String) r1, (com.adcolony.sdk.C1458z) r6)
            com.adcolony.sdk.h$c r6 = new com.adcolony.sdk.h$c
            r6.<init>()
            java.lang.String r1 = "AdColony.controller_version"
            com.adcolony.sdk.C1199a.m4876a((java.lang.String) r1, (com.adcolony.sdk.C1458z) r6)
            com.adcolony.sdk.g0 r6 = r4.f4115i
            int r6 = com.adcolony.sdk.C1359k0.m5298a((com.adcolony.sdk.C1289g0) r6)
            if (r6 != r0) goto L_0x01a7
            r1 = 1
            goto L_0x01a8
        L_0x01a7:
            r1 = 0
        L_0x01a8:
            r4.f4099K = r1
            r1 = 2
            if (r6 != r1) goto L_0x01ae
            r5 = 1
        L_0x01ae:
            r4.f4100L = r5
            com.adcolony.sdk.h$d r5 = new com.adcolony.sdk.h$d
            r5.<init>()
            com.adcolony.sdk.C1359k0.m5309a((java.lang.Runnable) r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adcolony.sdk.C1290h.mo6523a(com.adcolony.sdk.AdColonyAppOptions, boolean):void");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public C1205c mo6540f() {
        return this.f4119m;
    }

    /* renamed from: b */
    private void m5086b(JSONObject jSONObject) {
        if (!C1379m0.f4345N) {
            JSONObject g = C1437s.m5612g(jSONObject, "logging");
            C1443w.f4538n = C1437s.m5578a(g, "send_level", 1);
            C1443w.f4529e = C1437s.m5608d(g, "log_private");
            C1443w.f4537m = C1437s.m5578a(g, "print_level", 3);
            this.f4116j.mo6824b(C1437s.m5604c(g, "modules"));
        }
        JSONObject g2 = C1437s.m5612g(jSONObject, "metadata");
        mo6542h().mo6614a(g2);
        mo6554u().mo6492a(C1437s.m5611f(g2, "session_timeout"));
        this.f4089A = C1437s.m5613h(C1437s.m5612g(jSONObject, "controller"), "version");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:?, code lost:
        new java.io.File(r3.f4115i.mo6509a() + f4085S).delete();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0037 */
    /* renamed from: c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean m5092c(org.json.JSONObject r4) {
        /*
            r3 = this;
            r0 = 0
            if (r4 != 0) goto L_0x0004
            return r0
        L_0x0004:
            java.lang.String r1 = "controller"
            org.json.JSONObject r1 = com.adcolony.sdk.C1437s.m5612g(r4, r1)     // Catch:{ Exception -> 0x0037 }
            java.lang.String r2 = "url"
            java.lang.String r2 = com.adcolony.sdk.C1437s.m5613h(r1, r2)     // Catch:{ Exception -> 0x0037 }
            r3.f4130x = r2     // Catch:{ Exception -> 0x0037 }
            java.lang.String r2 = "sha1"
            java.lang.String r1 = com.adcolony.sdk.C1437s.m5613h(r1, r2)     // Catch:{ Exception -> 0x0037 }
            r3.f4131y = r1     // Catch:{ Exception -> 0x0037 }
            java.lang.String r1 = "status"
            java.lang.String r1 = com.adcolony.sdk.C1437s.m5613h(r4, r1)     // Catch:{ Exception -> 0x0037 }
            r3.f4132z = r1     // Catch:{ Exception -> 0x0037 }
            java.lang.String r1 = "pie"
            java.lang.String r1 = com.adcolony.sdk.C1437s.m5613h(r4, r1)     // Catch:{ Exception -> 0x0037 }
            f4088V = r1     // Catch:{ Exception -> 0x0037 }
            boolean r1 = com.adcolony.sdk.AdColonyEventTracker.m4837a()     // Catch:{ Exception -> 0x0037 }
            if (r1 == 0) goto L_0x0033
            com.adcolony.sdk.AdColonyEventTracker.m4839b()     // Catch:{ Exception -> 0x0037 }
        L_0x0033:
            r3.m5086b((org.json.JSONObject) r4)     // Catch:{ Exception -> 0x0037 }
            goto L_0x0058
        L_0x0037:
            java.io.File r4 = new java.io.File     // Catch:{ Exception -> 0x0057 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0057 }
            r1.<init>()     // Catch:{ Exception -> 0x0057 }
            com.adcolony.sdk.g0 r2 = r3.f4115i     // Catch:{ Exception -> 0x0057 }
            java.lang.String r2 = r2.mo6509a()     // Catch:{ Exception -> 0x0057 }
            r1.append(r2)     // Catch:{ Exception -> 0x0057 }
            java.lang.String r2 = "026ae9c9824b3e483fa6c71fa88f57ae27816141"
            r1.append(r2)     // Catch:{ Exception -> 0x0057 }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x0057 }
            r4.<init>(r1)     // Catch:{ Exception -> 0x0057 }
            r4.delete()     // Catch:{ Exception -> 0x0057 }
            goto L_0x0058
        L_0x0057:
        L_0x0058:
            java.lang.String r4 = r3.f4132z
            java.lang.String r1 = "disable"
            boolean r4 = r4.equals(r1)
            if (r4 == 0) goto L_0x009f
            boolean r4 = com.adcolony.sdk.C1379m0.f4345N
            if (r4 != 0) goto L_0x009f
            java.io.File r4 = new java.io.File     // Catch:{ Exception -> 0x0085 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0085 }
            r1.<init>()     // Catch:{ Exception -> 0x0085 }
            com.adcolony.sdk.g0 r2 = r3.f4115i     // Catch:{ Exception -> 0x0085 }
            java.lang.String r2 = r2.mo6509a()     // Catch:{ Exception -> 0x0085 }
            r1.append(r2)     // Catch:{ Exception -> 0x0085 }
            java.lang.String r2 = "7bf3a1e7bbd31e612eda3310c2cdb8075c43c6b5"
            r1.append(r2)     // Catch:{ Exception -> 0x0085 }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x0085 }
            r4.<init>(r1)     // Catch:{ Exception -> 0x0085 }
            r4.delete()     // Catch:{ Exception -> 0x0085 }
        L_0x0085:
            com.adcolony.sdk.u$a r4 = new com.adcolony.sdk.u$a
            r4.<init>()
            java.lang.String r1 = "Launch server response with disabled status. Disabling AdColony "
            com.adcolony.sdk.u$a r4 = r4.mo6801a((java.lang.String) r1)
            java.lang.String r1 = "until next launch."
            com.adcolony.sdk.u$a r4 = r4.mo6801a((java.lang.String) r1)
            com.adcolony.sdk.u r1 = com.adcolony.sdk.C1439u.f4515h
            r4.mo6803a((com.adcolony.sdk.C1439u) r1)
            com.adcolony.sdk.AdColony.disable()
            return r0
        L_0x009f:
            java.lang.String r4 = r3.f4130x
            java.lang.String r1 = ""
            boolean r4 = r4.equals(r1)
            if (r4 != 0) goto L_0x00b1
            java.lang.String r4 = r3.f4132z
            boolean r4 = r4.equals(r1)
            if (r4 == 0) goto L_0x00cc
        L_0x00b1:
            boolean r4 = com.adcolony.sdk.C1379m0.f4345N
            if (r4 != 0) goto L_0x00cc
            com.adcolony.sdk.u$a r4 = new com.adcolony.sdk.u$a
            r4.<init>()
            java.lang.String r1 = "Missing controller status or URL. Disabling AdColony until next "
            com.adcolony.sdk.u$a r4 = r4.mo6801a((java.lang.String) r1)
            java.lang.String r1 = "launch."
            com.adcolony.sdk.u$a r4 = r4.mo6801a((java.lang.String) r1)
            com.adcolony.sdk.u r1 = com.adcolony.sdk.C1439u.f4517j
            r4.mo6803a((com.adcolony.sdk.C1439u) r1)
            return r0
        L_0x00cc:
            r4 = 1
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adcolony.sdk.C1290h.m5092c(org.json.JSONObject):boolean");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo6531b(AdColonyAppOptions adColonyAppOptions) {
        this.f4124r = adColonyAppOptions;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public C1222d mo6530b() {
        if (this.f4111e == null) {
            C1222d dVar = new C1222d();
            this.f4111e = dVar;
            dVar.mo6461e();
        }
        return this.f4111e;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo6532b(String str) {
        this.f4129w = str;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo6535c(boolean z) {
        this.f4091C = z;
    }

    /* renamed from: a */
    private boolean m5081a(boolean z) {
        return m5082a(z, false);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public boolean m5082a(boolean z, boolean z2) {
        if (!C1199a.m4881d()) {
            return false;
        }
        this.f4098J = z2;
        this.f4095G = z;
        if (z && !z2 && !m5069F()) {
            return false;
        }
        m5068E();
        return true;
    }

    /* renamed from: a */
    private boolean m5080a(JSONObject jSONObject) {
        if (!this.f4095G) {
            return true;
        }
        JSONObject jSONObject2 = this.f4126t;
        if (jSONObject2 != null && C1437s.m5613h(C1437s.m5612g(jSONObject2, "controller"), "sha1").equals(C1437s.m5613h(C1437s.m5612g(jSONObject, "controller"), "sha1"))) {
            return false;
        }
        new C1439u.C1440a().mo6801a("Controller sha1 does not match, downloading new controller.").mo6803a(C1439u.f4515h);
        return true;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m5074a(C1454x xVar) {
        mo6528a(C1437s.m5611f(xVar.mo6830b(), "id"));
    }

    /* renamed from: a */
    public void mo6527a(C1362l lVar, C1454x xVar, Map<String, List<String>> map) {
        if (lVar.f4277m.equals(f4087U)) {
            if (lVar.f4279o) {
                JSONObject a = C1437s.m5583a(lVar.f4278n, "Parsing launch response");
                C1437s.m5592a(a, "sdkVersion", mo6542h().mo6603C());
                C1437s.m5614i(a, this.f4115i.mo6509a() + f4085S);
                if (m5092c(a)) {
                    if (m5080a(a)) {
                        JSONObject b = C1437s.m5599b();
                        C1437s.m5592a(b, "url", this.f4130x);
                        C1437s.m5592a(b, "filepath", this.f4115i.mo6509a() + f4086T);
                        this.f4109c.mo6705a(new C1362l(new C1454x("WebServices.download", 0, b), this));
                    }
                    this.f4126t = a;
                } else if (!this.f4095G) {
                    new C1439u.C1440a().mo6801a("Incomplete or disabled launch server response. ").mo6801a("Disabling AdColony until next launch.").mo6803a(C1439u.f4516i);
                    mo6533b(true);
                }
            } else {
                m5072I();
            }
        } else if (!lVar.f4277m.equals(this.f4130x)) {
        } else {
            if (!m5079a(this.f4131y) && !C1379m0.f4345N) {
                new C1439u.C1440a().mo6801a("Downloaded controller sha1 does not match, retrying.").mo6803a(C1439u.f4514g);
                m5072I();
            } else if (!this.f4095G && !this.f4098J) {
                C1359k0.m5309a((Runnable) new C1300h());
            }
        }
    }

    /* renamed from: a */
    private boolean m5079a(String str) {
        Context b = C1199a.m4878b();
        if (b == null) {
            return false;
        }
        File file = new File(b.getFilesDir().getAbsolutePath() + "/adc3/" + f4086T);
        if (file.exists()) {
            return C1359k0.m5311a(str, file);
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo6529a(Context context, C1454x xVar) {
        boolean z;
        if (context == null) {
            return false;
        }
        String str = "";
        AdvertisingIdClient.Info info = null;
        C1282e0 a = mo6547m().mo6816a();
        try {
            info = AdvertisingIdClient.getAdvertisingIdInfo(context);
        } catch (NoClassDefFoundError unused) {
            new C1439u.C1440a().mo6801a("Google Play Services ads dependencies are missing. Collecting ").mo6801a("Android ID instead of Advertising ID.").mo6803a(C1439u.f4514g);
            return false;
        } catch (NoSuchMethodError unused2) {
            new C1439u.C1440a().mo6801a("Google Play Services is out of date, please update to GPS 4.0+. ").mo6801a("Collecting Android ID instead of Advertising ID.").mo6803a(C1439u.f4514g);
        } catch (Exception e) {
            e.printStackTrace();
            if (!Build.MANUFACTURER.equals("Amazon")) {
                new C1439u.C1440a().mo6801a("Advertising ID is not available. Collecting Android ID instead of").mo6801a(" Advertising ID.").mo6803a(C1439u.f4514g);
                return false;
            }
            str = mo6542h().mo6618c();
            z = mo6542h().mo6620d();
        }
        z = false;
        if (!Build.MANUFACTURER.equals("Amazon") && info == null) {
            return false;
        }
        if (!Build.MANUFACTURER.equals("Amazon")) {
            str = info.getId();
            z = info.isLimitAdTrackingEnabled();
        }
        mo6542h().mo6613a(str);
        if (a != null) {
            a.f4048e.put("advertisingId", mo6542h().mo6615b());
        }
        mo6542h().mo6619c(z);
        mo6542h().mo6617b(true);
        if (xVar != null) {
            JSONObject b = C1437s.m5599b();
            C1437s.m5592a(b, "advertiser_id", mo6542h().mo6615b());
            C1437s.m5603b(b, "limit_ad_tracking", mo6542h().mo6637u());
            xVar.mo6829a(b).mo6834d();
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo6522a(AdColonyAppOptions adColonyAppOptions) {
        synchronized (this.f4111e.mo6453a()) {
            for (Map.Entry<String, AdColonyInterstitial> value : this.f4111e.mo6453a().entrySet()) {
                AdColonyInterstitial adColonyInterstitial = (AdColonyInterstitial) value.getValue();
                AdColonyInterstitialListener listener = adColonyInterstitial.getListener();
                adColonyInterstitial.mo6322a(true);
                if (listener != null) {
                    listener.onExpiring(adColonyInterstitial);
                }
            }
            this.f4111e.mo6453a().clear();
        }
        this.f4093E = false;
        AdColony.m4806a(C1199a.m4878b(), adColonyAppOptions);
        mo6528a(1);
        this.f4127u.clear();
        this.f4124r = adColonyAppOptions;
        this.f4108b.mo6837a();
        m5082a(true, true);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo6528a(int i) {
        C1201a0 a = this.f4108b.mo6835a(i);
        C1379m0 remove = this.f4128v.remove(Integer.valueOf(i));
        boolean z = false;
        if (a == null) {
            return false;
        }
        if (remove != null && remove.mo6732u()) {
            z = true;
        }
        C1301i iVar = new C1301i(remove);
        if (z) {
            if (Looper.myLooper() == null) {
                Looper.prepare();
            }
            new Handler().postDelayed(iVar, 1000);
        } else {
            iVar.run();
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo6525a(AdColonyRewardListener adColonyRewardListener) {
        this.f4122p = adColonyRewardListener;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo6526a(C1205c cVar) {
        this.f4119m = cVar;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo6521a(AdColonyAdView adColonyAdView) {
        this.f4120n = adColonyAdView;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo6524a(AdColonyInterstitial adColonyInterstitial) {
        this.f4121o = adColonyInterstitial;
    }
}
