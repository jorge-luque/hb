package com.tapjoy.internal;

import java.io.Serializable;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import java.util.RandomAccess;

/* renamed from: com.tapjoy.internal.ep */
final class C5027ep extends AbstractList implements Serializable, RandomAccess {

    /* renamed from: a */
    List f13613a;

    /* renamed from: b */
    private final List f13614b;

    C5027ep(List list) {
        this.f13614b = list;
        this.f13613a = list;
    }

    public final void add(int i, Object obj) {
        if (this.f13613a == this.f13614b) {
            this.f13613a = new ArrayList(this.f13614b);
        }
        this.f13613a.add(i, obj);
    }

    public final Object get(int i) {
        return this.f13613a.get(i);
    }

    public final Object remove(int i) {
        if (this.f13613a == this.f13614b) {
            this.f13613a = new ArrayList(this.f13614b);
        }
        return this.f13613a.remove(i);
    }

    public final Object set(int i, Object obj) {
        if (this.f13613a == this.f13614b) {
            this.f13613a = new ArrayList(this.f13614b);
        }
        return this.f13613a.set(i, obj);
    }

    public final int size() {
        return this.f13613a.size();
    }
}
