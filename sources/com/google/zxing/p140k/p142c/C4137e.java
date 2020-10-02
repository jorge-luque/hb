package com.google.zxing.p140k.p142c;

import admost.sdk.listener.AdMostAdListener;
import com.google.zxing.WriterException;
import com.google.zxing.p134g.C4079a;
import com.google.zxing.p140k.p141b.C4127a;
import com.google.zxing.p140k.p141b.C4129c;
import com.ogury.p159cm.OguryChoiceManager;

/* renamed from: com.google.zxing.k.c.e */
/* compiled from: MatrixUtil */
final class C4137e {

    /* renamed from: a */
    private static final int[][] f11092a = {new int[]{1, 1, 1, 1, 1, 1, 1}, new int[]{1, 0, 0, 0, 0, 0, 1}, new int[]{1, 0, 1, 1, 1, 0, 1}, new int[]{1, 0, 1, 1, 1, 0, 1}, new int[]{1, 0, 1, 1, 1, 0, 1}, new int[]{1, 0, 0, 0, 0, 0, 1}, new int[]{1, 1, 1, 1, 1, 1, 1}};

    /* renamed from: b */
    private static final int[][] f11093b = {new int[]{1, 1, 1, 1, 1}, new int[]{1, 0, 0, 0, 1}, new int[]{1, 0, 1, 0, 1}, new int[]{1, 0, 0, 0, 1}, new int[]{1, 1, 1, 1, 1}};

    /* renamed from: c */
    private static final int[][] f11094c = {new int[]{-1, -1, -1, -1, -1, -1, -1}, new int[]{6, 18, -1, -1, -1, -1, -1}, new int[]{6, 22, -1, -1, -1, -1, -1}, new int[]{6, 26, -1, -1, -1, -1, -1}, new int[]{6, 30, -1, -1, -1, -1, -1}, new int[]{6, 34, -1, -1, -1, -1, -1}, new int[]{6, 22, 38, -1, -1, -1, -1}, new int[]{6, 24, 42, -1, -1, -1, -1}, new int[]{6, 26, 46, -1, -1, -1, -1}, new int[]{6, 28, 50, -1, -1, -1, -1}, new int[]{6, 30, 54, -1, -1, -1, -1}, new int[]{6, 32, 58, -1, -1, -1, -1}, new int[]{6, 34, 62, -1, -1, -1, -1}, new int[]{6, 26, 46, 66, -1, -1, -1}, new int[]{6, 26, 48, 70, -1, -1, -1}, new int[]{6, 26, 50, 74, -1, -1, -1}, new int[]{6, 30, 54, 78, -1, -1, -1}, new int[]{6, 30, 56, 82, -1, -1, -1}, new int[]{6, 30, 58, 86, -1, -1, -1}, new int[]{6, 34, 62, 90, -1, -1, -1}, new int[]{6, 28, 50, 72, 94, -1, -1}, new int[]{6, 26, 50, 74, 98, -1, -1}, new int[]{6, 30, 54, 78, 102, -1, -1}, new int[]{6, 28, 54, 80, 106, -1, -1}, new int[]{6, 32, 58, 84, 110, -1, -1}, new int[]{6, 30, 58, 86, 114, -1, -1}, new int[]{6, 34, 62, 90, 118, -1, -1}, new int[]{6, 26, 50, 74, 98, 122, -1}, new int[]{6, 30, 54, 78, 102, 126, -1}, new int[]{6, 26, 52, 78, 104, 130, -1}, new int[]{6, 30, 56, 82, 108, 134, -1}, new int[]{6, 34, 60, 86, 112, 138, -1}, new int[]{6, 30, 58, 86, 114, 142, -1}, new int[]{6, 34, 62, 90, 118, 146, -1}, new int[]{6, 30, 54, 78, 102, 126, 150}, new int[]{6, 24, 50, 76, 102, OguryChoiceManager.TcfV2.Purpose.MEASURE_AD_PERFORMANCE, 154}, new int[]{6, 28, 54, 80, 106, 132, 158}, new int[]{6, 32, 58, 84, 110, 136, AdMostAdListener.COMPLETED}, new int[]{6, 26, 54, 82, 110, 138, AdMostAdListener.STATUS_CHANGED}, new int[]{6, 30, 58, 86, 114, 142, 170}};

    /* renamed from: d */
    private static final int[][] f11095d = {new int[]{8, 0}, new int[]{8, 1}, new int[]{8, 2}, new int[]{8, 3}, new int[]{8, 4}, new int[]{8, 5}, new int[]{8, 7}, new int[]{8, 8}, new int[]{7, 8}, new int[]{5, 8}, new int[]{4, 8}, new int[]{3, 8}, new int[]{2, 8}, new int[]{1, 8}, new int[]{0, 8}};

    /* renamed from: a */
    static void m13850a(C4133b bVar) {
        bVar.mo28410a((byte) -1);
    }

    /* renamed from: b */
    private static void m13853b(C4133b bVar) throws WriterException {
        if (bVar.mo28409a(8, bVar.mo28414b() - 8) != 0) {
            bVar.mo28411a(8, bVar.mo28414b() - 8, 1);
            return;
        }
        throw new WriterException();
    }

    /* renamed from: b */
    private static boolean m13854b(int i) {
        return i == -1;
    }

    /* renamed from: c */
    static void m13856c(C4129c cVar, C4133b bVar) throws WriterException {
        if (cVar.mo28399c() >= 7) {
            C4079a aVar = new C4079a();
            m13848a(cVar, aVar);
            int i = 17;
            for (int i2 = 0; i2 < 6; i2++) {
                for (int i3 = 0; i3 < 3; i3++) {
                    boolean a = aVar.mo28320a(i);
                    i--;
                    bVar.mo28412a(i2, (bVar.mo28414b() - 11) + i3, a);
                    bVar.mo28412a((bVar.mo28414b() - 11) + i3, i2, a);
                }
            }
        }
    }

    /* renamed from: d */
    private static void m13859d(C4133b bVar) {
        int i = 8;
        while (i < bVar.mo28415c() - 8) {
            int i2 = i + 1;
            int i3 = i2 % 2;
            if (m13854b((int) bVar.mo28409a(i, 6))) {
                bVar.mo28411a(i, 6, i3);
            }
            if (m13854b((int) bVar.mo28409a(6, i))) {
                bVar.mo28411a(6, i, i3);
            }
            i = i2;
        }
    }

    /* renamed from: a */
    static void m13845a(C4079a aVar, C4127a aVar2, C4129c cVar, int i, C4133b bVar) throws WriterException {
        m13850a(bVar);
        m13849a(cVar, bVar);
        m13847a(aVar2, i, bVar);
        m13856c(cVar, bVar);
        m13844a(aVar, i, bVar);
    }

    /* renamed from: b */
    private static void m13851b(int i, int i2, C4133b bVar) {
        for (int i3 = 0; i3 < 5; i3++) {
            int[] iArr = f11093b[i3];
            for (int i4 = 0; i4 < 5; i4++) {
                bVar.mo28411a(i + i4, i2 + i3, iArr[i4]);
            }
        }
    }

    /* renamed from: b */
    private static void m13852b(C4129c cVar, C4133b bVar) {
        if (cVar.mo28399c() >= 2) {
            int[] iArr = f11094c[cVar.mo28399c() - 1];
            for (int i : iArr) {
                if (i >= 0) {
                    for (int i2 : iArr) {
                        if (i2 >= 0 && m13854b((int) bVar.mo28409a(i2, i))) {
                            m13851b(i2 - 2, i - 2, bVar);
                        }
                    }
                }
            }
        }
    }

    /* renamed from: a */
    static void m13849a(C4129c cVar, C4133b bVar) throws WriterException {
        m13857c(bVar);
        m13853b(bVar);
        m13852b(cVar, bVar);
        m13859d(bVar);
    }

    /* renamed from: c */
    private static void m13855c(int i, int i2, C4133b bVar) {
        for (int i3 = 0; i3 < 7; i3++) {
            int[] iArr = f11092a[i3];
            for (int i4 = 0; i4 < 7; i4++) {
                bVar.mo28411a(i + i4, i2 + i3, iArr[i4]);
            }
        }
    }

    /* renamed from: d */
    private static void m13858d(int i, int i2, C4133b bVar) throws WriterException {
        int i3 = 0;
        while (i3 < 7) {
            int i4 = i2 + i3;
            if (m13854b((int) bVar.mo28409a(i, i4))) {
                bVar.mo28411a(i, i4, 0);
                i3++;
            } else {
                throw new WriterException();
            }
        }
    }

    /* renamed from: c */
    private static void m13857c(C4133b bVar) throws WriterException {
        int length = f11092a[0].length;
        m13855c(0, 0, bVar);
        m13855c(bVar.mo28415c() - length, 0, bVar);
        m13855c(0, bVar.mo28415c() - length, bVar);
        m13843a(0, 7, bVar);
        m13843a(bVar.mo28415c() - 8, 7, bVar);
        m13843a(0, bVar.mo28415c() - 8, bVar);
        m13858d(7, 0, bVar);
        m13858d((bVar.mo28414b() - 7) - 1, 0, bVar);
        m13858d(7, bVar.mo28414b() - 7, bVar);
    }

    /* renamed from: a */
    static void m13847a(C4127a aVar, int i, C4133b bVar) throws WriterException {
        C4079a aVar2 = new C4079a();
        m13846a(aVar, i, aVar2);
        for (int i2 = 0; i2 < aVar2.mo28315a(); i2++) {
            boolean a = aVar2.mo28320a((aVar2.mo28315a() - 1) - i2);
            int[] iArr = f11095d[i2];
            bVar.mo28412a(iArr[0], iArr[1], a);
            if (i2 < 8) {
                bVar.mo28412a((bVar.mo28415c() - i2) - 1, 8, a);
            } else {
                bVar.mo28412a(8, (bVar.mo28414b() - 7) + (i2 - 8), a);
            }
        }
    }

    /* renamed from: a */
    static void m13844a(C4079a aVar, int i, C4133b bVar) throws WriterException {
        boolean z;
        int c = bVar.mo28415c() - 1;
        int b = bVar.mo28414b() - 1;
        int i2 = 0;
        int i3 = -1;
        while (c > 0) {
            if (c == 6) {
                c--;
            }
            while (b >= 0 && b < bVar.mo28414b()) {
                for (int i4 = 0; i4 < 2; i4++) {
                    int i5 = c - i4;
                    if (m13854b((int) bVar.mo28409a(i5, b))) {
                        if (i2 < aVar.mo28315a()) {
                            z = aVar.mo28320a(i2);
                            i2++;
                        } else {
                            z = false;
                        }
                        if (i != -1 && C4136d.m13835a(i, i5, b)) {
                            z = !z;
                        }
                        bVar.mo28412a(i5, b, z);
                    }
                }
                b += i3;
            }
            i3 = -i3;
            b += i3;
            c -= 2;
        }
        if (i2 != aVar.mo28315a()) {
            throw new WriterException("Not all bits consumed: " + i2 + '/' + aVar.mo28315a());
        }
    }

    /* renamed from: a */
    static int m13841a(int i) {
        return 32 - Integer.numberOfLeadingZeros(i);
    }

    /* renamed from: a */
    static int m13842a(int i, int i2) {
        if (i2 != 0) {
            int a = m13841a(i2);
            int i3 = i << (a - 1);
            while (m13841a(i3) >= a) {
                i3 ^= i2 << (m13841a(i3) - a);
            }
            return i3;
        }
        throw new IllegalArgumentException("0 polynomial");
    }

    /* renamed from: a */
    static void m13846a(C4127a aVar, int i, C4079a aVar2) throws WriterException {
        if (C4138f.m13860b(i)) {
            int a = (aVar.mo28393a() << 3) | i;
            aVar2.mo28316a(a, 5);
            aVar2.mo28316a(m13842a(a, 1335), 10);
            C4079a aVar3 = new C4079a();
            aVar3.mo28316a(21522, 15);
            aVar2.mo28322b(aVar3);
            if (aVar2.mo28315a() != 15) {
                throw new WriterException("should not happen but we got: " + aVar2.mo28315a());
            }
            return;
        }
        throw new WriterException("Invalid mask pattern");
    }

    /* renamed from: a */
    static void m13848a(C4129c cVar, C4079a aVar) throws WriterException {
        aVar.mo28316a(cVar.mo28399c(), 6);
        aVar.mo28316a(m13842a(cVar.mo28399c(), 7973), 12);
        if (aVar.mo28315a() != 18) {
            throw new WriterException("should not happen but we got: " + aVar.mo28315a());
        }
    }

    /* renamed from: a */
    private static void m13843a(int i, int i2, C4133b bVar) throws WriterException {
        int i3 = 0;
        while (i3 < 8) {
            int i4 = i + i3;
            if (m13854b((int) bVar.mo28409a(i4, i2))) {
                bVar.mo28411a(i4, i2, 0);
                i3++;
            } else {
                throw new WriterException();
            }
        }
    }
}
