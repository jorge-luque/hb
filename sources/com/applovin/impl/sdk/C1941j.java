package com.applovin.impl.sdk;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.StrictMode;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.applovin.impl.adview.C1548c;
import com.applovin.impl.mediation.C1736g;
import com.applovin.impl.mediation.C1741h;
import com.applovin.impl.mediation.C1742i;
import com.applovin.impl.mediation.C1779k;
import com.applovin.impl.mediation.MediationServiceImpl;
import com.applovin.impl.mediation.p037a.C1645a;
import com.applovin.impl.mediation.p045b.C1701e;
import com.applovin.impl.sdk.network.C1956a;
import com.applovin.impl.sdk.network.C1962c;
import com.applovin.impl.sdk.network.C1965e;
import com.applovin.impl.sdk.network.PostbackServiceImpl;
import com.applovin.impl.sdk.p049ad.C1822e;
import com.applovin.impl.sdk.p050b.C1840b;
import com.applovin.impl.sdk.p050b.C1841c;
import com.applovin.impl.sdk.p050b.C1842d;
import com.applovin.impl.sdk.p050b.C1843e;
import com.applovin.impl.sdk.p050b.C1844f;
import com.applovin.impl.sdk.p051c.C1848c;
import com.applovin.impl.sdk.p051c.C1856f;
import com.applovin.impl.sdk.p051c.C1859g;
import com.applovin.impl.sdk.p051c.C1860h;
import com.applovin.impl.sdk.p052d.C1864a;
import com.applovin.impl.sdk.p052d.C1871ad;
import com.applovin.impl.sdk.p052d.C1892k;
import com.applovin.impl.sdk.p052d.C1907s;
import com.applovin.impl.sdk.utils.C1992h;
import com.applovin.impl.sdk.utils.C1993i;
import com.applovin.impl.sdk.utils.C2024n;
import com.applovin.impl.sdk.utils.C2028q;
import com.applovin.impl.sdk.utils.C2029r;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.sdk.AppLovinEventService;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkConfiguration;
import com.applovin.sdk.AppLovinSdkSettings;
import com.applovin.sdk.AppLovinSdkUtils;
import com.applovin.sdk.AppLovinUserService;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.sdk.j */
public class C1941j {

    /* renamed from: a */
    protected static Context f6399a;

    /* renamed from: A */
    private C2037w f6400A;

    /* renamed from: B */
    private C1798a f6401B;

    /* renamed from: C */
    private C1974p f6402C;

    /* renamed from: D */
    private C2036v f6403D;
    /* access modifiers changed from: private */

    /* renamed from: E */
    public C1962c f6404E;

    /* renamed from: F */
    private C1927f f6405F;

    /* renamed from: G */
    private C2024n f6406G;

    /* renamed from: H */
    private C1924e f6407H;

    /* renamed from: I */
    private C1952l f6408I;

    /* renamed from: J */
    private PostbackServiceImpl f6409J;

    /* renamed from: K */
    private C1965e f6410K;

    /* renamed from: L */
    private C1742i f6411L;

    /* renamed from: M */
    private C1741h f6412M;

    /* renamed from: N */
    private MediationServiceImpl f6413N;

    /* renamed from: O */
    private C1779k f6414O;

    /* renamed from: P */
    private C1645a f6415P;

    /* renamed from: Q */
    private C1978r f6416Q;

    /* renamed from: R */
    private C1736g f6417R;
    /* access modifiers changed from: private */

    /* renamed from: S */
    public final Object f6418S = new Object();

    /* renamed from: T */
    private final AtomicBoolean f6419T = new AtomicBoolean(true);
    /* access modifiers changed from: private */

    /* renamed from: U */
    public boolean f6420U = false;

    /* renamed from: V */
    private boolean f6421V = false;

    /* renamed from: W */
    private boolean f6422W = false;

    /* renamed from: X */
    private boolean f6423X = false;

    /* renamed from: Y */
    private boolean f6424Y = false;

    /* renamed from: Z */
    private boolean f6425Z = false;

    /* renamed from: aa */
    private String f6426aa = "";

    /* renamed from: ab */
    private AppLovinSdk.SdkInitializationListener f6427ab;

    /* renamed from: ac */
    private AppLovinSdk.SdkInitializationListener f6428ac;
    /* access modifiers changed from: private */

    /* renamed from: ad */
    public AppLovinSdkConfiguration f6429ad;

    /* renamed from: b */
    protected C1842d f6430b;

    /* renamed from: c */
    private String f6431c;

    /* renamed from: d */
    private WeakReference<Activity> f6432d;

    /* renamed from: e */
    private long f6433e;

    /* renamed from: f */
    private AppLovinSdkSettings f6434f;

    /* renamed from: g */
    private AppLovinAdServiceImpl f6435g;

    /* renamed from: h */
    private NativeAdServiceImpl f6436h;

    /* renamed from: i */
    private EventServiceImpl f6437i;

    /* renamed from: j */
    private UserServiceImpl f6438j;

    /* renamed from: k */
    private VariableServiceImpl f6439k;

    /* renamed from: l */
    private AppLovinSdk f6440l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public C1977q f6441m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public C1907s f6442n;

    /* renamed from: o */
    private C1956a f6443o;

    /* renamed from: p */
    private C1860h f6444p;

    /* renamed from: q */
    private C1945k f6445q;

    /* renamed from: r */
    private C1844f f6446r;

    /* renamed from: s */
    private C1856f f6447s;

    /* renamed from: t */
    private C1935i f6448t;

    /* renamed from: u */
    private C2028q f6449u;

    /* renamed from: v */
    private C1845c f6450v;

    /* renamed from: w */
    private C1979s f6451w;

    /* renamed from: x */
    private C1973o f6452x;

    /* renamed from: y */
    private C1822e f6453y;

    /* renamed from: z */
    private C1848c f6454z;

    /* renamed from: F */
    public static Context m7443F() {
        return f6399a;
    }

    /* renamed from: aj */
    private void m7445aj() {
        this.f6404E.mo8674a((C1962c.C1963a) new C1962c.C1963a() {
            /* renamed from: a */
            public void mo8609a() {
                C1941j.this.f6441m.mo8744c("AppLovinSdk", "Connected to internet - re-initializing SDK");
                synchronized (C1941j.this.f6418S) {
                    if (!C1941j.this.f6420U) {
                        C1941j.this.mo8577b();
                    }
                }
                C1941j.this.f6404E.mo8675b(this);
            }

            /* renamed from: b */
            public void mo8610b() {
            }
        });
    }

    /* renamed from: A */
    public C1645a mo8523A() {
        return this.f6415P;
    }

    /* renamed from: B */
    public C1779k mo8524B() {
        return this.f6414O;
    }

    /* renamed from: C */
    public C1736g mo8525C() {
        return this.f6417R;
    }

    /* renamed from: D */
    public C1842d mo8526D() {
        return this.f6430b;
    }

    /* renamed from: E */
    public Context mo8527E() {
        return f6399a;
    }

    /* renamed from: G */
    public Activity mo8528G() {
        WeakReference<Activity> weakReference = this.f6432d;
        if (weakReference != null) {
            return (Activity) weakReference.get();
        }
        return null;
    }

    /* renamed from: H */
    public long mo8529H() {
        return this.f6433e;
    }

    /* renamed from: I */
    public boolean mo8530I() {
        return this.f6423X;
    }

    /* renamed from: J */
    public boolean mo8531J() {
        return this.f6424Y;
    }

    /* renamed from: K */
    public C1956a mo8532K() {
        return this.f6443o;
    }

    /* renamed from: L */
    public C1907s mo8533L() {
        return this.f6442n;
    }

    /* renamed from: M */
    public C1860h mo8534M() {
        return this.f6444p;
    }

    /* renamed from: N */
    public C1965e mo8535N() {
        return this.f6410K;
    }

    /* renamed from: O */
    public C1945k mo8536O() {
        return this.f6445q;
    }

    /* renamed from: P */
    public C1856f mo8537P() {
        return this.f6447s;
    }

    /* renamed from: Q */
    public C1935i mo8538Q() {
        return this.f6448t;
    }

    /* renamed from: R */
    public PostbackServiceImpl mo8539R() {
        return this.f6409J;
    }

    /* renamed from: S */
    public AppLovinSdk mo8540S() {
        return this.f6440l;
    }

    /* renamed from: T */
    public C1845c mo8541T() {
        return this.f6450v;
    }

    /* renamed from: U */
    public C1979s mo8542U() {
        return this.f6451w;
    }

    /* renamed from: V */
    public C1973o mo8543V() {
        return this.f6452x;
    }

    /* renamed from: W */
    public C1822e mo8544W() {
        return this.f6453y;
    }

    /* renamed from: X */
    public C1848c mo8545X() {
        return this.f6454z;
    }

    /* renamed from: Y */
    public C2037w mo8546Y() {
        return this.f6400A;
    }

    /* renamed from: Z */
    public C1974p mo8547Z() {
        return this.f6402C;
    }

    /* renamed from: a */
    public <ST> C1841c<ST> mo8548a(String str, C1841c<ST> cVar) {
        return this.f6430b.mo8301a(str, cVar);
    }

    /* renamed from: a */
    public <T> T mo8549a(C1841c<T> cVar) {
        return this.f6430b.mo8302a(cVar);
    }

    /* renamed from: a */
    public <T> T mo8550a(C1843e<T> eVar) {
        return mo8574b(eVar, (Object) null);
    }

    /* renamed from: a */
    public <T> T mo8551a(String str, T t, Class cls, SharedPreferences sharedPreferences) {
        return C1844f.m7056a(str, t, cls, sharedPreferences);
    }

    /* renamed from: a */
    public void mo8552a() {
        synchronized (this.f6418S) {
            if (!this.f6420U && !this.f6421V) {
                mo8577b();
            }
        }
    }

    /* renamed from: a */
    public void mo8553a(long j) {
        this.f6448t.mo8516a(j);
    }

    /* renamed from: a */
    public void mo8554a(SharedPreferences sharedPreferences) {
        this.f6446r.mo8315a(sharedPreferences);
    }

    /* renamed from: a */
    public void mo8555a(C1701e eVar) {
        if (!this.f6442n.mo8478a()) {
            List<String> b = mo8576b(C1840b.f5763a);
            if (b.size() > 0 && this.f6412M.mo7891b().containsAll(b)) {
                this.f6441m.mo8742b("AppLovinSdk", "All required adapters initialized");
                this.f6442n.mo8482e();
                mo8585f();
            }
        }
    }

    /* renamed from: a */
    public <T> void mo8556a(C1843e<T> eVar, T t) {
        this.f6446r.mo8317a(eVar, t);
    }

    /* renamed from: a */
    public <T> void mo8557a(C1843e<T> eVar, T t, SharedPreferences sharedPreferences) {
        this.f6446r.mo8318a(eVar, t, sharedPreferences);
    }

    /* renamed from: a */
    public void mo8558a(AppLovinSdk.SdkInitializationListener sdkInitializationListener) {
        if (!mo8583d()) {
            this.f6427ab = sdkInitializationListener;
        } else if (sdkInitializationListener != null) {
            sdkInitializationListener.onSdkInitialized(this.f6429ad);
        }
    }

    /* renamed from: a */
    public void mo8559a(AppLovinSdk appLovinSdk) {
        this.f6440l = appLovinSdk;
    }

    /* renamed from: a */
    public void mo8560a(String str) {
        C1977q.m7748f("AppLovinSdk", "Setting plugin version: " + str);
        this.f6430b.mo8304a((C1841c<?>) C1841c.f5975dR, (Object) str);
        this.f6430b.mo8307b();
    }

    /* renamed from: a */
    public void mo8561a(String str, AppLovinSdkSettings appLovinSdkSettings, Context context) {
        C1843e<String> eVar;
        C1844f fVar;
        String str2;
        this.f6431c = str;
        this.f6433e = System.currentTimeMillis();
        this.f6434f = appLovinSdkSettings;
        this.f6429ad = new SdkConfigurationImpl(this);
        f6399a = context.getApplicationContext();
        if (context instanceof Activity) {
            this.f6432d = new WeakReference<>((Activity) context);
        }
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        this.f6441m = new C1977q(this);
        this.f6446r = new C1844f(this);
        C1842d dVar = new C1842d(this);
        this.f6430b = dVar;
        dVar.mo8309c();
        this.f6430b.mo8303a();
        C1856f fVar2 = new C1856f(this);
        this.f6447s = fVar2;
        fVar2.mo8383b();
        this.f6452x = new C1973o(this);
        this.f6450v = new C1845c(this);
        this.f6451w = new C1979s(this);
        this.f6453y = new C1822e(this);
        this.f6437i = new EventServiceImpl(this);
        this.f6438j = new UserServiceImpl(this);
        this.f6439k = new VariableServiceImpl(this);
        this.f6454z = new C1848c(this);
        this.f6442n = new C1907s(this);
        this.f6443o = new C1956a(this);
        this.f6444p = new C1860h(this);
        this.f6445q = new C1945k(this);
        this.f6401B = new C1798a(context);
        this.f6435g = new AppLovinAdServiceImpl(this);
        this.f6436h = new NativeAdServiceImpl(this);
        this.f6400A = new C2037w(this);
        this.f6402C = new C1974p(this);
        this.f6409J = new PostbackServiceImpl(this);
        this.f6410K = new C1965e(this);
        this.f6411L = new C1742i(this);
        this.f6412M = new C1741h(this);
        this.f6413N = new MediationServiceImpl(this);
        this.f6416Q = new C1978r(this);
        this.f6415P = new C1645a(this);
        this.f6414O = new C1779k();
        this.f6417R = new C1736g(this);
        this.f6448t = new C1935i(this);
        this.f6449u = new C2028q(this);
        this.f6403D = new C2036v(this);
        this.f6406G = new C2024n(this);
        this.f6407H = new C1924e(this);
        this.f6408I = new C1952l(this);
        this.f6405F = new C1927f(this);
        if (((Boolean) this.f6430b.mo8302a(C1841c.f6009dz)).booleanValue()) {
            this.f6404E = new C1962c(context);
        }
        if (TextUtils.isEmpty(str)) {
            this.f6422W = true;
            C1977q.m7751i("AppLovinSdk", "Unable to find AppLovin SDK key. Please add  meta-data android:name=\"applovin.sdk.key\" android:value=\"YOUR_SDK_KEY_HERE\" into AndroidManifest.xml.");
            StringWriter stringWriter = new StringWriter();
            new Throwable("").printStackTrace(new PrintWriter(stringWriter));
            String stringWriter2 = stringWriter.toString();
            C1977q.m7751i("AppLovinSdk", "Called with an invalid SDK key from: " + stringWriter2);
        }
        if (!mo8601u()) {
            if (C2029r.m8015a(context)) {
                appLovinSdkSettings.setVerboseLogging(true);
            }
            mo8526D().mo8304a((C1841c<?>) C1841c.f5795V, (Object) Boolean.valueOf(appLovinSdkSettings.isVerboseLoggingEnabled()));
            mo8526D().mo8307b();
            Class<C1548c> cls = C1548c.class;
            SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
            if (TextUtils.isEmpty((String) this.f6446r.mo8322b(C1843e.f6087a, null, defaultSharedPreferences))) {
                this.f6423X = true;
                fVar = this.f6446r;
                eVar = C1843e.f6087a;
                str2 = Boolean.toString(true);
            } else {
                fVar = this.f6446r;
                eVar = C1843e.f6087a;
                str2 = Boolean.toString(false);
            }
            fVar.mo8318a(eVar, str2, defaultSharedPreferences);
            if (((Boolean) this.f6446r.mo8321b(C1843e.f6088b, false)).booleanValue()) {
                this.f6441m.mo8742b("AppLovinSdk", "Initializing SDK for non-maiden launch");
                this.f6424Y = true;
            } else {
                this.f6441m.mo8742b("AppLovinSdk", "Initializing SDK for maiden launch");
                this.f6446r.mo8317a(C1843e.f6088b, true);
            }
            C2029r.m8007a(C1843e.f6093g, 100, this);
            boolean a = C1992h.m7853a(mo8527E());
            if (!((Boolean) this.f6430b.mo8302a(C1841c.f5958dA)).booleanValue() || a) {
                mo8577b();
            }
            if (((Boolean) this.f6430b.mo8302a(C1841c.f6009dz)).booleanValue() && !a) {
                this.f6441m.mo8744c("AppLovinSdk", "SDK initialized with no internet connection - listening for connection");
                m7445aj();
            }
        } else {
            mo8564a(false);
        }
        StrictMode.setThreadPolicy(allowThreadDiskReads);
    }

    /* renamed from: a */
    public <T> void mo8562a(String str, T t, SharedPreferences.Editor editor) {
        this.f6446r.mo8319a(str, t, editor);
    }

    /* renamed from: a */
    public void mo8563a(JSONObject jSONObject) {
        this.f6425Z = C1993i.m7892a(this.f6445q.mo8615d().f6468b, C1993i.m7900b(jSONObject, "test_mode_idfas", new JSONArray(), this)) || this.f6445q.mo8614c().f6477i;
    }

    /* renamed from: a */
    public void mo8564a(boolean z) {
        synchronized (this.f6418S) {
            this.f6420U = false;
            this.f6421V = z;
        }
        if (this.f6430b != null && this.f6442n != null) {
            List<String> b = mo8576b(C1840b.f5763a);
            if (b.isEmpty()) {
                this.f6442n.mo8482e();
                mo8585f();
                return;
            }
            long longValue = ((Long) mo8549a(C1840b.f5764b)).longValue();
            C1871ad adVar = new C1871ad(this, true, new Runnable() {
                public void run() {
                    if (!C1941j.this.f6442n.mo8478a()) {
                        C1941j.this.f6441m.mo8742b("AppLovinSdk", "Timing out adapters init...");
                        C1941j.this.f6442n.mo8482e();
                        C1941j.this.mo8585f();
                    }
                }
            });
            C1977q qVar = this.f6441m;
            qVar.mo8742b("AppLovinSdk", "Waiting for required adapters to init: " + b + " - timing out in " + longValue + "ms...");
            this.f6442n.mo8477a((C1864a) adVar, C1907s.C1909a.MEDIATION_TIMEOUT, longValue, true);
        }
    }

    /* renamed from: aa */
    public C1798a mo8565aa() {
        return this.f6401B;
    }

    /* renamed from: ab */
    public C2036v mo8566ab() {
        return this.f6403D;
    }

    /* renamed from: ac */
    public C1927f mo8567ac() {
        return this.f6405F;
    }

    /* renamed from: ad */
    public C2024n mo8568ad() {
        return this.f6406G;
    }

    /* renamed from: ae */
    public C1924e mo8569ae() {
        return this.f6407H;
    }

    /* renamed from: af */
    public AppLovinBroadcastManager mo8570af() {
        return AppLovinBroadcastManager.getInstance(f6399a);
    }

    /* renamed from: ag */
    public C1952l mo8571ag() {
        return this.f6408I;
    }

    /* renamed from: ah */
    public Activity mo8572ah() {
        Activity G = mo8528G();
        if (G != null) {
            return G;
        }
        Activity a = mo8565aa().mo8070a();
        if (a != null) {
            return a;
        }
        return null;
    }

    /* renamed from: ai */
    public boolean mo8573ai() {
        return this.f6425Z;
    }

    /* renamed from: b */
    public <T> T mo8574b(C1843e<T> eVar, T t) {
        return this.f6446r.mo8321b(eVar, t);
    }

    /* renamed from: b */
    public <T> T mo8575b(C1843e<T> eVar, T t, SharedPreferences sharedPreferences) {
        return this.f6446r.mo8322b(eVar, t, sharedPreferences);
    }

    /* renamed from: b */
    public List<String> mo8576b(C1841c<String> cVar) {
        return this.f6430b.mo8306b(cVar);
    }

    /* renamed from: b */
    public void mo8577b() {
        synchronized (this.f6418S) {
            this.f6420U = true;
            mo8533L().mo8481d();
            mo8533L().mo8475a((C1864a) new C1892k(this), C1907s.C1909a.MAIN);
        }
    }

    /* renamed from: b */
    public <T> void mo8578b(C1843e<T> eVar) {
        this.f6446r.mo8316a(eVar);
    }

    /* renamed from: b */
    public void mo8579b(String str) {
        C1977q qVar = this.f6441m;
        qVar.mo8742b("AppLovinSdk", "Setting user id: " + str);
        this.f6449u.mo8817a(str);
    }

    /* renamed from: c */
    public List<MaxAdFormat> mo8580c(C1841c<String> cVar) {
        return this.f6430b.mo8308c(cVar);
    }

    /* renamed from: c */
    public void mo8581c(String str) {
        mo8556a(C1843e.f6112z, str);
    }

    /* renamed from: c */
    public boolean mo8582c() {
        boolean z;
        synchronized (this.f6418S) {
            z = this.f6420U;
        }
        return z;
    }

    /* renamed from: d */
    public boolean mo8583d() {
        boolean z;
        synchronized (this.f6418S) {
            z = this.f6421V;
        }
        return z;
    }

    /* renamed from: e */
    public boolean mo8584e() {
        return "HSrCHRtOan6wp2kwOIGJC1RDtuSrF2mWVbio2aBcMHX9KF3iTJ1lLSzCKP1ZSo5yNolPNw1kCTtWpxELFF4ah1".equalsIgnoreCase(mo8599t());
    }

    /* renamed from: f */
    public void mo8585f() {
        final AppLovinSdk.SdkInitializationListener sdkInitializationListener = this.f6427ab;
        if (sdkInitializationListener != null) {
            if (mo8583d()) {
                this.f6427ab = null;
                this.f6428ac = null;
            } else if (this.f6428ac != sdkInitializationListener) {
                if (((Boolean) mo8549a(C1841c.f5831ae)).booleanValue()) {
                    this.f6427ab = null;
                } else {
                    this.f6428ac = sdkInitializationListener;
                }
            } else {
                return;
            }
            AppLovinSdkUtils.runOnUiThreadDelayed(new Runnable() {
                public void run() {
                    C1941j.this.f6441m.mo8742b("AppLovinSdk", "Calling back publisher's initialization completion handler...");
                    sdkInitializationListener.onSdkInitialized(C1941j.this.f6429ad);
                }
            }, Math.max(0, ((Long) mo8549a(C1841c.f5832af)).longValue()));
        }
    }

    /* renamed from: g */
    public void mo8586g() {
        long b = this.f6444p.mo8390b(C1859g.f6192g);
        this.f6430b.mo8310d();
        this.f6430b.mo8307b();
        this.f6444p.mo8389a();
        this.f6454z.mo8348b();
        this.f6444p.mo8392b(C1859g.f6192g, b + 1);
        if (this.f6419T.compareAndSet(true, false)) {
            mo8577b();
        } else {
            this.f6419T.set(true);
        }
    }

    /* renamed from: h */
    public void mo8587h() {
        this.f6415P.mo7632b();
    }

    /* renamed from: i */
    public String mo8588i() {
        return this.f6449u.mo8816a();
    }

    /* renamed from: j */
    public String mo8589j() {
        return this.f6449u.mo8818b();
    }

    /* renamed from: k */
    public String mo8590k() {
        return this.f6449u.mo8819c();
    }

    /* renamed from: l */
    public AppLovinSdkSettings mo8591l() {
        return this.f6434f;
    }

    /* renamed from: m */
    public AppLovinSdkConfiguration mo8592m() {
        return this.f6429ad;
    }

    /* renamed from: n */
    public String mo8593n() {
        return (String) mo8550a(C1843e.f6112z);
    }

    /* renamed from: o */
    public AppLovinAdServiceImpl mo8594o() {
        return this.f6435g;
    }

    /* renamed from: p */
    public NativeAdServiceImpl mo8595p() {
        return this.f6436h;
    }

    /* renamed from: q */
    public AppLovinEventService mo8596q() {
        return this.f6437i;
    }

    /* renamed from: r */
    public AppLovinUserService mo8597r() {
        return this.f6438j;
    }

    /* renamed from: s */
    public VariableServiceImpl mo8598s() {
        return this.f6439k;
    }

    /* renamed from: t */
    public String mo8599t() {
        return this.f6431c;
    }

    public String toString() {
        return "CoreSdk{sdkKey='" + this.f6431c + '\'' + ", enabled=" + this.f6421V + ", isFirstSession=" + this.f6423X + '}';
    }

    /* renamed from: u */
    public boolean mo8601u() {
        return this.f6422W;
    }

    /* renamed from: v */
    public C1977q mo8602v() {
        return this.f6441m;
    }

    /* renamed from: w */
    public C1742i mo8603w() {
        return this.f6411L;
    }

    /* renamed from: x */
    public C1741h mo8604x() {
        return this.f6412M;
    }

    /* renamed from: y */
    public MediationServiceImpl mo8605y() {
        return this.f6413N;
    }

    /* renamed from: z */
    public C1978r mo8606z() {
        return this.f6416Q;
    }
}
