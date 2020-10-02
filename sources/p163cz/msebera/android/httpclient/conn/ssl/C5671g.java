package p163cz.msebera.android.httpclient.conn.ssl;

import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;

@Deprecated
/* renamed from: cz.msebera.android.httpclient.conn.ssl.g */
/* compiled from: SSLContexts */
public class C5671g {
    /* renamed from: a */
    public static SSLContext m18061a() throws SSLInitializationException {
        try {
            SSLContext instance = SSLContext.getInstance("TLS");
            instance.init((KeyManager[]) null, (TrustManager[]) null, (SecureRandom) null);
            return instance;
        } catch (NoSuchAlgorithmException e) {
            throw new SSLInitializationException(e.getMessage(), e);
        } catch (KeyManagementException e2) {
            throw new SSLInitializationException(e2.getMessage(), e2);
        }
    }

    /* renamed from: b */
    public static C5669f m18062b() {
        return new C5669f();
    }
}
