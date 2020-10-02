package p163cz.msebera.android.httpclient.p187k0;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;

/* renamed from: cz.msebera.android.httpclient.k0.e */
/* compiled from: CharsetUtils */
public class C5890e {
    /* renamed from: a */
    public static Charset m18931a(String str) throws UnsupportedEncodingException {
        if (str == null) {
            return null;
        }
        try {
            return Charset.forName(str);
        } catch (UnsupportedCharsetException unused) {
            throw new UnsupportedEncodingException(str);
        }
    }

    /* renamed from: b */
    public static Charset m18932b(String str) {
        if (str == null) {
            return null;
        }
        try {
            return Charset.forName(str);
        } catch (UnsupportedCharsetException unused) {
            return null;
        }
    }
}
