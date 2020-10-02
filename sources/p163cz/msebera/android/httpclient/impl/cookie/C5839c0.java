package p163cz.msebera.android.httpclient.impl.cookie;

import p163cz.msebera.android.httpclient.cookie.C5678b;
import p163cz.msebera.android.httpclient.cookie.C5679c;
import p163cz.msebera.android.httpclient.cookie.C5682f;
import p163cz.msebera.android.httpclient.cookie.C5689l;
import p163cz.msebera.android.httpclient.cookie.C5690m;
import p163cz.msebera.android.httpclient.cookie.MalformedCookieException;

/* renamed from: cz.msebera.android.httpclient.impl.cookie.c0 */
/* compiled from: RFC2965DiscardAttributeHandler */
public class C5839c0 implements C5678b {
    /* renamed from: a */
    public String mo33121a() {
        return "discard";
    }

    /* renamed from: a */
    public void mo33131a(C5679c cVar, C5682f fVar) throws MalformedCookieException {
    }

    /* renamed from: a */
    public void mo33132a(C5690m mVar, String str) throws MalformedCookieException {
        if (mVar instanceof C5689l) {
            ((C5689l) mVar).mo33154b(true);
        }
    }

    /* renamed from: b */
    public boolean mo33133b(C5679c cVar, C5682f fVar) {
        return true;
    }
}
