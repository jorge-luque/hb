package p119j;

import java.io.Closeable;
import java.io.IOException;

/* renamed from: j.u */
/* compiled from: Source */
public interface C3586u extends Closeable {
    void close() throws IOException;

    long read(C3577c cVar, long j) throws IOException;

    C3587v timeout();
}
