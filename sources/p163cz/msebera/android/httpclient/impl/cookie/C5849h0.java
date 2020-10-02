package p163cz.msebera.android.httpclient.impl.cookie;

import p163cz.msebera.android.httpclient.cookie.C5677a;
import p163cz.msebera.android.httpclient.cookie.C5678b;
import p163cz.msebera.android.httpclient.cookie.C5679c;
import p163cz.msebera.android.httpclient.cookie.C5682f;
import p163cz.msebera.android.httpclient.cookie.C5689l;
import p163cz.msebera.android.httpclient.cookie.C5690m;
import p163cz.msebera.android.httpclient.cookie.CookieRestrictionViolationException;
import p163cz.msebera.android.httpclient.cookie.MalformedCookieException;
import p163cz.msebera.android.httpclient.p187k0.C5886a;

/* renamed from: cz.msebera.android.httpclient.impl.cookie.h0 */
/* compiled from: RFC2965VersionAttributeHandler */
public class C5849h0 implements C5678b {
    /* renamed from: a */
    public String mo33121a() {
        return "version";
    }

    /* renamed from: a */
    public void mo33132a(C5690m mVar, String str) throws MalformedCookieException {
        int i;
        C5886a.m18894a(mVar, "Cookie");
        if (str != null) {
            try {
                i = Integer.parseInt(str);
            } catch (NumberFormatException unused) {
                i = -1;
            }
            if (i >= 0) {
                mVar.mo33156a(i);
                return;
            }
            throw new MalformedCookieException("Invalid cookie version.");
        }
        throw new MalformedCookieException("Missing value for version attribute");
    }

    /* renamed from: b */
    public boolean mo33133b(C5679c cVar, C5682f fVar) {
        return true;
    }

    /* renamed from: a */
    public void mo33131a(C5679c cVar, C5682f fVar) throws MalformedCookieException {
        C5886a.m18894a(cVar, "Cookie");
        if ((cVar instanceof C5689l) && (cVar instanceof C5677a) && !((C5677a) cVar).mo33120c("version")) {
            throw new CookieRestrictionViolationException("Violates RFC 2965. Version attribute is required.");
        }
    }
}
