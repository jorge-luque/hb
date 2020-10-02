package admost.adserver.videocache;

import java.io.IOException;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.SocketAddress;
import java.net.URI;
import java.util.Arrays;
import java.util.List;

/* renamed from: admost.adserver.videocache.i */
/* compiled from: IgnoreHostProxySelector */
class C0073i extends ProxySelector {

    /* renamed from: d */
    private static final List<Proxy> f215d = Arrays.asList(new Proxy[]{Proxy.NO_PROXY});

    /* renamed from: a */
    private final ProxySelector f216a;

    /* renamed from: b */
    private final String f217b;

    /* renamed from: c */
    private final int f218c;

    C0073i(ProxySelector proxySelector, String str, int i) {
        C0077k.m231a(proxySelector);
        this.f216a = proxySelector;
        C0077k.m231a(str);
        this.f217b = str;
        this.f218c = i;
    }

    /* renamed from: a */
    static void m223a(String str, int i) {
        ProxySelector.setDefault(new C0073i(ProxySelector.getDefault(), str, i));
    }

    public void connectFailed(URI uri, SocketAddress socketAddress, IOException iOException) {
        this.f216a.connectFailed(uri, socketAddress, iOException);
    }

    public List<Proxy> select(URI uri) {
        return this.f217b.equals(uri.getHost()) && this.f218c == uri.getPort() ? f215d : this.f216a.select(uri);
    }
}
