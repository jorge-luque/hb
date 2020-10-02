package p118io.fabric.sdk.android.services.network;

import java.security.KeyStoreException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import p118io.fabric.sdk.android.C6059c;
import p118io.fabric.sdk.android.C6072k;

/* renamed from: io.fabric.sdk.android.services.network.g */
/* compiled from: PinningTrustManager */
class C6203g implements X509TrustManager {

    /* renamed from: f */
    private static final X509Certificate[] f16267f = new X509Certificate[0];

    /* renamed from: a */
    private final TrustManager[] f16268a;

    /* renamed from: b */
    private final C6204h f16269b;

    /* renamed from: c */
    private final long f16270c;

    /* renamed from: d */
    private final List<byte[]> f16271d = new LinkedList();

    /* renamed from: e */
    private final Set<X509Certificate> f16272e = Collections.synchronizedSet(new HashSet());

    public C6203g(C6204h hVar, C6202f fVar) {
        this.f16268a = m20033a(hVar);
        this.f16269b = hVar;
        this.f16270c = fVar.getPinCreationTimeInMillis();
        for (String a : fVar.getPins()) {
            this.f16271d.add(m20032a(a));
        }
    }

    /* renamed from: a */
    private TrustManager[] m20033a(C6204h hVar) {
        try {
            TrustManagerFactory instance = TrustManagerFactory.getInstance("X509");
            instance.init(hVar.f16273a);
            return instance.getTrustManagers();
        } catch (NoSuchAlgorithmException e) {
            throw new AssertionError(e);
        } catch (KeyStoreException e2) {
            throw new AssertionError(e2);
        }
    }

    public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        throw new CertificateException("Client certificates not supported!");
    }

    public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        if (!this.f16272e.contains(x509CertificateArr[0])) {
            m20030a(x509CertificateArr, str);
            m20029a(x509CertificateArr);
            this.f16272e.add(x509CertificateArr[0]);
        }
    }

    public X509Certificate[] getAcceptedIssuers() {
        return f16267f;
    }

    /* renamed from: a */
    private boolean m20031a(X509Certificate x509Certificate) throws CertificateException {
        try {
            byte[] digest = MessageDigest.getInstance("SHA1").digest(x509Certificate.getPublicKey().getEncoded());
            for (byte[] equals : this.f16271d) {
                if (Arrays.equals(equals, digest)) {
                    return true;
                }
            }
            return false;
        } catch (NoSuchAlgorithmException e) {
            throw new CertificateException(e);
        }
    }

    /* renamed from: a */
    private void m20030a(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        for (TrustManager trustManager : this.f16268a) {
            ((X509TrustManager) trustManager).checkServerTrusted(x509CertificateArr, str);
        }
    }

    /* renamed from: a */
    private void m20029a(X509Certificate[] x509CertificateArr) throws CertificateException {
        if (this.f16270c == -1 || System.currentTimeMillis() - this.f16270c <= 15552000000L) {
            X509Certificate[] a = C6196a.m20016a(x509CertificateArr, this.f16269b);
            int length = a.length;
            int i = 0;
            while (i < length) {
                if (!m20031a(a[i])) {
                    i++;
                } else {
                    return;
                }
            }
            throw new CertificateException("No valid pins found in chain!");
        }
        C6072k f = C6059c.m19630f();
        f.mo34086a("Fabric", "Certificate pins are stale, (" + (System.currentTimeMillis() - this.f16270c) + " millis vs " + 15552000000L + " millis) falling back to system trust.");
    }

    /* renamed from: a */
    private byte[] m20032a(String str) {
        int length = str.length();
        byte[] bArr = new byte[(length / 2)];
        for (int i = 0; i < length; i += 2) {
            bArr[i / 2] = (byte) ((Character.digit(str.charAt(i), 16) << 4) + Character.digit(str.charAt(i + 1), 16));
        }
        return bArr;
    }
}
