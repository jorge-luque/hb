package p163cz.msebera.android.httpclient.cookie;

import java.io.Serializable;
import java.util.Comparator;

/* renamed from: cz.msebera.android.httpclient.cookie.e */
/* compiled from: CookieIdentityComparator */
public class C5681e implements Serializable, Comparator<C5679c> {
    private static final long serialVersionUID = 4466565437490631532L;

    /* renamed from: a */
    public int compare(C5679c cVar, C5679c cVar2) {
        int compareTo = cVar.getName().compareTo(cVar2.getName());
        if (compareTo == 0) {
            String d = cVar.mo33127d();
            String str = "";
            if (d == null) {
                d = str;
            } else if (d.indexOf(46) == -1) {
                d = d + ".local";
            }
            String d2 = cVar2.mo33127d();
            if (d2 != null) {
                if (d2.indexOf(46) == -1) {
                    str = d2 + ".local";
                } else {
                    str = d2;
                }
            }
            compareTo = d.compareToIgnoreCase(str);
        }
        if (compareTo != 0) {
            return compareTo;
        }
        String c = cVar.mo33126c();
        String str2 = "/";
        if (c == null) {
            c = str2;
        }
        String c2 = cVar2.mo33126c();
        if (c2 != null) {
            str2 = c2;
        }
        return c.compareTo(str2);
    }
}
