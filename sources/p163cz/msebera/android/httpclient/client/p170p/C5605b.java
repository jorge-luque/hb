package p163cz.msebera.android.httpclient.client.p170p;

import p163cz.msebera.android.httpclient.p183h0.C5757c;
import p163cz.msebera.android.httpclient.p183h0.C5759e;
import p163cz.msebera.android.httpclient.p187k0.C5886a;

@Deprecated
/* renamed from: cz.msebera.android.httpclient.client.p.b */
/* compiled from: HttpClientParams */
public class C5605b {
    /* renamed from: a */
    public static long m17836a(C5759e eVar) {
        C5886a.m18894a(eVar, "HTTP parameters");
        Long l = (Long) eVar.mo33425b("http.conn-manager.timeout");
        if (l != null) {
            return l.longValue();
        }
        return (long) C5757c.m18337a(eVar);
    }

    /* renamed from: b */
    public static boolean m17837b(C5759e eVar) {
        C5886a.m18894a(eVar, "HTTP parameters");
        return eVar.mo33421b("http.protocol.handle-authentication", true);
    }

    /* renamed from: c */
    public static boolean m17838c(C5759e eVar) {
        C5886a.m18894a(eVar, "HTTP parameters");
        return eVar.mo33421b("http.protocol.handle-redirects", true);
    }
}
