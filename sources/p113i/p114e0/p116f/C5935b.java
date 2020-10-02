package p113i.p114e0.p116f;

import java.io.IOException;
import java.net.ProtocolException;
import okhttp3.internal.connection.C3589c;
import okhttp3.internal.connection.C6613f;
import p113i.C3480a0;
import p113i.C3548y;
import p113i.C5970t;
import p113i.p114e0.C3500c;
import p119j.C3577c;
import p119j.C3579d;
import p119j.C3585t;
import p119j.C6583h;
import p119j.C6589n;

/* renamed from: i.e0.f.b */
/* compiled from: CallServerInterceptor */
public final class C5935b implements C5970t {

    /* renamed from: a */
    private final boolean f15177a;

    /* renamed from: i.e0.f.b$a */
    /* compiled from: CallServerInterceptor */
    static final class C5936a extends C6583h {

        /* renamed from: b */
        long f15178b;

        C5936a(C3585t tVar) {
            super(tVar);
        }

        /* renamed from: a */
        public void mo19670a(C3577c cVar, long j) throws IOException {
            super.mo19670a(cVar, j);
            this.f15178b += j;
        }
    }

    public C5935b(boolean z) {
        this.f15177a = z;
    }

    public C3480a0 intercept(C5970t.C5971a aVar) throws IOException {
        C3480a0 a0Var;
        C5942g gVar = (C5942g) aVar;
        C5937c h = gVar.mo33738h();
        C6613f i = gVar.mo33739i();
        C3589c cVar = (C3589c) gVar.mo33736f();
        C3548y d = gVar.mo33734d();
        long currentTimeMillis = System.currentTimeMillis();
        gVar.mo33737g().mo19489d(gVar.mo33735e());
        h.mo33725a(d);
        gVar.mo33737g().mo19478a(gVar.mo33735e(), d);
        C3480a0.C3481a aVar2 = null;
        if (C5941f.m19042b(d.mo19605e()) && d.mo19599a() != null) {
            if ("100-continue".equalsIgnoreCase(d.mo19600a("Expect"))) {
                h.mo33726b();
                gVar.mo33737g().mo19491f(gVar.mo33735e());
                aVar2 = h.mo33721a(true);
            }
            if (aVar2 == null) {
                gVar.mo33737g().mo19488c(gVar.mo33735e());
                C5936a aVar3 = new C5936a(h.mo33723a(d, d.mo19599a().contentLength()));
                C3579d a = C6589n.m21609a((C3585t) aVar3);
                d.mo19599a().writeTo(a);
                a.close();
                gVar.mo33737g().mo19474a(gVar.mo33735e(), aVar3.f15178b);
            } else if (!cVar.mo19788c()) {
                i.mo35667e();
            }
        }
        h.mo33724a();
        if (aVar2 == null) {
            gVar.mo33737g().mo19491f(gVar.mo33735e());
            aVar2 = h.mo33721a(false);
        }
        aVar2.mo19300a(d);
        aVar2.mo19297a(i.mo35665c().mo19787b());
        aVar2.mo19304b(currentTimeMillis);
        aVar2.mo19294a(System.currentTimeMillis());
        C3480a0 a2 = aVar2.mo19303a();
        int v = a2.mo19288v();
        if (v == 100) {
            C3480a0.C3481a a3 = h.mo33721a(false);
            a3.mo19300a(d);
            a3.mo19297a(i.mo35665c().mo19787b());
            a3.mo19304b(currentTimeMillis);
            a3.mo19294a(System.currentTimeMillis());
            a2 = a3.mo19303a();
            v = a2.mo19288v();
        }
        gVar.mo33737g().mo19475a(gVar.mo33735e(), a2);
        if (!this.f15177a || v != 101) {
            C3480a0.C3481a X = a2.mo19275X();
            X.mo19296a(h.mo33722a(a2));
            a0Var = X.mo19303a();
        } else {
            C3480a0.C3481a X2 = a2.mo19275X();
            X2.mo19296a(C3500c.f9703c);
            a0Var = X2.mo19303a();
        }
        if ("close".equalsIgnoreCase(a0Var.mo19281b0().mo19600a("Connection")) || "close".equalsIgnoreCase(a0Var.mo19278a("Connection"))) {
            i.mo35667e();
        }
        if ((v != 204 && v != 205) || a0Var.mo19284d().contentLength() <= 0) {
            return a0Var;
        }
        throw new ProtocolException("HTTP " + v + " had non-zero Content-Length: " + a0Var.mo19284d().contentLength());
    }
}
