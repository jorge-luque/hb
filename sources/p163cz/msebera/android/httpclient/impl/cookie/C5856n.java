package p163cz.msebera.android.httpclient.impl.cookie;

import p163cz.msebera.android.httpclient.cookie.C5684h;
import p163cz.msebera.android.httpclient.cookie.C5685i;
import p163cz.msebera.android.httpclient.cookie.C5686j;
import p163cz.msebera.android.httpclient.p186j0.C5875e;

@Deprecated
/* renamed from: cz.msebera.android.httpclient.impl.cookie.n */
/* compiled from: BrowserCompatSpecFactory */
public class C5856n implements C5685i, C5686j {

    /* renamed from: a */
    private final C5857a f15084a;

    /* renamed from: b */
    private final C5684h f15085b;

    /* renamed from: cz.msebera.android.httpclient.impl.cookie.n$a */
    /* compiled from: BrowserCompatSpecFactory */
    public enum C5857a {
        SECURITYLEVEL_DEFAULT,
        SECURITYLEVEL_IE_MEDIUM;

        static {
            SECURITYLEVEL_DEFAULT = new C5857a("SECURITYLEVEL_DEFAULT", 0);
            SECURITYLEVEL_IE_MEDIUM = new C5857a("SECURITYLEVEL_IE_MEDIUM", 1);
        }
    }

    public C5856n(String[] strArr, C5857a aVar) {
        this.f15084a = aVar;
        this.f15085b = new C5854m(strArr, aVar);
    }

    /* JADX WARNING: type inference failed for: r3v5, types: [java.lang.Object[]] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public p163cz.msebera.android.httpclient.cookie.C5684h mo33149a(p163cz.msebera.android.httpclient.p183h0.C5759e r3) {
        /*
            r2 = this;
            r0 = 0
            if (r3 == 0) goto L_0x0022
            java.lang.String r1 = "http.protocol.cookie-datepatterns"
            java.lang.Object r3 = r3.mo33425b(r1)
            java.util.Collection r3 = (java.util.Collection) r3
            if (r3 == 0) goto L_0x001a
            int r0 = r3.size()
            java.lang.String[] r0 = new java.lang.String[r0]
            java.lang.Object[] r3 = r3.toArray(r0)
            r0 = r3
            java.lang.String[] r0 = (java.lang.String[]) r0
        L_0x001a:
            cz.msebera.android.httpclient.impl.cookie.m r3 = new cz.msebera.android.httpclient.impl.cookie.m
            cz.msebera.android.httpclient.impl.cookie.n$a r1 = r2.f15084a
            r3.<init>(r0, r1)
            return r3
        L_0x0022:
            cz.msebera.android.httpclient.impl.cookie.m r3 = new cz.msebera.android.httpclient.impl.cookie.m
            cz.msebera.android.httpclient.impl.cookie.n$a r1 = r2.f15084a
            r3.<init>(r0, r1)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: p163cz.msebera.android.httpclient.impl.cookie.C5856n.mo33149a(cz.msebera.android.httpclient.h0.e):cz.msebera.android.httpclient.cookie.h");
    }

    public C5856n() {
        this((String[]) null, C5857a.SECURITYLEVEL_DEFAULT);
    }

    /* renamed from: a */
    public C5684h mo33150a(C5875e eVar) {
        return this.f15085b;
    }
}
