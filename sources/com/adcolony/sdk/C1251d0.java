package com.adcolony.sdk;

import android.os.Bundle;
import java.util.HashMap;

/* renamed from: com.adcolony.sdk.d0 */
class C1251d0 {

    /* renamed from: a */
    private static int f3475a = 0;

    /* renamed from: b */
    private static HashMap<String, Integer> f3476b = new HashMap<>();

    /* renamed from: c */
    private static HashMap<String, Integer> f3477c = new HashMap<>();

    /* renamed from: d */
    static final int f3478d = 5;

    /* renamed from: e */
    static final int f3479e = 1;

    /* renamed from: f */
    static final int f3480f = 3;

    /* renamed from: g */
    static final int f3481g = 0;

    /* renamed from: h */
    static final int f3482h = 1;

    C1251d0() {
    }

    /* renamed from: a */
    static boolean m5026a(int i, Bundle bundle) {
        int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
        if (i != 0) {
            if (i != 1 || bundle == null) {
                return false;
            }
            String string = bundle.getString("zone_id");
            if (f3476b.get(string) == null) {
                f3476b.put(string, Integer.valueOf(currentTimeMillis));
            }
            if (f3477c.get(string) == null) {
                f3477c.put(string, 0);
            }
            if (currentTimeMillis - f3476b.get(string).intValue() > 1) {
                f3477c.put(string, 1);
                f3476b.put(string, Integer.valueOf(currentTimeMillis));
                return false;
            }
            int intValue = f3477c.get(string).intValue() + 1;
            f3477c.put(string, Integer.valueOf(intValue));
            return intValue > 3;
        } else if (currentTimeMillis - f3475a < 5) {
            return true;
        } else {
            f3475a = currentTimeMillis;
            return false;
        }
    }
}
