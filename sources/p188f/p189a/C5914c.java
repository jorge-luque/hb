package p188f.p189a;

/* renamed from: f.a.c */
/* compiled from: InstanceFactory */
public final class C5914c<T> implements C5913b<T> {

    /* renamed from: a */
    private final T f15137a;

    static {
        new C5914c((Object) null);
    }

    private C5914c(T t) {
        this.f15137a = t;
    }

    /* renamed from: a */
    public static <T> C5913b<T> m18979a(T t) {
        C5915d.m18981a(t, "instance cannot be null");
        return new C5914c(t);
    }

    public T get() {
        return this.f15137a;
    }
}
