package com.google.zxing.p137i;

import com.google.zxing.FormatException;

/* renamed from: com.google.zxing.i.p */
/* compiled from: UPCEANReader */
public abstract class C4113p extends C4110m {

    /* renamed from: a */
    static final int[] f11021a = {1, 1, 1};

    /* renamed from: b */
    static final int[] f11022b = {1, 1, 1, 1, 1};

    /* renamed from: c */
    static final int[] f11023c = {1, 1, 1, 1, 1, 1};

    /* renamed from: d */
    static final int[][] f11024d;

    /* renamed from: e */
    static final int[][] f11025e;

    static {
        int[][] iArr = {new int[]{3, 2, 1, 1}, new int[]{2, 2, 2, 1}, new int[]{2, 1, 2, 2}, new int[]{1, 4, 1, 1}, new int[]{1, 1, 3, 2}, new int[]{1, 2, 3, 1}, new int[]{1, 1, 1, 4}, new int[]{1, 3, 1, 2}, new int[]{1, 2, 1, 3}, new int[]{3, 1, 1, 2}};
        f11024d = iArr;
        int[][] iArr2 = new int[20][];
        f11025e = iArr2;
        System.arraycopy(iArr, 0, iArr2, 0, 10);
        for (int i = 10; i < 20; i++) {
            int[] iArr3 = f11024d[i - 10];
            int[] iArr4 = new int[iArr3.length];
            for (int i2 = 0; i2 < iArr3.length; i2++) {
                iArr4[i2] = iArr3[(iArr3.length - i2) - 1];
            }
            f11025e[i] = iArr4;
        }
    }

    /* renamed from: a */
    static boolean m13735a(CharSequence charSequence) throws FormatException {
        int length = charSequence.length();
        if (length == 0) {
            return false;
        }
        int i = length - 1;
        return m13736b(charSequence.subSequence(0, i)) == Character.digit(charSequence.charAt(i), 10);
    }

    /* renamed from: b */
    static int m13736b(CharSequence charSequence) throws FormatException {
        int length = charSequence.length();
        int i = 0;
        for (int i2 = length - 1; i2 >= 0; i2 -= 2) {
            int charAt = charSequence.charAt(i2) - '0';
            if (charAt < 0 || charAt > 9) {
                throw FormatException.m13534a();
            }
            i += charAt;
        }
        int i3 = i * 3;
        for (int i4 = length - 2; i4 >= 0; i4 -= 2) {
            int charAt2 = charSequence.charAt(i4) - '0';
            if (charAt2 < 0 || charAt2 > 9) {
                throw FormatException.m13534a();
            }
            i3 += charAt2;
        }
        return (1000 - i3) % 10;
    }
}
