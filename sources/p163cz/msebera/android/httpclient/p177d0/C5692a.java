package p163cz.msebera.android.httpclient.p177d0;

/* renamed from: cz.msebera.android.httpclient.d0.a */
/* compiled from: Base64 */
public class C5692a {

    /* renamed from: cz.msebera.android.httpclient.d0.a$a */
    /* compiled from: Base64 */
    static abstract class C5693a {

        /* renamed from: a */
        public byte[] f14696a;

        /* renamed from: b */
        public int f14697b;

        C5693a() {
        }
    }

    /* renamed from: cz.msebera.android.httpclient.d0.a$b */
    /* compiled from: Base64 */
    static class C5694b extends C5693a {

        /* renamed from: j */
        private static final byte[] f14698j = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};

        /* renamed from: k */
        private static final byte[] f14699k = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95};

        /* renamed from: c */
        private final byte[] f14700c;

        /* renamed from: d */
        int f14701d;

        /* renamed from: e */
        private int f14702e;

        /* renamed from: f */
        public final boolean f14703f;

        /* renamed from: g */
        public final boolean f14704g;

        /* renamed from: h */
        public final boolean f14705h;

        /* renamed from: i */
        private final byte[] f14706i;

        public C5694b(int i, byte[] bArr) {
            this.f14696a = bArr;
            boolean z = true;
            this.f14703f = (i & 1) == 0;
            this.f14704g = (i & 2) == 0;
            this.f14705h = (i & 4) == 0 ? false : z;
            this.f14706i = (i & 8) == 0 ? f14698j : f14699k;
            this.f14700c = new byte[2];
            this.f14701d = 0;
            this.f14702e = this.f14704g ? 19 : -1;
        }

        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
            	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
            */
        /* JADX WARNING: Removed duplicated region for block: B:24:0x0094  */
        /* JADX WARNING: Removed duplicated region for block: B:32:0x00e8  */
        /* JADX WARNING: Removed duplicated region for block: B:75:0x01b5  */
        /* JADX WARNING: Removed duplicated region for block: B:84:0x00e6 A[SYNTHETIC] */
        /* renamed from: a */
        public boolean mo33165a(byte[] r18, int r19, int r20, boolean r21) {
            /*
                r17 = this;
                r0 = r17
                byte[] r1 = r0.f14706i
                byte[] r2 = r0.f14696a
                int r3 = r0.f14702e
                int r4 = r20 + r19
                int r5 = r0.f14701d
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
                byte[] r10 = r0.f14700c
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
                r0.f14701d = r7
                r11 = r5
                goto L_0x0053
            L_0x0031:
                int r5 = r19 + 2
                if (r5 > r4) goto L_0x0050
                byte[] r5 = r0.f14700c
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
                r0.f14701d = r7
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
                boolean r3 = r0.f14705h
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
                boolean r3 = r0.f14705h
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
                if (r21 == 0) goto L_0x01b5
                int r5 = r0.f14701d
                int r10 = r11 - r5
                int r15 = r4 + -1
                r16 = 61
                if (r10 != r15) goto L_0x0136
                if (r5 <= 0) goto L_0x00fa
                byte[] r4 = r0.f14700c
                byte r4 = r4[r7]
                r7 = 1
                goto L_0x00fc
            L_0x00fa:
                byte r4 = r18[r11]
            L_0x00fc:
                r4 = r4 & 255(0xff, float:3.57E-43)
                int r4 = r4 << r12
                int r5 = r0.f14701d
                int r5 = r5 - r7
                r0.f14701d = r5
                int r5 = r6 + 1
                int r7 = r4 >> 6
                r7 = r7 & 63
                byte r7 = r1[r7]
                r2[r6] = r7
                int r6 = r5 + 1
                r4 = r4 & 63
                byte r1 = r1[r4]
                r2[r5] = r1
                boolean r1 = r0.f14703f
                if (r1 == 0) goto L_0x0122
                int r1 = r6 + 1
                r2[r6] = r16
                int r6 = r1 + 1
                r2[r1] = r16
            L_0x0122:
                boolean r1 = r0.f14704g
                if (r1 == 0) goto L_0x01de
                boolean r1 = r0.f14705h
                if (r1 == 0) goto L_0x012f
                int r1 = r6 + 1
                r2[r6] = r13
                r6 = r1
            L_0x012f:
                int r1 = r6 + 1
                r2[r6] = r14
            L_0x0133:
                r6 = r1
                goto L_0x01de
            L_0x0136:
                int r10 = r11 - r5
                int r4 = r4 - r8
                if (r10 != r4) goto L_0x019c
                if (r5 <= r9) goto L_0x0143
                byte[] r4 = r0.f14700c
                byte r4 = r4[r7]
                r7 = 1
                goto L_0x0149
            L_0x0143:
                int r4 = r11 + 1
                byte r5 = r18[r11]
                r11 = r4
                r4 = r5
            L_0x0149:
                r4 = r4 & 255(0xff, float:3.57E-43)
                int r4 = r4 << r14
                int r5 = r0.f14701d
                if (r5 <= 0) goto L_0x0158
                byte[] r5 = r0.f14700c
                int r10 = r7 + 1
                byte r5 = r5[r7]
                r7 = r10
                goto L_0x015a
            L_0x0158:
                byte r5 = r18[r11]
            L_0x015a:
                r5 = r5 & 255(0xff, float:3.57E-43)
                int r5 = r5 << r8
                r4 = r4 | r5
                int r5 = r0.f14701d
                int r5 = r5 - r7
                r0.f14701d = r5
                int r5 = r6 + 1
                int r7 = r4 >> 12
                r7 = r7 & 63
                byte r7 = r1[r7]
                r2[r6] = r7
                int r6 = r5 + 1
                int r7 = r4 >> 6
                r7 = r7 & 63
                byte r7 = r1[r7]
                r2[r5] = r7
                int r5 = r6 + 1
                r4 = r4 & 63
                byte r1 = r1[r4]
                r2[r6] = r1
                boolean r1 = r0.f14703f
                if (r1 == 0) goto L_0x0188
                int r1 = r5 + 1
                r2[r5] = r16
                r5 = r1
            L_0x0188:
                boolean r1 = r0.f14704g
                if (r1 == 0) goto L_0x019a
                boolean r1 = r0.f14705h
                if (r1 == 0) goto L_0x0195
                int r1 = r5 + 1
                r2[r5] = r13
                r5 = r1
            L_0x0195:
                int r1 = r5 + 1
                r2[r5] = r14
                r5 = r1
            L_0x019a:
                r6 = r5
                goto L_0x01de
            L_0x019c:
                boolean r1 = r0.f14704g
                if (r1 == 0) goto L_0x01de
                if (r6 <= 0) goto L_0x01de
                r1 = 19
                if (r3 == r1) goto L_0x01de
                boolean r1 = r0.f14705h
                if (r1 == 0) goto L_0x01af
                int r1 = r6 + 1
                r2[r6] = r13
                r6 = r1
            L_0x01af:
                int r1 = r6 + 1
                r2[r6] = r14
                goto L_0x0133
            L_0x01b5:
                int r1 = r4 + -1
                if (r11 != r1) goto L_0x01c6
                byte[] r1 = r0.f14700c
                int r2 = r0.f14701d
                int r4 = r2 + 1
                r0.f14701d = r4
                byte r4 = r18[r11]
                r1[r2] = r4
                goto L_0x01de
            L_0x01c6:
                int r4 = r4 - r8
                if (r11 != r4) goto L_0x01de
                byte[] r1 = r0.f14700c
                int r2 = r0.f14701d
                int r4 = r2 + 1
                r0.f14701d = r4
                byte r5 = r18[r11]
                r1[r2] = r5
                int r2 = r4 + 1
                r0.f14701d = r2
                int r11 = r11 + r9
                byte r2 = r18[r11]
                r1[r4] = r2
            L_0x01de:
                r0.f14697b = r6
                r0.f14702e = r3
                return r9
            */
            throw new UnsupportedOperationException("Method not decompiled: p163cz.msebera.android.httpclient.p177d0.C5692a.C5694b.mo33165a(byte[], int, int, boolean):boolean");
        }
    }

    /* renamed from: a */
    public static byte[] m18124a(byte[] bArr, int i) {
        return m18125a(bArr, 0, bArr.length, i);
    }

    /* renamed from: a */
    public static byte[] m18125a(byte[] bArr, int i, int i2, int i3) {
        C5694b bVar = new C5694b(i3, (byte[]) null);
        int i4 = (i2 / 3) * 4;
        int i5 = 2;
        if (!bVar.f14703f) {
            int i6 = i2 % 3;
            if (i6 == 1) {
                i4 += 2;
            } else if (i6 == 2) {
                i4 += 3;
            }
        } else if (i2 % 3 > 0) {
            i4 += 4;
        }
        if (bVar.f14704g && i2 > 0) {
            int i7 = ((i2 - 1) / 57) + 1;
            if (!bVar.f14705h) {
                i5 = 1;
            }
            i4 += i7 * i5;
        }
        bVar.f14696a = new byte[i4];
        bVar.mo33165a(bArr, i, i2, true);
        return bVar.f14696a;
    }
}
