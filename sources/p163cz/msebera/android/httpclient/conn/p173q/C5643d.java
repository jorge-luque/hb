package p163cz.msebera.android.httpclient.conn.p173q;

import java.net.InetAddress;
import p163cz.msebera.android.httpclient.C5896l;
import p163cz.msebera.android.httpclient.conn.p174r.C5645b;
import p163cz.msebera.android.httpclient.p183h0.C5759e;
import p163cz.msebera.android.httpclient.p187k0.C5886a;

@Deprecated
/* renamed from: cz.msebera.android.httpclient.conn.q.d */
/* compiled from: ConnRouteParams */
public class C5643d {

    /* renamed from: a */
    public static final C5896l f14634a;

    /* renamed from: b */
    public static final C5645b f14635b;

    static {
        C5896l lVar = new C5896l("127.0.0.255", 0, "no-host");
        f14634a = lVar;
        f14635b = new C5645b(lVar);
    }

    /* renamed from: a */
    public static C5896l m17968a(C5759e eVar) {
        C5886a.m18894a(eVar, "Parameters");
        C5896l lVar = (C5896l) eVar.mo33425b("http.route.default-proxy");
        if (lVar == null || !f14634a.equals(lVar)) {
            return lVar;
        }
        return null;
    }

    /* renamed from: b */
    public static C5645b m17969b(C5759e eVar) {
        C5886a.m18894a(eVar, "Parameters");
        C5645b bVar = (C5645b) eVar.mo33425b("http.route.forced-route");
        if (bVar == null || !f14635b.equals(bVar)) {
            return bVar;
        }
        return null;
    }

    /* renamed from: c */
    public static InetAddress m17970c(C5759e eVar) {
        C5886a.m18894a(eVar, "Parameters");
        return (InetAddress) eVar.mo33425b("http.route.local-address");
    }
}
