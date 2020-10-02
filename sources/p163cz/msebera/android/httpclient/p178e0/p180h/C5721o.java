package p163cz.msebera.android.httpclient.p178e0.p180h;

import com.ogury.p159cm.OguryChoiceManager;
import java.io.IOException;
import java.net.Socket;
import p163cz.msebera.android.httpclient.p183h0.C5759e;
import p163cz.msebera.android.httpclient.p187k0.C5886a;

@Deprecated
/* renamed from: cz.msebera.android.httpclient.e0.h.o */
/* compiled from: SocketOutputBuffer */
public class C5721o extends C5710d {
    public C5721o(Socket socket, int i, C5759e eVar) throws IOException {
        C5886a.m18894a(socket, "Socket");
        i = i < 0 ? socket.getSendBufferSize() : i;
        mo33235a(socket.getOutputStream(), i < 1024 ? OguryChoiceManager.TcfV2.Purpose.DEVELOP_AND_IMPROVE_PRODUCTS : i, eVar);
    }
}
