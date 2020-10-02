package p163cz.msebera.android.httpclient.impl.client;

import java.security.Principal;
import p163cz.msebera.android.httpclient.auth.C5549c;
import p163cz.msebera.android.httpclient.auth.C5555h;
import p163cz.msebera.android.httpclient.auth.C5559l;
import p163cz.msebera.android.httpclient.client.C5586l;

/* renamed from: cz.msebera.android.httpclient.impl.client.q */
/* compiled from: DefaultUserTokenHandler */
public class C5796q implements C5586l {
    static {
        new C5796q();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x002a, code lost:
        r3 = ((p163cz.msebera.android.httpclient.conn.C5636n) r3).mo33040T();
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object mo32929a(p163cz.msebera.android.httpclient.p186j0.C5875e r3) {
        /*
            r2 = this;
            cz.msebera.android.httpclient.client.q.a r3 = p163cz.msebera.android.httpclient.client.p171q.C5606a.m17839a((p163cz.msebera.android.httpclient.p186j0.C5875e) r3)
            cz.msebera.android.httpclient.auth.h r0 = r3.mo32985o()
            if (r0 == 0) goto L_0x0019
            java.security.Principal r0 = m18516a((p163cz.msebera.android.httpclient.auth.C5555h) r0)
            if (r0 != 0) goto L_0x001a
            cz.msebera.android.httpclient.auth.h r0 = r3.mo32983m()
            java.security.Principal r0 = m18516a((p163cz.msebera.android.httpclient.auth.C5555h) r0)
            goto L_0x001a
        L_0x0019:
            r0 = 0
        L_0x001a:
            if (r0 != 0) goto L_0x0036
            cz.msebera.android.httpclient.i r3 = r3.mo33641a()
            boolean r1 = r3.isOpen()
            if (r1 == 0) goto L_0x0036
            boolean r1 = r3 instanceof p163cz.msebera.android.httpclient.conn.C5636n
            if (r1 == 0) goto L_0x0036
            cz.msebera.android.httpclient.conn.n r3 = (p163cz.msebera.android.httpclient.conn.C5636n) r3
            javax.net.ssl.SSLSession r3 = r3.mo33040T()
            if (r3 == 0) goto L_0x0036
            java.security.Principal r0 = r3.getLocalPrincipal()
        L_0x0036:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p163cz.msebera.android.httpclient.impl.client.C5796q.mo32929a(cz.msebera.android.httpclient.j0.e):java.lang.Object");
    }

    /* renamed from: a */
    private static Principal m18516a(C5555h hVar) {
        C5559l c;
        C5549c b = hVar.mo32858b();
        if (b == null || !b.mo32841c() || !b.mo32840b() || (c = hVar.mo32859c()) == null) {
            return null;
        }
        return c.mo32868a();
    }
}
