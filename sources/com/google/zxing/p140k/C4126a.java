package com.google.zxing.p140k;

import com.google.zxing.C4061a;
import com.google.zxing.C4063c;
import com.google.zxing.C4069e;
import com.google.zxing.WriterException;
import com.google.zxing.p134g.C4080b;
import com.google.zxing.p140k.p141b.C4127a;
import com.google.zxing.p140k.p142c.C4133b;
import com.google.zxing.p140k.p142c.C4134c;
import com.google.zxing.p140k.p142c.C4138f;
import java.util.Map;

/* renamed from: com.google.zxing.k.a */
/* compiled from: QRCodeWriter */
public final class C4126a implements C4069e {
    /* renamed from: a */
    public C4080b mo28289a(String str, C4061a aVar, int i, int i2, Map<C4063c, ?> map) throws WriterException {
        if (str.isEmpty()) {
            throw new IllegalArgumentException("Found empty contents");
        } else if (aVar != C4061a.QR_CODE) {
            throw new IllegalArgumentException("Can only encode QR_CODE, but got ".concat(String.valueOf(aVar)));
        } else if (i < 0 || i2 < 0) {
            throw new IllegalArgumentException("Requested dimensions are too small: " + i + 'x' + i2);
        } else {
            C4127a aVar2 = C4127a.L;
            int i3 = 4;
            if (map != null) {
                if (map.containsKey(C4063c.ERROR_CORRECTION)) {
                    aVar2 = C4127a.m13785a(map.get(C4063c.ERROR_CORRECTION).toString());
                }
                if (map.containsKey(C4063c.MARGIN)) {
                    i3 = Integer.parseInt(map.get(C4063c.MARGIN).toString());
                }
            }
            return m13783a(C4134c.m13819a(str, aVar2, map), i, i2, i3);
        }
    }

    /* renamed from: a */
    private static C4080b m13783a(C4138f fVar, int i, int i2, int i3) {
        C4133b a = fVar.mo28417a();
        if (a != null) {
            int c = a.mo28415c();
            int b = a.mo28414b();
            int i4 = i3 << 1;
            int i5 = c + i4;
            int i6 = i4 + b;
            int max = Math.max(i, i5);
            int max2 = Math.max(i2, i6);
            int min = Math.min(max / i5, max2 / i6);
            int i7 = (max - (c * min)) / 2;
            int i8 = (max2 - (b * min)) / 2;
            C4080b bVar = new C4080b(max, max2);
            int i9 = 0;
            while (i9 < b) {
                int i10 = i7;
                int i11 = 0;
                while (i11 < c) {
                    if (a.mo28409a(i11, i9) == 1) {
                        bVar.mo28329a(i10, i8, min, min);
                    }
                    i11++;
                    i10 += min;
                }
                i9++;
                i8 += min;
            }
            return bVar;
        }
        throw new IllegalStateException();
    }
}
