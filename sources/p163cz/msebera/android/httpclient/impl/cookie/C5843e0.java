package p163cz.msebera.android.httpclient.impl.cookie;

import java.util.StringTokenizer;
import p163cz.msebera.android.httpclient.cookie.C5677a;
import p163cz.msebera.android.httpclient.cookie.C5678b;
import p163cz.msebera.android.httpclient.cookie.C5679c;
import p163cz.msebera.android.httpclient.cookie.C5682f;
import p163cz.msebera.android.httpclient.cookie.C5689l;
import p163cz.msebera.android.httpclient.cookie.C5690m;
import p163cz.msebera.android.httpclient.cookie.CookieRestrictionViolationException;
import p163cz.msebera.android.httpclient.cookie.MalformedCookieException;
import p163cz.msebera.android.httpclient.p187k0.C5886a;

/* renamed from: cz.msebera.android.httpclient.impl.cookie.e0 */
/* compiled from: RFC2965PortAttributeHandler */
public class C5843e0 implements C5678b {
    /* renamed from: a */
    private static int[] m18752a(String str) throws MalformedCookieException {
        StringTokenizer stringTokenizer = new StringTokenizer(str, ",");
        int[] iArr = new int[stringTokenizer.countTokens()];
        int i = 0;
        while (stringTokenizer.hasMoreTokens()) {
            try {
                iArr[i] = Integer.parseInt(stringTokenizer.nextToken().trim());
                if (iArr[i] >= 0) {
                    i++;
                } else {
                    throw new MalformedCookieException("Invalid Port attribute.");
                }
            } catch (NumberFormatException e) {
                throw new MalformedCookieException("Invalid Port attribute: " + e.getMessage());
            }
        }
        return iArr;
    }

    /* renamed from: a */
    public String mo33121a() {
        return "port";
    }

    /* renamed from: b */
    public boolean mo33133b(C5679c cVar, C5682f fVar) {
        C5886a.m18894a(cVar, "Cookie");
        C5886a.m18894a(fVar, "Cookie origin");
        int c = fVar.mo33138c();
        if (!(cVar instanceof C5677a) || !((C5677a) cVar).mo33120c("port")) {
            return true;
        }
        if (cVar.mo33123a() != null && m18751a(c, cVar.mo33123a())) {
            return true;
        }
        return false;
    }

    /* renamed from: a */
    private static boolean m18751a(int i, int[] iArr) {
        for (int i2 : iArr) {
            if (i == i2) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    public void mo33132a(C5690m mVar, String str) throws MalformedCookieException {
        C5886a.m18894a(mVar, "Cookie");
        if (mVar instanceof C5689l) {
            C5689l lVar = (C5689l) mVar;
            if (str != null && !str.trim().isEmpty()) {
                lVar.mo33153a(m18752a(str));
            }
        }
    }

    /* renamed from: a */
    public void mo33131a(C5679c cVar, C5682f fVar) throws MalformedCookieException {
        C5886a.m18894a(cVar, "Cookie");
        C5886a.m18894a(fVar, "Cookie origin");
        int c = fVar.mo33138c();
        if ((cVar instanceof C5677a) && ((C5677a) cVar).mo33120c("port") && !m18751a(c, cVar.mo33123a())) {
            throw new CookieRestrictionViolationException("Port attribute violates RFC 2965: Request port not found in cookie's port list.");
        }
    }
}
