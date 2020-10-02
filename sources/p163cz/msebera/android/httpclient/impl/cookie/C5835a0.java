package p163cz.msebera.android.httpclient.impl.cookie;

import p163cz.msebera.android.httpclient.cookie.C5678b;
import p163cz.msebera.android.httpclient.cookie.C5679c;
import p163cz.msebera.android.httpclient.cookie.C5682f;
import p163cz.msebera.android.httpclient.cookie.C5690m;
import p163cz.msebera.android.httpclient.cookie.CookieRestrictionViolationException;
import p163cz.msebera.android.httpclient.cookie.MalformedCookieException;
import p163cz.msebera.android.httpclient.p187k0.C5886a;

/* renamed from: cz.msebera.android.httpclient.impl.cookie.a0 */
/* compiled from: RFC2109VersionHandler */
public class C5835a0 extends C5834a implements C5678b {
    /* renamed from: a */
    public String mo33121a() {
        return "version";
    }

    /* renamed from: a */
    public void mo33132a(C5690m mVar, String str) throws MalformedCookieException {
        C5886a.m18894a(mVar, "Cookie");
        if (str == null) {
            throw new MalformedCookieException("Missing value for version attribute");
        } else if (!str.trim().isEmpty()) {
            try {
                mVar.mo33156a(Integer.parseInt(str));
            } catch (NumberFormatException e) {
                throw new MalformedCookieException("Invalid version: " + e.getMessage());
            }
        } else {
            throw new MalformedCookieException("Blank value for version attribute");
        }
    }

    /* renamed from: a */
    public void mo33131a(C5679c cVar, C5682f fVar) throws MalformedCookieException {
        C5886a.m18894a(cVar, "Cookie");
        if (cVar.getVersion() < 0) {
            throw new CookieRestrictionViolationException("Cookie version may not be negative");
        }
    }
}
