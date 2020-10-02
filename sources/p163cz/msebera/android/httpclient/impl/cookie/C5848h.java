package p163cz.msebera.android.httpclient.impl.cookie;

import java.util.Date;
import p163cz.msebera.android.httpclient.cookie.C5678b;
import p163cz.msebera.android.httpclient.cookie.C5690m;
import p163cz.msebera.android.httpclient.cookie.MalformedCookieException;
import p163cz.msebera.android.httpclient.p187k0.C5886a;

/* renamed from: cz.msebera.android.httpclient.impl.cookie.h */
/* compiled from: BasicMaxAgeHandler */
public class C5848h extends C5834a implements C5678b {
    /* renamed from: a */
    public String mo33121a() {
        return "max-age";
    }

    /* renamed from: a */
    public void mo33132a(C5690m mVar, String str) throws MalformedCookieException {
        C5886a.m18894a(mVar, "Cookie");
        if (str != null) {
            try {
                int parseInt = Integer.parseInt(str);
                if (parseInt >= 0) {
                    mVar.mo33157a(new Date(System.currentTimeMillis() + (((long) parseInt) * 1000)));
                    return;
                }
                throw new MalformedCookieException("Negative 'max-age' attribute: " + str);
            } catch (NumberFormatException unused) {
                throw new MalformedCookieException("Invalid 'max-age' attribute: " + str);
            }
        } else {
            throw new MalformedCookieException("Missing value for 'max-age' attribute");
        }
    }
}
