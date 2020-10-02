package com.google.zxing.p134g;

import java.util.Arrays;

/* renamed from: com.google.zxing.g.a */
/* compiled from: BitArray */
public final class C4079a implements Cloneable {

    /* renamed from: a */
    private int[] f10936a;

    /* renamed from: b */
    private int f10937b;

    public C4079a() {
        this.f10937b = 0;
        this.f10936a = new int[1];
    }

    /* renamed from: c */
    private static int[] m13599c(int i) {
        return new int[((i + 31) / 32)];
    }

    /* renamed from: a */
    public int mo28315a() {
        return this.f10937b;
    }

    /* renamed from: b */
    public int mo28321b() {
        return (this.f10937b + 7) / 8;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C4079a)) {
            return false;
        }
        C4079a aVar = (C4079a) obj;
        if (this.f10937b != aVar.f10937b || !Arrays.equals(this.f10936a, aVar.f10936a)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return (this.f10937b * 31) + Arrays.hashCode(this.f10936a);
    }

    public String toString() {
        int i = this.f10937b;
        StringBuilder sb = new StringBuilder(i + (i / 8) + 1);
        for (int i2 = 0; i2 < this.f10937b; i2++) {
            if ((i2 & 7) == 0) {
                sb.append(' ');
            }
            sb.append(mo28320a(i2) ? 'X' : '.');
        }
        return sb.toString();
    }

    /* renamed from: b */
    private void m13598b(int i) {
        if (i > (this.f10936a.length << 5)) {
            int[] c = m13599c(i);
            int[] iArr = this.f10936a;
            System.arraycopy(iArr, 0, c, 0, iArr.length);
            this.f10936a = c;
        }
    }

    /* renamed from: a */
    public boolean mo28320a(int i) {
        return ((1 << (i & 31)) & this.f10936a[i / 32]) != 0;
    }

    public C4079a clone() {
        return new C4079a((int[]) this.f10936a.clone(), this.f10937b);
    }

    /* renamed from: a */
    public void mo28319a(boolean z) {
        m13598b(this.f10937b + 1);
        if (z) {
            int[] iArr = this.f10936a;
            int i = this.f10937b;
            int i2 = i / 32;
            iArr[i2] = (1 << (i & 31)) | iArr[i2];
        }
        this.f10937b++;
    }

    C4079a(int[] iArr, int i) {
        this.f10936a = iArr;
        this.f10937b = i;
    }

    /* renamed from: a */
    public void mo28316a(int i, int i2) {
        if (i2 < 0 || i2 > 32) {
            throw new IllegalArgumentException("Num bits must be between 0 and 32");
        }
        m13598b(this.f10937b + i2);
        while (i2 > 0) {
            boolean z = true;
            if (((i >> (i2 - 1)) & 1) != 1) {
                z = false;
            }
            mo28319a(z);
            i2--;
        }
    }

    /* renamed from: b */
    public void mo28322b(C4079a aVar) {
        if (this.f10937b == aVar.f10937b) {
            int i = 0;
            while (true) {
                int[] iArr = this.f10936a;
                if (i < iArr.length) {
                    iArr[i] = iArr[i] ^ aVar.f10936a[i];
                    i++;
                } else {
                    return;
                }
            }
        } else {
            throw new IllegalArgumentException("Sizes don't match");
        }
    }

    /* renamed from: a */
    public void mo28318a(C4079a aVar) {
        int i = aVar.f10937b;
        m13598b(this.f10937b + i);
        for (int i2 = 0; i2 < i; i2++) {
            mo28319a(aVar.mo28320a(i2));
        }
    }

    /* renamed from: a */
    public void mo28317a(int i, byte[] bArr, int i2, int i3) {
        for (int i4 = 0; i4 < i3; i4++) {
            int i5 = 0;
            for (int i6 = 0; i6 < 8; i6++) {
                if (mo28320a(i)) {
                    i5 |= 1 << (7 - i6);
                }
                i++;
            }
            bArr[i2 + i4] = (byte) i5;
        }
    }
}
