package p075d.p080b;

import java.util.ConcurrentModificationException;
import java.util.Map;

/* renamed from: d.b.g */
/* compiled from: SimpleArrayMap */
public class C3204g<K, V> {

    /* renamed from: d */
    static Object[] f8911d;

    /* renamed from: e */
    static int f8912e;

    /* renamed from: f */
    static Object[] f8913f;

    /* renamed from: g */
    static int f8914g;

    /* renamed from: a */
    int[] f8915a;

    /* renamed from: b */
    Object[] f8916b;

    /* renamed from: c */
    int f8917c;

    public C3204g() {
        this.f8915a = C3195c.f8888a;
        this.f8916b = C3195c.f8890c;
        this.f8917c = 0;
    }

    /* renamed from: a */
    private static int m10568a(int[] iArr, int i, int i2) {
        try {
            return C3195c.m10532a(iArr, i, i2);
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw new ConcurrentModificationException();
        }
    }

    /* renamed from: e */
    private void m10570e(int i) {
        Class<C3204g> cls = C3204g.class;
        if (i == 8) {
            synchronized (cls) {
                if (f8913f != null) {
                    Object[] objArr = f8913f;
                    this.f8916b = objArr;
                    f8913f = (Object[]) objArr[0];
                    this.f8915a = (int[]) objArr[1];
                    objArr[1] = null;
                    objArr[0] = null;
                    f8914g--;
                    return;
                }
            }
        } else if (i == 4) {
            synchronized (cls) {
                if (f8911d != null) {
                    Object[] objArr2 = f8911d;
                    this.f8916b = objArr2;
                    f8911d = (Object[]) objArr2[0];
                    this.f8915a = (int[]) objArr2[1];
                    objArr2[1] = null;
                    objArr2[0] = null;
                    f8912e--;
                    return;
                }
            }
        }
        this.f8915a = new int[i];
        this.f8916b = new Object[(i << 1)];
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public int mo18802b(Object obj) {
        int i = this.f8917c * 2;
        Object[] objArr = this.f8916b;
        if (obj == null) {
            for (int i2 = 1; i2 < i; i2 += 2) {
                if (objArr[i2] == null) {
                    return i2 >> 1;
                }
            }
            return -1;
        }
        for (int i3 = 1; i3 < i; i3 += 2) {
            if (obj.equals(objArr[i3])) {
                return i3 >> 1;
            }
        }
        return -1;
    }

    /* renamed from: c */
    public V mo18804c(int i) {
        V[] vArr = this.f8916b;
        int i2 = i << 1;
        V v = vArr[i2 + 1];
        int i3 = this.f8917c;
        int i4 = 0;
        if (i3 <= 1) {
            m10569a(this.f8915a, (Object[]) vArr, i3);
            this.f8915a = C3195c.f8888a;
            this.f8916b = C3195c.f8890c;
        } else {
            int i5 = i3 - 1;
            int[] iArr = this.f8915a;
            int i6 = 8;
            if (iArr.length <= 8 || i3 >= iArr.length / 3) {
                if (i < i5) {
                    int[] iArr2 = this.f8915a;
                    int i7 = i + 1;
                    int i8 = i5 - i;
                    System.arraycopy(iArr2, i7, iArr2, i, i8);
                    Object[] objArr = this.f8916b;
                    System.arraycopy(objArr, i7 << 1, objArr, i2, i8 << 1);
                }
                Object[] objArr2 = this.f8916b;
                int i9 = i5 << 1;
                objArr2[i9] = null;
                objArr2[i9 + 1] = null;
            } else {
                if (i3 > 8) {
                    i6 = i3 + (i3 >> 1);
                }
                int[] iArr3 = this.f8915a;
                Object[] objArr3 = this.f8916b;
                m10570e(i6);
                if (i3 == this.f8917c) {
                    if (i > 0) {
                        System.arraycopy(iArr3, 0, this.f8915a, 0, i);
                        System.arraycopy(objArr3, 0, this.f8916b, 0, i2);
                    }
                    if (i < i5) {
                        int i10 = i + 1;
                        int i11 = i5 - i;
                        System.arraycopy(iArr3, i10, this.f8915a, i, i11);
                        System.arraycopy(objArr3, i10 << 1, this.f8916b, i2, i11 << 1);
                    }
                } else {
                    throw new ConcurrentModificationException();
                }
            }
            i4 = i5;
        }
        if (i3 == this.f8917c) {
            this.f8917c = i4;
            return v;
        }
        throw new ConcurrentModificationException();
    }

    public void clear() {
        int i = this.f8917c;
        if (i > 0) {
            int[] iArr = this.f8915a;
            Object[] objArr = this.f8916b;
            this.f8915a = C3195c.f8888a;
            this.f8916b = C3195c.f8890c;
            this.f8917c = 0;
            m10569a(iArr, objArr, i);
        }
        if (this.f8917c > 0) {
            throw new ConcurrentModificationException();
        }
    }

    public boolean containsKey(Object obj) {
        return mo18797a(obj) >= 0;
    }

    public boolean containsValue(Object obj) {
        return mo18802b(obj) >= 0;
    }

    /* renamed from: d */
    public V mo18808d(int i) {
        return this.f8916b[(i << 1) + 1];
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof C3204g) {
            C3204g gVar = (C3204g) obj;
            if (size() != gVar.size()) {
                return false;
            }
            int i = 0;
            while (i < this.f8917c) {
                try {
                    Object b = mo18803b(i);
                    Object d = mo18808d(i);
                    Object obj2 = gVar.get(b);
                    if (d == null) {
                        if (obj2 != null || !gVar.containsKey(b)) {
                            return false;
                        }
                    } else if (!d.equals(obj2)) {
                        return false;
                    }
                    i++;
                } catch (ClassCastException | NullPointerException unused) {
                    return false;
                }
            }
            return true;
        }
        if (obj instanceof Map) {
            Map map = (Map) obj;
            if (size() != map.size()) {
                return false;
            }
            int i2 = 0;
            while (i2 < this.f8917c) {
                try {
                    Object b2 = mo18803b(i2);
                    Object d2 = mo18808d(i2);
                    Object obj3 = map.get(b2);
                    if (d2 == null) {
                        if (obj3 != null || !map.containsKey(b2)) {
                            return false;
                        }
                    } else if (!d2.equals(obj3)) {
                        return false;
                    }
                    i2++;
                } catch (ClassCastException | NullPointerException unused2) {
                }
            }
            return true;
        }
        return false;
    }

    public V get(Object obj) {
        return getOrDefault(obj, (Object) null);
    }

    public V getOrDefault(Object obj, V v) {
        int a = mo18797a(obj);
        return a >= 0 ? this.f8916b[(a << 1) + 1] : v;
    }

    public int hashCode() {
        int[] iArr = this.f8915a;
        Object[] objArr = this.f8916b;
        int i = this.f8917c;
        int i2 = 1;
        int i3 = 0;
        int i4 = 0;
        while (i3 < i) {
            Object obj = objArr[i2];
            i4 += (obj == null ? 0 : obj.hashCode()) ^ iArr[i3];
            i3++;
            i2 += 2;
        }
        return i4;
    }

    public boolean isEmpty() {
        return this.f8917c <= 0;
    }

    public V put(K k, V v) {
        int i;
        int i2;
        int i3 = this.f8917c;
        if (k == null) {
            i2 = mo18796a();
            i = 0;
        } else {
            int hashCode = k.hashCode();
            i = hashCode;
            i2 = mo18798a((Object) k, hashCode);
        }
        if (i2 >= 0) {
            int i4 = (i2 << 1) + 1;
            V[] vArr = this.f8916b;
            V v2 = vArr[i4];
            vArr[i4] = v;
            return v2;
        }
        int i5 = i2 ^ -1;
        if (i3 >= this.f8915a.length) {
            int i6 = 4;
            if (i3 >= 8) {
                i6 = (i3 >> 1) + i3;
            } else if (i3 >= 4) {
                i6 = 8;
            }
            int[] iArr = this.f8915a;
            Object[] objArr = this.f8916b;
            m10570e(i6);
            if (i3 == this.f8917c) {
                int[] iArr2 = this.f8915a;
                if (iArr2.length > 0) {
                    System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                    System.arraycopy(objArr, 0, this.f8916b, 0, objArr.length);
                }
                m10569a(iArr, objArr, i3);
            } else {
                throw new ConcurrentModificationException();
            }
        }
        if (i5 < i3) {
            int[] iArr3 = this.f8915a;
            int i7 = i5 + 1;
            System.arraycopy(iArr3, i5, iArr3, i7, i3 - i5);
            Object[] objArr2 = this.f8916b;
            System.arraycopy(objArr2, i5 << 1, objArr2, i7 << 1, (this.f8917c - i5) << 1);
        }
        int i8 = this.f8917c;
        if (i3 == i8) {
            int[] iArr4 = this.f8915a;
            if (i5 < iArr4.length) {
                iArr4[i5] = i;
                Object[] objArr3 = this.f8916b;
                int i9 = i5 << 1;
                objArr3[i9] = k;
                objArr3[i9 + 1] = v;
                this.f8917c = i8 + 1;
                return null;
            }
        }
        throw new ConcurrentModificationException();
    }

    public V putIfAbsent(K k, V v) {
        V v2 = get(k);
        return v2 == null ? put(k, v) : v2;
    }

    public V remove(Object obj) {
        int a = mo18797a(obj);
        if (a >= 0) {
            return mo18804c(a);
        }
        return null;
    }

    public V replace(K k, V v) {
        int a = mo18797a((Object) k);
        if (a >= 0) {
            return mo18799a(a, v);
        }
        return null;
    }

    public int size() {
        return this.f8917c;
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f8917c * 28);
        sb.append('{');
        for (int i = 0; i < this.f8917c; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            Object b = mo18803b(i);
            if (b != this) {
                sb.append(b);
            } else {
                sb.append("(this Map)");
            }
            sb.append('=');
            Object d = mo18808d(i);
            if (d != this) {
                sb.append(d);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public int mo18798a(Object obj, int i) {
        int i2 = this.f8917c;
        if (i2 == 0) {
            return -1;
        }
        int a = m10568a(this.f8915a, i2, i);
        if (a < 0 || obj.equals(this.f8916b[a << 1])) {
            return a;
        }
        int i3 = a + 1;
        while (i3 < i2 && this.f8915a[i3] == i) {
            if (obj.equals(this.f8916b[i3 << 1])) {
                return i3;
            }
            i3++;
        }
        int i4 = a - 1;
        while (i4 >= 0 && this.f8915a[i4] == i) {
            if (obj.equals(this.f8916b[i4 << 1])) {
                return i4;
            }
            i4--;
        }
        return i3 ^ -1;
    }

    public boolean remove(Object obj, Object obj2) {
        int a = mo18797a(obj);
        if (a < 0) {
            return false;
        }
        Object d = mo18808d(a);
        if (obj2 != d && (obj2 == null || !obj2.equals(d))) {
            return false;
        }
        mo18804c(a);
        return true;
    }

    public boolean replace(K k, V v, V v2) {
        int a = mo18797a((Object) k);
        if (a < 0) {
            return false;
        }
        V d = mo18808d(a);
        if (d != v && (v == null || !v.equals(d))) {
            return false;
        }
        mo18799a(a, v2);
        return true;
    }

    public C3204g(int i) {
        if (i == 0) {
            this.f8915a = C3195c.f8888a;
            this.f8916b = C3195c.f8890c;
        } else {
            m10570e(i);
        }
        this.f8917c = 0;
    }

    /* renamed from: b */
    public K mo18803b(int i) {
        return this.f8916b[i << 1];
    }

    public C3204g(C3204g<K, V> gVar) {
        this();
        if (gVar != null) {
            mo18801a(gVar);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public int mo18796a() {
        int i = this.f8917c;
        if (i == 0) {
            return -1;
        }
        int a = m10568a(this.f8915a, i, 0);
        if (a < 0 || this.f8916b[a << 1] == null) {
            return a;
        }
        int i2 = a + 1;
        while (i2 < i && this.f8915a[i2] == 0) {
            if (this.f8916b[i2 << 1] == null) {
                return i2;
            }
            i2++;
        }
        int i3 = a - 1;
        while (i3 >= 0 && this.f8915a[i3] == 0) {
            if (this.f8916b[i3 << 1] == null) {
                return i3;
            }
            i3--;
        }
        return i2 ^ -1;
    }

    /* renamed from: a */
    private static void m10569a(int[] iArr, Object[] objArr, int i) {
        Class<C3204g> cls = C3204g.class;
        if (iArr.length == 8) {
            synchronized (cls) {
                if (f8914g < 10) {
                    objArr[0] = f8913f;
                    objArr[1] = iArr;
                    for (int i2 = (i << 1) - 1; i2 >= 2; i2--) {
                        objArr[i2] = null;
                    }
                    f8913f = objArr;
                    f8914g++;
                }
            }
        } else if (iArr.length == 4) {
            synchronized (cls) {
                if (f8912e < 10) {
                    objArr[0] = f8911d;
                    objArr[1] = iArr;
                    for (int i3 = (i << 1) - 1; i3 >= 2; i3--) {
                        objArr[i3] = null;
                    }
                    f8911d = objArr;
                    f8912e++;
                }
            }
        }
    }

    /* renamed from: a */
    public void mo18800a(int i) {
        int i2 = this.f8917c;
        int[] iArr = this.f8915a;
        if (iArr.length < i) {
            Object[] objArr = this.f8916b;
            m10570e(i);
            if (this.f8917c > 0) {
                System.arraycopy(iArr, 0, this.f8915a, 0, i2);
                System.arraycopy(objArr, 0, this.f8916b, 0, i2 << 1);
            }
            m10569a(iArr, objArr, i2);
        }
        if (this.f8917c != i2) {
            throw new ConcurrentModificationException();
        }
    }

    /* renamed from: a */
    public int mo18797a(Object obj) {
        return obj == null ? mo18796a() : mo18798a(obj, obj.hashCode());
    }

    /* renamed from: a */
    public V mo18799a(int i, V v) {
        int i2 = (i << 1) + 1;
        V[] vArr = this.f8916b;
        V v2 = vArr[i2];
        vArr[i2] = v;
        return v2;
    }

    /* renamed from: a */
    public void mo18801a(C3204g<? extends K, ? extends V> gVar) {
        int i = gVar.f8917c;
        mo18800a(this.f8917c + i);
        if (this.f8917c != 0) {
            for (int i2 = 0; i2 < i; i2++) {
                put(gVar.mo18803b(i2), gVar.mo18808d(i2));
            }
        } else if (i > 0) {
            System.arraycopy(gVar.f8915a, 0, this.f8915a, 0, i);
            System.arraycopy(gVar.f8916b, 0, this.f8916b, 0, i << 1);
            this.f8917c = i;
        }
    }
}
