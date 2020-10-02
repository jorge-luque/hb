package p163cz.msebera.android.httpclient.p186j0;

import java.io.IOException;
import p118io.fabric.sdk.android.p200m.p202b.C6078a;
import p163cz.msebera.android.httpclient.C5899o;
import p163cz.msebera.android.httpclient.C5900p;
import p163cz.msebera.android.httpclient.HttpException;
import p163cz.msebera.android.httpclient.p183h0.C5759e;
import p163cz.msebera.android.httpclient.p187k0.C5886a;

/* renamed from: cz.msebera.android.httpclient.j0.m */
/* compiled from: RequestUserAgent */
public class C5883m implements C5900p {

    /* renamed from: a */
    private final String f15113a;

    public C5883m(String str) {
        this.f15113a = str;
    }

    /* renamed from: a */
    public void mo28845a(C5899o oVar, C5875e eVar) throws HttpException, IOException {
        C5886a.m18894a(oVar, "HTTP request");
        if (!oVar.containsHeader(C6078a.HEADER_USER_AGENT)) {
            String str = null;
            C5759e params = oVar.getParams();
            if (params != null) {
                str = (String) params.mo33425b("http.useragent");
            }
            if (str == null) {
                str = this.f15113a;
            }
            if (str != null) {
                oVar.addHeader(C6078a.HEADER_USER_AGENT, str);
            }
        }
    }

    public C5883m() {
        this((String) null);
    }
}
