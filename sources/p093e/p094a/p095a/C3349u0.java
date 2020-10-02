package p093e.p094a.p095a;

import com.facebook.share.internal.ShareConstants;
import com.tapjoy.TapjoyConstants;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import p093e.p094a.p095a.p096c1.C3280c;
import p093e.p094a.p095a.p096c1.C3289g;

/* renamed from: e.a.a.u0 */
/* compiled from: SdkClickHandler */
public class C3349u0 implements C3277c0 {

    /* renamed from: a */
    private boolean f9403a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public C3364y f9404b = C3309k.m11002d();

    /* renamed from: c */
    private C3342s f9405c = C3309k.m11005g();

    /* renamed from: d */
    private String f9406d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public List<C3276c> f9407e;

    /* renamed from: f */
    private C3289g f9408f = new C3280c("SdkClickHandler");
    /* access modifiers changed from: private */

    /* renamed from: g */
    public WeakReference<C3360w> f9409g;

    /* renamed from: e.a.a.u0$a */
    /* compiled from: SdkClickHandler */
    class C3350a implements Runnable {

        /* renamed from: a */
        final /* synthetic */ C3276c f9410a;

        C3350a(C3276c cVar) {
            this.f9410a = cVar;
        }

        public void run() {
            C3349u0.this.f9407e.add(this.f9410a);
            C3349u0.this.f9404b.mo19023d("Added sdk_click %d", Integer.valueOf(C3349u0.this.f9407e.size()));
            C3349u0.this.f9404b.mo19024e("%s", this.f9410a.mo18969f());
            C3349u0.this.m11161d();
        }
    }

    /* renamed from: e.a.a.u0$b */
    /* compiled from: SdkClickHandler */
    class C3351b implements Runnable {
        C3351b() {
        }

        public void run() {
            C3360w wVar = (C3360w) C3349u0.this.f9409g.get();
            C3365y0 y0Var = new C3365y0(wVar.getContext());
            try {
                JSONArray f = y0Var.mo19124f();
                boolean z = false;
                for (int i = 0; i < f.length(); i++) {
                    JSONArray jSONArray = f.getJSONArray(i);
                    if (jSONArray.optInt(2, -1) == 0) {
                        String optString = jSONArray.optString(0, (String) null);
                        long optLong = jSONArray.optLong(1, -1);
                        jSONArray.put(2, 1);
                        C3349u0.this.mo18981a(C3324p0.m11057a(optString, optLong, wVar.mo18898g(), wVar.mo18901i(), wVar.mo18897f(), wVar.mo18896e()));
                        z = true;
                    }
                }
                if (z) {
                    y0Var.mo19117a(f);
                }
            } catch (JSONException e) {
                C3349u0.this.f9404b.mo19022c("Send saved raw referrers error (%s)", e.getMessage());
            }
        }
    }

    /* renamed from: e.a.a.u0$c */
    /* compiled from: SdkClickHandler */
    class C3352c implements Runnable {
        C3352c() {
        }

        public void run() {
            C3349u0.this.m11162e();
        }
    }

    /* renamed from: e.a.a.u0$d */
    /* compiled from: SdkClickHandler */
    class C3353d implements Runnable {

        /* renamed from: a */
        final /* synthetic */ C3276c f9414a;

        C3353d(C3276c cVar) {
            this.f9414a = cVar;
        }

        public void run() {
            C3349u0.this.m11158c(this.f9414a);
            C3349u0.this.m11161d();
        }
    }

    public C3349u0(C3360w wVar, boolean z) {
        mo18982a(wVar, z);
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m11161d() {
        this.f9408f.submit(new C3352c());
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public void m11162e() {
        if (!this.f9403a && !this.f9407e.isEmpty()) {
            C3276c remove = this.f9407e.remove(0);
            int l = remove.mo18976l();
            C3353d dVar = new C3353d(remove);
            if (l <= 0) {
                dVar.run();
                return;
            }
            long a = C3268a1.m10823a(l, this.f9405c);
            double d = (double) a;
            Double.isNaN(d);
            String format = C3268a1.f9091a.format(d / 1000.0d);
            this.f9404b.mo19024e("Waiting for %s seconds before retrying sdk_click for the %d time", format, Integer.valueOf(l));
            this.f9408f.schedule(dVar, a);
        }
    }

    /* renamed from: b */
    public void mo18983b() {
        this.f9403a = false;
        m11161d();
    }

    /* renamed from: c */
    public void mo18984c() {
        this.f9408f.submit(new C3351b());
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m11158c(C3276c cVar) {
        long j;
        C3360w wVar = (C3360w) this.f9409g.get();
        if (!wVar.mo18898g().f9148c) {
            String str = cVar.mo18973i().get(ShareConstants.FEED_SOURCE_PARAM);
            boolean z = false;
            boolean z2 = str != null && str.equals("reftag");
            String str2 = cVar.mo18973i().get("raw_referrer");
            if (!z2 || new C3365y0(wVar.getContext()).mo19115a(str2, cVar.mo18962c()) != null) {
                if (str != null && str.equals("install_referrer")) {
                    z = true;
                }
                String str3 = null;
                long j2 = -1;
                if (z) {
                    j2 = cVar.mo18966d();
                    j = cVar.mo18971h();
                    str3 = cVar.mo18973i().get(TapjoyConstants.TJC_REFERRER);
                } else {
                    j = -1;
                }
                String a = C3309k.m10997a();
                if (this.f9406d != null) {
                    a = a + this.f9406d;
                }
                try {
                    C3359v0 v0Var = (C3359v0) C3273b1.m10873a(a + cVar.mo18975k(), cVar, this.f9407e.size() - 1);
                    if (v0Var.f9396f == null) {
                        m11157b(cVar);
                    } else if (wVar != null) {
                        if (v0Var.f9397g == C3367z0.OPTED_OUT) {
                            wVar.mo18904k();
                            return;
                        }
                        if (z2) {
                            new C3365y0(wVar.getContext()).mo19119b(str2, cVar.mo18962c());
                        }
                        if (z) {
                            v0Var.f9422j = j2;
                            v0Var.f9423k = j;
                            v0Var.f9424l = str3;
                            v0Var.f9421i = true;
                        }
                        wVar.mo18885a((C3346t0) v0Var);
                    }
                } catch (UnsupportedEncodingException e) {
                    m11154a(cVar, "Sdk_click failed to encode parameters", e);
                } catch (SocketTimeoutException e2) {
                    m11154a(cVar, "Sdk_click request timed out. Will retry later", e2);
                    m11157b(cVar);
                } catch (IOException e3) {
                    m11154a(cVar, "Sdk_click request failed. Will retry later", e3);
                    m11157b(cVar);
                } catch (Throwable th) {
                    m11154a(cVar, "Sdk_click runtime exception", th);
                }
            }
        }
    }

    /* renamed from: a */
    public void mo18982a(C3360w wVar, boolean z) {
        this.f9403a = !z;
        this.f9407e = new ArrayList();
        this.f9409g = new WeakReference<>(wVar);
        this.f9406d = wVar.mo18894c();
    }

    /* renamed from: b */
    private void m11157b(C3276c cVar) {
        int n = cVar.mo18978n();
        this.f9404b.mo19022c("Retrying sdk_click package for the %d time", Integer.valueOf(n));
        mo18981a(cVar);
    }

    /* renamed from: a */
    public void mo18980a() {
        this.f9403a = true;
    }

    /* renamed from: a */
    public void mo18981a(C3276c cVar) {
        this.f9408f.submit(new C3350a(cVar));
    }

    /* renamed from: a */
    private void m11154a(C3276c cVar, String str, Throwable th) {
        this.f9404b.mo19022c(C3268a1.m10834a("%s. (%s)", cVar.mo18970g(), C3268a1.m10833a(str, th)), new Object[0]);
    }
}
