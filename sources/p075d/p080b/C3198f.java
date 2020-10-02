package p075d.p080b;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

/* renamed from: d.b.f */
/* compiled from: MapCollections */
abstract class C3198f<K, V> {

    /* renamed from: a */
    C3198f<K, V>.C1155b f8896a;

    /* renamed from: b */
    C3198f<K, V>.c f8897b;

    /* renamed from: c */
    C3198f<K, V>.e f8898c;

    /* renamed from: d.b.f$a */
    /* compiled from: MapCollections */
    final class C3199a<T> implements Iterator<T> {

        /* renamed from: a */
        final int f8899a;

        /* renamed from: b */
        int f8900b;

        /* renamed from: c */
        int f8901c;

        /* renamed from: d */
        boolean f8902d = false;

        C3199a(int i) {
            this.f8899a = i;
            this.f8900b = C3198f.this.mo18685c();
        }

        public boolean hasNext() {
            return this.f8901c < this.f8900b;
        }

        public T next() {
            if (hasNext()) {
                T a = C3198f.this.mo18678a(this.f8901c, this.f8899a);
                this.f8901c++;
                this.f8902d = true;
                return a;
            }
            throw new NoSuchElementException();
        }

        public void remove() {
            if (this.f8902d) {
                int i = this.f8901c - 1;
                this.f8901c = i;
                this.f8900b--;
                this.f8902d = false;
                C3198f.this.mo18681a(i);
                return;
            }
            throw new IllegalStateException();
        }
    }

    /* renamed from: d.b.f$b */
    /* compiled from: MapCollections */
    final class C3200b implements Set<Map.Entry<K, V>> {
        C3200b() {
        }

        /* renamed from: a */
        public boolean mo18743a(Map.Entry<K, V> entry) {
            throw new UnsupportedOperationException();
        }

        public /* bridge */ /* synthetic */ boolean add(Object obj) {
            mo18743a((Map.Entry) obj);
            throw null;
        }

        public boolean addAll(Collection<? extends Map.Entry<K, V>> collection) {
            int c = C3198f.this.mo18685c();
            for (Map.Entry entry : collection) {
                C3198f.this.mo18682a(entry.getKey(), entry.getValue());
            }
            return c != C3198f.this.mo18685c();
        }

        public void clear() {
            C3198f.this.mo18680a();
        }

        public boolean contains(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            int a = C3198f.this.mo18677a(entry.getKey());
            if (a < 0) {
                return false;
            }
            return C3195c.m10534a(C3198f.this.mo18678a(a, 1), entry.getValue());
        }

        public boolean containsAll(Collection<?> collection) {
            for (Object contains : collection) {
                if (!contains(contains)) {
                    return false;
                }
            }
            return true;
        }

        public boolean equals(Object obj) {
            return C3198f.m10550a(this, obj);
        }

        public int hashCode() {
            int i;
            int i2;
            int i3 = 0;
            for (int c = C3198f.this.mo18685c() - 1; c >= 0; c--) {
                Object a = C3198f.this.mo18678a(c, 0);
                Object a2 = C3198f.this.mo18678a(c, 1);
                if (a == null) {
                    i = 0;
                } else {
                    i = a.hashCode();
                }
                if (a2 == null) {
                    i2 = 0;
                } else {
                    i2 = a2.hashCode();
                }
                i3 += i ^ i2;
            }
            return i3;
        }

        public boolean isEmpty() {
            return C3198f.this.mo18685c() == 0;
        }

        public Iterator<Map.Entry<K, V>> iterator() {
            return new C3202d();
        }

        public boolean remove(Object obj) {
            throw new UnsupportedOperationException();
        }

        public boolean removeAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        public boolean retainAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        public int size() {
            return C3198f.this.mo18685c();
        }

        public Object[] toArray() {
            throw new UnsupportedOperationException();
        }

        public <T> T[] toArray(T[] tArr) {
            throw new UnsupportedOperationException();
        }
    }

    /* renamed from: d.b.f$c */
    /* compiled from: MapCollections */
    final class C3201c implements Set<K> {
        C3201c() {
        }

        public boolean add(K k) {
            throw new UnsupportedOperationException();
        }

        public boolean addAll(Collection<? extends K> collection) {
            throw new UnsupportedOperationException();
        }

        public void clear() {
            C3198f.this.mo18680a();
        }

        public boolean contains(Object obj) {
            return C3198f.this.mo18677a(obj) >= 0;
        }

        public boolean containsAll(Collection<?> collection) {
            return C3198f.m10549a(C3198f.this.mo18684b(), collection);
        }

        public boolean equals(Object obj) {
            return C3198f.m10550a(this, obj);
        }

        public int hashCode() {
            int i;
            int i2 = 0;
            for (int c = C3198f.this.mo18685c() - 1; c >= 0; c--) {
                Object a = C3198f.this.mo18678a(c, 0);
                if (a == null) {
                    i = 0;
                } else {
                    i = a.hashCode();
                }
                i2 += i;
            }
            return i2;
        }

        public boolean isEmpty() {
            return C3198f.this.mo18685c() == 0;
        }

        public Iterator<K> iterator() {
            return new C3199a(0);
        }

        public boolean remove(Object obj) {
            int a = C3198f.this.mo18677a(obj);
            if (a < 0) {
                return false;
            }
            C3198f.this.mo18681a(a);
            return true;
        }

        public boolean removeAll(Collection<?> collection) {
            return C3198f.m10551b(C3198f.this.mo18684b(), collection);
        }

        public boolean retainAll(Collection<?> collection) {
            return C3198f.m10552c(C3198f.this.mo18684b(), collection);
        }

        public int size() {
            return C3198f.this.mo18685c();
        }

        public Object[] toArray() {
            return C3198f.this.mo18736b(0);
        }

        public <T> T[] toArray(T[] tArr) {
            return C3198f.this.mo18735a(tArr, 0);
        }
    }

    /* renamed from: d.b.f$d */
    /* compiled from: MapCollections */
    final class C3202d implements Iterator<Map.Entry<K, V>>, Map.Entry<K, V> {

        /* renamed from: a */
        int f8906a;

        /* renamed from: b */
        int f8907b;

        /* renamed from: c */
        boolean f8908c = false;

        C3202d() {
            this.f8906a = C3198f.this.mo18685c() - 1;
            this.f8907b = -1;
        }

        public boolean equals(Object obj) {
            if (!this.f8908c) {
                throw new IllegalStateException("This container does not support retaining Map.Entry objects");
            } else if (!(obj instanceof Map.Entry)) {
                return false;
            } else {
                Map.Entry entry = (Map.Entry) obj;
                if (!C3195c.m10534a(entry.getKey(), C3198f.this.mo18678a(this.f8907b, 0)) || !C3195c.m10534a(entry.getValue(), C3198f.this.mo18678a(this.f8907b, 1))) {
                    return false;
                }
                return true;
            }
        }

        public K getKey() {
            if (this.f8908c) {
                return C3198f.this.mo18678a(this.f8907b, 0);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public V getValue() {
            if (this.f8908c) {
                return C3198f.this.mo18678a(this.f8907b, 1);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public boolean hasNext() {
            return this.f8907b < this.f8906a;
        }

        public int hashCode() {
            int i;
            if (this.f8908c) {
                int i2 = 0;
                Object a = C3198f.this.mo18678a(this.f8907b, 0);
                Object a2 = C3198f.this.mo18678a(this.f8907b, 1);
                if (a == null) {
                    i = 0;
                } else {
                    i = a.hashCode();
                }
                if (a2 != null) {
                    i2 = a2.hashCode();
                }
                return i ^ i2;
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public void remove() {
            if (this.f8908c) {
                C3198f.this.mo18681a(this.f8907b);
                this.f8907b--;
                this.f8906a--;
                this.f8908c = false;
                return;
            }
            throw new IllegalStateException();
        }

        public V setValue(V v) {
            if (this.f8908c) {
                return C3198f.this.mo18679a(this.f8907b, v);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public String toString() {
            return getKey() + "=" + getValue();
        }

        public Map.Entry<K, V> next() {
            if (hasNext()) {
                this.f8907b++;
                this.f8908c = true;
                return this;
            }
            throw new NoSuchElementException();
        }
    }

    /* renamed from: d.b.f$e */
    /* compiled from: MapCollections */
    final class C3203e implements Collection<V> {
        C3203e() {
        }

        public boolean add(V v) {
            throw new UnsupportedOperationException();
        }

        public boolean addAll(Collection<? extends V> collection) {
            throw new UnsupportedOperationException();
        }

        public void clear() {
            C3198f.this.mo18680a();
        }

        public boolean contains(Object obj) {
            return C3198f.this.mo18683b(obj) >= 0;
        }

        public boolean containsAll(Collection<?> collection) {
            for (Object contains : collection) {
                if (!contains(contains)) {
                    return false;
                }
            }
            return true;
        }

        public boolean isEmpty() {
            return C3198f.this.mo18685c() == 0;
        }

        public Iterator<V> iterator() {
            return new C3199a(1);
        }

        public boolean remove(Object obj) {
            int b = C3198f.this.mo18683b(obj);
            if (b < 0) {
                return false;
            }
            C3198f.this.mo18681a(b);
            return true;
        }

        public boolean removeAll(Collection<?> collection) {
            int c = C3198f.this.mo18685c();
            int i = 0;
            boolean z = false;
            while (i < c) {
                if (collection.contains(C3198f.this.mo18678a(i, 1))) {
                    C3198f.this.mo18681a(i);
                    i--;
                    c--;
                    z = true;
                }
                i++;
            }
            return z;
        }

        public boolean retainAll(Collection<?> collection) {
            int c = C3198f.this.mo18685c();
            int i = 0;
            boolean z = false;
            while (i < c) {
                if (!collection.contains(C3198f.this.mo18678a(i, 1))) {
                    C3198f.this.mo18681a(i);
                    i--;
                    c--;
                    z = true;
                }
                i++;
            }
            return z;
        }

        public int size() {
            return C3198f.this.mo18685c();
        }

        public Object[] toArray() {
            return C3198f.this.mo18736b(1);
        }

        public <T> T[] toArray(T[] tArr) {
            return C3198f.this.mo18735a(tArr, 1);
        }
    }

    C3198f() {
    }

    /* renamed from: a */
    public static <K, V> boolean m10549a(Map<K, V> map, Collection<?> collection) {
        for (Object containsKey : collection) {
            if (!map.containsKey(containsKey)) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: b */
    public static <K, V> boolean m10551b(Map<K, V> map, Collection<?> collection) {
        int size = map.size();
        for (Object remove : collection) {
            map.remove(remove);
        }
        return size != map.size();
    }

    /* renamed from: c */
    public static <K, V> boolean m10552c(Map<K, V> map, Collection<?> collection) {
        int size = map.size();
        Iterator<K> it = map.keySet().iterator();
        while (it.hasNext()) {
            if (!collection.contains(it.next())) {
                it.remove();
            }
        }
        return size != map.size();
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract int mo18677a(Object obj);

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract Object mo18678a(int i, int i2);

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract V mo18679a(int i, V v);

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract void mo18680a();

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract void mo18681a(int i);

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract void mo18682a(K k, V v);

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public abstract int mo18683b(Object obj);

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public abstract Map<K, V> mo18684b();

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public abstract int mo18685c();

    /* renamed from: d */
    public Set<Map.Entry<K, V>> mo18737d() {
        if (this.f8896a == null) {
            this.f8896a = new C3200b();
        }
        return this.f8896a;
    }

    /* renamed from: e */
    public Set<K> mo18738e() {
        if (this.f8897b == null) {
            this.f8897b = new C3201c();
        }
        return this.f8897b;
    }

    /* renamed from: f */
    public Collection<V> mo18739f() {
        if (this.f8898c == null) {
            this.f8898c = new C3203e();
        }
        return this.f8898c;
    }

    /* renamed from: a */
    public <T> T[] mo18735a(T[] tArr, int i) {
        int c = mo18685c();
        if (tArr.length < c) {
            tArr = (Object[]) Array.newInstance(tArr.getClass().getComponentType(), c);
        }
        for (int i2 = 0; i2 < c; i2++) {
            tArr[i2] = mo18678a(i2, i);
        }
        if (tArr.length > c) {
            tArr[c] = null;
        }
        return tArr;
    }

    /* renamed from: b */
    public Object[] mo18736b(int i) {
        int c = mo18685c();
        Object[] objArr = new Object[c];
        for (int i2 = 0; i2 < c; i2++) {
            objArr[i2] = mo18678a(i2, i);
        }
        return objArr;
    }

    /* renamed from: a */
    public static <T> boolean m10550a(Set<T> set, Object obj) {
        if (set == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set2 = (Set) obj;
            try {
                if (set.size() != set2.size() || !set.containsAll(set2)) {
                    return false;
                }
                return true;
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
        return false;
    }
}
