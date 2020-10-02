package com.tapjoy.internal;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

@C3135ft
public final class PluginSupport {
    private PluginSupport() {
    }

    @C3135ft
    public static void trackUsage(String str, String str2, String str3) {
        TreeMap treeMap;
        C3126bn b;
        C3126bn b2;
        try {
            HashMap hashMap = null;
            if (!C4889al.m16672a(str2)) {
                treeMap = new TreeMap();
                b2 = C3126bn.m10231b(str2);
                b2.mo18479a((Map) treeMap);
                b2.close();
            } else {
                treeMap = null;
            }
            if (!C4889al.m16672a(str3)) {
                hashMap = new HashMap();
                b = C3126bn.m10231b(str3);
                b.mo18492h();
                while (b.mo18494j()) {
                    hashMap.put(b.mo18496l(), Long.valueOf(b.mo18501q()));
                }
                b.mo18493i();
                b.close();
            }
            C3137gf.m10284a(str, treeMap, (Map) hashMap);
        } catch (Exception unused) {
        } catch (Throwable th) {
            b2.close();
            throw th;
        }
    }
}
