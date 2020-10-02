package p118io.presage;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* renamed from: io.presage.hc */
final class C6505hc<T> implements C6520hr, Iterator<T> {

    /* renamed from: a */
    private int f17036a;

    /* renamed from: b */
    private final T[] f17037b;

    public C6505hc(T[] tArr) {
        this.f17037b = tArr;
    }

    public final boolean hasNext() {
        return this.f17036a < this.f17037b.length;
    }

    public final T next() {
        try {
            T[] tArr = this.f17037b;
            int i = this.f17036a;
            this.f17036a = i + 1;
            return tArr[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.f17036a--;
            throw new NoSuchElementException(e.getMessage());
        }
    }

    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
