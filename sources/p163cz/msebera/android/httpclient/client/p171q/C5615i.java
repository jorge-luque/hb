package p163cz.msebera.android.httpclient.client.p171q;

import java.io.IOException;
import p163cz.msebera.android.httpclient.C5691d;
import p163cz.msebera.android.httpclient.C5730g;
import p163cz.msebera.android.httpclient.C5901q;
import p163cz.msebera.android.httpclient.C5903s;
import p163cz.msebera.android.httpclient.HttpException;
import p163cz.msebera.android.httpclient.client.C5580f;
import p163cz.msebera.android.httpclient.cookie.C5679c;
import p163cz.msebera.android.httpclient.cookie.C5682f;
import p163cz.msebera.android.httpclient.cookie.C5684h;
import p163cz.msebera.android.httpclient.cookie.MalformedCookieException;
import p163cz.msebera.android.httpclient.p177d0.C5695b;
import p163cz.msebera.android.httpclient.p186j0.C5875e;
import p163cz.msebera.android.httpclient.p187k0.C5886a;

/* renamed from: cz.msebera.android.httpclient.client.q.i */
/* compiled from: ResponseProcessCookies */
public class C5615i implements C5903s {

    /* renamed from: a */
    public C5695b f14598a = new C5695b(C5615i.class);

    /* renamed from: a */
    public void mo28846a(C5901q qVar, C5875e eVar) throws HttpException, IOException {
        C5886a.m18894a(qVar, "HTTP request");
        C5886a.m18894a(eVar, "HTTP context");
        C5606a a = C5606a.m17839a(eVar);
        C5684h h = a.mo32978h();
        if (h == null) {
            this.f14598a.mo33166a("Cookie spec not specified in HTTP context");
            return;
        }
        C5580f j = a.mo32980j();
        if (j == null) {
            this.f14598a.mo33166a("Cookie store not specified in HTTP context");
            return;
        }
        C5682f g = a.mo32977g();
        if (g == null) {
            this.f14598a.mo33166a("Cookie origin not specified in HTTP context");
            return;
        }
        m17864a(qVar.headerIterator("Set-Cookie"), h, g, j);
        if (h.getVersion() > 0) {
            m17864a(qVar.headerIterator("Set-Cookie2"), h, g, j);
        }
    }

    /* renamed from: a */
    private void m17864a(C5730g gVar, C5684h hVar, C5682f fVar, C5580f fVar2) {
        while (gVar.hasNext()) {
            C5691d nextHeader = gVar.nextHeader();
            try {
                for (C5679c next : hVar.mo33144a(nextHeader, fVar)) {
                    try {
                        hVar.mo33146a(next, fVar);
                        fVar2.mo32923a(next);
                        if (this.f14598a.mo33168a()) {
                            C5695b bVar = this.f14598a;
                            bVar.mo33166a("Cookie accepted [" + m17863a(next) + "]");
                        }
                    } catch (MalformedCookieException e) {
                        if (this.f14598a.mo33175d()) {
                            C5695b bVar2 = this.f14598a;
                            bVar2.mo33174d("Cookie rejected [" + m17863a(next) + "] " + e.getMessage());
                        }
                    }
                }
            } catch (MalformedCookieException e2) {
                if (this.f14598a.mo33175d()) {
                    C5695b bVar3 = this.f14598a;
                    bVar3.mo33174d("Invalid cookie header: \"" + nextHeader + "\". " + e2.getMessage());
                }
            }
        }
    }

    /* renamed from: a */
    private static String m17863a(C5679c cVar) {
        StringBuilder sb = new StringBuilder();
        sb.append(cVar.getName());
        sb.append("=\"");
        String value = cVar.getValue();
        if (value != null) {
            if (value.length() > 100) {
                value = value.substring(0, 100) + "...";
            }
            sb.append(value);
        }
        sb.append("\"");
        sb.append(", version:");
        sb.append(Integer.toString(cVar.getVersion()));
        sb.append(", domain:");
        sb.append(cVar.mo33127d());
        sb.append(", path:");
        sb.append(cVar.mo33126c());
        sb.append(", expiry:");
        sb.append(cVar.mo33124b());
        return sb.toString();
    }
}
