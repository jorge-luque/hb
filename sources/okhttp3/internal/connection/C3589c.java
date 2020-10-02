package okhttp3.internal.connection;

import java.io.IOException;
import java.lang.ref.Reference;
import java.net.ConnectException;
import java.net.Proxy;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import javax.net.ssl.SSLPeerUnverifiedException;
import okhttp3.internal.http2.C3592h;
import okhttp3.internal.http2.C6615a;
import okhttp3.internal.http2.C6622e;
import okhttp3.internal.http2.C6624f;
import p113i.C3479a;
import p113i.C3480a0;
import p113i.C3494c0;
import p113i.C3497e;
import p113i.C3525i;
import p113i.C3526j;
import p113i.C3532p;
import p113i.C3536q;
import p113i.C3539s;
import p113i.C3542v;
import p113i.C3548y;
import p113i.C3550z;
import p113i.C5970t;
import p113i.C5972w;
import p113i.p114e0.C3499a;
import p113i.p114e0.C3500c;
import p113i.p114e0.C5928d;
import p113i.p114e0.p116f.C5937c;
import p113i.p114e0.p116f.C5940e;
import p113i.p114e0.p117i.C3521f;
import p113i.p114e0.p195g.C5946a;
import p113i.p114e0.p198k.C5961d;
import p118io.fabric.sdk.android.p200m.p202b.C6078a;
import p119j.C3579d;
import p119j.C3580e;
import p119j.C3586u;
import p119j.C6589n;

/* renamed from: okhttp3.internal.connection.c */
/* compiled from: RealConnection */
public final class C3589c extends C6624f.C3590h implements C3525i {

    /* renamed from: b */
    private final C3526j f10053b;

    /* renamed from: c */
    private final C3494c0 f10054c;

    /* renamed from: d */
    private Socket f10055d;

    /* renamed from: e */
    private Socket f10056e;

    /* renamed from: f */
    private C3536q f10057f;

    /* renamed from: g */
    private C5972w f10058g;

    /* renamed from: h */
    private C6624f f10059h;

    /* renamed from: i */
    private C3580e f10060i;

    /* renamed from: j */
    private C3579d f10061j;

    /* renamed from: k */
    public boolean f10062k;

    /* renamed from: l */
    public int f10063l;

    /* renamed from: m */
    public int f10064m = 1;

    /* renamed from: n */
    public final List<Reference<C6613f>> f10065n = new ArrayList();

    /* renamed from: o */
    public long f10066o = Long.MAX_VALUE;

    public C3589c(C3526j jVar, C3494c0 c0Var) {
        this.f10053b = jVar;
        this.f10054c = c0Var;
    }

    /* renamed from: f */
    private C3548y m12222f() throws IOException {
        C3548y.C3549a aVar = new C3548y.C3549a();
        aVar.mo19611a(this.f10054c.mo19340a().mo19272k());
        aVar.mo19614a("CONNECT", (C3550z) null);
        aVar.mo19619b("Host", C3500c.m11637a(this.f10054c.mo19340a().mo19272k(), true));
        aVar.mo19619b("Proxy-Connection", "Keep-Alive");
        aVar.mo19619b(C6078a.HEADER_USER_AGENT, C5928d.m19001a());
        C3548y a = aVar.mo19616a();
        C3480a0.C3481a aVar2 = new C3480a0.C3481a();
        aVar2.mo19300a(a);
        aVar2.mo19299a(C5972w.HTTP_1_1);
        aVar2.mo19293a(407);
        aVar2.mo19301a("Preemptive Authenticate");
        aVar2.mo19296a(C3500c.f9703c);
        aVar2.mo19304b(-1);
        aVar2.mo19294a(-1);
        aVar2.mo19306b("Proxy-Authenticate", "OkHttp-Preemptive");
        C3548y a2 = this.f10054c.mo19340a().mo19267g().mo19308a(this.f10054c, aVar2.mo19303a());
        return a2 != null ? a2 : a;
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0090 A[Catch:{ IOException -> 0x00f9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x00a9  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00d3  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00e0  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x012f  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0135  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo19781a(int r17, int r18, int r19, int r20, boolean r21, p113i.C3497e r22, p113i.C3532p r23) {
        /*
            r16 = this;
            r7 = r16
            r8 = r22
            r9 = r23
            i.w r0 = r7.f10058g
            if (r0 != 0) goto L_0x0150
            i.c0 r0 = r7.f10054c
            i.a r0 = r0.mo19340a()
            java.util.List r0 = r0.mo19261b()
            okhttp3.internal.connection.b r10 = new okhttp3.internal.connection.b
            r10.<init>(r0)
            i.c0 r1 = r7.f10054c
            i.a r1 = r1.mo19340a()
            javax.net.ssl.SSLSocketFactory r1 = r1.mo19271j()
            if (r1 != 0) goto L_0x0074
            i.k r1 = p113i.C3528k.f9820h
            boolean r0 = r0.contains(r1)
            if (r0 == 0) goto L_0x0067
            i.c0 r0 = r7.f10054c
            i.a r0 = r0.mo19340a()
            i.s r0 = r0.mo19272k()
            java.lang.String r0 = r0.mo19525g()
            i.e0.i.f r1 = p113i.p114e0.p117i.C3521f.m11740d()
            boolean r1 = r1.mo19416b((java.lang.String) r0)
            if (r1 == 0) goto L_0x0046
            goto L_0x0086
        L_0x0046:
            okhttp3.internal.connection.RouteException r1 = new okhttp3.internal.connection.RouteException
            java.net.UnknownServiceException r2 = new java.net.UnknownServiceException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "CLEARTEXT communication to "
            r3.append(r4)
            r3.append(r0)
            java.lang.String r0 = " not permitted by network security policy"
            r3.append(r0)
            java.lang.String r0 = r3.toString()
            r2.<init>(r0)
            r1.<init>(r2)
            throw r1
        L_0x0067:
            okhttp3.internal.connection.RouteException r0 = new okhttp3.internal.connection.RouteException
            java.net.UnknownServiceException r1 = new java.net.UnknownServiceException
            java.lang.String r2 = "CLEARTEXT communication not enabled for client"
            r1.<init>(r2)
            r0.<init>(r1)
            throw r0
        L_0x0074:
            i.c0 r0 = r7.f10054c
            i.a r0 = r0.mo19340a()
            java.util.List r0 = r0.mo19264e()
            i.w r1 = p113i.C5972w.H2_PRIOR_KNOWLEDGE
            boolean r0 = r0.contains(r1)
            if (r0 != 0) goto L_0x0143
        L_0x0086:
            r11 = 0
            r12 = r11
        L_0x0088:
            i.c0 r0 = r7.f10054c     // Catch:{ IOException -> 0x00f9 }
            boolean r0 = r0.mo19342c()     // Catch:{ IOException -> 0x00f9 }
            if (r0 == 0) goto L_0x00a9
            r1 = r16
            r2 = r17
            r3 = r18
            r4 = r19
            r5 = r22
            r6 = r23
            r1.m12218a(r2, r3, r4, r5, r6)     // Catch:{ IOException -> 0x00f9 }
            java.net.Socket r0 = r7.f10055d     // Catch:{ IOException -> 0x00f9 }
            if (r0 != 0) goto L_0x00a4
            goto L_0x00c6
        L_0x00a4:
            r13 = r17
            r14 = r18
            goto L_0x00b0
        L_0x00a9:
            r13 = r17
            r14 = r18
            r7.m12219a((int) r13, (int) r14, (p113i.C3497e) r8, (p113i.C3532p) r9)     // Catch:{ IOException -> 0x00f7 }
        L_0x00b0:
            r15 = r20
            r7.m12221a((okhttp3.internal.connection.C6609b) r10, (int) r15, (p113i.C3497e) r8, (p113i.C3532p) r9)     // Catch:{ IOException -> 0x00f5 }
            i.c0 r0 = r7.f10054c     // Catch:{ IOException -> 0x00f5 }
            java.net.InetSocketAddress r0 = r0.mo19343d()     // Catch:{ IOException -> 0x00f5 }
            i.c0 r1 = r7.f10054c     // Catch:{ IOException -> 0x00f5 }
            java.net.Proxy r1 = r1.mo19341b()     // Catch:{ IOException -> 0x00f5 }
            i.w r2 = r7.f10058g     // Catch:{ IOException -> 0x00f5 }
            r9.mo19483a(r8, r0, r1, r2)     // Catch:{ IOException -> 0x00f5 }
        L_0x00c6:
            i.c0 r0 = r7.f10054c
            boolean r0 = r0.mo19342c()
            if (r0 == 0) goto L_0x00e0
            java.net.Socket r0 = r7.f10055d
            if (r0 == 0) goto L_0x00d3
            goto L_0x00e0
        L_0x00d3:
            java.net.ProtocolException r0 = new java.net.ProtocolException
            java.lang.String r1 = "Too many tunnel connections attempted: 21"
            r0.<init>(r1)
            okhttp3.internal.connection.RouteException r1 = new okhttp3.internal.connection.RouteException
            r1.<init>(r0)
            throw r1
        L_0x00e0:
            okhttp3.internal.http2.f r0 = r7.f10059h
            if (r0 == 0) goto L_0x00f4
            i.j r1 = r7.f10053b
            monitor-enter(r1)
            okhttp3.internal.http2.f r0 = r7.f10059h     // Catch:{ all -> 0x00f1 }
            int r0 = r0.mo35703t()     // Catch:{ all -> 0x00f1 }
            r7.f10064m = r0     // Catch:{ all -> 0x00f1 }
            monitor-exit(r1)     // Catch:{ all -> 0x00f1 }
            goto L_0x00f4
        L_0x00f1:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x00f1 }
            throw r0
        L_0x00f4:
            return
        L_0x00f5:
            r0 = move-exception
            goto L_0x0100
        L_0x00f7:
            r0 = move-exception
            goto L_0x00fe
        L_0x00f9:
            r0 = move-exception
            r13 = r17
            r14 = r18
        L_0x00fe:
            r15 = r20
        L_0x0100:
            java.net.Socket r1 = r7.f10056e
            p113i.p114e0.C3500c.m11651a((java.net.Socket) r1)
            java.net.Socket r1 = r7.f10055d
            p113i.p114e0.C3500c.m11651a((java.net.Socket) r1)
            r7.f10056e = r11
            r7.f10055d = r11
            r7.f10060i = r11
            r7.f10061j = r11
            r7.f10057f = r11
            r7.f10058g = r11
            r7.f10059h = r11
            i.c0 r1 = r7.f10054c
            java.net.InetSocketAddress r3 = r1.mo19343d()
            i.c0 r1 = r7.f10054c
            java.net.Proxy r4 = r1.mo19341b()
            r5 = 0
            r1 = r23
            r2 = r22
            r6 = r0
            r1.mo19484a(r2, r3, r4, r5, r6)
            if (r12 != 0) goto L_0x0135
            okhttp3.internal.connection.RouteException r12 = new okhttp3.internal.connection.RouteException
            r12.<init>(r0)
            goto L_0x0138
        L_0x0135:
            r12.mo35645a(r0)
        L_0x0138:
            if (r21 == 0) goto L_0x0142
            boolean r0 = r10.mo35648a((java.io.IOException) r0)
            if (r0 == 0) goto L_0x0142
            goto L_0x0088
        L_0x0142:
            throw r12
        L_0x0143:
            okhttp3.internal.connection.RouteException r0 = new okhttp3.internal.connection.RouteException
            java.net.UnknownServiceException r1 = new java.net.UnknownServiceException
            java.lang.String r2 = "H2_PRIOR_KNOWLEDGE cannot be used with HTTPS"
            r1.<init>(r2)
            r0.<init>(r1)
            throw r0
        L_0x0150:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "already connected"
            r0.<init>(r1)
            goto L_0x0159
        L_0x0158:
            throw r0
        L_0x0159:
            goto L_0x0158
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.connection.C3589c.mo19781a(int, int, int, int, boolean, i.e, i.p):void");
    }

    /* renamed from: b */
    public C3536q mo19787b() {
        return this.f10057f;
    }

    /* renamed from: c */
    public boolean mo19788c() {
        return this.f10059h != null;
    }

    /* renamed from: d */
    public C3494c0 mo19789d() {
        return this.f10054c;
    }

    /* renamed from: e */
    public Socket mo19790e() {
        return this.f10056e;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Connection{");
        sb.append(this.f10054c.mo19340a().mo19272k().mo19525g());
        sb.append(":");
        sb.append(this.f10054c.mo19340a().mo19272k().mo19530k());
        sb.append(", proxy=");
        sb.append(this.f10054c.mo19341b());
        sb.append(" hostAddress=");
        sb.append(this.f10054c.mo19343d());
        sb.append(" cipherSuite=");
        C3536q qVar = this.f10057f;
        sb.append(qVar != null ? qVar.mo19494a() : "none");
        sb.append(" protocol=");
        sb.append(this.f10058g);
        sb.append('}');
        return sb.toString();
    }

    /* renamed from: a */
    private void m12218a(int i, int i2, int i3, C3497e eVar, C3532p pVar) throws IOException {
        C3548y f = m12222f();
        C3539s g = f.mo19607g();
        int i4 = 0;
        while (i4 < 21) {
            m12219a(i, i2, eVar, pVar);
            f = m12216a(i2, i3, f, g);
            if (f != null) {
                C3500c.m11651a(this.f10055d);
                this.f10055d = null;
                this.f10061j = null;
                this.f10060i = null;
                pVar.mo19483a(eVar, this.f10054c.mo19343d(), this.f10054c.mo19341b(), (C5972w) null);
                i4++;
            } else {
                return;
            }
        }
    }

    /* renamed from: a */
    private void m12219a(int i, int i2, C3497e eVar, C3532p pVar) throws IOException {
        Socket socket;
        Proxy b = this.f10054c.mo19341b();
        C3479a a = this.f10054c.mo19340a();
        if (b.type() == Proxy.Type.DIRECT || b.type() == Proxy.Type.HTTP) {
            socket = a.mo19270i().createSocket();
        } else {
            socket = new Socket(b);
        }
        this.f10055d = socket;
        pVar.mo19482a(eVar, this.f10054c.mo19343d(), b);
        this.f10055d.setSoTimeout(i2);
        try {
            C3521f.m11740d().mo19411a(this.f10055d, this.f10054c.mo19343d(), i);
            try {
                this.f10060i = C6589n.m21610a(C6589n.m21620b(this.f10055d));
                this.f10061j = C6589n.m21609a(C6589n.m21615a(this.f10055d));
            } catch (NullPointerException e) {
                if ("throw with null exception".equals(e.getMessage())) {
                    throw new IOException(e);
                }
            }
        } catch (ConnectException e2) {
            ConnectException connectException = new ConnectException("Failed to connect to " + this.f10054c.mo19343d());
            connectException.initCause(e2);
            throw connectException;
        }
    }

    /* renamed from: a */
    private void m12221a(C6609b bVar, int i, C3497e eVar, C3532p pVar) throws IOException {
        if (this.f10054c.mo19340a().mo19271j() != null) {
            pVar.mo19492g(eVar);
            m12220a(bVar);
            pVar.mo19477a(eVar, this.f10057f);
            if (this.f10058g == C5972w.HTTP_2) {
                m12217a(i);
            }
        } else if (this.f10054c.mo19340a().mo19264e().contains(C5972w.H2_PRIOR_KNOWLEDGE)) {
            this.f10056e = this.f10055d;
            this.f10058g = C5972w.H2_PRIOR_KNOWLEDGE;
            m12217a(i);
        } else {
            this.f10056e = this.f10055d;
            this.f10058g = C5972w.HTTP_1_1;
        }
    }

    /* renamed from: a */
    private void m12217a(int i) throws IOException {
        this.f10056e.setSoTimeout(0);
        C6624f.C6631g gVar = new C6624f.C6631g(true);
        gVar.mo35706a(this.f10056e, this.f10054c.mo19340a().mo19272k().mo19525g(), this.f10060i, this.f10061j);
        gVar.mo35707a((C6624f.C3590h) this);
        gVar.mo35705a(i);
        C6624f a = gVar.mo35708a();
        this.f10059h = a;
        a.mo35704u();
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v0, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v2, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: javax.net.ssl.SSLSocket} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v3, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v7, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v10, resolved type: java.lang.String} */
    /* JADX WARNING: type inference failed for: r2v1, types: [java.net.Socket, javax.net.ssl.SSLSocket] */
    /* JADX WARNING: type inference failed for: r2v4 */
    /* JADX WARNING: type inference failed for: r2v9 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x010f A[Catch:{ all -> 0x0106 }] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0115 A[Catch:{ all -> 0x0106 }] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0118  */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m12220a(okhttp3.internal.connection.C6609b r8) throws java.io.IOException {
        /*
            r7 = this;
            i.c0 r0 = r7.f10054c
            i.a r0 = r0.mo19340a()
            javax.net.ssl.SSLSocketFactory r1 = r0.mo19271j()
            r2 = 0
            java.net.Socket r3 = r7.f10055d     // Catch:{ AssertionError -> 0x0108 }
            i.s r4 = r0.mo19272k()     // Catch:{ AssertionError -> 0x0108 }
            java.lang.String r4 = r4.mo19525g()     // Catch:{ AssertionError -> 0x0108 }
            i.s r5 = r0.mo19272k()     // Catch:{ AssertionError -> 0x0108 }
            int r5 = r5.mo19530k()     // Catch:{ AssertionError -> 0x0108 }
            r6 = 1
            java.net.Socket r1 = r1.createSocket(r3, r4, r5, r6)     // Catch:{ AssertionError -> 0x0108 }
            javax.net.ssl.SSLSocket r1 = (javax.net.ssl.SSLSocket) r1     // Catch:{ AssertionError -> 0x0108 }
            i.k r8 = r8.mo35647a((javax.net.ssl.SSLSocket) r1)     // Catch:{ AssertionError -> 0x0103, all -> 0x0100 }
            boolean r3 = r8.mo19450c()     // Catch:{ AssertionError -> 0x0103, all -> 0x0100 }
            if (r3 == 0) goto L_0x0041
            i.e0.i.f r3 = p113i.p114e0.p117i.C3521f.m11740d()     // Catch:{ AssertionError -> 0x0103, all -> 0x0100 }
            i.s r4 = r0.mo19272k()     // Catch:{ AssertionError -> 0x0103, all -> 0x0100 }
            java.lang.String r4 = r4.mo19525g()     // Catch:{ AssertionError -> 0x0103, all -> 0x0100 }
            java.util.List r5 = r0.mo19264e()     // Catch:{ AssertionError -> 0x0103, all -> 0x0100 }
            r3.mo19412a((javax.net.ssl.SSLSocket) r1, (java.lang.String) r4, (java.util.List<p113i.C5972w>) r5)     // Catch:{ AssertionError -> 0x0103, all -> 0x0100 }
        L_0x0041:
            r1.startHandshake()     // Catch:{ AssertionError -> 0x0103, all -> 0x0100 }
            javax.net.ssl.SSLSession r3 = r1.getSession()     // Catch:{ AssertionError -> 0x0103, all -> 0x0100 }
            i.q r4 = p113i.C3536q.m11826a(r3)     // Catch:{ AssertionError -> 0x0103, all -> 0x0100 }
            javax.net.ssl.HostnameVerifier r5 = r0.mo19263d()     // Catch:{ AssertionError -> 0x0103, all -> 0x0100 }
            i.s r6 = r0.mo19272k()     // Catch:{ AssertionError -> 0x0103, all -> 0x0100 }
            java.lang.String r6 = r6.mo19525g()     // Catch:{ AssertionError -> 0x0103, all -> 0x0100 }
            boolean r3 = r5.verify(r6, r3)     // Catch:{ AssertionError -> 0x0103, all -> 0x0100 }
            if (r3 == 0) goto L_0x00ae
            i.g r3 = r0.mo19259a()     // Catch:{ AssertionError -> 0x0103, all -> 0x0100 }
            i.s r0 = r0.mo19272k()     // Catch:{ AssertionError -> 0x0103, all -> 0x0100 }
            java.lang.String r0 = r0.mo19525g()     // Catch:{ AssertionError -> 0x0103, all -> 0x0100 }
            java.util.List r5 = r4.mo19496c()     // Catch:{ AssertionError -> 0x0103, all -> 0x0100 }
            r3.mo19432a(r0, r5)     // Catch:{ AssertionError -> 0x0103, all -> 0x0100 }
            boolean r8 = r8.mo19450c()     // Catch:{ AssertionError -> 0x0103, all -> 0x0100 }
            if (r8 == 0) goto L_0x007f
            i.e0.i.f r8 = p113i.p114e0.p117i.C3521f.m11740d()     // Catch:{ AssertionError -> 0x0103, all -> 0x0100 }
            java.lang.String r2 = r8.mo19414b((javax.net.ssl.SSLSocket) r1)     // Catch:{ AssertionError -> 0x0103, all -> 0x0100 }
        L_0x007f:
            r7.f10056e = r1     // Catch:{ AssertionError -> 0x0103, all -> 0x0100 }
            j.u r8 = p119j.C6589n.m21620b((java.net.Socket) r1)     // Catch:{ AssertionError -> 0x0103, all -> 0x0100 }
            j.e r8 = p119j.C6589n.m21610a((p119j.C3586u) r8)     // Catch:{ AssertionError -> 0x0103, all -> 0x0100 }
            r7.f10060i = r8     // Catch:{ AssertionError -> 0x0103, all -> 0x0100 }
            java.net.Socket r8 = r7.f10056e     // Catch:{ AssertionError -> 0x0103, all -> 0x0100 }
            j.t r8 = p119j.C6589n.m21615a((java.net.Socket) r8)     // Catch:{ AssertionError -> 0x0103, all -> 0x0100 }
            j.d r8 = p119j.C6589n.m21609a((p119j.C3585t) r8)     // Catch:{ AssertionError -> 0x0103, all -> 0x0100 }
            r7.f10061j = r8     // Catch:{ AssertionError -> 0x0103, all -> 0x0100 }
            r7.f10057f = r4     // Catch:{ AssertionError -> 0x0103, all -> 0x0100 }
            if (r2 == 0) goto L_0x00a0
            i.w r8 = p113i.C5972w.m19139a(r2)     // Catch:{ AssertionError -> 0x0103, all -> 0x0100 }
            goto L_0x00a2
        L_0x00a0:
            i.w r8 = p113i.C5972w.HTTP_1_1     // Catch:{ AssertionError -> 0x0103, all -> 0x0100 }
        L_0x00a2:
            r7.f10058g = r8     // Catch:{ AssertionError -> 0x0103, all -> 0x0100 }
            if (r1 == 0) goto L_0x00ad
            i.e0.i.f r8 = p113i.p114e0.p117i.C3521f.m11740d()
            r8.mo19426a((javax.net.ssl.SSLSocket) r1)
        L_0x00ad:
            return
        L_0x00ae:
            java.util.List r8 = r4.mo19496c()     // Catch:{ AssertionError -> 0x0103, all -> 0x0100 }
            r2 = 0
            java.lang.Object r8 = r8.get(r2)     // Catch:{ AssertionError -> 0x0103, all -> 0x0100 }
            java.security.cert.X509Certificate r8 = (java.security.cert.X509Certificate) r8     // Catch:{ AssertionError -> 0x0103, all -> 0x0100 }
            javax.net.ssl.SSLPeerUnverifiedException r2 = new javax.net.ssl.SSLPeerUnverifiedException     // Catch:{ AssertionError -> 0x0103, all -> 0x0100 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ AssertionError -> 0x0103, all -> 0x0100 }
            r3.<init>()     // Catch:{ AssertionError -> 0x0103, all -> 0x0100 }
            java.lang.String r4 = "Hostname "
            r3.append(r4)     // Catch:{ AssertionError -> 0x0103, all -> 0x0100 }
            i.s r0 = r0.mo19272k()     // Catch:{ AssertionError -> 0x0103, all -> 0x0100 }
            java.lang.String r0 = r0.mo19525g()     // Catch:{ AssertionError -> 0x0103, all -> 0x0100 }
            r3.append(r0)     // Catch:{ AssertionError -> 0x0103, all -> 0x0100 }
            java.lang.String r0 = " not verified:\n    certificate: "
            r3.append(r0)     // Catch:{ AssertionError -> 0x0103, all -> 0x0100 }
            java.lang.String r0 = p113i.C3522g.m11756a((java.security.cert.Certificate) r8)     // Catch:{ AssertionError -> 0x0103, all -> 0x0100 }
            r3.append(r0)     // Catch:{ AssertionError -> 0x0103, all -> 0x0100 }
            java.lang.String r0 = "\n    DN: "
            r3.append(r0)     // Catch:{ AssertionError -> 0x0103, all -> 0x0100 }
            java.security.Principal r0 = r8.getSubjectDN()     // Catch:{ AssertionError -> 0x0103, all -> 0x0100 }
            java.lang.String r0 = r0.getName()     // Catch:{ AssertionError -> 0x0103, all -> 0x0100 }
            r3.append(r0)     // Catch:{ AssertionError -> 0x0103, all -> 0x0100 }
            java.lang.String r0 = "\n    subjectAltNames: "
            r3.append(r0)     // Catch:{ AssertionError -> 0x0103, all -> 0x0100 }
            java.util.List r8 = p113i.p114e0.p198k.C5961d.m19115a(r8)     // Catch:{ AssertionError -> 0x0103, all -> 0x0100 }
            r3.append(r8)     // Catch:{ AssertionError -> 0x0103, all -> 0x0100 }
            java.lang.String r8 = r3.toString()     // Catch:{ AssertionError -> 0x0103, all -> 0x0100 }
            r2.<init>(r8)     // Catch:{ AssertionError -> 0x0103, all -> 0x0100 }
            throw r2     // Catch:{ AssertionError -> 0x0103, all -> 0x0100 }
        L_0x0100:
            r8 = move-exception
            r2 = r1
            goto L_0x0116
        L_0x0103:
            r8 = move-exception
            r2 = r1
            goto L_0x0109
        L_0x0106:
            r8 = move-exception
            goto L_0x0116
        L_0x0108:
            r8 = move-exception
        L_0x0109:
            boolean r0 = p113i.p114e0.C3500c.m11653a((java.lang.AssertionError) r8)     // Catch:{ all -> 0x0106 }
            if (r0 == 0) goto L_0x0115
            java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x0106 }
            r0.<init>(r8)     // Catch:{ all -> 0x0106 }
            throw r0     // Catch:{ all -> 0x0106 }
        L_0x0115:
            throw r8     // Catch:{ all -> 0x0106 }
        L_0x0116:
            if (r2 == 0) goto L_0x011f
            i.e0.i.f r0 = p113i.p114e0.p117i.C3521f.m11740d()
            r0.mo19426a((javax.net.ssl.SSLSocket) r2)
        L_0x011f:
            p113i.p114e0.C3500c.m11651a((java.net.Socket) r2)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.connection.C3589c.m12220a(okhttp3.internal.connection.b):void");
    }

    /* renamed from: a */
    private C3548y m12216a(int i, int i2, C3548y yVar, C3539s sVar) throws IOException {
        String str = "CONNECT " + C3500c.m11637a(sVar, true) + " HTTP/1.1";
        while (true) {
            C5946a aVar = new C5946a((C3542v) null, (C6613f) null, this.f10060i, this.f10061j);
            this.f10060i.timeout().mo19773a((long) i, TimeUnit.MILLISECONDS);
            this.f10061j.timeout().mo19773a((long) i2, TimeUnit.MILLISECONDS);
            aVar.mo33746a(yVar.mo19603c(), str);
            aVar.mo33724a();
            C3480a0.C3481a a = aVar.mo33721a(false);
            a.mo19300a(yVar);
            C3480a0 a2 = a.mo19303a();
            long a3 = C5940e.m19028a(a2);
            if (a3 == -1) {
                a3 = 0;
            }
            C3586u b = aVar.mo33748b(a3);
            C3500c.m11660b(b, Integer.MAX_VALUE, TimeUnit.MILLISECONDS);
            b.close();
            int v = a2.mo19288v();
            if (v != 200) {
                if (v == 407) {
                    C3548y a4 = this.f10054c.mo19340a().mo19267g().mo19308a(this.f10054c, a2);
                    if (a4 == null) {
                        throw new IOException("Failed to authenticate with proxy");
                    } else if ("close".equalsIgnoreCase(a2.mo19278a("Connection"))) {
                        return a4;
                    } else {
                        yVar = a4;
                    }
                } else {
                    throw new IOException("Unexpected response code for CONNECT: " + a2.mo19288v());
                }
            } else if (this.f10060i.mo19678C().mo19681H() && this.f10061j.mo19678C().mo19681H()) {
                return null;
            } else {
                throw new IOException("TLS tunnel buffered too many bytes!");
            }
        }
    }

    /* renamed from: a */
    public boolean mo19784a(C3479a aVar, @Nullable C3494c0 c0Var) {
        if (this.f10065n.size() >= this.f10064m || this.f10062k || !C3499a.f9700a.mo19374a(this.f10054c.mo19340a(), aVar)) {
            return false;
        }
        if (aVar.mo19272k().mo19525g().equals(mo19789d().mo19340a().mo19272k().mo19525g())) {
            return true;
        }
        if (this.f10059h == null || c0Var == null || c0Var.mo19341b().type() != Proxy.Type.DIRECT || this.f10054c.mo19341b().type() != Proxy.Type.DIRECT || !this.f10054c.mo19343d().equals(c0Var.mo19343d()) || c0Var.mo19340a().mo19263d() != C5961d.f15230a || !mo19785a(aVar.mo19272k())) {
            return false;
        }
        try {
            aVar.mo19259a().mo19432a(aVar.mo19272k().mo19525g(), mo19787b().mo19496c());
            return true;
        } catch (SSLPeerUnverifiedException unused) {
            return false;
        }
    }

    /* renamed from: a */
    public boolean mo19785a(C3539s sVar) {
        if (sVar.mo19530k() != this.f10054c.mo19340a().mo19272k().mo19530k()) {
            return false;
        }
        if (sVar.mo19525g().equals(this.f10054c.mo19340a().mo19272k().mo19525g())) {
            return true;
        }
        if (this.f10057f == null || !C5961d.f15230a.mo33773a(sVar.mo19525g(), (X509Certificate) this.f10057f.mo19496c().get(0))) {
            return false;
        }
        return true;
    }

    /* renamed from: a */
    public C5937c mo19779a(C3542v vVar, C5970t.C5971a aVar, C6613f fVar) throws SocketException {
        if (this.f10059h != null) {
            return new C6622e(vVar, aVar, fVar, this.f10059h);
        }
        this.f10056e.setSoTimeout(aVar.mo33729a());
        this.f10060i.timeout().mo19773a((long) aVar.mo33729a(), TimeUnit.MILLISECONDS);
        this.f10061j.timeout().mo19773a((long) aVar.mo33732b(), TimeUnit.MILLISECONDS);
        return new C5946a(vVar, fVar, this.f10060i, this.f10061j);
    }

    /* renamed from: a */
    public void mo19780a() {
        C3500c.m11651a(this.f10055d);
    }

    /* renamed from: a */
    public boolean mo19786a(boolean z) {
        int soTimeout;
        if (this.f10056e.isClosed() || this.f10056e.isInputShutdown() || this.f10056e.isOutputShutdown()) {
            return false;
        }
        C6624f fVar = this.f10059h;
        if (fVar != null) {
            return !fVar.mo35700d();
        }
        if (z) {
            try {
                soTimeout = this.f10056e.getSoTimeout();
                this.f10056e.setSoTimeout(1);
                if (this.f10060i.mo19681H()) {
                    this.f10056e.setSoTimeout(soTimeout);
                    return false;
                }
                this.f10056e.setSoTimeout(soTimeout);
                return true;
            } catch (SocketTimeoutException unused) {
            } catch (IOException unused2) {
                return false;
            } catch (Throwable th) {
                this.f10056e.setSoTimeout(soTimeout);
                throw th;
            }
        }
        return true;
    }

    /* renamed from: a */
    public void mo19783a(C3592h hVar) throws IOException {
        hVar.mo19796a(C6615a.REFUSED_STREAM);
    }

    /* renamed from: a */
    public void mo19782a(C6624f fVar) {
        synchronized (this.f10053b) {
            this.f10064m = fVar.mo35703t();
        }
    }
}
