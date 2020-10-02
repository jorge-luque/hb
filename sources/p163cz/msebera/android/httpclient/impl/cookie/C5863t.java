package p163cz.msebera.android.httpclient.impl.cookie;

import java.util.Locale;
import java.util.StringTokenizer;
import p163cz.msebera.android.httpclient.cookie.C5679c;
import p163cz.msebera.android.httpclient.cookie.C5682f;
import p163cz.msebera.android.httpclient.cookie.C5690m;
import p163cz.msebera.android.httpclient.cookie.CookieRestrictionViolationException;
import p163cz.msebera.android.httpclient.cookie.MalformedCookieException;
import p163cz.msebera.android.httpclient.p187k0.C5886a;
import p163cz.msebera.android.httpclient.p187k0.C5894i;

/* renamed from: cz.msebera.android.httpclient.impl.cookie.t */
/* compiled from: NetscapeDomainHandler */
public class C5863t extends C5844f {
    /* renamed from: a */
    public String mo33121a() {
        return "domain";
    }

    /* renamed from: a */
    public void mo33132a(C5690m mVar, String str) throws MalformedCookieException {
        C5886a.m18894a(mVar, "Cookie");
        if (!C5894i.m18943b(str)) {
            mVar.mo33161f(str);
            return;
        }
        throw new MalformedCookieException("Blank or null value for domain attribute");
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
        return a.endsWith(d);
    }

    /* renamed from: a */
    public void mo33131a(C5679c cVar, C5682f fVar) throws MalformedCookieException {
        String a = fVar.mo33136a();
        String d = cVar.mo33127d();
        if (!a.equals(d) && !C5844f.m18757a(d, a)) {
            throw new CookieRestrictionViolationException("Illegal domain attribute \"" + d + "\". Domain of origin: \"" + a + "\"");
        } else if (a.contains(".")) {
            int countTokens = new StringTokenizer(d, ".").countTokens();
            if (m18814a(d)) {
                if (countTokens < 2) {
                    throw new CookieRestrictionViolationException("Domain attribute \"" + d + "\" violates the Netscape cookie specification for " + "special domains");
                }
            } else if (countTokens < 3) {
                throw new CookieRestrictionViolationException("Domain attribute \"" + d + "\" violates the Netscape cookie specification");
            }
        }
    }

    /* renamed from: a */
    private static boolean m18814a(String str) {
        String upperCase = str.toUpperCase(Locale.ROOT);
        return upperCase.endsWith(".COM") || upperCase.endsWith(".EDU") || upperCase.endsWith(".NET") || upperCase.endsWith(".GOV") || upperCase.endsWith(".MIL") || upperCase.endsWith(".ORG") || upperCase.endsWith(".INT");
    }
}
