package com.google.protobuf;

import com.google.android.gms.games.Notifications;
import com.google.protobuf.C3990e0;
import com.ogury.p159cm.OguryChoiceManager;
import java.io.IOException;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class CodedOutputStream extends C3989e {

    /* renamed from: a */
    private static final Logger f10716a = Logger.getLogger(CodedOutputStream.class.getName());
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static final boolean f10717b = C3987d0.m13290d();
    /* access modifiers changed from: private */

    /* renamed from: c */
    public static final long f10718c = C3987d0.m13287b();

    public static class OutOfSpaceException extends IOException {
        private static final long serialVersionUID = -6947486886997889499L;

        OutOfSpaceException() {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.");
        }

        OutOfSpaceException(Throwable th) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.", th);
        }

        OutOfSpaceException(String str, Throwable th) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.: " + str, th);
        }
    }

    /* renamed from: com.google.protobuf.CodedOutputStream$b */
    private static abstract class C3966b extends CodedOutputStream {

        /* renamed from: d */
        final byte[] f10719d;

        /* renamed from: e */
        final int f10720e;

        /* renamed from: f */
        int f10721f;

        /* renamed from: g */
        int f10722g;

        C3966b(int i) {
            super();
            if (i >= 0) {
                byte[] bArr = new byte[Math.max(i, 20)];
                this.f10719d = bArr;
                this.f10720e = bArr.length;
                return;
            }
            throw new IllegalArgumentException("bufferSize must be >= 0");
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public final void mo27980a(byte b) {
            byte[] bArr = this.f10719d;
            int i = this.f10721f;
            this.f10721f = i + 1;
            bArr[i] = b;
            this.f10722g++;
        }

        /* renamed from: c */
        public final int mo27976c() {
            throw new UnsupportedOperationException("spaceLeft() can only be called on CodedOutputStreams that are writing to a flat array or ByteBuffer.");
        }

        /* access modifiers changed from: package-private */
        /* renamed from: d */
        public final void mo27981d(long j) {
            byte[] bArr = this.f10719d;
            int i = this.f10721f;
            int i2 = i + 1;
            this.f10721f = i2;
            bArr[i] = (byte) ((int) (j & 255));
            int i3 = i2 + 1;
            this.f10721f = i3;
            bArr[i2] = (byte) ((int) ((j >> 8) & 255));
            int i4 = i3 + 1;
            this.f10721f = i4;
            bArr[i3] = (byte) ((int) ((j >> 16) & 255));
            int i5 = i4 + 1;
            this.f10721f = i5;
            bArr[i4] = (byte) ((int) (255 & (j >> 24)));
            int i6 = i5 + 1;
            this.f10721f = i6;
            bArr[i5] = (byte) (((int) (j >> 32)) & 255);
            int i7 = i6 + 1;
            this.f10721f = i7;
            bArr[i6] = (byte) (((int) (j >> 40)) & 255);
            int i8 = i7 + 1;
            this.f10721f = i8;
            bArr[i7] = (byte) (((int) (j >> 48)) & 255);
            this.f10721f = i8 + 1;
            bArr[i8] = (byte) (((int) (j >> 56)) & 255);
            this.f10722g += 8;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: e */
        public final void mo27982e(long j) {
            if (CodedOutputStream.f10717b) {
                long e = CodedOutputStream.f10718c + ((long) this.f10721f);
                long j2 = j;
                long j3 = e;
                while ((j2 & -128) != 0) {
                    C3987d0.m13286a(this.f10719d, j3, (byte) ((((int) j2) & Notifications.NOTIFICATION_TYPES_ALL) | OguryChoiceManager.TcfV2.Purpose.MEASURE_AD_PERFORMANCE));
                    j2 >>>= 7;
                    j3 = 1 + j3;
                }
                C3987d0.m13286a(this.f10719d, j3, (byte) ((int) j2));
                int i = (int) ((1 + j3) - e);
                this.f10721f += i;
                this.f10722g += i;
                return;
            }
            long j4 = j;
            while ((j4 & -128) != 0) {
                byte[] bArr = this.f10719d;
                int i2 = this.f10721f;
                this.f10721f = i2 + 1;
                bArr[i2] = (byte) ((((int) j4) & Notifications.NOTIFICATION_TYPES_ALL) | OguryChoiceManager.TcfV2.Purpose.MEASURE_AD_PERFORMANCE);
                this.f10722g++;
                j4 >>>= 7;
            }
            byte[] bArr2 = this.f10719d;
            int i3 = this.f10721f;
            this.f10721f = i3 + 1;
            bArr2[i3] = (byte) ((int) j4);
            this.f10722g++;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: h */
        public final void mo27983h(int i, int i2) {
            mo27986m(C4005f0.m13358a(i, i2));
        }

        /* access modifiers changed from: package-private */
        /* renamed from: k */
        public final void mo27984k(int i) {
            byte[] bArr = this.f10719d;
            int i2 = this.f10721f;
            int i3 = i2 + 1;
            this.f10721f = i3;
            bArr[i2] = (byte) (i & 255);
            int i4 = i3 + 1;
            this.f10721f = i4;
            bArr[i3] = (byte) ((i >> 8) & 255);
            int i5 = i4 + 1;
            this.f10721f = i5;
            bArr[i4] = (byte) ((i >> 16) & 255);
            this.f10721f = i5 + 1;
            bArr[i5] = (byte) ((i >> 24) & 255);
            this.f10722g += 4;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: l */
        public final void mo27985l(int i) {
            if (i >= 0) {
                mo27986m(i);
            } else {
                mo27982e((long) i);
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: m */
        public final void mo27986m(int i) {
            if (CodedOutputStream.f10717b) {
                long e = CodedOutputStream.f10718c + ((long) this.f10721f);
                long j = e;
                while ((i & -128) != 0) {
                    C3987d0.m13286a(this.f10719d, j, (byte) ((i & Notifications.NOTIFICATION_TYPES_ALL) | OguryChoiceManager.TcfV2.Purpose.MEASURE_AD_PERFORMANCE));
                    i >>>= 7;
                    j = 1 + j;
                }
                C3987d0.m13286a(this.f10719d, j, (byte) i);
                int i2 = (int) ((1 + j) - e);
                this.f10721f += i2;
                this.f10722g += i2;
                return;
            }
            while ((i & -128) != 0) {
                byte[] bArr = this.f10719d;
                int i3 = this.f10721f;
                this.f10721f = i3 + 1;
                bArr[i3] = (byte) ((i & Notifications.NOTIFICATION_TYPES_ALL) | OguryChoiceManager.TcfV2.Purpose.MEASURE_AD_PERFORMANCE);
                this.f10722g++;
                i >>>= 7;
            }
            byte[] bArr2 = this.f10719d;
            int i4 = this.f10721f;
            this.f10721f = i4 + 1;
            bArr2[i4] = (byte) i;
            this.f10722g++;
        }
    }

    /* renamed from: com.google.protobuf.CodedOutputStream$c */
    private static class C3967c extends CodedOutputStream {

        /* renamed from: d */
        private final byte[] f10723d;

        /* renamed from: e */
        private final int f10724e;

        /* renamed from: f */
        private int f10725f;

        C3967c(byte[] bArr, int i, int i2) {
            super();
            if (bArr != null) {
                int i3 = i + i2;
                if ((i | i2 | (bArr.length - i3)) >= 0) {
                    this.f10723d = bArr;
                    this.f10725f = i;
                    this.f10724e = i3;
                    return;
                }
                throw new IllegalArgumentException(String.format("Array range is invalid. Buffer.length=%d, offset=%d, length=%d", new Object[]{Integer.valueOf(bArr.length), Integer.valueOf(i), Integer.valueOf(i2)}));
            }
            throw new NullPointerException("buffer");
        }

        /* renamed from: a */
        public final void mo27966a(int i, long j) throws IOException {
            mo27979d(i, 1);
            mo27993d(j);
        }

        /* renamed from: b */
        public void mo27972b() {
        }

        /* renamed from: b */
        public final void mo27974b(int i, int i2) throws IOException {
            mo27979d(i, 5);
            mo27995k(i2);
        }

        /* renamed from: c */
        public final void mo27977c(int i, int i2) throws IOException {
            mo27979d(i, 0);
            mo27996l(i2);
        }

        /* renamed from: d */
        public final void mo27979d(int i, int i2) throws IOException {
            mo27973b(C4005f0.m13358a(i, i2));
        }

        /* renamed from: e */
        public final void mo27994e(long j) throws IOException {
            if (!CodedOutputStream.f10717b || mo27976c() < 10) {
                while ((j & -128) != 0) {
                    byte[] bArr = this.f10723d;
                    int i = this.f10725f;
                    this.f10725f = i + 1;
                    bArr[i] = (byte) ((((int) j) & Notifications.NOTIFICATION_TYPES_ALL) | OguryChoiceManager.TcfV2.Purpose.MEASURE_AD_PERFORMANCE);
                    j >>>= 7;
                }
                try {
                    byte[] bArr2 = this.f10723d;
                    int i2 = this.f10725f;
                    this.f10725f = i2 + 1;
                    bArr2[i2] = (byte) ((int) j);
                } catch (IndexOutOfBoundsException e) {
                    throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.f10725f), Integer.valueOf(this.f10724e), 1}), e);
                }
            } else {
                long e2 = CodedOutputStream.f10718c + ((long) this.f10725f);
                while ((j & -128) != 0) {
                    C3987d0.m13286a(this.f10723d, e2, (byte) ((((int) j) & Notifications.NOTIFICATION_TYPES_ALL) | OguryChoiceManager.TcfV2.Purpose.MEASURE_AD_PERFORMANCE));
                    this.f10725f++;
                    j >>>= 7;
                    e2 = 1 + e2;
                }
                C3987d0.m13286a(this.f10723d, e2, (byte) ((int) j));
                this.f10725f++;
            }
        }

        /* renamed from: k */
        public final void mo27995k(int i) throws IOException {
            try {
                byte[] bArr = this.f10723d;
                int i2 = this.f10725f;
                int i3 = i2 + 1;
                this.f10725f = i3;
                bArr[i2] = (byte) (i & 255);
                byte[] bArr2 = this.f10723d;
                int i4 = i3 + 1;
                this.f10725f = i4;
                bArr2[i3] = (byte) ((i >> 8) & 255);
                byte[] bArr3 = this.f10723d;
                int i5 = i4 + 1;
                this.f10725f = i5;
                bArr3[i4] = (byte) ((i >> 16) & 255);
                byte[] bArr4 = this.f10723d;
                this.f10725f = i5 + 1;
                bArr4[i5] = (byte) ((i >> 24) & 255);
            } catch (IndexOutOfBoundsException e) {
                throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.f10725f), Integer.valueOf(this.f10724e), 1}), e);
            }
        }

        /* renamed from: l */
        public final void mo27996l(int i) throws IOException {
            if (i >= 0) {
                mo27973b(i);
            } else {
                mo27994e((long) i);
            }
        }

        /* renamed from: d */
        public final void mo27993d(long j) throws IOException {
            try {
                byte[] bArr = this.f10723d;
                int i = this.f10725f;
                int i2 = i + 1;
                this.f10725f = i2;
                bArr[i] = (byte) (((int) j) & 255);
                byte[] bArr2 = this.f10723d;
                int i3 = i2 + 1;
                this.f10725f = i3;
                bArr2[i2] = (byte) (((int) (j >> 8)) & 255);
                byte[] bArr3 = this.f10723d;
                int i4 = i3 + 1;
                this.f10725f = i4;
                bArr3[i3] = (byte) (((int) (j >> 16)) & 255);
                byte[] bArr4 = this.f10723d;
                int i5 = i4 + 1;
                this.f10725f = i5;
                bArr4[i4] = (byte) (((int) (j >> 24)) & 255);
                byte[] bArr5 = this.f10723d;
                int i6 = i5 + 1;
                this.f10725f = i6;
                bArr5[i5] = (byte) (((int) (j >> 32)) & 255);
                byte[] bArr6 = this.f10723d;
                int i7 = i6 + 1;
                this.f10725f = i7;
                bArr6[i6] = (byte) (((int) (j >> 40)) & 255);
                byte[] bArr7 = this.f10723d;
                int i8 = i7 + 1;
                this.f10725f = i8;
                bArr7[i7] = (byte) (((int) (j >> 48)) & 255);
                byte[] bArr8 = this.f10723d;
                this.f10725f = i8 + 1;
                bArr8[i8] = (byte) (((int) (j >> 56)) & 255);
            } catch (IndexOutOfBoundsException e) {
                throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.f10725f), Integer.valueOf(this.f10724e), 1}), e);
            }
        }

        /* renamed from: a */
        public final void mo27970a(int i, boolean z) throws IOException {
            mo27979d(i, 0);
            mo27987a(z ? (byte) 1 : 0);
        }

        /* renamed from: b */
        public final void mo27989b(C3995f fVar) throws IOException {
            mo27973b(fVar.size());
            fVar.mo28108a((C3989e) this);
        }

        /* renamed from: c */
        public final void mo27978c(int i, long j) throws IOException {
            mo27979d(i, 0);
            mo27994e(j);
        }

        /* renamed from: a */
        public final void mo27969a(int i, String str) throws IOException {
            mo27979d(i, 2);
            mo27991b(str);
        }

        /* renamed from: b */
        public final void mo27990b(C4054u uVar) throws IOException {
            mo27973b(uVar.getSerializedSize());
            uVar.writeTo(this);
        }

        /* renamed from: c */
        public final void mo27992c(byte[] bArr, int i, int i2) throws IOException {
            try {
                System.arraycopy(bArr, i, this.f10723d, this.f10725f, i2);
                this.f10725f += i2;
            } catch (IndexOutOfBoundsException e) {
                throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.f10725f), Integer.valueOf(this.f10724e), Integer.valueOf(i2)}), e);
            }
        }

        /* renamed from: a */
        public final void mo27967a(int i, C3995f fVar) throws IOException {
            mo27979d(i, 2);
            mo27989b(fVar);
        }

        /* renamed from: b */
        public final void mo27973b(int i) throws IOException {
            if (!CodedOutputStream.f10717b || mo27976c() < 10) {
                while ((i & -128) != 0) {
                    byte[] bArr = this.f10723d;
                    int i2 = this.f10725f;
                    this.f10725f = i2 + 1;
                    bArr[i2] = (byte) ((i & Notifications.NOTIFICATION_TYPES_ALL) | OguryChoiceManager.TcfV2.Purpose.MEASURE_AD_PERFORMANCE);
                    i >>>= 7;
                }
                try {
                    byte[] bArr2 = this.f10723d;
                    int i3 = this.f10725f;
                    this.f10725f = i3 + 1;
                    bArr2[i3] = (byte) i;
                } catch (IndexOutOfBoundsException e) {
                    throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.f10725f), Integer.valueOf(this.f10724e), 1}), e);
                }
            } else {
                long e2 = CodedOutputStream.f10718c + ((long) this.f10725f);
                while ((i & -128) != 0) {
                    C3987d0.m13286a(this.f10723d, e2, (byte) ((i & Notifications.NOTIFICATION_TYPES_ALL) | OguryChoiceManager.TcfV2.Purpose.MEASURE_AD_PERFORMANCE));
                    this.f10725f++;
                    i >>>= 7;
                    e2 = 1 + e2;
                }
                C3987d0.m13286a(this.f10723d, e2, (byte) i);
                this.f10725f++;
            }
        }

        /* renamed from: a */
        public final void mo27968a(int i, C4054u uVar) throws IOException {
            mo27979d(i, 2);
            mo27990b(uVar);
        }

        /* renamed from: c */
        public final int mo27976c() {
            return this.f10724e - this.f10725f;
        }

        /* renamed from: a */
        public final void mo27987a(byte b) throws IOException {
            try {
                byte[] bArr = this.f10723d;
                int i = this.f10725f;
                this.f10725f = i + 1;
                bArr[i] = b;
            } catch (IndexOutOfBoundsException e) {
                throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.f10725f), Integer.valueOf(this.f10724e), 1}), e);
            }
        }

        /* renamed from: a */
        public final void mo27988a(byte[] bArr, int i, int i2) throws IOException {
            mo27992c(bArr, i, i2);
        }

        /* renamed from: b */
        public final void mo27991b(String str) throws IOException {
            int i = this.f10725f;
            try {
                int j = CodedOutputStream.m13144j(str.length() * 3);
                int j2 = CodedOutputStream.m13144j(str.length());
                if (j2 == j) {
                    int i2 = i + j2;
                    this.f10725f = i2;
                    int a = C3990e0.m13300a(str, this.f10723d, i2, mo27976c());
                    this.f10725f = i;
                    mo27973b((a - i) - j2);
                    this.f10725f = a;
                    return;
                }
                mo27973b(C3990e0.m13298a((CharSequence) str));
                this.f10725f = C3990e0.m13300a(str, this.f10723d, this.f10725f, mo27976c());
            } catch (C3990e0.C3993c e) {
                this.f10725f = i;
                mo27971a(str, e);
            } catch (IndexOutOfBoundsException e2) {
                throw new OutOfSpaceException(e2);
            }
        }
    }

    /* renamed from: a */
    public static int m13115a(long j) {
        return 8;
    }

    /* renamed from: a */
    public static int m13119a(boolean z) {
        return 1;
    }

    /* renamed from: a */
    public static CodedOutputStream m13120a(OutputStream outputStream, int i) {
        return new C3968d(outputStream, i);
    }

    /* renamed from: b */
    public static CodedOutputStream m13127b(byte[] bArr, int i, int i2) {
        return new C3967c(bArr, i, i2);
    }

    /* renamed from: c */
    public static int m13128c(int i) {
        return m13133e(i);
    }

    /* renamed from: c */
    public static int m13129c(long j) {
        int i;
        if ((-128 & j) == 0) {
            return 1;
        }
        if (j < 0) {
            return 10;
        }
        if ((-34359738368L & j) != 0) {
            i = 6;
            j >>>= 28;
        } else {
            i = 2;
        }
        if ((-2097152 & j) != 0) {
            i += 2;
            j >>>= 14;
        }
        return (j & -16384) != 0 ? i + 1 : i;
    }

    /* renamed from: d */
    public static int m13130d(int i) {
        return 4;
    }

    /* renamed from: f */
    public static int m13138f(int i, int i2) {
        return m13143i(i) + m13130d(i2);
    }

    /* renamed from: g */
    static int m13140g(int i) {
        return i > 4096 ? CodedOutputStream.DEFAULT_BUFFER_SIZE : i;
    }

    /* renamed from: g */
    public static int m13141g(int i, int i2) {
        return m13143i(i) + m13133e(i2);
    }

    @Deprecated
    /* renamed from: h */
    public static int m13142h(int i) {
        return m13144j(i);
    }

    /* renamed from: i */
    public static int m13143i(int i) {
        return m13144j(C4005f0.m13358a(i, 0));
    }

    /* renamed from: j */
    public static int m13144j(int i) {
        if ((i & -128) == 0) {
            return 1;
        }
        if ((i & -16384) == 0) {
            return 2;
        }
        if ((-2097152 & i) == 0) {
            return 3;
        }
        return (i & -268435456) == 0 ? 4 : 5;
    }

    /* renamed from: a */
    public abstract void mo27966a(int i, long j) throws IOException;

    /* renamed from: a */
    public abstract void mo27967a(int i, C3995f fVar) throws IOException;

    /* renamed from: a */
    public abstract void mo27968a(int i, C4054u uVar) throws IOException;

    /* renamed from: a */
    public abstract void mo27969a(int i, String str) throws IOException;

    /* renamed from: a */
    public abstract void mo27970a(int i, boolean z) throws IOException;

    /* renamed from: b */
    public abstract void mo27972b() throws IOException;

    /* renamed from: b */
    public abstract void mo27973b(int i) throws IOException;

    /* renamed from: b */
    public abstract void mo27974b(int i, int i2) throws IOException;

    /* renamed from: c */
    public abstract int mo27976c();

    /* renamed from: c */
    public abstract void mo27977c(int i, int i2) throws IOException;

    /* renamed from: c */
    public abstract void mo27978c(int i, long j) throws IOException;

    /* renamed from: d */
    public abstract void mo27979d(int i, int i2) throws IOException;

    private CodedOutputStream() {
    }

    /* renamed from: a */
    public static CodedOutputStream m13121a(byte[] bArr) {
        return m13127b(bArr, 0, bArr.length);
    }

    /* renamed from: d */
    public static int m13131d(int i, long j) {
        return m13143i(i) + m13115a(j);
    }

    /* renamed from: e */
    public static int m13135e(int i, long j) {
        return m13143i(i) + m13126b(j);
    }

    /* renamed from: f */
    public static int m13139f(int i, long j) {
        return m13143i(i) + m13129c(j);
    }

    /* renamed from: b */
    public final void mo27975b(int i, long j) throws IOException {
        mo27978c(i, j);
    }

    /* renamed from: com.google.protobuf.CodedOutputStream$d */
    private static final class C3968d extends C3966b {

        /* renamed from: h */
        private final OutputStream f10726h;

        C3968d(OutputStream outputStream, int i) {
            super(i);
            if (outputStream != null) {
                this.f10726h = outputStream;
                return;
            }
            throw new NullPointerException("out");
        }

        /* renamed from: f */
        private void m13192f() throws IOException {
            this.f10726h.write(this.f10719d, 0, this.f10721f);
            this.f10721f = 0;
        }

        /* renamed from: n */
        private void m13193n(int i) throws IOException {
            if (this.f10720e - this.f10721f < i) {
                m13192f();
            }
        }

        /* renamed from: a */
        public void mo27966a(int i, long j) throws IOException {
            m13193n(18);
            mo27983h(i, 1);
            mo27981d(j);
        }

        /* renamed from: b */
        public void mo27974b(int i, int i2) throws IOException {
            m13193n(14);
            mo27983h(i, 5);
            mo27984k(i2);
        }

        /* renamed from: c */
        public void mo27977c(int i, int i2) throws IOException {
            m13193n(20);
            mo27983h(i, 0);
            mo27985l(i2);
        }

        /* renamed from: d */
        public void mo27979d(int i, int i2) throws IOException {
            mo27973b(C4005f0.m13358a(i, i2));
        }

        /* renamed from: a */
        public void mo27970a(int i, boolean z) throws IOException {
            m13193n(11);
            mo27983h(i, 0);
            mo27980a(z ? (byte) 1 : 0);
        }

        /* renamed from: b */
        public void mo27997b(C3995f fVar) throws IOException {
            mo27973b(fVar.size());
            fVar.mo28108a((C3989e) this);
        }

        /* renamed from: c */
        public void mo27978c(int i, long j) throws IOException {
            m13193n(20);
            mo27983h(i, 0);
            mo27982e(j);
        }

        /* renamed from: b */
        public void mo27998b(C4054u uVar) throws IOException {
            mo27973b(uVar.getSerializedSize());
            uVar.writeTo(this);
        }

        /* renamed from: a */
        public void mo27969a(int i, String str) throws IOException {
            mo27979d(i, 2);
            mo27999b(str);
        }

        /* renamed from: c */
        public void mo28000c(byte[] bArr, int i, int i2) throws IOException {
            int i3 = this.f10720e;
            int i4 = this.f10721f;
            if (i3 - i4 >= i2) {
                System.arraycopy(bArr, i, this.f10719d, i4, i2);
                this.f10721f += i2;
                this.f10722g += i2;
                return;
            }
            int i5 = i3 - i4;
            System.arraycopy(bArr, i, this.f10719d, i4, i5);
            int i6 = i + i5;
            int i7 = i2 - i5;
            this.f10721f = this.f10720e;
            this.f10722g += i5;
            m13192f();
            if (i7 <= this.f10720e) {
                System.arraycopy(bArr, i6, this.f10719d, 0, i7);
                this.f10721f = i7;
            } else {
                this.f10726h.write(bArr, i6, i7);
            }
            this.f10722g += i7;
        }

        /* renamed from: b */
        public void mo27973b(int i) throws IOException {
            m13193n(10);
            mo27986m(i);
        }

        /* renamed from: a */
        public void mo27967a(int i, C3995f fVar) throws IOException {
            mo27979d(i, 2);
            mo27997b(fVar);
        }

        /* renamed from: b */
        public void mo27999b(String str) throws IOException {
            int i;
            int i2;
            try {
                int length = str.length() * 3;
                int j = CodedOutputStream.m13144j(length);
                int i3 = j + length;
                if (i3 > this.f10720e) {
                    byte[] bArr = new byte[length];
                    int a = C3990e0.m13300a(str, bArr, 0, length);
                    mo27973b(a);
                    mo27988a(bArr, 0, a);
                    return;
                }
                if (i3 > this.f10720e - this.f10721f) {
                    m13192f();
                }
                int j2 = CodedOutputStream.m13144j(str.length());
                i = this.f10721f;
                if (j2 == j) {
                    int i4 = i + j2;
                    this.f10721f = i4;
                    int a2 = C3990e0.m13300a(str, this.f10719d, i4, this.f10720e - i4);
                    this.f10721f = i;
                    i2 = (a2 - i) - j2;
                    mo27986m(i2);
                    this.f10721f = a2;
                } else {
                    i2 = C3990e0.m13298a((CharSequence) str);
                    mo27986m(i2);
                    this.f10721f = C3990e0.m13300a(str, this.f10719d, this.f10721f, i2);
                }
                this.f10722g += i2;
            } catch (C3990e0.C3993c e) {
                this.f10722g -= this.f10721f - i;
                this.f10721f = i;
                throw e;
            } catch (ArrayIndexOutOfBoundsException e2) {
                throw new OutOfSpaceException(e2);
            } catch (C3990e0.C3993c e3) {
                mo27971a(str, e3);
            }
        }

        /* renamed from: a */
        public void mo27968a(int i, C4054u uVar) throws IOException {
            mo27979d(i, 2);
            mo27998b(uVar);
        }

        /* renamed from: a */
        public void mo27988a(byte[] bArr, int i, int i2) throws IOException {
            mo28000c(bArr, i, i2);
        }

        /* renamed from: b */
        public void mo27972b() throws IOException {
            if (this.f10721f > 0) {
                m13192f();
            }
        }
    }

    /* renamed from: b */
    public static int m13125b(int i, boolean z) {
        return m13143i(i) + m13119a(z);
    }

    /* renamed from: e */
    public static int m13134e(int i, int i2) {
        return m13143i(i) + m13128c(i2);
    }

    /* renamed from: f */
    static int m13137f(int i) {
        return m13144j(i) + i;
    }

    /* renamed from: a */
    public final void mo27965a(int i, int i2) throws IOException {
        mo27977c(i, i2);
    }

    /* renamed from: a */
    public static int m13118a(String str) {
        int i;
        try {
            i = C3990e0.m13298a((CharSequence) str);
        } catch (C3990e0.C3993c unused) {
            i = str.getBytes(C4038p.f10852a).length;
        }
        return m13137f(i);
    }

    /* renamed from: b */
    public static int m13124b(int i, String str) {
        return m13143i(i) + m13118a(str);
    }

    /* renamed from: e */
    public static int m13133e(int i) {
        if (i >= 0) {
            return m13144j(i);
        }
        return 10;
    }

    /* renamed from: b */
    public static int m13122b(int i, C3995f fVar) {
        return m13143i(i) + m13116a(fVar);
    }

    /* renamed from: b */
    public static int m13123b(int i, C4054u uVar) {
        return m13143i(i) + m13117a(uVar);
    }

    /* renamed from: b */
    public static int m13126b(long j) {
        return m13129c(j);
    }

    /* renamed from: a */
    public static int m13116a(C3995f fVar) {
        return m13137f(fVar.size());
    }

    /* renamed from: a */
    public static int m13117a(C4054u uVar) {
        return m13137f(uVar.getSerializedSize());
    }

    /* renamed from: a */
    public final void mo27963a() {
        if (mo27976c() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo27971a(String str, C3990e0.C3993c cVar) throws IOException {
        f10716a.log(Level.WARNING, "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", cVar);
        byte[] bytes = str.getBytes(C4038p.f10852a);
        try {
            mo27973b(bytes.length);
            mo27988a(bytes, 0, bytes.length);
        } catch (IndexOutOfBoundsException e) {
            throw new OutOfSpaceException(e);
        } catch (OutOfSpaceException e2) {
            throw e2;
        }
    }

    @Deprecated
    /* renamed from: a */
    public final void mo27964a(int i) throws IOException {
        mo27973b(i);
    }
}
