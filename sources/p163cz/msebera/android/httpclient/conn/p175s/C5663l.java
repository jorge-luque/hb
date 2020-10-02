package p163cz.msebera.android.httpclient.conn.p175s;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import p163cz.msebera.android.httpclient.conn.ConnectTimeoutException;
import p163cz.msebera.android.httpclient.p183h0.C5759e;

@Deprecated
/* renamed from: cz.msebera.android.httpclient.conn.s.l */
/* compiled from: SocketFactory */
public interface C5663l {
    /* renamed from: a */
    Socket mo28913a() throws IOException;

    /* renamed from: a */
    Socket mo33081a(Socket socket, String str, int i, InetAddress inetAddress, int i2, C5759e eVar) throws IOException, UnknownHostException, ConnectTimeoutException;

    /* renamed from: a */
    boolean mo33083a(Socket socket) throws IllegalArgumentException;
}
