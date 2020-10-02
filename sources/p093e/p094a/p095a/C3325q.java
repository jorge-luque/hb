package p093e.p094a.p095a;

import android.net.Uri;
import java.lang.ref.WeakReference;
import org.json.JSONObject;
import p093e.p094a.p095a.p096c1.C3280c;
import p093e.p094a.p095a.p096c1.C3289g;
import p093e.p094a.p095a.p096c1.C3292i;

/* renamed from: e.a.a.q */
/* compiled from: AttributionHandler */
public class C3325q implements C3362x {

    /* renamed from: a */
    private boolean f9306a;

    /* renamed from: b */
    private String f9307b;

    /* renamed from: c */
    private String f9308c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public String f9309d;

    /* renamed from: e */
    private C3364y f9310e = C3309k.m11002d();

    /* renamed from: f */
    private C3292i f9311f = new C3292i(new C3326a(), "Attribution timer");

    /* renamed from: g */
    private C3289g f9312g = new C3280c("AttributionHandler");
    /* access modifiers changed from: private */

    /* renamed from: h */
    public WeakReference<C3360w> f9313h;

    /* renamed from: e.a.a.q$a */
    /* compiled from: AttributionHandler */
    class C3326a implements Runnable {
        C3326a() {
        }

        public void run() {
            C3325q.this.m11076e();
        }
    }

    /* renamed from: e.a.a.q$b */
    /* compiled from: AttributionHandler */
    class C3327b implements Runnable {
        C3327b() {
        }

        public void run() {
            String unused = C3325q.this.f9309d = "sdk";
            C3325q.this.m11062a(0);
        }
    }

    /* renamed from: e.a.a.q$c */
    /* compiled from: AttributionHandler */
    class C3328c implements Runnable {

        /* renamed from: a */
        final /* synthetic */ C3363x0 f9316a;

        C3328c(C3363x0 x0Var) {
            this.f9316a = x0Var;
        }

        public void run() {
            C3360w wVar = (C3360w) C3325q.this.f9313h.get();
            if (wVar != null) {
                C3325q.this.m11071a(wVar, this.f9316a);
            }
        }
    }

    /* renamed from: e.a.a.q$d */
    /* compiled from: AttributionHandler */
    class C3329d implements Runnable {

        /* renamed from: a */
        final /* synthetic */ C3359v0 f9318a;

        C3329d(C3359v0 v0Var) {
            this.f9318a = v0Var;
        }

        public void run() {
            C3360w wVar = (C3360w) C3325q.this.f9313h.get();
            if (wVar != null) {
                C3325q.this.m11070a(wVar, this.f9318a);
            }
        }
    }

    /* renamed from: e.a.a.q$e */
    /* compiled from: AttributionHandler */
    class C3330e implements Runnable {

        /* renamed from: a */
        final /* synthetic */ C3340r f9320a;

        C3330e(C3340r rVar) {
            this.f9320a = rVar;
        }

        public void run() {
            C3360w wVar = (C3360w) C3325q.this.f9313h.get();
            if (wVar != null) {
                C3325q.this.m11068a(wVar, this.f9320a);
            }
        }
    }

    /* renamed from: e.a.a.q$f */
    /* compiled from: AttributionHandler */
    class C3331f implements Runnable {
        C3331f() {
        }

        public void run() {
            C3325q.this.m11077f();
        }
    }

    public C3325q(C3360w wVar, boolean z) {
        this.f9307b = wVar.mo18894c();
        this.f9308c = wVar.mo18897f().f9373i;
        mo19062a(wVar, z);
    }

    /* renamed from: d */
    private C3276c m11075d() {
        long currentTimeMillis = System.currentTimeMillis();
        C3360w wVar = (C3360w) this.f9313h.get();
        C3276c a = new C3321o0(wVar.mo18901i(), wVar.mo18897f(), wVar.mo18898g(), wVar.mo18896e(), currentTimeMillis).mo19054a(this.f9309d);
        this.f9309d = null;
        return a;
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public void m11076e() {
        this.f9312g.submit(new C3331f());
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public void m11077f() {
        if (!((C3360w) this.f9313h.get()).mo18898g().f9148c) {
            if (this.f9306a) {
                this.f9310e.mo19023d("Attribution handler is paused", new Object[0]);
                return;
            }
            C3276c d = m11075d();
            this.f9310e.mo19024e("%s", d.mo18969f());
            try {
                C3346t0 a = C3273b1.m10872a(d, this.f9307b);
                if (a instanceof C3340r) {
                    if (a.f9397g == C3367z0.OPTED_OUT) {
                        ((C3360w) this.f9313h.get()).mo18904k();
                    } else {
                        mo19060a((C3340r) a);
                    }
                }
            } catch (Exception e) {
                this.f9310e.mo19022c("Failed to get attribution (%s)", e.getMessage());
            }
        }
    }

    /* renamed from: b */
    public void mo19064b() {
        this.f9306a = false;
    }

    /* renamed from: c */
    public void mo19065c() {
        this.f9312g.submit(new C3327b());
    }

    /* renamed from: b */
    private void m11073b(C3340r rVar) {
        JSONObject optJSONObject;
        String optString;
        JSONObject jSONObject = rVar.f9396f;
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("attribution")) != null && (optString = optJSONObject.optString("deeplink", (String) null)) != null) {
            rVar.f9343i = Uri.parse(optString);
        }
    }

    /* renamed from: a */
    public void mo19062a(C3360w wVar, boolean z) {
        this.f9313h = new WeakReference<>(wVar);
        this.f9306a = !z;
    }

    /* renamed from: a */
    public void mo19063a(C3363x0 x0Var) {
        this.f9312g.submit(new C3328c(x0Var));
    }

    /* renamed from: a */
    public void mo19061a(C3359v0 v0Var) {
        this.f9312g.submit(new C3329d(v0Var));
    }

    /* renamed from: a */
    public void mo19060a(C3340r rVar) {
        this.f9312g.submit(new C3330e(rVar));
    }

    /* renamed from: a */
    public void mo19059a() {
        this.f9306a = true;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m11062a(long j) {
        if (this.f9311f.mo19001b() <= j) {
            if (j != 0) {
                double d = (double) j;
                Double.isNaN(d);
                String format = C3268a1.f9091a.format(d / 1000.0d);
                this.f9310e.mo19023d("Waiting to query attribution in %s seconds", format);
            }
            this.f9311f.mo19000a(j);
        }
    }

    /* renamed from: a */
    private void m11069a(C3360w wVar, C3346t0 t0Var) {
        JSONObject jSONObject = t0Var.f9396f;
        if (jSONObject != null) {
            long optLong = jSONObject.optLong("ask_in", -1);
            if (optLong >= 0) {
                wVar.mo18891a(true);
                this.f9309d = "backend";
                m11062a(optLong);
                return;
            }
            wVar.mo18891a(false);
            t0Var.f9398h = C3299f.m10964a(t0Var.f9396f.optJSONObject("attribution"), t0Var.f9393c, C3268a1.m10853b(this.f9308c));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m11071a(C3360w wVar, C3363x0 x0Var) {
        m11069a(wVar, (C3346t0) x0Var);
        wVar.mo18888a(x0Var);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m11070a(C3360w wVar, C3359v0 v0Var) {
        m11069a(wVar, (C3346t0) v0Var);
        wVar.mo18887a(v0Var);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m11068a(C3360w wVar, C3340r rVar) {
        m11069a(wVar, (C3346t0) rVar);
        m11073b(rVar);
        wVar.mo18884a(rVar);
    }
}
