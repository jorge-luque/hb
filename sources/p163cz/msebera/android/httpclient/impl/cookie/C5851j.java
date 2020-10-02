package p163cz.msebera.android.httpclient.impl.cookie;

import p163cz.msebera.android.httpclient.cookie.C5678b;
import p163cz.msebera.android.httpclient.cookie.C5679c;
import p163cz.msebera.android.httpclient.cookie.C5682f;
import p163cz.msebera.android.httpclient.cookie.C5690m;
import p163cz.msebera.android.httpclient.cookie.MalformedCookieException;
import p163cz.msebera.android.httpclient.p187k0.C5886a;

/* renamed from: cz.msebera.android.httpclient.impl.cookie.j */
/* compiled from: BasicSecureHandler */
public class C5851j extends C5834a implements C5678b {
    /* renamed from: a */
    public String mo33121a() {
        return "secure";
    }

    /* renamed from: a */
    public void mo33132a(C5690m mVar, String str) throws MalformedCookieException {
        C5886a.m18894a(mVar, "Cookie");
        mVar.mo33158a(true);
    }

    /* renamed from: b */
    public boolean mo33133b(C5679c cVar, C5682f fVar) {
        C5886a.m18894a(cVar, "Cookie");
        C5886a.m18894a(fVar, "Cookie origin");
        return !cVar.mo33122B() || fVar.mo33139d();
    }
}
