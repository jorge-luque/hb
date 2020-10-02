package kotlin.p212b.p213a;

import java.util.Arrays;

/* renamed from: kotlin.b.a.b */
/* compiled from: Intrinsics */
public class C6607b {
    private C6607b() {
    }

    /* renamed from: a */
    public static void m21701a(Object obj, String str) {
        if (obj == null) {
            m21702a(str);
            throw null;
        }
    }

    /* renamed from: a */
    private static void m21702a(String str) {
        StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[3];
        String className = stackTraceElement.getClassName();
        String methodName = stackTraceElement.getMethodName();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Parameter specified as non-null is null: method " + className + "." + methodName + ", parameter " + str);
        m21699a(illegalArgumentException);
        throw illegalArgumentException;
    }

    /* renamed from: a */
    private static <T extends Throwable> T m21699a(T t) {
        m21700a(t, C6607b.class.getName());
        return t;
    }

    /* renamed from: a */
    static <T extends Throwable> T m21700a(T t, String str) {
        StackTraceElement[] stackTrace = t.getStackTrace();
        int length = stackTrace.length;
        int i = -1;
        for (int i2 = 0; i2 < length; i2++) {
            if (str.equals(stackTrace[i2].getClassName())) {
                i = i2;
            }
        }
        t.setStackTrace((StackTraceElement[]) Arrays.copyOfRange(stackTrace, i + 1, length));
        return t;
    }
}
