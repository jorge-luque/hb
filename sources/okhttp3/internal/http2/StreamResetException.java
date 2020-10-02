package okhttp3.internal.http2;

import java.io.IOException;

public final class StreamResetException extends IOException {

    /* renamed from: a */
    public final C6615a f17314a;

    public StreamResetException(C6615a aVar) {
        super("stream was reset: " + aVar);
        this.f17314a = aVar;
    }
}
