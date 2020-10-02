package com.google.protobuf;

import com.google.protobuf.C4038p;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* renamed from: com.google.protobuf.m */
/* compiled from: FloatArrayList */
final class C4022m extends C3984c<Float> implements C4038p.C4043e, RandomAccess {

    /* renamed from: d */
    private static final C4022m f10826d;

    /* renamed from: b */
    private float[] f10827b;

    /* renamed from: c */
    private int f10828c;

    static {
        C4022m mVar = new C4022m();
        f10826d = mVar;
        mVar.mo28079t();
    }

    C4022m() {
        this(new float[10], 0);
    }

    /* renamed from: b */
    public static C4022m m13430b() {
        return f10826d;
    }

    /* renamed from: e */
    private void m13432e(int i) {
        if (i < 0 || i >= this.f10828c) {
            throw new IndexOutOfBoundsException(m13433f(i));
        }
    }

    /* renamed from: f */
    private String m13433f(int i) {
        return "Index:" + i + ", Size:" + this.f10828c;
    }

    /* renamed from: a */
    public float mo28181a(int i, float f) {
        mo28069a();
        m13432e(i);
        float[] fArr = this.f10827b;
        float f2 = fArr[i];
        fArr[i] = f;
        return f2;
    }

    public boolean addAll(Collection<? extends Float> collection) {
        mo28069a();
        if (collection == null) {
            throw null;
        } else if (!(collection instanceof C4022m)) {
            return super.addAll(collection);
        } else {
            C4022m mVar = (C4022m) collection;
            int i = mVar.f10828c;
            if (i == 0) {
                return false;
            }
            int i2 = this.f10828c;
            if (Integer.MAX_VALUE - i2 >= i) {
                int i3 = i2 + i;
                float[] fArr = this.f10827b;
                if (i3 > fArr.length) {
                    this.f10827b = Arrays.copyOf(fArr, i3);
                }
                System.arraycopy(mVar.f10827b, 0, this.f10827b, this.f10828c, mVar.f10828c);
                this.f10828c = i3;
                this.modCount++;
                return true;
            }
            throw new OutOfMemoryError();
        }
    }

    /* renamed from: d */
    public float mo28185d(int i) {
        m13432e(i);
        return this.f10827b[i];
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C4022m)) {
            return super.equals(obj);
        }
        C4022m mVar = (C4022m) obj;
        if (this.f10828c != mVar.f10828c) {
            return false;
        }
        float[] fArr = mVar.f10827b;
        for (int i = 0; i < this.f10828c; i++) {
            if (this.f10827b[i] != fArr[i]) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.f10828c; i2++) {
            i = (i * 31) + Float.floatToIntBits(this.f10827b[i2]);
        }
        return i;
    }

    public int size() {
        return this.f10828c;
    }

    private C4022m(float[] fArr, int i) {
        this.f10827b = fArr;
        this.f10828c = i;
    }

    /* renamed from: b */
    public Float set(int i, Float f) {
        return Float.valueOf(mo28181a(i, f.floatValue()));
    }

    /* renamed from: c */
    public C4038p.C4043e m13438c(int i) {
        if (i >= this.f10828c) {
            return new C4022m(Arrays.copyOf(this.f10827b, i), this.f10828c);
        }
        throw new IllegalArgumentException();
    }

    public Float get(int i) {
        return Float.valueOf(mo28185d(i));
    }

    public boolean remove(Object obj) {
        mo28069a();
        for (int i = 0; i < this.f10828c; i++) {
            if (obj.equals(Float.valueOf(this.f10827b[i]))) {
                float[] fArr = this.f10827b;
                System.arraycopy(fArr, i + 1, fArr, i, this.f10828c - i);
                this.f10828c--;
                this.modCount++;
                return true;
            }
        }
        return false;
    }

    /* renamed from: b */
    private void m13431b(int i, float f) {
        int i2;
        mo28069a();
        if (i < 0 || i > (i2 = this.f10828c)) {
            throw new IndexOutOfBoundsException(m13433f(i));
        }
        float[] fArr = this.f10827b;
        if (i2 < fArr.length) {
            System.arraycopy(fArr, i, fArr, i + 1, i2 - i);
        } else {
            float[] fArr2 = new float[(((i2 * 3) / 2) + 1)];
            System.arraycopy(fArr, 0, fArr2, 0, i);
            System.arraycopy(this.f10827b, i, fArr2, i + 1, this.f10828c - i);
            this.f10827b = fArr2;
        }
        this.f10827b[i] = f;
        this.f10828c++;
        this.modCount++;
    }

    /* renamed from: a */
    public void add(int i, Float f) {
        m13431b(i, f.floatValue());
    }

    public Float remove(int i) {
        mo28069a();
        m13432e(i);
        float[] fArr = this.f10827b;
        float f = fArr[i];
        System.arraycopy(fArr, i + 1, fArr, i, this.f10828c - i);
        this.f10828c--;
        this.modCount++;
        return Float.valueOf(f);
    }
}
