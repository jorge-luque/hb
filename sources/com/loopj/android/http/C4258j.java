package com.loopj.android.http;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import p163cz.msebera.android.httpclient.conn.ssl.C5672h;

/* renamed from: com.loopj.android.http.j */
/* compiled from: MySSLSocketFactory */
public class C4258j extends C5672h {

    /* renamed from: h */
    final SSLContext f11408h = SSLContext.getInstance("TLS");

    /* renamed from: com.loopj.android.http.j$a */
    /* compiled from: MySSLSocketFactory */
    class C4259a implements X509TrustManager {
        C4259a(C4258j jVar) {
        }

        public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        }

        public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        }

        public X509Certificate[] getAcceptedIssuers() {
            return null;
        }
    }

    public C4258j(KeyStore keyStore) throws NoSuchAlgorithmException, KeyManagementException, KeyStoreException, UnrecoverableKeyException {
        super(keyStore);
        C4259a aVar = new C4259a(this);
        this.f11408h.init((KeyManager[]) null, new TrustManager[]{aVar}, (SecureRandom) null);
    }

    /* renamed from: c */
    public static C5672h m14384c() {
        try {
            C4258j jVar = new C4258j(m14385d());
            jVar.mo33116a(C5672h.f14678f);
            return jVar;
        } catch (Throwable th) {
            th.printStackTrace();
            return C5672h.m18064b();
        }
    }

    /* renamed from: d */
    public static KeyStore m14385d() {
        KeyStore keyStore;
        Throwable th;
        try {
            keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
            try {
                keyStore.load((InputStream) null, (char[]) null);
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Throwable th3) {
            Throwable th4 = th3;
            keyStore = null;
            th = th4;
            th.printStackTrace();
            return keyStore;
        }
        return keyStore;
    }

    /* renamed from: a */
    public Socket mo28914a(Socket socket, String str, int i, boolean z) throws IOException {
        return this.f11408h.getSocketFactory().createSocket(socket, str, i, z);
    }

    /* renamed from: a */
    public Socket mo28913a() throws IOException {
        return this.f11408h.getSocketFactory().createSocket();
    }
}
