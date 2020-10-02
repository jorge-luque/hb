package okhttp3.internal.connection;

import java.io.IOException;
import p113i.p114e0.C3500c;

public final class RouteException extends RuntimeException {

    /* renamed from: a */
    private IOException f17281a;

    /* renamed from: b */
    private IOException f17282b;

    public RouteException(IOException iOException) {
        super(iOException);
        this.f17281a = iOException;
        this.f17282b = iOException;
    }

    /* renamed from: a */
    public IOException mo35644a() {
        return this.f17281a;
    }

    /* renamed from: b */
    public IOException mo35646b() {
        return this.f17282b;
    }

    /* renamed from: a */
    public void mo35645a(IOException iOException) {
        C3500c.m11650a((Throwable) this.f17281a, (Throwable) iOException);
        this.f17282b = iOException;
    }
}
