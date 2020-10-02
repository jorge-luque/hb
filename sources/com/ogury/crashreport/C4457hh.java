package com.ogury.crashreport;

/* renamed from: com.ogury.crashreport.hh */
/* compiled from: Strings.kt */
class C4457hh extends C4456gg {
    /* renamed from: a */
    public static final int m15298a(CharSequence charSequence) {
        tx7920.m15333b(charSequence, "receiver$0");
        return charSequence.length() - 1;
    }

    /* renamed from: a */
    public static /* synthetic */ int m15299a(CharSequence charSequence, char c, int i, boolean z, int i2) {
        boolean z2;
        if ((i2 & 2) != 0) {
            i = 0;
        }
        tx7920.m15333b(charSequence, "receiver$0");
        if (charSequence instanceof String) {
            return ((String) charSequence).indexOf(46, i);
        }
        char[] cArr = {'.'};
        tx7920.m15333b(charSequence, "receiver$0");
        tx7920.m15333b(cArr, "chars");
        if (charSequence instanceof String) {
            tx7920.m15333b(cArr, "receiver$0");
            return ((String) charSequence).indexOf(cArr[0], i);
        }
        int a = C4449aa.m15276a(i, 0);
        int a2 = m15298a(charSequence);
        if (a > a2) {
            return -1;
        }
        while (true) {
            char charAt = charSequence.charAt(a);
            int i3 = 0;
            while (true) {
                if (i3 > 0) {
                    z2 = false;
                    break;
                } else if (C4451cc.m15281a(cArr[i3], charAt, false)) {
                    z2 = true;
                    break;
                } else {
                    i3++;
                }
            }
            if (z2) {
                return a;
            }
            if (a == a2) {
                return -1;
            }
            a++;
        }
    }

    /* renamed from: a */
    public static /* synthetic */ boolean m15301a(CharSequence charSequence, CharSequence charSequence2, boolean z, int i) {
        int i2;
        tx7920.m15333b(charSequence, "receiver$0");
        tx7920.m15333b(charSequence2, "other");
        if (charSequence2 instanceof String) {
            String str = (String) charSequence2;
            tx7920.m15333b(charSequence, "receiver$0");
            tx7920.m15333b(str, "string");
            if (!(charSequence instanceof String)) {
                i2 = m15300a(charSequence, str, 0, charSequence.length(), false, false, 16);
            } else {
                i2 = ((String) charSequence).indexOf(str, 0);
            }
            return i2 >= 0;
        }
        return m15300a(charSequence, charSequence2, 0, charSequence.length(), false, false, 16) >= 0;
    }

    /* renamed from: a */
    private static /* synthetic */ int m15300a(CharSequence charSequence, CharSequence charSequence2, int i, int i2, boolean z, boolean z2, int i3) {
        boolean z3;
        boolean z4;
        cf0 cf0 = new cf0(C4449aa.m15276a(i, 0), C4449aa.m15277b(i2, charSequence.length()));
        if (!(charSequence instanceof String) || !(charSequence2 instanceof String)) {
            int a = cf0.mo29605a();
            int b = cf0.mo29606b();
            int c = cf0.mo29607c();
            if (c > 0) {
                if (a > b) {
                    return -1;
                }
            } else if (a < b) {
                return -1;
            }
            while (true) {
                int length = charSequence2.length();
                tx7920.m15333b(charSequence2, "receiver$0");
                tx7920.m15333b(charSequence, "other");
                if (a >= 0 && charSequence2.length() - length >= 0 && a <= charSequence.length() - length) {
                    int i4 = 0;
                    while (true) {
                        if (i4 >= length) {
                            z3 = true;
                            break;
                        } else if (!C4451cc.m15281a(charSequence2.charAt(i4 + 0), charSequence.charAt(a + i4), z)) {
                            break;
                        } else {
                            i4++;
                        }
                    }
                }
                z3 = false;
                if (z3) {
                    return a;
                }
                if (a == b) {
                    return -1;
                }
                a += c;
            }
        } else {
            int a2 = cf0.mo29605a();
            int b2 = cf0.mo29606b();
            int c2 = cf0.mo29607c();
            if (c2 > 0) {
                if (a2 > b2) {
                    return -1;
                }
            } else if (a2 < b2) {
                return -1;
            }
            while (true) {
                String str = (String) charSequence2;
                String str2 = (String) charSequence;
                int length2 = charSequence2.length();
                tx7920.m15333b(str, "receiver$0");
                tx7920.m15333b(str2, "other");
                if (!z) {
                    z4 = str.regionMatches(0, str2, a2, length2);
                } else {
                    z4 = str.regionMatches(z, 0, str2, a2, length2);
                }
                if (z4) {
                    return a2;
                }
                if (a2 == b2) {
                    return -1;
                }
                a2 += c2;
            }
        }
    }
}
