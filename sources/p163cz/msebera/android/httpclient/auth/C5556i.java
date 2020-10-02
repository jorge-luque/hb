package p163cz.msebera.android.httpclient.auth;

import java.io.Serializable;
import java.security.Principal;
import p163cz.msebera.android.httpclient.p187k0.C5886a;
import p163cz.msebera.android.httpclient.p187k0.C5893h;

/* renamed from: cz.msebera.android.httpclient.auth.i */
/* compiled from: BasicUserPrincipal */
public final class C5556i implements Principal, Serializable {
    private static final long serialVersionUID = -2266305184969850467L;

    /* renamed from: a */
    private final String f14512a;

    public C5556i(String str) {
        C5886a.m18894a(str, "User name");
        this.f14512a = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C5556i) || !C5893h.m18940a((Object) this.f14512a, (Object) ((C5556i) obj).f14512a)) {
            return false;
        }
        return true;
    }

    public String getName() {
        return this.f14512a;
    }

    public int hashCode() {
        return C5893h.m18938a(17, (Object) this.f14512a);
    }

    public String toString() {
        return "[principal: " + this.f14512a + "]";
    }
}
