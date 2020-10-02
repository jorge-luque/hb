package p113i.p114e0.p115e;

import java.io.Closeable;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import p113i.C3480a0;
import p113i.C3484b0;
import p113i.C3537r;
import p113i.C3548y;
import p113i.C5970t;
import p113i.C5972w;
import p113i.p114e0.C3499a;
import p113i.p114e0.C3500c;
import p113i.p114e0.p115e.C3503c;
import p113i.p114e0.p116f.C3512h;
import p113i.p114e0.p116f.C5940e;
import p113i.p114e0.p116f.C5941f;
import p119j.C3577c;
import p119j.C3579d;
import p119j.C3580e;
import p119j.C3585t;
import p119j.C3586u;
import p119j.C3587v;
import p119j.C6589n;

/* renamed from: i.e0.e.a */
/* compiled from: CacheInterceptor */
public final class C5929a implements C5970t {

    /* renamed from: a */
    final C5933f f15170a;

    /* renamed from: i.e0.e.a$a */
    /* compiled from: CacheInterceptor */
    class C5930a implements C3586u {

        /* renamed from: a */
        boolean f15171a;

        /* renamed from: b */
        final /* synthetic */ C3580e f15172b;

        /* renamed from: c */
        final /* synthetic */ C5931b f15173c;

        /* renamed from: d */
        final /* synthetic */ C3579d f15174d;

        C5930a(C5929a aVar, C3580e eVar, C5931b bVar, C3579d dVar) {
            this.f15172b = eVar;
            this.f15173c = bVar;
            this.f15174d = dVar;
        }

        public void close() throws IOException {
            if (!this.f15171a && !C3500c.m11652a((C3586u) this, 100, TimeUnit.MILLISECONDS)) {
                this.f15171a = true;
                this.f15173c.abort();
            }
            this.f15172b.close();
        }

        public long read(C3577c cVar, long j) throws IOException {
            try {
                long read = this.f15172b.read(cVar, j);
                if (read == -1) {
                    if (!this.f15171a) {
                        this.f15171a = true;
                        this.f15174d.close();
                    }
                    return -1;
                }
                cVar.mo19693a(this.f15174d.mo19678C(), cVar.size() - read, read);
                this.f15174d.mo19682J();
                return read;
            } catch (IOException e) {
                if (!this.f15171a) {
                    this.f15171a = true;
                    this.f15173c.abort();
                }
                throw e;
            }
        }

        public C3587v timeout() {
            return this.f15172b.timeout();
        }
    }

    public C5929a(C5933f fVar) {
        this.f15170a = fVar;
    }

    /* renamed from: a */
    private static C3480a0 m19002a(C3480a0 a0Var) {
        if (a0Var == null || a0Var.mo19284d() == null) {
            return a0Var;
        }
        C3480a0.C3481a X = a0Var.mo19275X();
        X.mo19296a((C3484b0) null);
        return X.mo19303a();
    }

    /* renamed from: b */
    static boolean m19006b(String str) {
        return !"Connection".equalsIgnoreCase(str) && !"Keep-Alive".equalsIgnoreCase(str) && !"Proxy-Authenticate".equalsIgnoreCase(str) && !"Proxy-Authorization".equalsIgnoreCase(str) && !"TE".equalsIgnoreCase(str) && !"Trailers".equalsIgnoreCase(str) && !"Transfer-Encoding".equalsIgnoreCase(str) && !"Upgrade".equalsIgnoreCase(str);
    }

    public C3480a0 intercept(C5970t.C5971a aVar) throws IOException {
        C5933f fVar = this.f15170a;
        C3480a0 b = fVar != null ? fVar.mo19336b(aVar.mo33734d()) : null;
        C3503c a = new C3503c.C3504a(System.currentTimeMillis(), aVar.mo33734d(), b).mo19380a();
        C3548y yVar = a.f9720a;
        C3480a0 a0Var = a.f9721b;
        C5933f fVar2 = this.f15170a;
        if (fVar2 != null) {
            fVar2.mo19334a(a);
        }
        if (b != null && a0Var == null) {
            C3500c.m11649a((Closeable) b.mo19284d());
        }
        if (yVar == null && a0Var == null) {
            C3480a0.C3481a aVar2 = new C3480a0.C3481a();
            aVar2.mo19300a(aVar.mo33734d());
            aVar2.mo19299a(C5972w.HTTP_1_1);
            aVar2.mo19293a(504);
            aVar2.mo19301a("Unsatisfiable Request (only-if-cached)");
            aVar2.mo19296a(C3500c.f9703c);
            aVar2.mo19304b(-1);
            aVar2.mo19294a(System.currentTimeMillis());
            return aVar2.mo19303a();
        } else if (yVar == null) {
            C3480a0.C3481a X = a0Var.mo19275X();
            X.mo19295a(m19002a(a0Var));
            return X.mo19303a();
        } else {
            try {
                C3480a0 a2 = aVar.mo33730a(yVar);
                if (a2 == null && b != null) {
                }
                if (a0Var != null) {
                    if (a2.mo19288v() == 304) {
                        C3480a0.C3481a X2 = a0Var.mo19275X();
                        X2.mo19298a(m19004a(a0Var.mo19290x(), a2.mo19290x()));
                        X2.mo19304b(a2.mo19282c0());
                        X2.mo19294a(a2.mo19280a0());
                        X2.mo19295a(m19002a(a0Var));
                        X2.mo19305b(m19002a(a2));
                        C3480a0 a3 = X2.mo19303a();
                        a2.mo19284d().close();
                        this.f15170a.mo19332a();
                        this.f15170a.mo19333a(a0Var, a3);
                        return a3;
                    }
                    C3500c.m11649a((Closeable) a0Var.mo19284d());
                }
                C3480a0.C3481a X3 = a2.mo19275X();
                X3.mo19295a(m19002a(a0Var));
                X3.mo19305b(m19002a(a2));
                C3480a0 a4 = X3.mo19303a();
                if (this.f15170a != null) {
                    if (C5940e.m19035b(a4) && C3503c.m11668a(a4, yVar)) {
                        return m19003a(this.f15170a.mo19331a(a4), a4);
                    }
                    if (C5941f.m19041a(yVar.mo19605e())) {
                        try {
                            this.f15170a.mo19335a(yVar);
                        } catch (IOException unused) {
                        }
                    }
                }
                return a4;
            } finally {
                if (b != null) {
                    C3500c.m11649a((Closeable) b.mo19284d());
                }
            }
        }
    }

    /* renamed from: a */
    private C3480a0 m19003a(C5931b bVar, C3480a0 a0Var) throws IOException {
        C3585t a;
        if (bVar == null || (a = bVar.mo19337a()) == null) {
            return a0Var;
        }
        C5930a aVar = new C5930a(this, a0Var.mo19284d().source(), bVar, C6589n.m21609a(a));
        String a2 = a0Var.mo19278a("Content-Type");
        long contentLength = a0Var.mo19284d().contentLength();
        C3480a0.C3481a X = a0Var.mo19275X();
        X.mo19296a((C3484b0) new C3512h(a2, contentLength, C6589n.m21610a((C3586u) aVar)));
        return X.mo19303a();
    }

    /* renamed from: a */
    private static C3537r m19004a(C3537r rVar, C3537r rVar2) {
        C3537r.C3538a aVar = new C3537r.C3538a();
        int b = rVar.mo19503b();
        for (int i = 0; i < b; i++) {
            String a = rVar.mo19501a(i);
            String b2 = rVar.mo19504b(i);
            if ((!"Warning".equalsIgnoreCase(a) || !b2.startsWith("1")) && (m19005a(a) || !m19006b(a) || rVar2.mo19502a(a) == null)) {
                C3499a.f9700a.mo19373a(aVar, a, b2);
            }
        }
        int b3 = rVar2.mo19503b();
        for (int i2 = 0; i2 < b3; i2++) {
            String a2 = rVar2.mo19501a(i2);
            if (!m19005a(a2) && m19006b(a2)) {
                C3499a.f9700a.mo19373a(aVar, a2, rVar2.mo19504b(i2));
            }
        }
        return aVar.mo19511a();
    }

    /* renamed from: a */
    static boolean m19005a(String str) {
        return "Content-Length".equalsIgnoreCase(str) || "Content-Encoding".equalsIgnoreCase(str) || "Content-Type".equalsIgnoreCase(str);
    }
}
