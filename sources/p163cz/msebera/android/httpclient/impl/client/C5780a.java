package p163cz.msebera.android.httpclient.impl.client;

import java.io.IOException;
import java.lang.reflect.UndeclaredThrowableException;
import p163cz.msebera.android.httpclient.C5545a;
import p163cz.msebera.android.httpclient.C5896l;
import p163cz.msebera.android.httpclient.C5899o;
import p163cz.msebera.android.httpclient.C5900p;
import p163cz.msebera.android.httpclient.C5901q;
import p163cz.msebera.android.httpclient.C5903s;
import p163cz.msebera.android.httpclient.HttpException;
import p163cz.msebera.android.httpclient.auth.C5550d;
import p163cz.msebera.android.httpclient.auth.C5552f;
import p163cz.msebera.android.httpclient.client.C5577c;
import p163cz.msebera.android.httpclient.client.C5578d;
import p163cz.msebera.android.httpclient.client.C5579e;
import p163cz.msebera.android.httpclient.client.C5580f;
import p163cz.msebera.android.httpclient.client.C5581g;
import p163cz.msebera.android.httpclient.client.C5582h;
import p163cz.msebera.android.httpclient.client.C5583i;
import p163cz.msebera.android.httpclient.client.C5584j;
import p163cz.msebera.android.httpclient.client.C5585k;
import p163cz.msebera.android.httpclient.client.C5586l;
import p163cz.msebera.android.httpclient.client.ClientProtocolException;
import p163cz.msebera.android.httpclient.client.p169o.C5594c;
import p163cz.msebera.android.httpclient.client.p170p.C5604a;
import p163cz.msebera.android.httpclient.conn.C5624b;
import p163cz.msebera.android.httpclient.conn.C5625c;
import p163cz.msebera.android.httpclient.conn.C5628f;
import p163cz.msebera.android.httpclient.conn.p174r.C5645b;
import p163cz.msebera.android.httpclient.conn.p174r.C5647d;
import p163cz.msebera.android.httpclient.conn.p175s.C5660i;
import p163cz.msebera.android.httpclient.cookie.C5685i;
import p163cz.msebera.android.httpclient.cookie.C5687k;
import p163cz.msebera.android.httpclient.impl.auth.C5766c;
import p163cz.msebera.android.httpclient.impl.auth.C5768e;
import p163cz.msebera.android.httpclient.impl.auth.C5778k;
import p163cz.msebera.android.httpclient.impl.conn.C5808d;
import p163cz.msebera.android.httpclient.impl.conn.C5813h;
import p163cz.msebera.android.httpclient.impl.conn.C5820o;
import p163cz.msebera.android.httpclient.impl.cookie.C5847g0;
import p163cz.msebera.android.httpclient.impl.cookie.C5853l;
import p163cz.msebera.android.httpclient.impl.cookie.C5856n;
import p163cz.msebera.android.httpclient.impl.cookie.C5862s;
import p163cz.msebera.android.httpclient.impl.cookie.C5866w;
import p163cz.msebera.android.httpclient.impl.cookie.C5869z;
import p163cz.msebera.android.httpclient.p177d0.C5695b;
import p163cz.msebera.android.httpclient.p178e0.C5698b;
import p163cz.msebera.android.httpclient.p183h0.C5759e;
import p163cz.msebera.android.httpclient.p186j0.C5871a;
import p163cz.msebera.android.httpclient.p186j0.C5872b;
import p163cz.msebera.android.httpclient.p186j0.C5873c;
import p163cz.msebera.android.httpclient.p186j0.C5875e;
import p163cz.msebera.android.httpclient.p186j0.C5877g;
import p163cz.msebera.android.httpclient.p186j0.C5878h;
import p163cz.msebera.android.httpclient.p186j0.C5879i;
import p163cz.msebera.android.httpclient.p187k0.C5886a;

@Deprecated
/* renamed from: cz.msebera.android.httpclient.impl.client.a */
/* compiled from: AbstractHttpClient */
public abstract class C5780a extends C5787h {

    /* renamed from: a */
    public C5695b f14899a = new C5695b(getClass());

    /* renamed from: b */
    private C5759e f14900b;

    /* renamed from: c */
    private C5878h f14901c;

    /* renamed from: d */
    private C5624b f14902d;

    /* renamed from: e */
    private C5545a f14903e;

    /* renamed from: f */
    private C5628f f14904f;

    /* renamed from: g */
    private C5687k f14905g;

    /* renamed from: h */
    private C5552f f14906h;

    /* renamed from: i */
    private C5872b f14907i;

    /* renamed from: j */
    private C5879i f14908j;

    /* renamed from: k */
    private C5582h f14909k;

    /* renamed from: l */
    private C5584j f14910l;

    /* renamed from: m */
    private C5577c f14911m;

    /* renamed from: n */
    private C5577c f14912n;

    /* renamed from: o */
    private C5580f f14913o;

    /* renamed from: p */
    private C5581g f14914p;

    /* renamed from: q */
    private C5647d f14915q;

    /* renamed from: r */
    private C5586l f14916r;

    /* renamed from: s */
    private C5579e f14917s;

    /* renamed from: t */
    private C5578d f14918t;

    protected C5780a(C5624b bVar, C5759e eVar) {
        this.f14900b = eVar;
        this.f14902d = bVar;
    }

    /* renamed from: w0 */
    private synchronized C5877g m18415w0() {
        if (this.f14908j == null) {
            C5872b n0 = mo33475n0();
            int a = n0.mo33628a();
            C5900p[] pVarArr = new C5900p[a];
            for (int i = 0; i < a; i++) {
                pVarArr[i] = n0.mo33629a(i);
            }
            int b = n0.mo33634b();
            C5903s[] sVarArr = new C5903s[b];
            for (int i2 = 0; i2 < b; i2++) {
                sVarArr[i2] = n0.mo33635b(i2);
            }
            this.f14908j = new C5879i(pVarArr, sVarArr);
        }
        return this.f14908j;
    }

    /* access modifiers changed from: protected */
    /* renamed from: A */
    public abstract C5759e mo33448A();

    /* access modifiers changed from: protected */
    /* renamed from: X */
    public abstract C5872b mo33449X();

    /* access modifiers changed from: protected */
    /* renamed from: Y */
    public C5582h mo33450Y() {
        return new C5791l();
    }

    /* access modifiers changed from: protected */
    /* renamed from: Z */
    public C5647d mo33451Z() {
        return new C5813h(mo33470i0().mo33010a());
    }

    /* renamed from: a */
    public synchronized void mo33454a(C5582h hVar) {
        this.f14909k = hVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a0 */
    public C5577c mo33459a0() {
        return new C5800t();
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public C5759e mo33460b(C5899o oVar) {
        return new C5786g((C5759e) null, mo33477p0(), oVar.getParams(), (C5759e) null);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b0 */
    public C5878h mo33461b0() {
        return new C5878h();
    }

    /* access modifiers changed from: protected */
    /* renamed from: c0 */
    public C5577c mo33462c0() {
        return new C5804x();
    }

    public void close() {
        mo33470i0().shutdown();
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public C5552f mo33464d() {
        C5552f fVar = new C5552f();
        fVar.mo32847a("Basic", (C5550d) new C5766c());
        fVar.mo32847a("Digest", (C5550d) new C5768e());
        fVar.mo32847a("NTLM", (C5550d) new C5778k());
        return fVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: d0 */
    public C5586l mo33465d0() {
        return new C5796q();
    }

    /* renamed from: e0 */
    public final synchronized C5552f mo33466e0() {
        if (this.f14906h == null) {
            this.f14906h = mo33464d();
        }
        return this.f14906h;
    }

    /* renamed from: f0 */
    public final synchronized C5578d mo33467f0() {
        return this.f14918t;
    }

    /* renamed from: g0 */
    public final synchronized C5579e mo33468g0() {
        return this.f14917s;
    }

    /* renamed from: h0 */
    public final synchronized C5628f mo33469h0() {
        if (this.f14904f == null) {
            this.f14904f = mo33483u();
        }
        return this.f14904f;
    }

    /* renamed from: i0 */
    public final synchronized C5624b mo33470i0() {
        if (this.f14902d == null) {
            this.f14902d = mo33481t();
        }
        return this.f14902d;
    }

    /* renamed from: j0 */
    public final synchronized C5545a mo33471j0() {
        if (this.f14903e == null) {
            this.f14903e = mo33485v();
        }
        return this.f14903e;
    }

    /* renamed from: k0 */
    public final synchronized C5687k mo33472k0() {
        if (this.f14905g == null) {
            this.f14905g = mo33487w();
        }
        return this.f14905g;
    }

    /* renamed from: l0 */
    public final synchronized C5580f mo33473l0() {
        if (this.f14913o == null) {
            this.f14913o = mo33488x();
        }
        return this.f14913o;
    }

    /* renamed from: m0 */
    public final synchronized C5581g mo33474m0() {
        if (this.f14914p == null) {
            this.f14914p = mo33489y();
        }
        return this.f14914p;
    }

    /* access modifiers changed from: protected */
    /* renamed from: n0 */
    public final synchronized C5872b mo33475n0() {
        if (this.f14907i == null) {
            this.f14907i = mo33449X();
        }
        return this.f14907i;
    }

    /* renamed from: o0 */
    public final synchronized C5582h mo33476o0() {
        if (this.f14909k == null) {
            this.f14909k = mo33450Y();
        }
        return this.f14909k;
    }

    /* renamed from: p0 */
    public final synchronized C5759e mo33477p0() {
        if (this.f14900b == null) {
            this.f14900b = mo33448A();
        }
        return this.f14900b;
    }

    /* renamed from: q0 */
    public final synchronized C5577c mo33478q0() {
        if (this.f14912n == null) {
            this.f14912n = mo33459a0();
        }
        return this.f14912n;
    }

    /* renamed from: r0 */
    public final synchronized C5584j mo33479r0() {
        if (this.f14910l == null) {
            this.f14910l = new C5793n();
        }
        return this.f14910l;
    }

    /* renamed from: s0 */
    public final synchronized C5878h mo33480s0() {
        if (this.f14901c == null) {
            this.f14901c = mo33461b0();
        }
        return this.f14901c;
    }

    /* access modifiers changed from: protected */
    /* renamed from: t */
    public C5624b mo33481t() {
        C5625c cVar;
        C5660i a = C5820o.m18645a();
        C5759e p0 = mo33477p0();
        String str = (String) p0.mo33425b("http.connection-manager.factory-class-name");
        if (str != null) {
            try {
                cVar = (C5625c) Class.forName(str).newInstance();
            } catch (ClassNotFoundException unused) {
                throw new IllegalStateException("Invalid class name: " + str);
            } catch (IllegalAccessException e) {
                throw new IllegalAccessError(e.getMessage());
            } catch (InstantiationException e2) {
                throw new InstantiationError(e2.getMessage());
            }
        } else {
            cVar = null;
        }
        if (cVar != null) {
            return cVar.mo33013a(p0, a);
        }
        return new C5808d(a);
    }

    /* renamed from: t0 */
    public final synchronized C5647d mo33482t0() {
        if (this.f14915q == null) {
            this.f14915q = mo33451Z();
        }
        return this.f14915q;
    }

    /* access modifiers changed from: protected */
    /* renamed from: u */
    public C5628f mo33483u() {
        return new C5789j();
    }

    /* renamed from: u0 */
    public final synchronized C5577c mo33484u0() {
        if (this.f14911m == null) {
            this.f14911m = mo33462c0();
        }
        return this.f14911m;
    }

    /* access modifiers changed from: protected */
    /* renamed from: v */
    public C5545a mo33485v() {
        return new C5698b();
    }

    /* renamed from: v0 */
    public final synchronized C5586l mo33486v0() {
        if (this.f14916r == null) {
            this.f14916r = mo33465d0();
        }
        return this.f14916r;
    }

    /* access modifiers changed from: protected */
    /* renamed from: w */
    public C5687k mo33487w() {
        C5687k kVar = new C5687k();
        kVar.mo33152a("default", (C5685i) new C5853l());
        kVar.mo33152a("best-match", (C5685i) new C5853l());
        kVar.mo33152a("compatibility", (C5685i) new C5856n());
        kVar.mo33152a("netscape", (C5685i) new C5866w());
        kVar.mo33152a("rfc2109", (C5685i) new C5869z());
        kVar.mo33152a("rfc2965", (C5685i) new C5847g0());
        kVar.mo33152a("ignoreCookies", (C5685i) new C5862s());
        return kVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: x */
    public C5580f mo33488x() {
        return new C5784e();
    }

    /* access modifiers changed from: protected */
    /* renamed from: y */
    public C5581g mo33489y() {
        return new C5785f();
    }

    /* access modifiers changed from: protected */
    /* renamed from: z */
    public C5875e mo33490z() {
        C5871a aVar = new C5871a();
        aVar.mo33535a("http.scheme-registry", mo33470i0().mo33010a());
        aVar.mo33535a("http.authscheme-registry", mo33466e0());
        aVar.mo33535a("http.cookiespec-registry", mo33472k0());
        aVar.mo33535a("http.cookie-store", mo33473l0());
        aVar.mo33535a("http.auth.credentials-provider", mo33474m0());
        return aVar;
    }

    @Deprecated
    /* renamed from: a */
    public synchronized void mo33455a(C5583i iVar) {
        this.f14910l = new C5794o(iVar);
    }

    /* renamed from: a */
    public synchronized void mo33458a(C5903s sVar) {
        mo33475n0().mo33633a(sVar);
        this.f14908j = null;
    }

    /* renamed from: a */
    public synchronized void mo33456a(C5900p pVar) {
        mo33475n0().mo33631a(pVar);
        this.f14908j = null;
    }

    /* renamed from: a */
    public synchronized void mo33457a(C5900p pVar, int i) {
        mo33475n0().mo33632a(pVar, i);
        this.f14908j = null;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final C5594c mo33453a(C5896l lVar, C5899o oVar, C5875e eVar) throws IOException, ClientProtocolException {
        C5873c cVar;
        C5875e eVar2;
        C5585k a;
        C5647d t0;
        C5579e g0;
        C5578d f0;
        C5896l lVar2;
        C5645b a2;
        C5896l lVar3 = lVar;
        C5899o oVar2 = oVar;
        C5875e eVar3 = eVar;
        C5886a.m18894a(oVar2, "HTTP request");
        synchronized (this) {
            C5875e z = mo33490z();
            if (eVar3 == null) {
                cVar = z;
            } else {
                cVar = new C5873c(eVar3, z);
            }
            C5759e b = mo33460b(oVar2);
            cVar.mo33535a("http.request-config", C5604a.m17835a(b));
            eVar2 = cVar;
            a = mo33452a(mo33480s0(), mo33470i0(), mo33471j0(), mo33469h0(), mo33482t0(), m18415w0(), mo33476o0(), mo33479r0(), mo33484u0(), mo33478q0(), mo33486v0(), b);
            t0 = mo33482t0();
            g0 = mo33468g0();
            f0 = mo33467f0();
        }
        if (g0 == null || f0 == null) {
            return C5788i.m18486a(a.mo32928a(lVar3, oVar2, eVar2));
        }
        if (lVar3 != null) {
            lVar2 = lVar3;
        } else {
            try {
                lVar2 = (C5896l) mo33460b(oVar2).mo33425b("http.default-host");
            } catch (RuntimeException e) {
                if (g0.mo32921a((Throwable) e)) {
                    f0.mo32918a(a2);
                }
                throw e;
            } catch (Exception e2) {
                if (g0.mo32921a((Throwable) e2)) {
                    f0.mo32918a(a2);
                }
                if (e2 instanceof HttpException) {
                    throw ((HttpException) e2);
                } else if (e2 instanceof IOException) {
                    throw ((IOException) e2);
                } else {
                    throw new UndeclaredThrowableException(e2);
                }
            } catch (HttpException e3) {
                throw new ClientProtocolException((Throwable) e3);
            }
        }
        C5875e eVar4 = eVar2;
        a2 = t0.mo33066a(lVar2, oVar2, eVar4);
        C5594c a3 = C5788i.m18486a(a.mo32928a(lVar3, oVar2, eVar4));
        if (g0.mo32920a((C5901q) a3)) {
            f0.mo32918a(a2);
        } else {
            f0.mo32919b(a2);
        }
        return a3;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public C5585k mo33452a(C5878h hVar, C5624b bVar, C5545a aVar, C5628f fVar, C5647d dVar, C5877g gVar, C5582h hVar2, C5584j jVar, C5577c cVar, C5577c cVar2, C5586l lVar, C5759e eVar) {
        return new C5795p(this.f14899a, hVar, bVar, aVar, fVar, dVar, gVar, hVar2, jVar, cVar, cVar2, lVar, eVar);
    }
}
