package com.chartboost.sdk;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.webkit.WebSettings;
import com.chartboost.sdk.Banner.C2061a;
import com.chartboost.sdk.Chartboost;
import com.chartboost.sdk.Libraries.C2074d;
import com.chartboost.sdk.Libraries.C2076e;
import com.chartboost.sdk.Libraries.C2078f;
import com.chartboost.sdk.Libraries.C2082i;
import com.chartboost.sdk.Libraries.CBLogging;
import com.chartboost.sdk.Model.C2092g;
import com.chartboost.sdk.Model.C2093h;
import com.chartboost.sdk.Model.CBError;
import com.chartboost.sdk.Tracking.C2098a;
import com.chartboost.sdk.impl.C2117a;
import com.chartboost.sdk.impl.C2120a1;
import com.chartboost.sdk.impl.C2126c;
import com.chartboost.sdk.impl.C2128c1;
import com.chartboost.sdk.impl.C2131d;
import com.chartboost.sdk.impl.C2143g;
import com.chartboost.sdk.impl.C2166i1;
import com.chartboost.sdk.impl.C2181n;
import com.chartboost.sdk.impl.C2186o;
import com.chartboost.sdk.impl.C2193o1;
import com.chartboost.sdk.impl.C2218v0;
import com.chartboost.sdk.impl.C2222w0;
import com.chartboost.sdk.impl.C2224x;
import com.chartboost.sdk.impl.C2225x0;
import com.chartboost.sdk.impl.C2234y0;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONObject;

/* renamed from: com.chartboost.sdk.j */
public class C2239j {

    /* renamed from: B */
    private static C2239j f7565B;

    /* renamed from: A */
    public final C2225x0 f7566A;

    /* renamed from: a */
    private final C2224x f7567a;

    /* renamed from: b */
    final C2078f f7568b;

    /* renamed from: c */
    final C2222w0 f7569c;

    /* renamed from: d */
    final C2082i f7570d;

    /* renamed from: e */
    final C2107e f7571e;

    /* renamed from: f */
    final C2234y0 f7572f;

    /* renamed from: g */
    final C2181n f7573g;

    /* renamed from: h */
    public C2100b f7574h = new C2100b();

    /* renamed from: i */
    final SharedPreferences f7575i;

    /* renamed from: j */
    public C2186o f7576j;

    /* renamed from: k */
    boolean f7577k = false;

    /* renamed from: l */
    boolean f7578l = true;

    /* renamed from: m */
    public final Executor f7579m;

    /* renamed from: n */
    public final C2074d f7580n;

    /* renamed from: o */
    public final C2143g f7581o;

    /* renamed from: p */
    public final C2117a f7582p;

    /* renamed from: q */
    public final C2143g f7583q;

    /* renamed from: r */
    public final C2117a f7584r;

    /* renamed from: s */
    public final C2218v0 f7585s;

    /* renamed from: t */
    public final C2092g f7586t;

    /* renamed from: u */
    public final C2143g f7587u;

    /* renamed from: v */
    public final C2117a f7588v;

    /* renamed from: w */
    public final AtomicReference<C2093h> f7589w;

    /* renamed from: x */
    public final C2098a f7590x;

    /* renamed from: y */
    public final Handler f7591y;

    /* renamed from: z */
    public final C2102d f7592z;

    /* renamed from: com.chartboost.sdk.j$b */
    public class C2241b implements Runnable {

        /* renamed from: a */
        final int f7595a;

        /* renamed from: b */
        String f7596b = null;

        /* renamed from: c */
        boolean f7597c = false;

        /* renamed from: d */
        boolean f7598d = false;

        /* renamed from: e */
        ChartboostBanner f7599e = null;

        C2241b(int i) {
            this.f7595a = i;
        }

        /* renamed from: a */
        private void m8918a() {
            C2116i a = C2116i.m8407a();
            C2131d a2 = C2131d.m8467a((C2126c) this.f7599e);
            C2239j jVar = C2239j.this;
            C2239j jVar2 = jVar;
            C2061a aVar = r2;
            C2061a aVar2 = new C2061a(a2, (ScheduledExecutorService) jVar.f7579m, jVar.f7573g, jVar.f7568b, jVar.f7585s, jVar.f7569c, jVar.f7586t, jVar.f7589w, jVar.f7575i, jVar.f7570d, jVar.f7590x, jVar.f7591y, jVar2.f7592z, jVar2.f7566A, jVar2.f7571e, jVar2.f7572f);
            C2061a aVar3 = (C2061a) a.mo9266a(aVar);
            aVar3.mo8997a(this.f7599e);
            Executor executor = C2239j.this.f7579m;
            aVar3.getClass();
            executor.execute(new C2143g.C2145b(0, (String) null, (C2151h) null, (CBError.CBImpressionError) null));
            C2239j.this.f7574h.mo9180a(this.f7599e.getLocation(), aVar3);
        }

        public void run() {
            try {
                switch (this.f7595a) {
                    case 0:
                        C2239j.this.mo9604b();
                        return;
                    case 1:
                        C2242k.f7618r = this.f7597c;
                        return;
                    case 2:
                        C2242k.f7620t = this.f7598d;
                        if (!this.f7598d || !C2239j.m8899p()) {
                            C2239j.this.f7576j.mo9444a();
                            return;
                        } else {
                            C2239j.this.f7576j.mo9445b();
                            return;
                        }
                    case 3:
                        C2128c1 c1Var = new C2128c1("https://live.chartboost.com", "/api/install", C2239j.this.f7586t, C2239j.this.f7590x, 2, (C2128c1.C2129a) null);
                        c1Var.f7130m = true;
                        C2239j.this.f7585s.mo9524a(c1Var);
                        Executor executor = C2239j.this.f7579m;
                        C2143g gVar = C2239j.this.f7581o;
                        gVar.getClass();
                        executor.execute(new C2143g.C2145b(0, (String) null, (C2151h) null, (CBError.CBImpressionError) null));
                        Executor executor2 = C2239j.this.f7579m;
                        C2143g gVar2 = C2239j.this.f7583q;
                        gVar2.getClass();
                        executor2.execute(new C2143g.C2145b(0, (String) null, (C2151h) null, (CBError.CBImpressionError) null));
                        Executor executor3 = C2239j.this.f7579m;
                        C2143g gVar3 = C2239j.this.f7587u;
                        gVar3.getClass();
                        executor3.execute(new C2143g.C2145b(0, (String) null, (C2151h) null, (CBError.CBImpressionError) null));
                        C2239j.this.f7579m.execute(new C2241b(4));
                        C2239j.this.f7578l = false;
                        return;
                    case 4:
                        C2239j.this.f7576j.mo9445b();
                        return;
                    case 5:
                        if (C2242k.f7604d != null) {
                            C2242k.f7604d.didFailToLoadMoreApps(this.f7596b, CBError.CBImpressionError.END_POINT_DISABLED);
                            return;
                        }
                        return;
                    case 6:
                        m8918a();
                        return;
                    default:
                        return;
                }
            } catch (Exception e) {
                C2098a.m8288a(C2241b.class, "run (" + this.f7595a + ")", e);
            }
            C2098a.m8288a(C2241b.class, "run (" + this.f7595a + ")", e);
        }
    }

    C2239j(Context context, String str, String str2, C2224x xVar, ScheduledExecutorService scheduledExecutorService, Handler handler, Executor executor) {
        JSONObject jSONObject;
        Context context2 = context;
        C2224x xVar2 = xVar;
        ScheduledExecutorService scheduledExecutorService2 = scheduledExecutorService;
        Handler handler2 = handler;
        C2116i a = C2116i.m8407a();
        C2242k.f7612l = context2;
        this.f7580n = (C2074d) a.mo9266a(new C2074d(context2));
        this.f7569c = (C2222w0) a.mo9266a(new C2222w0());
        this.f7570d = (C2082i) a.mo9266a(new C2082i());
        this.f7585s = (C2218v0) a.mo9266a(new C2218v0(scheduledExecutorService, (C2120a1) a.mo9266a(new C2120a1()), this.f7569c, this.f7570d, handler, executor));
        SharedPreferences a2 = m8892a(C2242k.f7612l);
        try {
            jSONObject = new JSONObject(a2.getString("config", "{}"));
        } catch (Exception e) {
            CBLogging.m8154b("Sdk", "Unable to process config");
            e.printStackTrace();
            jSONObject = new JSONObject();
        }
        AtomicReference<C2093h> atomicReference = new AtomicReference<>((Object) null);
        if (!C2101c.m8328a(atomicReference, jSONObject, a2)) {
            atomicReference.set(new C2093h(new JSONObject()));
        }
        this.f7567a = xVar2;
        this.f7579m = scheduledExecutorService2;
        this.f7589w = atomicReference;
        this.f7575i = a2;
        this.f7591y = handler2;
        this.f7568b = new C2078f(xVar2, C2242k.f7612l, atomicReference);
        if (!atomicReference.get().f7023w) {
            C2242k.f7621u = "";
        } else {
            m8895b(C2242k.f7612l);
        }
        AtomicReference<C2093h> atomicReference2 = atomicReference;
        this.f7586t = (C2092g) a.mo9266a(new C2092g(C2242k.f7612l, str, this.f7580n, this.f7569c, atomicReference2, a2, this.f7570d));
        C2098a aVar = (C2098a) a.mo9266a(new C2098a(atomicReference));
        this.f7590x = aVar;
        this.f7573g = (C2181n) a.mo9266a(new C2181n(scheduledExecutorService, this.f7568b, this.f7585s, this.f7569c, atomicReference2, this.f7570d, aVar));
        this.f7571e = (C2107e) a.mo9266a(new C2107e((C2193o1) C2116i.m8407a().mo9266a(new C2193o1(handler2)), this.f7573g, atomicReference, handler2));
        this.f7566A = (C2225x0) a.mo9266a(new C2225x0(scheduledExecutorService2, this.f7585s, this.f7569c, handler2));
        C2116i iVar = a;
        this.f7592z = (C2102d) iVar.mo9266a(new C2102d(this.f7569c, this, this.f7590x, handler, this.f7571e));
        this.f7572f = (C2234y0) iVar.mo9266a(new C2234y0(this.f7568b));
        this.f7582p = C2117a.m8409a();
        this.f7584r = C2117a.m8410b();
        this.f7588v = C2117a.m8411c();
        C2116i iVar2 = iVar;
        SharedPreferences sharedPreferences = a2;
        ScheduledExecutorService scheduledExecutorService3 = scheduledExecutorService;
        AtomicReference<C2093h> atomicReference3 = atomicReference;
        SharedPreferences sharedPreferences2 = sharedPreferences;
        Handler handler3 = handler;
        this.f7581o = (C2143g) iVar2.mo9266a(new C2143g(this.f7582p, scheduledExecutorService3, this.f7573g, this.f7568b, this.f7585s, this.f7569c, this.f7586t, atomicReference3, sharedPreferences2, this.f7570d, this.f7590x, handler3, this.f7592z, this.f7566A, this.f7571e, this.f7572f));
        this.f7583q = (C2143g) iVar2.mo9266a(new C2143g(this.f7584r, scheduledExecutorService3, this.f7573g, this.f7568b, this.f7585s, this.f7569c, this.f7586t, atomicReference3, sharedPreferences2, this.f7570d, this.f7590x, handler3, this.f7592z, this.f7566A, this.f7571e, this.f7572f));
        this.f7587u = (C2143g) iVar2.mo9266a(new C2143g(this.f7588v, scheduledExecutorService3, this.f7573g, this.f7568b, this.f7585s, this.f7569c, this.f7586t, atomicReference3, sharedPreferences2, this.f7570d, this.f7590x, handler3, this.f7592z, this.f7566A, this.f7571e, this.f7572f));
        this.f7576j = (C2186o) iVar2.mo9266a(new C2186o(this.f7573g, this.f7568b, this.f7585s, this.f7586t, this.f7590x, atomicReference));
        C2242k.f7610j = str;
        C2242k.f7611k = str2;
        if (!sharedPreferences.contains("cbLimitTrack") || sharedPreferences.contains("cbGDPR")) {
            C2242k.f7622v = Chartboost.CBPIDataUseConsent.valueOf(sharedPreferences.getInt("cbGDPR", C2242k.f7622v.getValue()));
        } else {
            C2242k.f7622v = sharedPreferences.getBoolean("cbLimitTrack", false) ? Chartboost.CBPIDataUseConsent.NO_BEHAVIORAL : Chartboost.CBPIDataUseConsent.UNKNOWN;
        }
    }

    /* renamed from: a */
    public static void m8894a(C2239j jVar) {
        f7565B = jVar;
    }

    /* renamed from: n */
    public static C2239j m8897n() {
        return f7565B;
    }

    /* renamed from: o */
    public static C2100b m8898o() {
        C2239j n = m8897n();
        if (n != null) {
            return n.f7574h;
        }
        return null;
    }

    /* renamed from: p */
    public static boolean m8899p() {
        C2239j n = m8897n();
        if (n == null || !n.mo9610h().mo9152a()) {
            return true;
        }
        try {
            throw new Exception("Chartboost Integration Warning: your account has been disabled for this session. This app has no active publishing campaigns, please create a publishing campaign in the Chartboost dashboard and wait at least 30 minutes to re-enable. If you need assistance, please visit http://chartboo.st/publishing .");
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /* renamed from: q */
    private void m8900q() {
        this.f7590x.mo9169b();
        if (!this.f7578l) {
            mo9603a((Runnable) new C2241b(3));
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo9604b() {
        this.f7590x.mo9158a();
    }

    /* renamed from: c */
    public C2093h.C2094a mo9605c() {
        C2093h hVar;
        AtomicReference<C2093h> atomicReference = this.f7589w;
        if (atomicReference == null || (hVar = atomicReference.get()) == null) {
            return null;
        }
        return hVar.f7000E;
    }

    /* renamed from: d */
    public C2143g mo9606d() {
        return this.f7583q;
    }

    /* renamed from: e */
    public C2117a mo9607e() {
        return this.f7584r;
    }

    /* renamed from: f */
    public C2143g mo9608f() {
        return this.f7587u;
    }

    /* renamed from: g */
    public C2117a mo9609g() {
        return this.f7588v;
    }

    /* renamed from: h */
    public C2093h mo9610h() {
        return this.f7589w.get();
    }

    /* renamed from: i */
    public Handler mo9611i() {
        return this.f7591y;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: j */
    public void mo9612j() {
        if (!this.f7577k) {
            C2099a aVar = C2242k.f7604d;
            if (aVar != null) {
                aVar.didInitialize();
            }
            this.f7577k = true;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: k */
    public void mo9613k() {
        Application application;
        Application.ActivityLifecycleCallbacks activityLifecycleCallbacks;
        C2166i1.m8609a("Chartboost.setActivityCallbacks");
        try {
            application = (Application) C2242k.f7612l;
        } catch (Exception unused) {
            CBLogging.m8159e("Sdk", "Wrong context. Can't retrieve the application object.");
            application = null;
        }
        if (application != null && (activityLifecycleCallbacks = this.f7592z.f7050i) != null) {
            C2242k.f7617q = true;
            application.registerActivityLifecycleCallbacks(activityLifecycleCallbacks);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: l */
    public void mo9614l() {
        if (C2242k.f7612l == null) {
            CBLogging.m8154b("Sdk", "The context must be set through the Chartboost method onCreate() before calling startSession().");
        } else {
            m8900q();
        }
    }

    /* renamed from: m */
    public void mo9615m() {
        this.f7573g.mo9436c();
    }

    /* renamed from: a */
    private static SharedPreferences m8892a(Context context) {
        return context.getSharedPreferences("cbPrefs", 0);
    }

    /* renamed from: b */
    public static void m8896b(Runnable runnable) {
        C2224x e = C2224x.m8805e();
        if (!e.mo9552d()) {
            e.f7490a.post(runnable);
        } else {
            runnable.run();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo9603a(Runnable runnable) {
        C2128c1 c1Var = new C2128c1("https://live.chartboost.com", "/api/config", this.f7586t, this.f7590x, 1, new C2240a(runnable));
        c1Var.f7130m = true;
        this.f7585s.mo9524a(c1Var);
    }

    /* renamed from: b */
    public static void m8895b(Context context) {
        String property = System.getProperty("http.agent");
        try {
            property = WebSettings.getDefaultUserAgent(context);
        } catch (Exception unused) {
        }
        C2242k.f7621u = property;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo9602a(Activity activity) {
        if (this.f7567a.mo9548a(23)) {
            C2101c.m8330b(activity);
        }
        if (!this.f7578l && !this.f7592z.mo9203f()) {
            this.f7573g.mo9435b();
        }
    }

    /* renamed from: com.chartboost.sdk.j$a */
    class C2240a implements C2128c1.C2129a {

        /* renamed from: a */
        final /* synthetic */ Runnable f7593a;

        C2240a(Runnable runnable) {
            this.f7593a = runnable;
        }

        /* renamed from: a */
        public void mo9300a(C2128c1 c1Var, JSONObject jSONObject) {
            JSONObject a = C2076e.m8185a(jSONObject, "response");
            if (a != null) {
                C2239j jVar = C2239j.this;
                if (C2101c.m8328a(jVar.f7589w, a, jVar.f7575i)) {
                    C2239j.this.f7575i.edit().putString("config", a.toString()).apply();
                }
            }
            Runnable runnable = this.f7593a;
            if (runnable != null) {
                runnable.run();
            }
            if (!C2239j.this.f7577k) {
                C2099a aVar = C2242k.f7604d;
                if (aVar != null) {
                    aVar.didInitialize();
                }
                C2239j.this.f7577k = true;
            }
        }

        /* renamed from: a */
        public void mo9299a(C2128c1 c1Var, CBError cBError) {
            Runnable runnable = this.f7593a;
            if (runnable != null) {
                runnable.run();
            }
            if (!C2239j.this.f7577k) {
                C2099a aVar = C2242k.f7604d;
                if (aVar != null) {
                    aVar.didInitialize();
                }
                C2239j.this.f7577k = true;
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo9601a() {
        this.f7591y.postDelayed(new C2241b(0), 500);
    }

    /* renamed from: a */
    static void m8893a(Context context, Chartboost.CBPIDataUseConsent cBPIDataUseConsent) {
        C2242k.f7622v = cBPIDataUseConsent;
        SharedPreferences a = m8892a(context);
        if (a != null) {
            a.edit().putInt("cbGDPR", cBPIDataUseConsent.getValue()).apply();
        }
    }
}
