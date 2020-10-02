package p163cz.msebera.android.httpclient.impl.cookie;

import java.util.Locale;
import p163cz.msebera.android.httpclient.cookie.C5677a;
import p163cz.msebera.android.httpclient.cookie.C5678b;
import p163cz.msebera.android.httpclient.cookie.C5679c;
import p163cz.msebera.android.httpclient.cookie.C5682f;
import p163cz.msebera.android.httpclient.cookie.C5690m;
import p163cz.msebera.android.httpclient.cookie.CookieRestrictionViolationException;
import p163cz.msebera.android.httpclient.cookie.MalformedCookieException;
import p163cz.msebera.android.httpclient.p187k0.C5886a;

/* renamed from: cz.msebera.android.httpclient.impl.cookie.d0 */
/* compiled from: RFC2965DomainAttributeHandler */
public class C5841d0 implements C5678b {
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
            String lowerCase = str.toLowerCase(Locale.ROOT);
            if (!str.startsWith(".")) {
                lowerCase = '.' + lowerCase;
            }
            mVar.mo33161f(lowerCase);
        } else {
            throw new MalformedCookieException("Blank value for domain attribute");
        }
    }

    /* renamed from: b */
    public boolean mo33133b(C5679c cVar, C5682f fVar) {
        C5886a.m18894a(cVar, "Cookie");
        C5886a.m18894a(fVar, "Cookie origin");
        String lowerCase = fVar.mo33136a().toLowerCase(Locale.ROOT);
        String d = cVar.mo33127d();
        if (mo33618a(lowerCase, d) && lowerCase.substring(0, lowerCase.length() - d.length()).indexOf(46) == -1) {
            return true;
        }
        return false;
    }

    /* renamed from: a */
    public boolean mo33618a(String str, String str2) {
        return str.equals(str2) || (str2.startsWith(".") && str.endsWith(str2));
    }

    /* renamed from: a */
    public void mo33131a(C5679c cVar, C5682f fVar) throws MalformedCookieException {
        C5886a.m18894a(cVar, "Cookie");
        C5886a.m18894a(fVar, "Cookie origin");
        String lowerCase = fVar.mo33136a().toLowerCase(Locale.ROOT);
        if (cVar.mo33127d() != null) {
            String lowerCase2 = cVar.mo33127d().toLowerCase(Locale.ROOT);
            if (!(cVar instanceof C5677a) || !((C5677a) cVar).mo33120c("domain")) {
                if (!cVar.mo33127d().equals(lowerCase)) {
                    throw new CookieRestrictionViolationException("Illegal domain attribute: \"" + cVar.mo33127d() + "\"." + "Domain of origin: \"" + lowerCase + "\"");
                }
            } else if (lowerCase2.startsWith(".")) {
                int indexOf = lowerCase2.indexOf(46, 1);
                if ((indexOf < 0 || indexOf == lowerCase2.length() - 1) && !lowerCase2.equals(".local")) {
                    throw new CookieRestrictionViolationException("Domain attribute \"" + cVar.mo33127d() + "\" violates RFC 2965: the value contains no embedded dots " + "and the value is not .local");
                } else if (!mo33618a(lowerCase, lowerCase2)) {
                    throw new CookieRestrictionViolationException("Domain attribute \"" + cVar.mo33127d() + "\" violates RFC 2965: effective host name does not " + "domain-match domain attribute.");
                } else if (lowerCase.substring(0, lowerCase.length() - lowerCase2.length()).indexOf(46) != -1) {
                    throw new CookieRestrictionViolationException("Domain attribute \"" + cVar.mo33127d() + "\" violates RFC 2965: " + "effective host minus domain may not contain any dots");
                }
            } else {
                throw new CookieRestrictionViolationException("Domain attribute \"" + cVar.mo33127d() + "\" violates RFC 2109: domain must start with a dot");
            }
        } else {
            throw new CookieRestrictionViolationException("Invalid cookie state: domain not specified");
        }
    }
}
