package p118io.presage;

import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

/* renamed from: io.presage.fe */
class C6453fe extends C6452fd {
    /* renamed from: a */
    private static final <T> boolean m21334a(Iterable<? extends T> iterable, C6482gg<? super T, Boolean> ggVar) {
        Iterator<? extends T> it = iterable.iterator();
        boolean z = false;
        while (it.hasNext()) {
            if (ggVar.mo34409a(it.next()).booleanValue()) {
                it.remove();
                z = true;
            }
        }
        return z;
    }

    /* renamed from: b */
    private static final <T> boolean m21336b(List<T> list, C6482gg<? super T, Boolean> ggVar) {
        int i;
        if (list instanceof RandomAccess) {
            int a = C6447ez.m21317a(list);
            if (a >= 0) {
                int i2 = 0;
                i = 0;
                while (true) {
                    T t = list.get(i2);
                    if (!ggVar.mo34409a(t).booleanValue()) {
                        if (i != i2) {
                            list.set(i, t);
                        }
                        i++;
                    }
                    if (i2 == a) {
                        break;
                    }
                    i2++;
                }
            } else {
                i = 0;
            }
            if (i >= list.size()) {
                return false;
            }
            int a2 = C6447ez.m21317a(list);
            if (a2 >= i) {
                while (true) {
                    list.remove(a2);
                    if (a2 == i) {
                        break;
                    }
                    a2--;
                }
            }
            return true;
        } else if (list != null) {
            return m21334a(C6519hq.m21426a((Object) list), ggVar);
        } else {
            throw new C6434em("null cannot be cast to non-null type kotlin.collections.MutableIterable<T>");
        }
    }

    /* renamed from: a */
    public static final <T> boolean m21335a(List<T> list, C6482gg<? super T, Boolean> ggVar) {
        return m21336b(list, ggVar);
    }
}
