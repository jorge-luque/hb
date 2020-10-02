package p163cz.msebera.android.httpclient.client.p170p;

import java.net.InetAddress;
import java.util.Collection;
import p163cz.msebera.android.httpclient.C5896l;
import p163cz.msebera.android.httpclient.client.p167m.C5587a;
import p163cz.msebera.android.httpclient.p183h0.C5759e;

@Deprecated
/* renamed from: cz.msebera.android.httpclient.client.p.a */
/* compiled from: HttpClientParamConfig */
public final class C5604a {
    /* renamed from: a */
    public static C5587a m17835a(C5759e eVar) {
        C5587a.C5588a f = C5587a.m17800f();
        f.mo32949d(eVar.mo33419b("http.socket.timeout", 0));
        f.mo32952f(eVar.mo33421b("http.connection.stalecheck", true));
        f.mo32937a(eVar.mo33419b("http.connection.timeout", 0));
        f.mo32948c(eVar.mo33421b("http.protocol.expect-continue", false));
        f.mo32938a((C5896l) eVar.mo33425b("http.route.default-proxy"));
        f.mo32940a((InetAddress) eVar.mo33425b("http.route.local-address"));
        f.mo32941a((Collection<String>) (Collection) eVar.mo33425b("http.auth.proxy-scheme-pref"));
        f.mo32945b((Collection<String>) (Collection) eVar.mo33425b("http.auth.target-scheme-pref"));
        f.mo32942a(eVar.mo33421b("http.protocol.handle-authentication", true));
        f.mo32946b(eVar.mo33421b("http.protocol.allow-circular-redirects", false));
        f.mo32944b((int) eVar.mo33415a("http.conn-manager.timeout", 0));
        f.mo32939a((String) eVar.mo33425b("http.protocol.cookie-policy"));
        f.mo32947c(eVar.mo33419b("http.protocol.max-redirects", 50));
        f.mo32950d(eVar.mo33421b("http.protocol.handle-redirects", true));
        f.mo32951e(!eVar.mo33421b("http.protocol.reject-relative-redirect", false));
        return f.mo32943a();
    }
}
