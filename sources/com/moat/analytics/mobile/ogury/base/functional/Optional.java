package com.moat.analytics.mobile.ogury.base.functional;

import java.util.NoSuchElementException;

public final class Optional<T> {

    /* renamed from: ˏ */
    private static final Optional<?> f11490 = new Optional<>();

    /* renamed from: ˎ */
    private final T f11491;

    private Optional() {
        this.f11491 = null;
    }

    public static <T> Optional<T> empty() {
        return f11490;
    }

    /* renamed from: of */
    public static <T> Optional<T> m14414of(T t) {
        return new Optional<>(t);
    }

    public static <T> Optional<T> ofNullable(T t) {
        return t == null ? empty() : m14414of(t);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Optional)) {
            return false;
        }
        T t = this.f11491;
        T t2 = ((Optional) obj).f11491;
        return t == t2 || !(t == null || t2 == null || !t.equals(t2));
    }

    public final T get() {
        T t = this.f11491;
        if (t != null) {
            return t;
        }
        throw new NoSuchElementException("No value present");
    }

    public final int hashCode() {
        T t = this.f11491;
        if (t == null) {
            return 0;
        }
        return t.hashCode();
    }

    public final boolean isPresent() {
        return this.f11491 != null;
    }

    public final T orElse(T t) {
        T t2 = this.f11491;
        return t2 != null ? t2 : t;
    }

    public final String toString() {
        T t = this.f11491;
        if (t == null) {
            return "Optional.empty";
        }
        return String.format("Optional[%s]", new Object[]{t});
    }

    private Optional(T t) {
        if (t != null) {
            this.f11491 = t;
            return;
        }
        throw new NullPointerException("Optional of null value.");
    }
}
