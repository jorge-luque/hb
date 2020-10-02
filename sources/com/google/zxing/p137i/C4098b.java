package com.google.zxing.p137i;

/* renamed from: com.google.zxing.i.b */
/* compiled from: CodaBarWriter */
public final class C4098b extends C4111n {

    /* renamed from: a */
    private static final char[] f11005a;

    /* renamed from: b */
    private static final char[] f11006b = {'T', 'N', '*', 'E'};

    /* renamed from: c */
    private static final char[] f11007c = {'/', ':', '+', '.'};

    /* renamed from: d */
    private static final char f11008d;

    static {
        char[] cArr = {'A', 'B', 'C', 'D'};
        f11005a = cArr;
        f11008d = cArr[0];
    }

    /* renamed from: a */
    public boolean[] mo28376a(String str) {
        int i;
        if (str.length() < 2) {
            str = f11008d + str + f11008d;
        } else {
            char upperCase = Character.toUpperCase(str.charAt(0));
            char upperCase2 = Character.toUpperCase(str.charAt(str.length() - 1));
            boolean a = C4097a.m13708a(f11005a, upperCase);
            boolean a2 = C4097a.m13708a(f11005a, upperCase2);
            boolean a3 = C4097a.m13708a(f11006b, upperCase);
            boolean a4 = C4097a.m13708a(f11006b, upperCase2);
            if (a) {
                if (!a2) {
                    throw new IllegalArgumentException("Invalid start/end guards: ".concat(String.valueOf(str)));
                }
            } else if (a3) {
                if (!a4) {
                    throw new IllegalArgumentException("Invalid start/end guards: ".concat(String.valueOf(str)));
                }
            } else if (a2 || a4) {
                throw new IllegalArgumentException("Invalid start/end guards: ".concat(String.valueOf(str)));
            } else {
                str = f11008d + str + f11008d;
            }
        }
        int i2 = 20;
        for (int i3 = 1; i3 < str.length() - 1; i3++) {
            if (Character.isDigit(str.charAt(i3)) || str.charAt(i3) == '-' || str.charAt(i3) == '$') {
                i2 += 9;
            } else if (C4097a.m13708a(f11007c, str.charAt(i3))) {
                i2 += 10;
            } else {
                throw new IllegalArgumentException("Cannot encode : '" + str.charAt(i3) + '\'');
            }
        }
        boolean[] zArr = new boolean[(i2 + (str.length() - 1))];
        int i4 = 0;
        for (int i5 = 0; i5 < str.length(); i5++) {
            char upperCase3 = Character.toUpperCase(str.charAt(i5));
            if (i5 == 0 || i5 == str.length() - 1) {
                if (upperCase3 == '*') {
                    upperCase3 = 'C';
                } else if (upperCase3 == 'E') {
                    upperCase3 = 'D';
                } else if (upperCase3 == 'N') {
                    upperCase3 = 'B';
                } else if (upperCase3 == 'T') {
                    upperCase3 = 'A';
                }
            }
            int i6 = 0;
            while (true) {
                char[] cArr = C4097a.f11003a;
                if (i6 >= cArr.length) {
                    i = 0;
                    break;
                } else if (upperCase3 == cArr[i6]) {
                    i = C4097a.f11004b[i6];
                    break;
                } else {
                    i6++;
                }
            }
            int i7 = 0;
            boolean z = true;
            while (true) {
                int i8 = 0;
                while (i7 < 7) {
                    zArr[i4] = z;
                    i4++;
                    if (((i >> (6 - i7)) & 1) == 0 || i8 == 1) {
                        z = !z;
                        i7++;
                    } else {
                        i8++;
                    }
                }
                break;
            }
            if (i5 < str.length() - 1) {
                zArr[i4] = false;
                i4++;
            }
        }
        return zArr;
    }
}
