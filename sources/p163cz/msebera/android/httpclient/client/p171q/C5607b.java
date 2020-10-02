package p163cz.msebera.android.httpclient.client.p171q;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import p163cz.msebera.android.httpclient.C5691d;
import p163cz.msebera.android.httpclient.C5896l;
import p163cz.msebera.android.httpclient.C5899o;
import p163cz.msebera.android.httpclient.C5900p;
import p163cz.msebera.android.httpclient.HttpException;
import p163cz.msebera.android.httpclient.client.C5580f;
import p163cz.msebera.android.httpclient.client.p169o.C5600i;
import p163cz.msebera.android.httpclient.conn.p174r.C5648e;
import p163cz.msebera.android.httpclient.cookie.C5679c;
import p163cz.msebera.android.httpclient.cookie.C5682f;
import p163cz.msebera.android.httpclient.cookie.C5684h;
import p163cz.msebera.android.httpclient.cookie.C5686j;
import p163cz.msebera.android.httpclient.p165b0.C5564a;
import p163cz.msebera.android.httpclient.p177d0.C5695b;
import p163cz.msebera.android.httpclient.p186j0.C5875e;
import p163cz.msebera.android.httpclient.p187k0.C5886a;
import p163cz.msebera.android.httpclient.p187k0.C5894i;

/* renamed from: cz.msebera.android.httpclient.client.q.b */
/* compiled from: RequestAddCookies */
public class C5607b implements C5900p {

    /* renamed from: a */
    public C5695b f14592a = new C5695b(C5607b.class);

    /* renamed from: a */
    public void mo28845a(C5899o oVar, C5875e eVar) throws HttpException, IOException {
        URI uri;
        C5691d a;
        C5886a.m18894a(oVar, "HTTP request");
        C5886a.m18894a(eVar, "HTTP context");
        if (!oVar.getRequestLine().getMethod().equalsIgnoreCase("CONNECT")) {
            C5606a a2 = C5606a.m17839a(eVar);
            C5580f j = a2.mo32980j();
            if (j == null) {
                this.f14592a.mo33166a("Cookie store not specified in HTTP context");
                return;
            }
            C5564a<C5686j> i = a2.mo32979i();
            if (i == null) {
                this.f14592a.mo33166a("CookieSpec registry not specified in HTTP context");
                return;
            }
            C5896l c = a2.mo33644c();
            if (c == null) {
                this.f14592a.mo33166a("Target host not set in the context");
                return;
            }
            C5648e l = a2.mo32982l();
            if (l == null) {
                this.f14592a.mo33166a("Connection route not set in the context");
                return;
            }
            String a3 = a2.mo32984n().mo32930a();
            if (a3 == null) {
                a3 = "default";
            }
            if (this.f14592a.mo33168a()) {
                this.f14592a.mo33166a("CookieSpec selected: " + a3);
            }
            String str = null;
            if (oVar instanceof C5600i) {
                uri = ((C5600i) oVar).getURI();
            } else {
                try {
                    uri = new URI(oVar.getRequestLine().getUri());
                } catch (URISyntaxException unused) {
                    uri = null;
                }
            }
            if (uri != null) {
                str = uri.getPath();
            }
            String b = c.mo33685b();
            int c2 = c.mo33686c();
            if (c2 < 0) {
                c2 = l.mo33061e().mo33686c();
            }
            boolean z = false;
            if (c2 < 0) {
                c2 = 0;
            }
            if (C5894i.m18944c(str)) {
                str = "/";
            }
            C5682f fVar = new C5682f(b, c2, str, l.mo33054B());
            C5686j a4 = i.mo32846a(a3);
            if (a4 != null) {
                C5684h a5 = a4.mo33150a(a2);
                List<C5679c> a6 = j.mo32922a();
                ArrayList arrayList = new ArrayList();
                Date date = new Date();
                for (C5679c next : a6) {
                    if (next.mo33125b(date)) {
                        if (this.f14592a.mo33168a()) {
                            this.f14592a.mo33166a("Cookie " + next + " expired");
                        }
                        z = true;
                    } else if (a5.mo33147b(next, fVar)) {
                        if (this.f14592a.mo33168a()) {
                            this.f14592a.mo33166a("Cookie " + next + " match " + fVar);
                        }
                        arrayList.add(next);
                    }
                }
                if (z) {
                    j.mo32924a(date);
                }
                if (!arrayList.isEmpty()) {
                    for (C5691d a7 : a5.mo33145a(arrayList)) {
                        oVar.mo33293a(a7);
                    }
                }
                if (a5.getVersion() > 0 && (a = a5.mo33143a()) != null) {
                    oVar.mo33293a(a);
                }
                eVar.mo33535a("http.cookie-spec", a5);
                eVar.mo33535a("http.cookie-origin", fVar);
            } else if (this.f14592a.mo33168a()) {
                this.f14592a.mo33166a("Unsupported cookie policy: " + a3);
            }
        }
    }
}
