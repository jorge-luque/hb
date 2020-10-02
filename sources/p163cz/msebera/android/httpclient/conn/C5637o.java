package p163cz.msebera.android.httpclient.conn;

import java.io.IOException;
import java.net.Socket;
import p163cz.msebera.android.httpclient.C5754h;
import p163cz.msebera.android.httpclient.C5896l;
import p163cz.msebera.android.httpclient.C5897m;
import p163cz.msebera.android.httpclient.p183h0.C5759e;

@Deprecated
/* renamed from: cz.msebera.android.httpclient.conn.o */
/* compiled from: OperatedClientConnection */
public interface C5637o extends C5754h, C5897m {
    /* renamed from: B */
    boolean mo33041B();

    /* renamed from: N */
    Socket mo33042N();

    /* renamed from: a */
    void mo33043a(Socket socket, C5896l lVar) throws IOException;

    /* renamed from: a */
    void mo33044a(Socket socket, C5896l lVar, boolean z, C5759e eVar) throws IOException;

    /* renamed from: b */
    void mo33045b(boolean z, C5759e eVar) throws IOException;
}
