package p118io.fabric.sdk.android.services.network;

import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;

/* renamed from: io.fabric.sdk.android.services.network.e */
/* compiled from: NetworkUtils */
public final class C6201e {
    /* renamed from: a */
    public static final SSLSocketFactory m20028a(C6202f fVar) throws KeyManagementException, NoSuchAlgorithmException {
        SSLContext instance = SSLContext.getInstance("TLS");
        instance.init((KeyManager[]) null, new TrustManager[]{new C6203g(new C6204h(fVar.getKeyStoreStream(), fVar.getKeyStorePassword()), fVar)}, (SecureRandom) null);
        return instance.getSocketFactory();
    }
}
