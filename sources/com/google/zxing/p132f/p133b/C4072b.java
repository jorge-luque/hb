package com.google.zxing.p132f.p133b;

import com.google.zxing.p134g.C4079a;

/* renamed from: com.google.zxing.f.b.b */
/* compiled from: BinaryShiftToken */
final class C4072b extends C4078g {

    /* renamed from: c */
    private final short f10919c;

    /* renamed from: d */
    private final short f10920d;

    C4072b(C4078g gVar, int i, int i2) {
        super(gVar);
        this.f10919c = (short) i;
        this.f10920d = (short) i2;
    }

    /* renamed from: a */
    public void mo28296a(C4079a aVar, byte[] bArr) {
        int i = 0;
        while (true) {
            short s = this.f10920d;
            if (i < s) {
                if (i == 0 || (i == 31 && s <= 62)) {
                    aVar.mo28316a(31, 5);
                    short s2 = this.f10920d;
                    if (s2 > 62) {
                        aVar.mo28316a(s2 - 31, 16);
                    } else if (i == 0) {
                        aVar.mo28316a(Math.min(s2, 31), 5);
                    } else {
                        aVar.mo28316a(s2 - 31, 5);
                    }
                }
                aVar.mo28316a(bArr[this.f10919c + i], 8);
                i++;
            } else {
                return;
            }
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("<");
        sb.append(this.f10919c);
        sb.append("::");
        sb.append((this.f10919c + this.f10920d) - 1);
        sb.append('>');
        return sb.toString();
    }
}
