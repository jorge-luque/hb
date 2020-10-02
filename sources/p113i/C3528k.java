package p113i;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import javax.annotation.Nullable;
import javax.net.ssl.SSLSocket;
import p113i.p114e0.C3500c;

/* renamed from: i.k */
/* compiled from: ConnectionSpec */
public final class C3528k {

    /* renamed from: e */
    private static final C5964h[] f9817e = {C5964h.f15246q, C5964h.f15247r, C5964h.f15248s, C5964h.f15249t, C5964h.f15250u, C5964h.f15240k, C5964h.f15242m, C5964h.f15241l, C5964h.f15243n, C5964h.f15245p, C5964h.f15244o};

    /* renamed from: f */
    private static final C5964h[] f9818f = {C5964h.f15246q, C5964h.f15247r, C5964h.f15248s, C5964h.f15249t, C5964h.f15250u, C5964h.f15240k, C5964h.f15242m, C5964h.f15241l, C5964h.f15243n, C5964h.f15245p, C5964h.f15244o, C5964h.f15238i, C5964h.f15239j, C5964h.f15236g, C5964h.f15237h, C5964h.f15234e, C5964h.f15235f, C5964h.f15233d};

    /* renamed from: g */
    public static final C3528k f9819g;

    /* renamed from: h */
    public static final C3528k f9820h = new C3529a(false).mo19459a();

    /* renamed from: a */
    final boolean f9821a;

    /* renamed from: b */
    final boolean f9822b;
    @Nullable

    /* renamed from: c */
    final String[] f9823c;
    @Nullable

    /* renamed from: d */
    final String[] f9824d;

    static {
        C3529a aVar = new C3529a(true);
        aVar.mo19457a(f9817e);
        aVar.mo19456a(C5926d0.TLS_1_3, C5926d0.TLS_1_2);
        aVar.mo19455a(true);
        aVar.mo19459a();
        C3529a aVar2 = new C3529a(true);
        aVar2.mo19457a(f9818f);
        aVar2.mo19456a(C5926d0.TLS_1_3, C5926d0.TLS_1_2, C5926d0.TLS_1_1, C5926d0.TLS_1_0);
        aVar2.mo19455a(true);
        f9819g = aVar2.mo19459a();
        C3529a aVar3 = new C3529a(true);
        aVar3.mo19457a(f9818f);
        aVar3.mo19456a(C5926d0.TLS_1_0);
        aVar3.mo19455a(true);
        aVar3.mo19459a();
    }

    C3528k(C3529a aVar) {
        this.f9821a = aVar.f9825a;
        this.f9823c = aVar.f9826b;
        this.f9824d = aVar.f9827c;
        this.f9822b = aVar.f9828d;
    }

    @Nullable
    /* renamed from: a */
    public List<C5964h> mo19446a() {
        String[] strArr = this.f9823c;
        if (strArr != null) {
            return C5964h.m19124a(strArr);
        }
        return null;
    }

    /* renamed from: b */
    public boolean mo19449b() {
        return this.f9821a;
    }

    /* renamed from: c */
    public boolean mo19450c() {
        return this.f9822b;
    }

    @Nullable
    /* renamed from: d */
    public List<C5926d0> mo19451d() {
        String[] strArr = this.f9824d;
        if (strArr != null) {
            return C5926d0.m18998a(strArr);
        }
        return null;
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof C3528k)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        C3528k kVar = (C3528k) obj;
        boolean z = this.f9821a;
        if (z != kVar.f9821a) {
            return false;
        }
        return !z || (Arrays.equals(this.f9823c, kVar.f9823c) && Arrays.equals(this.f9824d, kVar.f9824d) && this.f9822b == kVar.f9822b);
    }

    public int hashCode() {
        if (this.f9821a) {
            return ((((527 + Arrays.hashCode(this.f9823c)) * 31) + Arrays.hashCode(this.f9824d)) * 31) + (this.f9822b ^ true ? 1 : 0);
        }
        return 17;
    }

    public String toString() {
        if (!this.f9821a) {
            return "ConnectionSpec()";
        }
        String str = "[all enabled]";
        String obj = this.f9823c != null ? mo19446a().toString() : str;
        if (this.f9824d != null) {
            str = mo19451d().toString();
        }
        return "ConnectionSpec(cipherSuites=" + obj + ", tlsVersions=" + str + ", supportsTlsExtensions=" + this.f9822b + ")";
    }

    /* renamed from: i.k$a */
    /* compiled from: ConnectionSpec */
    public static final class C3529a {

        /* renamed from: a */
        boolean f9825a;
        @Nullable

        /* renamed from: b */
        String[] f9826b;
        @Nullable

        /* renamed from: c */
        String[] f9827c;

        /* renamed from: d */
        boolean f9828d;

        C3529a(boolean z) {
            this.f9825a = z;
        }

        /* renamed from: a */
        public C3529a mo19457a(C5964h... hVarArr) {
            if (this.f9825a) {
                String[] strArr = new String[hVarArr.length];
                for (int i = 0; i < hVarArr.length; i++) {
                    strArr[i] = hVarArr[i].f15251a;
                }
                mo19458a(strArr);
                return this;
            }
            throw new IllegalStateException("no cipher suites for cleartext connections");
        }

        /* renamed from: b */
        public C3529a mo19460b(String... strArr) {
            if (!this.f9825a) {
                throw new IllegalStateException("no TLS versions for cleartext connections");
            } else if (strArr.length != 0) {
                this.f9827c = (String[]) strArr.clone();
                return this;
            } else {
                throw new IllegalArgumentException("At least one TLS version is required");
            }
        }

        public C3529a(C3528k kVar) {
            this.f9825a = kVar.f9821a;
            this.f9826b = kVar.f9823c;
            this.f9827c = kVar.f9824d;
            this.f9828d = kVar.f9822b;
        }

        /* renamed from: a */
        public C3529a mo19458a(String... strArr) {
            if (!this.f9825a) {
                throw new IllegalStateException("no cipher suites for cleartext connections");
            } else if (strArr.length != 0) {
                this.f9826b = (String[]) strArr.clone();
                return this;
            } else {
                throw new IllegalArgumentException("At least one cipher suite is required");
            }
        }

        /* renamed from: a */
        public C3529a mo19456a(C5926d0... d0VarArr) {
            if (this.f9825a) {
                String[] strArr = new String[d0VarArr.length];
                for (int i = 0; i < d0VarArr.length; i++) {
                    strArr[i] = d0VarArr[i].f15168a;
                }
                mo19460b(strArr);
                return this;
            }
            throw new IllegalStateException("no TLS versions for cleartext connections");
        }

        /* renamed from: a */
        public C3529a mo19455a(boolean z) {
            if (this.f9825a) {
                this.f9828d = z;
                return this;
            }
            throw new IllegalStateException("no TLS extensions for cleartext connections");
        }

        /* renamed from: a */
        public C3528k mo19459a() {
            return new C3528k(this);
        }
    }

    /* renamed from: b */
    private C3528k m11769b(SSLSocket sSLSocket, boolean z) {
        String[] strArr;
        String[] strArr2;
        if (this.f9823c != null) {
            strArr = C3500c.m11656a((Comparator<? super String>) C5964h.f15231b, sSLSocket.getEnabledCipherSuites(), this.f9823c);
        } else {
            strArr = sSLSocket.getEnabledCipherSuites();
        }
        if (this.f9824d != null) {
            strArr2 = C3500c.m11656a((Comparator<? super String>) C3500c.f9715o, sSLSocket.getEnabledProtocols(), this.f9824d);
        } else {
            strArr2 = sSLSocket.getEnabledProtocols();
        }
        String[] supportedCipherSuites = sSLSocket.getSupportedCipherSuites();
        int a = C3500c.m11635a(C5964h.f15231b, supportedCipherSuites, "TLS_FALLBACK_SCSV");
        if (z && a != -1) {
            strArr = C3500c.m11657a(strArr, supportedCipherSuites[a]);
        }
        C3529a aVar = new C3529a(this);
        aVar.mo19458a(strArr);
        aVar.mo19460b(strArr2);
        return aVar.mo19459a();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo19447a(SSLSocket sSLSocket, boolean z) {
        C3528k b = m11769b(sSLSocket, z);
        String[] strArr = b.f9824d;
        if (strArr != null) {
            sSLSocket.setEnabledProtocols(strArr);
        }
        String[] strArr2 = b.f9823c;
        if (strArr2 != null) {
            sSLSocket.setEnabledCipherSuites(strArr2);
        }
    }

    /* renamed from: a */
    public boolean mo19448a(SSLSocket sSLSocket) {
        if (!this.f9821a) {
            return false;
        }
        String[] strArr = this.f9824d;
        if (strArr != null && !C3500c.m11662b(C3500c.f9715o, strArr, sSLSocket.getEnabledProtocols())) {
            return false;
        }
        String[] strArr2 = this.f9823c;
        if (strArr2 == null || C3500c.m11662b(C5964h.f15231b, strArr2, sSLSocket.getEnabledCipherSuites())) {
            return true;
        }
        return false;
    }
}
