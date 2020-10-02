package p113i.p114e0.p198k;

import java.security.cert.Certificate;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.X509TrustManager;
import p113i.p114e0.p117i.C3521f;

/* renamed from: i.e0.k.c */
/* compiled from: CertificateChainCleaner */
public abstract class C5960c {
    /* renamed from: a */
    public static C5960c m19113a(X509TrustManager x509TrustManager) {
        return C3521f.m11740d().mo19407a(x509TrustManager);
    }

    /* renamed from: a */
    public abstract List<Certificate> mo19417a(List<Certificate> list, String str) throws SSLPeerUnverifiedException;
}
