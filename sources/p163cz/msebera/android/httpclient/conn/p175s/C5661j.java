package p163cz.msebera.android.httpclient.conn.p175s;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import p163cz.msebera.android.httpclient.conn.ConnectTimeoutException;
import p163cz.msebera.android.httpclient.p183h0.C5759e;

@Deprecated
/* renamed from: cz.msebera.android.httpclient.conn.s.j */
/* compiled from: SchemeSocketFactory */
public interface C5661j {
    /* renamed from: a */
    Socket mo33080a(C5759e eVar) throws IOException;

    /* renamed from: a */
    Socket mo33082a(Socket socket, InetSocketAddress inetSocketAddress, InetSocketAddress inetSocketAddress2, C5759e eVar) throws IOException, UnknownHostException, ConnectTimeoutException;

    /* renamed from: a */
    boolean mo33083a(Socket socket) throws IllegalArgumentException;
}
