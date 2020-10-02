package p093e.p094a.p095a;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.net.SocketTimeoutException;
import p093e.p094a.p095a.p096c1.C3280c;
import p093e.p094a.p095a.p096c1.C3286e;

/* renamed from: e.a.a.s0 */
/* compiled from: RequestHandler */
public class C3343s0 implements C3267a0 {

    /* renamed from: a */
    private C3286e f9353a = new C3280c("RequestHandler");

    /* renamed from: b */
    private WeakReference<C3366z> f9354b;

    /* renamed from: c */
    private WeakReference<C3360w> f9355c;

    /* renamed from: d */
    private C3364y f9356d = C3309k.m11002d();

    /* renamed from: e */
    private String f9357e;

    /* renamed from: f */
    private String f9358f;

    /* renamed from: e.a.a.s0$a */
    /* compiled from: RequestHandler */
    class C3344a implements Runnable {

        /* renamed from: a */
        final /* synthetic */ C3276c f9359a;

        /* renamed from: b */
        final /* synthetic */ int f9360b;

        C3344a(C3276c cVar, int i) {
            this.f9359a = cVar;
            this.f9360b = i;
        }

        public void run() {
            C3343s0.this.m11120b(this.f9359a, this.f9360b);
        }
    }

    public C3343s0(C3360w wVar, C3366z zVar) {
        mo18950a(wVar, zVar);
        this.f9357e = zVar.mo19080c();
        this.f9358f = zVar.mo19081d();
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m11120b(C3276c cVar, int i) {
        String str;
        C3360w wVar;
        if (cVar.mo18954a() != C3270b.GDPR) {
            str = C3309k.m10997a();
            if (this.f9357e != null) {
                str = str + this.f9357e;
            }
        } else {
            str = C3309k.m11001c();
            if (this.f9358f != null) {
                str = str + this.f9358f;
            }
        }
        try {
            C3346t0 a = C3273b1.m10873a(str + cVar.mo18975k(), cVar, i);
            C3366z zVar = (C3366z) this.f9354b.get();
            if (zVar != null && (wVar = (C3360w) this.f9355c.get()) != null) {
                if (a.f9397g == C3367z0.OPTED_OUT) {
                    wVar.mo18904k();
                } else if (a.f9396f == null) {
                    zVar.mo19075a(a, cVar);
                } else {
                    zVar.mo19074a(a);
                }
            }
        } catch (UnsupportedEncodingException e) {
            m11121b(cVar, "Failed to encode parameters", e);
        } catch (SocketTimeoutException e2) {
            m11118a(cVar, "Request timed out", (Throwable) e2);
        } catch (IOException e3) {
            m11118a(cVar, "Request failed", (Throwable) e3);
        } catch (Throwable th) {
            m11121b(cVar, "Runtime exception", th);
        }
    }

    /* renamed from: a */
    public void mo18950a(C3360w wVar, C3366z zVar) {
        this.f9354b = new WeakReference<>(zVar);
        this.f9355c = new WeakReference<>(wVar);
    }

    /* renamed from: a */
    public void mo18949a(C3276c cVar, int i) {
        this.f9353a.submit(new C3344a(cVar, i));
    }

    /* renamed from: a */
    private void m11118a(C3276c cVar, String str, Throwable th) {
        String a = C3268a1.m10834a("%s. (%s) Will retry later", cVar.mo18970g(), C3268a1.m10833a(str, th));
        this.f9356d.mo19022c(a, new Object[0]);
        C3346t0 a2 = C3346t0.m11150a(cVar);
        a2.f9394d = a;
        C3366z zVar = (C3366z) this.f9354b.get();
        if (zVar != null) {
            zVar.mo19075a(a2, cVar);
        }
    }

    /* renamed from: b */
    private void m11121b(C3276c cVar, String str, Throwable th) {
        String a = C3268a1.m10834a("%s. (%s)", cVar.mo18970g(), C3268a1.m10833a(str, th));
        this.f9356d.mo19022c(a, new Object[0]);
        C3346t0 a2 = C3346t0.m11150a(cVar);
        a2.f9394d = a;
        C3366z zVar = (C3366z) this.f9354b.get();
        if (zVar != null) {
            zVar.mo19074a(a2);
        }
    }
}
