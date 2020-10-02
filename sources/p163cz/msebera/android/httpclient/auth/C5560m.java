package p163cz.msebera.android.httpclient.auth;

import java.io.Serializable;
import java.security.Principal;
import p163cz.msebera.android.httpclient.p187k0.C5893h;

/* renamed from: cz.msebera.android.httpclient.auth.m */
/* compiled from: NTCredentials */
public class C5560m implements C5559l, Serializable {
    private static final long serialVersionUID = -7385699315228907265L;

    /* renamed from: a */
    private final C5561n f14515a;

    /* renamed from: b */
    private final String f14516b;

    /* renamed from: c */
    private final String f14517c;

    /* renamed from: a */
    public Principal mo32868a() {
        return this.f14515a;
    }

    /* renamed from: b */
    public String mo32869b() {
        return this.f14516b;
    }

    /* renamed from: c */
    public String mo32870c() {
        this.f14515a.mo32875a();
        throw null;
    }

    /* renamed from: d */
    public String mo32871d() {
        this.f14515a.mo32876b();
        throw null;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C5560m)) {
            return false;
        }
        C5560m mVar = (C5560m) obj;
        if (!C5893h.m18940a((Object) this.f14515a, (Object) mVar.f14515a) || !C5893h.m18940a((Object) this.f14517c, (Object) mVar.f14517c)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return C5893h.m18938a(C5893h.m18938a(17, (Object) this.f14515a), (Object) this.f14517c);
    }

    public String toString() {
        return "[principal: " + this.f14515a + "][workstation: " + this.f14517c + "]";
    }
}
