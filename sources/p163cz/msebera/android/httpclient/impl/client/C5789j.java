package p163cz.msebera.android.httpclient.impl.client;

import p163cz.msebera.android.httpclient.C5696e;
import p163cz.msebera.android.httpclient.C5901q;
import p163cz.msebera.android.httpclient.conn.C5628f;
import p163cz.msebera.android.httpclient.p182g0.C5734d;
import p163cz.msebera.android.httpclient.p186j0.C5875e;
import p163cz.msebera.android.httpclient.p187k0.C5886a;

/* renamed from: cz.msebera.android.httpclient.impl.client.j */
/* compiled from: DefaultConnectionKeepAliveStrategy */
public class C5789j implements C5628f {
    static {
        new C5789j();
    }

    /* renamed from: a */
    public long mo33019a(C5901q qVar, C5875e eVar) {
        C5886a.m18894a(qVar, "HTTP response");
        C5734d dVar = new C5734d(qVar.headerIterator("Keep-Alive"));
        while (dVar.hasNext()) {
            C5696e nextElement = dVar.nextElement();
            String name = nextElement.getName();
            String value = nextElement.getValue();
            if (value != null && name.equalsIgnoreCase("timeout")) {
                try {
                    return Long.parseLong(value) * 1000;
                } catch (NumberFormatException unused) {
                }
            }
        }
        return -1;
    }
}
