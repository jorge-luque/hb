package p163cz.msebera.android.httpclient.conn.p175s;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import p163cz.msebera.android.httpclient.conn.ConnectTimeoutException;
import p163cz.msebera.android.httpclient.p183h0.C5757c;
import p163cz.msebera.android.httpclient.p183h0.C5759e;
import p163cz.msebera.android.httpclient.p187k0.C5886a;

@Deprecated
/* renamed from: cz.msebera.android.httpclient.conn.s.d */
/* compiled from: PlainSocketFactory */
public class C5655d implements C5663l, C5661j {

    /* renamed from: a */
    private final C5652a f14653a = null;

    /* renamed from: b */
    public static C5655d m18013b() {
        return new C5655d();
    }

    /* renamed from: a */
    public Socket mo33080a(C5759e eVar) {
        return new Socket();
    }

    /* renamed from: a */
    public final boolean mo33083a(Socket socket) {
        return false;
    }

    /* renamed from: a */
    public Socket mo28913a() {
        return new Socket();
    }

    /* renamed from: a */
    public Socket mo33082a(Socket socket, InetSocketAddress inetSocketAddress, InetSocketAddress inetSocketAddress2, C5759e eVar) throws IOException, ConnectTimeoutException {
        C5886a.m18894a(inetSocketAddress, "Remote address");
        C5886a.m18894a(eVar, "HTTP parameters");
        if (socket == null) {
            socket = mo28913a();
        }
        if (inetSocketAddress2 != null) {
            socket.setReuseAddress(C5757c.m18343c(eVar));
            socket.bind(inetSocketAddress2);
        }
        int a = C5757c.m18337a(eVar);
        try {
            socket.setSoTimeout(C5757c.m18344d(eVar));
            socket.connect(inetSocketAddress, a);
            return socket;
        } catch (SocketTimeoutException unused) {
            throw new ConnectTimeoutException("Connect to " + inetSocketAddress + " timed out");
        }
    }

    @Deprecated
    /* renamed from: a */
    public Socket mo33081a(Socket socket, String str, int i, InetAddress inetAddress, int i2, C5759e eVar) throws IOException, UnknownHostException, ConnectTimeoutException {
        InetSocketAddress inetSocketAddress;
        InetAddress inetAddress2;
        if (inetAddress != null || i2 > 0) {
            if (i2 <= 0) {
                i2 = 0;
            }
            inetSocketAddress = new InetSocketAddress(inetAddress, i2);
        } else {
            inetSocketAddress = null;
        }
        C5652a aVar = this.f14653a;
        if (aVar != null) {
            inetAddress2 = aVar.mo33078a(str);
        } else {
            inetAddress2 = InetAddress.getByName(str);
        }
        return mo33082a(socket, new InetSocketAddress(inetAddress2, i), inetSocketAddress, eVar);
    }
}
