package p113i.p114e0.p116f;

import admost.sdk.base.AdMost;
import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.SocketTimeoutException;
import java.security.cert.CertificateException;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocketFactory;
import okhttp3.internal.connection.C3589c;
import okhttp3.internal.connection.C6613f;
import okhttp3.internal.connection.RouteException;
import okhttp3.internal.http2.ConnectionShutdownException;
import p113i.C3479a;
import p113i.C3480a0;
import p113i.C3484b0;
import p113i.C3494c0;
import p113i.C3497e;
import p113i.C3522g;
import p113i.C3532p;
import p113i.C3539s;
import p113i.C3542v;
import p113i.C3548y;
import p113i.C3550z;
import p113i.C5970t;
import p113i.p114e0.C3500c;

/* renamed from: i.e0.f.j */
/* compiled from: RetryAndFollowUpInterceptor */
public final class C5944j implements C5970t {

    /* renamed from: a */
    private final C3542v f15194a;

    /* renamed from: b */
    private volatile C6613f f15195b;

    /* renamed from: c */
    private Object f15196c;

    /* renamed from: d */
    private volatile boolean f15197d;

    public C5944j(C3542v vVar, boolean z) {
        this.f15194a = vVar;
    }

    /* renamed from: a */
    public void mo33740a() {
        this.f15197d = true;
        C6613f fVar = this.f15195b;
        if (fVar != null) {
            fVar.mo35660a();
        }
    }

    /* renamed from: b */
    public boolean mo33742b() {
        return this.f15197d;
    }

    public C3480a0 intercept(C5970t.C5971a aVar) throws IOException {
        C3548y d = aVar.mo33734d();
        C5942g gVar = (C5942g) aVar;
        C3497e e = gVar.mo33735e();
        C3532p g = gVar.mo33737g();
        C6613f fVar = new C6613f(this.f15194a.mo19560f(), m19061a(d.mo19607g()), e, g, this.f15196c);
        this.f15195b = fVar;
        C3480a0 a0Var = null;
        int i = 0;
        while (!this.f15197d) {
            try {
                C3480a0 a = gVar.mo33731a(d, fVar, (C5937c) null, (C3589c) null);
                if (a0Var != null) {
                    C3480a0.C3481a X = a.mo19275X();
                    C3480a0.C3481a X2 = a0Var.mo19275X();
                    X2.mo19296a((C3484b0) null);
                    X.mo19307c(X2.mo19303a());
                    a = X.mo19303a();
                }
                try {
                    C3548y a2 = m19062a(a, fVar.mo35669g());
                    if (a2 == null) {
                        fVar.mo35668f();
                        return a;
                    }
                    C3500c.m11649a((Closeable) a.mo19284d());
                    int i2 = i + 1;
                    if (i2 <= 20) {
                        a2.mo19599a();
                        if (!m19063a(a, a2.mo19607g())) {
                            fVar.mo35668f();
                            fVar = new C6613f(this.f15194a.mo19560f(), m19061a(a2.mo19607g()), e, g, this.f15196c);
                            this.f15195b = fVar;
                        } else if (fVar.mo35664b() != null) {
                            throw new IllegalStateException("Closing the body of " + a + " didn't close its backing stream. Bad interceptor?");
                        }
                        a0Var = a;
                        d = a2;
                        i = i2;
                    } else {
                        fVar.mo35668f();
                        throw new ProtocolException("Too many follow-up requests: " + i2);
                    }
                } catch (IOException e2) {
                    fVar.mo35668f();
                    throw e2;
                }
            } catch (RouteException e3) {
                if (!m19064a(e3.mo35646b(), fVar, false, d)) {
                    throw e3.mo35644a();
                }
            } catch (IOException e4) {
                if (!m19064a(e4, fVar, !(e4 instanceof ConnectionShutdownException), d)) {
                    throw e4;
                }
            } catch (Throwable th) {
                fVar.mo35661a((IOException) null);
                fVar.mo35668f();
                throw th;
            }
        }
        fVar.mo35668f();
        throw new IOException("Canceled");
    }

    /* renamed from: a */
    public void mo33741a(Object obj) {
        this.f15196c = obj;
    }

    /* renamed from: a */
    private C3479a m19061a(C3539s sVar) {
        C3522g gVar;
        HostnameVerifier hostnameVerifier;
        SSLSocketFactory sSLSocketFactory;
        if (sVar.mo19526h()) {
            SSLSocketFactory A = this.f15194a.mo19553A();
            hostnameVerifier = this.f15194a.mo19568n();
            sSLSocketFactory = A;
            gVar = this.f15194a.mo19558d();
        } else {
            sSLSocketFactory = null;
            hostnameVerifier = null;
            gVar = null;
        }
        return new C3479a(sVar.mo19525g(), sVar.mo19530k(), this.f15194a.mo19564j(), this.f15194a.mo19580z(), sSLSocketFactory, hostnameVerifier, gVar, this.f15194a.mo19576v(), this.f15194a.mo19575u(), this.f15194a.mo19574t(), this.f15194a.mo19561g(), this.f15194a.mo19577w());
    }

    /* renamed from: a */
    private boolean m19064a(IOException iOException, C6613f fVar, boolean z, C3548y yVar) {
        fVar.mo35661a(iOException);
        if (!this.f15194a.mo19579y()) {
            return false;
        }
        if (z) {
            yVar.mo19599a();
        }
        if (m19065a(iOException, z) && fVar.mo35666d()) {
            return true;
        }
        return false;
    }

    /* renamed from: a */
    private boolean m19065a(IOException iOException, boolean z) {
        if (iOException instanceof ProtocolException) {
            return false;
        }
        if (iOException instanceof InterruptedIOException) {
            if (!(iOException instanceof SocketTimeoutException) || z) {
                return false;
            }
            return true;
        } else if ((!(iOException instanceof SSLHandshakeException) || !(iOException.getCause() instanceof CertificateException)) && !(iOException instanceof SSLPeerUnverifiedException)) {
            return true;
        } else {
            return false;
        }
    }

    /* renamed from: a */
    private C3548y m19062a(C3480a0 a0Var, C3494c0 c0Var) throws IOException {
        String a;
        C3539s b;
        Proxy proxy;
        if (a0Var != null) {
            int v = a0Var.mo19288v();
            String e = a0Var.mo19281b0().mo19605e();
            C3550z zVar = null;
            if (v == 307 || v == 308) {
                if (!e.equals("GET") && !e.equals("HEAD")) {
                    return null;
                }
            } else if (v == 401) {
                return this.f15194a.mo19555a().mo19308a(c0Var, a0Var);
            } else {
                if (v != 503) {
                    if (v == 407) {
                        if (c0Var != null) {
                            proxy = c0Var.mo19341b();
                        } else {
                            proxy = this.f15194a.mo19575u();
                        }
                        if (proxy.type() == Proxy.Type.HTTP) {
                            return this.f15194a.mo19576v().mo19308a(c0Var, a0Var);
                        }
                        throw new ProtocolException("Received HTTP_PROXY_AUTH (407) code while not using proxy");
                    } else if (v != 408) {
                        switch (v) {
                            case AdMost.AD_ERROR_FREQ_CAP:
                            case AdMost.AD_ERROR_FREQ_CAP_ON_SHOWN:
                            case AdMost.AD_ERROR_TAG_PASSIVE:
                            case AdMost.AD_ERROR_ZONE_PASSIVE:
                                break;
                            default:
                                return null;
                        }
                    } else if (!this.f15194a.mo19579y()) {
                        return null;
                    } else {
                        a0Var.mo19281b0().mo19599a();
                        if ((a0Var.mo19276Y() == null || a0Var.mo19276Y().mo19288v() != 408) && m19060a(a0Var, 0) <= 0) {
                            return a0Var.mo19281b0();
                        }
                        return null;
                    }
                } else if ((a0Var.mo19276Y() == null || a0Var.mo19276Y().mo19288v() != 503) && m19060a(a0Var, Integer.MAX_VALUE) == 0) {
                    return a0Var.mo19281b0();
                } else {
                    return null;
                }
            }
            if (!this.f15194a.mo19566l() || (a = a0Var.mo19278a("Location")) == null || (b = a0Var.mo19281b0().mo19607g().mo19518b(a)) == null) {
                return null;
            }
            if (!b.mo19533n().equals(a0Var.mo19281b0().mo19607g().mo19533n()) && !this.f15194a.mo19567m()) {
                return null;
            }
            C3548y.C3549a f = a0Var.mo19281b0().mo19606f();
            if (C5941f.m19042b(e)) {
                boolean d = C5941f.m19044d(e);
                if (C5941f.m19043c(e)) {
                    f.mo19614a("GET", (C3550z) null);
                } else {
                    if (d) {
                        zVar = a0Var.mo19281b0().mo19599a();
                    }
                    f.mo19614a(e, zVar);
                }
                if (!d) {
                    f.mo19613a("Transfer-Encoding");
                    f.mo19613a("Content-Length");
                    f.mo19613a("Content-Type");
                }
            }
            if (!m19063a(a0Var, b)) {
                f.mo19613a("Authorization");
            }
            f.mo19611a(b);
            return f.mo19616a();
        }
        throw new IllegalStateException();
    }

    /* renamed from: a */
    private int m19060a(C3480a0 a0Var, int i) {
        String a = a0Var.mo19278a("Retry-After");
        if (a == null) {
            return i;
        }
        if (a.matches("\\d+")) {
            return Integer.valueOf(a).intValue();
        }
        return Integer.MAX_VALUE;
    }

    /* renamed from: a */
    private boolean m19063a(C3480a0 a0Var, C3539s sVar) {
        C3539s g = a0Var.mo19281b0().mo19607g();
        return g.mo19525g().equals(sVar.mo19525g()) && g.mo19530k() == sVar.mo19530k() && g.mo19533n().equals(sVar.mo19533n());
    }
}
