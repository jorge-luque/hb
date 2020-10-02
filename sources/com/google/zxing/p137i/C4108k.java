package com.google.zxing.p137i;

import com.google.zxing.C4061a;
import com.google.zxing.C4063c;
import com.google.zxing.FormatException;
import com.google.zxing.WriterException;
import com.google.zxing.p134g.C4080b;
import java.util.Map;

/* renamed from: com.google.zxing.i.k */
/* compiled from: EAN8Writer */
public final class C4108k extends C4114q {
    /* renamed from: a */
    public C4080b mo28289a(String str, C4061a aVar, int i, int i2, Map<C4063c, ?> map) throws WriterException {
        if (aVar == C4061a.EAN_8) {
            return super.mo28289a(str, aVar, i, i2, map);
        }
        throw new IllegalArgumentException("Can only encode EAN_8, but got ".concat(String.valueOf(aVar)));
    }

    /* renamed from: a */
    public boolean[] mo28376a(String str) {
        int length = str.length();
        if (length == 7) {
            try {
                str = str + C4113p.m13736b(str);
            } catch (FormatException e) {
                throw new IllegalArgumentException(e);
            }
        } else if (length == 8) {
            try {
                if (!C4113p.m13735a(str)) {
                    throw new IllegalArgumentException("Contents do not pass checksum");
                }
            } catch (FormatException unused) {
                throw new IllegalArgumentException("Illegal contents");
            }
        } else {
            throw new IllegalArgumentException("Requested contents should be 8 digits long, but got ".concat(String.valueOf(length)));
        }
        boolean[] zArr = new boolean[67];
        int a = C4111n.m13729a(zArr, 0, C4113p.f11021a, true) + 0;
        for (int i = 0; i <= 3; i++) {
            a += C4111n.m13729a(zArr, a, C4113p.f11024d[Character.digit(str.charAt(i), 10)], false);
        }
        int a2 = a + C4111n.m13729a(zArr, a, C4113p.f11022b, false);
        for (int i2 = 4; i2 <= 7; i2++) {
            a2 += C4111n.m13729a(zArr, a2, C4113p.f11024d[Character.digit(str.charAt(i2), 10)], true);
        }
        C4111n.m13729a(zArr, a2, C4113p.f11021a, true);
        return zArr;
    }
}
