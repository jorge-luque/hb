package com.ogury.p159cm;

import java.util.List;

/* renamed from: com.ogury.cm.babac */
public final class babac extends baacc {

    /* renamed from: com.ogury.cm.babac$aaaaa */
    static final class aaaaa extends accbc implements accba<CharSequence, Integer, acbaa<? extends Integer, ? extends Integer>> {

        /* renamed from: a */
        final /* synthetic */ List f12182a;

        /* renamed from: b */
        final /* synthetic */ boolean f12183b = false;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        aaaaa(List list, boolean z) {
            super(2);
            this.f12182a = list;
        }

        /* JADX WARNING: Multi-variable type inference failed */
        /* JADX WARNING: Removed duplicated region for block: B:63:0x012a  */
        /* JADX WARNING: Removed duplicated region for block: B:65:0x0141 A[RETURN] */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final /* synthetic */ java.lang.Object mo29538a(java.lang.Object r18, java.lang.Object r19) {
            /*
                r17 = this;
                r0 = r17
                r7 = r18
                java.lang.CharSequence r7 = (java.lang.CharSequence) r7
                r1 = r19
                java.lang.Number r1 = (java.lang.Number) r1
                int r3 = r1.intValue()
                java.lang.String r1 = "receiver$0"
                com.ogury.p159cm.accbb.m15218b(r7, r1)
                java.util.List r8 = r0.f12182a
                boolean r15 = r0.f12183b
                r2 = 0
                r16 = 0
                if (r15 != 0) goto L_0x0087
                int r4 = r8.size()
                r5 = 1
                if (r4 != r5) goto L_0x0087
                com.ogury.p159cm.accbb.m15218b(r8, r1)
                boolean r4 = r8 instanceof java.util.List
                if (r4 == 0) goto L_0x004a
                com.ogury.p159cm.accbb.m15218b(r8, r1)
                int r1 = r8.size()
                if (r1 == 0) goto L_0x0042
                if (r1 != r5) goto L_0x003a
                java.lang.Object r1 = r8.get(r2)
                goto L_0x005f
            L_0x003a:
                java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
                java.lang.String r2 = "List has more than one element."
                r1.<init>(r2)
                throw r1
            L_0x0042:
                java.util.NoSuchElementException r1 = new java.util.NoSuchElementException
                java.lang.String r2 = "List is empty."
                r1.<init>(r2)
                throw r1
            L_0x004a:
                java.util.Iterator r1 = r8.iterator()
                boolean r2 = r1.hasNext()
                if (r2 == 0) goto L_0x007f
                java.lang.Object r2 = r1.next()
                boolean r1 = r1.hasNext()
                if (r1 != 0) goto L_0x0077
                r1 = r2
            L_0x005f:
                r8 = r1
                java.lang.String r8 = (java.lang.String) r8
                r4 = 0
                r5 = 4
                r6 = 0
                r1 = r7
                r2 = r8
                int r1 = com.ogury.p159cm.babac.m15262a((java.lang.CharSequence) r1, (java.lang.String) r2, (int) r3, (boolean) r4, (int) r5, (java.lang.Object) r6)
                if (r1 < 0) goto L_0x0126
                java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
                com.ogury.cm.acbaa r1 = com.ogury.p159cm.ConsentActivity.aaaaa.m14879a(r1, r8)
                goto L_0x0128
            L_0x0077:
                java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
                java.lang.String r2 = "Collection has more than one element."
                r1.<init>(r2)
                throw r1
            L_0x007f:
                java.util.NoSuchElementException r1 = new java.util.NoSuchElementException
                java.lang.String r2 = "Collection is empty."
                r1.<init>(r2)
                throw r1
            L_0x0087:
                if (r3 >= 0) goto L_0x008a
                r3 = 0
            L_0x008a:
                com.ogury.cm.baabb r1 = new com.ogury.cm.baabb
                int r2 = r7.length()
                r1.<init>(r3, r2)
                boolean r2 = r7 instanceof java.lang.String
                if (r2 == 0) goto L_0x00df
                int r2 = r1.mo29552a()
                int r3 = r1.mo29553b()
                int r1 = r1.mo29554c()
                if (r1 <= 0) goto L_0x00a8
                if (r2 > r3) goto L_0x0126
                goto L_0x00aa
            L_0x00a8:
                if (r2 < r3) goto L_0x0126
            L_0x00aa:
                java.util.Iterator r4 = r8.iterator()
            L_0x00ae:
                boolean r5 = r4.hasNext()
                if (r5 == 0) goto L_0x00cc
                java.lang.Object r5 = r4.next()
                r9 = r5
                java.lang.String r9 = (java.lang.String) r9
                r10 = 0
                r11 = r7
                java.lang.String r11 = (java.lang.String) r11
                int r13 = r9.length()
                r12 = r2
                r14 = r15
                boolean r6 = com.ogury.p159cm.baacc.m15251a((java.lang.String) r9, (int) r10, (java.lang.String) r11, (int) r12, (int) r13, (boolean) r14)
                if (r6 == 0) goto L_0x00ae
                goto L_0x00ce
            L_0x00cc:
                r5 = r16
            L_0x00ce:
                java.lang.String r5 = (java.lang.String) r5
                if (r5 == 0) goto L_0x00db
                java.lang.Integer r1 = java.lang.Integer.valueOf(r2)
                com.ogury.cm.acbaa r1 = com.ogury.p159cm.ConsentActivity.aaaaa.m14879a(r1, r5)
                goto L_0x0128
            L_0x00db:
                if (r2 == r3) goto L_0x0126
                int r2 = r2 + r1
                goto L_0x00aa
            L_0x00df:
                int r2 = r1.mo29552a()
                int r9 = r1.mo29553b()
                int r10 = r1.mo29554c()
                if (r10 <= 0) goto L_0x00f0
                if (r2 > r9) goto L_0x0126
                goto L_0x00f2
            L_0x00f0:
                if (r2 < r9) goto L_0x0126
            L_0x00f2:
                r11 = r2
            L_0x00f3:
                java.util.Iterator r12 = r8.iterator()
            L_0x00f7:
                boolean r1 = r12.hasNext()
                if (r1 == 0) goto L_0x0113
                java.lang.Object r13 = r12.next()
                r1 = r13
                java.lang.String r1 = (java.lang.String) r1
                r2 = 0
                int r5 = r1.length()
                r3 = r7
                r4 = r11
                r6 = r15
                boolean r1 = com.ogury.p159cm.babac.m15264a((java.lang.CharSequence) r1, (int) r2, (java.lang.CharSequence) r3, (int) r4, (int) r5, (boolean) r6)
                if (r1 == 0) goto L_0x00f7
                goto L_0x0115
            L_0x0113:
                r13 = r16
            L_0x0115:
                java.lang.String r13 = (java.lang.String) r13
                if (r13 == 0) goto L_0x0122
                java.lang.Integer r1 = java.lang.Integer.valueOf(r11)
                com.ogury.cm.acbaa r1 = com.ogury.p159cm.ConsentActivity.aaaaa.m14879a(r1, r13)
                goto L_0x0128
            L_0x0122:
                if (r11 == r9) goto L_0x0126
                int r11 = r11 + r10
                goto L_0x00f3
            L_0x0126:
                r1 = r16
            L_0x0128:
                if (r1 == 0) goto L_0x0141
                java.lang.Object r2 = r1.mo29524a()
                java.lang.Object r1 = r1.mo29525b()
                java.lang.String r1 = (java.lang.String) r1
                int r1 = r1.length()
                java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
                com.ogury.cm.acbaa r1 = com.ogury.p159cm.ConsentActivity.aaaaa.m14879a(r2, r1)
                return r1
            L_0x0141:
                return r16
            */
            throw new UnsupportedOperationException("Method not decompiled: com.ogury.p159cm.babac.aaaaa.mo29538a(java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    /* renamed from: com.ogury.cm.babac$aaaab */
    static final class aaaab extends accbc implements accac<baabb, String> {

        /* renamed from: a */
        final /* synthetic */ CharSequence f12184a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        aaaab(CharSequence charSequence) {
            super(1);
            this.f12184a = charSequence;
        }

        /* renamed from: a */
        public final /* synthetic */ Object mo29401a(Object obj) {
            baabb baabb = (baabb) obj;
            accbb.m15218b(baabb, "it");
            CharSequence charSequence = this.f12184a;
            accbb.m15218b(charSequence, "receiver$0");
            accbb.m15218b(baabb, "range");
            return charSequence.subSequence(baabb.mo29552a(), baabb.mo29553b() + 1).toString();
        }
    }

    /* renamed from: a */
    public static /* synthetic */ int m15259a(CharSequence charSequence, char c, int i, boolean z, int i2, Object obj) {
        boolean z2;
        if ((i2 & 2) != 0) {
            i = 0;
        }
        accbb.m15218b(charSequence, "receiver$0");
        boolean z3 = charSequence instanceof String;
        if (z3) {
            return ((String) charSequence).indexOf(46, i);
        }
        char[] cArr = {'.'};
        accbb.m15218b(charSequence, "receiver$0");
        accbb.m15218b(cArr, "chars");
        if (z3) {
            accbb.m15218b(cArr, "receiver$0");
            return ((String) charSequence).indexOf(cArr[0], i);
        }
        if (i < 0) {
            i = 0;
        }
        int b = m15266b(charSequence);
        if (i > b) {
            return -1;
        }
        while (true) {
            char charAt = charSequence.charAt(i);
            int i3 = 0;
            while (true) {
                if (i3 > 0) {
                    z2 = false;
                    break;
                } else if (baacc.m15248a(cArr[i3], charAt, false)) {
                    z2 = true;
                    break;
                } else {
                    i3++;
                }
            }
            if (z2) {
                return i;
            }
            if (i == b) {
                return -1;
            }
            i++;
        }
    }

    /* renamed from: a */
    private static /* synthetic */ int m15260a(CharSequence charSequence, CharSequence charSequence2, int i, int i2, boolean z, boolean z2, int i3, Object obj) {
        if (i < 0) {
            i = 0;
        }
        int length = charSequence.length();
        if (i2 > length) {
            i2 = length;
        }
        baabb baabb = new baabb(i, i2);
        if (!(charSequence instanceof String) || !(charSequence2 instanceof String)) {
            int a = baabb.mo29552a();
            int b = baabb.mo29553b();
            int c = baabb.mo29554c();
            if (c > 0) {
                if (a > b) {
                    return -1;
                }
            } else if (a < b) {
                return -1;
            }
            while (true) {
                if (m15264a(charSequence2, 0, charSequence, a, charSequence2.length(), false)) {
                    return a;
                }
                if (a == b) {
                    return -1;
                }
                a += c;
            }
        } else {
            int a2 = baabb.mo29552a();
            int b2 = baabb.mo29553b();
            int c2 = baabb.mo29554c();
            if (c2 > 0) {
                if (a2 > b2) {
                    return -1;
                }
            } else if (a2 < b2) {
                return -1;
            }
            while (true) {
                if (baacc.m15251a((String) charSequence2, 0, (String) charSequence, a2, charSequence2.length(), false)) {
                    return a2;
                }
                if (a2 == b2) {
                    return -1;
                }
                a2 += c2;
            }
        }
    }

    /* renamed from: a */
    private static int m15261a(CharSequence charSequence, String str, int i, boolean z) {
        accbb.m15218b(charSequence, "receiver$0");
        accbb.m15218b(str, "string");
        if (charSequence instanceof String) {
            return ((String) charSequence).indexOf(str, i);
        }
        return m15260a(charSequence, str, i, charSequence.length(), false, false, 16, (Object) null);
    }

    /* renamed from: a */
    public static /* synthetic */ int m15262a(CharSequence charSequence, String str, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        return m15261a(charSequence, str, i, false);
    }

    /* renamed from: a */
    public static /* synthetic */ String m15263a(String str, String str2, String str3, int i, Object obj) {
        accbb.m15218b(str, "receiver$0");
        accbb.m15218b(str2, "delimiter");
        accbb.m15218b(str, "missingDelimiterValue");
        int a = m15262a((CharSequence) str, str2, 0, false, 6, (Object) null);
        if (a == -1) {
            return str;
        }
        String substring = str.substring(a + str2.length(), str.length());
        accbb.m15215a((Object) substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return substring;
    }

    /* renamed from: a */
    public static final boolean m15264a(CharSequence charSequence, int i, CharSequence charSequence2, int i2, int i3, boolean z) {
        accbb.m15218b(charSequence, "receiver$0");
        accbb.m15218b(charSequence2, "other");
        if (i2 < 0 || charSequence.length() - i3 < 0 || i2 > charSequence2.length() - i3) {
            return false;
        }
        for (int i4 = 0; i4 < i3; i4++) {
            if (!baacc.m15248a(charSequence.charAt(i4 + 0), charSequence2.charAt(i2 + i4), z)) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: a */
    public static /* synthetic */ boolean m15265a(CharSequence charSequence, CharSequence charSequence2, boolean z, int i, Object obj) {
        accbb.m15218b(charSequence, "receiver$0");
        accbb.m15218b(charSequence2, "other");
        if (charSequence2 instanceof String) {
            return m15262a(charSequence, (String) charSequence2, 0, false, 2, (Object) null) >= 0;
        }
        return m15260a(charSequence, charSequence2, 0, charSequence.length(), false, false, 16, (Object) null) >= 0;
    }

    /* renamed from: b */
    public static final int m15266b(CharSequence charSequence) {
        accbb.m15218b(charSequence, "receiver$0");
        return charSequence.length() - 1;
    }

    /* renamed from: c */
    public static CharSequence m15267c(CharSequence charSequence) {
        accbb.m15218b(charSequence, "receiver$0");
        StringBuilder reverse = new StringBuilder(charSequence).reverse();
        accbb.m15215a((Object) reverse, "StringBuilder(this).reverse()");
        return reverse;
    }
}
