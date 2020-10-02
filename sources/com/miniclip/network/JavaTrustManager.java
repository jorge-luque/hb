package com.miniclip.network;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertPath;
import java.security.cert.CertPathValidator;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.PKIXParameters;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

public class JavaTrustManager implements X509TrustManager {
    private final X509TrustManager defaultX509TrustManager;
    private final KeyStore keyStore;

    public JavaTrustManager(ArrayList<byte[]> arrayList) throws NoSuchAlgorithmException, KeyStoreException, IOException, CertificateException {
        KeyStore instance = KeyStore.getInstance(KeyStore.getDefaultType());
        this.keyStore = instance;
        instance.load((KeyStore.LoadStoreParameter) null);
        Iterator<byte[]> it = arrayList.iterator();
        while (it.hasNext()) {
            X509Certificate derCert = getDerCert(it.next());
            this.keyStore.setCertificateEntry(derCert.getSubjectX500Principal().getName(), derCert);
        }
        TrustManagerFactory instance2 = TrustManagerFactory.getInstance("X509");
        instance2.init((KeyStore) null);
        this.defaultX509TrustManager = (X509TrustManager) instance2.getTrustManagers()[0];
    }

    private X509Certificate getDerCert(byte[] bArr) throws CertificateException, KeyStoreException, NoSuchAlgorithmException, IOException {
        return (X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(bArr));
    }

    public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
    }

    public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        try {
            this.defaultX509TrustManager.checkServerTrusted(x509CertificateArr, str);
        } catch (CertificateException e) {
            try {
                CertPathValidator instance = CertPathValidator.getInstance("PKIX");
                CertPath generateCertPath = CertificateFactory.getInstance("X509").generateCertPath(Arrays.asList(x509CertificateArr));
                PKIXParameters pKIXParameters = new PKIXParameters(this.keyStore);
                pKIXParameters.setRevocationEnabled(false);
                instance.validate(generateCertPath, pKIXParameters);
            } catch (Exception unused) {
                throw e;
            }
        }
    }

    public X509Certificate[] getAcceptedIssuers() {
        return new X509Certificate[0];
    }
}
