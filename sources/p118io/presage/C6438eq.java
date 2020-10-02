package p118io.presage;

import java.util.Collection;
import java.util.Iterator;

/* renamed from: io.presage.eq */
final class C6438eq<T> implements C6520hr, Collection<T> {

    /* renamed from: a */
    private final T[] f17018a;

    /* renamed from: b */
    private final boolean f17019b = false;

    public C6438eq(T[] tArr) {
        this.f17018a = tArr;
    }

    /* renamed from: a */
    private int m21306a() {
        return this.f17018a.length;
    }

    public final boolean add(T t) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final boolean addAll(Collection<? extends T> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final boolean contains(Object obj) {
        return C6443ev.m21309a(this.f17018a, obj);
    }

    public final boolean containsAll(Collection<? extends Object> collection) {
        if (collection.isEmpty()) {
            return true;
        }
        Iterator<T> it = collection.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    public final boolean isEmpty() {
        return this.f17018a.length == 0;
    }

    public final Iterator<T> iterator() {
        return C6506hd.m21398a(this.f17018a);
    }

    public final boolean remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final boolean removeAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final boolean retainAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final int size() {
        return m21306a();
    }

    public final Object[] toArray() {
        return C6446ey.m21316a(this.f17018a, this.f17019b);
    }

    public final <T> T[] toArray(T[] tArr) {
        return C6510hh.m21409a(this, tArr);
    }
}
