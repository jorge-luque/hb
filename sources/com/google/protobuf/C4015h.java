package com.google.protobuf;

import com.google.protobuf.C4038p;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* renamed from: com.google.protobuf.h */
/* compiled from: DoubleArrayList */
final class C4015h extends C3984c<Double> implements C4038p.C4040b, RandomAccess {

    /* renamed from: d */
    private static final C4015h f10816d;

    /* renamed from: b */
    private double[] f10817b;

    /* renamed from: c */
    private int f10818c;

    static {
        C4015h hVar = new C4015h();
        f10816d = hVar;
        hVar.mo28079t();
    }

    C4015h() {
        this(new double[10], 0);
    }

    /* renamed from: b */
    public static C4015h m13400b() {
        return f10816d;
    }

    /* renamed from: e */
    private void m13402e(int i) {
        if (i < 0 || i >= this.f10818c) {
            throw new IndexOutOfBoundsException(m13403f(i));
        }
    }

    /* renamed from: f */
    private String m13403f(int i) {
        return "Index:" + i + ", Size:" + this.f10818c;
    }

    /* renamed from: a */
    public double mo28158a(int i, double d) {
        mo28069a();
        m13402e(i);
        double[] dArr = this.f10817b;
        double d2 = dArr[i];
        dArr[i] = d;
        return d2;
    }

    public boolean addAll(Collection<? extends Double> collection) {
        mo28069a();
        if (collection == null) {
            throw null;
        } else if (!(collection instanceof C4015h)) {
            return super.addAll(collection);
        } else {
            C4015h hVar = (C4015h) collection;
            int i = hVar.f10818c;
            if (i == 0) {
                return false;
            }
            int i2 = this.f10818c;
            if (Integer.MAX_VALUE - i2 >= i) {
                int i3 = i2 + i;
                double[] dArr = this.f10817b;
                if (i3 > dArr.length) {
                    this.f10817b = Arrays.copyOf(dArr, i3);
                }
                System.arraycopy(hVar.f10817b, 0, this.f10817b, this.f10818c, hVar.f10818c);
                this.f10818c = i3;
                this.modCount++;
                return true;
            }
            throw new OutOfMemoryError();
        }
    }

    /* renamed from: d */
    public double mo28162d(int i) {
        m13402e(i);
        return this.f10817b[i];
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C4015h)) {
            return super.equals(obj);
        }
        C4015h hVar = (C4015h) obj;
        if (this.f10818c != hVar.f10818c) {
            return false;
        }
        double[] dArr = hVar.f10817b;
        for (int i = 0; i < this.f10818c; i++) {
            if (this.f10817b[i] != dArr[i]) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.f10818c; i2++) {
            i = (i * 31) + C4038p.m13499a(Double.doubleToLongBits(this.f10817b[i2]));
        }
        return i;
    }

    public int size() {
        return this.f10818c;
    }

    private C4015h(double[] dArr, int i) {
        this.f10817b = dArr;
        this.f10818c = i;
    }

    /* renamed from: b */
    public Double set(int i, Double d) {
        return Double.valueOf(mo28158a(i, d.doubleValue()));
    }

    /* renamed from: c */
    public C4038p.C4040b m13408c(int i) {
        if (i >= this.f10818c) {
            return new C4015h(Arrays.copyOf(this.f10817b, i), this.f10818c);
        }
        throw new IllegalArgumentException();
    }

    public Double get(int i) {
        return Double.valueOf(mo28162d(i));
    }

    public boolean remove(Object obj) {
        mo28069a();
        for (int i = 0; i < this.f10818c; i++) {
            if (obj.equals(Double.valueOf(this.f10817b[i]))) {
                double[] dArr = this.f10817b;
                System.arraycopy(dArr, i + 1, dArr, i, this.f10818c - i);
                this.f10818c--;
                this.modCount++;
                return true;
            }
        }
        return false;
    }

    /* renamed from: b */
    private void m13401b(int i, double d) {
        int i2;
        mo28069a();
        if (i < 0 || i > (i2 = this.f10818c)) {
            throw new IndexOutOfBoundsException(m13403f(i));
        }
        double[] dArr = this.f10817b;
        if (i2 < dArr.length) {
            System.arraycopy(dArr, i, dArr, i + 1, i2 - i);
        } else {
            double[] dArr2 = new double[(((i2 * 3) / 2) + 1)];
            System.arraycopy(dArr, 0, dArr2, 0, i);
            System.arraycopy(this.f10817b, i, dArr2, i + 1, this.f10818c - i);
            this.f10817b = dArr2;
        }
        this.f10817b[i] = d;
        this.f10818c++;
        this.modCount++;
    }

    /* renamed from: a */
    public void add(int i, Double d) {
        m13401b(i, d.doubleValue());
    }

    public Double remove(int i) {
        mo28069a();
        m13402e(i);
        double[] dArr = this.f10817b;
        double d = dArr[i];
        System.arraycopy(dArr, i + 1, dArr, i, this.f10818c - i);
        this.f10818c--;
        this.modCount++;
        return Double.valueOf(d);
    }
}
