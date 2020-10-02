package p118io.presage;

import java.util.Collection;

/* renamed from: io.presage.fa */
class C6449fa extends C6447ez {
    /* renamed from: a */
    public static final <T> int m21332a(Iterable<? extends T> iterable) {
        if (iterable instanceof Collection) {
            return ((Collection) iterable).size();
        }
        return 10;
    }
}
