package com.tapjoy.internal;

import java.util.Collections;
import java.util.List;

/* renamed from: com.tapjoy.internal.eo */
public final class C5026eo {
    /* renamed from: a */
    public static List m16985a() {
        return new C5027ep(Collections.emptyList());
    }

    /* renamed from: a */
    public static List m16986a(String str, List list) {
        if (list != null) {
            if (list instanceof C5027ep) {
                list = ((C5027ep) list).f13613a;
            }
            if (list == Collections.emptyList() || (list instanceof C5025en)) {
                return list;
            }
            C5025en enVar = new C5025en(list);
            if (!enVar.contains((Object) null)) {
                return enVar;
            }
            throw new IllegalArgumentException(str + ".contains(null)");
        }
        throw new NullPointerException(str + " == null");
    }

    /* renamed from: a */
    public static boolean m16987a(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    /* renamed from: a */
    public static IllegalStateException m16984a(Object... objArr) {
        StringBuilder sb = new StringBuilder();
        int length = objArr.length;
        String str = "";
        for (int i = 0; i < length; i += 2) {
            if (objArr[i] == null) {
                if (sb.length() > 0) {
                    str = "s";
                }
                sb.append("\n  ");
                sb.append(objArr[i + 1]);
            }
        }
        throw new IllegalStateException("Required field" + str + " not set:" + sb);
    }
}
