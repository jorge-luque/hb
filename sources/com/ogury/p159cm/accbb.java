package com.ogury.p159cm;

import java.util.Arrays;
import java.util.List;

/* renamed from: com.ogury.cm.accbb */
public class accbb {
    private accbb() {
    }

    /* renamed from: a */
    private static <T extends Throwable> T m15212a(T t) {
        return m15213a(t, accbb.class.getName());
    }

    /* renamed from: a */
    static <T extends Throwable> T m15213a(T t, String str) {
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

    /* renamed from: a */
    public static void m15214a() {
        throw ((acacb) m15212a(new acacb()));
    }

    /* renamed from: a */
    public static void m15215a(Object obj, String str) {
        if (obj == null) {
            throw ((IllegalStateException) m15212a(new IllegalStateException(str + " must not be null")));
        }
    }

    /* renamed from: a */
    public static void m15216a(String str) {
        throw ((acbac) m15212a(new acbac("lateinit property " + str + " has not been initialized")));
    }

    /* renamed from: a */
    public static boolean m15217a(Object obj, Object obj2) {
        return obj == null ? obj2 == null : obj.equals(obj2);
    }

    /* renamed from: b */
    public static void m15218b(Object obj, String str) {
        if (obj == null) {
            StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[3];
            String className = stackTraceElement.getClassName();
            String methodName = stackTraceElement.getMethodName();
            throw ((IllegalArgumentException) m15212a(new IllegalArgumentException("Parameter specified as non-null is null: method " + className + "." + methodName + ", parameter " + str)));
        }
    }
}
