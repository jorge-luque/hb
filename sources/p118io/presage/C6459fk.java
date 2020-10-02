package p118io.presage;

import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

/* renamed from: io.presage.fk */
final class C6459fk implements C6520hr, Serializable, Map {

    /* renamed from: a */
    public static final C6459fk f17027a = new C6459fk();
    private static final long serialVersionUID = 8246714829545688274L;

    private C6459fk() {
    }

    /* renamed from: a */
    private static Set<Map.Entry> m21342a() {
        return C6460fl.f17028a;
    }

    /* renamed from: b */
    private static Set<Object> m21343b() {
        return C6460fl.f17028a;
    }

    /* renamed from: c */
    private static Collection m21344c() {
        return C6458fj.f17026a;
    }

    private final Object readResolve() {
        return f17027a;
    }

    public final void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final boolean containsKey(Object obj) {
        return false;
    }

    public final /* bridge */ boolean containsValue(Object obj) {
        boolean z = obj instanceof Void;
        return false;
    }

    public final Set<Map.Entry> entrySet() {
        return m21342a();
    }

    public final boolean equals(Object obj) {
        return (obj instanceof Map) && ((Map) obj).isEmpty();
    }

    public final /* bridge */ Object get(Object obj) {
        return null;
    }

    public final int hashCode() {
        return 0;
    }

    public final boolean isEmpty() {
        return true;
    }

    public final Set<Object> keySet() {
        return m21343b();
    }

    public final /* synthetic */ Object put(Object obj, Object obj2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final void putAll(Map map) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final Object remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final /* bridge */ int size() {
        return 0;
    }

    public final String toString() {
        return "{}";
    }

    public final Collection values() {
        return m21344c();
    }
}
