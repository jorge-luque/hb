package p163cz.msebera.android.httpclient.impl.cookie;

import java.util.Locale;
import p163cz.msebera.android.httpclient.conn.p176t.C5676a;
import p163cz.msebera.android.httpclient.cookie.C5677a;
import p163cz.msebera.android.httpclient.cookie.C5678b;
import p163cz.msebera.android.httpclient.cookie.C5679c;
import p163cz.msebera.android.httpclient.cookie.C5682f;
import p163cz.msebera.android.httpclient.cookie.C5690m;
import p163cz.msebera.android.httpclient.cookie.CookieRestrictionViolationException;
import p163cz.msebera.android.httpclient.cookie.MalformedCookieException;
import p163cz.msebera.android.httpclient.p187k0.C5886a;
import p163cz.msebera.android.httpclient.p187k0.C5894i;

/* renamed from: cz.msebera.android.httpclient.impl.cookie.f */
/* compiled from: BasicDomainHandler */
public class C5844f implements C5678b {
    /* renamed from: a */
    public String mo33121a() {
        return "domain";
    }

    /* renamed from: a */
    public void mo33132a(C5690m mVar, String str) throws MalformedCookieException {
        C5886a.m18894a(mVar, "Cookie");
        if (C5894i.m18943b(str)) {
            throw new MalformedCookieException("Blank or null value for domain attribute");
        } else if (!str.endsWith(".")) {
            if (str.startsWith(".")) {
                str = str.substring(1);
            }
            mVar.mo33161f(str.toLowerCase(Locale.ROOT));
        }
    }

    /* renamed from: b */
    public boolean mo33133b(C5679c cVar, C5682f fVar) {
        C5886a.m18894a(cVar, "Cookie");
        C5886a.m18894a(fVar, "Cookie origin");
        String a = fVar.mo33136a();
        String d = cVar.mo33127d();
        if (d == null) {
            return false;
        }
        if (d.startsWith(".")) {
            d = d.substring(1);
        }
        String lowerCase = d.toLowerCase(Locale.ROOT);
        if (a.equals(lowerCase)) {
            return true;
        }
        if (!(cVar instanceof C5677a) || !((C5677a) cVar).mo33120c("domain")) {
            return false;
        }
        return m18757a(lowerCase, a);
    }

    /* renamed from: a */
    public void mo33131a(C5679c cVar, C5682f fVar) throws MalformedCookieException {
        C5886a.m18894a(cVar, "Cookie");
        C5886a.m18894a(fVar, "Cookie origin");
        String a = fVar.mo33136a();
        String d = cVar.mo33127d();
        if (d == null) {
            throw new CookieRestrictionViolationException("Cookie 'domain' may not be null");
        } else if (!a.equals(d) && !m18757a(d, a)) {
            throw new CookieRestrictionViolationException("Illegal 'domain' attribute \"" + d + "\". Domain of origin: \"" + a + "\"");
        }
    }

    /* renamed from: a */
    static boolean m18757a(String str, String str2) {
        if (!C5676a.m18079a(str2) && !C5676a.m18080b(str2)) {
            if (str.startsWith(".")) {
                str = str.substring(1);
            }
            if (str2.endsWith(str)) {
                int length = str2.length() - str.length();
                if (length == 0) {
                    return true;
                }
                if (length <= 1 || str2.charAt(length - 1) != '.') {
                    return false;
                }
                return true;
            }
        }
        return false;
    }
}
