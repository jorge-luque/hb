package p119j;

import java.io.IOException;
import java.util.zip.CRC32;
import java.util.zip.Deflater;

/* renamed from: j.k */
/* compiled from: GzipSink */
public final class C6586k implements C3585t {

    /* renamed from: a */
    private final C3579d f17144a;

    /* renamed from: b */
    private final Deflater f17145b;

    /* renamed from: c */
    private final C6582g f17146c;

    /* renamed from: d */
    private boolean f17147d;

    /* renamed from: e */
    private final CRC32 f17148e = new CRC32();

    public C6586k(C3585t tVar) {
        if (tVar != null) {
            this.f17145b = new Deflater(-1, true);
            C3579d a = C6589n.m21609a(tVar);
            this.f17144a = a;
            this.f17146c = new C6582g(a, this.f17145b);
            m21601t();
            return;
        }
        throw new IllegalArgumentException("sink == null");
    }

    /* renamed from: b */
    private void m21599b(C3577c cVar, long j) {
        C3583q qVar = cVar.f10031a;
        while (j > 0) {
            int min = (int) Math.min(j, (long) (qVar.f10042c - qVar.f10041b));
            this.f17148e.update(qVar.f10040a, qVar.f10041b, min);
            j -= (long) min;
            qVar = qVar.f10045f;
        }
    }

    /* renamed from: d */
    private void m21600d() throws IOException {
        this.f17144a.mo19710g((int) this.f17148e.getValue());
        this.f17144a.mo19710g((int) this.f17145b.getBytesRead());
    }

    /* renamed from: t */
    private void m21601t() {
        C3577c C = this.f17144a.mo19678C();
        C.writeShort(8075);
        C.writeByte(8);
        C.writeByte(0);
        C.writeInt(0);
        C.writeByte(0);
        C.writeByte(0);
    }

    /* renamed from: a */
    public void mo19670a(C3577c cVar, long j) throws IOException {
        if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        } else if (j != 0) {
            m21599b(cVar, j);
            this.f17146c.mo19670a(cVar, j);
        }
    }

    public void close() throws IOException {
        if (!this.f17147d) {
            try {
                this.f17146c.mo35606d();
                m21600d();
                th = null;
            } catch (Throwable th) {
                th = th;
            }
            try {
                this.f17145b.end();
            } catch (Throwable th2) {
                if (th == null) {
                    th = th2;
                }
            }
            try {
                this.f17144a.close();
            } catch (Throwable th3) {
                if (th == null) {
                    th = th3;
                }
            }
            this.f17147d = true;
            if (th != null) {
                C6597w.m21674a(th);
                throw null;
            }
        }
    }

    public void flush() throws IOException {
        this.f17146c.flush();
    }

    public C3587v timeout() {
        return this.f17144a.timeout();
    }
}
