package com.google.protobuf;

import com.google.protobuf.C4038p;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* renamed from: com.google.protobuf.d */
/* compiled from: BooleanArrayList */
final class C3986d extends C3984c<Boolean> implements C4038p.C4039a, RandomAccess {

    /* renamed from: d */
    private static final C3986d f10751d;

    /* renamed from: b */
    private boolean[] f10752b;

    /* renamed from: c */
    private int f10753c;

    static {
        C3986d dVar = new C3986d();
        f10751d = dVar;
        dVar.mo28079t();
    }

    C3986d() {
        this(new boolean[10], 0);
    }

    /* renamed from: b */
    public static C3986d m13272b() {
        return f10751d;
    }

    /* renamed from: e */
    private void m13274e(int i) {
        if (i < 0 || i >= this.f10753c) {
            throw new IndexOutOfBoundsException(m13275f(i));
        }
    }

    /* renamed from: f */
    private String m13275f(int i) {
        return "Index:" + i + ", Size:" + this.f10753c;
    }

    /* renamed from: a */
    public boolean mo28092a(int i, boolean z) {
        mo28069a();
        m13274e(i);
        boolean[] zArr = this.f10752b;
        boolean z2 = zArr[i];
        zArr[i] = z;
        return z2;
    }

    public boolean addAll(Collection<? extends Boolean> collection) {
        mo28069a();
        if (collection == null) {
            throw null;
        } else if (!(collection instanceof C3986d)) {
            return super.addAll(collection);
        } else {
            C3986d dVar = (C3986d) collection;
            int i = dVar.f10753c;
            if (i == 0) {
                return false;
            }
            int i2 = this.f10753c;
            if (Integer.MAX_VALUE - i2 >= i) {
                int i3 = i2 + i;
                boolean[] zArr = this.f10752b;
                if (i3 > zArr.length) {
                    this.f10752b = Arrays.copyOf(zArr, i3);
                }
                System.arraycopy(dVar.f10752b, 0, this.f10752b, this.f10753c, dVar.f10753c);
                this.f10753c = i3;
                this.modCount++;
                return true;
            }
            throw new OutOfMemoryError();
        }
    }

    /* renamed from: d */
    public boolean mo28096d(int i) {
        m13274e(i);
        return this.f10752b[i];
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C3986d)) {
            return super.equals(obj);
        }
        C3986d dVar = (C3986d) obj;
        if (this.f10753c != dVar.f10753c) {
            return false;
        }
        boolean[] zArr = dVar.f10752b;
        for (int i = 0; i < this.f10753c; i++) {
            if (this.f10752b[i] != zArr[i]) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.f10753c; i2++) {
            i = (i * 31) + C4038p.m13500a(this.f10752b[i2]);
        }
        return i;
    }

    public int size() {
        return this.f10753c;
    }

    private C3986d(boolean[] zArr, int i) {
        this.f10752b = zArr;
        this.f10753c = i;
    }

    /* renamed from: b */
    public Boolean set(int i, Boolean bool) {
        return Boolean.valueOf(mo28092a(i, bool.booleanValue()));
    }

    /* renamed from: c */
    public C4038p.C4039a m13280c(int i) {
        if (i >= this.f10753c) {
            return new C3986d(Arrays.copyOf(this.f10752b, i), this.f10753c);
        }
        throw new IllegalArgumentException();
    }

    public Boolean get(int i) {
        return Boolean.valueOf(mo28096d(i));
    }

    public boolean remove(Object obj) {
        mo28069a();
        for (int i = 0; i < this.f10753c; i++) {
            if (obj.equals(Boolean.valueOf(this.f10752b[i]))) {
                boolean[] zArr = this.f10752b;
                System.arraycopy(zArr, i + 1, zArr, i, this.f10753c - i);
                this.f10753c--;
                this.modCount++;
                return true;
            }
        }
        return false;
    }

    /* renamed from: b */
    private void m13273b(int i, boolean z) {
        int i2;
        mo28069a();
        if (i < 0 || i > (i2 = this.f10753c)) {
            throw new IndexOutOfBoundsException(m13275f(i));
        }
        boolean[] zArr = this.f10752b;
        if (i2 < zArr.length) {
            System.arraycopy(zArr, i, zArr, i + 1, i2 - i);
        } else {
            boolean[] zArr2 = new boolean[(((i2 * 3) / 2) + 1)];
            System.arraycopy(zArr, 0, zArr2, 0, i);
            System.arraycopy(this.f10752b, i, zArr2, i + 1, this.f10753c - i);
            this.f10752b = zArr2;
        }
        this.f10752b[i] = z;
        this.f10753c++;
        this.modCount++;
    }

    /* renamed from: a */
    public void add(int i, Boolean bool) {
        m13273b(i, bool.booleanValue());
    }

    public Boolean remove(int i) {
        mo28069a();
        m13274e(i);
        boolean[] zArr = this.f10752b;
        boolean z = zArr[i];
        System.arraycopy(zArr, i + 1, zArr, i, this.f10753c - i);
        this.f10753c--;
        this.modCount++;
        return Boolean.valueOf(z);
    }
}
