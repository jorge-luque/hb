package p163cz.msebera.android.httpclient.client.p169o;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.util.List;
import p163cz.msebera.android.httpclient.C5563b;
import p163cz.msebera.android.httpclient.C5870j;
import p163cz.msebera.android.httpclient.C5885k;
import p163cz.msebera.android.httpclient.C5899o;
import p163cz.msebera.android.httpclient.C5906u;
import p163cz.msebera.android.httpclient.C5907v;
import p163cz.msebera.android.httpclient.client.p167m.C5587a;
import p163cz.msebera.android.httpclient.client.p168n.C5589a;
import p163cz.msebera.android.httpclient.client.p172r.C5620c;
import p163cz.msebera.android.httpclient.client.p172r.C5622e;
import p163cz.msebera.android.httpclient.p166c0.C5572e;
import p163cz.msebera.android.httpclient.p182g0.C5748r;
import p163cz.msebera.android.httpclient.p186j0.C5874d;
import p163cz.msebera.android.httpclient.p187k0.C5886a;

/* renamed from: cz.msebera.android.httpclient.client.o.j */
/* compiled from: RequestBuilder */
public class C5601j {

    /* renamed from: a */
    private String f14582a;

    /* renamed from: b */
    private Charset f14583b;

    /* renamed from: c */
    private C5907v f14584c;

    /* renamed from: d */
    private URI f14585d;

    /* renamed from: e */
    private C5748r f14586e;

    /* renamed from: f */
    private C5870j f14587f;

    /* renamed from: g */
    private List<C5906u> f14588g;

    /* renamed from: h */
    private C5587a f14589h;

    /* renamed from: cz.msebera.android.httpclient.client.o.j$a */
    /* compiled from: RequestBuilder */
    static class C5602a extends C5596e {

        /* renamed from: i */
        private final String f14590i;

        C5602a(String str) {
            this.f14590i = str;
        }

        public String getMethod() {
            return this.f14590i;
        }
    }

    /* renamed from: cz.msebera.android.httpclient.client.o.j$b */
    /* compiled from: RequestBuilder */
    static class C5603b extends C5599h {

        /* renamed from: h */
        private final String f14591h;

        C5603b(String str) {
            this.f14591h = str;
        }

        public String getMethod() {
            return this.f14591h;
        }
    }

    C5601j(String str) {
        this.f14583b = C5563b.f14520a;
        this.f14582a = str;
    }

    /* renamed from: a */
    public static C5601j m17831a(C5899o oVar) {
        C5886a.m18894a(oVar, "HTTP request");
        C5601j jVar = new C5601j();
        jVar.m17832b(oVar);
        return jVar;
    }

    /* renamed from: b */
    private C5601j m17832b(C5899o oVar) {
        URI uri;
        if (oVar == null) {
            return this;
        }
        this.f14582a = oVar.getRequestLine().getMethod();
        this.f14584c = oVar.getRequestLine().getProtocolVersion();
        if (this.f14586e == null) {
            this.f14586e = new C5748r();
        }
        this.f14586e.mo33391a();
        this.f14586e.mo33393a(oVar.getAllHeaders());
        this.f14588g = null;
        this.f14587f = null;
        if (oVar instanceof C5885k) {
            C5870j entity = ((C5885k) oVar).getEntity();
            C5572e a = C5572e.m17756a(entity);
            if (a == null || !a.mo32904b().equals(C5572e.f14534d.mo32904b())) {
                this.f14587f = entity;
            } else {
                try {
                    List<C5906u> a2 = C5622e.m17903a(entity);
                    if (!a2.isEmpty()) {
                        this.f14588g = a2;
                    }
                } catch (IOException unused) {
                }
            }
        }
        if (oVar instanceof C5600i) {
            uri = ((C5600i) oVar).getURI();
        } else {
            uri = URI.create(oVar.getRequestLine().getUri());
        }
        C5620c cVar = new C5620c(uri);
        if (this.f14588g == null) {
            List<C5906u> e = cVar.mo33000e();
            if (!e.isEmpty()) {
                this.f14588g = e;
                cVar.mo32993b();
            } else {
                this.f14588g = null;
            }
        }
        try {
            this.f14585d = cVar.mo32992a();
        } catch (URISyntaxException unused2) {
            this.f14585d = uri;
        }
        if (oVar instanceof C5595d) {
            this.f14589h = ((C5595d) oVar).getConfig();
        } else {
            this.f14589h = null;
        }
        return this;
    }

    /* renamed from: a */
    public C5601j mo32973a(URI uri) {
        this.f14585d = uri;
        return this;
    }

    C5601j() {
        this((String) null);
    }

    /* renamed from: a */
    public C5600i mo32972a() {
        C5599h hVar;
        URI uri = this.f14585d;
        if (uri == null) {
            uri = URI.create("/");
        }
        C5870j jVar = this.f14587f;
        List<C5906u> list = this.f14588g;
        if (list != null && !list.isEmpty()) {
            if (jVar != null || (!"POST".equalsIgnoreCase(this.f14582a) && !"PUT".equalsIgnoreCase(this.f14582a))) {
                try {
                    C5620c cVar = new C5620c(uri);
                    cVar.mo32990a(this.f14583b);
                    cVar.mo32991a(this.f14588g);
                    uri = cVar.mo32992a();
                } catch (URISyntaxException unused) {
                }
            } else {
                jVar = new C5589a(this.f14588g, C5874d.f15105a);
            }
        }
        if (jVar == null) {
            hVar = new C5603b(this.f14582a);
        } else {
            C5602a aVar = new C5602a(this.f14582a);
            aVar.mo32960a(jVar);
            hVar = aVar;
        }
        hVar.mo32964a(this.f14584c);
        hVar.mo32965a(uri);
        C5748r rVar = this.f14586e;
        if (rVar != null) {
            hVar.mo33295a(rVar.mo33397b());
        }
        hVar.mo32963a(this.f14589h);
        return hVar;
    }
}
