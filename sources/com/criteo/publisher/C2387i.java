package com.criteo.publisher;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import com.criteo.publisher.advancednative.C2354b;
import com.criteo.publisher.advancednative.C2358e;
import com.criteo.publisher.advancednative.C2360f;
import com.criteo.publisher.advancednative.C2364g;
import com.criteo.publisher.advancednative.C2365h;
import com.criteo.publisher.advancednative.C2366i;
import com.criteo.publisher.advancednative.C2370k;
import com.criteo.publisher.advancednative.C2372m;
import com.criteo.publisher.advancednative.C2374o;
import com.criteo.publisher.advancednative.ImageLoader;
import com.criteo.publisher.advancednative.RendererHelper;
import com.criteo.publisher.model.C2440f;
import com.criteo.publisher.model.C2452m;
import com.criteo.publisher.model.C2455p;
import com.criteo.publisher.model.C2456q;
import com.criteo.publisher.model.C2460s;
import com.criteo.publisher.model.C2463u;
import com.criteo.publisher.p053a.C2320a;
import com.criteo.publisher.p054a0.C2322b;
import com.criteo.publisher.p054a0.C2323c;
import com.criteo.publisher.p054a0.C2330h;
import com.criteo.publisher.p054a0.C2337l;
import com.criteo.publisher.p054a0.C2338m;
import com.criteo.publisher.p054a0.C2339n;
import com.criteo.publisher.p054a0.C2345t;
import com.criteo.publisher.p056o.C2497b;
import com.criteo.publisher.p057p.C2500b;
import com.criteo.publisher.p058q.C2503a;
import com.criteo.publisher.p058q.C2504b;
import com.criteo.publisher.p058q.C2505c;
import com.criteo.publisher.p058q.C2506d;
import com.criteo.publisher.p059r.C2507a;
import com.criteo.publisher.p060s.C2508a;
import com.criteo.publisher.p060s.C2509b;
import com.criteo.publisher.p061t.C2528k;
import com.criteo.publisher.p061t.C2545p;
import com.criteo.publisher.p061t.C2547q;
import com.criteo.publisher.p061t.C2548r;
import com.criteo.publisher.p061t.C2550s;
import com.criteo.publisher.p061t.C2554u;
import com.criteo.publisher.p061t.C2555v;
import com.criteo.publisher.p061t.C2558w;
import com.criteo.publisher.p061t.C2559x;
import com.criteo.publisher.p062u.C2563a;
import com.criteo.publisher.p062u.C2566b;
import com.criteo.publisher.p062u.C2567c;
import com.criteo.publisher.p062u.C2568d;
import com.criteo.publisher.p062u.C2569e;
import com.criteo.publisher.p063v.C2570a;
import com.criteo.publisher.p064w.C2572b;
import com.criteo.publisher.p065x.C2574b;
import com.criteo.publisher.p065x.C2579d;
import com.criteo.publisher.p066y.C2580a;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.squareup.picasso.Picasso;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/* renamed from: com.criteo.publisher.i */
public class C2387i {

    /* renamed from: d */
    protected static C2387i f7805d;

    /* renamed from: a */
    private final Map<Class, Object> f7806a = new HashMap();

    /* renamed from: b */
    private Application f7807b;

    /* renamed from: c */
    private String f7808c;

    /* renamed from: com.criteo.publisher.i$a */
    class C2388a implements C2413m0<C2456q> {
        C2388a() {
        }

        /* renamed from: a */
        public C2456q m9134a() {
            return new C2456q(C2387i.this.mo10282o(), C2387i.this.mo10260M());
        }
    }

    /* renamed from: com.criteo.publisher.i$a0 */
    class C2389a0 implements C2413m0<C2545p> {
        C2389a0() {
        }

        /* renamed from: a */
        public C2545p m9136a() {
            return new C2545p(C2387i.this.mo10282o(), C2387i.this.mo10248A(), C2387i.this.mo10277j());
        }
    }

    /* renamed from: com.criteo.publisher.i$b */
    class C2390b implements C2413m0<C2440f> {
        C2390b() {
        }

        /* renamed from: a */
        public C2440f m9138a() {
            return new C2440f(C2387i.this.mo10271d(), C2387i.this.mo10286s());
        }
    }

    /* renamed from: com.criteo.publisher.i$b0 */
    class C2391b0 implements C2413m0<C2547q> {
        C2391b0() {
        }

        /* renamed from: a */
        public C2547q m9140a() {
            return new C2547q(C2387i.this.mo10292y());
        }
    }

    /* renamed from: com.criteo.publisher.i$c */
    class C2392c implements C2413m0<C2320a> {
        C2392c() {
        }

        /* renamed from: a */
        public C2320a m9142a() {
            return new C2320a(C2387i.this.mo10282o(), C2387i.this.mo10286s(), C2387i.this.mo10280m(), C2387i.this.mo10255H(), C2387i.this.mo10264Q(), C2387i.this.mo10285r());
        }
    }

    /* renamed from: com.criteo.publisher.i$c0 */
    class C2393c0 implements C2413m0<C2339n> {
        C2393c0() {
        }

        /* renamed from: a */
        public C2339n m9144a() {
            return new C2339n(C2387i.this.mo10287t());
        }
    }

    /* renamed from: com.criteo.publisher.i$d */
    class C2394d implements C2413m0<C2460s> {
        C2394d() {
        }

        /* renamed from: a */
        public C2460s m9146a() {
            return new C2460s(C2387i.this.mo10282o(), C2387i.this.mo10283p());
        }
    }

    /* renamed from: com.criteo.publisher.i$d0 */
    class C2395d0 implements C2413m0<Gson> {
        C2395d0(C2387i iVar) {
        }

        /* renamed from: a */
        public Gson m9148a() {
            return new GsonBuilder().registerTypeAdapterFactory(C2337l.m8981a()).create();
        }
    }

    /* renamed from: com.criteo.publisher.i$e */
    class C2396e implements C2413m0<C2330h> {
        C2396e(C2387i iVar) {
        }

        /* renamed from: a */
        public C2330h m9150a() {
            return new C2330h();
        }
    }

    /* renamed from: com.criteo.publisher.i$e0 */
    class C2397e0 implements C2413m0<C2572b> {
        C2397e0() {
        }

        /* renamed from: a */
        public C2572b m9152a() {
            return new C2572b(C2387i.this.mo10277j());
        }
    }

    /* renamed from: com.criteo.publisher.i$f */
    class C2398f implements C2413m0<C2452m> {
        C2398f() {
        }

        /* renamed from: a */
        public C2452m m9154a() {
            return new C2452m(C2387i.this.mo10256I(), C2387i.this.mo10285r(), C2387i.this.mo10286s(), C2387i.this.mo10264Q(), C2387i.this.mo10263P(), C2387i.this.mo10277j());
        }
    }

    /* renamed from: com.criteo.publisher.i$f0 */
    class C2399f0 implements C2413m0<C2323c> {
        C2399f0() {
        }

        /* renamed from: a */
        public C2323c m9156a() {
            return new C2323c(C2387i.this.mo10282o());
        }
    }

    /* renamed from: com.criteo.publisher.i$g */
    class C2400g implements C2413m0<C2506d> {
        C2400g() {
        }

        /* renamed from: a */
        public C2506d m9158a() {
            return new C2506d(C2387i.this.mo10280m());
        }
    }

    /* renamed from: com.criteo.publisher.i$g0 */
    class C2401g0 implements C2413m0<C2338m> {
        C2401g0() {
        }

        /* renamed from: a */
        public C2338m m9160a() {
            return new C2338m(C2387i.this.mo10282o(), C2387i.this.mo10270c());
        }
    }

    /* renamed from: com.criteo.publisher.i$h */
    class C2402h implements C2413m0<C2463u> {
        C2402h() {
        }

        /* renamed from: a */
        public C2463u m9162a() {
            return new C2463u(C2387i.this.mo10256I(), C2387i.this.mo10277j());
        }
    }

    /* renamed from: com.criteo.publisher.i$h0 */
    class C2403h0 implements C2413m0<C2508a> {
        C2403h0(C2387i iVar) {
        }

        /* renamed from: a */
        public C2508a m9164a() {
            return new C2508a();
        }
    }

    /* renamed from: com.criteo.publisher.i$i */
    class C2404i implements C2413m0<C2574b> {
        C2404i() {
        }

        /* renamed from: a */
        public C2574b m9166a() {
            return new C2574b(C2387i.this.mo10278k(), C2387i.this.mo10258K(), C2387i.this.mo10255H(), C2387i.this.mo10261N());
        }
    }

    /* renamed from: com.criteo.publisher.i$i0 */
    class C2405i0 implements C2413m0<C2455p> {
        C2405i0() {
        }

        /* renamed from: a */
        public C2455p m9168a() {
            return new C2455p(C2387i.this.mo10282o(), C2387i.this.mo10292y());
        }
    }

    /* renamed from: com.criteo.publisher.i$j */
    class C2406j implements C2413m0<C2503a> {
        C2406j() {
        }

        /* renamed from: a */
        public C2503a m9170a() {
            C2504b bVar = new C2504b();
            bVar.mo10514a((C2503a) new C2505c());
            if (Build.VERSION.SDK_INT >= 17) {
                bVar.mo10514a((C2503a) new C2528k(C2387i.this.mo10249B(), new C2559x(C2387i.this.mo10250C()), C2387i.this.mo10280m(), C2387i.this.mo10263P(), C2387i.this.mo10281n(), C2387i.this.mo10261N()));
            }
            return bVar;
        }
    }

    /* renamed from: com.criteo.publisher.i$j0 */
    class C2407j0 implements C2413m0<C2379c> {
        C2407j0(C2387i iVar) {
        }

        /* renamed from: a */
        public C2379c m9172a() {
            return new C2431k();
        }
    }

    /* renamed from: com.criteo.publisher.i$k */
    class C2408k implements C2413m0<C2579d> {
        C2408k() {
        }

        /* renamed from: a */
        public C2579d m9174a() {
            return new C2579d(C2387i.this.mo10277j(), C2387i.this.mo10292y());
        }
    }

    /* renamed from: com.criteo.publisher.i$k0 */
    class C2409k0 implements C2413m0<C2580a> {
        C2409k0() {
        }

        /* renamed from: a */
        public C2580a m9176a() {
            return new C2580a(C2387i.this.mo10282o());
        }
    }

    /* renamed from: com.criteo.publisher.i$l */
    class C2410l implements C2413m0<C2370k> {
        C2410l() {
        }

        /* renamed from: a */
        public C2370k m9178a() {
            return new C2370k(C2387i.this.mo10265R(), new C2366i(C2387i.this.mo10255H(), C2387i.this.mo10261N(), C2387i.this.mo10260M()), C2387i.this.mo10279l(), new C2360f(C2387i.this.mo10257J(), C2387i.this.mo10262O(), C2387i.this.mo10260M()), C2387i.this.mo10266a(), C2387i.this.mo10259L());
        }
    }

    /* renamed from: com.criteo.publisher.i$l0 */
    class C2411l0 implements C2413m0<C2376b> {
        C2411l0() {
        }

        /* renamed from: a */
        public C2376b m9180a() {
            return new C2376b(new C2507a(C2387i.this.mo10286s()), C2387i.this.mo10281n(), C2387i.this.mo10280m(), C2387i.this.mo10269b(), C2387i.this.mo10276i(), C2387i.this.mo10274g(), C2387i.this.mo10251D());
        }
    }

    /* renamed from: com.criteo.publisher.i$m */
    class C2412m implements C2413m0<C2374o> {
        C2412m(C2387i iVar) {
        }

        /* renamed from: a */
        public C2374o m9182a() {
            return new C2374o(new C2372m());
        }
    }

    /* renamed from: com.criteo.publisher.i$m0 */
    public interface C2413m0<T> {
        /* renamed from: a */
        T mo10294a();
    }

    /* renamed from: com.criteo.publisher.i$n */
    class C2414n implements C2413m0<C2358e> {
        C2414n(C2387i iVar) {
        }

        /* renamed from: a */
        public C2358e m9185a() {
            return new C2358e();
        }
    }

    /* renamed from: com.criteo.publisher.i$o */
    class C2415o implements C2413m0<C2500b> {
        C2415o() {
        }

        /* renamed from: a */
        public C2500b m9187a() {
            return new C2500b(C2387i.this.mo10282o());
        }
    }

    /* renamed from: com.criteo.publisher.i$p */
    class C2416p implements C2413m0<C2354b> {
        C2416p() {
        }

        /* renamed from: a */
        public C2354b m9189a() {
            return new C2354b(C2387i.this.mo10277j(), C2387i.this.mo10271d());
        }
    }

    /* renamed from: com.criteo.publisher.i$q */
    class C2417q implements C2413m0<Picasso> {
        C2417q() {
        }

        /* renamed from: a */
        public Picasso m9191a() {
            return new Picasso.Builder(C2387i.this.mo10282o()).build();
        }
    }

    /* renamed from: com.criteo.publisher.i$r */
    class C2418r implements C2413m0<ImageLoader> {
        C2418r() {
        }

        /* renamed from: a */
        public ImageLoader m9193a() {
            return new C2364g(C2387i.this.mo10254G());
        }
    }

    /* renamed from: com.criteo.publisher.i$s */
    class C2419s implements C2413m0<C2365h> {
        C2419s() {
        }

        /* renamed from: a */
        public C2365h m9195a() {
            return new C2365h(C2387i.this.mo10284q());
        }
    }

    /* renamed from: com.criteo.publisher.i$t */
    class C2420t implements C2413m0<RendererHelper> {
        C2420t() {
        }

        /* renamed from: a */
        public RendererHelper m9197a() {
            return new RendererHelper(C2387i.this.mo10289v(), C2387i.this.mo10260M());
        }
    }

    /* renamed from: com.criteo.publisher.i$u */
    class C2421u implements C2413m0<C2432l> {
        C2421u() {
        }

        /* renamed from: a */
        public C2432l m9199a() {
            return new C2432l(C2387i.this.mo10275h(), new C2495n(), C2387i.this.mo10280m(), C2387i.this.mo10291x());
        }
    }

    /* renamed from: com.criteo.publisher.i$v */
    class C2422v implements C2413m0<C2322b> {
        C2422v(C2387i iVar) {
        }

        /* renamed from: a */
        public C2322b m9201a() {
            return new C2322b();
        }
    }

    /* renamed from: com.criteo.publisher.i$w */
    class C2423w implements C2413m0<C2566b> {
        C2423w() {
        }

        /* renamed from: a */
        public C2566b m9203a() {
            return new C2566b(C2387i.this.mo10275h(), Arrays.asList(new C2567c[]{new C2568d(), new C2563a(C2387i.this.mo10271d(), C2387i.this.mo10286s()), new C2569e()}));
        }
    }

    /* renamed from: com.criteo.publisher.i$x */
    class C2424x implements C2413m0<C2570a> {
        C2424x() {
        }

        /* renamed from: a */
        public C2570a m9205a() {
            return new C2570a(C2387i.this.mo10282o(), C2387i.this.mo10262O());
        }
    }

    /* renamed from: com.criteo.publisher.i$y */
    class C2425y implements C2413m0<C2497b> {
        C2425y() {
        }

        /* renamed from: a */
        public C2497b m9207a() {
            return new C2497b(C2387i.this.mo10282o());
        }
    }

    /* renamed from: com.criteo.publisher.i$z */
    class C2426z implements C2413m0<C2555v> {
        C2426z() {
        }

        /* renamed from: a */
        public C2555v m9209a() {
            return new C2555v(C2387i.this.mo10250C(), C2387i.this.mo10255H(), C2387i.this.mo10277j(), C2387i.this.mo10281n(), C2387i.this.mo10261N());
        }
    }

    private C2387i() {
    }

    /* renamed from: S */
    private void m9083S() {
        if (this.f7807b == null) {
            throw new C2386h("Application reference is required");
        }
    }

    /* renamed from: T */
    private void m9084T() {
        if (C2345t.m9006a((CharSequence) this.f7808c)) {
            throw new C2386h("Criteo Publisher Id is required");
        }
    }

    /* renamed from: U */
    public static synchronized C2387i m9085U() {
        C2387i iVar;
        synchronized (C2387i.class) {
            if (f7805d == null) {
                f7805d = new C2387i();
            }
            iVar = f7805d;
        }
        return iVar;
    }

    /* renamed from: A */
    public C2547q mo10248A() {
        return (C2547q) m9086a(C2547q.class, new C2391b0());
    }

    /* renamed from: B */
    public C2548r mo10249B() {
        return (C2548r) m9086a(C2548r.class, new C2550s(mo10282o(), mo10248A(), mo10277j()));
    }

    /* renamed from: C */
    public C2554u mo10250C() {
        return (C2554u) m9086a(C2554u.class, new C2558w(mo10253F(), mo10277j()));
    }

    /* renamed from: D */
    public C2555v mo10251D() {
        return (C2555v) m9086a(C2555v.class, new C2426z());
    }

    /* renamed from: E */
    public C2370k mo10252E() {
        return (C2370k) m9086a(C2370k.class, new C2410l());
    }

    /* renamed from: F */
    public C2545p mo10253F() {
        return (C2545p) m9086a(C2545p.class, new C2389a0());
    }

    /* renamed from: G */
    public Picasso mo10254G() {
        return (Picasso) m9086a(Picasso.class, new C2417q());
    }

    /* renamed from: H */
    public C2579d mo10255H() {
        return (C2579d) m9086a(C2579d.class, new C2408k());
    }

    /* renamed from: I */
    public C2460s mo10256I() {
        return (C2460s) m9086a(C2460s.class, new C2394d());
    }

    /* renamed from: J */
    public C2500b mo10257J() {
        return (C2500b) m9086a(C2500b.class, new C2415o());
    }

    /* renamed from: K */
    public C2463u mo10258K() {
        return (C2463u) m9086a(C2463u.class, new C2402h());
    }

    /* renamed from: L */
    public RendererHelper mo10259L() {
        return (RendererHelper) m9086a(RendererHelper.class, new C2420t());
    }

    /* renamed from: M */
    public C2508a mo10260M() {
        return (C2508a) m9086a(C2508a.class, new C2403h0(this));
    }

    /* renamed from: N */
    public Executor mo10261N() {
        return (Executor) m9086a(ThreadPoolExecutor.class, new C2509b());
    }

    /* renamed from: O */
    public C2497b mo10262O() {
        return (C2497b) m9086a(C2497b.class, new C2425y());
    }

    /* renamed from: P */
    public C2506d mo10263P() {
        return (C2506d) m9086a(C2506d.class, new C2400g());
    }

    /* renamed from: Q */
    public C2580a mo10264Q() {
        return (C2580a) m9086a(C2580a.class, new C2409k0());
    }

    /* renamed from: R */
    public C2374o mo10265R() {
        return (C2374o) m9086a(C2374o.class, new C2412m(this));
    }

    /* renamed from: a */
    public void mo10267a(Application application) {
        this.f7807b = application;
        m9083S();
    }

    /* renamed from: b */
    public C2440f mo10269b() {
        return (C2440f) m9086a(C2440f.class, new C2390b());
    }

    /* renamed from: c */
    public C2322b mo10270c() {
        return (C2322b) m9086a(C2322b.class, new C2422v(this));
    }

    /* renamed from: d */
    public C2323c mo10271d() {
        return (C2323c) m9086a(C2323c.class, new C2399f0());
    }

    /* renamed from: e */
    public C2320a mo10272e() {
        return (C2320a) m9086a(C2320a.class, new C2392c());
    }

    /* renamed from: f */
    public Application mo10273f() {
        m9083S();
        return this.f7807b;
    }

    /* renamed from: g */
    public C2503a mo10274g() {
        return (C2503a) m9086a(C2503a.class, new C2406j());
    }

    /* renamed from: h */
    public C2376b mo10275h() {
        return (C2376b) m9086a(C2376b.class, new C2411l0());
    }

    /* renamed from: i */
    public C2574b mo10276i() {
        return (C2574b) m9086a(C2574b.class, new C2404i());
    }

    /* renamed from: j */
    public C2330h mo10277j() {
        return (C2330h) m9086a(C2330h.class, new C2396e(this));
    }

    /* renamed from: k */
    public C2452m mo10278k() {
        return (C2452m) m9086a(C2452m.class, new C2398f());
    }

    /* renamed from: l */
    public C2358e mo10279l() {
        return (C2358e) m9086a(C2358e.class, new C2414n(this));
    }

    /* renamed from: m */
    public C2379c mo10280m() {
        return (C2379c) m9086a(C2379c.class, new C2407j0(this));
    }

    /* renamed from: n */
    public C2455p mo10281n() {
        return (C2455p) m9086a(C2455p.class, new C2405i0());
    }

    /* renamed from: o */
    public Context mo10282o() {
        return mo10273f().getApplicationContext();
    }

    /* renamed from: p */
    public String mo10283p() {
        m9084T();
        return this.f7808c;
    }

    /* renamed from: q */
    public ImageLoader mo10284q() {
        return (ImageLoader) m9086a(ImageLoader.class, new C2418r());
    }

    /* renamed from: r */
    public C2456q mo10285r() {
        return (C2456q) m9086a(C2456q.class, new C2388a());
    }

    /* renamed from: s */
    public C2338m mo10286s() {
        return (C2338m) m9086a(C2338m.class, new C2401g0());
    }

    /* renamed from: t */
    public Gson mo10287t() {
        return (Gson) m9086a(Gson.class, new C2395d0(this));
    }

    /* renamed from: u */
    public C2566b mo10288u() {
        return (C2566b) m9086a(C2566b.class, new C2423w());
    }

    /* renamed from: v */
    public C2365h mo10289v() {
        return (C2365h) m9086a(C2365h.class, new C2419s());
    }

    /* renamed from: w */
    public C2432l mo10290w() {
        return (C2432l) m9086a(C2432l.class, new C2421u());
    }

    /* renamed from: x */
    public C2570a mo10291x() {
        return (C2570a) m9086a(C2570a.class, new C2424x());
    }

    /* renamed from: y */
    public C2339n mo10292y() {
        return (C2339n) m9086a(C2339n.class, new C2393c0());
    }

    /* renamed from: z */
    public C2572b mo10293z() {
        return (C2572b) m9086a(C2572b.class, new C2397e0());
    }

    /* renamed from: a */
    public void mo10268a(String str) {
        this.f7808c = str;
        m9084T();
    }

    /* renamed from: a */
    public C2354b mo10266a() {
        return (C2354b) m9086a(C2354b.class, new C2416p());
    }

    /* renamed from: a */
    private <T> T m9086a(Class<T> cls, C2413m0<T> m0Var) {
        T t = this.f7806a.get(cls);
        if (t != null) {
            return t;
        }
        T a = m0Var.mo10294a();
        this.f7806a.put(cls, a);
        return a;
    }
}
