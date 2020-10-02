package com.google.protobuf;

import com.google.protobuf.C4038p;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* renamed from: com.google.protobuf.o */
/* compiled from: IntArrayList */
final class C4037o extends C3984c<Integer> implements C4038p.C4044f, RandomAccess {

    /* renamed from: d */
    private static final C4037o f10849d;

    /* renamed from: b */
    private int[] f10850b;

    /* renamed from: c */
    private int f10851c;

    static {
        C4037o oVar = new C4037o();
        f10849d = oVar;
        oVar.mo28079t();
    }

    C4037o() {
        this(new int[10], 0);
    }

    /* renamed from: b */
    public static C4037o m13488b() {
        return f10849d;
    }

    /* renamed from: e */
    private void m13490e(int i) {
        if (i < 0 || i >= this.f10851c) {
            throw new IndexOutOfBoundsException(m13491f(i));
        }
    }

    /* renamed from: f */
    private String m13491f(int i) {
        return "Index:" + i + ", Size:" + this.f10851c;
    }

    /* renamed from: a */
    public int mo28228a(int i, int i2) {
        mo28069a();
        m13490e(i);
        int[] iArr = this.f10850b;
        int i3 = iArr[i];
        iArr[i] = i2;
        return i3;
    }

    public boolean addAll(Collection<? extends Integer> collection) {
        mo28069a();
        if (collection == null) {
            throw null;
        } else if (!(collection instanceof C4037o)) {
            return super.addAll(collection);
        } else {
            C4037o oVar = (C4037o) collection;
            int i = oVar.f10851c;
            if (i == 0) {
                return false;
            }
            int i2 = this.f10851c;
            if (Integer.MAX_VALUE - i2 >= i) {
                int i3 = i2 + i;
                int[] iArr = this.f10850b;
                if (i3 > iArr.length) {
                    this.f10850b = Arrays.copyOf(iArr, i3);
                }
                System.arraycopy(oVar.f10850b, 0, this.f10850b, this.f10851c, oVar.f10851c);
                this.f10851c = i3;
                this.modCount++;
                return true;
            }
            throw new OutOfMemoryError();
        }
    }

    /* renamed from: d */
    public int mo28232d(int i) {
        m13490e(i);
        return this.f10850b[i];
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C4037o)) {
            return super.equals(obj);
        }
        C4037o oVar = (C4037o) obj;
        if (this.f10851c != oVar.f10851c) {
            return false;
        }
        int[] iArr = oVar.f10850b;
        for (int i = 0; i < this.f10851c; i++) {
            if (this.f10850b[i] != iArr[i]) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.f10851c; i2++) {
            i = (i * 31) + this.f10850b[i2];
        }
        return i;
    }

    public int size() {
        return this.f10851c;
    }

    private C4037o(int[] iArr, int i) {
        this.f10850b = iArr;
        this.f10851c = i;
    }

    /* renamed from: b */
    public Integer set(int i, Integer num) {
        return Integer.valueOf(mo28228a(i, num.intValue()));
    }

    /* renamed from: c */
    public C4038p.C4044f m13496c(int i) {
        if (i >= this.f10851c) {
            return new C4037o(Arrays.copyOf(this.f10850b, i), this.f10851c);
        }
        throw new IllegalArgumentException();
    }

    public Integer get(int i) {
        return Integer.valueOf(mo28232d(i));
    }

    public boolean remove(Object obj) {
        mo28069a();
        for (int i = 0; i < this.f10851c; i++) {
            if (obj.equals(Integer.valueOf(this.f10850b[i]))) {
                int[] iArr = this.f10850b;
                System.arraycopy(iArr, i + 1, iArr, i, this.f10851c - i);
                this.f10851c--;
                this.modCount++;
                return true;
            }
        }
        return false;
    }

    /* renamed from: b */
    private void m13489b(int i, int i2) {
        int i3;
        mo28069a();
        if (i < 0 || i > (i3 = this.f10851c)) {
            throw new IndexOutOfBoundsException(m13491f(i));
        }
        int[] iArr = this.f10850b;
        if (i3 < iArr.length) {
            System.arraycopy(iArr, i, iArr, i + 1, i3 - i);
        } else {
            int[] iArr2 = new int[(((i3 * 3) / 2) + 1)];
            System.arraycopy(iArr, 0, iArr2, 0, i);
            System.arraycopy(this.f10850b, i, iArr2, i + 1, this.f10851c - i);
            this.f10850b = iArr2;
        }
        this.f10850b[i] = i2;
        this.f10851c++;
        this.modCount++;
    }

    /* renamed from: a */
    public void add(int i, Integer num) {
        m13489b(i, num.intValue());
    }

    public Integer remove(int i) {
        mo28069a();
        m13490e(i);
        int[] iArr = this.f10850b;
        int i2 = iArr[i];
        System.arraycopy(iArr, i + 1, iArr, i, this.f10851c - i);
        this.f10851c--;
        this.modCount++;
        return Integer.valueOf(i2);
    }
}
