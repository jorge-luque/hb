package p118io.presage;

import java.util.List;

/* renamed from: io.presage.hq */
public class C6519hq {
    /* renamed from: a */
    private static <T extends Throwable> T m21427a(T t) {
        return C6514hl.m21412a(t, C6519hq.class.getName());
    }

    /* renamed from: b */
    public static List m21430b(Object obj) {
        if ((obj instanceof C6520hr) && !(obj instanceof C6523hu)) {
            m21428a(obj, "kotlin.collections.MutableList");
        }
        return m21432d(obj);
    }

    /* renamed from: c */
    private static Iterable m21431c(Object obj) {
        try {
            return (Iterable) obj;
        } catch (ClassCastException e) {
            throw m21425a(e);
        }
    }

    /* renamed from: d */
    private static List m21432d(Object obj) {
        try {
            return (List) obj;
        } catch (ClassCastException e) {
            throw m21425a(e);
        }
    }

    /* renamed from: a */
    private static void m21428a(Object obj, String str) {
        String name = obj == null ? "null" : obj.getClass().getName();
        m21429a(name + " cannot be cast to " + str);
    }

    /* renamed from: a */
    private static void m21429a(String str) {
        throw m21425a(new ClassCastException(str));
    }

    /* renamed from: a */
    private static ClassCastException m21425a(ClassCastException classCastException) {
        throw ((ClassCastException) m21427a(classCastException));
    }

    /* renamed from: a */
    public static Iterable m21426a(Object obj) {
        if ((obj instanceof C6520hr) && !(obj instanceof C6522ht)) {
            m21428a(obj, "kotlin.collections.MutableIterable");
        }
        return m21431c(obj);
    }
}
