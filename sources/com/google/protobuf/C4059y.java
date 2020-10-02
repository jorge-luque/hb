package com.google.protobuf;

import java.util.ArrayList;
import java.util.List;

/* renamed from: com.google.protobuf.y */
/* compiled from: ProtobufArrayList */
final class C4059y<E> extends C3984c<E> {

    /* renamed from: c */
    private static final C4059y<Object> f10864c;

    /* renamed from: b */
    private final List<E> f10865b;

    static {
        C4059y<Object> yVar = new C4059y<>();
        f10864c = yVar;
        yVar.mo28079t();
    }

    C4059y() {
        this(new ArrayList(10));
    }

    /* renamed from: b */
    public static <E> C4059y<E> m13531b() {
        return f10864c;
    }

    public void add(int i, E e) {
        mo28069a();
        this.f10865b.add(i, e);
        this.modCount++;
    }

    public E get(int i) {
        return this.f10865b.get(i);
    }

    public E remove(int i) {
        mo28069a();
        E remove = this.f10865b.remove(i);
        this.modCount++;
        return remove;
    }

    public E set(int i, E e) {
        mo28069a();
        E e2 = this.f10865b.set(i, e);
        this.modCount++;
        return e2;
    }

    public int size() {
        return this.f10865b.size();
    }

    private C4059y(List<E> list) {
        this.f10865b = list;
    }

    /* renamed from: c */
    public C4059y<E> m13533c(int i) {
        if (i >= size()) {
            ArrayList arrayList = new ArrayList(i);
            arrayList.addAll(this.f10865b);
            return new C4059y<>(arrayList);
        }
        throw new IllegalArgumentException();
    }
}
