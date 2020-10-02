package p163cz.msebera.android.httpclient.client.p171q;

import java.io.IOException;
import p163cz.msebera.android.httpclient.C5899o;
import p163cz.msebera.android.httpclient.HttpException;
import p163cz.msebera.android.httpclient.auth.C5555h;
import p163cz.msebera.android.httpclient.conn.C5634l;
import p163cz.msebera.android.httpclient.p177d0.C5695b;
import p163cz.msebera.android.httpclient.p186j0.C5875e;
import p163cz.msebera.android.httpclient.p187k0.C5886a;

@Deprecated
/* renamed from: cz.msebera.android.httpclient.client.q.g */
/* compiled from: RequestProxyAuthentication */
public class C5613g extends C5609d {
    /* renamed from: a */
    public void mo28845a(C5899o oVar, C5875e eVar) throws HttpException, IOException {
        C5886a.m18894a(oVar, "HTTP request");
        C5886a.m18894a(eVar, "HTTP context");
        if (!oVar.containsHeader("Proxy-Authorization")) {
            C5634l lVar = (C5634l) eVar.mo33533a("http.connection");
            if (lVar == null) {
                this.f14594a.mo33166a("HTTP connection not set in the context");
            } else if (!lVar.mo33032D().mo33057b()) {
                C5555h hVar = (C5555h) eVar.mo33533a("http.auth.proxy-scope");
                if (hVar == null) {
                    this.f14594a.mo33166a("Proxy auth state not set in the context");
                    return;
                }
                if (this.f14594a.mo33168a()) {
                    C5695b bVar = this.f14594a;
                    bVar.mo33166a("Proxy auth state: " + hVar.mo32860d());
                }
                mo32986a(hVar, oVar, eVar);
            }
        }
    }
}
