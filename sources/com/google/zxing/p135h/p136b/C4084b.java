package com.google.zxing.p135h.p136b;

import admost.sdk.AdMostManager;

/* renamed from: com.google.zxing.h.b.b */
/* compiled from: Base256Encoder */
final class C4084b implements C4089g {
    C4084b() {
    }

    /* renamed from: a */
    public int mo28341a() {
        return 5;
    }

    /* renamed from: a */
    public void mo28340a(C4090h hVar) {
        StringBuilder sb = new StringBuilder();
        sb.append(0);
        while (true) {
            if (!hVar.mo28364h()) {
                break;
            }
            sb.append(hVar.mo28358c());
            hVar.f10983f++;
            if (C4092j.m13677a(hVar.mo28360d(), hVar.f10983f, mo28341a()) != mo28341a()) {
                hVar.mo28357b(0);
                break;
            }
        }
        int length = sb.length() - 1;
        int a = hVar.mo28350a() + length + 1;
        hVar.mo28359c(a);
        boolean z = hVar.mo28363g().mo28368a() - a > 0;
        if (hVar.mo28364h() || z) {
            if (length <= 249) {
                sb.setCharAt(0, (char) length);
            } else if (length <= 1555) {
                sb.setCharAt(0, (char) ((length / AdMostManager.AD_MEDIUM_RECTANGLE) + 249));
                sb.insert(1, (char) (length % AdMostManager.AD_MEDIUM_RECTANGLE));
            } else {
                throw new IllegalStateException("Message length not in valid ranges: ".concat(String.valueOf(length)));
            }
        }
        int length2 = sb.length();
        for (int i = 0; i < length2; i++) {
            hVar.mo28351a(m13625a(sb.charAt(i), hVar.mo28350a() + 1));
        }
    }

    /* renamed from: a */
    private static char m13625a(char c, int i) {
        int i2 = c + ((i * 149) % 255) + 1;
        return i2 <= 255 ? (char) i2 : (char) (i2 - 256);
    }
}
