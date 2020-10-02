package p163cz.msebera.android.httpclient.conn.p175s;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import p163cz.msebera.android.httpclient.conn.ConnectTimeoutException;
import p163cz.msebera.android.httpclient.p183h0.C5759e;

@Deprecated
/* renamed from: cz.msebera.android.httpclient.conn.s.g */
/* compiled from: SchemeLayeredSocketFactoryAdaptor2 */
class C5658g implements C5657f {

    /* renamed from: a */
    private final C5653b f14659a;

    C5658g(C5653b bVar) {
        this.f14659a = bVar;
    }

    /* renamed from: a */
    public Socket mo33080a(C5759e eVar) throws IOException {
        return this.f14659a.mo33080a(eVar);
    }

    /* renamed from: a */
    public Socket mo33082a(Socket socket, InetSocketAddress inetSocketAddress, InetSocketAddress inetSocketAddress2, C5759e eVar) throws IOException, UnknownHostException, ConnectTimeoutException {
        return this.f14659a.mo33082a(socket, inetSocketAddress, inetSocketAddress2, eVar);
    }

    /* renamed from: a */
    public boolean mo33083a(Socket socket) throws IllegalArgumentException {
        return this.f14659a.mo33083a(socket);
    }

    /* renamed from: a */
    public Socket mo33092a(Socket socket, String str, int i, C5759e eVar) throws IOException, UnknownHostException {
        return this.f14659a.mo33079b(socket, str, i, true);
    }
}
