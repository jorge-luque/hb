package p188f.p189a;

/* renamed from: f.a.d */
/* compiled from: Preconditions */
public final class C5915d {
    /* renamed from: a */
    public static <T> T m18980a(T t) {
        if (t != null) {
            return t;
        }
        throw null;
    }

    /* renamed from: a */
    public static <T> T m18981a(T t, String str) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(str);
    }

    /* renamed from: a */
    public static <T> void m18982a(T t, Class<T> cls) {
        if (t == null) {
            throw new IllegalStateException(cls.getCanonicalName() + " must be set");
        }
    }
}
