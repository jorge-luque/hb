package com.google.zxing.p138j;

import com.google.zxing.C4061a;
import com.google.zxing.C4063c;
import com.google.zxing.C4069e;
import com.google.zxing.WriterException;
import com.google.zxing.p134g.C4080b;
import com.google.zxing.p138j.p139b.C4120c;
import com.google.zxing.p138j.p139b.C4121d;
import com.google.zxing.p138j.p139b.C4122e;
import java.lang.reflect.Array;
import java.nio.charset.Charset;
import java.util.Map;

/* renamed from: com.google.zxing.j.a */
/* compiled from: PDF417Writer */
public final class C4117a implements C4069e {
    /* renamed from: a */
    public C4080b mo28289a(String str, C4061a aVar, int i, int i2, Map<C4063c, ?> map) throws WriterException {
        int i3;
        int i4;
        if (aVar == C4061a.PDF_417) {
            C4122e eVar = new C4122e();
            int i5 = 30;
            int i6 = 2;
            if (map != null) {
                if (map.containsKey(C4063c.PDF417_COMPACT)) {
                    eVar.mo28392a(Boolean.valueOf(map.get(C4063c.PDF417_COMPACT).toString()).booleanValue());
                }
                if (map.containsKey(C4063c.PDF417_COMPACTION)) {
                    eVar.mo28389a(C4120c.m13751a(map.get(C4063c.PDF417_COMPACTION).toString()));
                }
                if (map.containsKey(C4063c.PDF417_DIMENSIONS)) {
                    C4121d dVar = (C4121d) map.get(C4063c.PDF417_DIMENSIONS);
                    eVar.mo28388a(dVar.mo28383a(), dVar.mo28385c(), dVar.mo28384b(), dVar.mo28386d());
                }
                if (map.containsKey(C4063c.MARGIN)) {
                    i5 = Integer.parseInt(map.get(C4063c.MARGIN).toString());
                }
                if (map.containsKey(C4063c.ERROR_CORRECTION)) {
                    i6 = Integer.parseInt(map.get(C4063c.ERROR_CORRECTION).toString());
                }
                if (map.containsKey(C4063c.CHARACTER_SET)) {
                    eVar.mo28391a(Charset.forName(map.get(C4063c.CHARACTER_SET).toString()));
                }
                i3 = i5;
                i4 = i6;
            } else {
                i4 = 2;
                i3 = 30;
            }
            return m13741a(eVar, str, i4, i, i2, i3);
        }
        throw new IllegalArgumentException("Can only encode PDF_417, but got ".concat(String.valueOf(aVar)));
    }

    /* renamed from: a */
    private static C4080b m13741a(C4122e eVar, String str, int i, int i2, int i3, int i4) throws WriterException {
        boolean z;
        eVar.mo28390a(str, i);
        byte[][] a = eVar.mo28387a().mo28379a(1, 4);
        if ((i3 > i2) != (a[0].length < a.length)) {
            a = m13743a(a);
            z = true;
        } else {
            z = false;
        }
        int length = i2 / a[0].length;
        int length2 = i3 / a.length;
        if (length >= length2) {
            length = length2;
        }
        if (length <= 1) {
            return m13742a(a, i4);
        }
        byte[][] a2 = eVar.mo28387a().mo28379a(length, length << 2);
        if (z) {
            a2 = m13743a(a2);
        }
        return m13742a(a2, i4);
    }

    /* renamed from: a */
    private static C4080b m13742a(byte[][] bArr, int i) {
        int i2 = i * 2;
        C4080b bVar = new C4080b(bArr[0].length + i2, bArr.length + i2);
        bVar.mo28328a();
        int b = (bVar.mo28331b() - i) - 1;
        int i3 = 0;
        while (i3 < bArr.length) {
            byte[] bArr2 = bArr[i3];
            for (int i4 = 0; i4 < bArr[0].length; i4++) {
                if (bArr2[i4] == 1) {
                    bVar.mo28332b(i4 + i, b);
                }
            }
            i3++;
            b--;
        }
        return bVar;
    }

    /* renamed from: a */
    private static byte[][] m13743a(byte[][] bArr) {
        int length = bArr[0].length;
        int[] iArr = new int[2];
        iArr[1] = bArr.length;
        iArr[0] = length;
        byte[][] bArr2 = (byte[][]) Array.newInstance(byte.class, iArr);
        for (int i = 0; i < bArr.length; i++) {
            int length2 = (bArr.length - i) - 1;
            for (int i2 = 0; i2 < bArr[0].length; i2++) {
                bArr2[i2][length2] = bArr[i][i2];
            }
        }
        return bArr2;
    }
}
