package p118io.presage;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

/* renamed from: io.presage.fl */
public final class C6460fl implements C6520hr, Serializable, Set {

    /* renamed from: a */
    public static final C6460fl f17028a = new C6460fl();
    private static final long serialVersionUID = 3406603774387020532L;

    private C6460fl() {
    }

    private final Object readResolve() {
        return f17028a;
    }

    public final /* synthetic */ boolean add(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final boolean addAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final /* bridge */ boolean contains(Object obj) {
        boolean z = obj instanceof Void;
        return false;
    }

    public final boolean containsAll(Collection collection) {
        return collection.isEmpty();
    }

    public final boolean equals(Object obj) {
        return (obj instanceof Set) && ((Set) obj).isEmpty();
    }

    public final int hashCode() {
        return 0;
    }

    public final boolean isEmpty() {
        return true;
    }

    public final Iterator iterator() {
        return C6457fi.f17025a;
    }

    public final boolean remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final boolean removeAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final boolean retainAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final /* bridge */ int size() {
        return 0;
    }

    public final Object[] toArray() {
        return C6510hh.m21408a(this);
    }

    public final <T> T[] toArray(T[] tArr) {
        return C6510hh.m21409a(this, tArr);
    }

    public final String toString() {
        return "[]";
    }
}
