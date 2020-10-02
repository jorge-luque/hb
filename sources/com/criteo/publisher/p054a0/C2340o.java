package com.criteo.publisher.p054a0;

import java.util.Arrays;

/* renamed from: com.criteo.publisher.a0.o */
public class C2340o {
    /* renamed from: a */
    public static boolean m8994a(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    /* renamed from: b */
    public static <T> T m8995b(T t, T t2) {
        return t == null ? t2 : t;
    }

    /* renamed from: a */
    public static int m8993a(Object... objArr) {
        return Arrays.hashCode(objArr);
    }
}
