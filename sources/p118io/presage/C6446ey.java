package p118io.presage;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* renamed from: io.presage.ey */
class C6446ey {
    /* renamed from: a */
    public static final <T> List<T> m21315a(T t) {
        List<T> singletonList = Collections.singletonList(t);
        C6514hl.m21414a((Object) singletonList, "java.util.Collections.singletonList(element)");
        return singletonList;
    }

    /* renamed from: a */
    public static final <T> Object[] m21316a(T[] tArr, boolean z) {
        Class<Object[]> cls = Object[].class;
        if (z && C6514hl.m21416a((Object) tArr.getClass(), (Object) cls)) {
            return tArr;
        }
        Object[] copyOf = Arrays.copyOf(tArr, tArr.length, cls);
        C6514hl.m21414a((Object) copyOf, "java.util.Arrays.copyOf(… Array<Any?>::class.java)");
        return copyOf;
    }
}
