package p163cz.msebera.android.httpclient.impl.client;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.concurrent.TimeUnit;
import p163cz.msebera.android.httpclient.C5545a;
import p163cz.msebera.android.httpclient.C5870j;
import p163cz.msebera.android.httpclient.C5885k;
import p163cz.msebera.android.httpclient.C5896l;
import p163cz.msebera.android.httpclient.C5899o;
import p163cz.msebera.android.httpclient.C5901q;
import p163cz.msebera.android.httpclient.HttpException;
import p163cz.msebera.android.httpclient.NoHttpResponseException;
import p163cz.msebera.android.httpclient.ProtocolException;
import p163cz.msebera.android.httpclient.auth.C5548b;
import p163cz.msebera.android.httpclient.auth.C5549c;
import p163cz.msebera.android.httpclient.auth.C5555h;
import p163cz.msebera.android.httpclient.auth.C5562o;
import p163cz.msebera.android.httpclient.client.C5577c;
import p163cz.msebera.android.httpclient.client.C5582h;
import p163cz.msebera.android.httpclient.client.C5584j;
import p163cz.msebera.android.httpclient.client.C5585k;
import p163cz.msebera.android.httpclient.client.C5586l;
import p163cz.msebera.android.httpclient.client.NonRepeatableRequestException;
import p163cz.msebera.android.httpclient.client.RedirectException;
import p163cz.msebera.android.httpclient.client.p169o.C5590a;
import p163cz.msebera.android.httpclient.client.p169o.C5600i;
import p163cz.msebera.android.httpclient.client.p170p.C5605b;
import p163cz.msebera.android.httpclient.client.p172r.C5621d;
import p163cz.msebera.android.httpclient.conn.C5623a;
import p163cz.msebera.android.httpclient.conn.C5624b;
import p163cz.msebera.android.httpclient.conn.C5627e;
import p163cz.msebera.android.httpclient.conn.C5628f;
import p163cz.msebera.android.httpclient.conn.C5629g;
import p163cz.msebera.android.httpclient.conn.C5635m;
import p163cz.msebera.android.httpclient.conn.p174r.C5644a;
import p163cz.msebera.android.httpclient.conn.p174r.C5645b;
import p163cz.msebera.android.httpclient.conn.p174r.C5647d;
import p163cz.msebera.android.httpclient.impl.auth.C5765b;
import p163cz.msebera.android.httpclient.impl.conn.ConnectionShutdownException;
import p163cz.msebera.android.httpclient.p166c0.C5570c;
import p163cz.msebera.android.httpclient.p177d0.C5695b;
import p163cz.msebera.android.httpclient.p182g0.C5738h;
import p163cz.msebera.android.httpclient.p183h0.C5757c;
import p163cz.msebera.android.httpclient.p183h0.C5759e;
import p163cz.msebera.android.httpclient.p183h0.C5760f;
import p163cz.msebera.android.httpclient.p186j0.C5875e;
import p163cz.msebera.android.httpclient.p186j0.C5877g;
import p163cz.msebera.android.httpclient.p186j0.C5878h;
import p163cz.msebera.android.httpclient.p187k0.C5886a;
import p163cz.msebera.android.httpclient.p187k0.C5892g;

@Deprecated
/* renamed from: cz.msebera.android.httpclient.impl.client.p */
/* compiled from: DefaultRequestDirector */
public class C5795p implements C5585k {

    /* renamed from: a */
    public C5695b f14942a;

    /* renamed from: b */
    protected final C5624b f14943b;

    /* renamed from: c */
    protected final C5647d f14944c;

    /* renamed from: d */
    protected final C5545a f14945d;

    /* renamed from: e */
    protected final C5628f f14946e;

    /* renamed from: f */
    protected final C5878h f14947f;

    /* renamed from: g */
    protected final C5877g f14948g;

    /* renamed from: h */
    protected final C5582h f14949h;

    /* renamed from: i */
    protected final C5584j f14950i;

    /* renamed from: j */
    protected final C5577c f14951j;

    /* renamed from: k */
    protected final C5577c f14952k;

    /* renamed from: l */
    protected final C5586l f14953l;

    /* renamed from: m */
    protected final C5759e f14954m;

    /* renamed from: n */
    protected C5635m f14955n;

    /* renamed from: o */
    protected final C5555h f14956o;

    /* renamed from: p */
    protected final C5555h f14957p;

    /* renamed from: q */
    private final C5799s f14958q;

    /* renamed from: r */
    private int f14959r;

    /* renamed from: s */
    private int f14960s;

    /* renamed from: t */
    private final int f14961t;

    /* renamed from: u */
    private C5896l f14962u;

    public C5795p(C5695b bVar, C5878h hVar, C5624b bVar2, C5545a aVar, C5628f fVar, C5647d dVar, C5877g gVar, C5582h hVar2, C5584j jVar, C5577c cVar, C5577c cVar2, C5586l lVar, C5759e eVar) {
        C5886a.m18894a(bVar, "Log");
        C5886a.m18894a(hVar, "Request executor");
        C5886a.m18894a(bVar2, "Client connection manager");
        C5886a.m18894a(aVar, "Connection reuse strategy");
        C5886a.m18894a(fVar, "Connection keep alive strategy");
        C5886a.m18894a(dVar, "Route planner");
        C5886a.m18894a(gVar, "HTTP protocol processor");
        C5886a.m18894a(hVar2, "HTTP request retry handler");
        C5886a.m18894a(jVar, "Redirect strategy");
        C5886a.m18894a(cVar, "Target authentication strategy");
        C5886a.m18894a(cVar2, "Proxy authentication strategy");
        C5886a.m18894a(lVar, "User token handler");
        C5886a.m18894a(eVar, "HTTP parameters");
        this.f14942a = bVar;
        this.f14958q = new C5799s(bVar);
        this.f14947f = hVar;
        this.f14943b = bVar2;
        this.f14945d = aVar;
        this.f14946e = fVar;
        this.f14944c = dVar;
        this.f14948g = gVar;
        this.f14949h = hVar2;
        this.f14950i = jVar;
        this.f14951j = cVar;
        this.f14952k = cVar2;
        this.f14953l = lVar;
        this.f14954m = eVar;
        if (jVar instanceof C5794o) {
            ((C5794o) jVar).mo33506a();
        }
        if (cVar instanceof C5781b) {
            ((C5781b) cVar).mo33491a();
        }
        if (cVar2 instanceof C5781b) {
            ((C5781b) cVar2).mo33491a();
        }
        this.f14955n = null;
        this.f14959r = 0;
        this.f14960s = 0;
        this.f14956o = new C5555h();
        this.f14957p = new C5555h();
        this.f14961t = this.f14954m.mo33419b("http.protocol.max-redirects", 100);
    }

    /* renamed from: a */
    private C5802v m18503a(C5899o oVar) throws ProtocolException {
        if (oVar instanceof C5885k) {
            return new C5797r((C5885k) oVar);
        }
        return new C5802v(oVar);
    }

    /* renamed from: b */
    private C5901q m18505b(C5803w wVar, C5875e eVar) throws HttpException, IOException {
        C5802v a = wVar.mo33531a();
        C5645b b = wVar.mo33532b();
        IOException e = null;
        while (true) {
            this.f14959r++;
            a.mo33529d();
            if (!a.mo33516e()) {
                this.f14942a.mo33166a("Cannot retry non-repeatable request");
                if (e != null) {
                    throw new NonRepeatableRequestException("Cannot retry request with a non-repeatable request entity.  The cause lists the reason the original request failed.", e);
                }
                throw new NonRepeatableRequestException("Cannot retry request with a non-repeatable request entity.");
            }
            try {
                if (!this.f14955n.isOpen()) {
                    if (!b.mo33057b()) {
                        this.f14942a.mo33166a("Reopening the direct connection.");
                        this.f14955n.mo33036a(b, eVar, this.f14954m);
                    } else {
                        this.f14942a.mo33166a("Proxied connection. Need to start over.");
                        return null;
                    }
                }
                if (this.f14942a.mo33168a()) {
                    this.f14942a.mo33166a("Attempt " + this.f14959r + " to execute request");
                }
                return this.f14947f.mo33651c(a, this.f14955n, eVar);
            } catch (IOException e2) {
                e = e2;
                this.f14942a.mo33166a("Closing the connection.");
                try {
                    this.f14955n.close();
                } catch (IOException unused) {
                }
                if (this.f14949h.mo28925a(e, a.mo33527b(), eVar)) {
                    if (this.f14942a.mo33173c()) {
                        this.f14942a.mo33172c("I/O exception (" + e.getClass().getName() + ") caught when processing request to " + b + ": " + e.getMessage());
                    }
                    if (this.f14942a.mo33168a()) {
                        this.f14942a.mo33167a(e.getMessage(), e);
                    }
                    if (this.f14942a.mo33173c()) {
                        this.f14942a.mo33172c("Retrying request to " + b);
                    }
                } else if (e instanceof NoHttpResponseException) {
                    NoHttpResponseException noHttpResponseException = new NoHttpResponseException(b.mo33061e().mo33689e() + " failed to respond");
                    noHttpResponseException.setStackTrace(e.getStackTrace());
                    throw noHttpResponseException;
                } else {
                    throw e;
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public void mo33514c(C5645b bVar, C5875e eVar) throws HttpException, IOException {
        int a;
        C5644a aVar = new C5644a();
        do {
            C5645b D = this.f14955n.mo33032D();
            a = aVar.mo33051a(bVar, D);
            switch (a) {
                case -1:
                    throw new HttpException("Unable to establish route: planned = " + bVar + "; current = " + D);
                case 0:
                    break;
                case 1:
                case 2:
                    this.f14955n.mo33036a(bVar, eVar, this.f14954m);
                    continue;
                case 3:
                    boolean b = mo33513b(bVar, eVar);
                    this.f14942a.mo33166a("Tunnel to target created.");
                    this.f14955n.mo33038a(b, this.f14954m);
                    continue;
                case 4:
                    mo33511a(bVar, D.mo33055a() - 1, eVar);
                    throw null;
                case 5:
                    this.f14955n.mo33037a(eVar, this.f14954m);
                    continue;
                default:
                    throw new IllegalStateException("Unknown step indicator " + a + " from RouteDirector.");
            }
        } while (a > 0);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo33510a(C5802v vVar, C5645b bVar) throws ProtocolException {
        URI uri;
        try {
            URI uri2 = vVar.getURI();
            if (bVar.mo33058c() == null || bVar.mo33057b()) {
                if (uri2.isAbsolute()) {
                    uri = C5621d.m17893a(uri2, (C5896l) null, true);
                } else {
                    uri = C5621d.m17897c(uri2);
                }
            } else if (!uri2.isAbsolute()) {
                uri = C5621d.m17893a(uri2, bVar.mo33061e(), true);
            } else {
                uri = C5621d.m17897c(uri2);
            }
            vVar.mo33526a(uri);
        } catch (URISyntaxException e) {
            throw new ProtocolException("Invalid URI: " + vVar.getRequestLine().getUri(), e);
        }
    }

    /* renamed from: a */
    public C5901q mo32928a(C5896l lVar, C5899o oVar, C5875e eVar) throws HttpException, IOException {
        String str;
        C5896l lVar2;
        eVar.mo33535a("http.auth.target-scope", this.f14956o);
        eVar.mo33535a("http.auth.proxy-scope", this.f14957p);
        C5802v a = m18503a(oVar);
        a.mo33294a(this.f14954m);
        C5645b b = mo33512b(lVar, a, eVar);
        C5896l lVar3 = (C5896l) a.getParams().mo33425b("http.virtual-host");
        this.f14962u = lVar3;
        if (lVar3 != null && lVar3.mo33686c() == -1) {
            if (lVar != null) {
                lVar2 = lVar;
            } else {
                lVar2 = b.mo33061e();
            }
            int c = lVar2.mo33686c();
            if (c != -1) {
                this.f14962u = new C5896l(this.f14962u.mo33685b(), c, this.f14962u.mo33688d());
            }
        }
        C5803w wVar = new C5803w(a, b);
        C5901q qVar = null;
        boolean z = false;
        C5803w wVar2 = wVar;
        boolean z2 = false;
        while (!z) {
            try {
                C5802v a2 = wVar2.mo33531a();
                C5645b b2 = wVar2.mo33532b();
                Object a3 = eVar.mo33533a("http.user-token");
                if (this.f14955n == null) {
                    C5627e a4 = this.f14943b.mo33009a(b2, a3);
                    if (oVar instanceof C5590a) {
                        ((C5590a) oVar).mo32953a(a4);
                    }
                    this.f14955n = a4.mo33017a(C5605b.m17836a(this.f14954m), TimeUnit.MILLISECONDS);
                    if (C5757c.m18346f(this.f14954m) && this.f14955n.isOpen()) {
                        this.f14942a.mo33166a("Stale connection check");
                        if (this.f14955n.mo33183W()) {
                            this.f14942a.mo33166a("Stale connection detected");
                            this.f14955n.close();
                        }
                    }
                }
                if (oVar instanceof C5590a) {
                    ((C5590a) oVar).mo32954a((C5629g) this.f14955n);
                }
                try {
                    m18504a(wVar2, eVar);
                    String userInfo = a2.getURI().getUserInfo();
                    if (userInfo != null) {
                        this.f14956o.mo32855a(new C5765b(), new C5562o(userInfo));
                    }
                    if (this.f14962u != null) {
                        lVar = this.f14962u;
                    } else {
                        URI uri = a2.getURI();
                        if (uri.isAbsolute()) {
                            lVar = C5621d.m17892a(uri);
                        }
                    }
                    if (lVar == null) {
                        lVar = b2.mo33061e();
                    }
                    a2.mo33530f();
                    mo33510a(a2, b2);
                    eVar.mo33535a("http.target_host", lVar);
                    eVar.mo33535a("http.route", b2);
                    eVar.mo33535a("http.connection", this.f14955n);
                    this.f14947f.mo33647a((C5899o) a2, this.f14948g, eVar);
                    qVar = m18505b(wVar2, eVar);
                    if (qVar != null) {
                        qVar.mo33294a(this.f14954m);
                        this.f14947f.mo33648a(qVar, this.f14948g, eVar);
                        z2 = this.f14945d.mo32832a(qVar, eVar);
                        if (z2) {
                            long a5 = this.f14946e.mo33019a(qVar, eVar);
                            if (this.f14942a.mo33168a()) {
                                if (a5 > 0) {
                                    str = "for " + a5 + " " + TimeUnit.MILLISECONDS;
                                } else {
                                    str = "indefinitely";
                                }
                                this.f14942a.mo33166a("Connection can be kept alive " + str);
                            }
                            this.f14955n.mo33035a(a5, TimeUnit.MILLISECONDS);
                        }
                        C5803w a6 = mo33507a(wVar2, qVar, eVar);
                        if (a6 == null) {
                            z = true;
                        } else {
                            if (z2) {
                                C5892g.m18935a(qVar.getEntity());
                                this.f14955n.mo33034S();
                            } else {
                                this.f14955n.close();
                                if (this.f14957p.mo32860d().compareTo(C5548b.CHALLENGED) > 0 && this.f14957p.mo32858b() != null && this.f14957p.mo32858b().mo32840b()) {
                                    this.f14942a.mo33166a("Resetting proxy auth state");
                                    this.f14957p.mo32861e();
                                }
                                if (this.f14956o.mo32860d().compareTo(C5548b.CHALLENGED) > 0 && this.f14956o.mo32858b() != null && this.f14956o.mo32858b().mo32840b()) {
                                    this.f14942a.mo33166a("Resetting target auth state");
                                    this.f14956o.mo32861e();
                                }
                            }
                            if (!a6.mo33532b().equals(wVar2.mo33532b())) {
                                mo33509a();
                            }
                            wVar2 = a6;
                        }
                        if (this.f14955n != null) {
                            if (a3 == null) {
                                a3 = this.f14953l.mo32929a(eVar);
                                eVar.mo33535a("http.user-token", a3);
                            }
                            if (a3 != null) {
                                this.f14955n.mo33039b(a3);
                            }
                        }
                    }
                } catch (TunnelRefusedException e) {
                    if (this.f14942a.mo33168a()) {
                        this.f14942a.mo33166a(e.getMessage());
                    }
                    qVar = e.mo33447a();
                }
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
                throw new InterruptedIOException();
            } catch (ConnectionShutdownException e2) {
                InterruptedIOException interruptedIOException = new InterruptedIOException("Connection has been shut down");
                interruptedIOException.initCause(e2);
                throw interruptedIOException;
            } catch (HttpException e3) {
                m18506b();
                throw e3;
            } catch (IOException e4) {
                m18506b();
                throw e4;
            } catch (RuntimeException e5) {
                m18506b();
                throw e5;
            }
        }
        if (!(qVar == null || qVar.getEntity() == null)) {
            if (qVar.getEntity().mo32901f()) {
                qVar.mo33337a(new C5623a(qVar.getEntity(), this.f14955n, z2));
                return qVar;
            }
        }
        if (z2) {
            this.f14955n.mo33034S();
        }
        mo33509a();
        return qVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public C5645b mo33512b(C5896l lVar, C5899o oVar, C5875e eVar) throws HttpException {
        C5647d dVar = this.f14944c;
        if (lVar == null) {
            lVar = (C5896l) oVar.getParams().mo33425b("http.default-host");
        }
        return dVar.mo33066a(lVar, oVar, eVar);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public boolean mo33513b(C5645b bVar, C5875e eVar) throws HttpException, IOException {
        C5901q c;
        C5896l c2 = bVar.mo33058c();
        C5896l e = bVar.mo33061e();
        while (true) {
            if (!this.f14955n.isOpen()) {
                this.f14955n.mo33036a(bVar, eVar, this.f14954m);
            }
            C5899o a = mo33508a(bVar, eVar);
            a.mo33294a(this.f14954m);
            eVar.mo33535a("http.target_host", e);
            eVar.mo33535a("http.route", bVar);
            eVar.mo33535a("http.proxy_host", c2);
            eVar.mo33535a("http.connection", this.f14955n);
            eVar.mo33535a("http.request", a);
            this.f14947f.mo33647a(a, this.f14948g, eVar);
            c = this.f14947f.mo33651c(a, this.f14955n, eVar);
            c.mo33294a(this.f14954m);
            this.f14947f.mo33648a(c, this.f14948g, eVar);
            if (c.mo33335a().mo33371a() < 200) {
                throw new HttpException("Unexpected response to CONNECT request: " + c.mo33335a());
            } else if (C5605b.m17837b(this.f14954m)) {
                if (!this.f14958q.mo33438b(c2, c, this.f14952k, this.f14957p, eVar)) {
                    break;
                }
                if (!this.f14958q.mo33517c(c2, c, this.f14952k, this.f14957p, eVar)) {
                    break;
                } else if (this.f14945d.mo32832a(c, eVar)) {
                    this.f14942a.mo33166a("Connection kept alive");
                    C5892g.m18935a(c.getEntity());
                } else {
                    this.f14955n.close();
                }
            }
        }
        if (c.mo33335a().mo33371a() > 299) {
            C5870j entity = c.getEntity();
            if (entity != null) {
                c.mo33337a(new C5570c(entity));
            }
            this.f14955n.close();
            throw new TunnelRefusedException("CONNECT refused by proxy: " + c.mo33335a(), c);
        }
        this.f14955n.mo33034S();
        return false;
    }

    /* renamed from: b */
    private void m18506b() {
        C5635m mVar = this.f14955n;
        if (mVar != null) {
            this.f14955n = null;
            try {
                mVar.mo33008t();
            } catch (IOException e) {
                if (this.f14942a.mo33168a()) {
                    this.f14942a.mo33167a(e.getMessage(), e);
                }
            }
            try {
                mVar.mo33006d();
            } catch (IOException e2) {
                this.f14942a.mo33167a("Error releasing connection", e2);
            }
        }
    }

    /* renamed from: a */
    private void m18504a(C5803w wVar, C5875e eVar) throws HttpException, IOException {
        C5645b b = wVar.mo33532b();
        C5802v a = wVar.mo33531a();
        int i = 0;
        while (true) {
            eVar.mo33535a("http.request", a);
            i++;
            try {
                if (!this.f14955n.isOpen()) {
                    this.f14955n.mo33036a(b, eVar, this.f14954m);
                } else {
                    this.f14955n.mo33209f(C5757c.m18344d(this.f14954m));
                }
                mo33514c(b, eVar);
                return;
            } catch (IOException e) {
                try {
                    this.f14955n.close();
                } catch (IOException unused) {
                }
                if (!this.f14949h.mo28925a(e, i, eVar)) {
                    throw e;
                } else if (this.f14942a.mo33173c()) {
                    C5695b bVar = this.f14942a;
                    bVar.mo33172c("I/O exception (" + e.getClass().getName() + ") caught when connecting to " + b + ": " + e.getMessage());
                    if (this.f14942a.mo33168a()) {
                        this.f14942a.mo33167a(e.getMessage(), e);
                    }
                    C5695b bVar2 = this.f14942a;
                    bVar2.mo33172c("Retrying connect to " + b);
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo33509a() {
        try {
            this.f14955n.mo33006d();
        } catch (IOException e) {
            this.f14942a.mo33167a("IOException releasing connection", e);
        }
        this.f14955n = null;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo33511a(C5645b bVar, int i, C5875e eVar) throws HttpException, IOException {
        throw new HttpException("Proxy chains are not supported.");
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public C5899o mo33508a(C5645b bVar, C5875e eVar) {
        C5896l e = bVar.mo33061e();
        String b = e.mo33685b();
        int c = e.mo33686c();
        if (c < 0) {
            c = this.f14943b.mo33010a().mo33096b(e.mo33688d()).mo33084a();
        }
        StringBuilder sb = new StringBuilder(b.length() + 6);
        sb.append(b);
        sb.append(':');
        sb.append(Integer.toString(c));
        return new C5738h("CONNECT", sb.toString(), C5760f.m18361b(this.f14954m));
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public C5803w mo33507a(C5803w wVar, C5901q qVar, C5875e eVar) throws HttpException, IOException {
        C5896l lVar;
        C5901q qVar2 = qVar;
        C5875e eVar2 = eVar;
        C5645b b = wVar.mo33532b();
        C5802v a = wVar.mo33531a();
        C5759e params = a.getParams();
        if (C5605b.m17837b(params)) {
            C5896l lVar2 = (C5896l) eVar2.mo33533a("http.target_host");
            if (lVar2 == null) {
                lVar2 = b.mo33061e();
            }
            if (lVar2.mo33686c() < 0) {
                lVar = new C5896l(lVar2.mo33685b(), this.f14943b.mo33010a().mo33094a(lVar2).mo33084a(), lVar2.mo33688d());
            } else {
                lVar = lVar2;
            }
            boolean b2 = this.f14958q.mo33438b(lVar, qVar, this.f14951j, this.f14956o, eVar);
            C5896l c = b.mo33058c();
            if (c == null) {
                c = b.mo33061e();
            }
            C5896l lVar3 = c;
            boolean b3 = this.f14958q.mo33438b(lVar3, qVar, this.f14952k, this.f14957p, eVar);
            if (b2) {
                if (this.f14958q.mo33517c(lVar, qVar, this.f14951j, this.f14956o, eVar)) {
                    return wVar;
                }
            }
            if (b3) {
                if (this.f14958q.mo33517c(lVar3, qVar, this.f14952k, this.f14957p, eVar)) {
                    return wVar;
                }
            }
        }
        if (!C5605b.m17838c(params) || !this.f14950i.mo32927b(a, qVar2, eVar2)) {
            return null;
        }
        int i = this.f14960s;
        if (i < this.f14961t) {
            this.f14960s = i + 1;
            this.f14962u = null;
            C5600i a2 = this.f14950i.mo32926a(a, qVar2, eVar2);
            a2.mo33295a(a.mo33528c().getAllHeaders());
            URI uri = a2.getURI();
            C5896l a3 = C5621d.m17892a(uri);
            if (a3 != null) {
                if (!b.mo33061e().equals(a3)) {
                    this.f14942a.mo33166a("Resetting target auth state");
                    this.f14956o.mo32861e();
                    C5549c b4 = this.f14957p.mo32858b();
                    if (b4 != null && b4.mo32840b()) {
                        this.f14942a.mo33166a("Resetting proxy auth state");
                        this.f14957p.mo32861e();
                    }
                }
                C5802v a4 = m18503a(a2);
                a4.mo33294a(params);
                C5645b b5 = mo33512b(a3, a4, eVar2);
                C5803w wVar2 = new C5803w(a4, b5);
                if (this.f14942a.mo33168a()) {
                    C5695b bVar = this.f14942a;
                    bVar.mo33166a("Redirecting to '" + uri + "' via " + b5);
                }
                return wVar2;
            }
            throw new ProtocolException("Redirect URI does not specify a valid host name: " + uri);
        }
        throw new RedirectException("Maximum redirects (" + this.f14961t + ") exceeded");
    }
}
