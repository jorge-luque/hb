package okhttp3.internal.connection;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.UnknownServiceException;
import java.security.cert.CertificateException;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLProtocolException;
import javax.net.ssl.SSLSocket;
import p113i.C3528k;
import p113i.p114e0.C3499a;

/* renamed from: okhttp3.internal.connection.b */
/* compiled from: ConnectionSpecSelector */
public final class C6609b {

    /* renamed from: a */
    private final List<C3528k> f17284a;

    /* renamed from: b */
    private int f17285b = 0;

    /* renamed from: c */
    private boolean f17286c;

    /* renamed from: d */
    private boolean f17287d;

    public C6609b(List<C3528k> list) {
        this.f17284a = list;
    }

    /* renamed from: b */
    private boolean m21706b(SSLSocket sSLSocket) {
        for (int i = this.f17285b; i < this.f17284a.size(); i++) {
            if (this.f17284a.get(i).mo19448a(sSLSocket)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    public C3528k mo35647a(SSLSocket sSLSocket) throws IOException {
        C3528k kVar;
        int i = this.f17285b;
        int size = this.f17284a.size();
        while (true) {
            if (i >= size) {
                kVar = null;
                break;
            }
            kVar = this.f17284a.get(i);
            if (kVar.mo19448a(sSLSocket)) {
                this.f17285b = i + 1;
                break;
            }
            i++;
        }
        if (kVar != null) {
            this.f17286c = m21706b(sSLSocket);
            C3499a.f9700a.mo19371a(kVar, sSLSocket, this.f17287d);
            return kVar;
        }
        throw new UnknownServiceException("Unable to find acceptable protocols. isFallback=" + this.f17287d + ", modes=" + this.f17284a + ", supported protocols=" + Arrays.toString(sSLSocket.getEnabledProtocols()));
    }

    /* renamed from: a */
    public boolean mo35648a(IOException iOException) {
        this.f17287d = true;
        if (!this.f17286c || (iOException instanceof ProtocolException) || (iOException instanceof InterruptedIOException)) {
            return false;
        }
        boolean z = iOException instanceof SSLHandshakeException;
        if ((z && (iOException.getCause() instanceof CertificateException)) || (iOException instanceof SSLPeerUnverifiedException)) {
            return false;
        }
        if (z || (iOException instanceof SSLProtocolException) || (iOException instanceof SSLException)) {
            return true;
        }
        return false;
    }
}
