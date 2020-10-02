package p118io.presage;

import java.util.Collection;
import java.util.List;

/* renamed from: io.presage.ez */
class C6447ez extends C6446ey {
    /* renamed from: a */
    public static final <T> Collection<T> m21318a(T[] tArr) {
        return new C6438eq(tArr);
    }

    /* renamed from: b */
    public static final <T> List<T> m21320b(T... tArr) {
        return tArr.length > 0 ? C6442eu.m21307a(tArr) : m21319a();
    }

    /* renamed from: a */
    public static final <T> List<T> m21319a() {
        return C6458fj.f17026a;
    }

    /* renamed from: b */
    public static final void m21321b() {
        throw new ArithmeticException("Index overflow has happened.");
    }

    /* renamed from: a */
    public static final <T> int m21317a(List<? extends T> list) {
        return list.size() - 1;
    }
}
