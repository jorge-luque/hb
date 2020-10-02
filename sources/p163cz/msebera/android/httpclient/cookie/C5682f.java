package p163cz.msebera.android.httpclient.cookie;

import java.util.Locale;
import p163cz.msebera.android.httpclient.p187k0.C5886a;
import p163cz.msebera.android.httpclient.p187k0.C5894i;

/* renamed from: cz.msebera.android.httpclient.cookie.f */
/* compiled from: CookieOrigin */
public final class C5682f {

    /* renamed from: a */
    private final String f14688a;

    /* renamed from: b */
    private final int f14689b;

    /* renamed from: c */
    private final String f14690c;

    /* renamed from: d */
    private final boolean f14691d;

    public C5682f(String str, int i, String str2, boolean z) {
        C5886a.m18899b(str, "Host");
        C5886a.m18891a(i, "Port");
        C5886a.m18894a(str2, "Path");
        this.f14688a = str.toLowerCase(Locale.ROOT);
        this.f14689b = i;
        if (!C5894i.m18943b(str2)) {
            this.f14690c = str2;
        } else {
            this.f14690c = "/";
        }
        this.f14691d = z;
    }

    /* renamed from: a */
    public String mo33136a() {
        return this.f14688a;
    }

    /* renamed from: b */
    public String mo33137b() {
        return this.f14690c;
    }

    /* renamed from: c */
    public int mo33138c() {
        return this.f14689b;
    }

    /* renamed from: d */
    public boolean mo33139d() {
        return this.f14691d;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        if (this.f14691d) {
            sb.append("(secure)");
        }
        sb.append(this.f14688a);
        sb.append(':');
        sb.append(Integer.toString(this.f14689b));
        sb.append(this.f14690c);
        sb.append(']');
        return sb.toString();
    }
}
