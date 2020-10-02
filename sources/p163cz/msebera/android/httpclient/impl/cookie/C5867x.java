package p163cz.msebera.android.httpclient.impl.cookie;

import java.util.Locale;
import p163cz.msebera.android.httpclient.cookie.C5678b;
import p163cz.msebera.android.httpclient.cookie.C5679c;
import p163cz.msebera.android.httpclient.cookie.C5682f;
import p163cz.msebera.android.httpclient.cookie.C5690m;
import p163cz.msebera.android.httpclient.cookie.CookieRestrictionViolationException;
import p163cz.msebera.android.httpclient.cookie.MalformedCookieException;
import p163cz.msebera.android.httpclient.p187k0.C5886a;

/* renamed from: cz.msebera.android.httpclient.impl.cookie.x */
/* compiled from: RFC2109DomainHandler */
public class C5867x implements C5678b {
    /* renamed from: a */
    public String mo33121a() {
        return "domain";
    }

    /* renamed from: a */
    public void mo33132a(C5690m mVar, String str) throws MalformedCookieException {
        C5886a.m18894a(mVar, "Cookie");
        if (str == null) {
            throw new MalformedCookieException("Missing value for domain attribute");
        } else if (!str.trim().isEmpty()) {
            mVar.mo33161f(str);
        } else {
            throw new MalformedCookieException("Blank value for domain attribute");
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
        if (a.equals(d) || (d.startsWith(".") && a.endsWith(d))) {
            return true;
        }
        return false;
    }

    /* renamed from: a */
    public void mo33131a(C5679c cVar, C5682f fVar) throws MalformedCookieException {
        C5886a.m18894a(cVar, "Cookie");
        C5886a.m18894a(fVar, "Cookie origin");
        String a = fVar.mo33136a();
        String d = cVar.mo33127d();
        if (d == null) {
            throw new CookieRestrictionViolationException("Cookie domain may not be null");
        } else if (d.equals(a)) {
        } else {
            if (d.indexOf(46) == -1) {
                throw new CookieRestrictionViolationException("Domain attribute \"" + d + "\" does not match the host \"" + a + "\"");
            } else if (d.startsWith(".")) {
                int indexOf = d.indexOf(46, 1);
                if (indexOf < 0 || indexOf == d.length() - 1) {
                    throw new CookieRestrictionViolationException("Domain attribute \"" + d + "\" violates RFC 2109: domain must contain an embedded dot");
                }
                String lowerCase = a.toLowerCase(Locale.ROOT);
                if (!lowerCase.endsWith(d)) {
                    throw new CookieRestrictionViolationException("Illegal domain attribute \"" + d + "\". Domain of origin: \"" + lowerCase + "\"");
                } else if (lowerCase.substring(0, lowerCase.length() - d.length()).indexOf(46) != -1) {
                    throw new CookieRestrictionViolationException("Domain attribute \"" + d + "\" violates RFC 2109: host minus domain may not contain any dots");
                }
            } else {
                throw new CookieRestrictionViolationException("Domain attribute \"" + d + "\" violates RFC 2109: domain must start with a dot");
            }
        }
    }
}
