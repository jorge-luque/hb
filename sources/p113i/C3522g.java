package p113i;

import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.Nullable;
import javax.net.ssl.SSLPeerUnverifiedException;
import p113i.p114e0.C3500c;
import p113i.p114e0.p198k.C5960c;
import p119j.C3581f;

/* renamed from: i.g */
/* compiled from: CertificatePinner */
public final class C3522g {

    /* renamed from: c */
    public static final C3522g f9801c = new C3523a().mo19435a();

    /* renamed from: a */
    private final Set<C3524b> f9802a;
    @Nullable

    /* renamed from: b */
    private final C5960c f9803b;

    /* renamed from: i.g$a */
    /* compiled from: CertificatePinner */
    public static final class C3523a {

        /* renamed from: a */
        private final List<C3524b> f9804a = new ArrayList();

        /* renamed from: a */
        public C3522g mo19435a() {
            return new C3522g(new LinkedHashSet(this.f9804a), (C5960c) null);
        }
    }

    /* renamed from: i.g$b */
    /* compiled from: CertificatePinner */
    static final class C3524b {

        /* renamed from: a */
        final String f9805a;

        /* renamed from: b */
        final String f9806b;

        /* renamed from: c */
        final String f9807c;

        /* renamed from: d */
        final C3581f f9808d;

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public boolean mo19436a(String str) {
            if (!this.f9805a.startsWith("*.")) {
                return str.equals(this.f9806b);
            }
            int indexOf = str.indexOf(46);
            if ((str.length() - indexOf) - 1 == this.f9806b.length()) {
                String str2 = this.f9806b;
                if (str.regionMatches(false, indexOf + 1, str2, 0, str2.length())) {
                    return true;
                }
            }
            return false;
        }

        public boolean equals(Object obj) {
            if (obj instanceof C3524b) {
                C3524b bVar = (C3524b) obj;
                return this.f9805a.equals(bVar.f9805a) && this.f9807c.equals(bVar.f9807c) && this.f9808d.equals(bVar.f9808d);
            }
        }

        public int hashCode() {
            return ((((527 + this.f9805a.hashCode()) * 31) + this.f9807c.hashCode()) * 31) + this.f9808d.hashCode();
        }

        public String toString() {
            return this.f9807c + this.f9808d.mo19748a();
        }
    }

    C3522g(Set<C3524b> set, @Nullable C5960c cVar) {
        this.f9802a = set;
        this.f9803b = cVar;
    }

    /* renamed from: b */
    static C3581f m11757b(X509Certificate x509Certificate) {
        return C3581f.m12174a(x509Certificate.getPublicKey().getEncoded()).mo19757e();
    }

    /* renamed from: a */
    public void mo19432a(String str, List<Certificate> list) throws SSLPeerUnverifiedException {
        List<C3524b> a = mo19431a(str);
        if (!a.isEmpty()) {
            C5960c cVar = this.f9803b;
            if (cVar != null) {
                list = cVar.mo19417a(list, str);
            }
            int size = list.size();
            for (int i = 0; i < size; i++) {
                X509Certificate x509Certificate = (X509Certificate) list.get(i);
                int size2 = a.size();
                C3581f fVar = null;
                C3581f fVar2 = null;
                for (int i2 = 0; i2 < size2; i2++) {
                    C3524b bVar = a.get(i2);
                    if (bVar.f9807c.equals("sha256/")) {
                        if (fVar == null) {
                            fVar = m11757b(x509Certificate);
                        }
                        if (bVar.f9808d.equals(fVar)) {
                            return;
                        }
                    } else if (bVar.f9807c.equals("sha1/")) {
                        if (fVar2 == null) {
                            fVar2 = m11755a(x509Certificate);
                        }
                        if (bVar.f9808d.equals(fVar2)) {
                            return;
                        }
                    } else {
                        throw new AssertionError("unsupported hashAlgorithm: " + bVar.f9807c);
                    }
                }
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Certificate pinning failure!");
            sb.append("\n  Peer certificate chain:");
            int size3 = list.size();
            for (int i3 = 0; i3 < size3; i3++) {
                X509Certificate x509Certificate2 = (X509Certificate) list.get(i3);
                sb.append("\n    ");
                sb.append(m11756a((Certificate) x509Certificate2));
                sb.append(": ");
                sb.append(x509Certificate2.getSubjectDN().getName());
            }
            sb.append("\n  Pinned certificates for ");
            sb.append(str);
            sb.append(":");
            int size4 = a.size();
            for (int i4 = 0; i4 < size4; i4++) {
                sb.append("\n    ");
                sb.append(a.get(i4));
            }
            throw new SSLPeerUnverifiedException(sb.toString());
        }
    }

    public boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof C3522g) {
            C3522g gVar = (C3522g) obj;
            if (!C3500c.m11654a((Object) this.f9803b, (Object) gVar.f9803b) || !this.f9802a.equals(gVar.f9802a)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        C5960c cVar = this.f9803b;
        return ((cVar != null ? cVar.hashCode() : 0) * 31) + this.f9802a.hashCode();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public List<C3524b> mo19431a(String str) {
        List<C3524b> emptyList = Collections.emptyList();
        for (C3524b next : this.f9802a) {
            if (next.mo19436a(str)) {
                if (emptyList.isEmpty()) {
                    emptyList = new ArrayList<>();
                }
                emptyList.add(next);
            }
        }
        return emptyList;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public C3522g mo19430a(@Nullable C5960c cVar) {
        if (C3500c.m11654a((Object) this.f9803b, (Object) cVar)) {
            return this;
        }
        return new C3522g(this.f9802a, cVar);
    }

    /* renamed from: a */
    public static String m11756a(Certificate certificate) {
        if (certificate instanceof X509Certificate) {
            return "sha256/" + m11757b((X509Certificate) certificate).mo19748a();
        }
        throw new IllegalArgumentException("Certificate pinning requires X509 certificates");
    }

    /* renamed from: a */
    static C3581f m11755a(X509Certificate x509Certificate) {
        return C3581f.m12174a(x509Certificate.getPublicKey().getEncoded()).mo19756d();
    }
}
