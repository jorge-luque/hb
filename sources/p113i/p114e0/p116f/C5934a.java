package p113i.p114e0.p116f;

import java.io.IOException;
import java.util.List;
import p113i.C3480a0;
import p113i.C3484b0;
import p113i.C3530l;
import p113i.C3537r;
import p113i.C3541u;
import p113i.C3548y;
import p113i.C3550z;
import p113i.C5966m;
import p113i.C5970t;
import p113i.p114e0.C3500c;
import p113i.p114e0.C5928d;
import p118io.fabric.sdk.android.p200m.p202b.C6078a;
import p119j.C3586u;
import p119j.C6587l;
import p119j.C6589n;

/* renamed from: i.e0.f.a */
/* compiled from: BridgeInterceptor */
public final class C5934a implements C5970t {

    /* renamed from: a */
    private final C5966m f15176a;

    public C5934a(C5966m mVar) {
        this.f15176a = mVar;
    }

    /* renamed from: a */
    private String m19016a(List<C3530l> list) {
        StringBuilder sb = new StringBuilder();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                sb.append("; ");
            }
            C3530l lVar = list.get(i);
            sb.append(lVar.mo19461a());
            sb.append('=');
            sb.append(lVar.mo19463b());
        }
        return sb.toString();
    }

    public C3480a0 intercept(C5970t.C5971a aVar) throws IOException {
        C3548y d = aVar.mo33734d();
        C3548y.C3549a f = d.mo19606f();
        C3550z a = d.mo19599a();
        if (a != null) {
            C3541u contentType = a.contentType();
            if (contentType != null) {
                f.mo19619b("Content-Type", contentType.toString());
            }
            long contentLength = a.contentLength();
            if (contentLength != -1) {
                f.mo19619b("Content-Length", Long.toString(contentLength));
                f.mo19613a("Transfer-Encoding");
            } else {
                f.mo19619b("Transfer-Encoding", "chunked");
                f.mo19613a("Content-Length");
            }
        }
        boolean z = false;
        if (d.mo19600a("Host") == null) {
            f.mo19619b("Host", C3500c.m11637a(d.mo19607g(), false));
        }
        if (d.mo19600a("Connection") == null) {
            f.mo19619b("Connection", "Keep-Alive");
        }
        if (d.mo19600a("Accept-Encoding") == null && d.mo19600a("Range") == null) {
            z = true;
            f.mo19619b("Accept-Encoding", "gzip");
        }
        List<C3530l> a2 = this.f15176a.mo33779a(d.mo19607g());
        if (!a2.isEmpty()) {
            f.mo19619b("Cookie", m19016a(a2));
        }
        if (d.mo19600a(C6078a.HEADER_USER_AGENT) == null) {
            f.mo19619b(C6078a.HEADER_USER_AGENT, C5928d.m19001a());
        }
        C3480a0 a3 = aVar.mo33730a(f.mo19616a());
        C5940e.m19032a(this.f15176a, d.mo19607g(), a3.mo19290x());
        C3480a0.C3481a X = a3.mo19275X();
        X.mo19300a(d);
        if (z && "gzip".equalsIgnoreCase(a3.mo19278a("Content-Encoding")) && C5940e.m19035b(a3)) {
            C6587l lVar = new C6587l(a3.mo19284d().source());
            C3537r.C3538a a4 = a3.mo19290x().mo19500a();
            a4.mo19514c("Content-Encoding");
            a4.mo19514c("Content-Length");
            X.mo19298a(a4.mo19511a());
            X.mo19296a((C3484b0) new C3512h(a3.mo19278a("Content-Type"), -1, C6589n.m21610a((C3586u) lVar)));
        }
        return X.mo19303a();
    }
}
