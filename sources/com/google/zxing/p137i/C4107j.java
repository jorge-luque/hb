package com.google.zxing.p137i;

import com.google.zxing.C4061a;
import com.google.zxing.C4063c;
import com.google.zxing.FormatException;
import com.google.zxing.WriterException;
import com.google.zxing.p134g.C4080b;
import java.util.Map;

/* renamed from: com.google.zxing.i.j */
/* compiled from: EAN13Writer */
public final class C4107j extends C4114q {
    /* renamed from: a */
    public C4080b mo28289a(String str, C4061a aVar, int i, int i2, Map<C4063c, ?> map) throws WriterException {
        if (aVar == C4061a.EAN_13) {
            return super.mo28289a(str, aVar, i, i2, map);
        }
        throw new IllegalArgumentException("Can only encode EAN_13, but got ".concat(String.valueOf(aVar)));
    }

    /* renamed from: a */
    public boolean[] mo28376a(String str) {
        int length = str.length();
        if (length == 12) {
            try {
                str = str + C4113p.m13736b(str);
            } catch (FormatException e) {
                throw new IllegalArgumentException(e);
            }
        } else if (length == 13) {
            try {
                if (!C4113p.m13735a(str)) {
                    throw new IllegalArgumentException("Contents do not pass checksum");
                }
            } catch (FormatException unused) {
                throw new IllegalArgumentException("Illegal contents");
            }
        } else {
            throw new IllegalArgumentException("Requested contents should be 12 or 13 digits long, but got ".concat(String.valueOf(length)));
        }
        int i = C4106i.f11016f[Character.digit(str.charAt(0), 10)];
        boolean[] zArr = new boolean[95];
        int a = C4111n.m13729a(zArr, 0, C4113p.f11021a, true) + 0;
        for (int i2 = 1; i2 <= 6; i2++) {
            int digit = Character.digit(str.charAt(i2), 10);
            if (((i >> (6 - i2)) & 1) == 1) {
                digit += 10;
            }
            a += C4111n.m13729a(zArr, a, C4113p.f11025e[digit], false);
        }
        int a2 = a + C4111n.m13729a(zArr, a, C4113p.f11022b, false);
        for (int i3 = 7; i3 <= 12; i3++) {
            a2 += C4111n.m13729a(zArr, a2, C4113p.f11024d[Character.digit(str.charAt(i3), 10)], true);
        }
        C4111n.m13729a(zArr, a2, C4113p.f11021a, true);
        return zArr;
    }
}
