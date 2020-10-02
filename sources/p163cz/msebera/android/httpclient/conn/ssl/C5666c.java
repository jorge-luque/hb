package p163cz.msebera.android.httpclient.conn.ssl;

import javax.net.ssl.SSLException;

@Deprecated
/* renamed from: cz.msebera.android.httpclient.conn.ssl.c */
/* compiled from: BrowserCompatHostnameVerifier */
public class C5666c extends C5664a {
    static {
        new C5666c();
    }

    public final String toString() {
        return "BROWSER_COMPATIBLE";
    }

    public final void verify(String str, String[] strArr, String[] strArr2) throws SSLException {
        mo33100a(str, strArr, strArr2, false);
    }
}
