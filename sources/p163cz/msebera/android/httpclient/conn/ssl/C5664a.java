package p163cz.msebera.android.httpclient.conn.ssl;

import com.tapjoy.TJAdUnitConstants;
import java.io.IOException;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import p163cz.msebera.android.httpclient.conn.p176t.C5676a;
import p163cz.msebera.android.httpclient.p177d0.C5695b;
import p163cz.msebera.android.httpclient.p187k0.C5886a;

@Deprecated
/* renamed from: cz.msebera.android.httpclient.conn.ssl.a */
/* compiled from: AbstractVerifier */
public abstract class C5664a implements C5675k {

    /* renamed from: b */
    static final String[] f14663b;

    /* renamed from: a */
    public C5695b f14664a = new C5695b(getClass());

    static {
        String[] strArr = {"ac", "co", "com", "ed", "edu", "go", "gouv", "gov", TJAdUnitConstants.String.VIDEO_INFO, "lg", "ne", "net", "or", "org"};
        f14663b = strArr;
        Arrays.sort(strArr);
    }

    /* JADX WARNING: type inference failed for: r6v7, types: [java.lang.Object[]] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void mo33099a(java.lang.String r5, java.security.cert.X509Certificate r6) throws javax.net.ssl.SSLException {
        /*
            r4 = this;
            boolean r0 = p163cz.msebera.android.httpclient.conn.p176t.C5676a.m18079a(r5)
            boolean r1 = p163cz.msebera.android.httpclient.conn.p176t.C5676a.m18080b(r5)
            if (r0 != 0) goto L_0x000f
            if (r1 == 0) goto L_0x000d
            goto L_0x000f
        L_0x000d:
            r0 = 2
            goto L_0x0010
        L_0x000f:
            r0 = 7
        L_0x0010:
            java.util.List r0 = p163cz.msebera.android.httpclient.conn.ssl.C5667d.m18049a(r6, r0)
            javax.security.auth.x500.X500Principal r6 = r6.getSubjectX500Principal()
            cz.msebera.android.httpclient.conn.ssl.e r1 = new cz.msebera.android.httpclient.conn.ssl.e
            r1.<init>(r6)
            java.lang.String r6 = "cn"
            java.lang.String r6 = r1.mo33106a((java.lang.String) r6)
            r1 = 0
            if (r6 == 0) goto L_0x002d
            r2 = 1
            java.lang.String[] r2 = new java.lang.String[r2]
            r3 = 0
            r2[r3] = r6
            goto L_0x002e
        L_0x002d:
            r2 = r1
        L_0x002e:
            if (r0 == 0) goto L_0x0043
            boolean r6 = r0.isEmpty()
            if (r6 != 0) goto L_0x0043
            int r6 = r0.size()
            java.lang.String[] r6 = new java.lang.String[r6]
            java.lang.Object[] r6 = r0.toArray(r6)
            r1 = r6
            java.lang.String[] r1 = (java.lang.String[]) r1
        L_0x0043:
            r4.verify(r5, r2, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p163cz.msebera.android.httpclient.conn.ssl.C5664a.mo33099a(java.lang.String, java.security.cert.X509Certificate):void");
    }

    public final void verify(String str, SSLSocket sSLSocket) throws IOException {
        C5886a.m18894a(str, "Host");
        SSLSession session = sSLSocket.getSession();
        if (session == null) {
            sSLSocket.getInputStream().available();
            session = sSLSocket.getSession();
            if (session == null) {
                sSLSocket.startHandshake();
                session = sSLSocket.getSession();
            }
        }
        mo33099a(str, (X509Certificate) session.getPeerCertificates()[0]);
    }

    /* renamed from: a */
    public final void mo33100a(String str, String[] strArr, String[] strArr2, boolean z) throws SSLException {
        List<String> list = null;
        String str2 = (strArr == null || strArr.length <= 0) ? null : strArr[0];
        if (strArr2 != null && strArr2.length > 0) {
            list = Arrays.asList(strArr2);
        }
        String a = C5676a.m18080b(str) ? C5667d.m18048a(str.toLowerCase(Locale.ROOT)) : str;
        if (list != null) {
            for (String str3 : list) {
                if (C5676a.m18080b(str3)) {
                    str3 = C5667d.m18048a(str3);
                }
                if (m18044a(a, str3, z)) {
                    return;
                }
            }
            throw new SSLException("Certificate for <" + str + "> doesn't match any " + "of the subject alternative names: " + list);
        } else if (str2 != null) {
            if (!m18044a(a, C5676a.m18080b(str2) ? C5667d.m18048a(str2) : str2, z)) {
                throw new SSLException("Certificate for <" + str + "> doesn't match " + "common name of the certificate subject: " + str2);
            }
        } else {
            throw new SSLException("Certificate subject for <" + str + "> doesn't contain " + "a common name and does not have alternative names");
        }
    }

    public final boolean verify(String str, SSLSession sSLSession) {
        try {
            mo33099a(str, (X509Certificate) sSLSession.getPeerCertificates()[0]);
            return true;
        } catch (SSLException e) {
            if (this.f14664a.mo33168a()) {
                this.f14664a.mo33167a(e.getMessage(), e);
            }
            return false;
        }
    }

    /* renamed from: a */
    private static boolean m18044a(String str, String str2, boolean z) {
        boolean z2;
        if (str == null) {
            return false;
        }
        String lowerCase = str.toLowerCase(Locale.ROOT);
        String lowerCase2 = str2.toLowerCase(Locale.ROOT);
        String[] split = lowerCase2.split("\\.");
        if (!(split.length >= 3 && split[0].endsWith("*") && (!z || m18045a(split)))) {
            return lowerCase.equals(lowerCase2);
        }
        String str3 = split[0];
        if (str3.length() > 1) {
            String substring = str3.substring(0, str3.length() - 1);
            z2 = lowerCase.startsWith(substring) && lowerCase.substring(substring.length()).endsWith(lowerCase2.substring(str3.length()));
        } else {
            z2 = lowerCase.endsWith(lowerCase2.substring(1));
        }
        if (!z2) {
            return false;
        }
        if (!z || m18043a(lowerCase) == m18043a(lowerCase2)) {
            return true;
        }
        return false;
    }

    /* renamed from: a */
    private static boolean m18045a(String[] strArr) {
        if (strArr.length == 3 && strArr[2].length() == 2 && Arrays.binarySearch(f14663b, strArr[1]) >= 0) {
            return false;
        }
        return true;
    }

    /* renamed from: a */
    public static int m18043a(String str) {
        int i = 0;
        for (int i2 = 0; i2 < str.length(); i2++) {
            if (str.charAt(i2) == '.') {
                i++;
            }
        }
        return i;
    }
}
