package com.google.zxing.common.reedsolomon;

/* renamed from: com.google.zxing.common.reedsolomon.b */
/* compiled from: GenericGFPoly */
final class C4065b {

    /* renamed from: a */
    private final C4064a f10913a;

    /* renamed from: b */
    private final int[] f10914b;

    C4065b(C4064a aVar, int[] iArr) {
        if (iArr.length != 0) {
            this.f10913a = aVar;
            int length = iArr.length;
            if (length <= 1 || iArr[0] != 0) {
                this.f10914b = iArr;
                return;
            }
            int i = 1;
            while (i < length && iArr[i] == 0) {
                i++;
            }
            if (i == length) {
                this.f10914b = new int[]{0};
                return;
            }
            int[] iArr2 = new int[(length - i)];
            this.f10914b = iArr2;
            System.arraycopy(iArr, i, iArr2, 0, iArr2.length);
            return;
        }
        throw new IllegalArgumentException();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public int[] mo28282a() {
        return this.f10914b;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public int mo28283b() {
        return this.f10914b.length - 1;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public boolean mo28286c() {
        return this.f10914b[0] == 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(mo28283b() * 8);
        for (int b = mo28283b(); b >= 0; b--) {
            int a = mo28279a(b);
            if (a != 0) {
                if (a < 0) {
                    sb.append(" - ");
                    a = -a;
                } else if (sb.length() > 0) {
                    sb.append(" + ");
                }
                if (b == 0 || a != 1) {
                    int c = this.f10913a.mo28277c(a);
                    if (c == 0) {
                        sb.append('1');
                    } else if (c == 1) {
                        sb.append('a');
                    } else {
                        sb.append("a^");
                        sb.append(c);
                    }
                }
                if (b != 0) {
                    if (b == 1) {
                        sb.append('x');
                    } else {
                        sb.append("x^");
                        sb.append(b);
                    }
                }
            }
        }
        return sb.toString();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public int mo28279a(int i) {
        int[] iArr = this.f10914b;
        return iArr[(iArr.length - 1) - i];
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public C4065b[] mo28284b(C4065b bVar) {
        if (!this.f10913a.equals(bVar.f10913a)) {
            throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
        } else if (!bVar.mo28286c()) {
            C4065b b = this.f10913a.mo28276b();
            int b2 = this.f10913a.mo28274b(bVar.mo28279a(bVar.mo28283b()));
            C4065b bVar2 = this;
            while (bVar2.mo28283b() >= bVar.mo28283b() && !bVar2.mo28286c()) {
                int b3 = bVar2.mo28283b() - bVar.mo28283b();
                int b4 = this.f10913a.mo28275b(bVar2.mo28279a(bVar2.mo28283b()), b2);
                C4065b a = bVar.mo28280a(b3, b4);
                b = b.mo28281a(this.f10913a.mo28273a(b3, b4));
                bVar2 = bVar2.mo28281a(a);
            }
            return new C4065b[]{b, bVar2};
        } else {
            throw new IllegalArgumentException("Divide by 0");
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public C4065b mo28285c(C4065b bVar) {
        if (!this.f10913a.equals(bVar.f10913a)) {
            throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
        } else if (mo28286c() || bVar.mo28286c()) {
            return this.f10913a.mo28276b();
        } else {
            int[] iArr = this.f10914b;
            int length = iArr.length;
            int[] iArr2 = bVar.f10914b;
            int length2 = iArr2.length;
            int[] iArr3 = new int[((length + length2) - 1)];
            for (int i = 0; i < length; i++) {
                int i2 = iArr[i];
                for (int i3 = 0; i3 < length2; i3++) {
                    int i4 = i + i3;
                    iArr3[i4] = C4064a.m13538c(iArr3[i4], this.f10913a.mo28275b(i2, iArr2[i3]));
                }
            }
            return new C4065b(this.f10913a, iArr3);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public C4065b mo28281a(C4065b bVar) {
        if (!this.f10913a.equals(bVar.f10913a)) {
            throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
        } else if (mo28286c()) {
            return bVar;
        } else {
            if (bVar.mo28286c()) {
                return this;
            }
            int[] iArr = this.f10914b;
            int[] iArr2 = bVar.f10914b;
            if (iArr.length <= iArr2.length) {
                int[] iArr3 = iArr;
                iArr = iArr2;
                iArr2 = iArr3;
            }
            int[] iArr4 = new int[iArr.length];
            int length = iArr.length - iArr2.length;
            System.arraycopy(iArr, 0, iArr4, 0, length);
            for (int i = length; i < iArr.length; i++) {
                iArr4[i] = C4064a.m13538c(iArr2[i - length], iArr[i]);
            }
            return new C4065b(this.f10913a, iArr4);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public C4065b mo28280a(int i, int i2) {
        if (i < 0) {
            throw new IllegalArgumentException();
        } else if (i2 == 0) {
            return this.f10913a.mo28276b();
        } else {
            int length = this.f10914b.length;
            int[] iArr = new int[(i + length)];
            for (int i3 = 0; i3 < length; i3++) {
                iArr[i3] = this.f10913a.mo28275b(this.f10914b[i3], i2);
            }
            return new C4065b(this.f10913a, iArr);
        }
    }
}
