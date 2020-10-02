package p118io.fabric.sdk.android.services.network;

import java.security.GeneralSecurityException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.LinkedList;

/* renamed from: io.fabric.sdk.android.services.network.a */
/* compiled from: CertificateChainCleaner */
final class C6196a {
    /* renamed from: a */
    public static X509Certificate[] m20016a(X509Certificate[] x509CertificateArr, C6204h hVar) throws CertificateException {
        LinkedList linkedList = new LinkedList();
        boolean b = hVar.mo34375b(x509CertificateArr[0]);
        linkedList.add(x509CertificateArr[0]);
        boolean z = true;
        int i = 1;
        while (i < x509CertificateArr.length) {
            if (hVar.mo34375b(x509CertificateArr[i])) {
                b = true;
            }
            if (!m20015a(x509CertificateArr[i], x509CertificateArr[i - 1])) {
                break;
            }
            linkedList.add(x509CertificateArr[i]);
            i++;
        }
        X509Certificate a = hVar.mo34374a(x509CertificateArr[i - 1]);
        if (a != null) {
            linkedList.add(a);
        } else {
            z = b;
        }
        if (z) {
            return (X509Certificate[]) linkedList.toArray(new X509Certificate[linkedList.size()]);
        }
        throw new CertificateException("Didn't find a trust anchor in chain cleanup!");
    }

    /* renamed from: a */
    private static boolean m20015a(X509Certificate x509Certificate, X509Certificate x509Certificate2) {
        if (!x509Certificate.getSubjectX500Principal().equals(x509Certificate2.getIssuerX500Principal())) {
            return false;
        }
        try {
            x509Certificate2.verify(x509Certificate.getPublicKey());
            return true;
        } catch (GeneralSecurityException unused) {
            return false;
        }
    }
}
