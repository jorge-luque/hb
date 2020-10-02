package p163cz.msebera.android.httpclient;

import java.io.Closeable;
import java.io.IOException;

/* renamed from: cz.msebera.android.httpclient.i */
/* compiled from: HttpConnection */
public interface C5762i extends Closeable {
    /* renamed from: W */
    boolean mo33183W();

    void close() throws IOException;

    /* renamed from: f */
    void mo33209f(int i);

    boolean isOpen();

    void shutdown() throws IOException;
}
