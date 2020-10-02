package p163cz.msebera.android.httpclient.p178e0;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketException;
import p163cz.msebera.android.httpclient.C5897m;
import p163cz.msebera.android.httpclient.p178e0.p180h.C5720n;
import p163cz.msebera.android.httpclient.p178e0.p180h.C5721o;
import p163cz.msebera.android.httpclient.p181f0.C5728f;
import p163cz.msebera.android.httpclient.p181f0.C5729g;
import p163cz.msebera.android.httpclient.p183h0.C5759e;
import p163cz.msebera.android.httpclient.p187k0.C5886a;
import p163cz.msebera.android.httpclient.p187k0.C5887b;

@Deprecated
/* renamed from: cz.msebera.android.httpclient.e0.f */
/* compiled from: SocketHttpClientConnection */
public class C5702f extends C5697a implements C5897m {

    /* renamed from: i */
    private volatile boolean f14726i;

    /* renamed from: j */
    private volatile Socket f14727j = null;

    /* renamed from: O */
    public int mo33204O() {
        if (this.f14727j != null) {
            return this.f14727j.getPort();
        }
        return -1;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public C5728f mo33205a(Socket socket, int i, C5759e eVar) throws IOException {
        return new C5720n(socket, i, eVar);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public C5729g mo33207b(Socket socket, int i, C5759e eVar) throws IOException {
        return new C5721o(socket, i, eVar);
    }

    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:8:0x0010 */
    /* JADX WARNING: Removed duplicated region for block: B:11:? A[ExcHandler: UnsupportedOperationException (unused java.lang.UnsupportedOperationException), SYNTHETIC, Splitter:B:8:0x0010] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void close() throws java.io.IOException {
        /*
            r2 = this;
            boolean r0 = r2.f14726i
            if (r0 != 0) goto L_0x0005
            return
        L_0x0005:
            r0 = 0
            r2.f14726i = r0
            java.net.Socket r0 = r2.f14727j
            r2.mo33197w()     // Catch:{ all -> 0x0017 }
            r0.shutdownOutput()     // Catch:{ IOException -> 0x0010 }
        L_0x0010:
            r0.shutdownInput()     // Catch:{ UnsupportedOperationException -> 0x0013, UnsupportedOperationException -> 0x0013 }
        L_0x0013:
            r0.close()
            return
        L_0x0017:
            r1 = move-exception
            r0.close()
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: p163cz.msebera.android.httpclient.p178e0.C5702f.close():void");
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public void mo33191d() {
        C5887b.m18902a(this.f14726i, "Connection is not open");
    }

    /* renamed from: f */
    public void mo33209f(int i) {
        mo33191d();
        if (this.f14727j != null) {
            try {
                this.f14727j.setSoTimeout(i);
            } catch (SocketException unused) {
            }
        }
    }

    public InetAddress getRemoteAddress() {
        if (this.f14727j != null) {
            return this.f14727j.getInetAddress();
        }
        return null;
    }

    public boolean isOpen() {
        return this.f14726i;
    }

    public void shutdown() throws IOException {
        this.f14726i = false;
        Socket socket = this.f14727j;
        if (socket != null) {
            socket.close();
        }
    }

    public String toString() {
        if (this.f14727j == null) {
            return super.toString();
        }
        StringBuilder sb = new StringBuilder();
        SocketAddress remoteSocketAddress = this.f14727j.getRemoteSocketAddress();
        SocketAddress localSocketAddress = this.f14727j.getLocalSocketAddress();
        if (!(remoteSocketAddress == null || localSocketAddress == null)) {
            m18164a(sb, localSocketAddress);
            sb.append("<->");
            m18164a(sb, remoteSocketAddress);
        }
        return sb.toString();
    }

    /* access modifiers changed from: protected */
    /* renamed from: y */
    public void mo33214y() {
        C5887b.m18902a(!this.f14726i, "Connection is already open");
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo33206a(Socket socket, C5759e eVar) throws IOException {
        C5886a.m18894a(socket, "Socket");
        C5886a.m18894a(eVar, "HTTP parameters");
        this.f14727j = socket;
        int b = eVar.mo33419b("http.socket.buffer-size", -1);
        mo33187a(mo33205a(socket, b, eVar), mo33207b(socket, b, eVar), eVar);
        this.f14726i = true;
    }

    /* renamed from: a */
    private static void m18164a(StringBuilder sb, SocketAddress socketAddress) {
        Object obj;
        if (socketAddress instanceof InetSocketAddress) {
            InetSocketAddress inetSocketAddress = (InetSocketAddress) socketAddress;
            if (inetSocketAddress.getAddress() != null) {
                obj = inetSocketAddress.getAddress().getHostAddress();
            } else {
                obj = inetSocketAddress.getAddress();
            }
            sb.append(obj);
            sb.append(':');
            sb.append(inetSocketAddress.getPort());
            return;
        }
        sb.append(socketAddress);
    }
}
