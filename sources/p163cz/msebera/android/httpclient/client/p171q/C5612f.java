package p163cz.msebera.android.httpclient.client.p171q;

import java.io.IOException;
import java.util.Collection;
import p163cz.msebera.android.httpclient.C5691d;
import p163cz.msebera.android.httpclient.C5899o;
import p163cz.msebera.android.httpclient.C5900p;
import p163cz.msebera.android.httpclient.HttpException;
import p163cz.msebera.android.httpclient.p186j0.C5875e;
import p163cz.msebera.android.httpclient.p187k0.C5886a;

/* renamed from: cz.msebera.android.httpclient.client.q.f */
/* compiled from: RequestDefaultHeaders */
public class C5612f implements C5900p {

    /* renamed from: a */
    private final Collection<? extends C5691d> f14597a;

    public C5612f(Collection<? extends C5691d> collection) {
        this.f14597a = collection;
    }

    /* renamed from: a */
    public void mo28845a(C5899o oVar, C5875e eVar) throws HttpException, IOException {
        C5886a.m18894a(oVar, "HTTP request");
        if (!oVar.getRequestLine().getMethod().equalsIgnoreCase("CONNECT")) {
            Collection<? extends C5691d> collection = (Collection) oVar.getParams().mo33425b("http.default-headers");
            if (collection == null) {
                collection = this.f14597a;
            }
            if (collection != null) {
                for (C5691d a : collection) {
                    oVar.mo33293a(a);
                }
            }
        }
    }

    public C5612f() {
        this((Collection<? extends C5691d>) null);
    }
}
