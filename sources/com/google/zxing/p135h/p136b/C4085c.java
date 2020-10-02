package com.google.zxing.p135h.p136b;

/* renamed from: com.google.zxing.h.b.c */
/* compiled from: C40Encoder */
class C4085c implements C4089g {
    C4085c() {
    }

    /* renamed from: b */
    static void m13630b(C4090h hVar, StringBuilder sb) {
        hVar.mo28355a(m13629a((CharSequence) sb, 0));
        sb.delete(0, 3);
    }

    /* renamed from: a */
    public int mo28342a() {
        return 1;
    }

    /* renamed from: a */
    public void mo28340a(C4090h hVar) {
        StringBuilder sb = new StringBuilder();
        while (true) {
            if (!hVar.mo28364h()) {
                break;
            }
            char c = hVar.mo28358c();
            hVar.f10983f++;
            int a = mo28343a(c, sb);
            int a2 = hVar.mo28350a() + ((sb.length() / 3) << 1);
            hVar.mo28359c(a2);
            int a3 = hVar.mo28363g().mo28368a() - a2;
            if (hVar.mo28364h()) {
                if (sb.length() % 3 == 0 && C4092j.m13677a(hVar.mo28360d(), hVar.f10983f, mo28342a()) != mo28342a()) {
                    hVar.mo28357b(0);
                    break;
                }
            } else {
                StringBuilder sb2 = new StringBuilder();
                if (sb.length() % 3 == 2 && (a3 < 2 || a3 > 2)) {
                    a = m13628a(hVar, sb, sb2, a);
                }
                while (sb.length() % 3 == 1 && ((a <= 3 && a3 != 1) || a > 3)) {
                    a = m13628a(hVar, sb, sb2, a);
                }
            }
        }
        mo28344a(hVar, sb);
    }

    /* renamed from: a */
    private int m13628a(C4090h hVar, StringBuilder sb, StringBuilder sb2, int i) {
        int length = sb.length();
        sb.delete(length - i, length);
        hVar.f10983f--;
        int a = mo28343a(hVar.mo28358c(), sb2);
        hVar.mo28366j();
        return a;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo28344a(C4090h hVar, StringBuilder sb) {
        int length = sb.length() % 3;
        int a = hVar.mo28350a() + ((sb.length() / 3) << 1);
        hVar.mo28359c(a);
        int a2 = hVar.mo28363g().mo28368a() - a;
        if (length == 2) {
            sb.append(0);
            while (sb.length() >= 3) {
                m13630b(hVar, sb);
            }
            if (hVar.mo28364h()) {
                hVar.mo28351a(254);
            }
        } else if (a2 == 1 && length == 1) {
            while (sb.length() >= 3) {
                m13630b(hVar, sb);
            }
            if (hVar.mo28364h()) {
                hVar.mo28351a(254);
            }
            hVar.f10983f--;
        } else if (length == 0) {
            while (sb.length() >= 3) {
                m13630b(hVar, sb);
            }
            if (a2 > 0 || hVar.mo28364h()) {
                hVar.mo28351a(254);
            }
        } else {
            throw new IllegalStateException("Unexpected case. Please report!");
        }
        hVar.mo28357b(0);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public int mo28343a(char c, StringBuilder sb) {
        if (c == ' ') {
            sb.append(3);
            return 1;
        } else if (c >= '0' && c <= '9') {
            sb.append((char) ((c - '0') + 4));
            return 1;
        } else if (c >= 'A' && c <= 'Z') {
            sb.append((char) ((c - 'A') + 14));
            return 1;
        } else if (c < ' ') {
            sb.append(0);
            sb.append(c);
            return 2;
        } else if (c >= '!' && c <= '/') {
            sb.append(1);
            sb.append((char) (c - '!'));
            return 2;
        } else if (c >= ':' && c <= '@') {
            sb.append(1);
            sb.append((char) ((c - ':') + 15));
            return 2;
        } else if (c >= '[' && c <= '_') {
            sb.append(1);
            sb.append((char) ((c - '[') + 22));
            return 2;
        } else if (c < '`' || c > 127) {
            sb.append("\u0001\u001e");
            return mo28343a((char) (c - 128), sb) + 2;
        } else {
            sb.append(2);
            sb.append((char) (c - '`'));
            return 2;
        }
    }

    /* renamed from: a */
    private static String m13629a(CharSequence charSequence, int i) {
        int charAt = (charSequence.charAt(i) * 1600) + (charSequence.charAt(i + 1) * '(') + charSequence.charAt(i + 2) + 1;
        return new String(new char[]{(char) (charAt / 256), (char) (charAt % 256)});
    }
}
