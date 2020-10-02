package p119j;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;

/* renamed from: j.t */
/* compiled from: Sink */
public interface C3585t extends Closeable, Flushable {
    /* renamed from: a */
    void mo19670a(C3577c cVar, long j) throws IOException;

    void close() throws IOException;

    void flush() throws IOException;

    C3587v timeout();
}
