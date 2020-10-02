package p118io.presage;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

/* renamed from: io.presage.bb */
public final class C6238bb {

    /* renamed from: a */
    public static final C6238bb f16782a = new C6238bb();

    /* renamed from: b */
    private static final Map<String, C6482gg<C6237ba, C6437ep>> f16783b = Collections.synchronizedMap(new LinkedHashMap());

    private C6238bb() {
    }

    /* renamed from: a */
    public static void m20880a(String str, C6482gg<? super C6237ba, C6437ep> ggVar) {
        Map<String, C6482gg<C6237ba, C6437ep>> map = f16783b;
        C6514hl.m21414a((Object) map, "listeners");
        map.put(str, ggVar);
    }

    /* renamed from: a */
    public static void m20878a(C6237ba baVar) {
        C6482gg ggVar = f16783b.get(baVar.mo34774a());
        if (ggVar != null) {
            ggVar.mo34409a(baVar);
        }
    }

    /* renamed from: a */
    public static void m20879a(String str) {
        f16783b.remove(str);
    }
}
