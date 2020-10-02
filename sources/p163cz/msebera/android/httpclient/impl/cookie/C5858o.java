package p163cz.msebera.android.httpclient.impl.cookie;

import p163cz.msebera.android.httpclient.cookie.C5678b;
import p163cz.msebera.android.httpclient.cookie.C5690m;
import p163cz.msebera.android.httpclient.cookie.MalformedCookieException;
import p163cz.msebera.android.httpclient.p187k0.C5886a;

/* renamed from: cz.msebera.android.httpclient.impl.cookie.o */
/* compiled from: BrowserCompatVersionAttributeHandler */
public class C5858o extends C5834a implements C5678b {
    /* renamed from: a */
    public String mo33121a() {
        return "version";
    }

    /* renamed from: a */
    public void mo33132a(C5690m mVar, String str) throws MalformedCookieException {
        C5886a.m18894a(mVar, "Cookie");
        if (str != null) {
            int i = 0;
            try {
                i = Integer.parseInt(str);
            } catch (NumberFormatException unused) {
            }
            mVar.mo33156a(i);
            return;
        }
        throw new MalformedCookieException("Missing value for version attribute");
    }
}
