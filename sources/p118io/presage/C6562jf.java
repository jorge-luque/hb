package p118io.presage;

import java.util.ArrayList;
import java.util.List;

/* renamed from: io.presage.jf */
class C6562jf extends C6561je {

    /* renamed from: io.presage.jf$CamembertauCalvados */
    static final class CamembertauCalvados extends C6515hm implements C6493gr<CharSequence, Integer, C6431ej<? extends Integer, ? extends Integer>> {

        /* renamed from: a */
        final /* synthetic */ char[] f17114a;

        /* renamed from: b */
        final /* synthetic */ boolean f17115b = false;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        CamembertauCalvados(char[] cArr, boolean z) {
            super(2);
            this.f17114a = cArr;
        }

        /* renamed from: a */
        private C6431ej<Integer, Integer> m21536a(CharSequence charSequence, int i) {
            int a = C6562jf.m21519a(charSequence, this.f17114a, i, this.f17115b);
            if (a < 0) {
                return null;
            }
            return C6433el.m21305a(Integer.valueOf(a), 1);
        }

        /* renamed from: a */
        public final /* synthetic */ Object mo34520a(Object obj, Object obj2) {
            return m21536a((CharSequence) obj, ((Number) obj2).intValue());
        }
    }

    /* renamed from: a */
    public static final int m21513a(CharSequence charSequence) {
        return charSequence.length() - 1;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static final int m21528b(CharSequence charSequence, CharSequence charSequence2, int i, int i2, boolean z) {
        C6530ia iaVar = new C6530ia(C6533id.m21445a(i), C6533id.m21447b(i2, charSequence.length()));
        if (!(charSequence instanceof String) || !(charSequence2 instanceof String)) {
            int a = iaVar.mo35529a();
            int b = iaVar.mo35530b();
            int c = iaVar.mo35531c();
            if (c >= 0) {
                if (a > b) {
                    return -1;
                }
            } else if (a < b) {
                return -1;
            }
            while (!m21525a(charSequence2, charSequence, a, charSequence2.length(), z)) {
                if (a == b) {
                    return -1;
                }
                a += c;
            }
            return a;
        }
        int a2 = iaVar.mo35529a();
        int b2 = iaVar.mo35530b();
        int c2 = iaVar.mo35531c();
        if (c2 >= 0) {
            if (a2 > b2) {
                return -1;
            }
        } else if (a2 < b2) {
            return -1;
        }
        while (!C6561je.m21510a((String) charSequence2, (String) charSequence, a2, charSequence2.length(), z)) {
            if (a2 == b2) {
                return -1;
            }
            a2 += c2;
        }
        return a2;
    }

    /* renamed from: c */
    public static final String m21534c(String str, String str2) {
        int b = m21527b((CharSequence) str, m21513a((CharSequence) str));
        if (b == -1) {
            return str2;
        }
        String substring = str.substring(b + 1, str.length());
        C6514hl.m21414a((Object) substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return substring;
    }

    /* renamed from: a */
    public static final String m21521a(CharSequence charSequence, C6530ia iaVar) {
        return charSequence.subSequence(iaVar.mo35538e().intValue(), iaVar.mo35539f().intValue() + 1).toString();
    }

    /* renamed from: a */
    public static final CharSequence m21520a(CharSequence charSequence, int i, int i2, CharSequence charSequence2) {
        if (i2 >= i) {
            StringBuilder sb = new StringBuilder();
            sb.append(charSequence, 0, i);
            C6514hl.m21414a((Object) sb, "this.append(value, startIndex, endIndex)");
            sb.append(charSequence2);
            sb.append(charSequence, i2, charSequence.length());
            C6514hl.m21414a((Object) sb, "this.append(value, startIndex, endIndex)");
            return sb;
        }
        throw new IndexOutOfBoundsException("End index (" + i2 + ") is less than start index (" + i + ").");
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public static final C6538ii<C6530ia> m21533c(CharSequence charSequence, char[] cArr) {
        return new C6549it(charSequence, 0, new CamembertauCalvados(cArr, false));
    }

    /* renamed from: b */
    public static final int m21527b(CharSequence charSequence, int i) {
        if (charSequence instanceof String) {
            return ((String) charSequence).lastIndexOf(46, i);
        }
        return m21518a(charSequence, new char[]{'.'}, i);
    }

    /* renamed from: a */
    public static final boolean m21525a(CharSequence charSequence, CharSequence charSequence2, int i, int i2, boolean z) {
        if (i < 0 || charSequence.length() - i2 < 0 || i > charSequence2.length() - i2) {
            return false;
        }
        for (int i3 = 0; i3 < i2; i3++) {
            if (!C6547ir.m21465a(charSequence.charAt(i3 + 0), charSequence2.charAt(i + i3), z)) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: a */
    public static final int m21519a(CharSequence charSequence, char[] cArr, int i, boolean z) {
        if (z || cArr.length != 1 || !(charSequence instanceof String)) {
            int a = C6533id.m21445a(i);
            int a2 = m21513a(charSequence);
            if (a > a2) {
                return -1;
            }
            while (true) {
                char charAt = charSequence.charAt(a);
                int length = cArr.length;
                boolean z2 = false;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        break;
                    } else if (C6547ir.m21465a(cArr[i2], charAt, z)) {
                        z2 = true;
                        break;
                    } else {
                        i2++;
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
        } else {
            return ((String) charSequence).indexOf(C6443ev.m21308a(cArr), i);
        }
    }

    /* renamed from: b */
    private static final List<String> m21529b(CharSequence charSequence, String str) {
        int a = m21517a(charSequence, str, 0, false);
        if (a == -1) {
            return C6446ey.m21315a(charSequence.toString());
        }
        ArrayList arrayList = new ArrayList(10);
        int i = 0;
        do {
            arrayList.add(charSequence.subSequence(i, a).toString());
            i = str.length() + a;
            a = m21517a(charSequence, str, i, false);
        } while (a != -1);
        arrayList.add(charSequence.subSequence(i, charSequence.length()).toString());
        return arrayList;
    }

    /* renamed from: a */
    public static final int m21518a(CharSequence charSequence, char[] cArr, int i) {
        if (charSequence instanceof String) {
            return ((String) charSequence).lastIndexOf(C6443ev.m21308a(cArr), i);
        }
        for (int b = C6533id.m21447b(i, m21513a(charSequence)); b >= 0; b--) {
            char charAt = charSequence.charAt(b);
            boolean z = false;
            int i2 = 0;
            while (true) {
                if (i2 > 0) {
                    break;
                } else if (C6547ir.m21465a(cArr[i2], charAt, false)) {
                    z = true;
                    break;
                } else {
                    i2++;
                }
            }
            if (z) {
                return b;
            }
        }
        return -1;
    }

    /* renamed from: a */
    public static /* synthetic */ int m21515a(CharSequence charSequence, int i, int i2) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        return m21514a(charSequence, i);
    }

    /* renamed from: a */
    public static final int m21514a(CharSequence charSequence, int i) {
        if (charSequence instanceof String) {
            return ((String) charSequence).indexOf(46, i);
        }
        return m21519a(charSequence, new char[]{'.'}, i, false);
    }

    /* renamed from: a */
    public static final int m21517a(CharSequence charSequence, String str, int i, boolean z) {
        if (z || !(charSequence instanceof String)) {
            return m21528b(charSequence, str, i, charSequence.length(), z);
        }
        return ((String) charSequence).indexOf(str, i);
    }

    /* renamed from: a */
    public static final boolean m21524a(CharSequence charSequence, CharSequence charSequence2) {
        return charSequence2 instanceof String ? m21517a(charSequence, (String) charSequence2, 0, false) >= 0 : m21528b(charSequence, charSequence2, 0, charSequence.length(), false) >= 0;
    }

    /* renamed from: a */
    public static final List<String> m21523a(CharSequence charSequence, char[] cArr) {
        if (cArr.length == 1) {
            return m21529b(charSequence, String.valueOf(cArr[0]));
        }
        Iterable<C6530ia> a = C6544io.m21464a(m21533c(charSequence, cArr));
        ArrayList arrayList = new ArrayList(C6449fa.m21332a(a));
        for (C6530ia a2 : a) {
            arrayList.add(m21521a(charSequence, a2));
        }
        return arrayList;
    }
}
