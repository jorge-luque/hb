package com.google.zxing.p137i;

import com.google.zxing.C4061a;
import com.google.zxing.C4063c;
import com.google.zxing.WriterException;
import com.google.zxing.p134g.C4080b;
import java.util.ArrayList;
import java.util.Map;

/* renamed from: com.google.zxing.i.d */
/* compiled from: Code128Writer */
public final class C4100d extends C4111n {

    /* renamed from: com.google.zxing.i.d$a */
    /* compiled from: Code128Writer */
    private enum C4101a {
        UNCODABLE,
        ONE_DIGIT,
        TWO_DIGITS,
        FNC_1;

        static {
            UNCODABLE = new C4101a("UNCODABLE", 0);
            ONE_DIGIT = new C4101a("ONE_DIGIT", 1);
            TWO_DIGITS = new C4101a("TWO_DIGITS", 2);
            FNC_1 = new C4101a("FNC_1", 3);
        }
    }

    /* renamed from: a */
    public C4080b mo28289a(String str, C4061a aVar, int i, int i2, Map<C4063c, ?> map) throws WriterException {
        if (aVar == C4061a.CODE_128) {
            return super.mo28289a(str, aVar, i, i2, map);
        }
        throw new IllegalArgumentException("Can only encode CODE_128, but got ".concat(String.valueOf(aVar)));
    }

    /* renamed from: a */
    public boolean[] mo28376a(String str) {
        int length = str.length();
        if (length <= 0 || length > 80) {
            throw new IllegalArgumentException("Contents length should be between 1 and 80 characters, but got ".concat(String.valueOf(length)));
        }
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            char charAt = str.charAt(i2);
            switch (charAt) {
                case 241:
                case 242:
                case 243:
                case 244:
                    break;
                default:
                    if (charAt <= 127) {
                        break;
                    } else {
                        throw new IllegalArgumentException("Bad character in input: ".concat(String.valueOf(charAt)));
                    }
            }
        }
        ArrayList<int[]> arrayList = new ArrayList<>();
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = 1;
        while (true) {
            int i7 = 103;
            if (i3 < length) {
                int a = m13710a(str, i3, i5);
                int i8 = 100;
                if (a == i5) {
                    switch (str.charAt(i3)) {
                        case 241:
                            i8 = 102;
                            break;
                        case 242:
                            i8 = 97;
                            break;
                        case 243:
                            i8 = 96;
                            break;
                        case 244:
                            if (i5 == 101) {
                                i8 = 101;
                                break;
                            }
                            break;
                        default:
                            if (i5 != 100) {
                                if (i5 == 101) {
                                    i8 = str.charAt(i3) - ' ';
                                    if (i8 < 0) {
                                        i8 += 96;
                                        break;
                                    }
                                } else {
                                    i8 = Integer.parseInt(str.substring(i3, i3 + 2));
                                    i3++;
                                    break;
                                }
                            } else {
                                i8 = str.charAt(i3) - ' ';
                                break;
                            }
                            break;
                    }
                    i3++;
                } else {
                    if (i5 != 0) {
                        i7 = a;
                    } else if (a == 100) {
                        i7 = 104;
                    } else if (a != 101) {
                        i7 = 105;
                    }
                    i8 = i7;
                    i5 = a;
                }
                arrayList.add(C4099c.f11009a[i8]);
                i4 += i8 * i6;
                if (i3 != 0) {
                    i6++;
                }
            } else {
                arrayList.add(C4099c.f11009a[i4 % 103]);
                arrayList.add(C4099c.f11009a[106]);
                int i9 = 0;
                for (int[] iArr : arrayList) {
                    for (int i10 : (int[]) r13.next()) {
                        i9 += i10;
                    }
                }
                boolean[] zArr = new boolean[i9];
                for (int[] a2 : arrayList) {
                    i += C4111n.m13729a(zArr, i, a2, true);
                }
                return zArr;
            }
        }
    }

    /* renamed from: a */
    private static C4101a m13711a(CharSequence charSequence, int i) {
        int length = charSequence.length();
        if (i >= length) {
            return C4101a.UNCODABLE;
        }
        char charAt = charSequence.charAt(i);
        if (charAt == 241) {
            return C4101a.FNC_1;
        }
        if (charAt < '0' || charAt > '9') {
            return C4101a.UNCODABLE;
        }
        int i2 = i + 1;
        if (i2 >= length) {
            return C4101a.ONE_DIGIT;
        }
        char charAt2 = charSequence.charAt(i2);
        if (charAt2 < '0' || charAt2 > '9') {
            return C4101a.ONE_DIGIT;
        }
        return C4101a.TWO_DIGITS;
    }

    /* renamed from: a */
    private static int m13710a(CharSequence charSequence, int i, int i2) {
        C4101a a;
        C4101a a2;
        char charAt;
        C4101a a3 = m13711a(charSequence, i);
        if (a3 == C4101a.ONE_DIGIT) {
            return 100;
        }
        if (a3 == C4101a.UNCODABLE) {
            if (i >= charSequence.length() || ((charAt = charSequence.charAt(i)) >= ' ' && (i2 != 101 || charAt >= '`'))) {
                return 100;
            }
            return 101;
        } else if (i2 == 99) {
            return 99;
        } else {
            if (i2 != 100) {
                if (a3 == C4101a.FNC_1) {
                    a3 = m13711a(charSequence, i + 1);
                }
                if (a3 == C4101a.TWO_DIGITS) {
                    return 99;
                }
                return 100;
            } else if (a3 == C4101a.FNC_1 || (a = m13711a(charSequence, i + 2)) == C4101a.UNCODABLE || a == C4101a.ONE_DIGIT) {
                return 100;
            } else {
                if (a != C4101a.FNC_1) {
                    int i3 = i + 4;
                    while (true) {
                        a2 = m13711a(charSequence, i3);
                        if (a2 != C4101a.TWO_DIGITS) {
                            break;
                        }
                        i3 += 2;
                    }
                    if (a2 == C4101a.ONE_DIGIT) {
                        return 100;
                    }
                    return 99;
                } else if (m13711a(charSequence, i + 3) == C4101a.TWO_DIGITS) {
                    return 99;
                } else {
                    return 100;
                }
            }
        }
    }
}
