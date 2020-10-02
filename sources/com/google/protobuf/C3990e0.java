package com.google.protobuf;

import com.ogury.p159cm.OguryChoiceManager;

/* renamed from: com.google.protobuf.e0 */
/* compiled from: Utf8 */
final class C3990e0 {

    /* renamed from: a */
    private static final C3991a f10758a = (C3994d.m13316a() ? new C3994d() : new C3992b());

    /* renamed from: com.google.protobuf.e0$a */
    /* compiled from: Utf8 */
    static abstract class C3991a {
        C3991a() {
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public abstract int mo28102a(int i, byte[] bArr, int i2, int i3);

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public abstract int mo28103a(CharSequence charSequence, byte[] bArr, int i, int i2);

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public final boolean mo28104a(byte[] bArr, int i, int i2) {
            return mo28102a(0, bArr, i, i2) == 0;
        }
    }

    /* renamed from: com.google.protobuf.e0$c */
    /* compiled from: Utf8 */
    static class C3993c extends IllegalArgumentException {
        C3993c(int i, int i2) {
            super("Unpaired surrogate at index " + i + " of " + i2);
        }
    }

    /* renamed from: com.google.protobuf.e0$d */
    /* compiled from: Utf8 */
    static final class C3994d extends C3991a {
        C3994d() {
        }

        /* renamed from: a */
        static boolean m13316a() {
            return C3987d0.m13290d() && C3987d0.m13291e();
        }

        /* renamed from: b */
        private static int m13317b(byte[] bArr, long j, int i) {
            if (i < 16) {
                return 0;
            }
            int i2 = ((int) j) & 7;
            int i3 = i2;
            while (i3 > 0) {
                long j2 = 1 + j;
                if (C3987d0.m13282a(bArr, j) < 0) {
                    return i2 - i3;
                }
                i3--;
                j = j2;
            }
            int i4 = i - i2;
            while (i4 >= 8 && (C3987d0.m13288b(bArr, j) & -9187201950435737472L) == 0) {
                j += 8;
                i4 -= 8;
            }
            return i - i4;
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Code restructure failed: missing block: B:32:0x0063, code lost:
            if (com.google.protobuf.C3987d0.m13282a(r13, r2) > -65) goto L_0x0068;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:54:0x00a8, code lost:
            if (com.google.protobuf.C3987d0.m13282a(r13, r2) > -65) goto L_0x00aa;
         */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public int mo28102a(int r12, byte[] r13, int r14, int r15) {
            /*
                r11 = this;
                r0 = r14 | r15
                int r1 = r13.length
                int r1 = r1 - r15
                r0 = r0 | r1
                r1 = 0
                if (r0 < 0) goto L_0x00b2
                long r2 = com.google.protobuf.C3987d0.m13287b()
                long r4 = (long) r14
                long r2 = r2 + r4
                long r4 = com.google.protobuf.C3987d0.m13287b()
                long r14 = (long) r15
                long r4 = r4 + r14
                if (r12 == 0) goto L_0x00ab
                int r14 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
                if (r14 < 0) goto L_0x001b
                return r12
            L_0x001b:
                byte r14 = (byte) r12
                r15 = -32
                r0 = -1
                r6 = -65
                r7 = 1
                if (r14 >= r15) goto L_0x0035
                r12 = -62
                if (r14 < r12) goto L_0x0034
                long r7 = r7 + r2
                byte r12 = com.google.protobuf.C3987d0.m13282a((byte[]) r13, (long) r2)
                if (r12 <= r6) goto L_0x0031
                goto L_0x0034
            L_0x0031:
                r2 = r7
                goto L_0x00ab
            L_0x0034:
                return r0
            L_0x0035:
                r9 = -16
                if (r14 >= r9) goto L_0x0069
                int r12 = r12 >> 8
                r12 = r12 ^ r0
                byte r12 = (byte) r12
                if (r12 != 0) goto L_0x004f
                long r9 = r2 + r7
                byte r12 = com.google.protobuf.C3987d0.m13282a((byte[]) r13, (long) r2)
                int r1 = (r9 > r4 ? 1 : (r9 == r4 ? 0 : -1))
                if (r1 < 0) goto L_0x004e
                int r12 = com.google.protobuf.C3990e0.m13303b(r14, r12)
                return r12
            L_0x004e:
                r2 = r9
            L_0x004f:
                if (r12 > r6) goto L_0x0068
                r1 = -96
                if (r14 != r15) goto L_0x0057
                if (r12 < r1) goto L_0x0068
            L_0x0057:
                r15 = -19
                if (r14 != r15) goto L_0x005d
                if (r12 >= r1) goto L_0x0068
            L_0x005d:
                long r14 = r2 + r7
                byte r12 = com.google.protobuf.C3987d0.m13282a((byte[]) r13, (long) r2)
                if (r12 <= r6) goto L_0x0066
                goto L_0x0068
            L_0x0066:
                r2 = r14
                goto L_0x00ab
            L_0x0068:
                return r0
            L_0x0069:
                int r15 = r12 >> 8
                r15 = r15 ^ r0
                byte r15 = (byte) r15
                if (r15 != 0) goto L_0x0080
                long r9 = r2 + r7
                byte r15 = com.google.protobuf.C3987d0.m13282a((byte[]) r13, (long) r2)
                int r12 = (r9 > r4 ? 1 : (r9 == r4 ? 0 : -1))
                if (r12 < 0) goto L_0x007e
                int r12 = com.google.protobuf.C3990e0.m13303b(r14, r15)
                return r12
            L_0x007e:
                r2 = r9
                goto L_0x0083
            L_0x0080:
                int r12 = r12 >> 16
                byte r1 = (byte) r12
            L_0x0083:
                if (r1 != 0) goto L_0x0095
                long r9 = r2 + r7
                byte r1 = com.google.protobuf.C3987d0.m13282a((byte[]) r13, (long) r2)
                int r12 = (r9 > r4 ? 1 : (r9 == r4 ? 0 : -1))
                if (r12 < 0) goto L_0x0094
                int r12 = com.google.protobuf.C3990e0.m13304b((int) r14, (int) r15, (int) r1)
                return r12
            L_0x0094:
                r2 = r9
            L_0x0095:
                if (r15 > r6) goto L_0x00aa
                int r12 = r14 << 28
                int r15 = r15 + 112
                int r12 = r12 + r15
                int r12 = r12 >> 30
                if (r12 != 0) goto L_0x00aa
                if (r1 > r6) goto L_0x00aa
                long r14 = r2 + r7
                byte r12 = com.google.protobuf.C3987d0.m13282a((byte[]) r13, (long) r2)
                if (r12 <= r6) goto L_0x0066
            L_0x00aa:
                return r0
            L_0x00ab:
                long r4 = r4 - r2
                int r12 = (int) r4
                int r12 = m13315a(r13, r2, r12)
                return r12
            L_0x00b2:
                java.lang.ArrayIndexOutOfBoundsException r12 = new java.lang.ArrayIndexOutOfBoundsException
                r0 = 3
                java.lang.Object[] r0 = new java.lang.Object[r0]
                int r13 = r13.length
                java.lang.Integer r13 = java.lang.Integer.valueOf(r13)
                r0[r1] = r13
                r13 = 1
                java.lang.Integer r14 = java.lang.Integer.valueOf(r14)
                r0[r13] = r14
                r13 = 2
                java.lang.Integer r14 = java.lang.Integer.valueOf(r15)
                r0[r13] = r14
                java.lang.String r13 = "Array length=%d, index=%d, limit=%d"
                java.lang.String r13 = java.lang.String.format(r13, r0)
                r12.<init>(r13)
                goto L_0x00d7
            L_0x00d6:
                throw r12
            L_0x00d7:
                goto L_0x00d6
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.C3990e0.C3994d.mo28102a(int, byte[], int, int):int");
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Removed duplicated region for block: B:11:0x0036  */
        /* JADX WARNING: Removed duplicated region for block: B:14:0x003d A[LOOP:1: B:14:0x003d->B:39:0x0105, LOOP_START, PHI: r2 r3 r4 r11 
          PHI: (r2v3 int) = (r2v2 int), (r2v5 int) binds: [B:10:0x0034, B:39:0x0105] A[DONT_GENERATE, DONT_INLINE]
          PHI: (r3v2 char) = (r3v1 char), (r3v3 char) binds: [B:10:0x0034, B:39:0x0105] A[DONT_GENERATE, DONT_INLINE]
          PHI: (r4v4 long) = (r4v3 long), (r4v6 long) binds: [B:10:0x0034, B:39:0x0105] A[DONT_GENERATE, DONT_INLINE]
          PHI: (r11v3 long) = (r11v2 long), (r11v4 long) binds: [B:10:0x0034, B:39:0x0105] A[DONT_GENERATE, DONT_INLINE]] */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public int mo28103a(java.lang.CharSequence r23, byte[] r24, int r25, int r26) {
            /*
                r22 = this;
                r0 = r23
                r1 = r24
                r2 = r25
                r3 = r26
                long r4 = com.google.protobuf.C3987d0.m13287b()
                long r6 = (long) r2
                long r4 = r4 + r6
                long r6 = (long) r3
                long r6 = r6 + r4
                int r8 = r23.length()
                java.lang.String r9 = " at index "
                java.lang.String r10 = "Failed writing "
                if (r8 > r3) goto L_0x0152
                int r11 = r1.length
                int r11 = r11 - r3
                if (r11 < r2) goto L_0x0152
                r2 = 0
            L_0x001f:
                r3 = 128(0x80, float:1.794E-43)
                r11 = 1
                if (r2 >= r8) goto L_0x0034
                char r13 = r0.charAt(r2)
                if (r13 >= r3) goto L_0x0034
                long r11 = r11 + r4
                byte r3 = (byte) r13
                com.google.protobuf.C3987d0.m13286a(r1, r4, r3)
                int r2 = r2 + 1
                r4 = r11
                goto L_0x001f
            L_0x0034:
                if (r2 != r8) goto L_0x003d
                long r0 = com.google.protobuf.C3987d0.m13287b()
            L_0x003a:
                long r4 = r4 - r0
                int r0 = (int) r4
                return r0
            L_0x003d:
                if (r2 >= r8) goto L_0x014c
                char r13 = r0.charAt(r2)
                if (r13 >= r3) goto L_0x0055
                int r14 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
                if (r14 >= 0) goto L_0x0055
                long r14 = r4 + r11
                byte r13 = (byte) r13
                com.google.protobuf.C3987d0.m13286a(r1, r4, r13)
                r4 = r11
                r12 = r14
            L_0x0051:
                r11 = 128(0x80, float:1.794E-43)
                goto L_0x0105
            L_0x0055:
                r14 = 2048(0x800, float:2.87E-42)
                if (r13 >= r14) goto L_0x007f
                r14 = 2
                long r14 = r6 - r14
                int r16 = (r4 > r14 ? 1 : (r4 == r14 ? 0 : -1))
                if (r16 > 0) goto L_0x007f
                long r14 = r4 + r11
                int r3 = r13 >>> 6
                r3 = r3 | 960(0x3c0, float:1.345E-42)
                byte r3 = (byte) r3
                com.google.protobuf.C3987d0.m13286a(r1, r4, r3)
                long r3 = r14 + r11
                r5 = r13 & 63
                r13 = 128(0x80, float:1.794E-43)
                r5 = r5 | r13
                byte r5 = (byte) r5
                com.google.protobuf.C3987d0.m13286a(r1, r14, r5)
                r20 = r11
                r11 = 128(0x80, float:1.794E-43)
                r12 = r3
                r4 = r20
                goto L_0x0105
            L_0x007f:
                r3 = 57343(0xdfff, float:8.0355E-41)
                r14 = 55296(0xd800, float:7.7486E-41)
                if (r13 < r14) goto L_0x0089
                if (r3 >= r13) goto L_0x00b8
            L_0x0089:
                r15 = 3
                long r15 = r6 - r15
                int r17 = (r4 > r15 ? 1 : (r4 == r15 ? 0 : -1))
                if (r17 > 0) goto L_0x00b8
                long r14 = r4 + r11
                int r3 = r13 >>> 12
                r3 = r3 | 480(0x1e0, float:6.73E-43)
                byte r3 = (byte) r3
                com.google.protobuf.C3987d0.m13286a(r1, r4, r3)
                long r3 = r14 + r11
                int r5 = r13 >>> 6
                r5 = r5 & 63
                r11 = 128(0x80, float:1.794E-43)
                r5 = r5 | r11
                byte r5 = (byte) r5
                com.google.protobuf.C3987d0.m13286a(r1, r14, r5)
                r14 = 1
                long r18 = r3 + r14
                r5 = r13 & 63
                r5 = r5 | r11
                byte r5 = (byte) r5
                com.google.protobuf.C3987d0.m13286a(r1, r3, r5)
                r12 = r18
                r4 = 1
                goto L_0x0051
            L_0x00b8:
                r11 = 4
                long r11 = r6 - r11
                int r15 = (r4 > r11 ? 1 : (r4 == r11 ? 0 : -1))
                if (r15 > 0) goto L_0x0119
                int r3 = r2 + 1
                if (r3 == r8) goto L_0x0111
                char r2 = r0.charAt(r3)
                boolean r11 = java.lang.Character.isSurrogatePair(r13, r2)
                if (r11 == 0) goto L_0x0110
                int r2 = java.lang.Character.toCodePoint(r13, r2)
                r11 = 1
                long r13 = r4 + r11
                int r15 = r2 >>> 18
                r15 = r15 | 240(0xf0, float:3.36E-43)
                byte r15 = (byte) r15
                com.google.protobuf.C3987d0.m13286a(r1, r4, r15)
                long r4 = r13 + r11
                int r15 = r2 >>> 12
                r15 = r15 & 63
                r11 = 128(0x80, float:1.794E-43)
                r12 = r15 | 128(0x80, float:1.794E-43)
                byte r12 = (byte) r12
                com.google.protobuf.C3987d0.m13286a(r1, r13, r12)
                r12 = 1
                long r14 = r4 + r12
                int r16 = r2 >>> 6
                r12 = r16 & 63
                r12 = r12 | r11
                byte r12 = (byte) r12
                com.google.protobuf.C3987d0.m13286a(r1, r4, r12)
                r4 = 1
                long r12 = r14 + r4
                r2 = r2 & 63
                r2 = r2 | r11
                byte r2 = (byte) r2
                com.google.protobuf.C3987d0.m13286a(r1, r14, r2)
                r2 = r3
            L_0x0105:
                int r2 = r2 + 1
                r3 = 128(0x80, float:1.794E-43)
                r20 = r4
                r4 = r12
                r11 = r20
                goto L_0x003d
            L_0x0110:
                r2 = r3
            L_0x0111:
                com.google.protobuf.e0$c r0 = new com.google.protobuf.e0$c
                int r2 = r2 + -1
                r0.<init>(r2, r8)
                throw r0
            L_0x0119:
                if (r14 > r13) goto L_0x0131
                if (r13 > r3) goto L_0x0131
                int r1 = r2 + 1
                if (r1 == r8) goto L_0x012b
                char r0 = r0.charAt(r1)
                boolean r0 = java.lang.Character.isSurrogatePair(r13, r0)
                if (r0 != 0) goto L_0x0131
            L_0x012b:
                com.google.protobuf.e0$c r0 = new com.google.protobuf.e0$c
                r0.<init>(r2, r8)
                throw r0
            L_0x0131:
                java.lang.ArrayIndexOutOfBoundsException r0 = new java.lang.ArrayIndexOutOfBoundsException
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                r1.append(r10)
                r1.append(r13)
                r1.append(r9)
                r1.append(r4)
                java.lang.String r1 = r1.toString()
                r0.<init>(r1)
                throw r0
            L_0x014c:
                long r0 = com.google.protobuf.C3987d0.m13287b()
                goto L_0x003a
            L_0x0152:
                java.lang.ArrayIndexOutOfBoundsException r1 = new java.lang.ArrayIndexOutOfBoundsException
                java.lang.StringBuilder r4 = new java.lang.StringBuilder
                r4.<init>()
                r4.append(r10)
                int r8 = r8 + -1
                char r0 = r0.charAt(r8)
                r4.append(r0)
                r4.append(r9)
                int r0 = r2 + r3
                r4.append(r0)
                java.lang.String r0 = r4.toString()
                r1.<init>(r0)
                goto L_0x0176
            L_0x0175:
                throw r1
            L_0x0176:
                goto L_0x0175
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.C3990e0.C3994d.mo28103a(java.lang.CharSequence, byte[], int, int):int");
        }

        /* JADX WARNING: Code restructure failed: missing block: B:19:0x0039, code lost:
            return -1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:36:0x0063, code lost:
            return -1;
         */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private static int m13315a(byte[] r8, long r9, int r11) {
            /*
                int r0 = m13317b(r8, r9, r11)
                int r11 = r11 - r0
                long r0 = (long) r0
                long r9 = r9 + r0
            L_0x0007:
                r0 = 0
                r1 = 0
            L_0x0009:
                r2 = 1
                if (r11 <= 0) goto L_0x001a
                long r4 = r9 + r2
                byte r1 = com.google.protobuf.C3987d0.m13282a((byte[]) r8, (long) r9)
                if (r1 < 0) goto L_0x0019
                int r11 = r11 + -1
                r9 = r4
                goto L_0x0009
            L_0x0019:
                r9 = r4
            L_0x001a:
                if (r11 != 0) goto L_0x001d
                return r0
            L_0x001d:
                int r11 = r11 + -1
                r0 = -32
                r4 = -65
                r5 = -1
                if (r1 >= r0) goto L_0x003a
                if (r11 != 0) goto L_0x0029
                return r1
            L_0x0029:
                int r11 = r11 + -1
                r0 = -62
                if (r1 < r0) goto L_0x0039
                long r2 = r2 + r9
                byte r9 = com.google.protobuf.C3987d0.m13282a((byte[]) r8, (long) r9)
                if (r9 <= r4) goto L_0x0037
                goto L_0x0039
            L_0x0037:
                r9 = r2
                goto L_0x0007
            L_0x0039:
                return r5
            L_0x003a:
                r6 = -16
                if (r1 >= r6) goto L_0x0064
                r6 = 2
                if (r11 >= r6) goto L_0x0046
                int r8 = m13314a((byte[]) r8, (int) r1, (long) r9, (int) r11)
                return r8
            L_0x0046:
                int r11 = r11 + -2
                long r6 = r9 + r2
                byte r9 = com.google.protobuf.C3987d0.m13282a((byte[]) r8, (long) r9)
                if (r9 > r4) goto L_0x0063
                r10 = -96
                if (r1 != r0) goto L_0x0056
                if (r9 < r10) goto L_0x0063
            L_0x0056:
                r0 = -19
                if (r1 != r0) goto L_0x005c
                if (r9 >= r10) goto L_0x0063
            L_0x005c:
                long r2 = r2 + r6
                byte r9 = com.google.protobuf.C3987d0.m13282a((byte[]) r8, (long) r6)
                if (r9 <= r4) goto L_0x0037
            L_0x0063:
                return r5
            L_0x0064:
                r0 = 3
                if (r11 >= r0) goto L_0x006c
                int r8 = m13314a((byte[]) r8, (int) r1, (long) r9, (int) r11)
                return r8
            L_0x006c:
                int r11 = r11 + -3
                long r6 = r9 + r2
                byte r9 = com.google.protobuf.C3987d0.m13282a((byte[]) r8, (long) r9)
                if (r9 > r4) goto L_0x008e
                int r10 = r1 << 28
                int r9 = r9 + 112
                int r10 = r10 + r9
                int r9 = r10 >> 30
                if (r9 != 0) goto L_0x008e
                long r9 = r6 + r2
                byte r0 = com.google.protobuf.C3987d0.m13282a((byte[]) r8, (long) r6)
                if (r0 > r4) goto L_0x008e
                long r2 = r2 + r9
                byte r9 = com.google.protobuf.C3987d0.m13282a((byte[]) r8, (long) r9)
                if (r9 <= r4) goto L_0x0037
            L_0x008e:
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.C3990e0.C3994d.m13315a(byte[], long, int):int");
        }

        /* renamed from: a */
        private static int m13314a(byte[] bArr, int i, long j, int i2) {
            if (i2 == 0) {
                return C3990e0.m13302b(i);
            }
            if (i2 == 1) {
                return C3990e0.m13303b(i, C3987d0.m13282a(bArr, j));
            }
            if (i2 == 2) {
                return C3990e0.m13304b(i, (int) C3987d0.m13282a(bArr, j), (int) C3987d0.m13282a(bArr, j + 1));
            }
            throw new AssertionError();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static int m13302b(int i) {
        if (i > -12) {
            return -1;
        }
        return i;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static int m13303b(int i, int i2) {
        if (i > -12 || i2 > -65) {
            return -1;
        }
        return i ^ (i2 << 8);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static int m13304b(int i, int i2, int i3) {
        if (i > -12 || i2 > -65 || i3 > -65) {
            return -1;
        }
        return (i ^ (i2 << 8)) ^ (i3 << 16);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static int m13305b(byte[] bArr, int i, int i2) {
        byte b = bArr[i - 1];
        int i3 = i2 - i;
        if (i3 == 0) {
            return m13302b(b);
        }
        if (i3 == 1) {
            return m13303b(b, bArr[i]);
        }
        if (i3 == 2) {
            return m13304b((int) b, (int) bArr[i], (int) bArr[i + 1]);
        }
        throw new AssertionError();
    }

    /* renamed from: c */
    public static boolean m13306c(byte[] bArr, int i, int i2) {
        return f10758a.mo28104a(bArr, i, i2);
    }

    /* renamed from: a */
    static int m13298a(CharSequence charSequence) {
        int length = charSequence.length();
        int i = 0;
        while (i < length && charSequence.charAt(i) < 128) {
            i++;
        }
        int i2 = length;
        while (true) {
            if (i < length) {
                char charAt = charSequence.charAt(i);
                if (charAt >= 2048) {
                    i2 += m13299a(charSequence, i);
                    break;
                }
                i2 += (127 - charAt) >>> 31;
                i++;
            } else {
                break;
            }
        }
        if (i2 >= length) {
            return i2;
        }
        throw new IllegalArgumentException("UTF-8 length does not fit in int: " + (((long) i2) + 4294967296L));
    }

    /* renamed from: com.google.protobuf.e0$b */
    /* compiled from: Utf8 */
    static final class C3992b extends C3991a {
        C3992b() {
        }

        /* renamed from: b */
        private static int m13310b(byte[] bArr, int i, int i2) {
            while (i < i2 && bArr[i] >= 0) {
                i++;
            }
            if (i >= i2) {
                return 0;
            }
            return m13311c(bArr, i, i2);
        }

        /* renamed from: c */
        private static int m13311c(byte[] bArr, int i, int i2) {
            while (i < i2) {
                int i3 = i + 1;
                byte b = bArr[i];
                if (b < 0) {
                    if (b < -32) {
                        if (i3 >= i2) {
                            return b;
                        }
                        if (b >= -62) {
                            i = i3 + 1;
                            if (bArr[i3] > -65) {
                            }
                        }
                        return -1;
                    } else if (b < -16) {
                        if (i3 >= i2 - 1) {
                            return C3990e0.m13305b(bArr, i3, i2);
                        }
                        int i4 = i3 + 1;
                        byte b2 = bArr[i3];
                        if (b2 <= -65 && ((b != -32 || b2 >= -96) && (b != -19 || b2 < -96))) {
                            i = i4 + 1;
                            if (bArr[i4] > -65) {
                            }
                        }
                        return -1;
                    } else if (i3 >= i2 - 2) {
                        return C3990e0.m13305b(bArr, i3, i2);
                    } else {
                        int i5 = i3 + 1;
                        byte b3 = bArr[i3];
                        if (b3 <= -65 && (((b << 28) + (b3 + 112)) >> 30) == 0) {
                            int i6 = i5 + 1;
                            if (bArr[i5] <= -65) {
                                i3 = i6 + 1;
                                if (bArr[i6] > -65) {
                                }
                            }
                        }
                        return -1;
                    }
                }
                i = i3;
            }
            return 0;
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Code restructure failed: missing block: B:28:0x0046, code lost:
            if (r8[r9] > -65) goto L_0x0048;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:49:0x007f, code lost:
            if (r8[r9] > -65) goto L_0x0081;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:8:0x0015, code lost:
            if (r8[r9] > -65) goto L_0x001b;
         */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public int mo28102a(int r7, byte[] r8, int r9, int r10) {
            /*
                r6 = this;
                if (r7 == 0) goto L_0x0082
                if (r9 < r10) goto L_0x0005
                return r7
            L_0x0005:
                byte r0 = (byte) r7
                r1 = -32
                r2 = -1
                r3 = -65
                if (r0 >= r1) goto L_0x001c
                r7 = -62
                if (r0 < r7) goto L_0x001b
                int r7 = r9 + 1
                byte r9 = r8[r9]
                if (r9 <= r3) goto L_0x0018
                goto L_0x001b
            L_0x0018:
                r9 = r7
                goto L_0x0082
            L_0x001b:
                return r2
            L_0x001c:
                r4 = -16
                if (r0 >= r4) goto L_0x0049
                int r7 = r7 >> 8
                r7 = r7 ^ r2
                byte r7 = (byte) r7
                if (r7 != 0) goto L_0x0034
                int r7 = r9 + 1
                byte r9 = r8[r9]
                if (r7 < r10) goto L_0x0031
                int r7 = com.google.protobuf.C3990e0.m13303b(r0, r9)
                return r7
            L_0x0031:
                r5 = r9
                r9 = r7
                r7 = r5
            L_0x0034:
                if (r7 > r3) goto L_0x0048
                r4 = -96
                if (r0 != r1) goto L_0x003c
                if (r7 < r4) goto L_0x0048
            L_0x003c:
                r1 = -19
                if (r0 != r1) goto L_0x0042
                if (r7 >= r4) goto L_0x0048
            L_0x0042:
                int r7 = r9 + 1
                byte r9 = r8[r9]
                if (r9 <= r3) goto L_0x0018
            L_0x0048:
                return r2
            L_0x0049:
                int r1 = r7 >> 8
                r1 = r1 ^ r2
                byte r1 = (byte) r1
                r4 = 0
                if (r1 != 0) goto L_0x005d
                int r7 = r9 + 1
                byte r1 = r8[r9]
                if (r7 < r10) goto L_0x005b
                int r7 = com.google.protobuf.C3990e0.m13303b(r0, r1)
                return r7
            L_0x005b:
                r9 = r7
                goto L_0x0060
            L_0x005d:
                int r7 = r7 >> 16
                byte r4 = (byte) r7
            L_0x0060:
                if (r4 != 0) goto L_0x006e
                int r7 = r9 + 1
                byte r4 = r8[r9]
                if (r7 < r10) goto L_0x006d
                int r7 = com.google.protobuf.C3990e0.m13304b((int) r0, (int) r1, (int) r4)
                return r7
            L_0x006d:
                r9 = r7
            L_0x006e:
                if (r1 > r3) goto L_0x0081
                int r7 = r0 << 28
                int r1 = r1 + 112
                int r7 = r7 + r1
                int r7 = r7 >> 30
                if (r7 != 0) goto L_0x0081
                if (r4 > r3) goto L_0x0081
                int r7 = r9 + 1
                byte r9 = r8[r9]
                if (r9 <= r3) goto L_0x0018
            L_0x0081:
                return r2
            L_0x0082:
                int r7 = m13310b(r8, r9, r10)
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.C3990e0.C3992b.mo28102a(int, byte[], int, int):int");
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public int mo28103a(CharSequence charSequence, byte[] bArr, int i, int i2) {
            int i3;
            int i4;
            int i5;
            char charAt;
            int length = charSequence.length();
            int i6 = i2 + i;
            int i7 = 0;
            while (i7 < length && (i5 = i7 + i) < i6 && (charAt = charSequence.charAt(i7)) < 128) {
                bArr[i5] = (byte) charAt;
                i7++;
            }
            if (i7 == length) {
                return i + length;
            }
            int i8 = i + i7;
            while (i7 < length) {
                char charAt2 = charSequence.charAt(i7);
                if (charAt2 < 128 && i8 < i6) {
                    i4 = i8 + 1;
                    bArr[i8] = (byte) charAt2;
                } else if (charAt2 < 2048 && i8 <= i6 - 2) {
                    int i9 = i8 + 1;
                    bArr[i8] = (byte) ((charAt2 >>> 6) | 960);
                    i8 = i9 + 1;
                    bArr[i9] = (byte) ((charAt2 & '?') | 128);
                    i7++;
                } else if ((charAt2 < 55296 || 57343 < charAt2) && i8 <= i6 - 3) {
                    int i10 = i8 + 1;
                    bArr[i8] = (byte) ((charAt2 >>> 12) | 480);
                    int i11 = i10 + 1;
                    bArr[i10] = (byte) (((charAt2 >>> 6) & 63) | OguryChoiceManager.TcfV2.Purpose.MEASURE_AD_PERFORMANCE);
                    i4 = i11 + 1;
                    bArr[i11] = (byte) ((charAt2 & '?') | 128);
                } else if (i8 <= i6 - 4) {
                    int i12 = i7 + 1;
                    if (i12 != charSequence.length()) {
                        char charAt3 = charSequence.charAt(i12);
                        if (Character.isSurrogatePair(charAt2, charAt3)) {
                            int codePoint = Character.toCodePoint(charAt2, charAt3);
                            int i13 = i8 + 1;
                            bArr[i8] = (byte) ((codePoint >>> 18) | 240);
                            int i14 = i13 + 1;
                            bArr[i13] = (byte) (((codePoint >>> 12) & 63) | OguryChoiceManager.TcfV2.Purpose.MEASURE_AD_PERFORMANCE);
                            int i15 = i14 + 1;
                            bArr[i14] = (byte) (((codePoint >>> 6) & 63) | OguryChoiceManager.TcfV2.Purpose.MEASURE_AD_PERFORMANCE);
                            i8 = i15 + 1;
                            bArr[i15] = (byte) ((codePoint & 63) | OguryChoiceManager.TcfV2.Purpose.MEASURE_AD_PERFORMANCE);
                            i7 = i12;
                            i7++;
                        } else {
                            i7 = i12;
                        }
                    }
                    throw new C3993c(i7 - 1, length);
                } else if (55296 > charAt2 || charAt2 > 57343 || ((i3 = i7 + 1) != charSequence.length() && Character.isSurrogatePair(charAt2, charSequence.charAt(i3)))) {
                    throw new ArrayIndexOutOfBoundsException("Failed writing " + charAt2 + " at index " + i8);
                } else {
                    throw new C3993c(i7, length);
                }
                i8 = i4;
                i7++;
            }
            return i8;
        }
    }

    /* renamed from: a */
    private static int m13299a(CharSequence charSequence, int i) {
        int length = charSequence.length();
        int i2 = 0;
        while (i < length) {
            char charAt = charSequence.charAt(i);
            if (charAt < 2048) {
                i2 += (127 - charAt) >>> 31;
            } else {
                i2 += 2;
                if (55296 <= charAt && charAt <= 57343) {
                    if (Character.codePointAt(charSequence, i) >= 65536) {
                        i++;
                    } else {
                        throw new C3993c(i, length);
                    }
                }
            }
            i++;
        }
        return i2;
    }

    /* renamed from: a */
    static int m13300a(CharSequence charSequence, byte[] bArr, int i, int i2) {
        return f10758a.mo28103a(charSequence, bArr, i, i2);
    }
}
