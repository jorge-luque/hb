package com.google.zxing.p138j.p139b;

/* renamed from: com.google.zxing.j.b.b */
/* compiled from: BarcodeRow */
final class C4119b {

    /* renamed from: a */
    private final byte[] f11031a;

    /* renamed from: b */
    private int f11032b = 0;

    C4119b(int i) {
        this.f11031a = new byte[i];
    }

    /* renamed from: a */
    private void m13748a(int i, boolean z) {
        this.f11031a[i] = z ? (byte) 1 : 0;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo28381a(boolean z, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            int i3 = this.f11032b;
            this.f11032b = i3 + 1;
            m13748a(i3, z);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public byte[] mo28382a(int i) {
        int length = this.f11031a.length * i;
        byte[] bArr = new byte[length];
        for (int i2 = 0; i2 < length; i2++) {
            bArr[i2] = this.f11031a[i2 / i];
        }
        return bArr;
    }
}
