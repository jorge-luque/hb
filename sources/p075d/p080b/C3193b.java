package p075d.p080b;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* renamed from: d.b.b */
/* compiled from: ArraySet */
public final class C3193b<E> implements Collection<E>, Set<E> {

    /* renamed from: e */
    private static final int[] f8877e = new int[0];

    /* renamed from: f */
    private static final Object[] f8878f = new Object[0];

    /* renamed from: g */
    private static Object[] f8879g;

    /* renamed from: h */
    private static int f8880h;

    /* renamed from: i */
    private static Object[] f8881i;

    /* renamed from: j */
    private static int f8882j;

    /* renamed from: a */
    private int[] f8883a;

    /* renamed from: b */
    Object[] f8884b;

    /* renamed from: c */
    int f8885c;

    /* renamed from: d */
    private C3198f<E, E> f8886d;

    /* renamed from: d.b.b$a */
    /* compiled from: ArraySet */
    class C3194a extends C3198f<E, E> {
        C3194a() {
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public Object mo18678a(int i, int i2) {
            return C3193b.this.f8884b[i];
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public int mo18683b(Object obj) {
            return C3193b.this.indexOf(obj);
        }

        /* access modifiers changed from: protected */
        /* renamed from: c */
        public int mo18685c() {
            return C3193b.this.f8885c;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public int mo18677a(Object obj) {
            return C3193b.this.indexOf(obj);
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public Map<E, E> mo18684b() {
            throw new UnsupportedOperationException("not a map");
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo18682a(E e, E e2) {
            C3193b.this.add(e);
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public E mo18679a(int i, E e) {
            throw new UnsupportedOperationException("not a map");
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo18681a(int i) {
            C3193b.this.mo18692e(i);
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo18680a() {
            C3193b.this.clear();
        }
    }

    public C3193b() {
        this(0);
    }

    /* renamed from: a */
    private int m10514a(Object obj, int i) {
        int i2 = this.f8885c;
        if (i2 == 0) {
            return -1;
        }
        int a = C3195c.m10532a(this.f8883a, i2, i);
        if (a < 0 || obj.equals(this.f8884b[a])) {
            return a;
        }
        int i3 = a + 1;
        while (i3 < i2 && this.f8883a[i3] == i) {
            if (obj.equals(this.f8884b[i3])) {
                return i3;
            }
            i3++;
        }
        int i4 = a - 1;
        while (i4 >= 0 && this.f8883a[i4] == i) {
            if (obj.equals(this.f8884b[i4])) {
                return i4;
            }
            i4--;
        }
        return i3 ^ -1;
    }

    /* renamed from: b */
    private int m10517b() {
        int i = this.f8885c;
        if (i == 0) {
            return -1;
        }
        int a = C3195c.m10532a(this.f8883a, i, 0);
        if (a < 0 || this.f8884b[a] == null) {
            return a;
        }
        int i2 = a + 1;
        while (i2 < i && this.f8883a[i2] == 0) {
            if (this.f8884b[i2] == null) {
                return i2;
            }
            i2++;
        }
        int i3 = a - 1;
        while (i3 >= 0 && this.f8883a[i3] == 0) {
            if (this.f8884b[i3] == null) {
                return i3;
            }
            i3--;
        }
        return i2 ^ -1;
    }

    /* renamed from: g */
    private void m10518g(int i) {
        if (i == 8) {
            synchronized (C3193b.class) {
                if (f8881i != null) {
                    Object[] objArr = f8881i;
                    this.f8884b = objArr;
                    f8881i = (Object[]) objArr[0];
                    this.f8883a = (int[]) objArr[1];
                    objArr[1] = null;
                    objArr[0] = null;
                    f8882j--;
                    return;
                }
            }
        } else if (i == 4) {
            synchronized (C3193b.class) {
                if (f8879g != null) {
                    Object[] objArr2 = f8879g;
                    this.f8884b = objArr2;
                    f8879g = (Object[]) objArr2[0];
                    this.f8883a = (int[]) objArr2[1];
                    objArr2[1] = null;
                    objArr2[0] = null;
                    f8880h--;
                    return;
                }
            }
        }
        this.f8883a = new int[i];
        this.f8884b = new Object[i];
    }

    public boolean add(E e) {
        int i;
        int i2;
        if (e == null) {
            i2 = m10517b();
            i = 0;
        } else {
            int hashCode = e.hashCode();
            i = hashCode;
            i2 = m10514a(e, hashCode);
        }
        if (i2 >= 0) {
            return false;
        }
        int i3 = i2 ^ -1;
        int i4 = this.f8885c;
        if (i4 >= this.f8883a.length) {
            int i5 = 4;
            if (i4 >= 8) {
                i5 = (i4 >> 1) + i4;
            } else if (i4 >= 4) {
                i5 = 8;
            }
            int[] iArr = this.f8883a;
            Object[] objArr = this.f8884b;
            m10518g(i5);
            int[] iArr2 = this.f8883a;
            if (iArr2.length > 0) {
                System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                System.arraycopy(objArr, 0, this.f8884b, 0, objArr.length);
            }
            m10516a(iArr, objArr, this.f8885c);
        }
        int i6 = this.f8885c;
        if (i3 < i6) {
            int[] iArr3 = this.f8883a;
            int i7 = i3 + 1;
            System.arraycopy(iArr3, i3, iArr3, i7, i6 - i3);
            Object[] objArr2 = this.f8884b;
            System.arraycopy(objArr2, i3, objArr2, i7, this.f8885c - i3);
        }
        this.f8883a[i3] = i;
        this.f8884b[i3] = e;
        this.f8885c++;
        return true;
    }

    public boolean addAll(Collection<? extends E> collection) {
        mo18691d(this.f8885c + collection.size());
        boolean z = false;
        for (Object add : collection) {
            z |= add(add);
        }
        return z;
    }

    public void clear() {
        int i = this.f8885c;
        if (i != 0) {
            m10516a(this.f8883a, this.f8884b, i);
            this.f8883a = f8877e;
            this.f8884b = f8878f;
            this.f8885c = 0;
        }
    }

    public boolean contains(Object obj) {
        return indexOf(obj) >= 0;
    }

    public boolean containsAll(Collection<?> collection) {
        for (Object contains : collection) {
            if (!contains(contains)) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: d */
    public void mo18691d(int i) {
        int[] iArr = this.f8883a;
        if (iArr.length < i) {
            Object[] objArr = this.f8884b;
            m10518g(i);
            int i2 = this.f8885c;
            if (i2 > 0) {
                System.arraycopy(iArr, 0, this.f8883a, 0, i2);
                System.arraycopy(objArr, 0, this.f8884b, 0, this.f8885c);
            }
            m10516a(iArr, objArr, this.f8885c);
        }
    }

    /* renamed from: e */
    public E mo18692e(int i) {
        E[] eArr = this.f8884b;
        E e = eArr[i];
        int i2 = this.f8885c;
        if (i2 <= 1) {
            m10516a(this.f8883a, eArr, i2);
            this.f8883a = f8877e;
            this.f8884b = f8878f;
            this.f8885c = 0;
        } else {
            int[] iArr = this.f8883a;
            int i3 = 8;
            if (iArr.length <= 8 || i2 >= iArr.length / 3) {
                int i4 = this.f8885c - 1;
                this.f8885c = i4;
                if (i < i4) {
                    int[] iArr2 = this.f8883a;
                    int i5 = i + 1;
                    System.arraycopy(iArr2, i5, iArr2, i, i4 - i);
                    Object[] objArr = this.f8884b;
                    System.arraycopy(objArr, i5, objArr, i, this.f8885c - i);
                }
                this.f8884b[this.f8885c] = null;
            } else {
                if (i2 > 8) {
                    i3 = i2 + (i2 >> 1);
                }
                int[] iArr3 = this.f8883a;
                Object[] objArr2 = this.f8884b;
                m10518g(i3);
                this.f8885c--;
                if (i > 0) {
                    System.arraycopy(iArr3, 0, this.f8883a, 0, i);
                    System.arraycopy(objArr2, 0, this.f8884b, 0, i);
                }
                int i6 = this.f8885c;
                if (i < i6) {
                    int i7 = i + 1;
                    System.arraycopy(iArr3, i7, this.f8883a, i, i6 - i);
                    System.arraycopy(objArr2, i7, this.f8884b, i, this.f8885c - i);
                }
            }
        }
        return e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set = (Set) obj;
            if (size() != set.size()) {
                return false;
            }
            int i = 0;
            while (i < this.f8885c) {
                try {
                    if (!set.contains(mo18694f(i))) {
                        return false;
                    }
                    i++;
                } catch (ClassCastException | NullPointerException unused) {
                }
            }
            return true;
        }
        return false;
    }

    /* renamed from: f */
    public E mo18694f(int i) {
        return this.f8884b[i];
    }

    public int hashCode() {
        int[] iArr = this.f8883a;
        int i = this.f8885c;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            i2 += iArr[i3];
        }
        return i2;
    }

    public int indexOf(Object obj) {
        return obj == null ? m10517b() : m10514a(obj, obj.hashCode());
    }

    public boolean isEmpty() {
        return this.f8885c <= 0;
    }

    public Iterator<E> iterator() {
        return m10515a().mo18738e().iterator();
    }

    public boolean remove(Object obj) {
        int indexOf = indexOf(obj);
        if (indexOf < 0) {
            return false;
        }
        mo18692e(indexOf);
        return true;
    }

    public boolean removeAll(Collection<?> collection) {
        boolean z = false;
        for (Object remove : collection) {
            z |= remove(remove);
        }
        return z;
    }

    public boolean retainAll(Collection<?> collection) {
        boolean z = false;
        for (int i = this.f8885c - 1; i >= 0; i--) {
            if (!collection.contains(this.f8884b[i])) {
                mo18692e(i);
                z = true;
            }
        }
        return z;
    }

    public int size() {
        return this.f8885c;
    }

    public Object[] toArray() {
        int i = this.f8885c;
        Object[] objArr = new Object[i];
        System.arraycopy(this.f8884b, 0, objArr, 0, i);
        return objArr;
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f8885c * 14);
        sb.append('{');
        for (int i = 0; i < this.f8885c; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            Object f = mo18694f(i);
            if (f != this) {
                sb.append(f);
            } else {
                sb.append("(this Set)");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    public C3193b(int i) {
        if (i == 0) {
            this.f8883a = f8877e;
            this.f8884b = f8878f;
        } else {
            m10518g(i);
        }
        this.f8885c = 0;
    }

    public <T> T[] toArray(T[] tArr) {
        if (tArr.length < this.f8885c) {
            tArr = (Object[]) Array.newInstance(tArr.getClass().getComponentType(), this.f8885c);
        }
        System.arraycopy(this.f8884b, 0, tArr, 0, this.f8885c);
        int length = tArr.length;
        int i = this.f8885c;
        if (length > i) {
            tArr[i] = null;
        }
        return tArr;
    }

    /* renamed from: a */
    private static void m10516a(int[] iArr, Object[] objArr, int i) {
        if (iArr.length == 8) {
            synchronized (C3193b.class) {
                if (f8882j < 10) {
                    objArr[0] = f8881i;
                    objArr[1] = iArr;
                    for (int i2 = i - 1; i2 >= 2; i2--) {
                        objArr[i2] = null;
                    }
                    f8881i = objArr;
                    f8882j++;
                }
            }
        } else if (iArr.length == 4) {
            synchronized (C3193b.class) {
                if (f8880h < 10) {
                    objArr[0] = f8879g;
                    objArr[1] = iArr;
                    for (int i3 = i - 1; i3 >= 2; i3--) {
                        objArr[i3] = null;
                    }
                    f8879g = objArr;
                    f8880h++;
                }
            }
        }
    }

    /* renamed from: a */
    private C3198f<E, E> m10515a() {
        if (this.f8886d == null) {
            this.f8886d = new C3194a();
        }
        return this.f8886d;
    }
}
