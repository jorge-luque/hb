package p163cz.msebera.android.httpclient.client.p171q;

import p163cz.msebera.android.httpclient.auth.C5551e;
import p163cz.msebera.android.httpclient.auth.C5555h;
import p163cz.msebera.android.httpclient.client.C5575a;
import p163cz.msebera.android.httpclient.client.C5580f;
import p163cz.msebera.android.httpclient.client.C5581g;
import p163cz.msebera.android.httpclient.client.p167m.C5587a;
import p163cz.msebera.android.httpclient.conn.p174r.C5645b;
import p163cz.msebera.android.httpclient.conn.p174r.C5648e;
import p163cz.msebera.android.httpclient.cookie.C5682f;
import p163cz.msebera.android.httpclient.cookie.C5684h;
import p163cz.msebera.android.httpclient.cookie.C5686j;
import p163cz.msebera.android.httpclient.p165b0.C5564a;
import p163cz.msebera.android.httpclient.p186j0.C5875e;
import p163cz.msebera.android.httpclient.p186j0.C5876f;

/* renamed from: cz.msebera.android.httpclient.client.q.a */
/* compiled from: HttpClientContext */
public class C5606a extends C5876f {
    public C5606a(C5875e eVar) {
        super(eVar);
    }

    /* renamed from: a */
    public static C5606a m17839a(C5875e eVar) {
        if (eVar instanceof C5606a) {
            return (C5606a) eVar;
        }
        return new C5606a(eVar);
    }

    /* renamed from: b */
    private <T> C5564a<T> m17840b(String str, Class<T> cls) {
        return (C5564a) mo33642a(str, C5564a.class);
    }

    /* renamed from: e */
    public C5575a mo32975e() {
        return (C5575a) mo33642a("http.auth.auth-cache", C5575a.class);
    }

    /* renamed from: f */
    public C5564a<C5551e> mo32976f() {
        return m17840b("http.authscheme-registry", C5551e.class);
    }

    /* renamed from: g */
    public C5682f mo32977g() {
        return (C5682f) mo33642a("http.cookie-origin", C5682f.class);
    }

    /* renamed from: h */
    public C5684h mo32978h() {
        return (C5684h) mo33642a("http.cookie-spec", C5684h.class);
    }

    /* renamed from: i */
    public C5564a<C5686j> mo32979i() {
        return m17840b("http.cookiespec-registry", C5686j.class);
    }

    /* renamed from: j */
    public C5580f mo32980j() {
        return (C5580f) mo33642a("http.cookie-store", C5580f.class);
    }

    /* renamed from: k */
    public C5581g mo32981k() {
        return (C5581g) mo33642a("http.auth.credentials-provider", C5581g.class);
    }

    /* renamed from: l */
    public C5648e mo32982l() {
        return (C5648e) mo33642a("http.route", C5645b.class);
    }

    /* renamed from: m */
    public C5555h mo32983m() {
        return (C5555h) mo33642a("http.auth.proxy-scope", C5555h.class);
    }

    /* renamed from: n */
    public C5587a mo32984n() {
        C5587a aVar = (C5587a) mo33642a("http.request-config", C5587a.class);
        return aVar != null ? aVar : C5587a.f14542p;
    }

    /* renamed from: o */
    public C5555h mo32985o() {
        return (C5555h) mo33642a("http.auth.target-scope", C5555h.class);
    }

    public C5606a() {
    }

    /* renamed from: a */
    public void mo32974a(C5575a aVar) {
        mo33535a("http.auth.auth-cache", (Object) aVar);
    }
}
