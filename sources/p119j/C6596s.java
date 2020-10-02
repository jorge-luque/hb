package p119j;

import java.util.Arrays;

/* renamed from: j.s */
/* compiled from: SegmentedByteString */
final class C6596s extends C3581f {

    /* renamed from: f */
    final transient byte[][] f17170f;

    /* renamed from: g */
    final transient int[] f17171g;

    C6596s(C3577c cVar, int i) {
        super((byte[]) null);
        C6597w.m21673a(cVar.f10032b, 0, (long) i);
        C3583q qVar = cVar.f10031a;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (i3 < i) {
            int i5 = qVar.f10042c;
            int i6 = qVar.f10041b;
            if (i5 != i6) {
                i3 += i5 - i6;
                i4++;
                qVar = qVar.f10045f;
            } else {
                throw new AssertionError("s.limit == s.pos");
            }
        }
        this.f17170f = new byte[i4][];
        this.f17171g = new int[(i4 * 2)];
        C3583q qVar2 = cVar.f10031a;
        int i7 = 0;
        while (i2 < i) {
            this.f17170f[i7] = qVar2.f10040a;
            i2 += qVar2.f10042c - qVar2.f10041b;
            if (i2 > i) {
                i2 = i;
            }
            int[] iArr = this.f17171g;
            iArr[i7] = i2;
            iArr[this.f17170f.length + i7] = qVar2.f10041b;
            qVar2.f10043d = true;
            i7++;
            qVar2 = qVar2.f10045f;
        }
    }

    /* renamed from: j */
    private C3581f m21656j() {
        return new C3581f(mo19761h());
    }

    private Object writeReplace() {
        return m21656j();
    }

    /* renamed from: a */
    public String mo19748a() {
        return m21656j().mo19748a();
    }

    /* renamed from: b */
    public String mo19752b() {
        return m21656j().mo19752b();
    }

    /* renamed from: c */
    public C3581f mo19754c() {
        return m21656j().mo19754c();
    }

    /* renamed from: d */
    public C3581f mo19756d() {
        return m21656j().mo19756d();
    }

    /* renamed from: e */
    public C3581f mo19757e() {
        return m21656j().mo19757e();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof C3581f) {
            C3581f fVar = (C3581f) obj;
            if (fVar.mo19759f() != mo19759f() || !mo19750a(0, fVar, 0, mo19759f())) {
                return false;
            }
            return true;
        }
        return false;
    }

    /* renamed from: f */
    public int mo19759f() {
        return this.f17171g[this.f17170f.length - 1];
    }

    /* renamed from: g */
    public C3581f mo19760g() {
        return m21656j().mo19760g();
    }

    /* renamed from: h */
    public byte[] mo19761h() {
        int[] iArr = this.f17171g;
        byte[][] bArr = this.f17170f;
        byte[] bArr2 = new byte[iArr[bArr.length - 1]];
        int length = bArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int[] iArr2 = this.f17171g;
            int i3 = iArr2[length + i];
            int i4 = iArr2[i];
            System.arraycopy(this.f17170f[i], i3, bArr2, i2, i4 - i2);
            i++;
            i2 = i4;
        }
        return bArr2;
    }

    public int hashCode() {
        int i = this.f10037b;
        if (i != 0) {
            return i;
        }
        int length = this.f17170f.length;
        int i2 = 0;
        int i3 = 0;
        int i4 = 1;
        while (i2 < length) {
            byte[] bArr = this.f17170f[i2];
            int[] iArr = this.f17171g;
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
        this.f10037b = i4;
        return i4;
    }

    /* renamed from: i */
    public String mo19763i() {
        return m21656j().mo19763i();
    }

    public String toString() {
        return m21656j().toString();
    }

    /* renamed from: b */
    private int m21655b(int i) {
        int binarySearch = Arrays.binarySearch(this.f17171g, 0, this.f17170f.length, i + 1);
        return binarySearch >= 0 ? binarySearch : binarySearch ^ -1;
    }

    /* renamed from: a */
    public C3581f mo19747a(int i, int i2) {
        return m21656j().mo19747a(i, i2);
    }

    /* renamed from: a */
    public byte mo19745a(int i) {
        int i2;
        C6597w.m21673a((long) this.f17171g[this.f17170f.length - 1], (long) i, 1);
        int b = m21655b(i);
        if (b == 0) {
            i2 = 0;
        } else {
            i2 = this.f17171g[b - 1];
        }
        int[] iArr = this.f17171g;
        byte[][] bArr = this.f17170f;
        return bArr[b][(i - i2) + iArr[bArr.length + b]];
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo19749a(C3577c cVar) {
        int length = this.f17170f.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int[] iArr = this.f17171g;
            int i3 = iArr[length + i];
            int i4 = iArr[i];
            C3583q qVar = new C3583q(this.f17170f[i], i3, (i3 + i4) - i2, true, false);
            C3583q qVar2 = cVar.f10031a;
            if (qVar2 == null) {
                qVar.f10046g = qVar;
                qVar.f10045f = qVar;
                cVar.f10031a = qVar;
            } else {
                qVar2.f10046g.mo19766a(qVar);
            }
            i++;
            i2 = i4;
        }
        cVar.f10032b += (long) i2;
    }

    /* renamed from: a */
    public boolean mo19750a(int i, C3581f fVar, int i2, int i3) {
        int i4;
        if (i < 0 || i > mo19759f() - i3) {
            return false;
        }
        int b = m21655b(i);
        while (i3 > 0) {
            if (b == 0) {
                i4 = 0;
            } else {
                i4 = this.f17171g[b - 1];
            }
            int min = Math.min(i3, ((this.f17171g[b] - i4) + i4) - i);
            int[] iArr = this.f17171g;
            byte[][] bArr = this.f17170f;
            if (!fVar.mo19751a(i2, bArr[b], (i - i4) + iArr[bArr.length + b], min)) {
                return false;
            }
            i += min;
            i2 += min;
            i3 -= min;
            b++;
        }
        return true;
    }

    /* renamed from: a */
    public boolean mo19751a(int i, byte[] bArr, int i2, int i3) {
        int i4;
        if (i < 0 || i > mo19759f() - i3 || i2 < 0 || i2 > bArr.length - i3) {
            return false;
        }
        int b = m21655b(i);
        while (i3 > 0) {
            if (b == 0) {
                i4 = 0;
            } else {
                i4 = this.f17171g[b - 1];
            }
            int min = Math.min(i3, ((this.f17171g[b] - i4) + i4) - i);
            int[] iArr = this.f17171g;
            byte[][] bArr2 = this.f17170f;
            if (!C6597w.m21675a(bArr2[b], (i - i4) + iArr[bArr2.length + b], bArr, i2, min)) {
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
