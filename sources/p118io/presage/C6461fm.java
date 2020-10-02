package p118io.presage;

import java.util.Iterator;

/* renamed from: io.presage.fm */
public abstract class C6461fm implements C6520hr, Iterator<Integer> {
    /* access modifiers changed from: private */
    /* renamed from: b */
    public Integer next() {
        return Integer.valueOf(mo35491a());
    }

    /* renamed from: a */
    public abstract int mo35491a();

    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
