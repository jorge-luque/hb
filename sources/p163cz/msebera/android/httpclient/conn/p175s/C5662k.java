package p163cz.msebera.android.httpclient.conn.p175s;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import p163cz.msebera.android.httpclient.conn.ConnectTimeoutException;
import p163cz.msebera.android.httpclient.p183h0.C5759e;

@Deprecated
/* renamed from: cz.msebera.android.httpclient.conn.s.k */
/* compiled from: SchemeSocketFactoryAdaptor */
class C5662k implements C5661j {

    /* renamed from: a */
    private final C5663l f14662a;

    C5662k(C5663l lVar) {
        this.f14662a = lVar;
    }

    /* renamed from: a */
    public Socket mo33082a(Socket socket, InetSocketAddress inetSocketAddress, InetSocketAddress inetSocketAddress2, C5759e eVar) throws IOException, UnknownHostException, ConnectTimeoutException {
        int i;
        InetAddress inetAddress;
        String hostName = inetSocketAddress.getHostName();
        int port = inetSocketAddress.getPort();
        if (inetSocketAddress2 != null) {
            inetAddress = inetSocketAddress2.getAddress();
            i = inetSocketAddress2.getPort();
        } else {
            inetAddress = null;
            i = 0;
        }
        return this.f14662a.mo33081a(socket, hostName, port, inetAddress, i, eVar);
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (obj instanceof C5662k) {
            return this.f14662a.equals(((C5662k) obj).f14662a);
        }
        return this.f14662a.equals(obj);
    }

    public int hashCode() {
        return this.f14662a.hashCode();
    }

    /* renamed from: a */
    public Socket mo33080a(C5759e eVar) throws IOException {
        return this.f14662a.mo28913a();
    }

    /* renamed from: a */
    public boolean mo33083a(Socket socket) throws IllegalArgumentException {
        return this.f14662a.mo33083a(socket);
    }
}
