package p163cz.msebera.android.httpclient.auth;

import p163cz.msebera.android.httpclient.ProtocolException;

/* renamed from: cz.msebera.android.httpclient.auth.AuthenticationException */
public class AuthenticationException extends ProtocolException {
    private static final long serialVersionUID = -6794031905674764776L;

    public AuthenticationException() {
    }

    public AuthenticationException(String str) {
        super(str);
    }

    public AuthenticationException(String str, Throwable th) {
        super(str, th);
    }
}
