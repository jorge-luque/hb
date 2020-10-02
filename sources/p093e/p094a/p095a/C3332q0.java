package p093e.p094a.p095a;

import android.content.Context;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import p093e.p094a.p095a.p096c1.C3280c;
import p093e.p094a.p095a.p096c1.C3289g;

/* renamed from: e.a.a.q0 */
/* compiled from: PackageHandler */
public class C3332q0 implements C3366z {

    /* renamed from: a */
    private C3289g f9323a = new C3280c("PackageHandler");

    /* renamed from: b */
    private C3267a0 f9324b;

    /* renamed from: c */
    private WeakReference<C3360w> f9325c;

    /* renamed from: d */
    private List<C3276c> f9326d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public AtomicBoolean f9327e;

    /* renamed from: f */
    private boolean f9328f;

    /* renamed from: g */
    private Context f9329g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public C3364y f9330h = C3309k.m11002d();

    /* renamed from: i */
    private C3342s f9331i = C3309k.m11004f();

    /* renamed from: j */
    private String f9332j;

    /* renamed from: k */
    private String f9333k;

    /* renamed from: e.a.a.q0$a */
    /* compiled from: PackageHandler */
    class C3333a implements Runnable {
        C3333a() {
        }

        public void run() {
            C3332q0.this.m11094g();
        }
    }

    /* renamed from: e.a.a.q0$b */
    /* compiled from: PackageHandler */
    class C3334b implements Runnable {

        /* renamed from: a */
        final /* synthetic */ C3276c f9335a;

        C3334b(C3276c cVar) {
            this.f9335a = cVar;
        }

        public void run() {
            C3332q0.this.m11087b(this.f9335a);
        }
    }

    /* renamed from: e.a.a.q0$c */
    /* compiled from: PackageHandler */
    class C3335c implements Runnable {
        C3335c() {
        }

        public void run() {
            C3332q0.this.m11096i();
        }
    }

    /* renamed from: e.a.a.q0$d */
    /* compiled from: PackageHandler */
    class C3336d implements Runnable {
        C3336d() {
        }

        public void run() {
            C3332q0.this.m11097j();
        }
    }

    /* renamed from: e.a.a.q0$e */
    /* compiled from: PackageHandler */
    class C3337e implements Runnable {
        C3337e() {
        }

        public void run() {
            C3332q0.this.f9330h.mo19024e("Package handler can send", new Object[0]);
            C3332q0.this.f9327e.set(false);
            C3332q0.this.mo19082e();
        }
    }

    /* renamed from: e.a.a.q0$f */
    /* compiled from: PackageHandler */
    class C3338f implements Runnable {

        /* renamed from: a */
        final /* synthetic */ C3361w0 f9340a;

        C3338f(C3361w0 w0Var) {
            this.f9340a = w0Var;
        }

        public void run() {
            C3332q0.this.mo19079b(this.f9340a);
        }
    }

    /* renamed from: e.a.a.q0$g */
    /* compiled from: PackageHandler */
    class C3339g implements Runnable {
        C3339g() {
        }

        public void run() {
            C3332q0.this.m11092f();
        }
    }

    public C3332q0(C3360w wVar, Context context, boolean z) {
        mo19077a(wVar, context, z);
        this.f9323a.submit(new C3333a());
    }

    /* access modifiers changed from: private */
    /* renamed from: g */
    public void m11094g() {
        this.f9324b = C3309k.m10993a((C3360w) this.f9325c.get(), (C3366z) this);
        this.f9327e = new AtomicBoolean();
        m11095h();
    }

    /* renamed from: h */
    private void m11095h() {
        try {
            this.f9326d = (List) C3268a1.m10825a(this.f9329g, "AdjustIoPackageQueue", "Package queue", List.class);
        } catch (Exception e) {
            this.f9330h.mo19022c("Failed to read %s file (%s)", "Package queue", e.getMessage());
            this.f9326d = null;
        }
        List<C3276c> list = this.f9326d;
        if (list != null) {
            this.f9330h.mo19023d("Package handler read %d packages", Integer.valueOf(list.size()));
            return;
        }
        this.f9326d = new ArrayList();
    }

    /* access modifiers changed from: private */
    /* renamed from: i */
    public void m11096i() {
        if (!this.f9326d.isEmpty()) {
            if (this.f9328f) {
                this.f9330h.mo19023d("Package handler is paused", new Object[0]);
            } else if (this.f9327e.getAndSet(true)) {
                this.f9330h.mo19024e("Package handler is already sending", new Object[0]);
            } else {
                this.f9324b.mo18949a(this.f9326d.get(0), this.f9326d.size() - 1);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: j */
    public void m11097j() {
        if (!this.f9326d.isEmpty()) {
            this.f9326d.remove(0);
            m11098k();
            this.f9327e.set(false);
            this.f9330h.mo19024e("Package handler can send", new Object[0]);
            m11096i();
        }
    }

    /* renamed from: k */
    private void m11098k() {
        C3268a1.m10838a(this.f9326d, this.f9329g, "AdjustIoPackageQueue", "Package queue");
        this.f9330h.mo19023d("Package handler wrote %d packages", Integer.valueOf(this.f9326d.size()));
    }

    public void flush() {
        this.f9323a.submit(new C3339g());
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public void m11092f() {
        this.f9326d.clear();
        m11098k();
    }

    /* renamed from: b */
    public void mo19078b() {
        this.f9328f = false;
    }

    /* renamed from: c */
    public String mo19080c() {
        return this.f9332j;
    }

    /* renamed from: d */
    public String mo19081d() {
        return this.f9333k;
    }

    /* renamed from: e */
    public void mo19082e() {
        this.f9323a.submit(new C3335c());
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m11087b(C3276c cVar) {
        this.f9326d.add(cVar);
        this.f9330h.mo19023d("Added package %d (%s)", Integer.valueOf(this.f9326d.size()), cVar);
        this.f9330h.mo19024e("%s", cVar.mo18969f());
        m11098k();
    }

    /* renamed from: a */
    public void mo19077a(C3360w wVar, Context context, boolean z) {
        this.f9325c = new WeakReference<>(wVar);
        this.f9329g = context;
        this.f9328f = !z;
        this.f9332j = wVar.mo18894c();
        this.f9333k = wVar.mo18895d();
    }

    /* renamed from: b */
    public void mo19079b(C3361w0 w0Var) {
        if (w0Var != null) {
            this.f9330h.mo19023d("Updating package handler queue", new Object[0]);
            this.f9330h.mo19024e("Session callback parameters: %s", w0Var.f9425a);
            this.f9330h.mo19024e("Session partner parameters: %s", w0Var.f9426b);
            for (C3276c next : this.f9326d) {
                Map<String, String> i = next.mo18973i();
                C3321o0.m11037a(i, "callback_params", C3268a1.m10837a(w0Var.f9425a, next.mo18958b(), "Callback"));
                C3321o0.m11037a(i, "partner_params", C3268a1.m10837a(w0Var.f9426b, next.mo18974j(), "Partner"));
            }
            m11098k();
        }
    }

    /* renamed from: a */
    public void mo19073a(C3276c cVar) {
        this.f9323a.submit(new C3334b(cVar));
    }

    /* renamed from: a */
    public void mo19074a(C3346t0 t0Var) {
        this.f9323a.submit(new C3336d());
        C3360w wVar = (C3360w) this.f9325c.get();
        if (wVar != null) {
            wVar.mo18885a(t0Var);
        }
    }

    /* renamed from: a */
    public void mo19075a(C3346t0 t0Var, C3276c cVar) {
        t0Var.f9392b = true;
        C3360w wVar = (C3360w) this.f9325c.get();
        if (wVar != null) {
            wVar.mo18885a(t0Var);
        }
        C3337e eVar = new C3337e();
        if (cVar == null) {
            eVar.run();
            return;
        }
        int n = cVar.mo18978n();
        long a = C3268a1.m10823a(n, this.f9331i);
        double d = (double) a;
        Double.isNaN(d);
        String format = C3268a1.f9091a.format(d / 1000.0d);
        this.f9330h.mo19024e("Waiting for %s seconds before retrying the %d time", format, Integer.valueOf(n));
        this.f9323a.schedule(eVar, a);
    }

    /* renamed from: a */
    public void mo19072a() {
        this.f9328f = true;
    }

    /* renamed from: a */
    public void mo19076a(C3361w0 w0Var) {
        this.f9323a.submit(new C3338f(w0Var != null ? w0Var.mo19109a() : null));
    }
}
