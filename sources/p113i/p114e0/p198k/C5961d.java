package p113i.p114e0.p198k;

import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;
import p113i.p114e0.C3500c;

/* renamed from: i.e0.k.d */
/* compiled from: OkHostnameVerifier */
public final class C5961d implements HostnameVerifier {

    /* renamed from: a */
    public static final C5961d f15230a = new C5961d();

    private C5961d() {
    }

    /* renamed from: b */
    private boolean m19117b(String str, X509Certificate x509Certificate) {
        String lowerCase = str.toLowerCase(Locale.US);
        for (String a : m19116a(x509Certificate, 2)) {
            if (mo33772a(lowerCase, a)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: c */
    private boolean m19118c(String str, X509Certificate x509Certificate) {
        List<String> a = m19116a(x509Certificate, 7);
        int size = a.size();
        for (int i = 0; i < size; i++) {
            if (str.equalsIgnoreCase(a.get(i))) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    public boolean mo33773a(String str, X509Certificate x509Certificate) {
        if (C3500c.m11666d(str)) {
            return m19118c(str, x509Certificate);
        }
        return m19117b(str, x509Certificate);
    }

    public boolean verify(String str, SSLSession sSLSession) {
        try {
            return mo33773a(str, (X509Certificate) sSLSession.getPeerCertificates()[0]);
        } catch (SSLException unused) {
            return false;
        }
    }

    /* renamed from: a */
    public static List<String> m19115a(X509Certificate x509Certificate) {
        List<String> a = m19116a(x509Certificate, 7);
        List<String> a2 = m19116a(x509Certificate, 2);
        ArrayList arrayList = new ArrayList(a.size() + a2.size());
        arrayList.addAll(a);
        arrayList.addAll(a2);
        return arrayList;
    }

    /* renamed from: a */
    private static List<String> m19116a(X509Certificate x509Certificate, int i) {
        String str;
        ArrayList arrayList = new ArrayList();
        try {
            Collection<List<?>> subjectAlternativeNames = x509Certificate.getSubjectAlternativeNames();
            if (subjectAlternativeNames == null) {
                return Collections.emptyList();
            }
            for (List next : subjectAlternativeNames) {
                if (next != null) {
                    if (next.size() >= 2) {
                        Integer num = (Integer) next.get(0);
                        if (num != null) {
                            if (num.intValue() == i && (str = (String) next.get(1)) != null) {
                                arrayList.add(str);
                            }
                        }
                    }
                }
            }
            return arrayList;
        } catch (CertificateParsingException unused) {
            return Collections.emptyList();
        }
    }

    /* renamed from: a */
    public boolean mo33772a(String str, String str2) {
        if (str != null && str.length() != 0 && !str.startsWith(".") && !str.endsWith("..") && str2 != null && str2.length() != 0 && !str2.startsWith(".") && !str2.endsWith("..")) {
            if (!str.endsWith(".")) {
                str = str + '.';
            }
            if (!str2.endsWith(".")) {
                str2 = str2 + '.';
            }
            String lowerCase = str2.toLowerCase(Locale.US);
            if (!lowerCase.contains("*")) {
                return str.equals(lowerCase);
            }
            if (!lowerCase.startsWith("*.") || lowerCase.indexOf(42, 1) != -1 || str.length() < lowerCase.length() || "*.".equals(lowerCase)) {
                return false;
            }
            String substring = lowerCase.substring(1);
            if (!str.endsWith(substring)) {
                return false;
            }
            int length = str.length() - substring.length();
            if (length <= 0 || str.lastIndexOf(46, length - 1) == -1) {
                return true;
            }
            return false;
        }
        return false;
    }
}
