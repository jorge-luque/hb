package p163cz.msebera.android.httpclient.conn.ssl;

import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.LinkedHashSet;
import java.util.Set;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

@Deprecated
/* renamed from: cz.msebera.android.httpclient.conn.ssl.f */
/* compiled from: SSLContextBuilder */
public class C5669f {

    /* renamed from: a */
    private String f14672a;

    /* renamed from: b */
    private Set<KeyManager> f14673b = new LinkedHashSet();

    /* renamed from: c */
    private Set<TrustManager> f14674c = new LinkedHashSet();

    /* renamed from: d */
    private SecureRandom f14675d;

    /* renamed from: cz.msebera.android.httpclient.conn.ssl.f$a */
    /* compiled from: SSLContextBuilder */
    static class C5670a implements X509TrustManager {

        /* renamed from: a */
        private final X509TrustManager f14676a;

        /* renamed from: b */
        private final C5674j f14677b;

        C5670a(X509TrustManager x509TrustManager, C5674j jVar) {
            this.f14676a = x509TrustManager;
            this.f14677b = jVar;
        }

        public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
            this.f14676a.checkClientTrusted(x509CertificateArr, str);
        }

        public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
            if (!this.f14677b.mo33694a(x509CertificateArr, str)) {
                this.f14676a.checkServerTrusted(x509CertificateArr, str);
            }
        }

        public X509Certificate[] getAcceptedIssuers() {
            return this.f14676a.getAcceptedIssuers();
        }
    }

    /* renamed from: a */
    public C5669f mo33108a(KeyStore keyStore, C5674j jVar) throws NoSuchAlgorithmException, KeyStoreException {
        TrustManagerFactory instance = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        instance.init(keyStore);
        TrustManager[] trustManagers = instance.getTrustManagers();
        if (trustManagers != null) {
            if (jVar != null) {
                for (int i = 0; i < trustManagers.length; i++) {
                    TrustManager trustManager = trustManagers[i];
                    if (trustManager instanceof X509TrustManager) {
                        trustManagers[i] = new C5670a((X509TrustManager) trustManager, jVar);
                    }
                }
            }
            for (TrustManager add : trustManagers) {
                this.f14674c.add(add);
            }
        }
        return this;
    }

    /* renamed from: a */
    public C5669f mo33107a(KeyStore keyStore) throws NoSuchAlgorithmException, KeyStoreException {
        mo33108a(keyStore, (C5674j) null);
        return this;
    }

    /* renamed from: a */
    public SSLContext mo33109a() throws NoSuchAlgorithmException, KeyManagementException {
        KeyManager[] keyManagerArr;
        String str = this.f14672a;
        if (str == null) {
            str = "TLS";
        }
        SSLContext instance = SSLContext.getInstance(str);
        TrustManager[] trustManagerArr = null;
        if (!this.f14673b.isEmpty()) {
            Set<KeyManager> set = this.f14673b;
            keyManagerArr = (KeyManager[]) set.toArray(new KeyManager[set.size()]);
        } else {
            keyManagerArr = null;
        }
        if (!this.f14674c.isEmpty()) {
            Set<TrustManager> set2 = this.f14674c;
            trustManagerArr = (TrustManager[]) set2.toArray(new TrustManager[set2.size()]);
        }
        instance.init(keyManagerArr, trustManagerArr, this.f14675d);
        return instance;
    }
}
