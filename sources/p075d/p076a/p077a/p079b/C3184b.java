package p075d.p076a.p077a.p079b;

import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

/* renamed from: d.a.a.b.b */
/* compiled from: SafeIterableMap */
public class C3184b<K, V> implements Iterable<Map.Entry<K, V>> {

    /* renamed from: a */
    C3187c<K, V> f8862a;

    /* renamed from: b */
    private C3187c<K, V> f8863b;

    /* renamed from: c */
    private WeakHashMap<C3190f<K, V>, Boolean> f8864c = new WeakHashMap<>();

    /* renamed from: d */
    private int f8865d = 0;

    /* renamed from: d.a.a.b.b$a */
    /* compiled from: SafeIterableMap */
    static class C3185a<K, V> extends C3189e<K, V> {
        C3185a(C3187c<K, V> cVar, C3187c<K, V> cVar2) {
            super(cVar, cVar2);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public C3187c<K, V> mo18659b(C3187c<K, V> cVar) {
            return cVar.f8869d;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: c */
        public C3187c<K, V> mo18660c(C3187c<K, V> cVar) {
            return cVar.f8868c;
        }
    }

    /* renamed from: d.a.a.b.b$b */
    /* compiled from: SafeIterableMap */
    private static class C3186b<K, V> extends C3189e<K, V> {
        C3186b(C3187c<K, V> cVar, C3187c<K, V> cVar2) {
            super(cVar, cVar2);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public C3187c<K, V> mo18659b(C3187c<K, V> cVar) {
            return cVar.f8868c;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: c */
        public C3187c<K, V> mo18660c(C3187c<K, V> cVar) {
            return cVar.f8869d;
        }
    }

    /* renamed from: d.a.a.b.b$c */
    /* compiled from: SafeIterableMap */
    static class C3187c<K, V> implements Map.Entry<K, V> {

        /* renamed from: a */
        final K f8866a;

        /* renamed from: b */
        final V f8867b;

        /* renamed from: c */
        C3187c<K, V> f8868c;

        /* renamed from: d */
        C3187c<K, V> f8869d;

        C3187c(K k, V v) {
            this.f8866a = k;
            this.f8867b = v;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof C3187c)) {
                return false;
            }
            C3187c cVar = (C3187c) obj;
            if (!this.f8866a.equals(cVar.f8866a) || !this.f8867b.equals(cVar.f8867b)) {
                return false;
            }
            return true;
        }

        public K getKey() {
            return this.f8866a;
        }

        public V getValue() {
            return this.f8867b;
        }

        public int hashCode() {
            return this.f8866a.hashCode() ^ this.f8867b.hashCode();
        }

        public V setValue(V v) {
            throw new UnsupportedOperationException("An entry modification is not supported");
        }

        public String toString() {
            return this.f8866a + "=" + this.f8867b;
        }
    }

    /* renamed from: d.a.a.b.b$d */
    /* compiled from: SafeIterableMap */
    private class C3188d implements Iterator<Map.Entry<K, V>>, C3190f<K, V> {

        /* renamed from: a */
        private C3187c<K, V> f8870a;

        /* renamed from: b */
        private boolean f8871b = true;

        C3188d() {
        }

        /* renamed from: a */
        public void mo18667a(C3187c<K, V> cVar) {
            C3187c<K, V> cVar2 = this.f8870a;
            if (cVar == cVar2) {
                C3187c<K, V> cVar3 = cVar2.f8869d;
                this.f8870a = cVar3;
                this.f8871b = cVar3 == null;
            }
        }

        public boolean hasNext() {
            if (!this.f8871b) {
                C3187c<K, V> cVar = this.f8870a;
                if (cVar == null || cVar.f8868c == null) {
                    return false;
                }
                return true;
            } else if (C3184b.this.f8862a != null) {
                return true;
            } else {
                return false;
            }
        }

        public Map.Entry<K, V> next() {
            if (this.f8871b) {
                this.f8871b = false;
                this.f8870a = C3184b.this.f8862a;
            } else {
                C3187c<K, V> cVar = this.f8870a;
                this.f8870a = cVar != null ? cVar.f8868c : null;
            }
            return this.f8870a;
        }
    }

    /* renamed from: d.a.a.b.b$e */
    /* compiled from: SafeIterableMap */
    private static abstract class C3189e<K, V> implements Iterator<Map.Entry<K, V>>, C3190f<K, V> {

        /* renamed from: a */
        C3187c<K, V> f8873a;

        /* renamed from: b */
        C3187c<K, V> f8874b;

        C3189e(C3187c<K, V> cVar, C3187c<K, V> cVar2) {
            this.f8873a = cVar2;
            this.f8874b = cVar;
        }

        /* renamed from: a */
        public void mo18667a(C3187c<K, V> cVar) {
            if (this.f8873a == cVar && cVar == this.f8874b) {
                this.f8874b = null;
                this.f8873a = null;
            }
            C3187c<K, V> cVar2 = this.f8873a;
            if (cVar2 == cVar) {
                this.f8873a = mo18659b(cVar2);
            }
            if (this.f8874b == cVar) {
                this.f8874b = m10498a();
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public abstract C3187c<K, V> mo18659b(C3187c<K, V> cVar);

        /* access modifiers changed from: package-private */
        /* renamed from: c */
        public abstract C3187c<K, V> mo18660c(C3187c<K, V> cVar);

        public boolean hasNext() {
            return this.f8874b != null;
        }

        public Map.Entry<K, V> next() {
            C3187c<K, V> cVar = this.f8874b;
            this.f8874b = m10498a();
            return cVar;
        }

        /* renamed from: a */
        private C3187c<K, V> m10498a() {
            C3187c<K, V> cVar = this.f8874b;
            C3187c<K, V> cVar2 = this.f8873a;
            if (cVar == cVar2 || cVar2 == null) {
                return null;
            }
            return mo18660c(cVar);
        }
    }

    /* renamed from: d.a.a.b.b$f */
    /* compiled from: SafeIterableMap */
    interface C3190f<K, V> {
        /* renamed from: a */
        void mo18667a(C3187c<K, V> cVar);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public C3187c<K, V> mo18644a(K k) {
        C3187c<K, V> cVar = this.f8862a;
        while (cVar != null && !cVar.f8866a.equals(k)) {
            cVar = cVar.f8868c;
        }
        return cVar;
    }

    /* renamed from: b */
    public V mo18645b(K k, V v) {
        C3187c a = mo18644a(k);
        if (a != null) {
            return a.f8867b;
        }
        mo18649a(k, v);
        return null;
    }

    /* renamed from: c */
    public C3184b<K, V>.d mo18652c() {
        C3184b<K, V>.d dVar = new C3188d();
        this.f8864c.put(dVar, false);
        return dVar;
    }

    /* renamed from: d */
    public Map.Entry<K, V> mo18653d() {
        return this.f8863b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C3184b)) {
            return false;
        }
        C3184b bVar = (C3184b) obj;
        if (size() != bVar.size()) {
            return false;
        }
        Iterator it = iterator();
        Iterator it2 = bVar.iterator();
        while (it.hasNext() && it2.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Object next = it2.next();
            if ((entry == null && next != null) || (entry != null && !entry.equals(next))) {
                return false;
            }
        }
        if (it.hasNext() || it2.hasNext()) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        Iterator it = iterator();
        int i = 0;
        while (it.hasNext()) {
            i += ((Map.Entry) it.next()).hashCode();
        }
        return i;
    }

    public Iterator<Map.Entry<K, V>> iterator() {
        C3185a aVar = new C3185a(this.f8862a, this.f8863b);
        this.f8864c.put(aVar, false);
        return aVar;
    }

    public V remove(K k) {
        C3187c a = mo18644a(k);
        if (a == null) {
            return null;
        }
        this.f8865d--;
        if (!this.f8864c.isEmpty()) {
            for (C3190f<K, V> a2 : this.f8864c.keySet()) {
                a2.mo18667a(a);
            }
        }
        C3187c<K, V> cVar = a.f8869d;
        if (cVar != null) {
            cVar.f8868c = a.f8868c;
        } else {
            this.f8862a = a.f8868c;
        }
        C3187c<K, V> cVar2 = a.f8868c;
        if (cVar2 != null) {
            cVar2.f8869d = a.f8869d;
        } else {
            this.f8863b = a.f8869d;
        }
        a.f8868c = null;
        a.f8869d = null;
        return a.f8867b;
    }

    public int size() {
        return this.f8865d;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Iterator it = iterator();
        while (it.hasNext()) {
            sb.append(((Map.Entry) it.next()).toString());
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public C3187c<K, V> mo18649a(K k, V v) {
        C3187c<K, V> cVar = new C3187c<>(k, v);
        this.f8865d++;
        C3187c<K, V> cVar2 = this.f8863b;
        if (cVar2 == null) {
            this.f8862a = cVar;
            this.f8863b = cVar;
            return cVar;
        }
        cVar2.f8868c = cVar;
        cVar.f8869d = cVar2;
        this.f8863b = cVar;
        return cVar;
    }

    /* renamed from: b */
    public Map.Entry<K, V> mo18651b() {
        return this.f8862a;
    }

    /* renamed from: a */
    public Iterator<Map.Entry<K, V>> mo18650a() {
        C3186b bVar = new C3186b(this.f8863b, this.f8862a);
        this.f8864c.put(bVar, false);
        return bVar;
    }
}
