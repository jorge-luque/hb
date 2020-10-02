package com.google.protobuf;

import com.google.protobuf.C4038p;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* renamed from: com.google.protobuf.t */
/* compiled from: LongArrayList */
final class C4053t extends C3984c<Long> implements C4038p.C4045g, RandomAccess {

    /* renamed from: d */
    private static final C4053t f10861d;

    /* renamed from: b */
    private long[] f10862b;

    /* renamed from: c */
    private int f10863c;

    static {
        C4053t tVar = new C4053t();
        f10861d = tVar;
        tVar.mo28079t();
    }

    C4053t() {
        this(new long[10], 0);
    }

    /* renamed from: b */
    public static C4053t m13514b() {
        return f10861d;
    }

    /* renamed from: e */
    private void m13516e(int i) {
        if (i < 0 || i >= this.f10863c) {
            throw new IndexOutOfBoundsException(m13517f(i));
        }
    }

    /* renamed from: f */
    private String m13517f(int i) {
        return "Index:" + i + ", Size:" + this.f10863c;
    }

    /* renamed from: a */
    public long mo28251a(int i, long j) {
        mo28069a();
        m13516e(i);
        long[] jArr = this.f10862b;
        long j2 = jArr[i];
        jArr[i] = j;
        return j2;
    }

    public boolean addAll(Collection<? extends Long> collection) {
        mo28069a();
        if (collection == null) {
            throw null;
        } else if (!(collection instanceof C4053t)) {
            return super.addAll(collection);
        } else {
            C4053t tVar = (C4053t) collection;
            int i = tVar.f10863c;
            if (i == 0) {
                return false;
            }
            int i2 = this.f10863c;
            if (Integer.MAX_VALUE - i2 >= i) {
                int i3 = i2 + i;
                long[] jArr = this.f10862b;
                if (i3 > jArr.length) {
                    this.f10862b = Arrays.copyOf(jArr, i3);
                }
                System.arraycopy(tVar.f10862b, 0, this.f10862b, this.f10863c, tVar.f10863c);
                this.f10863c = i3;
                this.modCount++;
                return true;
            }
            throw new OutOfMemoryError();
        }
    }

    /* renamed from: d */
    public long mo28255d(int i) {
        m13516e(i);
        return this.f10862b[i];
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C4053t)) {
            return super.equals(obj);
        }
        C4053t tVar = (C4053t) obj;
        if (this.f10863c != tVar.f10863c) {
            return false;
        }
        long[] jArr = tVar.f10862b;
        for (int i = 0; i < this.f10863c; i++) {
            if (this.f10862b[i] != jArr[i]) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.f10863c; i2++) {
            i = (i * 31) + C4038p.m13499a(this.f10862b[i2]);
        }
        return i;
    }

    public int size() {
        return this.f10863c;
    }

    private C4053t(long[] jArr, int i) {
        this.f10862b = jArr;
        this.f10863c = i;
    }

    /* renamed from: b */
    public Long set(int i, Long l) {
        return Long.valueOf(mo28251a(i, l.longValue()));
    }

    /* renamed from: c */
    public C4038p.C4045g m13522c(int i) {
        if (i >= this.f10863c) {
            return new C4053t(Arrays.copyOf(this.f10862b, i), this.f10863c);
        }
        throw new IllegalArgumentException();
    }

    public Long get(int i) {
        return Long.valueOf(mo28255d(i));
    }

    public boolean remove(Object obj) {
        mo28069a();
        for (int i = 0; i < this.f10863c; i++) {
            if (obj.equals(Long.valueOf(this.f10862b[i]))) {
                long[] jArr = this.f10862b;
                System.arraycopy(jArr, i + 1, jArr, i, this.f10863c - i);
                this.f10863c--;
                this.modCount++;
                return true;
            }
        }
        return false;
    }

    /* renamed from: b */
    private void m13515b(int i, long j) {
        int i2;
        mo28069a();
        if (i < 0 || i > (i2 = this.f10863c)) {
            throw new IndexOutOfBoundsException(m13517f(i));
        }
        long[] jArr = this.f10862b;
        if (i2 < jArr.length) {
            System.arraycopy(jArr, i, jArr, i + 1, i2 - i);
        } else {
            long[] jArr2 = new long[(((i2 * 3) / 2) + 1)];
            System.arraycopy(jArr, 0, jArr2, 0, i);
            System.arraycopy(this.f10862b, i, jArr2, i + 1, this.f10863c - i);
            this.f10862b = jArr2;
        }
        this.f10862b[i] = j;
        this.f10863c++;
        this.modCount++;
    }

    /* renamed from: a */
    public void add(int i, Long l) {
        m13515b(i, l.longValue());
    }

    public Long remove(int i) {
        mo28069a();
        m13516e(i);
        long[] jArr = this.f10862b;
        long j = jArr[i];
        System.arraycopy(jArr, i + 1, jArr, i, this.f10863c - i);
        this.f10863c--;
        this.modCount++;
        return Long.valueOf(j);
    }
}
