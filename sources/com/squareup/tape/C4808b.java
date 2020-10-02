package com.squareup.tape;

import com.squareup.tape.C4809c;
import java.util.LinkedList;
import java.util.Queue;

/* renamed from: com.squareup.tape.b */
/* compiled from: InMemoryObjectQueue */
public class C4808b<T> implements C4809c<T> {

    /* renamed from: a */
    private final Queue<T> f12886a = new LinkedList();

    /* renamed from: b */
    private C4809c.C4810a<T> f12887b;

    public void add(T t) {
        this.f12886a.add(t);
        C4809c.C4810a<T> aVar = this.f12887b;
        if (aVar != null) {
            aVar.mo30531a(this, t);
        }
    }

    public T peek() {
        return this.f12886a.peek();
    }

    public void remove() {
        this.f12886a.remove();
        C4809c.C4810a<T> aVar = this.f12887b;
        if (aVar != null) {
            aVar.mo30530a(this);
        }
    }
}
