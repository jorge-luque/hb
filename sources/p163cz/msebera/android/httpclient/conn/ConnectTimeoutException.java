package p163cz.msebera.android.httpclient.conn;

import java.io.InterruptedIOException;

/* renamed from: cz.msebera.android.httpclient.conn.ConnectTimeoutException */
public class ConnectTimeoutException extends InterruptedIOException {
    private static final long serialVersionUID = -4816682903149535989L;

    public ConnectTimeoutException() {
    }

    public ConnectTimeoutException(String str) {
        super(str);
    }
}
