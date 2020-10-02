package p163cz.msebera.android.httpclient.conn.ssl;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.net.ssl.HostnameVerifier;

/* renamed from: cz.msebera.android.httpclient.conn.ssl.d */
/* compiled from: DefaultHostnameVerifier */
public final class C5667d implements HostnameVerifier {
    /* renamed from: a */
    static List<String> m18049a(X509Certificate x509Certificate, int i) {
        Collection<List<?>> collection;
        ArrayList arrayList = null;
        try {
            collection = x509Certificate.getSubjectAlternativeNames();
        } catch (CertificateParsingException unused) {
            collection = null;
        }
        if (collection != null) {
            for (List next : collection) {
                if (((Integer) next.get(0)).intValue() == i) {
                    String str = (String) next.get(1);
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(str);
                }
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    static String m18048a(String str) {
        if (str == null) {
            return str;
        }
        try {
            return InetAddress.getByName(str).getHostAddress();
        } catch (UnknownHostException unused) {
            return str;
        }
    }
}
