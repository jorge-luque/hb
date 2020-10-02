package p163cz.msebera.android.httpclient.client.p171q;

import java.io.IOException;
import p163cz.msebera.android.httpclient.C5899o;
import p163cz.msebera.android.httpclient.C5900p;
import p163cz.msebera.android.httpclient.HttpException;
import p163cz.msebera.android.httpclient.conn.p174r.C5648e;
import p163cz.msebera.android.httpclient.p177d0.C5695b;
import p163cz.msebera.android.httpclient.p186j0.C5875e;
import p163cz.msebera.android.httpclient.p187k0.C5886a;

/* renamed from: cz.msebera.android.httpclient.client.q.e */
/* compiled from: RequestClientConnControl */
public class C5611e implements C5900p {

    /* renamed from: a */
    public C5695b f14596a = new C5695b(C5611e.class);

    /* renamed from: a */
    public void mo28845a(C5899o oVar, C5875e eVar) throws HttpException, IOException {
        C5886a.m18894a(oVar, "HTTP request");
        if (oVar.getRequestLine().getMethod().equalsIgnoreCase("CONNECT")) {
            oVar.setHeader("Proxy-Connection", "Keep-Alive");
            return;
        }
        C5648e l = C5606a.m17839a(eVar).mo32982l();
        if (l == null) {
            this.f14596a.mo33166a("Connection route not set in the context");
            return;
        }
        if ((l.mo33055a() == 1 || l.mo33057b()) && !oVar.containsHeader("Connection")) {
            oVar.addHeader("Connection", "Keep-Alive");
        }
        if (l.mo33055a() == 2 && !l.mo33057b() && !oVar.containsHeader("Proxy-Connection")) {
            oVar.addHeader("Proxy-Connection", "Keep-Alive");
        }
    }
}
