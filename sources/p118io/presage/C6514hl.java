package p118io.presage;

import java.util.Arrays;

/* renamed from: io.presage.hl */
public class C6514hl {
    private C6514hl() {
    }

    /* renamed from: a */
    public static void m21413a() {
        throw ((C6425ed) m21411a(new C6425ed()));
    }

    /* renamed from: b */
    private static void m21417b(String str) {
        throw ((C6436eo) m21411a(new C6436eo(str)));
    }

    /* renamed from: a */
    public static void m21415a(String str) {
        m21417b("lateinit property " + str + " has not been initialized");
    }

    /* renamed from: a */
    public static void m21414a(Object obj, String str) {
        if (obj == null) {
            throw ((IllegalStateException) m21411a(new IllegalStateException(str + " must not be null")));
        }
    }

    /* renamed from: a */
    public static boolean m21416a(Object obj, Object obj2) {
        if (obj == null) {
            return obj2 == null;
        }
        return obj.equals(obj2);
    }

    /* renamed from: a */
    private static <T extends Throwable> T m21411a(T t) {
        return m21412a(t, C6514hl.class.getName());
    }

    /* renamed from: a */
    static <T extends Throwable> T m21412a(T t, String str) {
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
