package com.google.zxing.p140k.p142c;

import java.lang.reflect.Array;
import java.util.Arrays;

/* renamed from: com.google.zxing.k.c.b */
/* compiled from: ByteMatrix */
public final class C4133b {

    /* renamed from: a */
    private final byte[][] f11087a;

    /* renamed from: b */
    private final int f11088b;

    /* renamed from: c */
    private final int f11089c;

    public C4133b(int i, int i2) {
        int[] iArr = new int[2];
        iArr[1] = i;
        iArr[0] = i2;
        this.f11087a = (byte[][]) Array.newInstance(byte.class, iArr);
        this.f11088b = i;
        this.f11089c = i2;
    }

    /* renamed from: a */
    public byte mo28409a(int i, int i2) {
        return this.f11087a[i2][i];
    }

    /* renamed from: b */
    public int mo28414b() {
        return this.f11089c;
    }

    /* renamed from: c */
    public int mo28415c() {
        return this.f11088b;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder((this.f11088b * 2 * this.f11089c) + 2);
        for (int i = 0; i < this.f11089c; i++) {
            byte[] bArr = this.f11087a[i];
            for (int i2 = 0; i2 < this.f11088b; i2++) {
                byte b = bArr[i2];
                if (b == 0) {
                    sb.append(" 0");
                } else if (b != 1) {
                    sb.append("  ");
                } else {
                    sb.append(" 1");
                }
            }
            sb.append(10);
        }
        return sb.toString();
    }

    /* renamed from: a */
    public byte[][] mo28413a() {
        return this.f11087a;
    }

    /* renamed from: a */
    public void mo28411a(int i, int i2, int i3) {
        this.f11087a[i2][i] = (byte) i3;
    }

    /* renamed from: a */
    public void mo28412a(int i, int i2, boolean z) {
        this.f11087a[i2][i] = z ? (byte) 1 : 0;
    }

    /* renamed from: a */
    public void mo28410a(byte b) {
        for (byte[] fill : this.f11087a) {
            Arrays.fill(fill, b);
        }
    }
}
