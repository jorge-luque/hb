package p119j;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

/* renamed from: j.m */
/* compiled from: InflaterSource */
public final class C6588m implements C3586u {

    /* renamed from: a */
    private final C3580e f17154a;

    /* renamed from: b */
    private final Inflater f17155b;

    /* renamed from: c */
    private int f17156c;

    /* renamed from: d */
    private boolean f17157d;

    C6588m(C3580e eVar, Inflater inflater) {
        if (eVar == null) {
            throw new IllegalArgumentException("source == null");
        } else if (inflater != null) {
            this.f17154a = eVar;
            this.f17155b = inflater;
        } else {
            throw new IllegalArgumentException("inflater == null");
        }
    }

    /* renamed from: t */
    private void m21607t() throws IOException {
        int i = this.f17156c;
        if (i != 0) {
            int remaining = i - this.f17155b.getRemaining();
            this.f17156c -= remaining;
            this.f17154a.skip((long) remaining);
        }
    }

    public void close() throws IOException {
        if (!this.f17157d) {
            this.f17155b.end();
            this.f17157d = true;
            this.f17154a.close();
        }
    }

    /* renamed from: d */
    public final boolean mo35613d() throws IOException {
        if (!this.f17155b.needsInput()) {
            return false;
        }
        m21607t();
        if (this.f17155b.getRemaining() != 0) {
            throw new IllegalStateException("?");
        } else if (this.f17154a.mo19681H()) {
            return true;
        } else {
            C3583q qVar = this.f17154a.mo19678C().f10031a;
            int i = qVar.f10042c;
            int i2 = qVar.f10041b;
            int i3 = i - i2;
            this.f17156c = i3;
            this.f17155b.setInput(qVar.f10040a, i2, i3);
            return false;
        }
    }

    public long read(C3577c cVar, long j) throws IOException {
        C3583q b;
        if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        } else if (this.f17157d) {
            throw new IllegalStateException("closed");
        } else if (j == 0) {
            return 0;
        } else {
            while (true) {
                boolean d = mo35613d();
                try {
                    b = cVar.mo19703b(1);
                    int inflate = this.f17155b.inflate(b.f10040a, b.f10042c, (int) Math.min(j, (long) (8192 - b.f10042c)));
                    if (inflate > 0) {
                        b.f10042c += inflate;
                        long j2 = (long) inflate;
                        cVar.f10032b += j2;
                        return j2;
                    } else if (this.f17155b.finished()) {
                        break;
                    } else if (this.f17155b.needsDictionary()) {
                        break;
                    } else if (d) {
                        throw new EOFException("source exhausted prematurely");
                    }
                } catch (DataFormatException e) {
                    throw new IOException(e);
                }
            }
            m21607t();
            if (b.f10041b != b.f10042c) {
                return -1;
            }
            cVar.f10031a = b.mo19769b();
            C3584r.m12203a(b);
            return -1;
        }
    }

    public C3587v timeout() {
        return this.f17154a.timeout();
    }
}
