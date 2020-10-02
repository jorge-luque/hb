package p113i;

import admost.sdk.listener.AdMostAdListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* renamed from: i.h */
/* compiled from: CipherSuite */
public final class C5964h {

    /* renamed from: b */
    static final Comparator<String> f15231b = new C5965a();

    /* renamed from: c */
    private static final Map<String, C5964h> f15232c = new LinkedHashMap();

    /* renamed from: d */
    public static final C5964h f15233d = m19123a("SSL_RSA_WITH_3DES_EDE_CBC_SHA", 10);

    /* renamed from: e */
    public static final C5964h f15234e = m19123a("TLS_RSA_WITH_AES_128_CBC_SHA", 47);

    /* renamed from: f */
    public static final C5964h f15235f = m19123a("TLS_RSA_WITH_AES_256_CBC_SHA", 53);

    /* renamed from: g */
    public static final C5964h f15236g = m19123a("TLS_RSA_WITH_AES_128_GCM_SHA256", 156);

    /* renamed from: h */
    public static final C5964h f15237h = m19123a("TLS_RSA_WITH_AES_256_GCM_SHA384", 157);

    /* renamed from: i */
    public static final C5964h f15238i = m19123a("TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA", 49171);

    /* renamed from: j */
    public static final C5964h f15239j = m19123a("TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA", 49172);

    /* renamed from: k */
    public static final C5964h f15240k = m19123a("TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256", 49195);

    /* renamed from: l */
    public static final C5964h f15241l = m19123a("TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384", 49196);

    /* renamed from: m */
    public static final C5964h f15242m = m19123a("TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256", 49199);

    /* renamed from: n */
    public static final C5964h f15243n = m19123a("TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384", 49200);

    /* renamed from: o */
    public static final C5964h f15244o = m19123a("TLS_ECDHE_RSA_WITH_CHACHA20_POLY1305_SHA256", 52392);

    /* renamed from: p */
    public static final C5964h f15245p = m19123a("TLS_ECDHE_ECDSA_WITH_CHACHA20_POLY1305_SHA256", 52393);

    /* renamed from: q */
    public static final C5964h f15246q = m19123a("TLS_AES_128_GCM_SHA256", 4865);

    /* renamed from: r */
    public static final C5964h f15247r = m19123a("TLS_AES_256_GCM_SHA384", 4866);

    /* renamed from: s */
    public static final C5964h f15248s = m19123a("TLS_CHACHA20_POLY1305_SHA256", 4867);

    /* renamed from: t */
    public static final C5964h f15249t = m19123a("TLS_AES_128_CCM_SHA256", 4868);

    /* renamed from: u */
    public static final C5964h f15250u = m19123a("TLS_AES_256_CCM_8_SHA256", 4869);

    /* renamed from: a */
    final String f15251a;

    /* renamed from: i.h$a */
    /* compiled from: CipherSuite */
    class C5965a implements Comparator<String> {
        C5965a() {
        }

        /* renamed from: a */
        public int compare(String str, String str2) {
            int min = Math.min(str.length(), str2.length());
            int i = 4;
            while (i < min) {
                char charAt = str.charAt(i);
                char charAt2 = str2.charAt(i);
                if (charAt == charAt2) {
                    i++;
                } else if (charAt < charAt2) {
                    return -1;
                } else {
                    return 1;
                }
            }
            int length = str.length();
            int length2 = str2.length();
            if (length == length2) {
                return 0;
            }
            if (length < length2) {
                return -1;
            }
            return 1;
        }
    }

    static {
        m19123a("SSL_RSA_WITH_NULL_MD5", 1);
        m19123a("SSL_RSA_WITH_NULL_SHA", 2);
        m19123a("SSL_RSA_EXPORT_WITH_RC4_40_MD5", 3);
        m19123a("SSL_RSA_WITH_RC4_128_MD5", 4);
        m19123a("SSL_RSA_WITH_RC4_128_SHA", 5);
        m19123a("SSL_RSA_EXPORT_WITH_DES40_CBC_SHA", 8);
        m19123a("SSL_RSA_WITH_DES_CBC_SHA", 9);
        m19123a("SSL_DHE_DSS_EXPORT_WITH_DES40_CBC_SHA", 17);
        m19123a("SSL_DHE_DSS_WITH_DES_CBC_SHA", 18);
        m19123a("SSL_DHE_DSS_WITH_3DES_EDE_CBC_SHA", 19);
        m19123a("SSL_DHE_RSA_EXPORT_WITH_DES40_CBC_SHA", 20);
        m19123a("SSL_DHE_RSA_WITH_DES_CBC_SHA", 21);
        m19123a("SSL_DHE_RSA_WITH_3DES_EDE_CBC_SHA", 22);
        m19123a("SSL_DH_anon_EXPORT_WITH_RC4_40_MD5", 23);
        m19123a("SSL_DH_anon_WITH_RC4_128_MD5", 24);
        m19123a("SSL_DH_anon_EXPORT_WITH_DES40_CBC_SHA", 25);
        m19123a("SSL_DH_anon_WITH_DES_CBC_SHA", 26);
        m19123a("SSL_DH_anon_WITH_3DES_EDE_CBC_SHA", 27);
        m19123a("TLS_KRB5_WITH_DES_CBC_SHA", 30);
        m19123a("TLS_KRB5_WITH_3DES_EDE_CBC_SHA", 31);
        m19123a("TLS_KRB5_WITH_RC4_128_SHA", 32);
        m19123a("TLS_KRB5_WITH_DES_CBC_MD5", 34);
        m19123a("TLS_KRB5_WITH_3DES_EDE_CBC_MD5", 35);
        m19123a("TLS_KRB5_WITH_RC4_128_MD5", 36);
        m19123a("TLS_KRB5_EXPORT_WITH_DES_CBC_40_SHA", 38);
        m19123a("TLS_KRB5_EXPORT_WITH_RC4_40_SHA", 40);
        m19123a("TLS_KRB5_EXPORT_WITH_DES_CBC_40_MD5", 41);
        m19123a("TLS_KRB5_EXPORT_WITH_RC4_40_MD5", 43);
        m19123a("TLS_DHE_DSS_WITH_AES_128_CBC_SHA", 50);
        m19123a("TLS_DHE_RSA_WITH_AES_128_CBC_SHA", 51);
        m19123a("TLS_DH_anon_WITH_AES_128_CBC_SHA", 52);
        m19123a("TLS_DHE_DSS_WITH_AES_256_CBC_SHA", 56);
        m19123a("TLS_DHE_RSA_WITH_AES_256_CBC_SHA", 57);
        m19123a("TLS_DH_anon_WITH_AES_256_CBC_SHA", 58);
        m19123a("TLS_RSA_WITH_NULL_SHA256", 59);
        m19123a("TLS_RSA_WITH_AES_128_CBC_SHA256", 60);
        m19123a("TLS_RSA_WITH_AES_256_CBC_SHA256", 61);
        m19123a("TLS_DHE_DSS_WITH_AES_128_CBC_SHA256", 64);
        m19123a("TLS_RSA_WITH_CAMELLIA_128_CBC_SHA", 65);
        m19123a("TLS_DHE_DSS_WITH_CAMELLIA_128_CBC_SHA", 68);
        m19123a("TLS_DHE_RSA_WITH_CAMELLIA_128_CBC_SHA", 69);
        m19123a("TLS_DHE_RSA_WITH_AES_128_CBC_SHA256", 103);
        m19123a("TLS_DHE_DSS_WITH_AES_256_CBC_SHA256", 106);
        m19123a("TLS_DHE_RSA_WITH_AES_256_CBC_SHA256", 107);
        m19123a("TLS_DH_anon_WITH_AES_128_CBC_SHA256", 108);
        m19123a("TLS_DH_anon_WITH_AES_256_CBC_SHA256", 109);
        m19123a("TLS_RSA_WITH_CAMELLIA_256_CBC_SHA", 132);
        m19123a("TLS_DHE_DSS_WITH_CAMELLIA_256_CBC_SHA", 135);
        m19123a("TLS_DHE_RSA_WITH_CAMELLIA_256_CBC_SHA", 136);
        m19123a("TLS_PSK_WITH_RC4_128_SHA", 138);
        m19123a("TLS_PSK_WITH_3DES_EDE_CBC_SHA", 139);
        m19123a("TLS_PSK_WITH_AES_128_CBC_SHA", 140);
        m19123a("TLS_PSK_WITH_AES_256_CBC_SHA", 141);
        m19123a("TLS_RSA_WITH_SEED_CBC_SHA", 150);
        m19123a("TLS_DHE_RSA_WITH_AES_128_GCM_SHA256", 158);
        m19123a("TLS_DHE_RSA_WITH_AES_256_GCM_SHA384", 159);
        m19123a("TLS_DHE_DSS_WITH_AES_128_GCM_SHA256", AdMostAdListener.COMPLETED);
        m19123a("TLS_DHE_DSS_WITH_AES_256_GCM_SHA384", AdMostAdListener.LOADED);
        m19123a("TLS_DH_anon_WITH_AES_128_GCM_SHA256", AdMostAdListener.STATUS_CHANGED);
        m19123a("TLS_DH_anon_WITH_AES_256_GCM_SHA384", 167);
        m19123a("TLS_EMPTY_RENEGOTIATION_INFO_SCSV", 255);
        m19123a("TLS_FALLBACK_SCSV", 22016);
        m19123a("TLS_ECDH_ECDSA_WITH_NULL_SHA", 49153);
        m19123a("TLS_ECDH_ECDSA_WITH_RC4_128_SHA", 49154);
        m19123a("TLS_ECDH_ECDSA_WITH_3DES_EDE_CBC_SHA", 49155);
        m19123a("TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA", 49156);
        m19123a("TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA", 49157);
        m19123a("TLS_ECDHE_ECDSA_WITH_NULL_SHA", 49158);
        m19123a("TLS_ECDHE_ECDSA_WITH_RC4_128_SHA", 49159);
        m19123a("TLS_ECDHE_ECDSA_WITH_3DES_EDE_CBC_SHA", 49160);
        m19123a("TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA", 49161);
        m19123a("TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA", 49162);
        m19123a("TLS_ECDH_RSA_WITH_NULL_SHA", 49163);
        m19123a("TLS_ECDH_RSA_WITH_RC4_128_SHA", 49164);
        m19123a("TLS_ECDH_RSA_WITH_3DES_EDE_CBC_SHA", 49165);
        m19123a("TLS_ECDH_RSA_WITH_AES_128_CBC_SHA", 49166);
        m19123a("TLS_ECDH_RSA_WITH_AES_256_CBC_SHA", 49167);
        m19123a("TLS_ECDHE_RSA_WITH_NULL_SHA", 49168);
        m19123a("TLS_ECDHE_RSA_WITH_RC4_128_SHA", 49169);
        m19123a("TLS_ECDHE_RSA_WITH_3DES_EDE_CBC_SHA", 49170);
        m19123a("TLS_ECDH_anon_WITH_NULL_SHA", 49173);
        m19123a("TLS_ECDH_anon_WITH_RC4_128_SHA", 49174);
        m19123a("TLS_ECDH_anon_WITH_3DES_EDE_CBC_SHA", 49175);
        m19123a("TLS_ECDH_anon_WITH_AES_128_CBC_SHA", 49176);
        m19123a("TLS_ECDH_anon_WITH_AES_256_CBC_SHA", 49177);
        m19123a("TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA256", 49187);
        m19123a("TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA384", 49188);
        m19123a("TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA256", 49189);
        m19123a("TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA384", 49190);
        m19123a("TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA256", 49191);
        m19123a("TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA384", 49192);
        m19123a("TLS_ECDH_RSA_WITH_AES_128_CBC_SHA256", 49193);
        m19123a("TLS_ECDH_RSA_WITH_AES_256_CBC_SHA384", 49194);
        m19123a("TLS_ECDH_ECDSA_WITH_AES_128_GCM_SHA256", 49197);
        m19123a("TLS_ECDH_ECDSA_WITH_AES_256_GCM_SHA384", 49198);
        m19123a("TLS_ECDH_RSA_WITH_AES_128_GCM_SHA256", 49201);
        m19123a("TLS_ECDH_RSA_WITH_AES_256_GCM_SHA384", 49202);
        m19123a("TLS_ECDHE_PSK_WITH_AES_128_CBC_SHA", 49205);
        m19123a("TLS_ECDHE_PSK_WITH_AES_256_CBC_SHA", 49206);
        m19123a("TLS_DHE_RSA_WITH_CHACHA20_POLY1305_SHA256", 52394);
        m19123a("TLS_ECDHE_PSK_WITH_CHACHA20_POLY1305_SHA256", 52396);
    }

    private C5964h(String str) {
        if (str != null) {
            this.f15251a = str;
            return;
        }
        throw null;
    }

    /* renamed from: a */
    public static synchronized C5964h m19122a(String str) {
        C5964h hVar;
        synchronized (C5964h.class) {
            hVar = f15232c.get(str);
            if (hVar == null) {
                hVar = f15232c.get(m19125b(str));
                if (hVar == null) {
                    hVar = new C5964h(str);
                }
                f15232c.put(str, hVar);
            }
        }
        return hVar;
    }

    /* renamed from: b */
    private static String m19125b(String str) {
        if (str.startsWith("TLS_")) {
            return "SSL_" + str.substring(4);
        } else if (!str.startsWith("SSL_")) {
            return str;
        } else {
            return "TLS_" + str.substring(4);
        }
    }

    public String toString() {
        return this.f15251a;
    }

    /* renamed from: a */
    static List<C5964h> m19124a(String... strArr) {
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String a : strArr) {
            arrayList.add(m19122a(a));
        }
        return Collections.unmodifiableList(arrayList);
    }

    /* renamed from: a */
    private static C5964h m19123a(String str, int i) {
        C5964h hVar = new C5964h(str);
        f15232c.put(str, hVar);
        return hVar;
    }

    /* renamed from: a */
    public String mo33775a() {
        return this.f15251a;
    }
}
