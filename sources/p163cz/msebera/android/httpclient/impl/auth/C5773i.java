package p163cz.msebera.android.httpclient.impl.auth;

import java.nio.charset.Charset;
import java.security.SecureRandom;
import p163cz.msebera.android.httpclient.C5563b;
import p163cz.msebera.android.httpclient.p187k0.C5890e;

/* renamed from: cz.msebera.android.httpclient.impl.auth.i */
/* compiled from: NTLMEngineImpl */
final class C5773i implements C5772h {

    /* renamed from: a */
    private static final Charset f14878a = C5890e.m18932b("UnicodeLittleUnmarked");

    /* renamed from: b */
    private static final Charset f14879b = C5563b.f14521b;

    /* renamed from: c */
    private static final SecureRandom f14880c;

    /* renamed from: d */
    private static final byte[] f14881d;

    /* renamed from: e */
    private static final C5775b f14882e = new C5775b();

    /* renamed from: cz.msebera.android.httpclient.impl.auth.i$a */
    /* compiled from: NTLMEngineImpl */
    static class C5774a {

        /* renamed from: a */
        private byte[] f14883a = null;

        /* renamed from: b */
        private int f14884b = 0;

        C5774a() {
        }
    }

    /* renamed from: cz.msebera.android.httpclient.impl.auth.i$b */
    /* compiled from: NTLMEngineImpl */
    static class C5775b extends C5774a {

        /* renamed from: c */
        private final byte[] f14885c = null;

        /* renamed from: d */
        private final byte[] f14886d = null;

        C5775b() {
        }
    }

    static {
        SecureRandom secureRandom;
        try {
            secureRandom = SecureRandom.getInstance("SHA1PRNG");
        } catch (Exception unused) {
            secureRandom = null;
        }
        f14880c = secureRandom;
        byte[] bytes = "NTLMSSP".getBytes(C5563b.f14521b);
        byte[] bArr = new byte[(bytes.length + 1)];
        f14881d = bArr;
        System.arraycopy(bytes, 0, bArr, 0, bytes.length);
        f14881d[bytes.length] = 0;
    }

    C5773i() {
    }
}
