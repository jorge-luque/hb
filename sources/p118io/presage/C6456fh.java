package p118io.presage;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.NoSuchElementException;

/* renamed from: io.presage.fh */
class C6456fh extends C6455fg {
    /* renamed from: a */
    public static final <T> List<T> m21337a(Collection<? extends T> collection) {
        return new ArrayList(collection);
    }

    /* renamed from: b */
    public static final <T> T m21338b(List<? extends T> list) {
        if (!list.isEmpty()) {
            return list.get(C6447ez.m21317a(list));
        }
        throw new NoSuchElementException("List is empty.");
    }
}
