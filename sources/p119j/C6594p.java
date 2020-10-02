package p119j;

import android.support.p004v4.media.session.PlaybackStateCompat;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* renamed from: j.p */
/* compiled from: RealBufferedSource */
final class C6594p implements C3580e {

    /* renamed from: a */
    public final C3577c f17166a = new C3577c();

    /* renamed from: b */
    public final C3586u f17167b;

    /* renamed from: c */
    boolean f17168c;

    C6594p(C3586u uVar) {
        if (uVar != null) {
            this.f17167b = uVar;
            return;
        }
        throw new NullPointerException("source == null");
    }

    /* renamed from: C */
    public C3577c mo19678C() {
        return this.f17166a;
    }

    /* renamed from: G */
    public byte[] mo19680G() throws IOException {
        this.f17166a.mo19692a(this.f17167b);
        return this.f17166a.mo19680G();
    }

    /* renamed from: H */
    public boolean mo19681H() throws IOException {
        if (!this.f17168c) {
            return this.f17166a.mo19681H() && this.f17167b.read(this.f17166a, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1;
        }
        throw new IllegalStateException("closed");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x002b  */
    /* renamed from: K */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long mo19683K() throws java.io.IOException {
        /*
            r6 = this;
            r0 = 1
            r6.mo19718l(r0)
            r0 = 0
            r1 = 0
        L_0x0007:
            int r2 = r1 + 1
            long r3 = (long) r2
            boolean r3 = r6.mo35621e(r3)
            if (r3 == 0) goto L_0x0040
            j.c r3 = r6.f17166a
            long r4 = (long) r1
            byte r3 = r3.mo19707e((long) r4)
            r4 = 48
            if (r3 < r4) goto L_0x001f
            r4 = 57
            if (r3 <= r4) goto L_0x0026
        L_0x001f:
            if (r1 != 0) goto L_0x0028
            r4 = 45
            if (r3 == r4) goto L_0x0026
            goto L_0x0028
        L_0x0026:
            r1 = r2
            goto L_0x0007
        L_0x0028:
            if (r1 == 0) goto L_0x002b
            goto L_0x0040
        L_0x002b:
            java.lang.NumberFormatException r1 = new java.lang.NumberFormatException
            r2 = 1
            java.lang.Object[] r2 = new java.lang.Object[r2]
            java.lang.Byte r3 = java.lang.Byte.valueOf(r3)
            r2[r0] = r3
            java.lang.String r0 = "Expected leading [0-9] or '-' character but was %#x"
            java.lang.String r0 = java.lang.String.format(r0, r2)
            r1.<init>(r0)
            throw r1
        L_0x0040:
            j.c r0 = r6.f17166a
            long r0 = r0.mo19683K()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p119j.C6594p.mo19683K():long");
    }

    /* renamed from: M */
    public String mo19684M() throws IOException {
        return mo19714i(Long.MAX_VALUE);
    }

    /* renamed from: P */
    public int mo19685P() throws IOException {
        mo19718l(4);
        return this.f17166a.mo19685P();
    }

    /* renamed from: Q */
    public short mo19686Q() throws IOException {
        mo19718l(2);
        return this.f17166a.mo19686Q();
    }

    /* renamed from: U */
    public long mo19687U() throws IOException {
        mo19718l(1);
        int i = 0;
        while (true) {
            int i2 = i + 1;
            if (!mo35621e((long) i2)) {
                break;
            }
            byte e = this.f17166a.mo19707e((long) i);
            if ((e >= 48 && e <= 57) || ((e >= 97 && e <= 102) || (e >= 65 && e <= 70))) {
                i = i2;
            } else if (i == 0) {
                throw new NumberFormatException(String.format("Expected leading [0-9a-fA-F] character but was %#x", new Object[]{Byte.valueOf(e)}));
            }
        }
        return this.f17166a.mo19687U();
    }

    /* renamed from: V */
    public InputStream mo19688V() {
        return new C6595a();
    }

    /* renamed from: a */
    public long mo19691a(C3585t tVar) throws IOException {
        if (tVar != null) {
            long j = 0;
            while (this.f17167b.read(this.f17166a, PlaybackStateCompat.ACTION_PLAY_FROM_URI) != -1) {
                long t = this.f17166a.mo19729t();
                if (t > 0) {
                    j += t;
                    tVar.mo19670a(this.f17166a, t);
                }
            }
            if (this.f17166a.size() <= 0) {
                return j;
            }
            long size = j + this.f17166a.size();
            C3577c cVar = this.f17166a;
            tVar.mo19670a(cVar, cVar.size());
            return size;
        }
        throw new IllegalArgumentException("sink == null");
    }

    public void close() throws IOException {
        if (!this.f17168c) {
            this.f17168c = true;
            this.f17167b.close();
            this.f17166a.mo19706d();
        }
    }

    /* renamed from: e */
    public boolean mo35621e(long j) throws IOException {
        C3577c cVar;
        if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        } else if (!this.f17168c) {
            do {
                cVar = this.f17166a;
                if (cVar.f10032b >= j) {
                    return true;
                }
            } while (this.f17167b.read(cVar, PlaybackStateCompat.ACTION_PLAY_FROM_URI) != -1);
            return false;
        } else {
            throw new IllegalStateException("closed");
        }
    }

    /* renamed from: h */
    public C3581f mo19712h(long j) throws IOException {
        mo19718l(j);
        return this.f17166a.mo19712h(j);
    }

    /* renamed from: i */
    public String mo19714i(long j) throws IOException {
        if (j >= 0) {
            long j2 = j == Long.MAX_VALUE ? Long.MAX_VALUE : j + 1;
            long a = mo35619a((byte) 10, 0, j2);
            if (a != -1) {
                return this.f17166a.mo19720n(a);
            }
            if (j2 < Long.MAX_VALUE && mo35621e(j2) && this.f17166a.mo19707e(j2 - 1) == 13 && mo35621e(1 + j2) && this.f17166a.mo19707e(j2) == 10) {
                return this.f17166a.mo19720n(j2);
            }
            C3577c cVar = new C3577c();
            C3577c cVar2 = this.f17166a;
            cVar2.mo19693a(cVar, 0, Math.min(32, cVar2.size()));
            throw new EOFException("\\n not found: limit=" + Math.min(this.f17166a.size(), j) + " content=" + cVar.mo19731u().mo19752b() + 8230);
        }
        throw new IllegalArgumentException("limit < 0: " + j);
    }

    public boolean isOpen() {
        return !this.f17168c;
    }

    /* renamed from: k */
    public byte[] mo19717k(long j) throws IOException {
        mo19718l(j);
        return this.f17166a.mo19717k(j);
    }

    /* renamed from: l */
    public void mo19718l(long j) throws IOException {
        if (!mo35621e(j)) {
            throw new EOFException();
        }
    }

    public long read(C3577c cVar, long j) throws IOException {
        if (cVar == null) {
            throw new IllegalArgumentException("sink == null");
        } else if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        } else if (!this.f17168c) {
            C3577c cVar2 = this.f17166a;
            if (cVar2.f10032b == 0 && this.f17167b.read(cVar2, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
                return -1;
            }
            return this.f17166a.read(cVar, Math.min(j, this.f17166a.f10032b));
        } else {
            throw new IllegalStateException("closed");
        }
    }

    public byte readByte() throws IOException {
        mo19718l(1);
        return this.f17166a.readByte();
    }

    public void readFully(byte[] bArr) throws IOException {
        try {
            mo19718l((long) bArr.length);
            this.f17166a.readFully(bArr);
        } catch (EOFException e) {
            int i = 0;
            while (true) {
                C3577c cVar = this.f17166a;
                long j = cVar.f10032b;
                if (j > 0) {
                    int read = cVar.read(bArr, i, (int) j);
                    if (read != -1) {
                        i += read;
                    } else {
                        throw new AssertionError();
                    }
                } else {
                    throw e;
                }
            }
        }
    }

    public int readInt() throws IOException {
        mo19718l(4);
        return this.f17166a.readInt();
    }

    public short readShort() throws IOException {
        mo19718l(2);
        return this.f17166a.readShort();
    }

    public void skip(long j) throws IOException {
        if (!this.f17168c) {
            while (j > 0) {
                C3577c cVar = this.f17166a;
                if (cVar.f10032b == 0 && this.f17167b.read(cVar, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
                    throw new EOFException();
                }
                long min = Math.min(j, this.f17166a.size());
                this.f17166a.skip(min);
                j -= min;
            }
            return;
        }
        throw new IllegalStateException("closed");
    }

    public C3587v timeout() {
        return this.f17167b.timeout();
    }

    public String toString() {
        return "buffer(" + this.f17167b + ")";
    }

    /* renamed from: j.p$a */
    /* compiled from: RealBufferedSource */
    class C6595a extends InputStream {
        C6595a() {
        }

        public int available() throws IOException {
            C6594p pVar = C6594p.this;
            if (!pVar.f17168c) {
                return (int) Math.min(pVar.f17166a.f10032b, 2147483647L);
            }
            throw new IOException("closed");
        }

        public void close() throws IOException {
            C6594p.this.close();
        }

        public int read() throws IOException {
            C6594p pVar = C6594p.this;
            if (!pVar.f17168c) {
                C3577c cVar = pVar.f17166a;
                if (cVar.f10032b == 0 && pVar.f17167b.read(cVar, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
                    return -1;
                }
                return C6594p.this.f17166a.readByte() & 255;
            }
            throw new IOException("closed");
        }

        public String toString() {
            return C6594p.this + ".inputStream()";
        }

        public int read(byte[] bArr, int i, int i2) throws IOException {
            if (!C6594p.this.f17168c) {
                C6597w.m21673a((long) bArr.length, (long) i, (long) i2);
                C6594p pVar = C6594p.this;
                C3577c cVar = pVar.f17166a;
                if (cVar.f10032b == 0 && pVar.f17167b.read(cVar, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
                    return -1;
                }
                return C6594p.this.f17166a.read(bArr, i, i2);
            }
            throw new IOException("closed");
        }
    }

    /* renamed from: a */
    public String mo19700a(Charset charset) throws IOException {
        if (charset != null) {
            this.f17166a.mo19692a(this.f17167b);
            return this.f17166a.mo19700a(charset);
        }
        throw new IllegalArgumentException("charset == null");
    }

    public int read(ByteBuffer byteBuffer) throws IOException {
        C3577c cVar = this.f17166a;
        if (cVar.f10032b == 0 && this.f17167b.read(cVar, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
            return -1;
        }
        return this.f17166a.read(byteBuffer);
    }

    /* renamed from: a */
    public long mo19689a(byte b) throws IOException {
        return mo35619a(b, 0, Long.MAX_VALUE);
    }

    /* renamed from: a */
    public long mo35619a(byte b, long j, long j2) throws IOException {
        if (this.f17168c) {
            throw new IllegalStateException("closed");
        } else if (j < 0 || j2 < j) {
            throw new IllegalArgumentException(String.format("fromIndex=%s toIndex=%s", new Object[]{Long.valueOf(j), Long.valueOf(j2)}));
        } else {
            while (j < j2) {
                long a = this.f17166a.mo19690a(b, j, j2);
                if (a == -1) {
                    C3577c cVar = this.f17166a;
                    long j3 = cVar.f10032b;
                    if (j3 >= j2 || this.f17167b.read(cVar, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
                        break;
                    }
                    j = Math.max(j, j3);
                } else {
                    return a;
                }
            }
            return -1;
        }
    }

    /* renamed from: a */
    public boolean mo19701a(long j, C3581f fVar) throws IOException {
        return mo35620a(j, fVar, 0, fVar.mo19759f());
    }

    /* renamed from: a */
    public boolean mo35620a(long j, C3581f fVar, int i, int i2) throws IOException {
        if (this.f17168c) {
            throw new IllegalStateException("closed");
        } else if (j < 0 || i < 0 || i2 < 0 || fVar.mo19759f() - i < i2) {
            return false;
        } else {
            for (int i3 = 0; i3 < i2; i3++) {
                long j2 = ((long) i3) + j;
                if (!mo35621e(1 + j2) || this.f17166a.mo19707e(j2) != fVar.mo19745a(i + i3)) {
                    return false;
                }
            }
            return true;
        }
    }
}
