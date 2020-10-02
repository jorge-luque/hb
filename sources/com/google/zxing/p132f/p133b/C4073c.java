package com.google.zxing.p132f.p133b;

import com.google.zxing.common.reedsolomon.C4064a;
import com.google.zxing.common.reedsolomon.C4066c;
import com.google.zxing.p134g.C4079a;
import com.google.zxing.p134g.C4080b;

/* renamed from: com.google.zxing.f.b.c */
/* compiled from: Encoder */
public final class C4073c {

    /* renamed from: a */
    private static final int[] f10921a = {4, 6, 6, 8, 8, 8, 8, 8, 8, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12};

    /* renamed from: a */
    private static int m13568a(int i, boolean z) {
        return ((z ? 88 : 112) + (i << 4)) * i;
    }

    /* renamed from: a */
    public static C4071a m13570a(byte[] bArr, int i, int i2) {
        int i3;
        int i4;
        int i5;
        boolean z;
        C4079a aVar;
        int i6;
        C4079a a = new C4074d(bArr).mo28298a();
        int i7 = 11;
        int a2 = ((a.mo28315a() * i) / 100) + 11;
        int a3 = a.mo28315a() + a2;
        int i8 = 32;
        int i9 = 0;
        int i10 = 1;
        if (i2 != 0) {
            z = i2 < 0;
            i4 = Math.abs(i2);
            if (z) {
                i8 = 4;
            }
            if (i4 <= i8) {
                i5 = m13568a(i4, z);
                i3 = f10921a[i4];
                int i11 = i5 - (i5 % i3);
                aVar = m13571a(a, i3);
                if (aVar.mo28315a() + a2 > i11) {
                    throw new IllegalArgumentException("Data to large for user specified layer");
                } else if (z && aVar.mo28315a() > (i3 << 6)) {
                    throw new IllegalArgumentException("Data to large for user specified layer");
                }
            } else {
                throw new IllegalArgumentException(String.format("Illegal value %s for layers", new Object[]{Integer.valueOf(i2)}));
            }
        } else {
            C4079a aVar2 = null;
            int i12 = 0;
            int i13 = 0;
            while (i12 <= 32) {
                boolean z2 = i12 <= 3;
                int i14 = z2 ? i12 + 1 : i12;
                int a4 = m13568a(i14, z2);
                if (a3 <= a4) {
                    if (aVar2 == null || i13 != f10921a[i14]) {
                        int i15 = f10921a[i14];
                        i13 = i15;
                        aVar2 = m13571a(a, i15);
                    }
                    int i16 = a4 - (a4 % i13);
                    if ((!z2 || aVar2.mo28315a() <= (i13 << 6)) && aVar2.mo28315a() + a2 <= i16) {
                        aVar = aVar2;
                        i3 = i13;
                        z = z2;
                        i4 = i14;
                        i5 = a4;
                    }
                }
                i12++;
                i9 = 0;
                i10 = 1;
            }
            throw new IllegalArgumentException("Data too large for an Aztec code");
        }
        C4079a b = m13576b(aVar, i5, i3);
        int a5 = aVar.mo28315a() / i3;
        C4079a a6 = m13572a(z, i4, a5);
        if (!z) {
            i7 = 14;
        }
        int i17 = i7 + (i4 << 2);
        int[] iArr = new int[i17];
        int i18 = 2;
        if (z) {
            for (int i19 = 0; i19 < i17; i19++) {
                iArr[i19] = i19;
            }
            i6 = i17;
        } else {
            int i20 = i17 / 2;
            i6 = i17 + 1 + (((i20 - 1) / 15) * 2);
            int i21 = i6 / 2;
            for (int i22 = 0; i22 < i20; i22++) {
                int i23 = (i22 / 15) + i22;
                iArr[(i20 - i22) - i10] = (i21 - i23) - 1;
                iArr[i20 + i22] = i23 + i21 + i10;
            }
        }
        C4080b bVar = new C4080b(i6);
        int i24 = 0;
        int i25 = 0;
        while (i24 < i4) {
            int i26 = ((i4 - i24) << i18) + (z ? 9 : 12);
            int i27 = 0;
            while (i27 < i26) {
                int i28 = i27 << 1;
                while (i9 < i18) {
                    if (b.mo28320a(i25 + i28 + i9)) {
                        int i29 = i24 << 1;
                        bVar.mo28332b(iArr[i29 + i9], iArr[i29 + i27]);
                    }
                    if (b.mo28320a((i26 << 1) + i25 + i28 + i9)) {
                        int i30 = i24 << 1;
                        bVar.mo28332b(iArr[i30 + i27], iArr[((i17 - 1) - i30) - i9]);
                    }
                    if (b.mo28320a((i26 << 2) + i25 + i28 + i9)) {
                        int i31 = (i17 - 1) - (i24 << 1);
                        bVar.mo28332b(iArr[i31 - i9], iArr[i31 - i27]);
                    }
                    if (b.mo28320a((i26 * 6) + i25 + i28 + i9)) {
                        int i32 = i24 << 1;
                        bVar.mo28332b(iArr[((i17 - 1) - i32) - i27], iArr[i32 + i9]);
                    }
                    i9++;
                    i18 = 2;
                }
                i27++;
                i9 = 0;
                i18 = 2;
            }
            i25 += i26 << 3;
            i24++;
            i9 = 0;
            i18 = 2;
        }
        m13574a(bVar, z, i6, a6);
        if (z) {
            m13573a(bVar, i6 / 2, 5);
        } else {
            int i33 = i6 / 2;
            m13573a(bVar, i33, 7);
            int i34 = 0;
            int i35 = 0;
            while (i35 < (i17 / 2) - 1) {
                for (int i36 = i33 & 1; i36 < i6; i36 += 2) {
                    int i37 = i33 - i34;
                    bVar.mo28332b(i37, i36);
                    int i38 = i33 + i34;
                    bVar.mo28332b(i38, i36);
                    bVar.mo28332b(i36, i37);
                    bVar.mo28332b(i36, i38);
                }
                i35 += 15;
                i34 += 16;
            }
        }
        C4071a aVar3 = new C4071a();
        aVar3.mo28293a(z);
        aVar3.mo28295c(i6);
        aVar3.mo28294b(i4);
        aVar3.mo28291a(a5);
        aVar3.mo28292a(bVar);
        return aVar3;
    }

    /* renamed from: b */
    private static C4079a m13576b(C4079a aVar, int i, int i2) {
        C4066c cVar = new C4066c(m13569a(i2));
        int i3 = i / i2;
        int[] a = m13575a(aVar, i2, i3);
        cVar.mo28288a(a, i3 - (aVar.mo28315a() / i2));
        C4079a aVar2 = new C4079a();
        aVar2.mo28316a(0, i % i2);
        for (int a2 : a) {
            aVar2.mo28316a(a2, i2);
        }
        return aVar2;
    }

    /* renamed from: a */
    private static void m13573a(C4080b bVar, int i, int i2) {
        for (int i3 = 0; i3 < i2; i3 += 2) {
            int i4 = i - i3;
            int i5 = i4;
            while (true) {
                int i6 = i + i3;
                if (i5 > i6) {
                    break;
                }
                bVar.mo28332b(i5, i4);
                bVar.mo28332b(i5, i6);
                bVar.mo28332b(i4, i5);
                bVar.mo28332b(i6, i5);
                i5++;
            }
        }
        int i7 = i - i2;
        bVar.mo28332b(i7, i7);
        int i8 = i7 + 1;
        bVar.mo28332b(i8, i7);
        bVar.mo28332b(i7, i8);
        int i9 = i + i2;
        bVar.mo28332b(i9, i7);
        bVar.mo28332b(i9, i8);
        bVar.mo28332b(i9, i9 - 1);
    }

    /* renamed from: a */
    static C4079a m13572a(boolean z, int i, int i2) {
        C4079a aVar = new C4079a();
        if (z) {
            aVar.mo28316a(i - 1, 2);
            aVar.mo28316a(i2 - 1, 6);
            return m13576b(aVar, 28, 4);
        }
        aVar.mo28316a(i - 1, 5);
        aVar.mo28316a(i2 - 1, 11);
        return m13576b(aVar, 40, 4);
    }

    /* renamed from: a */
    private static void m13574a(C4080b bVar, boolean z, int i, C4079a aVar) {
        int i2 = i / 2;
        int i3 = 0;
        if (z) {
            while (i3 < 7) {
                int i4 = (i2 - 3) + i3;
                if (aVar.mo28320a(i3)) {
                    bVar.mo28332b(i4, i2 - 5);
                }
                if (aVar.mo28320a(i3 + 7)) {
                    bVar.mo28332b(i2 + 5, i4);
                }
                if (aVar.mo28320a(20 - i3)) {
                    bVar.mo28332b(i4, i2 + 5);
                }
                if (aVar.mo28320a(27 - i3)) {
                    bVar.mo28332b(i2 - 5, i4);
                }
                i3++;
            }
            return;
        }
        while (i3 < 10) {
            int i5 = (i2 - 5) + i3 + (i3 / 5);
            if (aVar.mo28320a(i3)) {
                bVar.mo28332b(i5, i2 - 7);
            }
            if (aVar.mo28320a(i3 + 10)) {
                bVar.mo28332b(i2 + 7, i5);
            }
            if (aVar.mo28320a(29 - i3)) {
                bVar.mo28332b(i5, i2 + 7);
            }
            if (aVar.mo28320a(39 - i3)) {
                bVar.mo28332b(i2 - 7, i5);
            }
            i3++;
        }
    }

    /* renamed from: a */
    private static int[] m13575a(C4079a aVar, int i, int i2) {
        int[] iArr = new int[i2];
        int a = aVar.mo28315a() / i;
        for (int i3 = 0; i3 < a; i3++) {
            int i4 = 0;
            for (int i5 = 0; i5 < i; i5++) {
                i4 |= aVar.mo28320a((i3 * i) + i5) ? 1 << ((i - i5) - 1) : 0;
            }
            iArr[i3] = i4;
        }
        return iArr;
    }

    /* renamed from: a */
    private static C4064a m13569a(int i) {
        if (i == 4) {
            return C4064a.f10904j;
        }
        if (i == 6) {
            return C4064a.f10903i;
        }
        if (i == 8) {
            return C4064a.f10906l;
        }
        if (i == 10) {
            return C4064a.f10902h;
        }
        if (i == 12) {
            return C4064a.f10901g;
        }
        throw new IllegalArgumentException("Unsupported word size ".concat(String.valueOf(i)));
    }

    /* renamed from: a */
    static C4079a m13571a(C4079a aVar, int i) {
        C4079a aVar2 = new C4079a();
        int a = aVar.mo28315a();
        int i2 = (1 << i) - 2;
        int i3 = 0;
        while (i3 < a) {
            int i4 = 0;
            for (int i5 = 0; i5 < i; i5++) {
                int i6 = i3 + i5;
                if (i6 >= a || aVar.mo28320a(i6)) {
                    i4 |= 1 << ((i - 1) - i5);
                }
            }
            int i7 = i4 & i2;
            if (i7 == i2) {
                aVar2.mo28316a(i7, i);
            } else if (i7 == 0) {
                aVar2.mo28316a(i4 | 1, i);
            } else {
                aVar2.mo28316a(i4, i);
                i3 += i;
            }
            i3--;
            i3 += i;
        }
        return aVar2;
    }
}
