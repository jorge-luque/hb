package p118io.presage;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* renamed from: io.presage.fd */
class C6452fd extends C6451fc {
    /* renamed from: a */
    public static final <T> void m21333a(List<T> list, Comparator<? super T> comparator) {
        if (list.size() > 1) {
            Collections.sort(list, comparator);
        }
    }
}
