package com.moat.analytics.mobile.vng.p156a.p158b;

import java.util.NoSuchElementException;

/* renamed from: com.moat.analytics.mobile.vng.a.b.a */
public final class C4374a<T> {

    /* renamed from: a */
    private static final C4374a<?> f11717a = new C4374a<>();

    /* renamed from: b */
    private final T f11718b;

    private C4374a() {
        this.f11718b = null;
    }

    private C4374a(T t) {
        if (t != null) {
            this.f11718b = t;
            return;
        }
        throw new NullPointerException("Optional of null value.");
    }

    /* renamed from: a */
    public static <T> C4374a<T> m14624a() {
        return f11717a;
    }

    /* renamed from: a */
    public static <T> C4374a<T> m14625a(T t) {
        return new C4374a<>(t);
    }

    /* renamed from: b */
    public static <T> C4374a<T> m14626b(T t) {
        return t == null ? m14624a() : m14625a(t);
    }

    /* renamed from: b */
    public T mo29251b() {
        T t = this.f11718b;
        if (t != null) {
            return t;
        }
        throw new NoSuchElementException("No value present");
    }

    /* renamed from: c */
    public T mo29252c(T t) {
        T t2 = this.f11718b;
        return t2 != null ? t2 : t;
    }

    /* renamed from: c */
    public boolean mo29253c() {
        return this.f11718b != null;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C4374a)) {
            return false;
        }
        T t = this.f11718b;
        T t2 = ((C4374a) obj).f11718b;
        if (t != t2) {
            return (t == null || t2 == null || !t.equals(t2)) ? false : true;
        }
        return true;
    }

    public int hashCode() {
        T t = this.f11718b;
        if (t == null) {
            return 0;
        }
        return t.hashCode();
    }

    public String toString() {
        T t = this.f11718b;
        if (t == null) {
            return "Optional.empty";
        }
        return String.format("Optional[%s]", new Object[]{t});
    }
}
