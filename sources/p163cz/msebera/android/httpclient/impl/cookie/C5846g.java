package p163cz.msebera.android.httpclient.impl.cookie;

import java.util.Date;
import p163cz.msebera.android.httpclient.client.p172r.C5617b;
import p163cz.msebera.android.httpclient.cookie.C5678b;
import p163cz.msebera.android.httpclient.cookie.C5690m;
import p163cz.msebera.android.httpclient.cookie.MalformedCookieException;
import p163cz.msebera.android.httpclient.p187k0.C5886a;

/* renamed from: cz.msebera.android.httpclient.impl.cookie.g */
/* compiled from: BasicExpiresHandler */
public class C5846g extends C5834a implements C5678b {

    /* renamed from: a */
    private final String[] f15080a;

    public C5846g(String[] strArr) {
        C5886a.m18894a(strArr, "Array of date patterns");
        this.f15080a = strArr;
    }

    /* renamed from: a */
    public String mo33121a() {
        return "expires";
    }

    /* renamed from: a */
    public void mo33132a(C5690m mVar, String str) throws MalformedCookieException {
        C5886a.m18894a(mVar, "Cookie");
        if (str != null) {
            Date a = C5617b.m17867a(str, this.f15080a);
            if (a != null) {
                mVar.mo33157a(a);
                return;
            }
            throw new MalformedCookieException("Invalid 'expires' attribute: " + str);
        }
        throw new MalformedCookieException("Missing value for 'expires' attribute");
    }
}
