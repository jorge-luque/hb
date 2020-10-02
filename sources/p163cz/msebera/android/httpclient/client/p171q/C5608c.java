package p163cz.msebera.android.httpclient.client.p171q;

import java.io.IOException;
import p163cz.msebera.android.httpclient.C5896l;
import p163cz.msebera.android.httpclient.C5899o;
import p163cz.msebera.android.httpclient.C5900p;
import p163cz.msebera.android.httpclient.HttpException;
import p163cz.msebera.android.httpclient.auth.C5548b;
import p163cz.msebera.android.httpclient.auth.C5549c;
import p163cz.msebera.android.httpclient.auth.C5554g;
import p163cz.msebera.android.httpclient.auth.C5555h;
import p163cz.msebera.android.httpclient.auth.C5559l;
import p163cz.msebera.android.httpclient.client.C5575a;
import p163cz.msebera.android.httpclient.client.C5581g;
import p163cz.msebera.android.httpclient.conn.p174r.C5648e;
import p163cz.msebera.android.httpclient.p177d0.C5695b;
import p163cz.msebera.android.httpclient.p186j0.C5875e;
import p163cz.msebera.android.httpclient.p187k0.C5886a;

/* renamed from: cz.msebera.android.httpclient.client.q.c */
/* compiled from: RequestAuthCache */
public class C5608c implements C5900p {

    /* renamed from: a */
    public C5695b f14593a = new C5695b(C5608c.class);

    /* renamed from: a */
    public void mo28845a(C5899o oVar, C5875e eVar) throws HttpException, IOException {
        C5549c b;
        C5549c b2;
        C5886a.m18894a(oVar, "HTTP request");
        C5886a.m18894a(eVar, "HTTP context");
        C5606a a = C5606a.m17839a(eVar);
        C5575a e = a.mo32975e();
        if (e == null) {
            this.f14593a.mo33166a("Auth cache not set in the context");
            return;
        }
        C5581g k = a.mo32981k();
        if (k == null) {
            this.f14593a.mo33166a("Credentials provider not set in the context");
            return;
        }
        C5648e l = a.mo32982l();
        if (l == null) {
            this.f14593a.mo33166a("Route info not set in the context");
            return;
        }
        C5896l c = a.mo33644c();
        if (c == null) {
            this.f14593a.mo33166a("Target host not set in the context");
            return;
        }
        if (c.mo33686c() < 0) {
            c = new C5896l(c.mo33685b(), l.mo33061e().mo33686c(), c.mo33688d());
        }
        C5555h o = a.mo32985o();
        if (!(o == null || o.mo32860d() != C5548b.UNCHALLENGED || (b2 = e.mo32909b(c)) == null)) {
            m17854a(c, b2, o, k);
        }
        C5896l c2 = l.mo33058c();
        C5555h m = a.mo32983m();
        if (c2 != null && m != null && m.mo32860d() == C5548b.UNCHALLENGED && (b = e.mo32909b(c2)) != null) {
            m17854a(c2, b, m, k);
        }
    }

    /* renamed from: a */
    private void m17854a(C5896l lVar, C5549c cVar, C5555h hVar, C5581g gVar) {
        String d = cVar.mo32842d();
        if (this.f14593a.mo33168a()) {
            C5695b bVar = this.f14593a;
            bVar.mo33166a("Re-using cached '" + d + "' auth scheme for " + lVar);
        }
        C5559l a = gVar.mo32925a(new C5554g(lVar, C5554g.f14502f, d));
        if (a != null) {
            if ("BASIC".equalsIgnoreCase(cVar.mo32842d())) {
                hVar.mo32853a(C5548b.CHALLENGED);
            } else {
                hVar.mo32853a(C5548b.SUCCESS);
            }
            hVar.mo32855a(cVar, a);
            return;
        }
        this.f14593a.mo33166a("No credentials for preemptive authentication");
    }
}
