package com.google.zxing.p135h.p136b;

/* renamed from: com.google.zxing.h.b.n */
/* compiled from: X12Encoder */
final class C4096n extends C4085c {
    C4096n() {
    }

    /* renamed from: a */
    public int mo28342a() {
        return 3;
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
            mo28343a(c, sb);
            if (sb.length() % 3 == 0) {
                C4085c.m13630b(hVar, sb);
                if (C4092j.m13677a(hVar.mo28360d(), hVar.f10983f, mo28342a()) != mo28342a()) {
                    hVar.mo28357b(0);
                    break;
                }
            }
        }
        mo28344a(hVar, sb);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public int mo28343a(char c, StringBuilder sb) {
        if (c == 13) {
            sb.append(0);
        } else if (c == ' ') {
            sb.append(3);
        } else if (c == '*') {
            sb.append(1);
        } else if (c == '>') {
            sb.append(2);
        } else if (c >= '0' && c <= '9') {
            sb.append((char) ((c - '0') + 4));
        } else if (c < 'A' || c > 'Z') {
            C4092j.m13681a(c);
            throw null;
        } else {
            sb.append((char) ((c - 'A') + 14));
        }
        return 1;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo28344a(C4090h hVar, StringBuilder sb) {
        hVar.mo28367k();
        int a = hVar.mo28363g().mo28368a() - hVar.mo28350a();
        hVar.f10983f -= sb.length();
        if (hVar.mo28362f() > 1 || a > 1 || hVar.mo28362f() != a) {
            hVar.mo28351a(254);
        }
        if (hVar.mo28361e() < 0) {
            hVar.mo28357b(0);
        }
    }
}
