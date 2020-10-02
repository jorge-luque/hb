package p163cz.msebera.android.httpclient.conn.ssl;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import p163cz.msebera.android.httpclient.C5896l;
import p163cz.msebera.android.httpclient.conn.C5633k;
import p163cz.msebera.android.httpclient.conn.ConnectTimeoutException;
import p163cz.msebera.android.httpclient.conn.p175s.C5652a;
import p163cz.msebera.android.httpclient.conn.p175s.C5653b;
import p163cz.msebera.android.httpclient.conn.p175s.C5654c;
import p163cz.msebera.android.httpclient.conn.p175s.C5657f;
import p163cz.msebera.android.httpclient.p183h0.C5757c;
import p163cz.msebera.android.httpclient.p183h0.C5759e;
import p163cz.msebera.android.httpclient.p186j0.C5875e;
import p163cz.msebera.android.httpclient.p187k0.C5886a;
import p163cz.msebera.android.httpclient.p187k0.C5887b;

@Deprecated
/* renamed from: cz.msebera.android.httpclient.conn.ssl.h */
/* compiled from: SSLSocketFactory */
public class C5672h implements C5657f, C5653b, C5654c {

    /* renamed from: f */
    public static final C5675k f14678f = new C5665b();

    /* renamed from: g */
    public static final C5675k f14679g = new C5666c();

    /* renamed from: a */
    private final SSLSocketFactory f14680a;

    /* renamed from: b */
    private final C5652a f14681b;

    /* renamed from: c */
    private volatile C5675k f14682c;

    /* renamed from: d */
    private final String[] f14683d;

    /* renamed from: e */
    private final String[] f14684e;

    static {
        new C5673i();
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public C5672h(java.security.KeyStore r2) throws java.security.NoSuchAlgorithmException, java.security.KeyManagementException, java.security.KeyStoreException, java.security.UnrecoverableKeyException {
        /*
            r1 = this;
            cz.msebera.android.httpclient.conn.ssl.f r0 = p163cz.msebera.android.httpclient.conn.ssl.C5671g.m18062b()
            r0.mo33107a(r2)
            javax.net.ssl.SSLContext r2 = r0.mo33109a()
            cz.msebera.android.httpclient.conn.ssl.k r0 = f14679g
            r1.<init>(r2, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p163cz.msebera.android.httpclient.conn.ssl.C5672h.<init>(java.security.KeyStore):void");
    }

    /* renamed from: b */
    public static C5672h m18064b() throws SSLInitializationException {
        return new C5672h(C5671g.m18061a(), f14679g);
    }

    /* renamed from: a */
    public Socket mo33080a(C5759e eVar) throws IOException {
        return mo33114a((C5875e) null);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo33117a(SSLSocket sSLSocket) throws IOException {
    }

    /* renamed from: a */
    public Socket mo28913a() throws IOException {
        return mo33114a((C5875e) null);
    }

    /* renamed from: a */
    public Socket mo33082a(Socket socket, InetSocketAddress inetSocketAddress, InetSocketAddress inetSocketAddress2, C5759e eVar) throws IOException, UnknownHostException, ConnectTimeoutException {
        C5896l lVar;
        C5886a.m18894a(inetSocketAddress, "Remote address");
        C5886a.m18894a(eVar, "HTTP parameters");
        if (inetSocketAddress instanceof C5633k) {
            lVar = ((C5633k) inetSocketAddress).mo33030a();
        } else {
            lVar = new C5896l(inetSocketAddress.getHostName(), inetSocketAddress.getPort(), "https");
        }
        C5896l lVar2 = lVar;
        int d = C5757c.m18344d(eVar);
        int a = C5757c.m18337a(eVar);
        socket.setSoTimeout(d);
        return mo33113a(a, socket, lVar2, inetSocketAddress, inetSocketAddress2, (C5875e) null);
    }

    /* renamed from: b */
    public Socket mo33079b(Socket socket, String str, int i, boolean z) throws IOException, UnknownHostException {
        return mo33115a(socket, str, i, (C5875e) null);
    }

    /* renamed from: b */
    private void m18065b(SSLSocket sSLSocket) throws IOException {
        String[] strArr = this.f14683d;
        if (strArr != null) {
            sSLSocket.setEnabledProtocols(strArr);
        }
        String[] strArr2 = this.f14684e;
        if (strArr2 != null) {
            sSLSocket.setEnabledCipherSuites(strArr2);
        }
        mo33117a(sSLSocket);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public C5672h(SSLContext sSLContext, C5675k kVar) {
        this(sSLContext.getSocketFactory(), (String[]) null, (String[]) null, kVar);
        C5886a.m18894a(sSLContext, "SSL context");
    }

    public C5672h(SSLSocketFactory sSLSocketFactory, String[] strArr, String[] strArr2, C5675k kVar) {
        C5886a.m18894a(sSLSocketFactory, "SSL socket factory");
        this.f14680a = sSLSocketFactory;
        this.f14683d = strArr;
        this.f14684e = strArr2;
        this.f14682c = kVar == null ? f14679g : kVar;
        this.f14681b = null;
    }

    /* renamed from: a */
    public boolean mo33083a(Socket socket) throws IllegalArgumentException {
        C5886a.m18894a(socket, "Socket");
        C5887b.m18902a(socket instanceof SSLSocket, "Socket not created by this factory");
        C5887b.m18902a(!socket.isClosed(), "Socket is closed");
        return true;
    }

    /* renamed from: a */
    public Socket mo33092a(Socket socket, String str, int i, C5759e eVar) throws IOException, UnknownHostException {
        return mo33115a(socket, str, i, (C5875e) null);
    }

    /* renamed from: a */
    public void mo33116a(C5675k kVar) {
        C5886a.m18894a(kVar, "Hostname verifier");
        this.f14682c = kVar;
    }

    /* renamed from: a */
    public Socket mo33081a(Socket socket, String str, int i, InetAddress inetAddress, int i2, C5759e eVar) throws IOException, UnknownHostException, ConnectTimeoutException {
        InetAddress inetAddress2;
        C5652a aVar = this.f14681b;
        if (aVar != null) {
            inetAddress2 = aVar.mo33078a(str);
        } else {
            inetAddress2 = InetAddress.getByName(str);
        }
        InetSocketAddress inetSocketAddress = null;
        if (inetAddress != null || i2 > 0) {
            if (i2 <= 0) {
                i2 = 0;
            }
            inetSocketAddress = new InetSocketAddress(inetAddress, i2);
        }
        return mo33082a(socket, (InetSocketAddress) new C5633k(new C5896l(str, i), inetAddress2, i), inetSocketAddress, eVar);
    }

    /* renamed from: a */
    public Socket mo28914a(Socket socket, String str, int i, boolean z) throws IOException, UnknownHostException {
        return mo33079b(socket, str, i, z);
    }

    /* renamed from: a */
    public Socket mo33114a(C5875e eVar) throws IOException {
        SSLSocket sSLSocket = (SSLSocket) this.f14680a.createSocket();
        m18065b(sSLSocket);
        return sSLSocket;
    }

    /* renamed from: a */
    public Socket mo33113a(int i, Socket socket, C5896l lVar, InetSocketAddress inetSocketAddress, InetSocketAddress inetSocketAddress2, C5875e eVar) throws IOException {
        C5886a.m18894a(lVar, "HTTP host");
        C5886a.m18894a(inetSocketAddress, "Remote address");
        if (socket == null) {
            socket = mo33114a(eVar);
        }
        if (inetSocketAddress2 != null) {
            socket.bind(inetSocketAddress2);
        }
        try {
            socket.connect(inetSocketAddress, i);
            if (!(socket instanceof SSLSocket)) {
                return mo33115a(socket, lVar.mo33685b(), inetSocketAddress.getPort(), eVar);
            }
            SSLSocket sSLSocket = (SSLSocket) socket;
            sSLSocket.startHandshake();
            m18063a(sSLSocket, lVar.mo33685b());
            return socket;
        } catch (IOException e) {
            try {
                socket.close();
            } catch (IOException unused) {
            }
            throw e;
        }
    }

    /* renamed from: a */
    public Socket mo33115a(Socket socket, String str, int i, C5875e eVar) throws IOException {
        SSLSocket sSLSocket = (SSLSocket) this.f14680a.createSocket(socket, str, i, true);
        m18065b(sSLSocket);
        sSLSocket.startHandshake();
        m18063a(sSLSocket, str);
        return sSLSocket;
    }

    /* renamed from: a */
    private void m18063a(SSLSocket sSLSocket, String str) throws IOException {
        try {
            this.f14682c.verify(str, sSLSocket);
        } catch (IOException e) {
            try {
                sSLSocket.close();
            } catch (Exception unused) {
            }
            throw e;
        }
    }
}
