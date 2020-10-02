package p163cz.msebera.android.httpclient.p186j0;

import java.io.IOException;
import p163cz.msebera.android.httpclient.C5870j;
import p163cz.msebera.android.httpclient.C5885k;
import p163cz.msebera.android.httpclient.C5899o;
import p163cz.msebera.android.httpclient.C5900p;
import p163cz.msebera.android.httpclient.C5905t;
import p163cz.msebera.android.httpclient.C5907v;
import p163cz.msebera.android.httpclient.HttpException;
import p163cz.msebera.android.httpclient.p187k0.C5886a;

/* renamed from: cz.msebera.android.httpclient.j0.k */
/* compiled from: RequestExpectContinue */
public class C5881k implements C5900p {

    /* renamed from: a */
    private final boolean f15112a;

    @Deprecated
    public C5881k() {
        this(false);
    }

    /* renamed from: a */
    public void mo28845a(C5899o oVar, C5875e eVar) throws HttpException, IOException {
        C5886a.m18894a(oVar, "HTTP request");
        if (!oVar.containsHeader("Expect") && (oVar instanceof C5885k)) {
            C5907v protocolVersion = oVar.getRequestLine().getProtocolVersion();
            C5870j entity = ((C5885k) oVar).getEntity();
            if (entity != null && entity.mo28849h() != 0 && !protocolVersion.mo33701c(C5905t.f15129e) && oVar.getParams().mo33421b("http.protocol.expect-continue", this.f15112a)) {
                oVar.addHeader("Expect", "100-continue");
            }
        }
    }

    public C5881k(boolean z) {
        this.f15112a = z;
    }
}
