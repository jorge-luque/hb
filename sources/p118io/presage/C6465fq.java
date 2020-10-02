package p118io.presage;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* renamed from: io.presage.fq */
class C6465fq extends C6464fp {
    /* renamed from: a */
    public static final <K, V> Map<K, V> m21349a() {
        C6459fk fkVar = C6459fk.f17027a;
        if (fkVar != null) {
            return fkVar;
        }
        throw new C6434em("null cannot be cast to non-null type kotlin.collections.Map<K, V>");
    }

    /* renamed from: a */
    public static final <K, V> void m21352a(Map<? super K, ? super V> map, Iterable<? extends C6431ej<? extends K, ? extends V>> iterable) {
        for (C6431ej ejVar : iterable) {
            map.put(ejVar.mo35395c(), ejVar.mo35396d());
        }
    }

    /* renamed from: a */
    public static final <K, V> Map<K, V> m21350a(Iterable<? extends C6431ej<? extends K, ? extends V>> iterable) {
        Collection collection = (Collection) iterable;
        int size = collection.size();
        if (size == 0) {
            return m21349a();
        }
        if (size != 1) {
            return m21351a(iterable, new LinkedHashMap(C6464fp.m21347a(collection.size())));
        }
        return C6464fp.m21348a((C6431ej) ((List) iterable).get(0));
    }

    /* renamed from: a */
    public static final <K, V, M extends Map<? super K, ? super V>> M m21351a(Iterable<? extends C6431ej<? extends K, ? extends V>> iterable, M m) {
        m21352a(m, iterable);
        return m;
    }
}
