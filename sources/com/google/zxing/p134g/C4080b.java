package com.google.zxing.p134g;

import java.util.Arrays;

/* renamed from: com.google.zxing.g.b */
/* compiled from: BitMatrix */
public final class C4080b implements Cloneable {

    /* renamed from: a */
    private final int f10938a;

    /* renamed from: b */
    private final int f10939b;

    /* renamed from: c */
    private final int f10940c;

    /* renamed from: d */
    private final int[] f10941d;

    public C4080b(int i) {
        this(i, i);
    }

    /* renamed from: a */
    public boolean mo28330a(int i, int i2) {
        return ((this.f10941d[(i2 * this.f10940c) + (i / 32)] >>> (i & 31)) & 1) != 0;
    }

    /* renamed from: b */
    public void mo28332b(int i, int i2) {
        int i3 = (i2 * this.f10940c) + (i / 32);
        int[] iArr = this.f10941d;
        iArr[i3] = (1 << (i & 31)) | iArr[i3];
    }

    /* renamed from: c */
    public int mo28333c() {
        return this.f10938a;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C4080b)) {
            return false;
        }
        C4080b bVar = (C4080b) obj;
        if (this.f10938a == bVar.f10938a && this.f10939b == bVar.f10939b && this.f10940c == bVar.f10940c && Arrays.equals(this.f10941d, bVar.f10941d)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i = this.f10938a;
        return (((((((i * 31) + i) * 31) + this.f10939b) * 31) + this.f10940c) * 31) + Arrays.hashCode(this.f10941d);
    }

    public String toString() {
        return mo28327a("X ", "  ");
    }

    public C4080b(int i, int i2) {
        if (i <= 0 || i2 <= 0) {
            throw new IllegalArgumentException("Both dimensions must be greater than 0");
        }
        this.f10938a = i;
        this.f10939b = i2;
        int i3 = (i + 31) / 32;
        this.f10940c = i3;
        this.f10941d = new int[(i3 * i2)];
    }

    public C4080b clone() {
        return new C4080b(this.f10938a, this.f10939b, this.f10940c, (int[]) this.f10941d.clone());
    }

    /* renamed from: a */
    public void mo28328a() {
        int length = this.f10941d.length;
        for (int i = 0; i < length; i++) {
            this.f10941d[i] = 0;
        }
    }

    /* renamed from: b */
    public int mo28331b() {
        return this.f10939b;
    }

    /* renamed from: a */
    public void mo28329a(int i, int i2, int i3, int i4) {
        if (i2 < 0 || i < 0) {
            throw new IllegalArgumentException("Left and top must be nonnegative");
        } else if (i4 <= 0 || i3 <= 0) {
            throw new IllegalArgumentException("Height and width must be at least 1");
        } else {
            int i5 = i3 + i;
            int i6 = i4 + i2;
            if (i6 > this.f10939b || i5 > this.f10938a) {
                throw new IllegalArgumentException("The region must fit inside the matrix");
            }
            while (i2 < i6) {
                int i7 = this.f10940c * i2;
                for (int i8 = i; i8 < i5; i8++) {
                    int[] iArr = this.f10941d;
                    int i9 = (i8 / 32) + i7;
                    iArr[i9] = iArr[i9] | (1 << (i8 & 31));
                }
                i2++;
            }
        }
    }

    private C4080b(int i, int i2, int i3, int[] iArr) {
        this.f10938a = i;
        this.f10939b = i2;
        this.f10940c = i3;
        this.f10941d = iArr;
    }

    /* renamed from: a */
    public String mo28327a(String str, String str2) {
        return m13608a(str, str2, "\n");
    }

    /* renamed from: a */
    private String m13608a(String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder(this.f10939b * (this.f10938a + 1));
        for (int i = 0; i < this.f10939b; i++) {
            for (int i2 = 0; i2 < this.f10938a; i2++) {
                sb.append(mo28330a(i2, i) ? str : str2);
            }
            sb.append(str3);
        }
        return sb.toString();
    }
}
