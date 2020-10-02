package p118io.presage;

import java.util.Collections;
import java.util.Map;

/* renamed from: io.presage.fp */
class C6464fp extends C6463fo {
    /* renamed from: a */
    public static final int m21347a(int i) {
        if (i < 0) {
            return i;
        }
        if (i < 3) {
            return i + 1;
        }
        if (i < 1073741824) {
            return (int) ((((float) i) / 0.75f) + 1.0f);
        }
        return Integer.MAX_VALUE;
    }

    /* renamed from: a */
    public static final <K, V> Map<K, V> m21348a(C6431ej<? extends K, ? extends V> ejVar) {
        Map<K, V> singletonMap = Collections.singletonMap(ejVar.mo35393a(), ejVar.mo35394b());
        C6514hl.m21414a((Object) singletonMap, "java.util.Collections.si…(pair.first, pair.second)");
        return singletonMap;
    }
}
