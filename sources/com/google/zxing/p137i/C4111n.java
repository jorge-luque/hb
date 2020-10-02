package com.google.zxing.p137i;

import com.google.zxing.C4061a;
import com.google.zxing.C4063c;
import com.google.zxing.C4069e;
import com.google.zxing.WriterException;
import com.google.zxing.p134g.C4080b;
import java.util.Map;

/* renamed from: com.google.zxing.i.n */
/* compiled from: OneDimensionalCodeWriter */
public abstract class C4111n implements C4069e {
    /* renamed from: a */
    public int mo28377a() {
        return 10;
    }

    /* renamed from: a */
    public C4080b mo28289a(String str, C4061a aVar, int i, int i2, Map<C4063c, ?> map) throws WriterException {
        if (str.isEmpty()) {
            throw new IllegalArgumentException("Found empty contents");
        } else if (i < 0 || i2 < 0) {
            throw new IllegalArgumentException("Negative size is not allowed. Input: " + i + 'x' + i2);
        } else {
            int a = mo28377a();
            if (map != null && map.containsKey(C4063c.MARGIN)) {
                a = Integer.parseInt(map.get(C4063c.MARGIN).toString());
            }
            return m13730a(mo28376a(str), i, i2, a);
        }
    }

    /* renamed from: a */
    public abstract boolean[] mo28376a(String str);

    /* renamed from: a */
    private static C4080b m13730a(boolean[] zArr, int i, int i2, int i3) {
        int length = zArr.length;
        int i4 = i3 + length;
        int max = Math.max(i, i4);
        int max2 = Math.max(1, i2);
        int i5 = max / i4;
        int i6 = (max - (length * i5)) / 2;
        C4080b bVar = new C4080b(max, max2);
        int i7 = 0;
        while (i7 < length) {
            if (zArr[i7]) {
                bVar.mo28329a(i6, 0, i5, max2);
            }
            i7++;
            i6 += i5;
        }
        return bVar;
    }

    /* renamed from: a */
    protected static int m13729a(boolean[] zArr, int i, int[] iArr, boolean z) {
        int i2 = 0;
        for (int i3 : iArr) {
            int i4 = 0;
            while (i4 < i3) {
                zArr[i] = z;
                i4++;
                i++;
            }
            i2 += i3;
            z = !z;
        }
        return i2;
    }
}
