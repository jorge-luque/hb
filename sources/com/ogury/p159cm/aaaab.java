package com.ogury.p159cm;

import com.ogury.p159cm.ConsentActivity;
import java.util.Iterator;
import org.json.JSONObject;

/* renamed from: com.ogury.cm.aaaab */
public final class aaaab {

    /* renamed from: a */
    public static final aaaab f11932a = new aaaab();

    private aaaab() {
    }

    /* renamed from: a */
    public static int m14894a(String str, int i, JSONObject jSONObject) {
        accbb.m15218b(str, "key");
        accbb.m15218b(str, "key");
        JSONObject optJSONObject = jSONObject != null ? jSONObject.optJSONObject(str) : null;
        if (optJSONObject == null) {
            return 0;
        }
        accbb.m15218b(optJSONObject, "jsonObject");
        Iterator<String> keys = optJSONObject.keys();
        accbb.m15215a((Object) keys, "keysInJson");
        int i2 = 0;
        while (keys.hasNext()) {
            String next = keys.next();
            String optString = optJSONObject.optString(next);
            accbb.m15215a((Object) optString, "jsonObject.optString(key)");
            Object[] array = ConsentActivity.aaaaa.m14881a(ConsentActivity.aaaaa.m14884b(optString)).toArray(new Integer[0]);
            if (array != null) {
                aabac aabac = aabac.f12008a;
                if (aabac.m14996a((Integer[]) array, i)) {
                    accbb.m15215a((Object) next, "key");
                    i2 += (int) Math.pow(2.0d, (double) Integer.parseInt(next));
                }
            } else {
                throw new acbab("null cannot be cast to non-null type kotlin.Array<T>");
            }
        }
        return i2;
    }
}
