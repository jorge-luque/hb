package p075d.p080b;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/* renamed from: d.b.a */
/* compiled from: ArrayMap */
public class C3191a<K, V> extends C3204g<K, V> implements Map<K, V> {

    /* renamed from: h */
    C3198f<K, V> f8875h;

    /* renamed from: d.b.a$a */
    /* compiled from: ArrayMap */
    class C3192a extends C3198f<K, V> {
        C3192a() {
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public Object mo18678a(int i, int i2) {
            return C3191a.this.f8916b[(i << 1) + i2];
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public int mo18683b(Object obj) {
            return C3191a.this.mo18802b(obj);
        }

        /* access modifiers changed from: protected */
        /* renamed from: c */
        public int mo18685c() {
            return C3191a.this.f8917c;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public int mo18677a(Object obj) {
            return C3191a.this.mo18797a(obj);
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public Map<K, V> mo18684b() {
            return C3191a.this;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo18682a(K k, V v) {
            C3191a.this.put(k, v);
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public V mo18679a(int i, V v) {
            return C3191a.this.mo18799a(i, v);
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo18681a(int i) {
            C3191a.this.mo18804c(i);
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo18680a() {
            C3191a.this.clear();
        }
    }

    public C3191a() {
    }

    /* renamed from: b */
    private C3198f<K, V> m10503b() {
        if (this.f8875h == null) {
            this.f8875h = new C3192a();
        }
        return this.f8875h;
    }

    /* renamed from: a */
    public boolean mo18672a(Collection<?> collection) {
        return C3198f.m10552c(this, collection);
    }

    public Set<Map.Entry<K, V>> entrySet() {
        return m10503b().mo18737d();
    }

    public Set<K> keySet() {
        return m10503b().mo18738e();
    }

    public void putAll(Map<? extends K, ? extends V> map) {
        mo18800a(this.f8917c + map.size());
        for (Map.Entry next : map.entrySet()) {
            put(next.getKey(), next.getValue());
        }
    }

    public Collection<V> values() {
        return m10503b().mo18739f();
    }

    public C3191a(int i) {
        super(i);
    }
}
