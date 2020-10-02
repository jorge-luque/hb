package androidx.core.p019e;

/* renamed from: androidx.core.e.h */
/* compiled from: Preconditions */
public final class C0795h {
    /* renamed from: a */
    public static <T> T m2503a(T t) {
        if (t != null) {
            return t;
        }
        throw null;
    }

    /* renamed from: a */
    public static <T> T m2504a(T t, Object obj) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(String.valueOf(obj));
    }

    /* renamed from: a */
    public static int m2502a(int i) {
        if (i >= 0) {
            return i;
        }
        throw new IllegalArgumentException();
    }
}
