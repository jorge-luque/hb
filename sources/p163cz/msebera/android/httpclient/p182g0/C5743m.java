package p163cz.msebera.android.httpclient.p182g0;

import java.io.Serializable;
import p163cz.msebera.android.httpclient.C5906u;
import p163cz.msebera.android.httpclient.p187k0.C5886a;
import p163cz.msebera.android.httpclient.p187k0.C5893h;

/* renamed from: cz.msebera.android.httpclient.g0.m */
/* compiled from: BasicNameValuePair */
public class C5743m implements C5906u, Cloneable, Serializable {
    private static final long serialVersionUID = -6437800749411518984L;

    /* renamed from: a */
    private final String f14832a;

    /* renamed from: b */
    private final String f14833b;

    public C5743m(String str, String str2) {
        C5886a.m18894a(str, "Name");
        this.f14832a = str;
        this.f14833b = str2;
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C5906u)) {
            return false;
        }
        C5743m mVar = (C5743m) obj;
        if (!this.f14832a.equals(mVar.f14832a) || !C5893h.m18940a((Object) this.f14833b, (Object) mVar.f14833b)) {
            return false;
        }
        return true;
    }

    public String getName() {
        return this.f14832a;
    }

    public String getValue() {
        return this.f14833b;
    }

    public int hashCode() {
        return C5893h.m18938a(C5893h.m18938a(17, (Object) this.f14832a), (Object) this.f14833b);
    }

    public String toString() {
        if (this.f14833b == null) {
            return this.f14832a;
        }
        StringBuilder sb = new StringBuilder(this.f14832a.length() + 1 + this.f14833b.length());
        sb.append(this.f14832a);
        sb.append("=");
        sb.append(this.f14833b);
        return sb.toString();
    }
}
