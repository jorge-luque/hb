package p163cz.msebera.android.httpclient.conn.p175s;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import p163cz.msebera.android.httpclient.p183h0.C5759e;

@Deprecated
/* renamed from: cz.msebera.android.httpclient.conn.s.h */
/* compiled from: SchemeLayeredSocketFactoryAdaptor */
class C5659h extends C5662k implements C5657f {

    /* renamed from: b */
    private final C5654c f14660b;

    C5659h(C5654c cVar) {
        super(cVar);
        this.f14660b = cVar;
    }

    /* renamed from: a */
    public Socket mo33092a(Socket socket, String str, int i, C5759e eVar) throws IOException, UnknownHostException {
        return this.f14660b.mo28914a(socket, str, i, true);
    }
}
