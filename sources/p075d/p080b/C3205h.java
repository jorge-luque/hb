package p075d.p080b;

/* renamed from: d.b.h */
/* compiled from: SparseArrayCompat */
public class C3205h<E> implements Cloneable {

    /* renamed from: e */
    private static final Object f8918e = new Object();

    /* renamed from: a */
    private boolean f8919a;

    /* renamed from: b */
    private int[] f8920b;

    /* renamed from: c */
    private Object[] f8921c;

    /* renamed from: d */
    private int f8922d;

    public C3205h() {
        this(10);
    }

    /* renamed from: c */
    private void m10581c() {
        int i = this.f8922d;
        int[] iArr = this.f8920b;
        Object[] objArr = this.f8921c;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            Object obj = objArr[i3];
            if (obj != f8918e) {
                if (i3 != i2) {
                    iArr[i2] = iArr[i3];
                    objArr[i2] = obj;
                    objArr[i3] = null;
                }
                i2++;
            }
        }
        this.f8919a = false;
        this.f8922d = i2;
    }

    /* renamed from: a */
    public E mo18822a(int i) {
        return mo18827b(i, (Object) null);
    }

    /* renamed from: b */
    public E mo18827b(int i, E e) {
        int a = C3195c.m10532a(this.f8920b, this.f8922d, i);
        if (a >= 0) {
            E[] eArr = this.f8921c;
            if (eArr[a] != f8918e) {
                return eArr[a];
            }
        }
        return e;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000a, code lost:
        r0 = r3.f8921c;
     */
    /* renamed from: d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo18831d(int r4) {
        /*
            r3 = this;
            int[] r0 = r3.f8920b
            int r1 = r3.f8922d
            int r4 = p075d.p080b.C3195c.m10532a((int[]) r0, (int) r1, (int) r4)
            if (r4 < 0) goto L_0x0017
            java.lang.Object[] r0 = r3.f8921c
            r1 = r0[r4]
            java.lang.Object r2 = f8918e
            if (r1 == r2) goto L_0x0017
            r0[r4] = r2
            r4 = 1
            r3.f8919a = r4
        L_0x0017:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p075d.p080b.C3205h.mo18831d(int):void");
    }

    /* renamed from: e */
    public E mo18832e(int i) {
        if (this.f8919a) {
            m10581c();
        }
        return this.f8921c[i];
    }

    public String toString() {
        if (mo18825b() <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f8922d * 28);
        sb.append('{');
        for (int i = 0; i < this.f8922d; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            sb.append(mo18828c(i));
            sb.append('=');
            Object e = mo18832e(i);
            if (e != this) {
                sb.append(e);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    public C3205h(int i) {
        this.f8919a = false;
        if (i == 0) {
            this.f8920b = C3195c.f8888a;
            this.f8921c = C3195c.f8890c;
            return;
        }
        int b = C3195c.m10535b(i);
        this.f8920b = new int[b];
        this.f8921c = new Object[b];
    }

    /* renamed from: a */
    public void mo18823a() {
        int i = this.f8922d;
        Object[] objArr = this.f8921c;
        for (int i2 = 0; i2 < i; i2++) {
            objArr[i2] = null;
        }
        this.f8922d = 0;
        this.f8919a = false;
    }

    public C3205h<E> clone() {
        try {
            C3205h<E> hVar = (C3205h) super.clone();
            hVar.f8920b = (int[]) this.f8920b.clone();
            hVar.f8921c = (Object[]) this.f8921c.clone();
            return hVar;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    /* renamed from: b */
    public int mo18825b() {
        if (this.f8919a) {
            m10581c();
        }
        return this.f8922d;
    }

    /* renamed from: a */
    public void mo18824a(int i, E e) {
        int i2 = this.f8922d;
        if (i2 == 0 || i > this.f8920b[i2 - 1]) {
            if (this.f8919a && this.f8922d >= this.f8920b.length) {
                m10581c();
            }
            int i3 = this.f8922d;
            if (i3 >= this.f8920b.length) {
                int b = C3195c.m10535b(i3 + 1);
                int[] iArr = new int[b];
                Object[] objArr = new Object[b];
                int[] iArr2 = this.f8920b;
                System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
                Object[] objArr2 = this.f8921c;
                System.arraycopy(objArr2, 0, objArr, 0, objArr2.length);
                this.f8920b = iArr;
                this.f8921c = objArr;
            }
            this.f8920b[i3] = i;
            this.f8921c[i3] = e;
            this.f8922d = i3 + 1;
            return;
        }
        mo18829c(i, e);
    }

    /* renamed from: b */
    public int mo18826b(int i) {
        if (this.f8919a) {
            m10581c();
        }
        return C3195c.m10532a(this.f8920b, this.f8922d, i);
    }

    /* renamed from: c */
    public void mo18829c(int i, E e) {
        int a = C3195c.m10532a(this.f8920b, this.f8922d, i);
        if (a >= 0) {
            this.f8921c[a] = e;
            return;
        }
        int i2 = a ^ -1;
        if (i2 < this.f8922d) {
            Object[] objArr = this.f8921c;
            if (objArr[i2] == f8918e) {
                this.f8920b[i2] = i;
                objArr[i2] = e;
                return;
            }
        }
        if (this.f8919a && this.f8922d >= this.f8920b.length) {
            m10581c();
            i2 = C3195c.m10532a(this.f8920b, this.f8922d, i) ^ -1;
        }
        int i3 = this.f8922d;
        if (i3 >= this.f8920b.length) {
            int b = C3195c.m10535b(i3 + 1);
            int[] iArr = new int[b];
            Object[] objArr2 = new Object[b];
            int[] iArr2 = this.f8920b;
            System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
            Object[] objArr3 = this.f8921c;
            System.arraycopy(objArr3, 0, objArr2, 0, objArr3.length);
            this.f8920b = iArr;
            this.f8921c = objArr2;
        }
        int i4 = this.f8922d;
        if (i4 - i2 != 0) {
            int[] iArr3 = this.f8920b;
            int i5 = i2 + 1;
            System.arraycopy(iArr3, i2, iArr3, i5, i4 - i2);
            Object[] objArr4 = this.f8921c;
            System.arraycopy(objArr4, i2, objArr4, i5, this.f8922d - i2);
        }
        this.f8920b[i2] = i;
        this.f8921c[i2] = e;
        this.f8922d++;
    }

    /* renamed from: c */
    public int mo18828c(int i) {
        if (this.f8919a) {
            m10581c();
        }
        return this.f8920b[i];
    }
}
