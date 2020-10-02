package com.ogury.crashreport;

import java.util.Arrays;
import java.util.List;

/* compiled from: Intrinsics */
public class tx7920 {
    private tx7920() {
    }

    /* renamed from: a */
    public static void m15331a(String str) {
        throw ((margr1440) m15328a(new margr1440("lateinit property " + str + " has not been initialized")));
    }

    /* renamed from: b */
    public static void m15333b(Object obj, String str) {
        if (obj == null) {
            StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[3];
            String className = stackTraceElement.getClassName();
            String methodName = stackTraceElement.getMethodName();
            throw ((IllegalArgumentException) m15328a(new IllegalArgumentException("Parameter specified as non-null is null: method " + className + "." + methodName + ", parameter " + str)));
        }
    }

    /* renamed from: a */
    public static void m15330a(Object obj, String str) {
        if (obj == null) {
            throw ((IllegalStateException) m15328a(new IllegalStateException(str + " must not be null")));
        }
    }

    /* renamed from: a */
    public static boolean m15332a(Object obj, Object obj2) {
        if (obj == null) {
            return obj2 == null;
        }
        return obj.equals(obj2);
    }

    /* renamed from: a */
    private static <T extends Throwable> T m15328a(T t) {
        return m15329a(t, tx7920.class.getName());
    }

    /* renamed from: a */
    private static <T extends Throwable> T m15329a(T t, String str) {
        StackTraceElement[] stackTrace = t.getStackTrace();
        int length = stackTrace.length;
        int i = -1;
        for (int i2 = 0; i2 < length; i2++) {
            if (str.equals(stackTrace[i2].getClassName())) {
                i = i2;
            }
        }
        List subList = Arrays.asList(stackTrace).subList(i + 1, length);
        t.setStackTrace((StackTraceElement[]) subList.toArray(new StackTraceElement[subList.size()]));
        return t;
    }
}
