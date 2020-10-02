package p163cz.msebera.android.httpclient.client;

import java.io.IOException;

/* renamed from: cz.msebera.android.httpclient.client.ClientProtocolException */
public class ClientProtocolException extends IOException {
    private static final long serialVersionUID = -5596590843227115865L;

    public ClientProtocolException() {
    }

    public ClientProtocolException(String str) {
        super(str);
    }

    public ClientProtocolException(Throwable th) {
        initCause(th);
    }
}
