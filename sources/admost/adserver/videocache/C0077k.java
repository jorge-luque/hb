package admost.adserver.videocache;

/* renamed from: admost.adserver.videocache.k */
/* compiled from: Preconditions */
public final class C0077k {
    /* renamed from: a */
    public static <T> T m231a(T t) {
        if (t != null) {
            return t;
        }
        throw null;
    }

    /* renamed from: a */
    public static void m235a(Object... objArr) {
        int length = objArr.length;
        int i = 0;
        while (i < length) {
            if (objArr[i] != null) {
                i++;
            } else {
                throw null;
            }
        }
    }

    /* renamed from: a */
    public static <T> T m232a(T t, String str) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(str);
    }

    /* renamed from: a */
    static void m233a(boolean z) {
        if (!z) {
            throw new IllegalArgumentException();
        }
    }

    /* renamed from: a */
    static void m234a(boolean z, String str) {
        if (!z) {
            throw new IllegalArgumentException(str);
        }
    }
}
