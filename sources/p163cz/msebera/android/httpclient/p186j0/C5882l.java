package p163cz.msebera.android.httpclient.p186j0;

import java.io.IOException;
import java.net.InetAddress;
import p163cz.msebera.android.httpclient.C5762i;
import p163cz.msebera.android.httpclient.C5896l;
import p163cz.msebera.android.httpclient.C5897m;
import p163cz.msebera.android.httpclient.C5899o;
import p163cz.msebera.android.httpclient.C5900p;
import p163cz.msebera.android.httpclient.C5905t;
import p163cz.msebera.android.httpclient.C5907v;
import p163cz.msebera.android.httpclient.HttpException;
import p163cz.msebera.android.httpclient.ProtocolException;
import p163cz.msebera.android.httpclient.p187k0.C5886a;

/* renamed from: cz.msebera.android.httpclient.j0.l */
/* compiled from: RequestTargetHost */
public class C5882l implements C5900p {
    /* renamed from: a */
    public void mo28845a(C5899o oVar, C5875e eVar) throws HttpException, IOException {
        C5886a.m18894a(oVar, "HTTP request");
        C5876f a = C5876f.m18868a(eVar);
        C5907v protocolVersion = oVar.getRequestLine().getProtocolVersion();
        if ((!oVar.getRequestLine().getMethod().equalsIgnoreCase("CONNECT") || !protocolVersion.mo33701c(C5905t.f15129e)) && !oVar.containsHeader("Host")) {
            C5896l c = a.mo33644c();
            if (c == null) {
                C5762i a2 = a.mo33641a();
                if (a2 instanceof C5897m) {
                    C5897m mVar = (C5897m) a2;
                    InetAddress remoteAddress = mVar.getRemoteAddress();
                    int O = mVar.mo33204O();
                    if (remoteAddress != null) {
                        c = new C5896l(remoteAddress.getHostName(), O);
                    }
                }
                if (c == null) {
                    if (!protocolVersion.mo33701c(C5905t.f15129e)) {
                        throw new ProtocolException("Target host missing");
                    }
                    return;
                }
            }
            oVar.addHeader("Host", c.mo33689e());
        }
    }
}
