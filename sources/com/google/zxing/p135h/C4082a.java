package com.google.zxing.p135h;

import com.google.zxing.C4061a;
import com.google.zxing.C4062b;
import com.google.zxing.C4063c;
import com.google.zxing.C4069e;
import com.google.zxing.p134g.C4080b;
import com.google.zxing.p135h.p136b.C4087e;
import com.google.zxing.p135h.p136b.C4091i;
import com.google.zxing.p135h.p136b.C4092j;
import com.google.zxing.p135h.p136b.C4093k;
import com.google.zxing.p135h.p136b.C4094l;
import com.google.zxing.p140k.p142c.C4133b;
import java.util.Map;

/* renamed from: com.google.zxing.h.a */
/* compiled from: DataMatrixWriter */
public final class C4082a implements C4069e {
    /* renamed from: a */
    public C4080b mo28289a(String str, C4061a aVar, int i, int i2, Map<C4063c, ?> map) {
        C4062b bVar;
        if (str.isEmpty()) {
            throw new IllegalArgumentException("Found empty contents");
        } else if (aVar != C4061a.DATA_MATRIX) {
            throw new IllegalArgumentException("Can only encode DATA_MATRIX, but got ".concat(String.valueOf(aVar)));
        } else if (i < 0 || i2 < 0) {
            throw new IllegalArgumentException("Requested dimensions can't be negative: " + i + 'x' + i2);
        } else {
            C4094l lVar = C4094l.FORCE_NONE;
            C4062b bVar2 = null;
            if (map != null) {
                C4094l lVar2 = (C4094l) map.get(C4063c.DATA_MATRIX_SHAPE);
                if (lVar2 != null) {
                    lVar = lVar2;
                }
                C4062b bVar3 = (C4062b) map.get(C4063c.MIN_SIZE);
                if (bVar3 == null) {
                    bVar3 = null;
                }
                bVar = (C4062b) map.get(C4063c.MAX_SIZE);
                if (bVar == null) {
                    bVar = null;
                }
                bVar2 = bVar3;
            } else {
                bVar = null;
            }
            String a = C4092j.m13680a(str, lVar, bVar2, bVar);
            C4093k a2 = C4093k.m13690a(a.length(), lVar, bVar2, bVar, true);
            C4087e eVar = new C4087e(C4091i.m13674a(a, a2), a2.mo28372e(), a2.mo28371d());
            eVar.mo28347a();
            return m13619a(eVar, a2, i, i2);
        }
    }

    /* renamed from: a */
    private static C4080b m13619a(C4087e eVar, C4093k kVar, int i, int i2) {
        int e = kVar.mo28372e();
        int d = kVar.mo28371d();
        C4133b bVar = new C4133b(kVar.mo28374g(), kVar.mo28373f());
        int i3 = 0;
        for (int i4 = 0; i4 < d; i4++) {
            if (i4 % kVar.f10996e == 0) {
                int i5 = 0;
                for (int i6 = 0; i6 < kVar.mo28374g(); i6++) {
                    bVar.mo28412a(i5, i3, i6 % 2 == 0);
                    i5++;
                }
                i3++;
            }
            int i7 = 0;
            for (int i8 = 0; i8 < e; i8++) {
                if (i8 % kVar.f10995d == 0) {
                    bVar.mo28412a(i7, i3, true);
                    i7++;
                }
                bVar.mo28412a(i7, i3, eVar.mo28348a(i8, i4));
                i7++;
                int i9 = kVar.f10995d;
                if (i8 % i9 == i9 - 1) {
                    bVar.mo28412a(i7, i3, i4 % 2 == 0);
                    i7++;
                }
            }
            i3++;
            int i10 = kVar.f10996e;
            if (i4 % i10 == i10 - 1) {
                int i11 = 0;
                for (int i12 = 0; i12 < kVar.mo28374g(); i12++) {
                    bVar.mo28412a(i11, i3, true);
                    i11++;
                }
                i3++;
            }
        }
        return m13620a(bVar, i, i2);
    }

    /* renamed from: a */
    private static C4080b m13620a(C4133b bVar, int i, int i2) {
        C4080b bVar2;
        int c = bVar.mo28415c();
        int b = bVar.mo28414b();
        int max = Math.max(i, c);
        int max2 = Math.max(i2, b);
        int min = Math.min(max / c, max2 / b);
        int i3 = (max - (c * min)) / 2;
        int i4 = (max2 - (b * min)) / 2;
        if (i2 < b || i < c) {
            bVar2 = new C4080b(c, b);
            i3 = 0;
            i4 = 0;
        } else {
            bVar2 = new C4080b(i, i2);
        }
        bVar2.mo28328a();
        int i5 = 0;
        while (i5 < b) {
            int i6 = i3;
            int i7 = 0;
            while (i7 < c) {
                if (bVar.mo28409a(i7, i5) == 1) {
                    bVar2.mo28329a(i6, i4, min, min);
                }
                i7++;
                i6 += min;
            }
            i5++;
            i4 += min;
        }
        return bVar2;
    }
}
