package p163cz.msebera.android.httpclient.client;

import p163cz.msebera.android.httpclient.ProtocolException;

/* renamed from: cz.msebera.android.httpclient.client.NonRepeatableRequestException */
public class NonRepeatableRequestException extends ProtocolException {
    private static final long serialVersionUID = 82685265288806048L;

    public NonRepeatableRequestException() {
    }

    public NonRepeatableRequestException(String str) {
        super(str);
    }

    public NonRepeatableRequestException(String str, Throwable th) {
        super(str, th);
    }
}
