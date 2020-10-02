package p163cz.msebera.android.httpclient.p187k0;

import java.io.UnsupportedEncodingException;
import p163cz.msebera.android.httpclient.C5563b;

/* renamed from: cz.msebera.android.httpclient.k0.f */
/* compiled from: EncodingUtils */
public final class C5891f {
    /* renamed from: a */
    public static byte[] m18934a(String str, String str2) {
        C5886a.m18894a(str, "Input");
        C5886a.m18900c(str2, "Charset");
        try {
            return str.getBytes(str2);
        } catch (UnsupportedEncodingException unused) {
            return str.getBytes();
        }
    }

    /* renamed from: a */
    public static byte[] m18933a(String str) {
        C5886a.m18894a(str, "Input");
        return str.getBytes(C5563b.f14521b);
    }
}
