package p119j;

import java.io.IOException;
import java.util.zip.Deflater;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;

/* renamed from: j.g */
/* compiled from: DeflaterSink */
public final class C6582g implements C3585t {

    /* renamed from: a */
    private final C3579d f17139a;

    /* renamed from: b */
    private final Deflater f17140b;

    /* renamed from: c */
    private boolean f17141c;

    C6582g(C3579d dVar, Deflater deflater) {
        if (dVar == null) {
            throw new IllegalArgumentException("source == null");
        } else if (deflater != null) {
            this.f17139a = dVar;
            this.f17140b = deflater;
        } else {
            throw new IllegalArgumentException("inflater == null");
        }
    }

    /* renamed from: a */
    public void mo19670a(C3577c cVar, long j) throws IOException {
        C6597w.m21673a(cVar.f10032b, 0, j);
        while (j > 0) {
            C3583q qVar = cVar.f10031a;
            int min = (int) Math.min(j, (long) (qVar.f10042c - qVar.f10041b));
            this.f17140b.setInput(qVar.f10040a, qVar.f10041b, min);
            m21585a(false);
            long j2 = (long) min;
            cVar.f10032b -= j2;
            int i = qVar.f10041b + min;
            qVar.f10041b = i;
            if (i == qVar.f10042c) {
                cVar.f10031a = qVar.mo19769b();
                C3584r.m12203a(qVar);
            }
            j -= j2;
        }
    }

    public void close() throws IOException {
        if (!this.f17141c) {
            try {
                mo35606d();
                th = null;
            } catch (Throwable th) {
                th = th;
            }
            try {
                this.f17140b.end();
            } catch (Throwable th2) {
                if (th == null) {
                    th = th2;
                }
            }
            try {
                this.f17139a.close();
            } catch (Throwable th3) {
                if (th == null) {
                    th = th3;
                }
            }
            this.f17141c = true;
            if (th != null) {
                C6597w.m21674a(th);
                throw null;
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public void mo35606d() throws IOException {
        this.f17140b.finish();
        m21585a(false);
    }

    public void flush() throws IOException {
        m21585a(true);
        this.f17139a.flush();
    }

    public C3587v timeout() {
        return this.f17139a.timeout();
    }

    public String toString() {
        return "DeflaterSink(" + this.f17139a + ")";
    }

    @IgnoreJRERequirement
    /* renamed from: a */
    private void m21585a(boolean z) throws IOException {
        C3583q b;
        int i;
        C3577c C = this.f17139a.mo19678C();
        while (true) {
            b = C.mo19703b(1);
            if (z) {
                Deflater deflater = this.f17140b;
                byte[] bArr = b.f10040a;
                int i2 = b.f10042c;
                i = deflater.deflate(bArr, i2, 8192 - i2, 2);
            } else {
                Deflater deflater2 = this.f17140b;
                byte[] bArr2 = b.f10040a;
                int i3 = b.f10042c;
                i = deflater2.deflate(bArr2, i3, 8192 - i3);
            }
            if (i > 0) {
                b.f10042c += i;
                C.f10032b += (long) i;
                this.f17139a.mo19682J();
            } else if (this.f17140b.needsInput()) {
                break;
            }
        }
        if (b.f10041b == b.f10042c) {
            C.f10031a = b.mo19769b();
            C3584r.m12203a(b);
        }
    }
}
