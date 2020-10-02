package p119j;

import android.support.p004v4.media.session.PlaybackStateCompat;
import com.ogury.p159cm.OguryChoiceManager;
import com.tapjoy.TapjoyConstants;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.charset.Charset;
import javax.annotation.Nullable;

/* renamed from: j.c */
/* compiled from: Buffer */
public final class C3577c implements C3580e, C3579d, Cloneable, ByteChannel {

    /* renamed from: c */
    private static final byte[] f10030c = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102};
    @Nullable

    /* renamed from: a */
    C3583q f10031a;

    /* renamed from: b */
    long f10032b;

    /* renamed from: j.c$a */
    /* compiled from: Buffer */
    class C3578a extends InputStream {
        C3578a() {
        }

        public int available() {
            return (int) Math.min(C3577c.this.f10032b, 2147483647L);
        }

        public void close() {
        }

        public int read() {
            C3577c cVar = C3577c.this;
            if (cVar.f10032b > 0) {
                return cVar.readByte() & 255;
            }
            return -1;
        }

        public String toString() {
            return C3577c.this + ".inputStream()";
        }

        public int read(byte[] bArr, int i, int i2) {
            return C3577c.this.read(bArr, i, i2);
        }
    }

    /* renamed from: C */
    public C3577c mo19678C() {
        return this;
    }

    /* renamed from: F */
    public C3579d mo19679F() {
        return this;
    }

    /* renamed from: G */
    public byte[] mo19680G() {
        try {
            return mo19717k(this.f10032b);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    /* renamed from: H */
    public boolean mo19681H() {
        return this.f10032b == 0;
    }

    /* renamed from: J */
    public C3577c mo19682J() {
        return this;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0049, code lost:
        if (r8 != false) goto L_0x004e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x004b, code lost:
        r1.readByte();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0068, code lost:
        throw new java.lang.NumberFormatException("Number too large: " + r1.mo19732v());
     */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0099  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00a3  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0097 A[EDGE_INSN: B:48:0x0097->B:30:0x0097 ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:5:0x0019  */
    /* renamed from: K */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long mo19683K() {
        /*
            r17 = this;
            r0 = r17
            long r1 = r0.f10032b
            r3 = 0
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 == 0) goto L_0x00b6
            r5 = -7
            r7 = 0
            r8 = 0
            r9 = 0
        L_0x000f:
            j.q r10 = r0.f10031a
            byte[] r11 = r10.f10040a
            int r12 = r10.f10041b
            int r13 = r10.f10042c
        L_0x0017:
            if (r12 >= r13) goto L_0x0097
            byte r15 = r11[r12]
            r14 = 48
            if (r15 < r14) goto L_0x0069
            r1 = 57
            if (r15 > r1) goto L_0x0069
            int r14 = r14 - r15
            r1 = -922337203685477580(0xf333333333333334, double:-8.390303882365713E246)
            int r16 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r16 < 0) goto L_0x003e
            int r16 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r16 != 0) goto L_0x0037
            long r1 = (long) r14
            int r16 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
            if (r16 >= 0) goto L_0x0037
            goto L_0x003e
        L_0x0037:
            r1 = 10
            long r3 = r3 * r1
            long r1 = (long) r14
            long r3 = r3 + r1
            goto L_0x0073
        L_0x003e:
            j.c r1 = new j.c
            r1.<init>()
            r1.mo19719m((long) r3)
            r1.writeByte((int) r15)
            if (r8 != 0) goto L_0x004e
            r1.readByte()
        L_0x004e:
            java.lang.NumberFormatException r2 = new java.lang.NumberFormatException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Number too large: "
            r3.append(r4)
            java.lang.String r1 = r1.mo19732v()
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            r2.<init>(r1)
            throw r2
        L_0x0069:
            r1 = 45
            if (r15 != r1) goto L_0x0078
            if (r7 != 0) goto L_0x0078
            r1 = 1
            long r5 = r5 - r1
            r8 = 1
        L_0x0073:
            int r12 = r12 + 1
            int r7 = r7 + 1
            goto L_0x0017
        L_0x0078:
            if (r7 == 0) goto L_0x007c
            r9 = 1
            goto L_0x0097
        L_0x007c:
            java.lang.NumberFormatException r1 = new java.lang.NumberFormatException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Expected leading [0-9] or '-' character but was 0x"
            r2.append(r3)
            java.lang.String r3 = java.lang.Integer.toHexString(r15)
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r1
        L_0x0097:
            if (r12 != r13) goto L_0x00a3
            j.q r1 = r10.mo19769b()
            r0.f10031a = r1
            p119j.C3584r.m12203a(r10)
            goto L_0x00a5
        L_0x00a3:
            r10.f10041b = r12
        L_0x00a5:
            if (r9 != 0) goto L_0x00ab
            j.q r1 = r0.f10031a
            if (r1 != 0) goto L_0x000f
        L_0x00ab:
            long r1 = r0.f10032b
            long r5 = (long) r7
            long r1 = r1 - r5
            r0.f10032b = r1
            if (r8 == 0) goto L_0x00b4
            goto L_0x00b5
        L_0x00b4:
            long r3 = -r3
        L_0x00b5:
            return r3
        L_0x00b6:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "size == 0"
            r1.<init>(r2)
            goto L_0x00bf
        L_0x00be:
            throw r1
        L_0x00bf:
            goto L_0x00be
        */
        throw new UnsupportedOperationException("Method not decompiled: p119j.C3577c.mo19683K():long");
    }

    /* renamed from: M */
    public String mo19684M() throws EOFException {
        return mo19714i(Long.MAX_VALUE);
    }

    /* renamed from: P */
    public int mo19685P() {
        return C6597w.m21671a(readInt());
    }

    /* renamed from: Q */
    public short mo19686Q() {
        return C6597w.m21672a(readShort());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:30:0x008f, code lost:
        if (r8 != r9) goto L_0x009b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0091, code lost:
        r15.f10031a = r6.mo19769b();
        p119j.C3584r.m12203a(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x009b, code lost:
        r6.f10041b = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x009d, code lost:
        if (r1 != false) goto L_0x00a3;
     */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0072  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0074 A[SYNTHETIC] */
    /* renamed from: U */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long mo19687U() {
        /*
            r15 = this;
            long r0 = r15.f10032b
            r2 = 0
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 == 0) goto L_0x00aa
            r0 = 0
            r4 = r2
            r1 = 0
        L_0x000b:
            j.q r6 = r15.f10031a
            byte[] r7 = r6.f10040a
            int r8 = r6.f10041b
            int r9 = r6.f10042c
        L_0x0013:
            if (r8 >= r9) goto L_0x008f
            byte r10 = r7[r8]
            r11 = 48
            if (r10 < r11) goto L_0x0022
            r11 = 57
            if (r10 > r11) goto L_0x0022
            int r11 = r10 + -48
            goto L_0x003a
        L_0x0022:
            r11 = 97
            if (r10 < r11) goto L_0x002f
            r11 = 102(0x66, float:1.43E-43)
            if (r10 > r11) goto L_0x002f
            int r11 = r10 + -97
        L_0x002c:
            int r11 = r11 + 10
            goto L_0x003a
        L_0x002f:
            r11 = 65
            if (r10 < r11) goto L_0x0070
            r11 = 70
            if (r10 > r11) goto L_0x0070
            int r11 = r10 + -65
            goto L_0x002c
        L_0x003a:
            r12 = -1152921504606846976(0xf000000000000000, double:-3.105036184601418E231)
            long r12 = r12 & r4
            int r14 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1))
            if (r14 != 0) goto L_0x004a
            r10 = 4
            long r4 = r4 << r10
            long r10 = (long) r11
            long r4 = r4 | r10
            int r8 = r8 + 1
            int r0 = r0 + 1
            goto L_0x0013
        L_0x004a:
            j.c r0 = new j.c
            r0.<init>()
            r0.mo19716j((long) r4)
            r0.writeByte((int) r10)
            java.lang.NumberFormatException r1 = new java.lang.NumberFormatException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Number too large: "
            r2.append(r3)
            java.lang.String r0 = r0.mo19732v()
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            r1.<init>(r0)
            throw r1
        L_0x0070:
            if (r0 == 0) goto L_0x0074
            r1 = 1
            goto L_0x008f
        L_0x0074:
            java.lang.NumberFormatException r0 = new java.lang.NumberFormatException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Expected leading [0-9a-fA-F] character but was 0x"
            r1.append(r2)
            java.lang.String r2 = java.lang.Integer.toHexString(r10)
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x008f:
            if (r8 != r9) goto L_0x009b
            j.q r7 = r6.mo19769b()
            r15.f10031a = r7
            p119j.C3584r.m12203a(r6)
            goto L_0x009d
        L_0x009b:
            r6.f10041b = r8
        L_0x009d:
            if (r1 != 0) goto L_0x00a3
            j.q r6 = r15.f10031a
            if (r6 != 0) goto L_0x000b
        L_0x00a3:
            long r1 = r15.f10032b
            long r6 = (long) r0
            long r1 = r1 - r6
            r15.f10032b = r1
            return r4
        L_0x00aa:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "size == 0"
            r0.<init>(r1)
            goto L_0x00b3
        L_0x00b2:
            throw r0
        L_0x00b3:
            goto L_0x00b2
        */
        throw new UnsupportedOperationException("Method not decompiled: p119j.C3577c.mo19687U():long");
    }

    /* renamed from: V */
    public InputStream mo19688V() {
        return new C3578a();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public C3583q mo19703b(int i) {
        if (i < 1 || i > 8192) {
            throw new IllegalArgumentException();
        }
        C3583q qVar = this.f10031a;
        if (qVar == null) {
            C3583q a = C3584r.m12202a();
            this.f10031a = a;
            a.f10046g = a;
            a.f10045f = a;
            return a;
        }
        C3583q qVar2 = qVar.f10046g;
        if (qVar2.f10042c + i <= 8192 && qVar2.f10044e) {
            return qVar2;
        }
        C3583q a2 = C3584r.m12202a();
        qVar2.mo19766a(a2);
        return a2;
    }

    /* renamed from: c */
    public C3577c mo19704c(int i) {
        if (i < 128) {
            writeByte(i);
        } else if (i < 2048) {
            writeByte((i >> 6) | 192);
            writeByte((i & 63) | OguryChoiceManager.TcfV2.Purpose.MEASURE_AD_PERFORMANCE);
        } else if (i < 65536) {
            if (i < 55296 || i > 57343) {
                writeByte((i >> 12) | 224);
                writeByte(((i >> 6) & 63) | OguryChoiceManager.TcfV2.Purpose.MEASURE_AD_PERFORMANCE);
                writeByte((i & 63) | OguryChoiceManager.TcfV2.Purpose.MEASURE_AD_PERFORMANCE);
            } else {
                writeByte(63);
            }
        } else if (i <= 1114111) {
            writeByte((i >> 18) | 240);
            writeByte(((i >> 12) & 63) | OguryChoiceManager.TcfV2.Purpose.MEASURE_AD_PERFORMANCE);
            writeByte(((i >> 6) & 63) | OguryChoiceManager.TcfV2.Purpose.MEASURE_AD_PERFORMANCE);
            writeByte((i & 63) | OguryChoiceManager.TcfV2.Purpose.MEASURE_AD_PERFORMANCE);
        } else {
            throw new IllegalArgumentException("Unexpected code point: " + Integer.toHexString(i));
        }
        return this;
    }

    public void close() {
    }

    /* renamed from: d */
    public final void mo19706d() {
        try {
            skip(this.f10032b);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C3577c)) {
            return false;
        }
        C3577c cVar = (C3577c) obj;
        long j = this.f10032b;
        if (j != cVar.f10032b) {
            return false;
        }
        long j2 = 0;
        if (j == 0) {
            return true;
        }
        C3583q qVar = this.f10031a;
        C3583q qVar2 = cVar.f10031a;
        int i = qVar.f10041b;
        int i2 = qVar2.f10041b;
        while (j2 < this.f10032b) {
            long min = (long) Math.min(qVar.f10042c - i, qVar2.f10042c - i2);
            int i3 = 0;
            while (((long) i3) < min) {
                int i4 = i + 1;
                int i5 = i2 + 1;
                if (qVar.f10040a[i] != qVar2.f10040a[i2]) {
                    return false;
                }
                i3++;
                i = i4;
                i2 = i5;
            }
            if (i == qVar.f10042c) {
                qVar = qVar.f10045f;
                i = qVar.f10041b;
            }
            if (i2 == qVar2.f10042c) {
                qVar2 = qVar2.f10045f;
                i2 = qVar2.f10041b;
            }
            j2 += min;
        }
        return true;
    }

    public void flush() {
    }

    /* renamed from: h */
    public C3581f mo19712h(long j) throws EOFException {
        return new C3581f(mo19717k(j));
    }

    public int hashCode() {
        C3583q qVar = this.f10031a;
        if (qVar == null) {
            return 0;
        }
        int i = 1;
        do {
            int i2 = qVar.f10042c;
            for (int i3 = qVar.f10041b; i3 < i2; i3++) {
                i = (i * 31) + qVar.f10040a[i3];
            }
            qVar = qVar.f10045f;
        } while (qVar != this.f10031a);
        return i;
    }

    /* renamed from: i */
    public String mo19714i(long j) throws EOFException {
        if (j >= 0) {
            long j2 = Long.MAX_VALUE;
            if (j != Long.MAX_VALUE) {
                j2 = j + 1;
            }
            long a = mo19690a((byte) 10, 0, j2);
            if (a != -1) {
                return mo19720n(a);
            }
            if (j2 < size() && mo19707e(j2 - 1) == 13 && mo19707e(j2) == 10) {
                return mo19720n(j2);
            }
            C3577c cVar = new C3577c();
            mo19693a(cVar, 0, Math.min(32, size()));
            throw new EOFException("\\n not found: limit=" + Math.min(size(), j) + " content=" + cVar.mo19731u().mo19752b() + 8230);
        }
        throw new IllegalArgumentException("limit < 0: " + j);
    }

    public boolean isOpen() {
        return true;
    }

    /* renamed from: k */
    public byte[] mo19717k(long j) throws EOFException {
        C6597w.m21673a(this.f10032b, 0, j);
        if (j <= 2147483647L) {
            byte[] bArr = new byte[((int) j)];
            readFully(bArr);
            return bArr;
        }
        throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + j);
    }

    /* renamed from: l */
    public void mo19718l(long j) throws EOFException {
        if (this.f10032b < j) {
            throw new EOFException();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: n */
    public String mo19720n(long j) throws EOFException {
        if (j > 0) {
            long j2 = j - 1;
            if (mo19707e(j2) == 13) {
                String g = mo19711g(j2);
                skip(2);
                return g;
            }
        }
        String g2 = mo19711g(j);
        skip(1);
        return g2;
    }

    public int read(byte[] bArr, int i, int i2) {
        C6597w.m21673a((long) bArr.length, (long) i, (long) i2);
        C3583q qVar = this.f10031a;
        if (qVar == null) {
            return -1;
        }
        int min = Math.min(i2, qVar.f10042c - qVar.f10041b);
        System.arraycopy(qVar.f10040a, qVar.f10041b, bArr, i, min);
        int i3 = qVar.f10041b + min;
        qVar.f10041b = i3;
        this.f10032b -= (long) min;
        if (i3 == qVar.f10042c) {
            this.f10031a = qVar.mo19769b();
            C3584r.m12203a(qVar);
        }
        return min;
    }

    public byte readByte() {
        long j = this.f10032b;
        if (j != 0) {
            C3583q qVar = this.f10031a;
            int i = qVar.f10041b;
            int i2 = qVar.f10042c;
            int i3 = i + 1;
            byte b = qVar.f10040a[i];
            this.f10032b = j - 1;
            if (i3 == i2) {
                this.f10031a = qVar.mo19769b();
                C3584r.m12203a(qVar);
            } else {
                qVar.f10041b = i3;
            }
            return b;
        }
        throw new IllegalStateException("size == 0");
    }

    public void readFully(byte[] bArr) throws EOFException {
        int i = 0;
        while (i < bArr.length) {
            int read = read(bArr, i, bArr.length - i);
            if (read != -1) {
                i += read;
            } else {
                throw new EOFException();
            }
        }
    }

    public int readInt() {
        long j = this.f10032b;
        if (j >= 4) {
            C3583q qVar = this.f10031a;
            int i = qVar.f10041b;
            int i2 = qVar.f10042c;
            if (i2 - i < 4) {
                return ((readByte() & 255) << 24) | ((readByte() & 255) << 16) | ((readByte() & 255) << 8) | (readByte() & 255);
            }
            byte[] bArr = qVar.f10040a;
            int i3 = i + 1;
            int i4 = i3 + 1;
            byte b = ((bArr[i] & 255) << 24) | ((bArr[i3] & 255) << 16);
            int i5 = i4 + 1;
            byte b2 = b | ((bArr[i4] & 255) << 8);
            int i6 = i5 + 1;
            byte b3 = b2 | (bArr[i5] & 255);
            this.f10032b = j - 4;
            if (i6 == i2) {
                this.f10031a = qVar.mo19769b();
                C3584r.m12203a(qVar);
            } else {
                qVar.f10041b = i6;
            }
            return b3;
        }
        throw new IllegalStateException("size < 4: " + this.f10032b);
    }

    public short readShort() {
        long j = this.f10032b;
        if (j >= 2) {
            C3583q qVar = this.f10031a;
            int i = qVar.f10041b;
            int i2 = qVar.f10042c;
            if (i2 - i < 2) {
                return (short) (((readByte() & 255) << 8) | (readByte() & 255));
            }
            byte[] bArr = qVar.f10040a;
            int i3 = i + 1;
            int i4 = i3 + 1;
            byte b = ((bArr[i] & 255) << 8) | (bArr[i3] & 255);
            this.f10032b = j - 2;
            if (i4 == i2) {
                this.f10031a = qVar.mo19769b();
                C3584r.m12203a(qVar);
            } else {
                qVar.f10041b = i4;
            }
            return (short) b;
        }
        throw new IllegalStateException("size < 2: " + this.f10032b);
    }

    public final long size() {
        return this.f10032b;
    }

    public void skip(long j) throws EOFException {
        while (j > 0) {
            C3583q qVar = this.f10031a;
            if (qVar != null) {
                int min = (int) Math.min(j, (long) (qVar.f10042c - qVar.f10041b));
                long j2 = (long) min;
                this.f10032b -= j2;
                j -= j2;
                C3583q qVar2 = this.f10031a;
                int i = qVar2.f10041b + min;
                qVar2.f10041b = i;
                if (i == qVar2.f10042c) {
                    this.f10031a = qVar2.mo19769b();
                    C3584r.m12203a(qVar2);
                }
            } else {
                throw new EOFException();
            }
        }
    }

    /* renamed from: t */
    public final long mo19729t() {
        long j = this.f10032b;
        if (j == 0) {
            return 0;
        }
        C3583q qVar = this.f10031a.f10046g;
        int i = qVar.f10042c;
        return (i >= 8192 || !qVar.f10044e) ? j : j - ((long) (i - qVar.f10041b));
    }

    public C3587v timeout() {
        return C3587v.f10049d;
    }

    public String toString() {
        return mo19733w().toString();
    }

    /* renamed from: u */
    public C3581f mo19731u() {
        return new C3581f(mo19680G());
    }

    /* renamed from: v */
    public String mo19732v() {
        try {
            return mo19699a(this.f10032b, C6597w.f17172a);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    /* renamed from: w */
    public final C3581f mo19733w() {
        long j = this.f10032b;
        if (j <= 2147483647L) {
            return mo19698a((int) j);
        }
        throw new IllegalArgumentException("size > Integer.MAX_VALUE: " + this.f10032b);
    }

    /* renamed from: a */
    public final C3577c mo19693a(C3577c cVar, long j, long j2) {
        if (cVar != null) {
            C6597w.m21673a(this.f10032b, j, j2);
            if (j2 == 0) {
                return this;
            }
            cVar.f10032b += j2;
            C3583q qVar = this.f10031a;
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
                C3583q c = qVar.mo19770c();
                int i3 = (int) (((long) c.f10041b) + j);
                c.f10041b = i3;
                c.f10042c = Math.min(i3 + ((int) j2), c.f10042c);
                C3583q qVar2 = cVar.f10031a;
                if (qVar2 == null) {
                    c.f10046g = c;
                    c.f10045f = c;
                    cVar.f10031a = c;
                } else {
                    qVar2.f10046g.mo19766a(c);
                }
                j2 -= (long) (c.f10042c - c.f10041b);
                qVar = qVar.f10045f;
                j = 0;
            }
            return this;
        }
        throw new IllegalArgumentException("out == null");
    }

    public C3577c clone() {
        C3577c cVar = new C3577c();
        if (this.f10032b == 0) {
            return cVar;
        }
        C3583q c = this.f10031a.mo19770c();
        cVar.f10031a = c;
        c.f10046g = c;
        c.f10045f = c;
        C3583q qVar = this.f10031a;
        while (true) {
            qVar = qVar.f10045f;
            if (qVar != this.f10031a) {
                cVar.f10031a.f10046g.mo19766a(qVar.mo19770c());
            } else {
                cVar.f10032b = this.f10032b;
                return cVar;
            }
        }
    }

    /* renamed from: e */
    public final byte mo19707e(long j) {
        int i;
        C6597w.m21673a(this.f10032b, j, 1);
        long j2 = this.f10032b;
        if (j2 - j > j) {
            C3583q qVar = this.f10031a;
            while (true) {
                int i2 = qVar.f10042c;
                int i3 = qVar.f10041b;
                long j3 = (long) (i2 - i3);
                if (j < j3) {
                    return qVar.f10040a[i3 + ((int) j)];
                }
                j -= j3;
                qVar = qVar.f10045f;
            }
        } else {
            long j4 = j - j2;
            C3583q qVar2 = this.f10031a;
            do {
                qVar2 = qVar2.f10046g;
                int i4 = qVar2.f10042c;
                i = qVar2.f10041b;
                j4 += (long) (i4 - i);
            } while (j4 < 0);
            return qVar2.f10040a[i + ((int) j4)];
        }
    }

    /* renamed from: g */
    public String mo19711g(long j) throws EOFException {
        return mo19699a(j, C6597w.f17172a);
    }

    /* renamed from: j */
    public C3577c mo19716j(long j) {
        if (j == 0) {
            writeByte(48);
            return this;
        }
        int numberOfTrailingZeros = (Long.numberOfTrailingZeros(Long.highestOneBit(j)) / 4) + 1;
        C3583q b = mo19703b(numberOfTrailingZeros);
        byte[] bArr = b.f10040a;
        int i = b.f10042c;
        for (int i2 = (i + numberOfTrailingZeros) - 1; i2 >= i; i2--) {
            bArr[i2] = f10030c[(int) (15 & j)];
            j >>>= 4;
        }
        b.f10042c += numberOfTrailingZeros;
        this.f10032b += (long) numberOfTrailingZeros;
        return this;
    }

    /* renamed from: m */
    public C3577c mo19719m(long j) {
        if (j == 0) {
            writeByte(48);
            return this;
        }
        boolean z = false;
        int i = 1;
        if (j < 0) {
            j = -j;
            if (j < 0) {
                mo19708e("-9223372036854775808");
                return this;
            }
            z = true;
        }
        if (j >= 100000000) {
            i = j < 1000000000000L ? j < 10000000000L ? j < 1000000000 ? 9 : 10 : j < 100000000000L ? 11 : 12 : j < 1000000000000000L ? j < 10000000000000L ? 13 : j < 100000000000000L ? 14 : 15 : j < 100000000000000000L ? j < 10000000000000000L ? 16 : 17 : j < 1000000000000000000L ? 18 : 19;
        } else if (j >= TapjoyConstants.TIMER_INCREMENT) {
            i = j < 1000000 ? j < 100000 ? 5 : 6 : j < 10000000 ? 7 : 8;
        } else if (j >= 100) {
            i = j < 1000 ? 3 : 4;
        } else if (j >= 10) {
            i = 2;
        }
        if (z) {
            i++;
        }
        C3583q b = mo19703b(i);
        byte[] bArr = b.f10040a;
        int i2 = b.f10042c + i;
        while (j != 0) {
            i2--;
            bArr[i2] = f10030c[(int) (j % 10)];
            j /= 10;
        }
        if (z) {
            bArr[i2 - 1] = 45;
        }
        b.f10042c += i;
        this.f10032b += (long) i;
        return this;
    }

    public C3577c writeByte(int i) {
        C3583q b = mo19703b(1);
        byte[] bArr = b.f10040a;
        int i2 = b.f10042c;
        b.f10042c = i2 + 1;
        bArr[i2] = (byte) i;
        this.f10032b++;
        return this;
    }

    public C3577c writeInt(int i) {
        C3583q b = mo19703b(4);
        byte[] bArr = b.f10040a;
        int i2 = b.f10042c;
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((i >>> 24) & 255);
        int i4 = i3 + 1;
        bArr[i3] = (byte) ((i >>> 16) & 255);
        int i5 = i4 + 1;
        bArr[i4] = (byte) ((i >>> 8) & 255);
        bArr[i5] = (byte) (i & 255);
        b.f10042c = i5 + 1;
        this.f10032b += 4;
        return this;
    }

    public C3577c writeShort(int i) {
        C3583q b = mo19703b(2);
        byte[] bArr = b.f10040a;
        int i2 = b.f10042c;
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((i >>> 8) & 255);
        bArr[i3] = (byte) (i & 255);
        b.f10042c = i3 + 1;
        this.f10032b += 2;
        return this;
    }

    /* renamed from: g */
    public C3577c mo19710g(int i) {
        writeInt(C6597w.m21671a(i));
        return this;
    }

    public C3577c write(byte[] bArr) {
        if (bArr != null) {
            write(bArr, 0, bArr.length);
            return this;
        }
        throw new IllegalArgumentException("source == null");
    }

    public C3577c write(byte[] bArr, int i, int i2) {
        if (bArr != null) {
            long j = (long) i2;
            C6597w.m21673a((long) bArr.length, (long) i, j);
            int i3 = i2 + i;
            while (i < i3) {
                C3583q b = mo19703b(1);
                int min = Math.min(i3 - i, 8192 - b.f10042c);
                System.arraycopy(bArr, i, b.f10040a, b.f10042c, min);
                i += min;
                b.f10042c += min;
            }
            this.f10032b += j;
            return this;
        }
        throw new IllegalArgumentException("source == null");
    }

    public int read(ByteBuffer byteBuffer) throws IOException {
        C3583q qVar = this.f10031a;
        if (qVar == null) {
            return -1;
        }
        int min = Math.min(byteBuffer.remaining(), qVar.f10042c - qVar.f10041b);
        byteBuffer.put(qVar.f10040a, qVar.f10041b, min);
        int i = qVar.f10041b + min;
        qVar.f10041b = i;
        this.f10032b -= (long) min;
        if (i == qVar.f10042c) {
            this.f10031a = qVar.mo19769b();
            C3584r.m12203a(qVar);
        }
        return min;
    }

    /* renamed from: e */
    public C3577c mo19708e(String str) {
        mo19695a(str, 0, str.length());
        return this;
    }

    public int write(ByteBuffer byteBuffer) throws IOException {
        if (byteBuffer != null) {
            int remaining = byteBuffer.remaining();
            int i = remaining;
            while (i > 0) {
                C3583q b = mo19703b(1);
                int min = Math.min(i, 8192 - b.f10042c);
                byteBuffer.get(b.f10040a, b.f10042c, min);
                i -= min;
                b.f10042c += min;
            }
            this.f10032b += (long) remaining;
            return remaining;
        }
        throw new IllegalArgumentException("source == null");
    }

    /* renamed from: a */
    public long mo19691a(C3585t tVar) throws IOException {
        long j = this.f10032b;
        if (j > 0) {
            tVar.mo19670a(this, j);
        }
        return j;
    }

    /* renamed from: a */
    public String mo19700a(Charset charset) {
        try {
            return mo19699a(this.f10032b, charset);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    public long read(C3577c cVar, long j) {
        if (cVar == null) {
            throw new IllegalArgumentException("sink == null");
        } else if (j >= 0) {
            long j2 = this.f10032b;
            if (j2 == 0) {
                return -1;
            }
            if (j > j2) {
                j = j2;
            }
            cVar.mo19670a(this, j);
            return j;
        } else {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        }
    }

    /* renamed from: a */
    public String mo19699a(long j, Charset charset) throws EOFException {
        C6597w.m21673a(this.f10032b, 0, j);
        if (charset == null) {
            throw new IllegalArgumentException("charset == null");
        } else if (j > 2147483647L) {
            throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + j);
        } else if (j == 0) {
            return "";
        } else {
            C3583q qVar = this.f10031a;
            if (((long) qVar.f10041b) + j > ((long) qVar.f10042c)) {
                return new String(mo19717k(j), charset);
            }
            String str = new String(qVar.f10040a, qVar.f10041b, (int) j, charset);
            int i = (int) (((long) qVar.f10041b) + j);
            qVar.f10041b = i;
            this.f10032b -= j;
            if (i == qVar.f10042c) {
                this.f10031a = qVar.mo19769b();
                C3584r.m12203a(qVar);
            }
            return str;
        }
    }

    /* renamed from: a */
    public C3577c mo19694a(C3581f fVar) {
        if (fVar != null) {
            fVar.mo19749a(this);
            return this;
        }
        throw new IllegalArgumentException("byteString == null");
    }

    /* renamed from: a */
    public C3577c mo19695a(String str, int i, int i2) {
        if (str == null) {
            throw new IllegalArgumentException("string == null");
        } else if (i < 0) {
            throw new IllegalArgumentException("beginIndex < 0: " + i);
        } else if (i2 < i) {
            throw new IllegalArgumentException("endIndex < beginIndex: " + i2 + " < " + i);
        } else if (i2 <= str.length()) {
            while (i < i2) {
                char charAt = str.charAt(i);
                if (charAt < 128) {
                    C3583q b = mo19703b(1);
                    byte[] bArr = b.f10040a;
                    int i3 = b.f10042c - i;
                    int min = Math.min(i2, 8192 - i3);
                    int i4 = i + 1;
                    bArr[i + i3] = (byte) charAt;
                    while (i4 < min) {
                        char charAt2 = str.charAt(i4);
                        if (charAt2 >= 128) {
                            break;
                        }
                        bArr[i4 + i3] = (byte) charAt2;
                        i4++;
                    }
                    int i5 = b.f10042c;
                    int i6 = (i3 + i4) - i5;
                    b.f10042c = i5 + i6;
                    this.f10032b += (long) i6;
                    i = i4;
                } else {
                    if (charAt < 2048) {
                        writeByte((charAt >> 6) | 192);
                        writeByte((int) (charAt & '?') | 128);
                    } else if (charAt < 55296 || charAt > 57343) {
                        writeByte((charAt >> 12) | 224);
                        writeByte(((charAt >> 6) & 63) | OguryChoiceManager.TcfV2.Purpose.MEASURE_AD_PERFORMANCE);
                        writeByte((int) (charAt & '?') | 128);
                    } else {
                        int i7 = i + 1;
                        char charAt3 = i7 < i2 ? str.charAt(i7) : 0;
                        if (charAt > 56319 || charAt3 < 56320 || charAt3 > 57343) {
                            writeByte(63);
                            i = i7;
                        } else {
                            int i8 = (((charAt & 10239) << 10) | (9215 & charAt3)) + 0;
                            writeByte((i8 >> 18) | 240);
                            writeByte(((i8 >> 12) & 63) | OguryChoiceManager.TcfV2.Purpose.MEASURE_AD_PERFORMANCE);
                            writeByte(((i8 >> 6) & 63) | OguryChoiceManager.TcfV2.Purpose.MEASURE_AD_PERFORMANCE);
                            writeByte((i8 & 63) | OguryChoiceManager.TcfV2.Purpose.MEASURE_AD_PERFORMANCE);
                            i += 2;
                        }
                    }
                    i++;
                }
            }
            return this;
        } else {
            throw new IllegalArgumentException("endIndex > string.length: " + i2 + " > " + str.length());
        }
    }

    /* renamed from: a */
    public C3577c mo19697a(String str, Charset charset) {
        mo19696a(str, 0, str.length(), charset);
        return this;
    }

    /* renamed from: a */
    public C3577c mo19696a(String str, int i, int i2, Charset charset) {
        if (str == null) {
            throw new IllegalArgumentException("string == null");
        } else if (i < 0) {
            throw new IllegalAccessError("beginIndex < 0: " + i);
        } else if (i2 < i) {
            throw new IllegalArgumentException("endIndex < beginIndex: " + i2 + " < " + i);
        } else if (i2 > str.length()) {
            throw new IllegalArgumentException("endIndex > string.length: " + i2 + " > " + str.length());
        } else if (charset == null) {
            throw new IllegalArgumentException("charset == null");
        } else if (charset.equals(C6597w.f17172a)) {
            mo19695a(str, i, i2);
            return this;
        } else {
            byte[] bytes = str.substring(i, i2).getBytes(charset);
            write(bytes, 0, bytes.length);
            return this;
        }
    }

    /* renamed from: a */
    public long mo19692a(C3586u uVar) throws IOException {
        if (uVar != null) {
            long j = 0;
            while (true) {
                long read = uVar.read(this, PlaybackStateCompat.ACTION_PLAY_FROM_URI);
                if (read == -1) {
                    return j;
                }
                j += read;
            }
        } else {
            throw new IllegalArgumentException("source == null");
        }
    }

    /* renamed from: a */
    public void mo19670a(C3577c cVar, long j) {
        int i;
        if (cVar == null) {
            throw new IllegalArgumentException("source == null");
        } else if (cVar != this) {
            C6597w.m21673a(cVar.f10032b, 0, j);
            while (j > 0) {
                C3583q qVar = cVar.f10031a;
                if (j < ((long) (qVar.f10042c - qVar.f10041b))) {
                    C3583q qVar2 = this.f10031a;
                    C3583q qVar3 = qVar2 != null ? qVar2.f10046g : null;
                    if (qVar3 != null && qVar3.f10044e) {
                        long j2 = ((long) qVar3.f10042c) + j;
                        if (qVar3.f10043d) {
                            i = 0;
                        } else {
                            i = qVar3.f10041b;
                        }
                        if (j2 - ((long) i) <= PlaybackStateCompat.ACTION_PLAY_FROM_URI) {
                            cVar.f10031a.mo19768a(qVar3, (int) j);
                            cVar.f10032b -= j;
                            this.f10032b += j;
                            return;
                        }
                    }
                    cVar.f10031a = cVar.f10031a.mo19765a((int) j);
                }
                C3583q qVar4 = cVar.f10031a;
                long j3 = (long) (qVar4.f10042c - qVar4.f10041b);
                cVar.f10031a = qVar4.mo19769b();
                C3583q qVar5 = this.f10031a;
                if (qVar5 == null) {
                    this.f10031a = qVar4;
                    qVar4.f10046g = qVar4;
                    qVar4.f10045f = qVar4;
                } else {
                    qVar5.f10046g.mo19766a(qVar4);
                    qVar4.mo19767a();
                }
                cVar.f10032b -= j3;
                this.f10032b += j3;
                j -= j3;
            }
        } else {
            throw new IllegalArgumentException("source == this");
        }
    }

    /* renamed from: a */
    public long mo19689a(byte b) {
        return mo19690a(b, 0, Long.MAX_VALUE);
    }

    /* renamed from: a */
    public long mo19690a(byte b, long j, long j2) {
        C3583q qVar;
        long j3 = 0;
        if (j < 0 || j2 < j) {
            throw new IllegalArgumentException(String.format("size=%s fromIndex=%s toIndex=%s", new Object[]{Long.valueOf(this.f10032b), Long.valueOf(j), Long.valueOf(j2)}));
        }
        long j4 = this.f10032b;
        if (j2 <= j4) {
            j4 = j2;
        }
        if (j == j4 || (qVar = this.f10031a) == null) {
            return -1;
        }
        long j5 = this.f10032b;
        if (j5 - j < j) {
            while (j5 > j) {
                qVar = qVar.f10046g;
                j5 -= (long) (qVar.f10042c - qVar.f10041b);
            }
        } else {
            while (true) {
                long j6 = ((long) (qVar.f10042c - qVar.f10041b)) + j3;
                if (j6 >= j) {
                    break;
                }
                qVar = qVar.f10045f;
                j3 = j6;
            }
            j5 = j3;
        }
        long j7 = j;
        while (j5 < j4) {
            byte[] bArr = qVar.f10040a;
            int min = (int) Math.min((long) qVar.f10042c, (((long) qVar.f10041b) + j4) - j5);
            for (int i = (int) ((((long) qVar.f10041b) + j7) - j5); i < min; i++) {
                if (bArr[i] == b) {
                    return ((long) (i - qVar.f10041b)) + j5;
                }
            }
            byte b2 = b;
            j5 += (long) (qVar.f10042c - qVar.f10041b);
            qVar = qVar.f10045f;
            j7 = j5;
        }
        return -1;
    }

    /* renamed from: a */
    public boolean mo19701a(long j, C3581f fVar) {
        return mo19702a(j, fVar, 0, fVar.mo19759f());
    }

    /* renamed from: a */
    public boolean mo19702a(long j, C3581f fVar, int i, int i2) {
        if (j < 0 || i < 0 || i2 < 0 || this.f10032b - j < ((long) i2) || fVar.mo19759f() - i < i2) {
            return false;
        }
        for (int i3 = 0; i3 < i2; i3++) {
            if (mo19707e(((long) i3) + j) != fVar.mo19745a(i + i3)) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: a */
    public final C3581f mo19698a(int i) {
        if (i == 0) {
            return C3581f.f10035e;
        }
        return new C6596s(this, i);
    }
}
