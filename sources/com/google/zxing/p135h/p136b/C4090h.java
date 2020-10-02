package com.google.zxing.p135h.p136b;

import com.google.zxing.C4062b;
import java.nio.charset.StandardCharsets;

/* renamed from: com.google.zxing.h.b.h */
/* compiled from: EncoderContext */
final class C4090h {

    /* renamed from: a */
    private final String f10978a;

    /* renamed from: b */
    private C4094l f10979b;

    /* renamed from: c */
    private C4062b f10980c;

    /* renamed from: d */
    private C4062b f10981d;

    /* renamed from: e */
    private final StringBuilder f10982e;

    /* renamed from: f */
    int f10983f;

    /* renamed from: g */
    private int f10984g;

    /* renamed from: h */
    private C4093k f10985h;

    /* renamed from: i */
    private int f10986i;

    C4090h(String str) {
        byte[] bytes = str.getBytes(StandardCharsets.ISO_8859_1);
        StringBuilder sb = new StringBuilder(bytes.length);
        int length = bytes.length;
        int i = 0;
        while (i < length) {
            char c = (char) (bytes[i] & 255);
            if (c != '?' || str.charAt(i) == '?') {
                sb.append(c);
                i++;
            } else {
                throw new IllegalArgumentException("Message contains characters outside ISO-8859-1 encoding.");
            }
        }
        this.f10978a = sb.toString();
        this.f10979b = C4094l.FORCE_NONE;
        this.f10982e = new StringBuilder(str.length());
        this.f10984g = -1;
    }

    /* renamed from: l */
    private int m13653l() {
        return this.f10978a.length() - this.f10986i;
    }

    /* renamed from: a */
    public void mo28354a(C4094l lVar) {
        this.f10979b = lVar;
    }

    /* renamed from: b */
    public StringBuilder mo28356b() {
        return this.f10982e;
    }

    /* renamed from: c */
    public char mo28358c() {
        return this.f10978a.charAt(this.f10983f);
    }

    /* renamed from: d */
    public String mo28360d() {
        return this.f10978a;
    }

    /* renamed from: e */
    public int mo28361e() {
        return this.f10984g;
    }

    /* renamed from: f */
    public int mo28362f() {
        return m13653l() - this.f10983f;
    }

    /* renamed from: g */
    public C4093k mo28363g() {
        return this.f10985h;
    }

    /* renamed from: h */
    public boolean mo28364h() {
        return this.f10983f < m13653l();
    }

    /* renamed from: i */
    public void mo28365i() {
        this.f10984g = -1;
    }

    /* renamed from: j */
    public void mo28366j() {
        this.f10985h = null;
    }

    /* renamed from: k */
    public void mo28367k() {
        mo28359c(mo28350a());
    }

    /* renamed from: a */
    public void mo28353a(C4062b bVar, C4062b bVar2) {
        this.f10980c = bVar;
        this.f10981d = bVar2;
    }

    /* renamed from: b */
    public void mo28357b(int i) {
        this.f10984g = i;
    }

    /* renamed from: c */
    public void mo28359c(int i) {
        C4093k kVar = this.f10985h;
        if (kVar == null || i > kVar.mo28368a()) {
            this.f10985h = C4093k.m13690a(i, this.f10979b, this.f10980c, this.f10981d, true);
        }
    }

    /* renamed from: a */
    public void mo28352a(int i) {
        this.f10986i = i;
    }

    /* renamed from: a */
    public void mo28355a(String str) {
        this.f10982e.append(str);
    }

    /* renamed from: a */
    public void mo28351a(char c) {
        this.f10982e.append(c);
    }

    /* renamed from: a */
    public int mo28350a() {
        return this.f10982e.length();
    }
}
