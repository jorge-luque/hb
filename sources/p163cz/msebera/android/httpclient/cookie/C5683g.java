package p163cz.msebera.android.httpclient.cookie;

import java.io.Serializable;
import java.util.Comparator;

/* renamed from: cz.msebera.android.httpclient.cookie.g */
/* compiled from: CookiePathComparator */
public class C5683g implements Serializable, Comparator<C5679c> {

    /* renamed from: a */
    public static final C5683g f14692a = new C5683g();
    private static final long serialVersionUID = 7523645369616405818L;

    /* renamed from: a */
    private String m18100a(C5679c cVar) {
        String c = cVar.mo33126c();
        if (c == null) {
            c = "/";
        }
        if (c.endsWith("/")) {
            return c;
        }
        return c + '/';
    }

    /* renamed from: a */
    public int compare(C5679c cVar, C5679c cVar2) {
        String a = m18100a(cVar);
        String a2 = m18100a(cVar2);
        if (a.equals(a2)) {
            return 0;
        }
        if (a.startsWith(a2)) {
            return -1;
        }
        if (a2.startsWith(a)) {
            return 1;
        }
        return 0;
    }
}
