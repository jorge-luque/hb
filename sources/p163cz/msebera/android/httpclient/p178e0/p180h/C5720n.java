package p163cz.msebera.android.httpclient.p178e0.p180h;

import com.ogury.p159cm.OguryChoiceManager;
import java.io.IOException;
import java.net.Socket;
import p163cz.msebera.android.httpclient.p181f0.C5724b;
import p163cz.msebera.android.httpclient.p183h0.C5759e;
import p163cz.msebera.android.httpclient.p187k0.C5886a;

@Deprecated
/* renamed from: cz.msebera.android.httpclient.e0.h.n */
/* compiled from: SocketInputBuffer */
public class C5720n extends C5709c implements C5724b {

    /* renamed from: o */
    private final Socket f14793o;

    /* renamed from: p */
    private boolean f14794p = false;

    public C5720n(Socket socket, int i, C5759e eVar) throws IOException {
        C5886a.m18894a(socket, "Socket");
        this.f14793o = socket;
        i = i < 0 ? socket.getReceiveBufferSize() : i;
        mo33225a(socket.getInputStream(), i < 1024 ? OguryChoiceManager.TcfV2.Purpose.DEVELOP_AND_IMPROVE_PRODUCTS : i, eVar);
    }

    /* JADX INFO: finally extract failed */
    /* renamed from: a */
    public boolean mo33287a(int i) throws IOException {
        boolean e = mo33228e();
        if (e) {
            return e;
        }
        int soTimeout = this.f14793o.getSoTimeout();
        try {
            this.f14793o.setSoTimeout(i);
            mo33227d();
            boolean e2 = mo33228e();
            this.f14793o.setSoTimeout(soTimeout);
            return e2;
        } catch (Throwable th) {
            this.f14793o.setSoTimeout(soTimeout);
            throw th;
        }
    }

    /* renamed from: b */
    public boolean mo33288b() {
        return this.f14794p;
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public int mo33227d() throws IOException {
        int d = super.mo33227d();
        this.f14794p = d == -1;
        return d;
    }
}
