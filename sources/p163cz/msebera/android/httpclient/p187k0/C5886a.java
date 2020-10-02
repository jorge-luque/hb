package p163cz.msebera.android.httpclient.p187k0;

import java.util.Collection;

/* renamed from: cz.msebera.android.httpclient.k0.a */
/* compiled from: Args */
public class C5886a {
    /* renamed from: a */
    public static void m18896a(boolean z, String str) {
        if (!z) {
            throw new IllegalArgumentException(str);
        }
    }

    /* renamed from: b */
    public static <T extends CharSequence> T m18899b(T t, String str) {
        if (t == null) {
            throw new IllegalArgumentException(str + " may not be null");
        } else if (!C5894i.m18943b(t)) {
            return t;
        } else {
            throw new IllegalArgumentException(str + " may not be blank");
        }
    }

    /* renamed from: c */
    public static <T extends CharSequence> T m18900c(T t, String str) {
        if (t == null) {
            throw new IllegalArgumentException(str + " may not be null");
        } else if (!C5894i.m18944c(t)) {
            return t;
        } else {
            throw new IllegalArgumentException(str + " may not be empty");
        }
    }

    /* renamed from: a */
    public static void m18897a(boolean z, String str, Object... objArr) {
        if (!z) {
            throw new IllegalArgumentException(String.format(str, objArr));
        }
    }

    /* renamed from: a */
    public static <T> T m18894a(T t, String str) {
        if (t != null) {
            return t;
        }
        throw new IllegalArgumentException(str + " may not be null");
    }

    /* renamed from: a */
    public static <T extends CharSequence> T m18893a(T t, String str) {
        if (t == null) {
            throw new IllegalArgumentException(str + " may not be null");
        } else if (!C5894i.m18942a(t)) {
            return t;
        } else {
            throw new IllegalArgumentException(str + " may not contain blanks");
        }
    }

    /* renamed from: b */
    public static int m18898b(int i, String str) {
        if (i > 0) {
            return i;
        }
        throw new IllegalArgumentException(str + " may not be negative or zero");
    }

    /* renamed from: a */
    public static <E, T extends Collection<E>> T m18895a(T t, String str) {
        if (t == null) {
            throw new IllegalArgumentException(str + " may not be null");
        } else if (!t.isEmpty()) {
            return t;
        } else {
            throw new IllegalArgumentException(str + " may not be empty");
        }
    }

    /* renamed from: a */
    public static int m18891a(int i, String str) {
        if (i >= 0) {
            return i;
        }
        throw new IllegalArgumentException(str + " may not be negative");
    }

    /* renamed from: a */
    public static long m18892a(long j, String str) {
        if (j >= 0) {
            return j;
        }
        throw new IllegalArgumentException(str + " may not be negative");
    }
}
