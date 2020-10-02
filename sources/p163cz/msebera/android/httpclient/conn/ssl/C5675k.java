package p163cz.msebera.android.httpclient.conn.ssl;

import java.io.IOException;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSocket;

@Deprecated
/* renamed from: cz.msebera.android.httpclient.conn.ssl.k */
/* compiled from: X509HostnameVerifier */
public interface C5675k extends HostnameVerifier {
    void verify(String str, SSLSocket sSLSocket) throws IOException;

    void verify(String str, String[] strArr, String[] strArr2) throws SSLException;
}
