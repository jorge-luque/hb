package com.google.zxing.p132f;

import com.google.zxing.C4061a;
import com.google.zxing.C4063c;
import com.google.zxing.C4069e;
import com.google.zxing.p132f.p133b.C4071a;
import com.google.zxing.p132f.p133b.C4073c;
import com.google.zxing.p134g.C4080b;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Map;

/* renamed from: com.google.zxing.f.a */
/* compiled from: AztecWriter */
public final class C4070a implements C4069e {
    /* renamed from: a */
    public C4080b mo28289a(String str, C4061a aVar, int i, int i2, Map<C4063c, ?> map) {
        int i3;
        int i4;
        Charset charset;
        Charset charset2 = StandardCharsets.ISO_8859_1;
        int i5 = 33;
        if (map != null) {
            if (map.containsKey(C4063c.CHARACTER_SET)) {
                charset2 = Charset.forName(map.get(C4063c.CHARACTER_SET).toString());
            }
            if (map.containsKey(C4063c.ERROR_CORRECTION)) {
                i5 = Integer.parseInt(map.get(C4063c.ERROR_CORRECTION).toString());
            }
            if (map.containsKey(C4063c.AZTEC_LAYERS)) {
                charset = charset2;
                i4 = i5;
                i3 = Integer.parseInt(map.get(C4063c.AZTEC_LAYERS).toString());
                return m13559a(str, aVar, i, i2, charset, i4, i3);
            }
            charset = charset2;
            i4 = i5;
        } else {
            charset = charset2;
            i4 = 33;
        }
        i3 = 0;
        return m13559a(str, aVar, i, i2, charset, i4, i3);
    }

    /* renamed from: a */
    private static C4080b m13559a(String str, C4061a aVar, int i, int i2, Charset charset, int i3, int i4) {
        if (aVar == C4061a.AZTEC) {
            return m13558a(C4073c.m13570a(str.getBytes(charset), i3, i4), i, i2);
        }
        throw new IllegalArgumentException("Can only encode AZTEC, but got ".concat(String.valueOf(aVar)));
    }

    /* renamed from: a */
    private static C4080b m13558a(C4071a aVar, int i, int i2) {
        C4080b a = aVar.mo28290a();
        if (a != null) {
            int c = a.mo28333c();
            int b = a.mo28331b();
            int max = Math.max(i, c);
            int max2 = Math.max(i2, b);
            int min = Math.min(max / c, max2 / b);
            int i3 = (max - (c * min)) / 2;
            int i4 = (max2 - (b * min)) / 2;
            C4080b bVar = new C4080b(max, max2);
            int i5 = 0;
            while (i5 < b) {
                int i6 = i3;
                int i7 = 0;
                while (i7 < c) {
                    if (a.mo28330a(i7, i5)) {
                        bVar.mo28329a(i6, i4, min, min);
                    }
                    i7++;
                    i6 += min;
                }
                i5++;
                i4 += min;
            }
            return bVar;
        }
        throw new IllegalStateException();
    }
}
