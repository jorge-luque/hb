package com.google.zxing.p135h.p136b;

/* renamed from: com.google.zxing.h.b.f */
/* compiled from: EdifactEncoder */
final class C4088f implements C4089g {
    C4088f() {
    }

    /* renamed from: a */
    public int mo28349a() {
        return 4;
    }

    /* renamed from: a */
    public void mo28340a(C4090h hVar) {
        StringBuilder sb = new StringBuilder();
        while (true) {
            if (!hVar.mo28364h()) {
                break;
            }
            m13648a(hVar.mo28358c(), sb);
            hVar.f10983f++;
            if (sb.length() >= 4) {
                hVar.mo28355a(m13647a((CharSequence) sb, 0));
                sb.delete(0, 4);
                if (C4092j.m13677a(hVar.mo28360d(), hVar.f10983f, mo28349a()) != mo28349a()) {
                    hVar.mo28357b(0);
                    break;
                }
            }
        }
        sb.append(31);
        m13649a(hVar, (CharSequence) sb);
    }

    /* renamed from: a */
    private static void m13649a(C4090h hVar, CharSequence charSequence) {
        try {
            int length = charSequence.length();
            if (length != 0) {
                boolean z = true;
                if (length == 1) {
                    hVar.mo28367k();
                    int a = hVar.mo28363g().mo28368a() - hVar.mo28350a();
                    int f = hVar.mo28362f();
                    if (f > a) {
                        hVar.mo28359c(hVar.mo28350a() + 1);
                        a = hVar.mo28363g().mo28368a() - hVar.mo28350a();
                    }
                    if (f <= a && a <= 2) {
                        hVar.mo28357b(0);
                        return;
                    }
                }
                if (length <= 4) {
                    int i = length - 1;
                    String a2 = m13647a(charSequence, 0);
                    if (!(!hVar.mo28364h()) || i > 2) {
                        z = false;
                    }
                    if (i <= 2) {
                        hVar.mo28359c(hVar.mo28350a() + i);
                        if (hVar.mo28363g().mo28368a() - hVar.mo28350a() >= 3) {
                            hVar.mo28359c(hVar.mo28350a() + a2.length());
                            z = false;
                        }
                    }
                    if (z) {
                        hVar.mo28366j();
                        hVar.f10983f -= i;
                    } else {
                        hVar.mo28355a(a2);
                    }
                    hVar.mo28357b(0);
                    return;
                }
                throw new IllegalStateException("Count must not exceed 4");
            }
        } finally {
            hVar.mo28357b(0);
        }
    }

    /* renamed from: a */
    private static void m13648a(char c, StringBuilder sb) {
        if (c >= ' ' && c <= '?') {
            sb.append(c);
        } else if (c < '@' || c > '^') {
            C4092j.m13681a(c);
            throw null;
        } else {
            sb.append((char) (c - '@'));
        }
    }

    /* renamed from: a */
    private static String m13647a(CharSequence charSequence, int i) {
        int length = charSequence.length() - i;
        if (length != 0) {
            char charAt = charSequence.charAt(i);
            char c = 0;
            char charAt2 = length >= 2 ? charSequence.charAt(i + 1) : 0;
            char charAt3 = length >= 3 ? charSequence.charAt(i + 2) : 0;
            if (length >= 4) {
                c = charSequence.charAt(i + 3);
            }
            int i2 = (charAt << 18) + (charAt2 << 12) + (charAt3 << 6) + c;
            char c2 = (char) ((i2 >> 8) & 255);
            char c3 = (char) (i2 & 255);
            StringBuilder sb = new StringBuilder(3);
            sb.append((char) ((i2 >> 16) & 255));
            if (length >= 2) {
                sb.append(c2);
            }
            if (length >= 3) {
                sb.append(c3);
            }
            return sb.toString();
        }
        throw new IllegalStateException("StringBuilder must not be empty");
    }
}
