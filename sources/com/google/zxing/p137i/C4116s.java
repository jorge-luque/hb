package com.google.zxing.p137i;

import com.google.zxing.C4061a;
import com.google.zxing.C4063c;
import com.google.zxing.FormatException;
import com.google.zxing.WriterException;
import com.google.zxing.p134g.C4080b;
import java.util.Map;

/* renamed from: com.google.zxing.i.s */
/* compiled from: UPCEWriter */
public final class C4116s extends C4114q {
    /* renamed from: a */
    public C4080b mo28289a(String str, C4061a aVar, int i, int i2, Map<C4063c, ?> map) throws WriterException {
        if (aVar == C4061a.UPC_E) {
            return super.mo28289a(str, aVar, i, i2, map);
        }
        throw new IllegalArgumentException("Can only encode UPC_E, but got ".concat(String.valueOf(aVar)));
    }

    /* renamed from: a */
    public boolean[] mo28376a(String str) {
        int length = str.length();
        if (length == 7) {
            try {
                str = str + C4113p.m13736b(C4115r.m13738a(str));
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
        int digit = Character.digit(str.charAt(0), 10);
        if (digit == 0 || digit == 1) {
            int i = C4115r.f11026f[digit][Character.digit(str.charAt(7), 10)];
            boolean[] zArr = new boolean[51];
            int a = C4111n.m13729a(zArr, 0, C4113p.f11021a, true) + 0;
            for (int i2 = 1; i2 <= 6; i2++) {
                int digit2 = Character.digit(str.charAt(i2), 10);
                if (((i >> (6 - i2)) & 1) == 1) {
                    digit2 += 10;
                }
                a += C4111n.m13729a(zArr, a, C4113p.f11025e[digit2], false);
            }
            C4111n.m13729a(zArr, a, C4113p.f11023c, false);
            return zArr;
        }
        throw new IllegalArgumentException("Number system must be 0 or 1");
    }
}
