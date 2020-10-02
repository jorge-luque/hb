package com.google.zxing.p132f.p133b;

import com.google.zxing.p134g.C4079a;

/* renamed from: com.google.zxing.f.b.e */
/* compiled from: SimpleToken */
final class C4076e extends C4078g {

    /* renamed from: c */
    private final short f10927c;

    /* renamed from: d */
    private final short f10928d;

    C4076e(C4078g gVar, int i, int i2) {
        super(gVar);
        this.f10927c = (short) i;
        this.f10928d = (short) i2;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo28296a(C4079a aVar, byte[] bArr) {
        aVar.mo28316a(this.f10927c, this.f10928d);
    }

    public String toString() {
        short s = this.f10927c;
        short s2 = this.f10928d;
        short s3 = (s & ((1 << s2) - 1)) | (1 << s2);
        return "<" + Integer.toBinaryString(s3 | (1 << this.f10928d)).substring(1) + '>';
    }
}
