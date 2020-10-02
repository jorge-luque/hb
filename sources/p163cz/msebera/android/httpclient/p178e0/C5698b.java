package p163cz.msebera.android.httpclient.p178e0;

import p163cz.msebera.android.httpclient.C5545a;
import p163cz.msebera.android.httpclient.C5901q;

/* renamed from: cz.msebera.android.httpclient.e0.b */
/* compiled from: DefaultConnectionReuseStrategy */
public class C5698b implements C5545a {
    static {
        new C5698b();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0042, code lost:
        if (java.lang.Integer.parseInt(r0[0].getValue()) < 0) goto L_0x0044;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean mo32832a(p163cz.msebera.android.httpclient.C5901q r6, p163cz.msebera.android.httpclient.p186j0.C5875e r7) {
        /*
            r5 = this;
            java.lang.String r0 = "HTTP response"
            p163cz.msebera.android.httpclient.p187k0.C5886a.m18894a(r6, (java.lang.String) r0)
            java.lang.String r0 = "HTTP context"
            p163cz.msebera.android.httpclient.p187k0.C5886a.m18894a(r7, (java.lang.String) r0)
            cz.msebera.android.httpclient.y r7 = r6.mo33335a()
            cz.msebera.android.httpclient.v r7 = r7.getProtocolVersion()
            java.lang.String r0 = "Transfer-Encoding"
            cz.msebera.android.httpclient.d r0 = r6.getFirstHeader(r0)
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x0029
            java.lang.String r0 = r0.getValue()
            java.lang.String r3 = "chunked"
            boolean r0 = r3.equalsIgnoreCase(r0)
            if (r0 != 0) goto L_0x0045
            return r2
        L_0x0029:
            boolean r0 = r5.m18156a(r6)
            if (r0 == 0) goto L_0x0045
            java.lang.String r0 = "Content-Length"
            cz.msebera.android.httpclient.d[] r0 = r6.getHeaders(r0)
            int r3 = r0.length
            if (r3 != r1) goto L_0x0044
            r0 = r0[r2]
            java.lang.String r0 = r0.getValue()     // Catch:{ NumberFormatException -> 0x0044 }
            int r0 = java.lang.Integer.parseInt(r0)     // Catch:{ NumberFormatException -> 0x0044 }
            if (r0 >= 0) goto L_0x0045
        L_0x0044:
            return r2
        L_0x0045:
            java.lang.String r0 = "Connection"
            cz.msebera.android.httpclient.d[] r0 = r6.getHeaders(r0)
            int r3 = r0.length
            if (r3 != 0) goto L_0x0054
            java.lang.String r0 = "Proxy-Connection"
            cz.msebera.android.httpclient.d[] r0 = r6.getHeaders(r0)
        L_0x0054:
            int r6 = r0.length
            if (r6 == 0) goto L_0x0084
            cz.msebera.android.httpclient.g0.p r6 = new cz.msebera.android.httpclient.g0.p     // Catch:{ ParseException -> 0x0083 }
            cz.msebera.android.httpclient.g0.e r3 = new cz.msebera.android.httpclient.g0.e     // Catch:{ ParseException -> 0x0083 }
            r4 = 0
            r3.<init>(r0, r4)     // Catch:{ ParseException -> 0x0083 }
            r6.<init>(r3)     // Catch:{ ParseException -> 0x0083 }
            r0 = 0
        L_0x0063:
            boolean r3 = r6.hasNext()     // Catch:{ ParseException -> 0x0083 }
            if (r3 == 0) goto L_0x0080
            java.lang.String r3 = r6.nextToken()     // Catch:{ ParseException -> 0x0083 }
            java.lang.String r4 = "Close"
            boolean r4 = r4.equalsIgnoreCase(r3)     // Catch:{ ParseException -> 0x0083 }
            if (r4 == 0) goto L_0x0076
            return r2
        L_0x0076:
            java.lang.String r4 = "Keep-Alive"
            boolean r3 = r4.equalsIgnoreCase(r3)     // Catch:{ ParseException -> 0x0083 }
            if (r3 == 0) goto L_0x0063
            r0 = 1
            goto L_0x0063
        L_0x0080:
            if (r0 == 0) goto L_0x0084
            return r1
        L_0x0083:
            return r2
        L_0x0084:
            cz.msebera.android.httpclient.t r6 = p163cz.msebera.android.httpclient.C5905t.f15129e
            boolean r6 = r7.mo33701c(r6)
            r6 = r6 ^ r1
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: p163cz.msebera.android.httpclient.p178e0.C5698b.mo32832a(cz.msebera.android.httpclient.q, cz.msebera.android.httpclient.j0.e):boolean");
    }

    /* renamed from: a */
    private boolean m18156a(C5901q qVar) {
        int a = qVar.mo33335a().mo33371a();
        return (a < 200 || a == 204 || a == 304 || a == 205) ? false : true;
    }
}
