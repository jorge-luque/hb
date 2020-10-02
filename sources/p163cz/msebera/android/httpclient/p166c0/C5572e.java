package p163cz.msebera.android.httpclient.p166c0;

import java.io.Serializable;
import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;
import java.util.Locale;
import p118io.fabric.sdk.android.p200m.p202b.C6078a;
import p163cz.msebera.android.httpclient.C5563b;
import p163cz.msebera.android.httpclient.C5691d;
import p163cz.msebera.android.httpclient.C5696e;
import p163cz.msebera.android.httpclient.C5870j;
import p163cz.msebera.android.httpclient.C5906u;
import p163cz.msebera.android.httpclient.ParseException;
import p163cz.msebera.android.httpclient.p182g0.C5736f;
import p163cz.msebera.android.httpclient.p187k0.C5886a;
import p163cz.msebera.android.httpclient.p187k0.C5889d;
import p163cz.msebera.android.httpclient.p187k0.C5894i;

/* renamed from: cz.msebera.android.httpclient.c0.e */
/* compiled from: ContentType */
public final class C5572e implements Serializable {

    /* renamed from: d */
    public static final C5572e f14534d = m17757a("application/x-www-form-urlencoded", C5563b.f14522c);

    /* renamed from: e */
    public static final C5572e f14535e = m17757a("application/octet-stream", (Charset) null);

    /* renamed from: f */
    public static final C5572e f14536f = m17757a("text/plain", C5563b.f14522c);
    private static final long serialVersionUID = -7768694718232371896L;

    /* renamed from: a */
    private final String f14537a;

    /* renamed from: b */
    private final Charset f14538b;

    /* renamed from: c */
    private final C5906u[] f14539c;

    static {
        m17757a("application/atom+xml", C5563b.f14522c);
        m17757a(C6078a.ACCEPT_JSON_VALUE, C5563b.f14520a);
        m17757a("application/svg+xml", C5563b.f14522c);
        m17757a("application/xhtml+xml", C5563b.f14522c);
        m17757a("application/xml", C5563b.f14522c);
        m17757a("multipart/form-data", C5563b.f14522c);
        m17757a("text/html", C5563b.f14522c);
        m17757a("text/xml", C5563b.f14522c);
        m17757a("*/*", (Charset) null);
    }

    C5572e(String str, Charset charset) {
        this.f14537a = str;
        this.f14538b = charset;
        this.f14539c = null;
    }

    /* renamed from: a */
    public Charset mo32903a() {
        return this.f14538b;
    }

    /* renamed from: b */
    public String mo32904b() {
        return this.f14537a;
    }

    public String toString() {
        C5889d dVar = new C5889d(64);
        dVar.mo33670a(this.f14537a);
        if (this.f14539c != null) {
            dVar.mo33670a("; ");
            C5736f.f14810a.mo33324a(dVar, this.f14539c, false);
        } else if (this.f14538b != null) {
            dVar.mo33670a("; charset=");
            dVar.mo33670a(this.f14538b.name());
        }
        return dVar.toString();
    }

    /* renamed from: a */
    private static boolean m17759a(String str) {
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (charAt == '\"' || charAt == ',' || charAt == ';') {
                return false;
            }
        }
        return true;
    }

    /* renamed from: a */
    public static C5572e m17757a(String str, Charset charset) {
        C5886a.m18899b(str, "MIME type");
        String lowerCase = str.toLowerCase(Locale.ROOT);
        C5886a.m18896a(m17759a(lowerCase), "MIME type may not contain reserved characters");
        return new C5572e(lowerCase, charset);
    }

    C5572e(String str, Charset charset, C5906u[] uVarArr) {
        this.f14537a = str;
        this.f14538b = charset;
        this.f14539c = uVarArr;
    }

    /* renamed from: a */
    private static C5572e m17755a(C5696e eVar, boolean z) {
        return m17758a(eVar.getName(), eVar.getParameters(), z);
    }

    /* renamed from: a */
    private static C5572e m17758a(String str, C5906u[] uVarArr, boolean z) {
        Charset charset;
        int length = uVarArr.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                break;
            }
            C5906u uVar = uVarArr[i];
            if (uVar.getName().equalsIgnoreCase("charset")) {
                String value = uVar.getValue();
                if (!C5894i.m18943b(value)) {
                    try {
                        charset = Charset.forName(value);
                    } catch (UnsupportedCharsetException e) {
                        if (z) {
                            throw e;
                        }
                    }
                }
            } else {
                i++;
            }
        }
        charset = null;
        if (uVarArr == null || uVarArr.length <= 0) {
            uVarArr = null;
        }
        return new C5572e(str, charset, uVarArr);
    }

    /* renamed from: a */
    public static C5572e m17756a(C5870j jVar) throws ParseException, UnsupportedCharsetException {
        C5691d a;
        if (!(jVar == null || (a = jVar.mo32889a()) == null)) {
            C5696e[] b = a.mo33162b();
            if (b.length > 0) {
                return m17755a(b[0], true);
            }
        }
        return null;
    }
}
