package com.google.protobuf;

import com.google.protobuf.C4019l;
import java.lang.Comparable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

/* renamed from: com.google.protobuf.a0 */
/* compiled from: SmallSortedMap */
class C3972a0<K extends Comparable<K>, V> extends AbstractMap<K, V> {

    /* renamed from: a */
    private final int f10728a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public List<C3972a0<K, V>.c> f10729b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public Map<K, V> f10730c;

    /* renamed from: d */
    private boolean f10731d;

    /* renamed from: e */
    private volatile C3972a0<K, V>.e f10732e;

    /* renamed from: com.google.protobuf.a0$a */
    /* compiled from: SmallSortedMap */
    static class C3973a extends C3972a0<FieldDescriptorType, Object> {
        C3973a(int i) {
            super(i, (C3973a) null);
        }

        /* renamed from: e */
        public void mo28035e() {
            if (!mo28034d()) {
                for (int i = 0; i < mo28027a(); i++) {
                    Map.Entry a = mo28029a(i);
                    if (((C4019l.C4021b) a.getKey()).mo28178p()) {
                        a.setValue(Collections.unmodifiableList((List) a.getValue()));
                    }
                }
                for (Map.Entry entry : mo28031c()) {
                    if (((C4019l.C4021b) entry.getKey()).mo28178p()) {
                        entry.setValue(Collections.unmodifiableList((List) entry.getValue()));
                    }
                }
            }
            C3972a0.super.mo28035e();
        }

        public /* bridge */ /* synthetic */ Object put(Object obj, Object obj2) {
            return C3972a0.super.put((C4019l.C4021b) obj, obj2);
        }
    }

    /* renamed from: com.google.protobuf.a0$b */
    /* compiled from: SmallSortedMap */
    private static class C3974b {
        /* access modifiers changed from: private */

        /* renamed from: a */
        public static final Iterator<Object> f10733a = new C3975a();

        /* renamed from: b */
        private static final Iterable<Object> f10734b = new C3976b();

        /* renamed from: com.google.protobuf.a0$b$a */
        /* compiled from: SmallSortedMap */
        static class C3975a implements Iterator<Object> {
            C3975a() {
            }

            public boolean hasNext() {
                return false;
            }

            public Object next() {
                throw new NoSuchElementException();
            }

            public void remove() {
                throw new UnsupportedOperationException();
            }
        }

        /* renamed from: com.google.protobuf.a0$b$b */
        /* compiled from: SmallSortedMap */
        static class C3976b implements Iterable<Object> {
            C3976b() {
            }

            public Iterator<Object> iterator() {
                return C3974b.f10733a;
            }
        }

        /* renamed from: b */
        static <T> Iterable<T> m13240b() {
            return f10734b;
        }
    }

    /* renamed from: com.google.protobuf.a0$c */
    /* compiled from: SmallSortedMap */
    private class C3977c implements Map.Entry<K, V>, Comparable<C3972a0<K, V>.c> {

        /* renamed from: a */
        private final K f10735a;

        /* renamed from: b */
        private V f10736b;

        C3977c(C3972a0 a0Var, Map.Entry<K, V> entry) {
            this((Comparable) entry.getKey(), entry.getValue());
        }

        /* renamed from: a */
        public int compareTo(C3972a0<K, V>.c cVar) {
            return getKey().compareTo(cVar.getKey());
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            if (!m13241a(this.f10735a, entry.getKey()) || !m13241a(this.f10736b, entry.getValue())) {
                return false;
            }
            return true;
        }

        public V getValue() {
            return this.f10736b;
        }

        public int hashCode() {
            K k = this.f10735a;
            int i = 0;
            int hashCode = k == null ? 0 : k.hashCode();
            V v = this.f10736b;
            if (v != null) {
                i = v.hashCode();
            }
            return hashCode ^ i;
        }

        public V setValue(V v) {
            C3972a0.this.m13228f();
            V v2 = this.f10736b;
            this.f10736b = v;
            return v2;
        }

        public String toString() {
            return this.f10735a + "=" + this.f10736b;
        }

        C3977c(K k, V v) {
            this.f10735a = k;
            this.f10736b = v;
        }

        /* renamed from: a */
        private boolean m13241a(Object obj, Object obj2) {
            if (obj == null) {
                return obj2 == null;
            }
            return obj.equals(obj2);
        }

        public K getKey() {
            return this.f10735a;
        }
    }

    /* renamed from: com.google.protobuf.a0$d */
    /* compiled from: SmallSortedMap */
    private class C3978d implements Iterator<Map.Entry<K, V>> {

        /* renamed from: a */
        private int f10738a;

        /* renamed from: b */
        private boolean f10739b;

        /* renamed from: c */
        private Iterator<Map.Entry<K, V>> f10740c;

        private C3978d() {
            this.f10738a = -1;
        }

        /* renamed from: a */
        private Iterator<Map.Entry<K, V>> m13243a() {
            if (this.f10740c == null) {
                this.f10740c = C3972a0.this.f10730c.entrySet().iterator();
            }
            return this.f10740c;
        }

        public boolean hasNext() {
            if (this.f10738a + 1 < C3972a0.this.f10729b.size() || m13243a().hasNext()) {
                return true;
            }
            return false;
        }

        public void remove() {
            if (this.f10739b) {
                this.f10739b = false;
                C3972a0.this.m13228f();
                if (this.f10738a < C3972a0.this.f10729b.size()) {
                    C3972a0 a0Var = C3972a0.this;
                    int i = this.f10738a;
                    this.f10738a = i - 1;
                    Object unused = a0Var.m13226c(i);
                    return;
                }
                m13243a().remove();
                return;
            }
            throw new IllegalStateException("remove() was called before next()");
        }

        public Map.Entry<K, V> next() {
            this.f10739b = true;
            int i = this.f10738a + 1;
            this.f10738a = i;
            if (i < C3972a0.this.f10729b.size()) {
                return (Map.Entry) C3972a0.this.f10729b.get(this.f10738a);
            }
            return (Map.Entry) m13243a().next();
        }

        /* synthetic */ C3978d(C3972a0 a0Var, C3973a aVar) {
            this();
        }
    }

    /* renamed from: com.google.protobuf.a0$e */
    /* compiled from: SmallSortedMap */
    private class C3979e extends AbstractSet<Map.Entry<K, V>> {
        private C3979e() {
        }

        /* renamed from: a */
        public boolean add(Map.Entry<K, V> entry) {
            if (contains(entry)) {
                return false;
            }
            C3972a0.this.put((Comparable) entry.getKey(), entry.getValue());
            return true;
        }

        public void clear() {
            C3972a0.this.clear();
        }

        public boolean contains(Object obj) {
            Map.Entry entry = (Map.Entry) obj;
            Object obj2 = C3972a0.this.get(entry.getKey());
            Object value = entry.getValue();
            return obj2 == value || (obj2 != null && obj2.equals(value));
        }

        public Iterator<Map.Entry<K, V>> iterator() {
            return new C3978d(C3972a0.this, (C3973a) null);
        }

        public boolean remove(Object obj) {
            Map.Entry entry = (Map.Entry) obj;
            if (!contains(entry)) {
                return false;
            }
            C3972a0.this.remove(entry.getKey());
            return true;
        }

        public int size() {
            return C3972a0.this.size();
        }

        /* synthetic */ C3979e(C3972a0 a0Var, C3973a aVar) {
            this();
        }
    }

    /* synthetic */ C3972a0(int i, C3973a aVar) {
        this(i);
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public void m13228f() {
        if (this.f10731d) {
            throw new UnsupportedOperationException();
        }
    }

    /* renamed from: g */
    private void m13229g() {
        m13228f();
        if (this.f10729b.isEmpty() && !(this.f10729b instanceof ArrayList)) {
            this.f10729b = new ArrayList(this.f10728a);
        }
    }

    /* renamed from: h */
    private SortedMap<K, V> m13230h() {
        m13228f();
        if (this.f10730c.isEmpty() && !(this.f10730c instanceof TreeMap)) {
            this.f10730c = new TreeMap();
        }
        return (SortedMap) this.f10730c;
    }

    public void clear() {
        m13228f();
        if (!this.f10729b.isEmpty()) {
            this.f10729b.clear();
        }
        if (!this.f10730c.isEmpty()) {
            this.f10730c.clear();
        }
    }

    public boolean containsKey(Object obj) {
        Comparable comparable = (Comparable) obj;
        return m13221a(comparable) >= 0 || this.f10730c.containsKey(comparable);
    }

    /* renamed from: d */
    public boolean mo28034d() {
        return this.f10731d;
    }

    /* renamed from: e */
    public void mo28035e() {
        Map<K, V> map;
        if (!this.f10731d) {
            if (this.f10730c.isEmpty()) {
                map = Collections.emptyMap();
            } else {
                map = Collections.unmodifiableMap(this.f10730c);
            }
            this.f10730c = map;
            this.f10731d = true;
        }
    }

    public Set<Map.Entry<K, V>> entrySet() {
        if (this.f10732e == null) {
            this.f10732e = new C3979e(this, (C3973a) null);
        }
        return this.f10732e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C3972a0)) {
            return super.equals(obj);
        }
        C3972a0 a0Var = (C3972a0) obj;
        int size = size();
        if (size != a0Var.size()) {
            return false;
        }
        int a = mo28027a();
        if (a != a0Var.mo28027a()) {
            return entrySet().equals(a0Var.entrySet());
        }
        for (int i = 0; i < a; i++) {
            if (!mo28029a(i).equals(a0Var.mo28029a(i))) {
                return false;
            }
        }
        if (a != size) {
            return this.f10730c.equals(a0Var.f10730c);
        }
        return true;
    }

    public V get(Object obj) {
        Comparable comparable = (Comparable) obj;
        int a = m13221a(comparable);
        if (a >= 0) {
            return this.f10729b.get(a).getValue();
        }
        return this.f10730c.get(comparable);
    }

    public int hashCode() {
        int a = mo28027a();
        int i = 0;
        for (int i2 = 0; i2 < a; i2++) {
            i += this.f10729b.get(i2).hashCode();
        }
        return mo28030b() > 0 ? i + this.f10730c.hashCode() : i;
    }

    public V remove(Object obj) {
        m13228f();
        Comparable comparable = (Comparable) obj;
        int a = m13221a(comparable);
        if (a >= 0) {
            return m13226c(a);
        }
        if (this.f10730c.isEmpty()) {
            return null;
        }
        return this.f10730c.remove(comparable);
    }

    public int size() {
        return this.f10729b.size() + this.f10730c.size();
    }

    private C3972a0(int i) {
        this.f10728a = i;
        this.f10729b = Collections.emptyList();
        this.f10730c = Collections.emptyMap();
    }

    /* renamed from: b */
    static <FieldDescriptorType extends C4019l.C4021b<FieldDescriptorType>> C3972a0<FieldDescriptorType, Object> m13224b(int i) {
        return new C3973a(i);
    }

    /* renamed from: c */
    public Iterable<Map.Entry<K, V>> mo28031c() {
        if (this.f10730c.isEmpty()) {
            return C3974b.m13240b();
        }
        return this.f10730c.entrySet();
    }

    /* renamed from: a */
    public int mo28027a() {
        return this.f10729b.size();
    }

    /* renamed from: b */
    public int mo28030b() {
        return this.f10730c.size();
    }

    /* renamed from: a */
    public Map.Entry<K, V> mo28029a(int i) {
        return this.f10729b.get(i);
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public V m13226c(int i) {
        m13228f();
        V value = this.f10729b.remove(i).getValue();
        if (!this.f10730c.isEmpty()) {
            Iterator it = m13230h().entrySet().iterator();
            this.f10729b.add(new C3977c(this, (Map.Entry) it.next()));
            it.remove();
        }
        return value;
    }

    /* renamed from: a */
    public V put(K k, V v) {
        m13228f();
        int a = m13221a(k);
        if (a >= 0) {
            return this.f10729b.get(a).setValue(v);
        }
        m13229g();
        int i = -(a + 1);
        if (i >= this.f10728a) {
            return m13230h().put(k, v);
        }
        int size = this.f10729b.size();
        int i2 = this.f10728a;
        if (size == i2) {
            C3977c remove = this.f10729b.remove(i2 - 1);
            m13230h().put(remove.getKey(), remove.getValue());
        }
        this.f10729b.add(i, new C3977c(k, v));
        return null;
    }

    /* renamed from: a */
    private int m13221a(K k) {
        int size = this.f10729b.size() - 1;
        if (size >= 0) {
            int compareTo = k.compareTo(this.f10729b.get(size).getKey());
            if (compareTo > 0) {
                return -(size + 2);
            }
            if (compareTo == 0) {
                return size;
            }
        }
        int i = 0;
        while (i <= size) {
            int i2 = (i + size) / 2;
            int compareTo2 = k.compareTo(this.f10729b.get(i2).getKey());
            if (compareTo2 < 0) {
                size = i2 - 1;
            } else if (compareTo2 <= 0) {
                return i2;
            } else {
                i = i2 + 1;
            }
        }
        return -(i + 1);
    }
}
