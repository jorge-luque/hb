package p118io.presage;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;

/* renamed from: io.presage.Bouyssou */
public final class Bouyssou {

    /* renamed from: a */
    public static final Bouyssou f16387a = new Bouyssou();

    /* renamed from: b */
    private static final Map<String, BoulettedAvesnes> f16388b;

    static {
        Map<String, BoulettedAvesnes> synchronizedMap = Collections.synchronizedMap(new LinkedHashMap());
        C6514hl.m21414a((Object) synchronizedMap, "Collections.synchronizedMap(mutableMapOf())");
        f16388b = synchronizedMap;
    }

    private Bouyssou() {
    }

    /* renamed from: a */
    public static String m20220a(BoulettedAvesnes boulettedAvesnes) {
        String uuid = UUID.randomUUID().toString();
        C6514hl.m21414a((Object) uuid, "UUID.randomUUID().toString()");
        f16388b.put(uuid, boulettedAvesnes);
        return uuid;
    }

    /* renamed from: a */
    public static BoulettedAvesnes m20219a(String str) {
        return f16388b.remove(str);
    }
}
