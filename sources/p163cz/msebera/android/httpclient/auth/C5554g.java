package p163cz.msebera.android.httpclient.auth;

import java.util.Locale;
import p163cz.msebera.android.httpclient.C5896l;
import p163cz.msebera.android.httpclient.p187k0.C5886a;
import p163cz.msebera.android.httpclient.p187k0.C5893h;

/* renamed from: cz.msebera.android.httpclient.auth.g */
/* compiled from: AuthScope */
public class C5554g {

    /* renamed from: e */
    public static final String f14501e = null;

    /* renamed from: f */
    public static final String f14502f = null;

    /* renamed from: g */
    public static final String f14503g = null;

    /* renamed from: a */
    private final String f14504a;

    /* renamed from: b */
    private final String f14505b;

    /* renamed from: c */
    private final String f14506c;

    /* renamed from: d */
    private final int f14507d;

    static {
        new C5554g((String) null, -1, (String) null, (String) null);
    }

    public C5554g(String str, int i, String str2, String str3) {
        this.f14506c = str == null ? f14501e : str.toLowerCase(Locale.ROOT);
        this.f14507d = i < 0 ? -1 : i;
        this.f14505b = str2 == null ? f14502f : str2;
        this.f14504a = str3 == null ? f14503g : str3.toUpperCase(Locale.ROOT);
    }

    /* renamed from: a */
    public int mo32848a(C5554g gVar) {
        int i;
        if (C5893h.m18940a((Object) this.f14504a, (Object) gVar.f14504a)) {
            i = 1;
        } else {
            String str = this.f14504a;
            String str2 = f14503g;
            if (str != str2 && gVar.f14504a != str2) {
                return -1;
            }
            i = 0;
        }
        if (C5893h.m18940a((Object) this.f14505b, (Object) gVar.f14505b)) {
            i += 2;
        } else {
            String str3 = this.f14505b;
            String str4 = f14502f;
            if (!(str3 == str4 || gVar.f14505b == str4)) {
                return -1;
            }
        }
        int i2 = this.f14507d;
        int i3 = gVar.f14507d;
        if (i2 == i3) {
            i += 4;
        } else if (!(i2 == -1 || i3 == -1)) {
            return -1;
        }
        if (C5893h.m18940a((Object) this.f14506c, (Object) gVar.f14506c)) {
            return i + 8;
        }
        String str5 = this.f14506c;
        String str6 = f14501e;
        if (str5 == str6 || gVar.f14506c == str6) {
            return i;
        }
        return -1;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C5554g)) {
            return super.equals(obj);
        }
        C5554g gVar = (C5554g) obj;
        if (!C5893h.m18940a((Object) this.f14506c, (Object) gVar.f14506c) || this.f14507d != gVar.f14507d || !C5893h.m18940a((Object) this.f14505b, (Object) gVar.f14505b) || !C5893h.m18940a((Object) this.f14504a, (Object) gVar.f14504a)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return C5893h.m18938a(C5893h.m18938a(C5893h.m18937a(C5893h.m18938a(17, (Object) this.f14506c), this.f14507d), (Object) this.f14505b), (Object) this.f14504a);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        String str = this.f14504a;
        if (str != null) {
            sb.append(str.toUpperCase(Locale.ROOT));
            sb.append(' ');
        }
        if (this.f14505b != null) {
            sb.append('\'');
            sb.append(this.f14505b);
            sb.append('\'');
        } else {
            sb.append("<any realm>");
        }
        if (this.f14506c != null) {
            sb.append('@');
            sb.append(this.f14506c);
            if (this.f14507d >= 0) {
                sb.append(':');
                sb.append(this.f14507d);
            }
        }
        return sb.toString();
    }

    public C5554g(C5896l lVar, String str, String str2) {
        C5886a.m18894a(lVar, "Host");
        this.f14506c = lVar.mo33685b().toLowerCase(Locale.ROOT);
        this.f14507d = lVar.mo33686c() < 0 ? -1 : lVar.mo33686c();
        this.f14505b = str == null ? f14502f : str;
        this.f14504a = str2 == null ? f14503g : str2.toUpperCase(Locale.ROOT);
    }

    public C5554g(String str, int i) {
        this(str, i, f14502f, f14503g);
    }
}
