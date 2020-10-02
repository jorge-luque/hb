package p163cz.msebera.android.httpclient;

import java.io.Serializable;
import java.net.InetAddress;
import java.util.Locale;
import p163cz.msebera.android.httpclient.p187k0.C5886a;
import p163cz.msebera.android.httpclient.p187k0.C5893h;

/* renamed from: cz.msebera.android.httpclient.l */
/* compiled from: HttpHost */
public final class C5896l implements Cloneable, Serializable {
    private static final long serialVersionUID = -7529410654042457626L;

    /* renamed from: a */
    protected final String f15123a;

    /* renamed from: b */
    protected final String f15124b;

    /* renamed from: c */
    protected final int f15125c;

    /* renamed from: d */
    protected final String f15126d;

    /* renamed from: e */
    protected final InetAddress f15127e;

    public C5896l(String str, int i, String str2) {
        C5886a.m18893a(str, "Host name");
        this.f15123a = str;
        this.f15124b = str.toLowerCase(Locale.ROOT);
        if (str2 != null) {
            this.f15126d = str2.toLowerCase(Locale.ROOT);
        } else {
            this.f15126d = "http";
        }
        this.f15125c = i;
        this.f15127e = null;
    }

    /* renamed from: a */
    public InetAddress mo33684a() {
        return this.f15127e;
    }

    /* renamed from: b */
    public String mo33685b() {
        return this.f15123a;
    }

    /* renamed from: c */
    public int mo33686c() {
        return this.f15125c;
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    /* renamed from: d */
    public String mo33688d() {
        return this.f15126d;
    }

    /* renamed from: e */
    public String mo33689e() {
        if (this.f15125c == -1) {
            return this.f15123a;
        }
        StringBuilder sb = new StringBuilder(this.f15123a.length() + 6);
        sb.append(this.f15123a);
        sb.append(":");
        sb.append(Integer.toString(this.f15125c));
        return sb.toString();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C5896l)) {
            return false;
        }
        C5896l lVar = (C5896l) obj;
        if (this.f15124b.equals(lVar.f15124b) && this.f15125c == lVar.f15125c && this.f15126d.equals(lVar.f15126d)) {
            InetAddress inetAddress = this.f15127e;
            InetAddress inetAddress2 = lVar.f15127e;
            if (inetAddress == null) {
                if (inetAddress2 == null) {
                    return true;
                }
            } else if (inetAddress.equals(inetAddress2)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: f */
    public String mo33691f() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f15126d);
        sb.append("://");
        sb.append(this.f15123a);
        if (this.f15125c != -1) {
            sb.append(':');
            sb.append(Integer.toString(this.f15125c));
        }
        return sb.toString();
    }

    public int hashCode() {
        int a = C5893h.m18938a(C5893h.m18937a(C5893h.m18938a(17, (Object) this.f15124b), this.f15125c), (Object) this.f15126d);
        InetAddress inetAddress = this.f15127e;
        return inetAddress != null ? C5893h.m18938a(a, (Object) inetAddress) : a;
    }

    public String toString() {
        return mo33691f();
    }

    public C5896l(String str, int i) {
        this(str, i, (String) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public C5896l(InetAddress inetAddress, int i, String str) {
        this(inetAddress, inetAddress.getHostName(), i, str);
        C5886a.m18894a(inetAddress, "Inet address");
    }

    public C5896l(InetAddress inetAddress, String str, int i, String str2) {
        C5886a.m18894a(inetAddress, "Inet address");
        this.f15127e = inetAddress;
        C5886a.m18894a(str, "Hostname");
        String str3 = str;
        this.f15123a = str3;
        this.f15124b = str3.toLowerCase(Locale.ROOT);
        if (str2 != null) {
            this.f15126d = str2.toLowerCase(Locale.ROOT);
        } else {
            this.f15126d = "http";
        }
        this.f15125c = i;
    }
}
