package p118io.presage;

import java.util.ListIterator;
import java.util.NoSuchElementException;

/* renamed from: io.presage.fi */
public final class C6457fi implements C6520hr, ListIterator {

    /* renamed from: a */
    public static final C6457fi f17025a = new C6457fi();

    private C6457fi() {
    }

    /* renamed from: a */
    private static Void m21339a() {
        throw new NoSuchElementException();
    }

    /* renamed from: b */
    private static Void m21340b() {
        throw new NoSuchElementException();
    }

    public final /* synthetic */ void add(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final boolean hasNext() {
        return false;
    }

    public final boolean hasPrevious() {
        return false;
    }

    public final /* synthetic */ Object next() {
        return m21339a();
    }

    public final int nextIndex() {
        return 0;
    }

    public final /* synthetic */ Object previous() {
        return m21340b();
    }

    public final int previousIndex() {
        return -1;
    }

    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final /* synthetic */ void set(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
