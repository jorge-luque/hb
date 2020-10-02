package p163cz.msebera.android.httpclient.impl.conn;

import p163cz.msebera.android.httpclient.C5896l;
import p163cz.msebera.android.httpclient.conn.C5638p;
import p163cz.msebera.android.httpclient.conn.UnsupportedSchemeException;
import p163cz.msebera.android.httpclient.p187k0.C5886a;

/* renamed from: cz.msebera.android.httpclient.impl.conn.i */
/* compiled from: DefaultSchemePortResolver */
public class C5814i implements C5638p {

    /* renamed from: a */
    public static final C5814i f15010a = new C5814i();

    /* renamed from: a */
    public int mo33046a(C5896l lVar) throws UnsupportedSchemeException {
        C5886a.m18894a(lVar, "HTTP host");
        int c = lVar.mo33686c();
        if (c > 0) {
            return c;
        }
        String d = lVar.mo33688d();
        if (d.equalsIgnoreCase("http")) {
            return 80;
        }
        if (d.equalsIgnoreCase("https")) {
            return 443;
        }
        throw new UnsupportedSchemeException(d + " protocol is not supported");
    }
}
