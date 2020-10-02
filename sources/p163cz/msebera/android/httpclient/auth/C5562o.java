package p163cz.msebera.android.httpclient.auth;

import java.io.Serializable;
import java.security.Principal;
import p163cz.msebera.android.httpclient.p187k0.C5886a;
import p163cz.msebera.android.httpclient.p187k0.C5893h;

/* renamed from: cz.msebera.android.httpclient.auth.o */
/* compiled from: UsernamePasswordCredentials */
public class C5562o implements C5559l, Serializable {
    private static final long serialVersionUID = 243343858802739403L;

    /* renamed from: a */
    private final C5556i f14518a;

    /* renamed from: b */
    private final String f14519b;

    public C5562o(String str) {
        C5886a.m18894a(str, "Username:password string");
        int indexOf = str.indexOf(58);
        if (indexOf >= 0) {
            this.f14518a = new C5556i(str.substring(0, indexOf));
            this.f14519b = str.substring(indexOf + 1);
            return;
        }
        this.f14518a = new C5556i(str);
        this.f14519b = null;
    }

    /* renamed from: a */
    public Principal mo32868a() {
        return this.f14518a;
    }

    /* renamed from: b */
    public String mo32869b() {
        return this.f14519b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C5562o) || !C5893h.m18940a((Object) this.f14518a, (Object) ((C5562o) obj).f14518a)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return this.f14518a.hashCode();
    }

    public String toString() {
        return this.f14518a.toString();
    }
}
