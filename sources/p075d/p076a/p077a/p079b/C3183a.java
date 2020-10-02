package p075d.p076a.p077a.p079b;

import java.util.HashMap;
import java.util.Map;
import p075d.p076a.p077a.p079b.C3184b;

/* renamed from: d.a.a.b.a */
/* compiled from: FastSafeIterableMap */
public class C3183a<K, V> extends C3184b<K, V> {

    /* renamed from: e */
    private HashMap<K, C3184b.C3187c<K, V>> f8861e = new HashMap<>();

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public C3184b.C3187c<K, V> mo18644a(K k) {
        return this.f8861e.get(k);
    }

    /* renamed from: b */
    public V mo18645b(K k, V v) {
        C3184b.C3187c a = mo18644a(k);
        if (a != null) {
            return a.f8867b;
        }
        this.f8861e.put(k, mo18649a(k, v));
        return null;
    }

    public boolean contains(K k) {
        return this.f8861e.containsKey(k);
    }

    public V remove(K k) {
        V remove = super.remove(k);
        this.f8861e.remove(k);
        return remove;
    }

    /* renamed from: b */
    public Map.Entry<K, V> mo18646b(K k) {
        if (contains(k)) {
            return this.f8861e.get(k).f8869d;
        }
        return null;
    }
}
