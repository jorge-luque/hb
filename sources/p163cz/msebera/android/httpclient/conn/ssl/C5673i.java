package p163cz.msebera.android.httpclient.conn.ssl;

import javax.net.ssl.SSLException;

@Deprecated
/* renamed from: cz.msebera.android.httpclient.conn.ssl.i */
/* compiled from: StrictHostnameVerifier */
public class C5673i extends C5664a {
    static {
        new C5673i();
    }

    public final String toString() {
        return "STRICT";
    }

    public final void verify(String str, String[] strArr, String[] strArr2) throws SSLException {
        mo33100a(str, strArr, strArr2, true);
    }
}
