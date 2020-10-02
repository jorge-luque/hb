package p119j;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.CRC32;
import java.util.zip.Inflater;

/* renamed from: j.l */
/* compiled from: GzipSource */
public final class C6587l implements C3586u {

    /* renamed from: a */
    private int f17149a = 0;

    /* renamed from: b */
    private final C3580e f17150b;

    /* renamed from: c */
    private final Inflater f17151c;

    /* renamed from: d */
    private final C6588m f17152d;

    /* renamed from: e */
    private final CRC32 f17153e = new CRC32();

    public C6587l(C3586u uVar) {
        if (uVar != null) {
            this.f17151c = new Inflater(true);
            C3580e a = C6589n.m21610a(uVar);
            this.f17150b = a;
            this.f17152d = new C6588m(a, this.f17151c);
            return;
        }
        throw new IllegalArgumentException("source == null");
    }

    /* renamed from: a */
    private void m21603a(C3577c cVar, long j, long j2) {
        C3583q qVar = cVar.f10031a;
        while (true) {
            int i = qVar.f10042c;
            int i2 = qVar.f10041b;
            if (j < ((long) (i - i2))) {
                break;
            }
            j -= (long) (i - i2);
            qVar = qVar.f10045f;
        }
        while (j2 > 0) {
            int i3 = (int) (((long) qVar.f10041b) + j);
            int min = (int) Math.min((long) (qVar.f10042c - i3), j2);
            this.f17153e.update(qVar.f10040a, i3, min);
            j2 -= (long) min;
            qVar = qVar.f10045f;
            j = 0;
        }
    }

    /* renamed from: d */
    private void m21605d() throws IOException {
        this.f17150b.mo19718l(10);
        byte e = this.f17150b.mo19678C().mo19707e(3);
        boolean z = ((e >> 1) & 1) == 1;
        if (z) {
            m21603a(this.f17150b.mo19678C(), 0, 10);
        }
        m21604a("ID1ID2", 8075, (int) this.f17150b.readShort());
        this.f17150b.skip(8);
        if (((e >> 2) & 1) == 1) {
            this.f17150b.mo19718l(2);
            if (z) {
                m21603a(this.f17150b.mo19678C(), 0, 2);
            }
            long Q = (long) this.f17150b.mo19678C().mo19686Q();
            this.f17150b.mo19718l(Q);
            if (z) {
                m21603a(this.f17150b.mo19678C(), 0, Q);
            }
            this.f17150b.skip(Q);
        }
        if (((e >> 3) & 1) == 1) {
            long a = this.f17150b.mo19689a((byte) 0);
            if (a != -1) {
                if (z) {
                    m21603a(this.f17150b.mo19678C(), 0, a + 1);
                }
                this.f17150b.skip(a + 1);
            } else {
                throw new EOFException();
            }
        }
        if (((e >> 4) & 1) == 1) {
            long a2 = this.f17150b.mo19689a((byte) 0);
            if (a2 != -1) {
                if (z) {
                    m21603a(this.f17150b.mo19678C(), 0, a2 + 1);
                }
                this.f17150b.skip(a2 + 1);
            } else {
                throw new EOFException();
            }
        }
        if (z) {
            m21604a("FHCRC", (int) this.f17150b.mo19686Q(), (int) (short) ((int) this.f17153e.getValue()));
            this.f17153e.reset();
        }
    }

    /* renamed from: t */
    private void m21606t() throws IOException {
        m21604a("CRC", this.f17150b.mo19685P(), (int) this.f17153e.getValue());
        m21604a("ISIZE", this.f17150b.mo19685P(), (int) this.f17151c.getBytesWritten());
    }

    public void close() throws IOException {
        this.f17152d.close();
    }

    public long read(C3577c cVar, long j) throws IOException {
        if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        } else if (j == 0) {
            return 0;
        } else {
            if (this.f17149a == 0) {
                m21605d();
                this.f17149a = 1;
            }
            if (this.f17149a == 1) {
                long j2 = cVar.f10032b;
                long read = this.f17152d.read(cVar, j);
                if (read != -1) {
                    m21603a(cVar, j2, read);
                    return read;
                }
                this.f17149a = 2;
            }
            if (this.f17149a == 2) {
                m21606t();
                this.f17149a = 3;
                if (!this.f17150b.mo19681H()) {
                    throw new IOException("gzip finished without exhausting source");
                }
            }
            return -1;
        }
    }

    public C3587v timeout() {
        return this.f17150b.timeout();
    }

    /* renamed from: a */
    private void m21604a(String str, int i, int i2) throws IOException {
        if (i2 != i) {
            throw new IOException(String.format("%s: actual 0x%08x != expected 0x%08x", new Object[]{str, Integer.valueOf(i2), Integer.valueOf(i)}));
        }
    }
}
