package com.criteo.publisher.p054a0;

import java.io.UnsupportedEncodingException;

/* renamed from: com.criteo.publisher.a0.g */
public class C2327g {

    /* renamed from: a */
    static final /* synthetic */ boolean f7682a = (!C2327g.class.desiredAssertionStatus());

    /* renamed from: com.criteo.publisher.a0.g$a */
    static abstract class C2328a {

        /* renamed from: a */
        public byte[] f7683a;

        /* renamed from: b */
        public int f7684b;

        C2328a() {
        }
    }

    /* renamed from: com.criteo.publisher.a0.g$b */
    static class C2329b extends C2328a {

        /* renamed from: j */
        private static final byte[] f7685j = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};

        /* renamed from: k */
        private static final byte[] f7686k = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95};

        /* renamed from: l */
        static final /* synthetic */ boolean f7687l = (!C2327g.class.desiredAssertionStatus());

        /* renamed from: c */
        private final byte[] f7688c;

        /* renamed from: d */
        int f7689d;

        /* renamed from: e */
        private int f7690e;

        /* renamed from: f */
        public final boolean f7691f;

        /* renamed from: g */
        public final boolean f7692g;

        /* renamed from: h */
        public final boolean f7693h;

        /* renamed from: i */
        private final byte[] f7694i;

        public C2329b(int i, byte[] bArr) {
            this.f7683a = bArr;
            boolean z = true;
            this.f7691f = (i & 1) == 0;
            this.f7692g = (i & 2) == 0;
            this.f7693h = (i & 4) == 0 ? false : z;
            this.f7694i = (i & 8) == 0 ? f7685j : f7686k;
            this.f7688c = new byte[2];
            this.f7689d = 0;
            this.f7690e = this.f7692g ? 19 : -1;
        }

        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
            	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
            */
        /* JADX WARNING: Removed duplicated region for block: B:24:0x0094  */
        /* JADX WARNING: Removed duplicated region for block: B:32:0x00e8  */
        /* JADX WARNING: Removed duplicated region for block: B:79:0x01c3  */
        /* JADX WARNING: Removed duplicated region for block: B:81:0x01c9  */
        /* JADX WARNING: Removed duplicated region for block: B:86:0x01d6  */
        /* JADX WARNING: Removed duplicated region for block: B:95:0x00e6 A[SYNTHETIC] */
        /* renamed from: a */
        public boolean mo10127a(byte[] r18, int r19, int r20, boolean r21) {
            /*
                r17 = this;
                r0 = r17
                byte[] r1 = r0.f7694i
                byte[] r2 = r0.f7683a
                int r3 = r0.f7690e
                int r4 = r20 + r19
                int r5 = r0.f7689d
                r6 = -1
                r7 = 0
                r8 = 2
                r9 = 1
                if (r5 == r9) goto L_0x0031
                if (r5 == r8) goto L_0x0015
                goto L_0x0050
            L_0x0015:
                int r5 = r19 + 1
                if (r5 > r4) goto L_0x0050
                byte[] r10 = r0.f7688c
                byte r11 = r10[r7]
                r11 = r11 & 255(0xff, float:3.57E-43)
                int r11 = r11 << 16
                byte r10 = r10[r9]
                r10 = r10 & 255(0xff, float:3.57E-43)
                int r10 = r10 << 8
                r10 = r10 | r11
                byte r11 = r18[r19]
                r11 = r11 & 255(0xff, float:3.57E-43)
                r10 = r10 | r11
                r0.f7689d = r7
                r11 = r5
                goto L_0x0053
            L_0x0031:
                int r5 = r19 + 2
                if (r5 > r4) goto L_0x0050
                byte[] r5 = r0.f7688c
                byte r5 = r5[r7]
                r5 = r5 & 255(0xff, float:3.57E-43)
                int r5 = r5 << 16
                int r10 = r19 + 1
                byte r11 = r18[r19]
                r11 = r11 & 255(0xff, float:3.57E-43)
                int r11 = r11 << 8
                r5 = r5 | r11
                int r11 = r10 + 1
                byte r10 = r18[r10]
                r10 = r10 & 255(0xff, float:3.57E-43)
                r10 = r10 | r5
                r0.f7689d = r7
                goto L_0x0053
            L_0x0050:
                r11 = r19
                r10 = -1
            L_0x0053:
                r12 = 4
                r13 = 13
                r14 = 10
                if (r10 == r6) goto L_0x008f
                int r6 = r10 >> 18
                r6 = r6 & 63
                byte r6 = r1[r6]
                r2[r7] = r6
                int r6 = r10 >> 12
                r6 = r6 & 63
                byte r6 = r1[r6]
                r2[r9] = r6
                int r6 = r10 >> 6
                r6 = r6 & 63
                byte r6 = r1[r6]
                r2[r8] = r6
                r6 = r10 & 63
                byte r6 = r1[r6]
                r10 = 3
                r2[r10] = r6
                int r3 = r3 + -1
                if (r3 != 0) goto L_0x008d
                boolean r3 = r0.f7693h
                if (r3 == 0) goto L_0x0085
                r3 = 5
                r2[r12] = r13
                goto L_0x0086
            L_0x0085:
                r3 = 4
            L_0x0086:
                int r6 = r3 + 1
                r2[r3] = r14
            L_0x008a:
                r3 = 19
                goto L_0x0090
            L_0x008d:
                r6 = 4
                goto L_0x0090
            L_0x008f:
                r6 = 0
            L_0x0090:
                int r10 = r11 + 3
                if (r10 > r4) goto L_0x00e6
                byte r15 = r18[r11]
                r15 = r15 & 255(0xff, float:3.57E-43)
                int r15 = r15 << 16
                int r16 = r11 + 1
                byte r5 = r18[r16]
                r5 = r5 & 255(0xff, float:3.57E-43)
                int r5 = r5 << 8
                r5 = r5 | r15
                int r11 = r11 + 2
                byte r11 = r18[r11]
                r11 = r11 & 255(0xff, float:3.57E-43)
                r5 = r5 | r11
                int r11 = r5 >> 18
                r11 = r11 & 63
                byte r11 = r1[r11]
                r2[r6] = r11
                int r11 = r6 + 1
                int r15 = r5 >> 12
                r15 = r15 & 63
                byte r15 = r1[r15]
                r2[r11] = r15
                int r11 = r6 + 2
                int r15 = r5 >> 6
                r15 = r15 & 63
                byte r15 = r1[r15]
                r2[r11] = r15
                int r11 = r6 + 3
                r5 = r5 & 63
                byte r5 = r1[r5]
                r2[r11] = r5
                int r6 = r6 + 4
                int r3 = r3 + -1
                if (r3 != 0) goto L_0x00e4
                boolean r3 = r0.f7693h
                if (r3 == 0) goto L_0x00dd
                int r3 = r6 + 1
                r2[r6] = r13
                r6 = r3
            L_0x00dd:
                int r3 = r6 + 1
                r2[r6] = r14
                r6 = r3
                r11 = r10
                goto L_0x008a
            L_0x00e4:
                r11 = r10
                goto L_0x0090
            L_0x00e6:
                if (r21 == 0) goto L_0x01d6
                int r5 = r0.f7689d
                int r10 = r11 - r5
                int r15 = r4 + -1
                r16 = 61
                if (r10 != r15) goto L_0x0139
                if (r5 <= 0) goto L_0x00fa
                byte[] r5 = r0.f7688c
                byte r5 = r5[r7]
                r7 = 1
                goto L_0x0100
            L_0x00fa:
                int r5 = r11 + 1
                byte r8 = r18[r11]
                r11 = r5
                r5 = r8
            L_0x0100:
                r5 = r5 & 255(0xff, float:3.57E-43)
                int r5 = r5 << r12
                int r8 = r0.f7689d
                int r8 = r8 - r7
                r0.f7689d = r8
                int r7 = r6 + 1
                int r8 = r5 >> 6
                r8 = r8 & 63
                byte r8 = r1[r8]
                r2[r6] = r8
                int r6 = r7 + 1
                r5 = r5 & 63
                byte r1 = r1[r5]
                r2[r7] = r1
                boolean r1 = r0.f7691f
                if (r1 == 0) goto L_0x0126
                int r1 = r6 + 1
                r2[r6] = r16
                int r6 = r1 + 1
                r2[r1] = r16
            L_0x0126:
                boolean r1 = r0.f7692g
                if (r1 == 0) goto L_0x01ba
                boolean r1 = r0.f7693h
                if (r1 == 0) goto L_0x0133
                int r1 = r6 + 1
                r2[r6] = r13
                r6 = r1
            L_0x0133:
                int r1 = r6 + 1
                r2[r6] = r14
                goto L_0x01b9
            L_0x0139:
                int r12 = r4 + -2
                if (r10 != r12) goto L_0x01a2
                if (r5 <= r9) goto L_0x0145
                byte[] r5 = r0.f7688c
                byte r5 = r5[r7]
                r7 = 1
                goto L_0x014b
            L_0x0145:
                int r5 = r11 + 1
                byte r10 = r18[r11]
                r11 = r5
                r5 = r10
            L_0x014b:
                r5 = r5 & 255(0xff, float:3.57E-43)
                int r5 = r5 << r14
                int r10 = r0.f7689d
                if (r10 <= 0) goto L_0x0159
                byte[] r10 = r0.f7688c
                int r12 = r7 + 1
                byte r7 = r10[r7]
                goto L_0x0160
            L_0x0159:
                int r10 = r11 + 1
                byte r11 = r18[r11]
                r12 = r7
                r7 = r11
                r11 = r10
            L_0x0160:
                r7 = r7 & 255(0xff, float:3.57E-43)
                int r7 = r7 << r8
                r5 = r5 | r7
                int r7 = r0.f7689d
                int r7 = r7 - r12
                r0.f7689d = r7
                int r7 = r6 + 1
                int r8 = r5 >> 12
                r8 = r8 & 63
                byte r8 = r1[r8]
                r2[r6] = r8
                int r6 = r7 + 1
                int r8 = r5 >> 6
                r8 = r8 & 63
                byte r8 = r1[r8]
                r2[r7] = r8
                int r7 = r6 + 1
                r5 = r5 & 63
                byte r1 = r1[r5]
                r2[r6] = r1
                boolean r1 = r0.f7691f
                if (r1 == 0) goto L_0x018e
                int r1 = r7 + 1
                r2[r7] = r16
                r7 = r1
            L_0x018e:
                boolean r1 = r0.f7692g
                if (r1 == 0) goto L_0x01a0
                boolean r1 = r0.f7693h
                if (r1 == 0) goto L_0x019b
                int r1 = r7 + 1
                r2[r7] = r13
                r7 = r1
            L_0x019b:
                int r1 = r7 + 1
                r2[r7] = r14
                r7 = r1
            L_0x01a0:
                r6 = r7
                goto L_0x01ba
            L_0x01a2:
                boolean r1 = r0.f7692g
                if (r1 == 0) goto L_0x01ba
                if (r6 <= 0) goto L_0x01ba
                r1 = 19
                if (r3 == r1) goto L_0x01ba
                boolean r1 = r0.f7693h
                if (r1 == 0) goto L_0x01b5
                int r1 = r6 + 1
                r2[r6] = r13
                r6 = r1
            L_0x01b5:
                int r1 = r6 + 1
                r2[r6] = r14
            L_0x01b9:
                r6 = r1
            L_0x01ba:
                boolean r1 = f7687l
                if (r1 != 0) goto L_0x01c9
                int r1 = r0.f7689d
                if (r1 != 0) goto L_0x01c3
                goto L_0x01c9
            L_0x01c3:
                java.lang.AssertionError r1 = new java.lang.AssertionError
                r1.<init>()
                throw r1
            L_0x01c9:
                boolean r1 = f7687l
                if (r1 != 0) goto L_0x01ff
                if (r11 != r4) goto L_0x01d0
                goto L_0x01ff
            L_0x01d0:
                java.lang.AssertionError r1 = new java.lang.AssertionError
                r1.<init>()
                throw r1
            L_0x01d6:
                int r1 = r4 + -1
                if (r11 != r1) goto L_0x01e7
                byte[] r1 = r0.f7688c
                int r2 = r0.f7689d
                int r4 = r2 + 1
                r0.f7689d = r4
                byte r4 = r18[r11]
                r1[r2] = r4
                goto L_0x01ff
            L_0x01e7:
                int r4 = r4 - r8
                if (r11 != r4) goto L_0x01ff
                byte[] r1 = r0.f7688c
                int r2 = r0.f7689d
                int r4 = r2 + 1
                r0.f7689d = r4
                byte r5 = r18[r11]
                r1[r2] = r5
                int r2 = r4 + 1
                r0.f7689d = r2
                int r11 = r11 + r9
                byte r2 = r18[r11]
                r1[r4] = r2
            L_0x01ff:
                r0.f7684b = r6
                r0.f7690e = r3
                return r9
            */
            throw new UnsupportedOperationException("Method not decompiled: com.criteo.publisher.p054a0.C2327g.C2329b.mo10127a(byte[], int, int, boolean):boolean");
        }
    }

    private C2327g() {
    }

    /* renamed from: a */
    public static byte[] m8955a(byte[] bArr, int i) {
        return m8956a(bArr, 0, bArr.length, i);
    }

    /* renamed from: b */
    public static String m8957b(byte[] bArr, int i) {
        try {
            return new String(m8955a(bArr, i), "US-ASCII");
        } catch (UnsupportedEncodingException e) {
            throw new AssertionError(e);
        }
    }

    /* renamed from: a */
    public static byte[] m8956a(byte[] bArr, int i, int i2, int i3) {
        C2329b bVar = new C2329b(i3, (byte[]) null);
        int i4 = (i2 / 3) * 4;
        int i5 = 2;
        if (!bVar.f7691f) {
            int i6 = i2 % 3;
            if (i6 == 1) {
                i4 += 2;
            } else if (i6 == 2) {
                i4 += 3;
            }
        } else if (i2 % 3 > 0) {
            i4 += 4;
        }
        if (bVar.f7692g && i2 > 0) {
            int i7 = ((i2 - 1) / 57) + 1;
            if (!bVar.f7693h) {
                i5 = 1;
            }
            i4 += i7 * i5;
        }
        bVar.f7683a = new byte[i4];
        bVar.mo10127a(bArr, i, i2, true);
        if (f7682a || bVar.f7684b == i4) {
            return bVar.f7683a;
        }
        throw new AssertionError();
    }
}
