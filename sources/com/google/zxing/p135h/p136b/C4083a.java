package com.google.zxing.p135h.p136b;

/* renamed from: com.google.zxing.h.b.a */
/* compiled from: ASCIIEncoder */
final class C4083a implements C4089g {
    C4083a() {
    }

    /* renamed from: a */
    public int mo28339a() {
        return 0;
    }

    /* renamed from: a */
    public void mo28340a(C4090h hVar) {
        if (C4092j.m13676a((CharSequence) hVar.mo28360d(), hVar.f10983f) >= 2) {
            hVar.mo28351a(m13622a(hVar.mo28360d().charAt(hVar.f10983f), hVar.mo28360d().charAt(hVar.f10983f + 1)));
            hVar.f10983f += 2;
            return;
        }
        char c = hVar.mo28358c();
        int a = C4092j.m13677a(hVar.mo28360d(), hVar.f10983f, mo28339a());
        if (a != mo28339a()) {
            if (a == 1) {
                hVar.mo28351a(230);
                hVar.mo28357b(1);
            } else if (a == 2) {
                hVar.mo28351a(239);
                hVar.mo28357b(2);
            } else if (a == 3) {
                hVar.mo28351a(238);
                hVar.mo28357b(3);
            } else if (a == 4) {
                hVar.mo28351a(240);
                hVar.mo28357b(4);
            } else if (a == 5) {
                hVar.mo28351a(231);
                hVar.mo28357b(5);
            } else {
                throw new IllegalStateException("Illegal mode: ".concat(String.valueOf(a)));
            }
        } else if (C4092j.m13683c(c)) {
            hVar.mo28351a(235);
            hVar.mo28351a((char) ((c - 128) + 1));
            hVar.f10983f++;
        } else {
            hVar.mo28351a((char) (c + 1));
            hVar.f10983f++;
        }
    }

    /* renamed from: a */
    private static char m13622a(char c, char c2) {
        if (C4092j.m13682b(c) && C4092j.m13682b(c2)) {
            return (char) (((c - '0') * 10) + (c2 - '0') + 130);
        }
        throw new IllegalArgumentException("not digits: " + c + c2);
    }
}
