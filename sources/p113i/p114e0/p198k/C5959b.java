package p113i.p114e0.p198k;

import java.security.cert.X509Certificate;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import javax.security.auth.x500.X500Principal;

/* renamed from: i.e0.k.b */
/* compiled from: BasicTrustRootIndex */
public final class C5959b implements C5962e {

    /* renamed from: a */
    private final Map<X500Principal, Set<X509Certificate>> f15229a = new LinkedHashMap();

    public C5959b(X509Certificate... x509CertificateArr) {
        for (X509Certificate x509Certificate : x509CertificateArr) {
            X500Principal subjectX500Principal = x509Certificate.getSubjectX500Principal();
            Set set = this.f15229a.get(subjectX500Principal);
            if (set == null) {
                set = new LinkedHashSet(1);
                this.f15229a.put(subjectX500Principal, set);
            }
            set.add(x509Certificate);
        }
    }

    /* renamed from: a */
    public X509Certificate mo19420a(X509Certificate x509Certificate) {
        Set<X509Certificate> set = this.f15229a.get(x509Certificate.getIssuerX500Principal());
        if (set == null) {
            return null;
        }
        for (X509Certificate x509Certificate2 : set) {
            try {
                x509Certificate.verify(x509Certificate2.getPublicKey());
                return x509Certificate2;
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C5959b) || !((C5959b) obj).f15229a.equals(this.f15229a)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return this.f15229a.hashCode();
    }
}
