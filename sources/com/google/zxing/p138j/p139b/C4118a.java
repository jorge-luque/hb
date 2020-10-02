package com.google.zxing.p138j.p139b;

import java.lang.reflect.Array;

/* renamed from: com.google.zxing.j.b.a */
/* compiled from: BarcodeMatrix */
public final class C4118a {

    /* renamed from: a */
    private final C4119b[] f11027a;

    /* renamed from: b */
    private int f11028b;

    /* renamed from: c */
    private final int f11029c;

    /* renamed from: d */
    private final int f11030d;

    C4118a(int i, int i2) {
        C4119b[] bVarArr = new C4119b[i];
        this.f11027a = bVarArr;
        int length = bVarArr.length;
        for (int i3 = 0; i3 < length; i3++) {
            this.f11027a[i3] = new C4119b(((i2 + 4) * 17) + 1);
        }
        this.f11030d = i2 * 17;
        this.f11029c = i;
        this.f11028b = -1;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public C4119b mo28378a() {
        return this.f11027a[this.f11028b];
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo28380b() {
        this.f11028b++;
    }

    /* renamed from: a */
    public byte[][] mo28379a(int i, int i2) {
        int[] iArr = new int[2];
        iArr[1] = this.f11030d * i;
        iArr[0] = this.f11029c * i2;
        byte[][] bArr = (byte[][]) Array.newInstance(byte.class, iArr);
        int i3 = this.f11029c * i2;
        for (int i4 = 0; i4 < i3; i4++) {
            bArr[(i3 - i4) - 1] = this.f11027a[i4 / i2].mo28382a(i);
        }
        return bArr;
    }
}
