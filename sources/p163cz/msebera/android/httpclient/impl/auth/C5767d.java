package p163cz.msebera.android.httpclient.impl.auth;

import admost.sdk.base.AdMostExperimentManager;
import com.applovin.sdk.AppLovinEventParameters;
import com.facebook.share.internal.ShareConstants;
import com.ogury.p159cm.OguryChoiceManager;
import java.io.IOException;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.Principal;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.HashSet;
import java.util.Locale;
import java.util.StringTokenizer;
import p163cz.msebera.android.httpclient.C5563b;
import p163cz.msebera.android.httpclient.C5691d;
import p163cz.msebera.android.httpclient.C5870j;
import p163cz.msebera.android.httpclient.C5885k;
import p163cz.msebera.android.httpclient.C5899o;
import p163cz.msebera.android.httpclient.C5906u;
import p163cz.msebera.android.httpclient.auth.AuthenticationException;
import p163cz.msebera.android.httpclient.auth.C5559l;
import p163cz.msebera.android.httpclient.auth.MalformedChallengeException;
import p163cz.msebera.android.httpclient.p182g0.C5736f;
import p163cz.msebera.android.httpclient.p182g0.C5743m;
import p163cz.msebera.android.httpclient.p182g0.C5747q;
import p163cz.msebera.android.httpclient.p186j0.C5871a;
import p163cz.msebera.android.httpclient.p186j0.C5875e;
import p163cz.msebera.android.httpclient.p187k0.C5886a;
import p163cz.msebera.android.httpclient.p187k0.C5889d;
import p163cz.msebera.android.httpclient.p187k0.C5891f;

/* renamed from: cz.msebera.android.httpclient.impl.auth.d */
/* compiled from: DigestScheme */
public class C5767d extends C5779l {

    /* renamed from: j */
    private static final char[] f14865j = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    private static final long serialVersionUID = 3883908186234566916L;

    /* renamed from: d */
    private boolean f14866d;

    /* renamed from: e */
    private String f14867e;

    /* renamed from: f */
    private long f14868f;

    /* renamed from: g */
    private String f14869g;

    /* renamed from: h */
    private String f14870h;

    /* renamed from: i */
    private String f14871i;

    public C5767d(Charset charset) {
        super(charset);
        this.f14866d = false;
    }

    /* renamed from: b */
    private static MessageDigest m18387b(String str) throws UnsupportedDigestAlgorithmException {
        try {
            return MessageDigest.getInstance(str);
        } catch (Exception unused) {
            throw new UnsupportedDigestAlgorithmException("Unsupported algorithm in HTTP Digest authentication: " + str);
        }
    }

    /* renamed from: h */
    public static String m18388h() {
        byte[] bArr = new byte[8];
        new SecureRandom().nextBytes(bArr);
        return m18385a(bArr);
    }

    /* renamed from: a */
    public void mo32839a(C5691d dVar) throws MalformedChallengeException {
        super.mo32839a(dVar);
        this.f14866d = true;
        if (mo33446g().isEmpty()) {
            throw new MalformedChallengeException("Authentication challenge is empty");
        }
    }

    /* renamed from: b */
    public boolean mo32840b() {
        return false;
    }

    /* renamed from: c */
    public boolean mo32841c() {
        if ("true".equalsIgnoreCase(mo33444a("stale"))) {
            return false;
        }
        return this.f14866d;
    }

    /* renamed from: d */
    public String mo32842d() {
        return "digest";
    }

    public String toString() {
        return "DIGEST [complete=" + this.f14866d + ", nonce=" + this.f14867e + ", nc=" + this.f14868f + "]";
    }

    public C5767d() {
        this(C5563b.f14521b);
    }

    /* renamed from: b */
    private C5691d m18386b(C5559l lVar, C5899o oVar) throws AuthenticationException {
        String str;
        char c;
        String str2;
        String str3;
        MessageDigest messageDigest;
        String str4;
        String str5;
        String str6;
        String str7;
        char c2;
        C5899o oVar2 = oVar;
        String a = mo33444a(ShareConstants.MEDIA_URI);
        String a2 = mo33444a("realm");
        String a3 = mo33444a("nonce");
        String a4 = mo33444a("opaque");
        String a5 = mo33444a("methodname");
        String a6 = mo33444a(AdMostExperimentManager.TYPE_ALGORITHM);
        if (a6 == null) {
            a6 = "MD5";
        }
        HashSet hashSet = new HashSet(8);
        String str8 = "MD5";
        String a7 = mo33444a("qop");
        String str9 = "opaque";
        String str10 = a4;
        String str11 = AdMostExperimentManager.TYPE_ALGORITHM;
        if (a7 != null) {
            str = "qop";
            for (StringTokenizer stringTokenizer = new StringTokenizer(a7, ","); stringTokenizer.hasMoreTokens(); stringTokenizer = stringTokenizer) {
                hashSet.add(stringTokenizer.nextToken().trim().toLowerCase(Locale.ROOT));
            }
            c = (!(oVar2 instanceof C5885k) || !hashSet.contains("auth-int")) ? hashSet.contains("auth") ? (char) 2 : 65535 : 1;
        } else {
            str = "qop";
            c = 0;
        }
        if (c != 65535) {
            String a8 = mo33444a("charset");
            if (a8 == null) {
                a8 = "ISO-8859-1";
            }
            if (a6.equalsIgnoreCase("MD5-sess")) {
                str2 = "auth-int";
            } else {
                str2 = "auth-int";
                str8 = a6;
            }
            try {
                MessageDigest b = m18387b(str8);
                Principal a9 = lVar.mo32868a();
                String str12 = ShareConstants.MEDIA_URI;
                String name = a9.getName();
                String str13 = "nonce";
                String b2 = lVar.mo32869b();
                String str14 = "realm";
                String str15 = "auth";
                String str16 = a5;
                if (a3.equals(this.f14867e)) {
                    str3 = a;
                    this.f14868f++;
                } else {
                    str3 = a;
                    this.f14868f = 1;
                    this.f14869g = null;
                    this.f14867e = a3;
                }
                StringBuilder sb = new StringBuilder(256);
                Formatter formatter = new Formatter(sb, Locale.US);
                String str17 = a3;
                MessageDigest messageDigest2 = b;
                formatter.format("%08x", new Object[]{Long.valueOf(this.f14868f)});
                formatter.close();
                String sb2 = sb.toString();
                if (this.f14869g == null) {
                    this.f14869g = m18388h();
                }
                this.f14870h = null;
                this.f14871i = null;
                if (a6.equalsIgnoreCase("MD5-sess")) {
                    sb.setLength(0);
                    sb.append(name);
                    sb.append(':');
                    sb.append(a2);
                    sb.append(':');
                    sb.append(b2);
                    messageDigest = messageDigest2;
                    String a10 = m18385a(messageDigest.digest(C5891f.m18934a(sb.toString(), a8)));
                    sb.setLength(0);
                    sb.append(a10);
                    sb.append(':');
                    sb.append(str17);
                    sb.append(':');
                    sb.append(this.f14869g);
                    this.f14870h = sb.toString();
                } else {
                    messageDigest = messageDigest2;
                    sb.setLength(0);
                    sb.append(name);
                    sb.append(':');
                    sb.append(a2);
                    sb.append(':');
                    sb.append(b2);
                    this.f14870h = sb.toString();
                }
                String a11 = m18385a(messageDigest.digest(C5891f.m18934a(this.f14870h, a8)));
                if (c == 2) {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(str16);
                    sb3.append(':');
                    str5 = str3;
                    sb3.append(str5);
                    this.f14871i = sb3.toString();
                    str4 = str15;
                } else {
                    String str18 = str16;
                    str5 = str3;
                    if (c == 1) {
                        C5870j entity = oVar2 instanceof C5885k ? ((C5885k) oVar2).getEntity() : null;
                        if (entity == null || entity.mo32900b()) {
                            str4 = str15;
                            C5771g gVar = new C5771g(messageDigest);
                            if (entity != null) {
                                try {
                                    entity.mo32899a(gVar);
                                } catch (IOException e) {
                                    throw new AuthenticationException("I/O error reading entity content", e);
                                }
                            }
                            gVar.close();
                            this.f14871i = str18 + ':' + str5 + ':' + m18385a(gVar.mo33440d());
                            c2 = c;
                        } else {
                            str4 = str15;
                            if (hashSet.contains(str4)) {
                                this.f14871i = str18 + ':' + str5;
                                c2 = 2;
                            } else {
                                throw new AuthenticationException("Qop auth-int cannot be used with a non-repeatable entity");
                            }
                        }
                        c = c2;
                    } else {
                        str4 = str15;
                        this.f14871i = str18 + ':' + str5;
                    }
                }
                String a12 = m18385a(messageDigest.digest(C5891f.m18934a(this.f14871i, a8)));
                if (c == 0) {
                    sb.setLength(0);
                    sb.append(a11);
                    sb.append(':');
                    sb.append(str17);
                    sb.append(':');
                    sb.append(a12);
                    str6 = sb.toString();
                } else {
                    sb.setLength(0);
                    sb.append(a11);
                    sb.append(':');
                    sb.append(str17);
                    sb.append(':');
                    sb.append(sb2);
                    sb.append(':');
                    sb.append(this.f14869g);
                    sb.append(':');
                    sb.append(c == 1 ? str2 : str4);
                    sb.append(':');
                    sb.append(a12);
                    str6 = sb.toString();
                }
                String a13 = m18385a(messageDigest.digest(C5891f.m18933a(str6)));
                C5889d dVar = new C5889d(OguryChoiceManager.TcfV2.Purpose.MEASURE_AD_PERFORMANCE);
                if (mo33435e()) {
                    dVar.mo33670a("Proxy-Authorization");
                } else {
                    dVar.mo33670a("Authorization");
                }
                dVar.mo33670a(": Digest ");
                ArrayList arrayList = new ArrayList(20);
                arrayList.add(new C5743m(AppLovinEventParameters.USER_ACCOUNT_IDENTIFIER, name));
                arrayList.add(new C5743m(str14, a2));
                arrayList.add(new C5743m(str13, str17));
                arrayList.add(new C5743m(str12, str5));
                arrayList.add(new C5743m("response", a13));
                if (c != 0) {
                    if (c == 1) {
                        str4 = str2;
                    }
                    str7 = str;
                    arrayList.add(new C5743m(str7, str4));
                    arrayList.add(new C5743m("nc", sb2));
                    arrayList.add(new C5743m("cnonce", this.f14869g));
                } else {
                    str7 = str;
                }
                String str19 = str11;
                arrayList.add(new C5743m(str19, a6));
                if (str10 != null) {
                    arrayList.add(new C5743m(str9, str10));
                }
                for (int i = 0; i < arrayList.size(); i++) {
                    C5743m mVar = (C5743m) arrayList.get(i);
                    if (i > 0) {
                        dVar.mo33670a(", ");
                    }
                    String name2 = mVar.getName();
                    C5736f.f14810a.mo33323a(dVar, (C5906u) mVar, !("nc".equals(name2) || str7.equals(name2) || str19.equals(name2)));
                }
                return new C5747q(dVar);
            } catch (UnsupportedDigestAlgorithmException unused) {
                throw new AuthenticationException("Unsuppported digest algorithm: " + str8);
            }
        } else {
            throw new AuthenticationException("None of the qop methods is supported: " + a7);
        }
    }

    @Deprecated
    /* renamed from: a */
    public C5691d mo32837a(C5559l lVar, C5899o oVar) throws AuthenticationException {
        return mo32867a(lVar, oVar, new C5871a());
    }

    /* renamed from: a */
    public C5691d mo32867a(C5559l lVar, C5899o oVar, C5875e eVar) throws AuthenticationException {
        C5886a.m18894a(lVar, "Credentials");
        C5886a.m18894a(oVar, "HTTP request");
        if (mo33444a("realm") == null) {
            throw new AuthenticationException("missing realm in challenge");
        } else if (mo33444a("nonce") != null) {
            mo33446g().put("methodname", oVar.getRequestLine().getMethod());
            mo33446g().put(ShareConstants.MEDIA_URI, oVar.getRequestLine().getUri());
            if (mo33444a("charset") == null) {
                mo33446g().put("charset", mo33443a(oVar));
            }
            return m18386b(lVar, oVar);
        } else {
            throw new AuthenticationException("missing nonce in challenge");
        }
    }

    /* renamed from: a */
    static String m18385a(byte[] bArr) {
        int length = bArr.length;
        char[] cArr = new char[(length * 2)];
        for (int i = 0; i < length; i++) {
            int i2 = i * 2;
            char[] cArr2 = f14865j;
            cArr[i2] = cArr2[(bArr[i] & 240) >> 4];
            cArr[i2 + 1] = cArr2[bArr[i] & 15];
        }
        return new String(cArr);
    }
}
