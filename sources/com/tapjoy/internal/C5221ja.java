package com.tapjoy.internal;

import java.util.Arrays;

/* renamed from: com.tapjoy.internal.ja */
final class C5221ja extends C5212iu {

    /* renamed from: f */
    final transient byte[][] f14337f;

    /* renamed from: g */
    final transient int[] f14338g;

    C5221ja(C5209ir irVar, int i) {
        super((byte[]) null);
        C5226je.m17567a(irVar.f14311b, 0, (long) i);
        C5218iy iyVar = irVar.f14310a;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (i3 < i) {
            int i5 = iyVar.f14330c;
            int i6 = iyVar.f14329b;
            if (i5 != i6) {
                i3 += i5 - i6;
                i4++;
                iyVar = iyVar.f14333f;
            } else {
                throw new AssertionError("s.limit == s.pos");
            }
        }
        this.f14337f = new byte[i4][];
        this.f14338g = new int[(i4 * 2)];
        C5218iy iyVar2 = irVar.f14310a;
        int i7 = 0;
        while (i2 < i) {
            this.f14337f[i7] = iyVar2.f14328a;
            i2 += iyVar2.f14330c - iyVar2.f14329b;
            if (i2 > i) {
                i2 = i;
            }
            int[] iArr = this.f14338g;
            iArr[i7] = i2;
            iArr[this.f14337f.length + i7] = iyVar2.f14329b;
            iyVar2.f14331d = true;
            i7++;
            iyVar2 = iyVar2.f14333f;
        }
    }

    /* renamed from: e */
    private C5212iu m17552e() {
        return new C5212iu(mo31427d());
    }

    /* renamed from: a */
    public final String mo31421a() {
        return m17552e().mo31421a();
    }

    /* renamed from: b */
    public final String mo31424b() {
        return m17552e().mo31424b();
    }

    /* renamed from: c */
    public final int mo31425c() {
        return this.f14338g[this.f14337f.length - 1];
    }

    /* renamed from: d */
    public final byte[] mo31427d() {
        int[] iArr = this.f14338g;
        byte[][] bArr = this.f14337f;
        byte[] bArr2 = new byte[iArr[bArr.length - 1]];
        int length = bArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int[] iArr2 = this.f14338g;
            int i3 = iArr2[length + i];
            int i4 = iArr2[i];
            System.arraycopy(this.f14337f[i], i3, bArr2, i2, i4 - i2);
            i++;
            i2 = i4;
        }
        return bArr2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x005c A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(java.lang.Object r12) {
        /*
            r11 = this;
            r0 = 1
            if (r12 != r11) goto L_0x0004
            return r0
        L_0x0004:
            boolean r1 = r12 instanceof com.tapjoy.internal.C5212iu
            r2 = 0
            if (r1 == 0) goto L_0x005d
            com.tapjoy.internal.iu r12 = (com.tapjoy.internal.C5212iu) r12
            int r1 = r12.mo31425c()
            int r3 = r11.mo31425c()
            if (r1 != r3) goto L_0x005d
            int r1 = r11.mo31425c()
            int r3 = r11.mo31425c()
            int r3 = r3 - r1
            if (r3 >= 0) goto L_0x0022
        L_0x0020:
            r12 = 0
            goto L_0x005a
        L_0x0022:
            int r3 = r11.m17551b(r2)
            r4 = 0
            r5 = 0
        L_0x0028:
            if (r1 <= 0) goto L_0x0059
            if (r3 != 0) goto L_0x002e
            r6 = 0
            goto L_0x0034
        L_0x002e:
            int[] r6 = r11.f14338g
            int r7 = r3 + -1
            r6 = r6[r7]
        L_0x0034:
            int[] r7 = r11.f14338g
            r7 = r7[r3]
            int r7 = r7 - r6
            int r7 = r7 + r6
            int r7 = r7 - r4
            int r7 = java.lang.Math.min(r1, r7)
            int[] r8 = r11.f14338g
            byte[][] r9 = r11.f14337f
            int r10 = r9.length
            int r10 = r10 + r3
            r8 = r8[r10]
            int r6 = r4 - r6
            int r6 = r6 + r8
            r8 = r9[r3]
            boolean r6 = r12.mo31423a(r5, r8, r6, r7)
            if (r6 != 0) goto L_0x0053
            goto L_0x0020
        L_0x0053:
            int r4 = r4 + r7
            int r5 = r5 + r7
            int r1 = r1 - r7
            int r3 = r3 + 1
            goto L_0x0028
        L_0x0059:
            r12 = 1
        L_0x005a:
            if (r12 == 0) goto L_0x005d
            return r0
        L_0x005d:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tapjoy.internal.C5221ja.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        int i = this.f14315d;
        if (i != 0) {
            return i;
        }
        int length = this.f14337f.length;
        int i2 = 0;
        int i3 = 0;
        int i4 = 1;
        while (i2 < length) {
            byte[] bArr = this.f14337f[i2];
            int[] iArr = this.f14338g;
            int i5 = iArr[length + i2];
            int i6 = iArr[i2];
            int i7 = (i6 - i3) + i5;
            while (i5 < i7) {
                i4 = (i4 * 31) + bArr[i5];
                i5++;
            }
            i2++;
            i3 = i6;
        }
        this.f14315d = i4;
        return i4;
    }

    public final String toString() {
        return m17552e().toString();
    }

    /* renamed from: b */
    private int m17551b(int i) {
        int binarySearch = Arrays.binarySearch(this.f14338g, 0, this.f14337f.length, i + 1);
        return binarySearch >= 0 ? binarySearch : binarySearch ^ -1;
    }

    /* renamed from: a */
    public final C5212iu mo31420a(int i, int i2) {
        return m17552e().mo31420a(i, i2);
    }

    /* renamed from: a */
    public final byte mo31419a(int i) {
        int i2;
        C5226je.m17567a((long) this.f14338g[this.f14337f.length - 1], (long) i, 1);
        int b = m17551b(i);
        if (b == 0) {
            i2 = 0;
        } else {
            i2 = this.f14338g[b - 1];
        }
        int[] iArr = this.f14338g;
        byte[][] bArr = this.f14337f;
        return bArr[b][(i - i2) + iArr[bArr.length + b]];
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo31422a(C5209ir irVar) {
        int length = this.f14337f.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int[] iArr = this.f14338g;
            int i3 = iArr[length + i];
            int i4 = iArr[i];
            C5218iy iyVar = new C5218iy(this.f14337f[i], i3, (i3 + i4) - i2);
            C5218iy iyVar2 = irVar.f14310a;
            if (iyVar2 == null) {
                iyVar.f14334g = iyVar;
                iyVar.f14333f = iyVar;
                irVar.f14310a = iyVar;
            } else {
                iyVar2.f14334g.mo31436a(iyVar);
            }
            i++;
            i2 = i4;
        }
        irVar.f14311b += (long) i2;
    }

    /* renamed from: a */
    public final boolean mo31423a(int i, byte[] bArr, int i2, int i3) {
        int i4;
        if (i < 0 || i > mo31425c() - i3 || i2 < 0 || i2 > bArr.length - i3) {
            return false;
        }
        int b = m17551b(i);
        while (i3 > 0) {
            if (b == 0) {
                i4 = 0;
            } else {
                i4 = this.f14338g[b - 1];
            }
            int min = Math.min(i3, ((this.f14338g[b] - i4) + i4) - i);
            int[] iArr = this.f14338g;
            byte[][] bArr2 = this.f14337f;
            if (!C5226je.m17569a(bArr2[b], (i - i4) + iArr[bArr2.length + b], bArr, i2, min)) {
                return false;
            }
            i += min;
            i2 += min;
            i3 -= min;
            b++;
        }
        return true;
    }
}
