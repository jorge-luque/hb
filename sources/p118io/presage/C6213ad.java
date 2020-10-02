package p118io.presage;

import java.util.Map;

/* renamed from: io.presage.ad */
public final class C6213ad {
    /* renamed from: a */
    public static final int m20772a(Map<String, String> map, String str) {
        String str2 = map.get(str);
        if (str2 != null) {
            return Integer.parseInt(str2);
        }
        throw new IllegalStateException(("Key " + str + " not found in map").toString());
    }
}
