package p113i;

import java.io.IOException;
import java.security.cert.Certificate;
import java.util.Collections;
import java.util.List;
import javax.annotation.Nullable;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import p113i.p114e0.C3500c;

/* renamed from: i.q */
/* compiled from: Handshake */
public final class C3536q {

    /* renamed from: a */
    private final C5926d0 f9851a;

    /* renamed from: b */
    private final C5964h f9852b;

    /* renamed from: c */
    private final List<Certificate> f9853c;

    /* renamed from: d */
    private final List<Certificate> f9854d;

    private C3536q(C5926d0 d0Var, C5964h hVar, List<Certificate> list, List<Certificate> list2) {
        this.f9851a = d0Var;
        this.f9852b = hVar;
        this.f9853c = list;
        this.f9854d = list2;
    }

    /* renamed from: a */
    public static C3536q m11826a(SSLSession sSLSession) throws IOException {
        Certificate[] certificateArr;
        List list;
        List list2;
        String cipherSuite = sSLSession.getCipherSuite();
        if (cipherSuite == null) {
            throw new IllegalStateException("cipherSuite == null");
        } else if (!"SSL_NULL_WITH_NULL_NULL".equals(cipherSuite)) {
            C5964h a = C5964h.m19122a(cipherSuite);
            String protocol = sSLSession.getProtocol();
            if (protocol == null) {
                throw new IllegalStateException("tlsVersion == null");
            } else if (!"NONE".equals(protocol)) {
                C5926d0 a2 = C5926d0.m18997a(protocol);
                try {
                    certificateArr = sSLSession.getPeerCertificates();
                } catch (SSLPeerUnverifiedException unused) {
                    certificateArr = null;
                }
                if (certificateArr != null) {
                    list = C3500c.m11644a((T[]) certificateArr);
                } else {
                    list = Collections.emptyList();
                }
                Certificate[] localCertificates = sSLSession.getLocalCertificates();
                if (localCertificates != null) {
                    list2 = C3500c.m11644a((T[]) localCertificates);
                } else {
                    list2 = Collections.emptyList();
                }
                return new C3536q(a2, a, list, list2);
            } else {
                throw new IOException("tlsVersion == NONE");
            }
        } else {
            throw new IOException("cipherSuite == SSL_NULL_WITH_NULL_NULL");
        }
    }

    /* renamed from: b */
    public List<Certificate> mo19495b() {
        return this.f9854d;
    }

    /* renamed from: c */
    public List<Certificate> mo19496c() {
        return this.f9853c;
    }

    /* renamed from: d */
    public C5926d0 mo19497d() {
        return this.f9851a;
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof C3536q)) {
            return false;
        }
        C3536q qVar = (C3536q) obj;
        if (!this.f9851a.equals(qVar.f9851a) || !this.f9852b.equals(qVar.f9852b) || !this.f9853c.equals(qVar.f9853c) || !this.f9854d.equals(qVar.f9854d)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return ((((((527 + this.f9851a.hashCode()) * 31) + this.f9852b.hashCode()) * 31) + this.f9853c.hashCode()) * 31) + this.f9854d.hashCode();
    }

    /* renamed from: a */
    public static C3536q m11825a(C5926d0 d0Var, C5964h hVar, List<Certificate> list, List<Certificate> list2) {
        if (d0Var == null) {
            throw new NullPointerException("tlsVersion == null");
        } else if (hVar != null) {
            return new C3536q(d0Var, hVar, C3500c.m11643a(list), C3500c.m11643a(list2));
        } else {
            throw new NullPointerException("cipherSuite == null");
        }
    }

    /* renamed from: a */
    public C5964h mo19494a() {
        return this.f9852b;
    }
}
