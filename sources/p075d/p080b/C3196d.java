package p075d.p080b;

/* renamed from: d.b.d */
/* compiled from: LongSparseArray */
public class C3196d<E> implements Cloneable {

    /* renamed from: e */
    private static final Object f8891e = new Object();

    /* renamed from: a */
    private boolean f8892a;

    /* renamed from: b */
    private long[] f8893b;

    /* renamed from: c */
    private Object[] f8894c;

    /* renamed from: d */
    private int f8895d;

    public C3196d() {
        this(10);
    }

    @Deprecated
    /* renamed from: a */
    public void mo18708a(long j) {
        mo18715c(j);
    }

    /* renamed from: b */
    public E mo18711b(long j) {
        return mo18712b(j, (Object) null);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000a, code lost:
        r4 = r2.f8894c;
     */
    /* renamed from: c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo18715c(long r3) {
        /*
            r2 = this;
            long[] r0 = r2.f8893b
            int r1 = r2.f8895d
            int r3 = p075d.p080b.C3195c.m10533a((long[]) r0, (int) r1, (long) r3)
            if (r3 < 0) goto L_0x0017
            java.lang.Object[] r4 = r2.f8894c
            r0 = r4[r3]
            java.lang.Object r1 = f8891e
            if (r0 == r1) goto L_0x0017
            r4[r3] = r1
            r3 = 1
            r2.f8892a = r3
        L_0x0017:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p075d.p080b.C3196d.mo18715c(long):void");
    }

    public String toString() {
        if (mo18710b() <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f8895d * 28);
        sb.append('{');
        for (int i = 0; i < this.f8895d; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            sb.append(mo18706a(i));
            sb.append('=');
            Object c = mo18714c(i);
            if (c != this) {
                sb.append(c);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    public C3196d(int i) {
        this.f8892a = false;
        if (i == 0) {
            this.f8893b = C3195c.f8889b;
            this.f8894c = C3195c.f8890c;
            return;
        }
        int c = C3195c.m10536c(i);
        this.f8893b = new long[c];
        this.f8894c = new Object[c];
    }

    /* renamed from: a */
    public long mo18706a(int i) {
        if (this.f8892a) {
            m10537c();
        }
        return this.f8893b[i];
    }

    /* renamed from: b */
    public E mo18712b(long j, E e) {
        int a = C3195c.m10533a(this.f8893b, this.f8895d, j);
        if (a >= 0) {
            E[] eArr = this.f8894c;
            if (eArr[a] != f8891e) {
                return eArr[a];
            }
        }
        return e;
    }

    public C3196d<E> clone() {
        try {
            C3196d<E> dVar = (C3196d) super.clone();
            dVar.f8893b = (long[]) this.f8893b.clone();
            dVar.f8894c = (Object[]) this.f8894c.clone();
            return dVar;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    /* renamed from: c */
    private void m10537c() {
        int i = this.f8895d;
        long[] jArr = this.f8893b;
        Object[] objArr = this.f8894c;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            Object obj = objArr[i3];
            if (obj != f8891e) {
                if (i3 != i2) {
                    jArr[i2] = jArr[i3];
                    objArr[i2] = obj;
                    objArr[i3] = null;
                }
                i2++;
            }
        }
        this.f8892a = false;
        this.f8895d = i2;
    }

    /* renamed from: a */
    public void mo18707a() {
        int i = this.f8895d;
        Object[] objArr = this.f8894c;
        for (int i2 = 0; i2 < i; i2++) {
            objArr[i2] = null;
        }
        this.f8895d = 0;
        this.f8892a = false;
    }

    /* renamed from: b */
    public void mo18713b(int i) {
        Object[] objArr = this.f8894c;
        Object obj = objArr[i];
        Object obj2 = f8891e;
        if (obj != obj2) {
            objArr[i] = obj2;
            this.f8892a = true;
        }
    }

    /* renamed from: b */
    public int mo18710b() {
        if (this.f8892a) {
            m10537c();
        }
        return this.f8895d;
    }

    /* renamed from: a */
    public void mo18709a(long j, E e) {
        int i = this.f8895d;
        if (i == 0 || j > this.f8893b[i - 1]) {
            if (this.f8892a && this.f8895d >= this.f8893b.length) {
                m10537c();
            }
            int i2 = this.f8895d;
            if (i2 >= this.f8893b.length) {
                int c = C3195c.m10536c(i2 + 1);
                long[] jArr = new long[c];
                Object[] objArr = new Object[c];
                long[] jArr2 = this.f8893b;
                System.arraycopy(jArr2, 0, jArr, 0, jArr2.length);
                Object[] objArr2 = this.f8894c;
                System.arraycopy(objArr2, 0, objArr, 0, objArr2.length);
                this.f8893b = jArr;
                this.f8894c = objArr;
            }
            this.f8893b[i2] = j;
            this.f8894c[i2] = e;
            this.f8895d = i2 + 1;
            return;
        }
        mo18716c(j, e);
    }

    /* renamed from: c */
    public void mo18716c(long j, E e) {
        int a = C3195c.m10533a(this.f8893b, this.f8895d, j);
        if (a >= 0) {
            this.f8894c[a] = e;
            return;
        }
        int i = a ^ -1;
        if (i < this.f8895d) {
            Object[] objArr = this.f8894c;
            if (objArr[i] == f8891e) {
                this.f8893b[i] = j;
                objArr[i] = e;
                return;
            }
        }
        if (this.f8892a && this.f8895d >= this.f8893b.length) {
            m10537c();
            i = C3195c.m10533a(this.f8893b, this.f8895d, j) ^ -1;
        }
        int i2 = this.f8895d;
        if (i2 >= this.f8893b.length) {
            int c = C3195c.m10536c(i2 + 1);
            long[] jArr = new long[c];
            Object[] objArr2 = new Object[c];
            long[] jArr2 = this.f8893b;
            System.arraycopy(jArr2, 0, jArr, 0, jArr2.length);
            Object[] objArr3 = this.f8894c;
            System.arraycopy(objArr3, 0, objArr2, 0, objArr3.length);
            this.f8893b = jArr;
            this.f8894c = objArr2;
        }
        int i3 = this.f8895d;
        if (i3 - i != 0) {
            long[] jArr3 = this.f8893b;
            int i4 = i + 1;
            System.arraycopy(jArr3, i, jArr3, i4, i3 - i);
            Object[] objArr4 = this.f8894c;
            System.arraycopy(objArr4, i, objArr4, i4, this.f8895d - i);
        }
        this.f8893b[i] = j;
        this.f8894c[i] = e;
        this.f8895d++;
    }

    /* renamed from: c */
    public E mo18714c(int i) {
        if (this.f8892a) {
            m10537c();
        }
        return this.f8894c[i];
    }
}
