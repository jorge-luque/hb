package p119j;

import java.io.IOException;

/* renamed from: j.i */
/* compiled from: ForwardingSource */
public abstract class C6584i implements C3586u {
    private final C3586u delegate;

    public C6584i(C3586u uVar) {
        if (uVar != null) {
            this.delegate = uVar;
            return;
        }
        throw new IllegalArgumentException("delegate == null");
    }

    public void close() throws IOException {
        this.delegate.close();
    }

    public final C3586u delegate() {
        return this.delegate;
    }

    public long read(C3577c cVar, long j) throws IOException {
        return this.delegate.read(cVar, j);
    }

    public C3587v timeout() {
        return this.delegate.timeout();
    }

    public String toString() {
        return getClass().getSimpleName() + "(" + this.delegate.toString() + ")";
    }
}
