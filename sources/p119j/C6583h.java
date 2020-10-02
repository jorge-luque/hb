package p119j;

import java.io.IOException;

/* renamed from: j.h */
/* compiled from: ForwardingSink */
public abstract class C6583h implements C3585t {

    /* renamed from: a */
    private final C3585t f17142a;

    public C6583h(C3585t tVar) {
        if (tVar != null) {
            this.f17142a = tVar;
            return;
        }
        throw new IllegalArgumentException("delegate == null");
    }

    /* renamed from: a */
    public void mo19670a(C3577c cVar, long j) throws IOException {
        this.f17142a.mo19670a(cVar, j);
    }

    public void close() throws IOException {
        this.f17142a.close();
    }

    public void flush() throws IOException {
        this.f17142a.flush();
    }

    public C3587v timeout() {
        return this.f17142a.timeout();
    }

    public String toString() {
        return getClass().getSimpleName() + "(" + this.f17142a.toString() + ")";
    }
}
