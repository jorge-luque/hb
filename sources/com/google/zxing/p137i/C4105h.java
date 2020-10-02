package com.google.zxing.p137i;

import com.google.zxing.C4061a;
import com.google.zxing.C4063c;
import com.google.zxing.WriterException;
import com.google.zxing.p134g.C4080b;
import java.util.Map;

/* renamed from: com.google.zxing.i.h */
/* compiled from: Code93Writer */
public class C4105h extends C4111n {
    /* renamed from: a */
    public C4080b mo28289a(String str, C4061a aVar, int i, int i2, Map<C4063c, ?> map) throws WriterException {
        if (aVar == C4061a.CODE_93) {
            return super.mo28289a(str, aVar, i, i2, map);
        }
        throw new IllegalArgumentException("Can only encode CODE_93, but got ".concat(String.valueOf(aVar)));
    }

    /* renamed from: a */
    public boolean[] mo28376a(String str) {
        int length = str.length();
        if (length <= 80) {
            int[] iArr = new int[9];
            m13720a(C4104g.f11015a[47], iArr);
            boolean[] zArr = new boolean[(((str.length() + 2 + 2) * 9) + 1)];
            int a = m13719a(zArr, 0, iArr);
            for (int i = 0; i < length; i++) {
                m13720a(C4104g.f11015a["0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%abcd*".indexOf(str.charAt(i))], iArr);
                a += m13719a(zArr, a, iArr);
            }
            int a2 = m13718a(str, 20);
            m13720a(C4104g.f11015a[a2], iArr);
            int a3 = a + m13719a(zArr, a, iArr);
            m13720a(C4104g.f11015a[m13718a(str + "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%abcd*".charAt(a2), 15)], iArr);
            int a4 = a3 + m13719a(zArr, a3, iArr);
            m13720a(C4104g.f11015a[47], iArr);
            zArr[a4 + m13719a(zArr, a4, iArr)] = true;
            return zArr;
        }
        throw new IllegalArgumentException("Requested contents should be less than 80 digits long, but got ".concat(String.valueOf(length)));
    }

    /* renamed from: a */
    private static void m13720a(int i, int[] iArr) {
        for (int i2 = 0; i2 < 9; i2++) {
            int i3 = 1;
            if (((1 << (8 - i2)) & i) == 0) {
                i3 = 0;
            }
            iArr[i2] = i3;
        }
    }

    /* renamed from: a */
    private static int m13719a(boolean[] zArr, int i, int[] iArr) {
        int length = iArr.length;
        int i2 = 0;
        while (i2 < length) {
            int i3 = i + 1;
            zArr[i] = iArr[i2] != 0;
            i2++;
            i = i3;
        }
        return 9;
    }

    /* renamed from: a */
    private static int m13718a(String str, int i) {
        int i2 = 0;
        int i3 = 1;
        for (int length = str.length() - 1; length >= 0; length--) {
            i2 += "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%abcd*".indexOf(str.charAt(length)) * i3;
            i3++;
            if (i3 > i) {
                i3 = 1;
            }
        }
        return i2 % 47;
    }
}
