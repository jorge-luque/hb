package p163cz.msebera.android.httpclient.impl.cookie;

import p163cz.msebera.android.httpclient.cookie.C5678b;
import p163cz.msebera.android.httpclient.cookie.C5679c;
import p163cz.msebera.android.httpclient.cookie.C5682f;
import p163cz.msebera.android.httpclient.cookie.C5690m;
import p163cz.msebera.android.httpclient.cookie.CookieRestrictionViolationException;
import p163cz.msebera.android.httpclient.cookie.MalformedCookieException;
import p163cz.msebera.android.httpclient.p187k0.C5886a;
import p163cz.msebera.android.httpclient.p187k0.C5894i;

/* renamed from: cz.msebera.android.httpclient.impl.cookie.i */
/* compiled from: BasicPathHandler */
public class C5850i implements C5678b {
    /* renamed from: a */
    public String mo33121a() {
        return "path";
    }

    /* renamed from: a */
    public void mo33132a(C5690m mVar, String str) throws MalformedCookieException {
        C5886a.m18894a(mVar, "Cookie");
        if (C5894i.m18943b(str)) {
            str = "/";
        }
        mVar.mo33159b(str);
    }

    /* renamed from: b */
    public boolean mo33133b(C5679c cVar, C5682f fVar) {
        C5886a.m18894a(cVar, "Cookie");
        C5886a.m18894a(fVar, "Cookie origin");
        return m18780a(fVar.mo33137b(), cVar.mo33126c());
    }

    /* renamed from: a */
    public void mo33131a(C5679c cVar, C5682f fVar) throws MalformedCookieException {
        if (!mo33133b(cVar, fVar)) {
            throw new CookieRestrictionViolationException("Illegal 'path' attribute \"" + cVar.mo33126c() + "\". Path of origin: \"" + fVar.mo33137b() + "\"");
        }
    }

    /* renamed from: a */
    static boolean m18780a(String str, String str2) {
        if (str2 == null) {
            str2 = "/";
        }
        if (str2.length() > 1 && str2.endsWith("/")) {
            str2 = str2.substring(0, str2.length() - 1);
        }
        return str.startsWith(str2) && (str2.equals("/") || str.length() == str2.length() || str.charAt(str2.length()) == '/');
    }
}
