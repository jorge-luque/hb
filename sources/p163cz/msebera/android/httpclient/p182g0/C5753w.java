package p163cz.msebera.android.httpclient.p182g0;

import java.util.BitSet;
import p163cz.msebera.android.httpclient.p187k0.C5889d;

/* renamed from: cz.msebera.android.httpclient.g0.w */
/* compiled from: TokenParser */
public class C5753w {

    /* renamed from: a */
    public static final C5753w f14852a = new C5753w();

    /* renamed from: a */
    public static BitSet m18313a(int... iArr) {
        BitSet bitSet = new BitSet();
        for (int i : iArr) {
            bitSet.set(i);
        }
        return bitSet;
    }

    /* renamed from: a */
    public static boolean m18314a(char c) {
        return c == ' ' || c == 9 || c == 13 || c == 10;
    }

    /* renamed from: b */
    public String mo33413b(C5889d dVar, C5752v vVar, BitSet bitSet) {
        StringBuilder sb = new StringBuilder();
        loop0:
        while (true) {
            boolean z = false;
            while (!vVar.mo33405a()) {
                char charAt = dVar.charAt(vVar.mo33406b());
                if (bitSet != null && bitSet.get(charAt)) {
                    break loop0;
                } else if (m18314a(charAt)) {
                    mo33410a(dVar, vVar);
                    z = true;
                } else if (charAt == '\"') {
                    if (z && sb.length() > 0) {
                        sb.append(' ');
                    }
                    mo33411a(dVar, vVar, sb);
                } else {
                    if (z && sb.length() > 0) {
                        sb.append(' ');
                    }
                    mo33414b(dVar, vVar, bitSet, sb);
                }
            }
            break loop0;
        }
        return sb.toString();
    }

    /* renamed from: a */
    public String mo33409a(C5889d dVar, C5752v vVar, BitSet bitSet) {
        StringBuilder sb = new StringBuilder();
        loop0:
        while (true) {
            boolean z = false;
            while (!vVar.mo33405a()) {
                char charAt = dVar.charAt(vVar.mo33406b());
                if (bitSet != null && bitSet.get(charAt)) {
                    break loop0;
                } else if (m18314a(charAt)) {
                    mo33410a(dVar, vVar);
                    z = true;
                } else {
                    if (z && sb.length() > 0) {
                        sb.append(' ');
                    }
                    mo33412a(dVar, vVar, bitSet, sb);
                }
            }
            break loop0;
        }
        return sb.toString();
    }

    /* renamed from: a */
    public void mo33410a(C5889d dVar, C5752v vVar) {
        int b = vVar.mo33406b();
        int b2 = vVar.mo33406b();
        int c = vVar.mo33407c();
        while (b2 < c && m18314a(dVar.charAt(b2))) {
            b++;
            b2++;
        }
        vVar.mo33404a(b);
    }

    /* renamed from: b */
    public void mo33414b(C5889d dVar, C5752v vVar, BitSet bitSet, StringBuilder sb) {
        int b = vVar.mo33406b();
        int c = vVar.mo33407c();
        for (int b2 = vVar.mo33406b(); b2 < c; b2++) {
            char charAt = dVar.charAt(b2);
            if ((bitSet != null && bitSet.get(charAt)) || m18314a(charAt) || charAt == '\"') {
                break;
            }
            b++;
            sb.append(charAt);
        }
        vVar.mo33404a(b);
    }

    /* renamed from: a */
    public void mo33412a(C5889d dVar, C5752v vVar, BitSet bitSet, StringBuilder sb) {
        int b = vVar.mo33406b();
        int c = vVar.mo33407c();
        for (int b2 = vVar.mo33406b(); b2 < c; b2++) {
            char charAt = dVar.charAt(b2);
            if ((bitSet != null && bitSet.get(charAt)) || m18314a(charAt)) {
                break;
            }
            b++;
            sb.append(charAt);
        }
        vVar.mo33404a(b);
    }

    /* renamed from: a */
    public void mo33411a(C5889d dVar, C5752v vVar, StringBuilder sb) {
        if (!vVar.mo33405a()) {
            int b = vVar.mo33406b();
            int b2 = vVar.mo33406b();
            int c = vVar.mo33407c();
            if (dVar.charAt(b) == '\"') {
                int i = b + 1;
                int i2 = b2 + 1;
                boolean z = false;
                while (true) {
                    if (i2 >= c) {
                        break;
                    }
                    char charAt = dVar.charAt(i2);
                    if (z) {
                        if (!(charAt == '\"' || charAt == '\\')) {
                            sb.append('\\');
                        }
                        sb.append(charAt);
                        z = false;
                    } else if (charAt == '\"') {
                        i++;
                        break;
                    } else if (charAt == '\\') {
                        z = true;
                    } else if (!(charAt == 13 || charAt == 10)) {
                        sb.append(charAt);
                    }
                    i2++;
                    i++;
                }
                vVar.mo33404a(i);
            }
        }
    }
}
