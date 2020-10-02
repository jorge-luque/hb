package p118io.presage;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* renamed from: io.presage.fj */
public final class C6458fj implements C6520hr, Serializable, List, RandomAccess {

    /* renamed from: a */
    public static final C6458fj f17026a = new C6458fj();
    private static final long serialVersionUID = -7390468764508069838L;

    private C6458fj() {
    }

    /* renamed from: a */
    private static Void m21341a(int i) {
        throw new IndexOutOfBoundsException("Empty list doesn't contain element at index " + i + '.');
    }

    private final Object readResolve() {
        return f17026a;
    }

    public final /* synthetic */ void add(int i, Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final /* synthetic */ boolean add(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final boolean addAll(int i, Collection collection) {
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
        return (obj instanceof List) && ((List) obj).isEmpty();
    }

    public final /* synthetic */ Object get(int i) {
        return m21341a(i);
    }

    public final int hashCode() {
        return 1;
    }

    public final /* bridge */ int indexOf(Object obj) {
        boolean z = obj instanceof Void;
        return -1;
    }

    public final boolean isEmpty() {
        return true;
    }

    public final Iterator iterator() {
        return C6457fi.f17025a;
    }

    public final /* bridge */ int lastIndexOf(Object obj) {
        boolean z = obj instanceof Void;
        return -1;
    }

    public final ListIterator listIterator() {
        return C6457fi.f17025a;
    }

    public final /* synthetic */ Object remove(int i) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
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

    public final /* synthetic */ Object set(int i, Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final /* bridge */ int size() {
        return 0;
    }

    public final List subList(int i, int i2) {
        if (i == 0 && i2 == 0) {
            return this;
        }
        throw new IndexOutOfBoundsException("fromIndex: " + i + ", toIndex: " + i2);
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

    public final ListIterator listIterator(int i) {
        if (i == 0) {
            return C6457fi.f17025a;
        }
        throw new IndexOutOfBoundsException("Index: ".concat(String.valueOf(i)));
    }
}
